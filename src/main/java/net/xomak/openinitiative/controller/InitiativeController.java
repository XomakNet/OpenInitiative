package net.xomak.openinitiative.controller;


import net.xomak.openinitiative.model.ComplexText;
import net.xomak.openinitiative.model.Initiative;
import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.model.StatusHistoryItem;
import net.xomak.openinitiative.model.form.NewInitiativeForm;
import net.xomak.openinitiative.service.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collection;
import java.util.Iterator;

@Controller
@RequestMapping("/initiative")
public class InitiativeController extends BaseController {

    public static final long NEED_VOTES = 1000;

    @Autowired
    InitiativeService service;




    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String categoryCreate(Model model) {

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
    public String categorySave(@Valid @ModelAttribute("initiative")NewInitiativeForm initiative, BindingResult br, Model model) {
        if(br.hasErrors()) {
            return "initiative/form";
        }
        else {
            ComplexText complexText = new ComplexText(initiative.getText());
            long id = service.createInitiative(initiative.getName(), initiative.getDescription(), initiative.getCategories(), complexText, getCurrentUser());
            return "redirect:/initiative/"+id;
        }
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