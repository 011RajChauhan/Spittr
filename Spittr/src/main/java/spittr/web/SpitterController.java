package spittr.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spitter;
import spittr.data.SpitterRepositoryDao;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpitterRepositoryDao spitterRepositoryDao;
	public SpitterController(SpitterRepositoryDao spitterRepositoryDao) {
		this.spitterRepositoryDao = spitterRepositoryDao;
	}
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String registerForm(){
		return "registerForm";
	}
	@RequestMapping(value = "/register",method = RequestMethod.POST)
	public String processRegistration(@Valid Spitter spitter,Errors error) {
		if(error.hasErrors()){
			return "registerForm";
		}
		spitterRepositoryDao.save(spitter);
		return "redirect:/spitter/"+spitter.getUserName();
	}
	@RequestMapping(value = "/{userName}",method = RequestMethod.GET) 
	public String showSpitterProfile(@PathVariable String userName, Model model) {
		Spitter spitter = spitterRepositoryDao.findByUserName(userName);
		model.addAttribute("spitter",spitter);
		return "spitterProfile";
	}
}
