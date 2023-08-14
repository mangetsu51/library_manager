package com.example.controller;

import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Library;
import com.example.entity.Log;
import com.example.service.LibraryService;
import com.example.service.LogService;
import com.example.service.LoginUser;

@Controller
@RequestMapping("library")
public class LibraryController {
	
	private final LibraryService libraryService;
	private final LogService logService;
	
	@Autowired
	public LibraryController(LibraryService libraryService, LogService logService) {
		this.libraryService = libraryService;
		this.logService = logService;
	}
	
	@GetMapping
	public String index(Model model) {
		List<Library> libraries = this.libraryService.findAll();
		model.addAttribute("libraries",libraries);
		return "library/index";
	}
	
	@GetMapping("/borrow")
	public String borrowingForm(@RequestParam("id") Integer id, Model model) {
		Library library = this.libraryService.findById(id);
		model.addAttribute("library", library);
		return "library/borrowingForm";
	}
	
	@PostMapping("borrow")
	public String borrow(@RequestParam("id") Integer id, @RequestParam("return_due_date") String returnDueDate, @AuthenticationPrincipal LoginUser loginUser) {
		this.libraryService.idUpdata(id, loginUser.getUser().getId());
		LocalDate localDate = LocalDate.now();
		LocalDateTime test = LocalDateTime.parse(returnDueDate+"T00:00:00");
		
		Log log = this.logService.createReturnDate(id, loginUser.getUser().getId(), localDate, test);
		return "redirect:/library";
		
	}
	
	@PostMapping("return")
	public String returnBook(@RequestParam("id") Integer id, @AuthenticationPrincipal LoginUser loginUser) {
		this.libraryService.returnIdUpdata(id);
		
		LocalDate localDate = LocalDate.now();
		
		Log log = this.logService.returnBook(id, loginUser.getUser().getId(), localDate);
		return "redirect:/library";
	}
	
}
