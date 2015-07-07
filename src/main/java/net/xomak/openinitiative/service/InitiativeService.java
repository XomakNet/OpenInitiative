package net.xomak.openinitiative.service;

import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.repository.InitiativeCategoryRepository;
import net.xomak.openinitiative.repository.InitiativeRepository;
import net.xomak.openinitiative.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by ����� on 01.07.2015.
 */
@Service
public class InitiativeService {

    private static final long DEFAULT_STATUS_ID = 1;

    @Autowired
    StatusRepository statuses;

    @Autowired
    InitiativeRepository initiatives;

    @Autowired
    InitiativeCategoryRepository categories;

    public Iterable<InitiativeCategory> getAllCategories() {
        return categories.findAll();
    }

    public Iterable<InitiativeCategory> getActiveCategories() {
        return categories.findByIsActive(true);
    }

    public InitiativeCategory getCategoryById(long id) {
        return categories.findOne(id);
    }

    public InitiativeCategory saveCategory(InitiativeCategory category) {
        return categories.save(category);
    }

    public void deleteCategory(InitiativeCategory category) {
        categories.delete(category);
    }

    public void deleteCategoryById(long categoryId) {
        categories.delete(categoryId);
    }

    public long countInitiativesByCategory(InitiativeCategory category)
    {
        return initiatives.countByCategories(category);
    }

    public Initiative getInitiativeById(long id) {
        return initiatives.findOne(id);
    }

    @Transactional
    public long createInitiative(String name, String description, Collection<InitiativeCategory> categories, ComplexText complexText, User owner) {
        Status defaultStatus = statuses.findById(DEFAULT_STATUS_ID);
        StatusHistoryItem statusHistoryEntry = new StatusHistoryItem(defaultStatus, new Date(), null);
        LinkedList<StatusHistoryItem> statusHistory = new LinkedList<StatusHistoryItem>();
        statusHistory.push(statusHistoryEntry);
        Initiative newInitiative = new Initiative(name, description, complexText, defaultStatus, categories, owner, 0, 0, statusHistory);
        newInitiative = initiatives.save(newInitiative);
        return newInitiative.getId();
    }

    @PostConstruct
    private void createDefaultStatus() {
        Status status = new Status("Открыта", "Инициатива открыта");
        statuses.save(status);
    }
}
