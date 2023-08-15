package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer>{
	
//	public Log findByLibraryIdAndUserIdOrderByRentDateDesc(Integer libraryId, Integer userId);
	public Optional<Log> findTop1ByLibraryIdAndUserIdOrderByRentDateDesc(Integer libraryId, Integer userId);
	
	public List<Log> findByUserId(Integer userId);
}
