package com.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Log;
import com.example.repository.LogRepository;

@Service
public class LogService {
	
	private final LogRepository logRepository;
	
	@Autowired
	public LogService(LogRepository logRepository) {
		this.logRepository = logRepository;
	}
	
	public List<Log> findAll(){
		return this.logRepository.findAll();
	}
	
	public Log createReturnDate(Integer id, Integer UserId, LocalDate localDate, LocalDateTime test) {
		Log log = new Log();
		log.setLibrary_id(id);
		log.setUser_id(UserId);
		log.setRent_date(localDate);
		log.setReturn_due_date(test);
		log.setReturn_date(null);
		System.out.print(log.getUser_id());
		
		return this.logRepository.save(log);
	}
	
	public Log returnBook(Integer library_id, Integer user_id, LocalDate localDate) {
		Optional<Log> optionalLog = this.logRepository.findTop1ByLibraryIdAndUserIdOrderByRentDateDesc(library_id,user_id);
		Log log = optionalLog.get();
		log.setReturn_date(localDate);
		return this.logRepository.save(log);
	}
}
