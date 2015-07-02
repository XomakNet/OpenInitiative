package net.xomak.openinitiative.service;

import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.repository.InitiativeCategoryRepository;
import net.xomak.openinitiative.repository.InitiativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by ����� on 01.07.2015.
 */
@Service
public class InitiativeService {

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
}
