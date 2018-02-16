package AllInterfaces;

import Entities.LoginAuditTrail;

import javax.ejb.Local;

@Local
public interface LoginAuditTrailI {

    public boolean add(LoginAuditTrail auditTrail);
}
