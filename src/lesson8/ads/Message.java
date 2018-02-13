package lesson8.ads;

import java.util.Date;

public class Message extends BaseEntity {

    User UserFrom;
    User UserTo;
    Date dateSent;
    Date dateRead;
    String message;

    public Message(long id, User userFrom, User userTo, Date dateSent, Date dateRead, String message) {
        super(id);
        UserFrom = userFrom;
        UserTo = userTo;
        this.dateSent = dateSent;
        this.message = message;
    }

    void setDateRead(){
        Date read = new Date();

    }

    boolean isRead(){
        return dateRead == null;
    }
}
