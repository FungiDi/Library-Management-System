package Event;

import Entities.LoginAuditTrail;

public class LoginAuditTrailEvent {
    LoginAuditTrail auditTrail;

    public LoginAuditTrail getAuditTrail() {
        return auditTrail;
    }

    public void setAuditTrail(LoginAuditTrail auditTrail) {
        this.auditTrail = auditTrail;
    }
}
