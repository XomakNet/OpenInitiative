package net.xomak.openinitiative.service;

import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.repository.InitiativeCategoryRepository;
import net.xomak.openinitiative.repository.InitiativeRepository;
import net.xomak.openinitiative.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by ����� on 01.07.2015.
 */
@Service
public class InitiativeService {

    private static final long DEFAULT_STATUS_ID = 1;
    private static final int INITIATIVES_PER_PAGE = 10;

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

    public Iterable<Status> getSearchableStatuses() {
        return statuses.findByIsSearchable(true);
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

    private PageRequest generatePageRequest(int pageNumber) {
        return new PageRequest(pageNumber-1, INITIATIVES_PER_PAGE, Sort.Direction.DESC, "id");
    }

    public Page<Initiative> getAllInitiatives(int pageNumber) {
        return initiatives.findAll(generatePageRequest(pageNumber));
    }

    public Page<Initiative> getAllInitiativesOrderByRating(int pageNumber) {
        //TODO: Think about sorting condition
        return initiatives.findAll(new PageRequest(pageNumber-1, INITIATIVES_PER_PAGE, Sort.Direction.DESC, "votesFor"));
    }

    public Status getStatusById(long statusId) {
        return statuses.findById(statusId);
    }

    public Page<Initiative> getInitiativesByStatus(Status status, int pageNumber) {
        return initiatives.findByStatus(status, generatePageRequest(pageNumber));
    }

    public Page<Initiative> getInitiativesByKeyword(String keyword, int pageNumber) {
        return initiatives.findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase("%"+keyword+"%", "%"+keyword+"%", generatePageRequest(pageNumber));
    }

    public Page<Initiative> getInitiativesByCategory(InitiativeCategory category, int pageNumber) {
        List<InitiativeCategory> categories = new ArrayList<InitiativeCategory>();
        categories.add(category);
        return initiatives.findByCategories(categories, generatePageRequest(pageNumber));
    }

    public Status createStatus(final String name, final String description, final boolean isFinal, final boolean isVotingActive, final boolean isCommentable, final boolean isSearchable) {
        Status status = new Status(name, description, isFinal, isVotingActive, isCommentable, isSearchable);
        return statuses.save(status);
    }


    public InitiativeCategory createCategory(String name, String description, boolean isActive) {
        InitiativeCategory category = new InitiativeCategory(name, description, isActive);
        return categories.save(category);
    }


}
