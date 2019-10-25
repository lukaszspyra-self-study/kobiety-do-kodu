package pl.kobietydokodu.learningjavapart1.cats;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CatsController {

	@Autowired
	CatDao catDao;

	@RequestMapping("/add")
	public String addCat(HttpServletRequest request, @ModelAttribute("catDto") @Valid CatDTO catDto,
			BindingResult result) {
		if (request.getMethod().equalsIgnoreCase("post") && !result.hasErrors()) {
			Cat cat = new Cat();
			cat.setCatName(catDto.getCatName());
			cat.setOwnerName(catDto.getOwnerName());
			cat.setWeight(catDto.getWeight());
			cat.setDateOfBirth(catDto.getDateOfBirth());
			catDao.addCatToTheList(cat);
			return "redirect:/list";
		}
		return "add";	//jezce rozpisac schemat dzialania tej metody NA papierze!!!!!
	}

	@RequestMapping("/list")
	public String catsList(Model model) {
		model.addAttribute("Cats", catDao.getCatList());
		return "list";
	}

	@RequestMapping("/cat-{id}")
	public String catsDetails(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("Cat", catDao.getCatById(id));
		return "details";
	}

}
