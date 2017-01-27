package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.data.SpittleRepositoryDao;

@Controller
@RequestMapping("/")
public class SpittleController {
	
	private SpittleRepositoryDao spittleRepositoryDao;
	
	@Autowired
	public SpittleController(SpittleRepositoryDao spittleRepositoryDao) {
		this.spittleRepositoryDao = spittleRepositoryDao;
	}
	
	@RequestMapping(value="/spittles",method = RequestMethod.GET)
	public String spittles(Model model,@RequestParam(value = "from", defaultValue = "1") int from,
			@RequestParam(value = "to", defaultValue = "20") int to) {
		model.addAttribute("spittleList",spittleRepositoryDao.findSpittles(from, to));
		return "spittles";
	}
	@RequestMapping(value="/spittle/{spittleId}",method=RequestMethod.GET)
	public String spittle(Model model,@PathVariable int spittleId){
		model.addAttribute("spittle", spittleRepositoryDao.findSpittles(spittleId));
		return "spittle";
	}
}
