package Observers;

import AllInterfaces.LoginAuditTrailI;
import Event.LoginAuditTrailEvent;

import javax.ejb.EJB;
import javax.enterprise.event.Observes;

public class LoginAuditTrailObs {

    @EJB
    LoginAuditTrailI auditTrailI;

    public void observerEvent(@Observes LoginAuditTrailEvent event) {
        auditTrailI.add(event.getAuditTrail());
    }
}
