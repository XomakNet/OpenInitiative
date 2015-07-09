package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.exception.InternalErrorException;
import net.xomak.openinitiative.exception.NotAuthorizedException;
import net.xomak.openinitiative.model.*;
import net.xomak.openinitiative.model.form.NewInitiativeForm;
import net.xomak.openinitiative.service.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;

@Controller
@RequestMapping("/initiatives")
public class InitiativeController extends BaseController {

    public static final long NEED_VOTES = 1000;

    @Autowired
    InitiativeService service;

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String initiativeCreate(Model model) throws NotAuthorizedException {
        userService.assertIsAuthorized("Для создания инициативы вы должны авторизоваться.");
        Iterable<InitiativeCategory> categories = service.getActiveCategories();
//        Map<Long, String> categoriesMap = new HashMap<Long, String>();
//        Iterator<InitiativeCategory> categoryIterator = categories.iterator();
//        while(categoryIterator.hasNext())
//        {
//            InitiativeCategory category =
//            categoriesMap.put()
//        }
        model.addAttribute("initiative", new NewInitiativeForm());
        model.addAttribute("categories", categories);
        return "initiative/form";
    }

    @RequestMapping(value = {"/new"}, method = RequestMethod.POST)
    public String initiativeSave(@Valid @ModelAttribute("initiative")NewInitiativeForm initiative, BindingResult br, Model model)  throws NotAuthorizedException  {
        userService.assertIsAuthorized("Для создания инициативы вы должны авторизоваться.");
        if(br.hasErrors()) {

            Iterable<InitiativeCategory> categories = service.getActiveCategories();
            model.addAttribute("categories", categories);
            return "initiative/form";
        }
        else {
            ComplexText complexText = new ComplexText(initiative.getText());
            long id = service.createInitiative(initiative.getName(), initiative.getDescription(), initiative.getCategories(), complexText, getCurrentUser());
            return "redirect:/initiatives/"+id;
        }
    }

    @RequestMapping(value = {"/"})
    public String browseAllInitiatives(final Model model) {
        return browseAllInitiativesWithPage(1, model);
    }

    @RequestMapping(value = {"/pages/{pageId}"})
    public String browseAllInitiativesWithPage(@PathVariable("pageId") final int pageId, final Model model) {
        model.addAttribute("title", "Все инициативы");
        return listInitiatives(service.getAllInitiatives(pageId), "", model);
    }


    @RequestMapping("/category/{categoryId}")
    public String browseInitiativesByCategory(@PathVariable("categoryId") final long categoryId, final Model model) {
        return browseInitiativesByCategoryWithPage(categoryId, 1, model);
    }

    @RequestMapping("/category/{categoryId}/pages/{pageId}")
    public String browseInitiativesByCategoryWithPage(@PathVariable("categoryId") final long categoryId, @PathVariable("pageId") final int pageId, final Model model) {
        InitiativeCategory category = service.getCategoryById(categoryId);
        model.addAttribute("title", "Иницитиативы в категории "+category.getName());
        return listInitiatives(service.getInitiativesByCategory(category, pageId), "category/" + categoryId + "/", model);
    }

    @RequestMapping("/status/{statusId}")
    public String browseInitiativesByStatus(@PathVariable("statusId") final long statusId, final Model model) {
        return browseInitiativesByStatusWithPage(statusId, 1, model);
    }

    @RequestMapping("/status/{statusId}/pages/{pageId}")
    public String browseInitiativesByStatusWithPage(@PathVariable("statusId") final long statusId, @PathVariable("pageId") final int pageId, final Model model) {
        Status status = service.getStatusById(statusId);
        model.addAttribute("title", "Иницитиативы со статусом "+status.getName());
        return listInitiatives(service.getInitiativesByStatus(status, pageId), "status/" + statusId + "/", model);
    }

    @RequestMapping("/toprated")
    public String browseTopRankedInitiatives(final Model model) {
        return browseTopRankedInitiativesWithPage(1, model);
    }

    @RequestMapping("/toprated/pages/{pageId}")
    public String browseTopRankedInitiativesWithPage(@PathVariable("pageId") final int pageNumber, final Model model) {

        model.addAttribute("title", "Наиболее поддерживаемые инициативы");
        return listInitiatives(service.getAllInitiativesOrderByRating(pageNumber), "toprated/", model);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String browseInitiativesByKeywordPost(@RequestParam("keyword") String keyword, final Model model) throws InternalErrorException {
        try {
            String encodedKeyword = Base64.getUrlEncoder().encodeToString(keyword.getBytes("UTF-8"));
            return "redirect:/initiatives/search/"+encodedKeyword+"/pages/1";
        }
        catch(UnsupportedEncodingException e) {
            throw new InternalErrorException("Ошибка при кодировании ключевого слова");
        }

        //return listInitiatives(service.getInitiativesByKeyword("74", 1), "", model);
    }

    @RequestMapping(value = "/search/{keyword}/pages/{pageNumber}", method = RequestMethod.GET)
    public String browseInitiativesByKeyword(@PathVariable("keyword") String encodedKeyword, @PathVariable("pageNumber") int pageId, final Model model) throws InternalErrorException {
        try {
            String keyword = new String(Base64.getUrlDecoder().decode(encodedKeyword), "UTF-8");
            return listInitiatives(service.getInitiativesByKeyword(keyword, pageId), "search/"+encodedKeyword+"/", model);
        }
        catch(UnsupportedEncodingException e) {
            throw new InternalErrorException("Ошибка при кодировании ключевого слова");
        }

    }



    @Transactional
    public String listInitiatives(final Page<Initiative> initiatives, final String filterUrlPrefix, final Model model) {
        model.addAttribute("filterUrlPrefix", filterUrlPrefix);
        int current = initiatives.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, initiatives.getTotalPages());
        Iterator<Initiative> iterator = initiatives.iterator();
        while(iterator.hasNext()) {
            iterator.next().getStatus();
        }


        Iterable<InitiativeCategory> categories = service.getActiveCategories();
        Iterable<Status> statuses = service.getSearchableStatuses();
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPages", initiatives.getTotalPages());
        if(initiatives.getNumberOfElements() > 0) {
            model.addAttribute("initiatives", initiatives);
        }
        else {
            model.addAttribute("isEmpty", true);
        }
        model.addAttribute("categories", categories);
        model.addAttribute("statuses", statuses);
        return "initiative/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @Transactional
    public String detailedView(@PathVariable("id") final long id, final Model model) {

        Initiative initiative = service.getInitiativeById(id);
        Collection<StatusHistoryItem> statusHistory2 = initiative.getStatusHistory();
        Iterator<StatusHistoryItem> iterator = statusHistory2.iterator();
        String statusHistory = "";
        while(iterator.hasNext()) {
            //statusHistory +=
                    iterator.next().getNewStatus();
        }
        //String statusHistory = String.valueOf(TransactionSynchronizationManager.isActualTransactionActive());
        long totalVotes = initiative.getVotesFor()-initiative.getVotesAgainst();
        long votesPercent = 0;
        if(totalVotes >= 0) {
            votesPercent = totalVotes / NEED_VOTES;
        }
        model.addAttribute("votesLeft", NEED_VOTES-totalVotes);
        model.addAttribute("votesPercent", votesPercent);
        model.addAttribute("statusHistory", statusHistory2);
        model.addAttribute("initiative", initiative);
        return "initiative/detailedView";
    }
}