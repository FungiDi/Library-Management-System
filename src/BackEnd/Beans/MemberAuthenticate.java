package Beans;

import AllInterfaces.Authenticate;
import Dao.MemberLoginDao;
import Entities.LoginAuditTrail;
import Entities.Member;
import Event.LoginAuditTrailEvent;
import Qualifiers.LoginQualifier;

import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@LoginQualifier(LoginQualifier.LoginChoice.member)
public class MemberAuthenticate implements Authenticate<Member>{

    @PersistenceContext
    EntityManager em;

    @Inject
    private Event<LoginAuditTrailEvent> event;


    public boolean login(Member member) {
        MemberLoginDao loginDao=new MemberLoginDao(em);
        LoginAuditTrail auditTrail=new LoginAuditTrail();
        LoginAuditTrailEvent auditTrailEvent=new LoginAuditTrailEvent();
        Date date=new Date();
        auditTrail.setUsername(member.getEmail());
        auditTrail.setUserType("Member");
        auditTrail.setDetail("Login");
        auditTrail.setDate(date);
        auditTrailEvent.setAuditTrail(auditTrail);
        event.fire(auditTrailEvent);
        if (loginDao.login(member))
            return true;
        return false;
    }
}
