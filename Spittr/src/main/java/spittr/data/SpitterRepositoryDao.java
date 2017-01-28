package spittr.data;

import spittr.Spitter;

public interface SpitterRepositoryDao {
	public void save(Spitter spitter);

	public Spitter findByUserName(String userName);
}
