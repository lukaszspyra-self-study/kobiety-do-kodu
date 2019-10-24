package pl.kobietydokodu.learningjavapart1.cats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatsController {
	
	@Autowired
	CatDao catDao;

	@RequestMapping("/add")
	public String addCat(Model model) {
		return "add";
	}
	
	@RequestMapping("/list")
	public String catsList(Model model) {
		model.addAttribute("Cats",catDao.getCatList());
		return "list";
	}
	
	@RequestMapping("/cat-{id}")
	public String catsDetails(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("CAT", catDao.getCatById(id));
		return "details";
	}
}
