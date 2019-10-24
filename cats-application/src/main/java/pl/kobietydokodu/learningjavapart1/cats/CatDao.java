package pl.kobietydokodu.learningjavapart1.cats;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CatDao {
	private List<Cat> catList = new ArrayList<>();

	public List<Cat> getCatList() {
		return catList;
	}

	protected void addCatToTheList(Cat cat) {
		catList.add(cat);
		System.out.println("Cat added to the List.");
	}
	
	public Cat getCatById(Integer id) {
		if (id<catList.size()) {
			return catList.get(id);
		} else {
			return null;
		}
	}
}
