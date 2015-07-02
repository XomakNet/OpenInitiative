package net.xomak.openinitiative.model.form;

import net.xomak.openinitiative.model.*;
import org.springframework.context.annotation.Bean;

import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by Костя on 02.07.2015.
 */
public class NewInitiative {
    @Size(min = 200, message = "Содержание инициативы должно содержать не менее 200 символов")
    private String text;

    private Collection<InitiativeCategory> categories;

    @Size(min = 10, max = 100, message = "Название должно содержать от 10 до 100 символов")
    private String name;
    @Size(min = 50, max = 300, message = "Краткое описание должно содержать от 50 до 300 символов")
    private String description;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Collection<InitiativeCategory> getCategories() {
        return categories;
    }

    public void setCategories(Collection<InitiativeCategory> categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NewInitiative{" +
                "text='" + text + '\'' +
                ", categories=" + categories +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
