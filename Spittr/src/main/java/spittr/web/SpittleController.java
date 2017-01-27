package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.data.SpittleRepositoryDao;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepositoryDao spittleRepositoryDao;
	
	@Autowired
	public SpittleController(SpittleRepositoryDao spittleRepositoryDao) {
		this.spittleRepositoryDao = spittleRepositoryDao;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String spittles(Model model) {
		model.addAttribute("spittleList",spittleRepositoryDao.findSpittles(Long.MAX_VALUE, 20));
		System.out.println(">>>>"+Long.MAX_VALUE);
		return "spittles";
	}
}
