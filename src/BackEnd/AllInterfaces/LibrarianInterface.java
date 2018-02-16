package AllInterfaces;

import Entities.Librarian;

import java.util.List;

public interface LibrarianInterface {

    boolean add(Librarian librarian);

    boolean remove(Librarian librarian);

    boolean edit(Librarian librarian);

    Librarian viewByIdObj(Librarian librarian);

    List<Librarian> viewById(Librarian librarian);

    List<Librarian> viewAll(Librarian librarian);
}
