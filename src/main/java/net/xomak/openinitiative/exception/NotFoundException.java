package net.xomak.openinitiative.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Xomak on 11.07.2015.
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends UserFriendlyException {
    public NotFoundException() {
        super("Страница не найдена");
    }

    public NotFoundException(final String message) {
        super(message);
    }
}
