/*package com;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.entity.Address;
import com.entity.Communication;
import com.entity.Contact;

@Controller
@PropertySources(value = { @PropertySource("classpath:messages.properties") })
@RequestMapping("/contact")
public class ContactController {

	@Value("${rest.base.uri}")
	private String baseURL;

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/contact")
	public ModelAndView contactList(ModelAndView modelAndView) {
		ResponseEntity<List<Contact>> rateResponse = restTemplate.exchange(baseURL + "/contact", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Contact>>() {
				});

		modelAndView.addObject("contactList", rateResponse.getBody());
		modelAndView.setViewName("ContactList");
		return modelAndView;
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.GET)
	public ModelAndView addContact(ModelAndView modelAndView) {
		modelAndView.addObject("contact", new Contact());
		modelAndView.setViewName("AddContact");
		return modelAndView;
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public ModelAndView addRequest(@Valid Contact contact, BindingResult bindingResult, ModelAndView modelAndView) {
		if (!bindingResult.hasErrors()) {
			ResponseEntity<Contact> result = restTemplate.exchange(baseURL + "/contact", HttpMethod.POST,
					new HttpEntity<>(contact), Contact.class);
			modelAndView.addObject("message",
					result.getBody().getIdentification().getFirstName() + " added successfully");
			modelAndView.addObject("contact", new Contact());
		}
		modelAndView.addObject("contact", new Contact());
		modelAndView.setViewName("AddContact");

		return modelAndView;
	}

	@RequestMapping(value = "/addContactAddress", method = RequestMethod.GET)
	public ModelAndView addAddress(ModelAndView modelAndView, @RequestParam String id) {
		modelAndView.addObject("address", new Address());
		modelAndView.addObject("contactId", id);
		modelAndView.setViewName("AddAddress");
		return modelAndView;
	}

	@RequestMapping(value = "/addContactAddress", method = RequestMethod.POST)
	public ModelAndView addRequest(@Valid Address address, BindingResult bindingResult, ModelAndView modelAndView,
			@RequestParam String contactId) {
		if (!bindingResult.hasErrors()) {
			ResponseEntity<Contact> result = restTemplate.exchange(baseURL + "/contact/" + contactId + "/address",
					HttpMethod.POST, new HttpEntity<>(address), Contact.class);
			modelAndView.addObject("message", "Address added successfully");
			modelAndView.addObject("contact", result.getBody());
			modelAndView.setViewName("ViewContact");
		} else {
			modelAndView.addObject("address", new Address());
			modelAndView.setViewName("AddAddress");
		}
		return modelAndView;
	}

	@RequestMapping("/deleteContactAddress")
	public ModelAndView deleteContactAddress(ModelAndView modelAndView, @RequestParam String id,
			@RequestParam String contactId) {
		ResponseEntity<Contact> contact = restTemplate.exchange(baseURL + "/contact/" + contactId + "/address/" + id,
				HttpMethod.DELETE, null, Contact.class);
		modelAndView.addObject("message", "address has been deleted");
		modelAndView.addObject("contact", contact.getBody());
		modelAndView.setViewName("ViewContact");
		return modelAndView;
	}

	@RequestMapping(value = "/addContactCommunication", method = RequestMethod.GET)
	public ModelAndView addCommunication(ModelAndView modelAndView, @RequestParam String id) {
		modelAndView.addObject("communication", new Communication());
		modelAndView.addObject("contactId", id);
		modelAndView.setViewName("AddCommunication");
		return modelAndView;
	}

	@RequestMapping(value = "/addContactCommunication", method = RequestMethod.POST)
	public ModelAndView addCommunication(@Valid Communication communication, BindingResult bindingResult,
			ModelAndView modelAndView, @RequestParam String contactId) {
		if (!bindingResult.hasErrors()) {
			ResponseEntity<Contact> result = restTemplate.exchange(baseURL + "/contact/" + contactId + "/communication",
					HttpMethod.POST, new HttpEntity<>(communication), Contact.class);
			modelAndView.addObject("message", "Communication added successfully");
			modelAndView.addObject("contact", result.getBody());
			modelAndView.setViewName("ViewContact");
		} else {
			modelAndView.addObject("communication", new Communication());
			modelAndView.setViewName("AddCommunication");
		}
		return modelAndView;
	}

	@RequestMapping("/deleteContactCommunication")
	public ModelAndView deleteContactCommunication(ModelAndView modelAndView, @RequestParam String id,
			@RequestParam String contactId) {
		ResponseEntity<Contact> contact = restTemplate.exchange(
				baseURL + "/contact/" + contactId + "/communication/" + id, HttpMethod.DELETE, null, Contact.class);
		modelAndView.addObject("message", "communication has been deleted");
		modelAndView.addObject("contact", contact.getBody());
		modelAndView.setViewName("ViewContact");
		return modelAndView;
	}

	@RequestMapping(value = "/viewContact")
	public ModelAndView viewRequest(ModelAndView modelAndView, @RequestParam String id) {
		ResponseEntity<Contact> result = restTemplate.exchange(baseURL + "/contact/" + id, HttpMethod.GET, null,
				Contact.class);
		modelAndView.addObject("contact", result.getBody());

		modelAndView.setViewName("ViewContact");
		return modelAndView;
	}

	@RequestMapping("/deleteContact")
	public ModelAndView deleteContact(ModelAndView modelAndView, @RequestParam String id) {
		ResponseEntity<Contact> contact = restTemplate.exchange(baseURL + "/contact/" + id, HttpMethod.DELETE, null,
				Contact.class);

		modelAndView.addObject("message", "'s contact has been deleted");
		modelAndView.addObject("deletedContact", contact.getBody().getIdentification().getFirstName());
		ResponseEntity<List<Contact>> rateResponse = restTemplate.exchange(baseURL + "/contact", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Contact>>() {
				});

		modelAndView.addObject("contactList", rateResponse.getBody());
		modelAndView.setViewName("ContactList");
		return modelAndView;
	}
}
*/