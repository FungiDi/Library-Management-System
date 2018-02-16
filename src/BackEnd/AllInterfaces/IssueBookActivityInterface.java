package AllInterfaces;

import Entities.IssueBookActivity;

import javax.ejb.Local;

@Local
public interface IssueBookActivityInterface {
    boolean add(IssueBookActivity activity);


}
