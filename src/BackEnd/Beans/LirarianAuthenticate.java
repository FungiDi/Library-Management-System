package Beans;

import AllInterfaces.Authenticate;
import Dao.LibrarianLoginDao;
import Entities.Librarian;
import Entities.LoginAuditTrail;
import Entities.Staff;
import Event.LoginAuditTrailEvent;
import Qualifiers.LoginQualifier;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@LoginQualifier(LoginQualifier.LoginChoice.librarian)
public class LirarianAuthenticate implements Authenticate<Librarian> {
    @PersistenceContext
    EntityManager em;

    @Inject
    private Event<LoginAuditTrailEvent> event;


    public boolean login(Librarian librarian) {
        LibrarianLoginDao loginDao=new LibrarianLoginDao(em);

        if (loginDao.login(librarian)){
            LoginAuditTrail auditTrail=new LoginAuditTrail();
            LoginAuditTrailEvent auditTrailEvent=new LoginAuditTrailEvent();
            Date date=new Date();
            auditTrail.setUsername(librarian.getEmail());
            auditTrail.setUserType("Librarian");
            auditTrail.setDetail("Login");
            auditTrail.setDate(date);
            auditTrailEvent.setAuditTrail(auditTrail);
            event.fire(auditTrailEvent);
            return true;
        }
        return false;
    }
}
