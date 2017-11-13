package dao;

import java.util.Collection;

public interface Dao<T> {

	T getById(Long id);

	T create(T object);

	void remove(Long id);

	Collection<T> getAll();

	void release();
}
