package Beans;

import AllInterfaces.LoginAuditTrailI;
import Dao.LoginAuditTrailDao;
import Entities.LoginAuditTrail;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Local
@Stateless
public class LoginAuditTrailBean implements LoginAuditTrailI {

    @PersistenceContext
    EntityManager em;
    public boolean add(LoginAuditTrail auditTrail) {
        LoginAuditTrailDao auditTrailDao=new LoginAuditTrailDao(em);
        if (auditTrailDao.addAudit(auditTrail))
            return true;
        return false;
    }
}
