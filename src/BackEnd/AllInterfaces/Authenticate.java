package AllInterfaces;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Local
public interface Authenticate<T> {
    boolean login(T t);
}
