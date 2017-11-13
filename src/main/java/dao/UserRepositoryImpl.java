package dao;



import commons.DbUtils;
import entity.User;

import javax.persistence.EntityManager;
import java.util.Collection;

public class UserRepositoryImpl implements UserRepository {
	
	private EntityManager em;
	
	public UserRepositoryImpl() {
		this.em = DbUtils.getEntityManagerFactory().createEntityManager();
	}

	@Override
	public User getById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public User create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
		return user;
	}

	@Override
	public void remove(Long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.remove(user);
		em.getTransaction().commit();
		
	}

	@Override
	public Collection<User> getAll() {
		return em.createQuery("FROM " +User.class.getName()).getResultList();
	}

	@Override
	public void release() {
		this.em.close();
	}

}
