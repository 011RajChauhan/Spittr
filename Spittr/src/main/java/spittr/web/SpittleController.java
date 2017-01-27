package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String spittles(Model model,@RequestParam(value = "from", defaultValue = "1") int from,
			@RequestParam(value = "to", defaultValue = "20") int to) {
		model.addAttribute("spittleList",spittleRepositoryDao.findSpittles(from, to));
		return "spittles";
	}
}
