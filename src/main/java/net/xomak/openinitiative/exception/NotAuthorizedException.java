package net.xomak.openinitiative.exception;

/**
 * Created by regis on 09.07.2015.
 */
public class NotAuthorizedException extends UserFriendlyException {
    public NotAuthorizedException(final String message) {
        super(message);
    }
}
