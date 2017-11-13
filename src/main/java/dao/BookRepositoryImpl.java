package dao;

import commons.DbUtils;
import entity.Book;
import entity.User;

import javax.persistence.EntityManager;
import java.util.Collection;

public class BookRepositoryImpl implements BookRepository{
	
	private EntityManager em;
	
	public BookRepositoryImpl() {
		this.em = DbUtils.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public Book getById(Long id) {
		return em.find(Book.class, id);
	}

	@Override
	public Book create(Book book) {
		em.getTransaction().begin();
		em.persist(book);
		em.getTransaction().commit();
		return book;
	}

	@Override
	public void remove(Long id) {
		em.getTransaction().begin();
		Book book = em.find(Book.class, id);
		em.remove(book);
		em.getTransaction().commit();
		
	}

	@Override
	public Collection<Book> getAll() {
        return em.createQuery("FROM " +Book.class.getName()).getResultList();
	}

	@Override
	public void release() {
		this.em.close();
	}


	@Override
	public void fillOrder(Collection<Book> list, Long idReaders) {
		User user = em.find(User.class, idReaders);
		list.forEach(element -> element.setUser(user));
		em.getTransaction().begin();
		list.forEach(element->em.merge(element));
		em.getTransaction().commit();
		
	}

}
