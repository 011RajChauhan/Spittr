package spittr.data;

import java.util.List;

import spittr.Spittle;

public interface SpittleRepositoryDao {
	List<Spittle> findSpittles(int from,int to);

	Spittle findSpittles(int spittleId);
}
