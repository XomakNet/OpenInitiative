package net.xomak.openinitiative.initializator;

/**
 * Created by regis on 09.07.2015.
 */

import net.xomak.openinitiative.exception.InternalErrorException;
import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.service.InitiativeService;
import net.xomak.openinitiative.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Component
public class DataInititalizer {
    @Autowired
    UserService userService;

    @Autowired
    InitiativeService initiativeService;

    @PostConstruct
    private void startDataAdd() throws InternalErrorException {
        this.createDefaultRoleAndUser();
        this.createDefaultCategories();
        this.createDefaultStatuses();
        for(int i=0; i < 100; i++) {
            this.createDemoInitiative(i);
        }
    }

    private void createDefaultStatuses() {
        List<Status> statusesToAdd = new LinkedList<Status>();
        initiativeService.createStatus("Открыта", "Инициатива создана и доступна для поддержки", false, true, true, true);
        initiativeService.createStatus("На рассмотрении", "Инициатива набрала достаточно число голосов и находится на рассмотрении", false, false, true, true);
        initiativeService.createStatus("Принята к исполнению", "Инициатива одобрена администрацией и будет воплощена в жизнь", false, false, true, true);
        initiativeService.createStatus("Исполнена", "Инициатива реализована", false, false, true, true);
        initiativeService.createStatus("Отклонена", "Инициатива отклонена администрацией", false, false, true, true);
    }

    private void createDefaultCategories() {
        initiativeService.createCategory("Прочее", "Директория для инициатив, не отнесенных к какой-либо другой категории", true);
    }

    private void createDefaultRoleAndUser() throws InternalErrorException {
        userService.createRole("Пользователь", false, false);
        userService.createUser("admin", "test@example.com", "admin");
    }

    void createDemoInitiative(long id) {
        User user = userService.getUserById(1L);
        ComplexText complexText = new ComplexText("Тестовый текст инициативы "+id);
        List<InitiativeCategory> categories = new ArrayList<InitiativeCategory>();
        Iterator<InitiativeCategory> iterator = initiativeService.getActiveCategories().iterator();
        while(iterator.hasNext()) {
            categories.add(iterator.next());
        }
        initiativeService.createInitiative("Тестовая инициатива "+id, "Тестовое описание инициативы "+id, categories, complexText, user);
    }
}
