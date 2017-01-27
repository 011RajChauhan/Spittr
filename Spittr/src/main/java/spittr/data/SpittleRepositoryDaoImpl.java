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
}
