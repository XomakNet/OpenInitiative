package net.xomak.openinitiative.converter;

import net.xomak.openinitiative.model.InitiativeCategory;
import net.xomak.openinitiative.service.InitiativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


/**
 * Created by Костя on 02.07.2015.
 */
final class StringToInitiativeCategory implements Converter<String, InitiativeCategory> {
    @Autowired
    InitiativeService service;
    public InitiativeCategory convert(String source) {
        return service.getCategoryById(Long.parseLong(source));
    }
}
