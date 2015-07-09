package net.xomak.openinitiative.model.message;

/**
 * Created by regis on 06.07.2015.
 */
public class GenericMessage {
    public static enum MessageType {ALERT, INFO, DANGER, SUCCESS};
    private String title;
    private String message;
    private MessageType type;

    public GenericMessage() {
        this.title = "";
        this.message = "";
        this.type = MessageType.INFO;
    }

    public GenericMessage(String title, String message, MessageType type) {
        this.title = title;
        this.message = message;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }


    //TODO: Do it in right way
    public String getCssClass() {
        switch(this.type) {
            case ALERT:
                return "panel-alert";
            case INFO:
                return "panel-info";
            case DANGER:
                return "panel-danger";
            case SUCCESS:
                return "panel-success";
            default:
                return "panel-default";
        }
    }
}
