package Dao;

import Entities.LoginAuditTrail;

import javax.persistence.EntityManager;

public class LoginAuditTrailDao extends CustomDao<LoginAuditTrail>{
    public LoginAuditTrailDao(EntityManager entityManager) {
        super(entityManager);
    }

    public boolean addAudit(LoginAuditTrail auditTrail){
        if (addCustom(auditTrail))
            return true;
        return false;
    }
}
