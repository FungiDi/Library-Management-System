package Beans;

import AllInterfaces.IssueBookActivityInterface;
import Dao.IssueBookActivityDao;
import Entities.IssueBookActivity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class IssueBookActivityBean implements IssueBookActivityInterface {

    @PersistenceContext
    EntityManager em;
    public boolean add(IssueBookActivity activity) {
        IssueBookActivityDao activityDao=new IssueBookActivityDao(em);
        if (activityDao.add(activity))
            return true;
        return false;
    }
}
