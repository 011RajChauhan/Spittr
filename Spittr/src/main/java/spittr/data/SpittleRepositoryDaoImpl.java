package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import spittr.Spittle;

public class SpittleRepositoryDaoImpl implements SpittleRepositoryDao {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		
		return createSpittleList(count);
	}
	
	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i=0; i<count; i++) {
			spittles.add(new Spittle("Spittle "+ i, new Date()));
		}
		return spittles;
	}
}