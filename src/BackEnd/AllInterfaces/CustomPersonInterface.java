package AllInterfaces;

import javax.ejb.Local;
import java.util.List;
@Local
public interface CustomPersonInterface<T> {

    boolean add (T t);

    boolean remove(T t);

    boolean edit(T t);

    T viewById(T t);

    List<T> viewAll(T t);
}
