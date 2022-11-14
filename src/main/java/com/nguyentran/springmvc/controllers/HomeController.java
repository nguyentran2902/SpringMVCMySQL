package com.nguyentran.springmvc.controllers;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nguyentran.springmvc.models.Category;
import com.nguyentran.springmvc.models.Product;
import com.nguyentran.springmvc.models.Tag;
import com.nguyentran.springmvc.services.CategoryService;
import com.nguyentran.springmvc.services.ProductService;
import com.nguyentran.springmvc.services.TagService;

@Controller
@RequestMapping({ "/product" })
public class HomeController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private TagService tagService;
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@GetMapping("/list")
	public String goHome(Model model) {
		List<Product> products = productService.getAllProducts();
		model.addAttribute("products", products);
		return "products/home";
	}

	@GetMapping("/new")
	public String goCreateProduct(Model model) {
		List<Category> categories = categoryService.getAllCates();
		List<Tag> tags = tagService.getAllTags();

		Product pNew = new Product();
		Date date = new Date(new java.util.Date().getTime());
		pNew.setCreateDate(date);
		model.addAttribute("product", pNew);
		model.addAttribute("cates", categories);
		model.addAttribute("tagList", tags);
		return "products/handles-form";
	}

	@GetMapping("/update/{id}")
	public String UpdateProduct(@PathVariable int id, Model model) throws ParseException {
		Optional<Product> prod = productService.getProductById(id);
		List<Category> categories = categoryService.getAllCates();
		List<Tag> tags = tagService.getAllTags();

		model.addAttribute("product", prod.get());
		model.addAttribute("cates", categories);
		model.addAttribute("tagList", tags);
		return "products/handles-form";
	}

	@PostMapping("/saveProduct")
	public String SaveProduct( @ModelAttribute("product") @Valid Product product, BindingResult bd) {

		if (bd.hasErrors()) {
			return "products/handles-form";
		}
		System.out.println("Quoc cho");
		Optional<Category> cateOp = categoryService.getCateById(product.getCategory().getId());
		product.setCategory(cateOp.get());

		List<Tag> tags = product.getTags();
		List<Tag> updateTags = new ArrayList();
		for (Tag tag : tags) {
			Optional<Tag> tagUd = tagService.getTagById(Integer.valueOf(tag.getTagName()));
			updateTags.add(tagUd.get());

		}
		product.setTags(updateTags);
		productService.saveProduct(product);

		return "redirect:/product/list";

	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {

		productService.removeProduct(id);
		return "redirect:/product/list";
	}
}
