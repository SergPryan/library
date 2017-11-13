package dao;


import entity.Book;

import java.util.Collection;

public interface BookRepository extends Dao<Book> {
     void fillOrder(Collection<Book> list, Long idReaders);
}
