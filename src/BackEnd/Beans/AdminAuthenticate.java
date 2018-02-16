package Beans;

import AllInterfaces.Authenticate;
import Dao.AdminLoginDao;
import Entities.Admin;
import Entities.LoginAuditTrail;
import Entities.Staff;
import Event.LoginAuditTrailEvent;
import Qualifiers.LoginQualifier;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@LoginQualifier(LoginQualifier.LoginChoice.admin)
public class AdminAuthenticate implements Authenticate<Admin>{
    @PersistenceContext
    EntityManager em;

    @Inject
    private Event<LoginAuditTrailEvent> event;


    public boolean login(Admin admin) {

        AdminLoginDao loginDao=new AdminLoginDao(em);

        if(loginDao.login(admin)){
            LoginAuditTrail auditTrail=new LoginAuditTrail();
            LoginAuditTrailEvent auditTrailEvent=new LoginAuditTrailEvent();
            Date date=new Date();
            auditTrail.setUsername(admin.getEmail());
            auditTrail.setUserType("Admin");
            auditTrail.setDetail("Login");
            auditTrail.setDate(date);
            auditTrailEvent.setAuditTrail(auditTrail);
            event.fire(auditTrailEvent);
            return true;
        }
        return false;
    }
}
