package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spittr.Spittle;

public class SpittleRepositoryDaoImpl implements SpittleRepositoryDao {

	@Override
	public List<Spittle> findSpittles(int from, int to) {
		
		return createSpittleList(from,to);
	}
	
	private List<Spittle> createSpittleList(int from,int to) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i=from; i<to; i++) {
			spittles.add(new Spittle("Spittle "+ i, new Date()));
		}
		return spittles;
	}

	@Override
	public Spittle findSpittles(int spittleId) {
		System.out.println(spittleId);
		Spittle spittle = new Spittle("Dummy Spittle",new Date(),null,null);
		return null;
	}
}
