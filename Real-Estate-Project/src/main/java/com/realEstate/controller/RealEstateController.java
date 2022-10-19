package com.realEstate.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.realEstate.entity.Agent;
import com.realEstate.entity.Client;
import com.realEstate.entity.Property;
import com.realEstate.service.RealEstateService;

@Controller
public class RealEstateController {

	@Autowired
	RealEstateService realEstateService;

	@GetMapping("/")
	public String welcome(Model model, HttpSession session) {
		return "index";
	}

	@GetMapping("/signup")
	public ModelAndView signUp(Model model, HttpSession session) {

		return new ModelAndView("signup", "client", new Client());
	}

	@PostMapping("/signup")
	public String handleSignUp(Model model, HttpSession session, @ModelAttribute("client") Client c1) {
		realEstateService.saveClient(c1);
		System.out.println(c1);
		session.setAttribute("setClient", c1);
		model.addAttribute("newClient", c1);
		return "thankyouclient";
	}

	@GetMapping("/clientLogin")
	public ModelAndView clientLogin(Model model, HttpSession session) {
		Client client = (Client) session.getAttribute("setClient");
		if (client != null) {
			session.removeAttribute("setClient");
		}
		return new ModelAndView("clientLogin", "client", new Client());
	}

	@PostMapping("/clientLogin")
	public String handleLogin(Model model, HttpSession session, @ModelAttribute("client") Client c1) {
		if (realEstateService.findClient(c1)) {
			model.addAttribute("setClient",
					realEstateService.getClientByEmailAndPassword(c1.getEmail(), c1.getPassword()));
			session.setAttribute("setClient", c1);
			return "thankyouclient";
		} else {
			model.addAttribute("msg", "Invalid Login, please try again");

			return "clientLogin";
		}
	}

	@GetMapping("/agentLogin")
	public ModelAndView agentLogin(Model model) {

		return new ModelAndView("agentLogin", "agent", realEstateService.defaultAgent());
	}

	@PostMapping("/agentLogin")
	public String handleLogin(Model model, HttpSession session, @ModelAttribute("agent") Agent a1) {
		if (realEstateService.findAgent(a1)) {
			model.addAttribute("setAgent",
					realEstateService.getAgentByEmailAndPassword(a1.getEmail(), a1.getPassword()));
			session.setAttribute("setAgent", a1);
			System.out.println(session.getAttribute("setAgent"));
			return "thankyouagent";
		} else {
			model.addAttribute("msg", "Invalid Login, please try again");

			return "agentLogin";
		}
	}

	@GetMapping("/agentProfile")
	public String agentProfile(Model model, HttpSession session) {
		Agent current = (Agent) session.getAttribute("setAgent");
		System.out.println("Session: " + current);
		model.addAttribute("setAgent",
				realEstateService.getAgentByEmailAndPassword(current.getEmail(), current.getPassword()));
		return "agentProfile";
	}

	@GetMapping("/clientProfile")
	public String clientProfile(Model model, HttpSession session) {
		Client current = (Client) session.getAttribute("setClient");
		System.out.println("Session: " + current);
		model.addAttribute("setClient",
				realEstateService.getClientByEmailAndPassword(current.getEmail(), current.getPassword()));
		return "clientProfile";
	}

	@GetMapping("/addhouse")
	public String addProperty(Model model, HttpSession session) {
		model.addAttribute("property", new Property());
		return "addhouse";
	}

	@PostMapping("/addhouse")
	public ModelAndView handedAddedProperty(Model model, @ModelAttribute("property") Property property,
			HttpSession session) {
		realEstateService.saveProperty(property);
		session.getAttribute("setAgent");
		List<Property> list = realEstateService.getProperties();
		System.out.println(list);
		model.addAttribute("property", list);
		System.out.println("PROPERTY ATTRIBUTE: " + model.addAttribute(list));
		return new ModelAndView("agentProfile");
	}
}
