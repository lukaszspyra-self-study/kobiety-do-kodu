package pl.kobietydokodu.learningjavapart1.cats;

import java.util.ArrayList;
import java.util.List;

public class CatDao {
	List<Cat> catList = new ArrayList<>();

	protected void addCat(Cat cat) {
		catList.add(cat);
		System.out.println("Cat added to the List.");
	}

}
