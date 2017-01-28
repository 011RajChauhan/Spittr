package spittr.data;

import spittr.Spitter;
import spittr.data.SpitterRepositoryDao;

public class SpitterRepositoryDaoImpl implements SpitterRepositoryDao {
	private Spitter spitter;
	@Override
	public void save(Spitter spitter) {
		this.spitter = spitter;
	}
	@Override
	public Spitter findByUserName(String userName) {
		if(userName.equalsIgnoreCase(spitter.getUserName())) {
		return spitter;
		}else {
		return null;
		}
	}

}
