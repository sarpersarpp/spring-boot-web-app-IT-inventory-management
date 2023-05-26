package project.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.validation.Valid;
import project.app.model.Item;
import project.app.service.AppService;
import project.app.validator.FieldMatchValidator;

@Controller
public class AppController {

	@Autowired
	private AppService itemService;
	@Autowired
	private FieldMatchValidator fcv;
	
	@GetMapping({"/main","inventoryscreen-en.html"})
	public ModelAndView newItem() {
		ModelAndView mv = new ModelAndView("inventoryscreen-en");
		mv.addObject("item",new Item());
		return mv;
	}
	@GetMapping({"/main-en","inventoryscreen-en.html"})
	public ModelAndView newItemEn() {
		ModelAndView mv = new ModelAndView("inventoryscreen-en");
		mv.addObject("item",new Item());
		return mv;
	}
	@GetMapping({"/main-tr","inventoryscreen-tr.html"})
	public ModelAndView newItemTr() {
		ModelAndView mv = new ModelAndView("inventoryscreen-tr");
		mv.addObject("item",new Item());
		return mv;
	}
	
	@PostMapping("/send-item-data")
	public ModelAndView getItemList(@Valid @ModelAttribute Item item,BindingResult result) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("item",item);
		if(result.hasErrors())
			mv.setViewName("inventoryscreen-en");
		else {
			mv.setViewName("history");
			itemService.saveItem(item);
			mv.addObject("items",itemService.findItems());
		}
		return mv;
	}
	@GetMapping({"/itemlist","history.html"})
	public ModelAndView list() {
		ModelAndView mv =new ModelAndView("history");
		mv.addObject("items",itemService.findItems());
		return mv;
	}
	//item/delete/79031547
	@GetMapping("/item/delete/{id}")
	public ModelAndView delete(@PathVariable long id) {
		ModelAndView mv =new ModelAndView("history2");
		itemService.deleteItem(id);
		mv.addObject("items",itemService.findItems());
		return mv;
	}
	
}
