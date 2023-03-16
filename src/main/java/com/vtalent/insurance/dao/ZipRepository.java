package com.vtalent.insurance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtalent.insurance.model.UsaZipInfo;

@Repository
public interface ZipRepository extends JpaRepository<UsaZipInfo, Integer>{
	
	@Query("SELECT u FROM UsaZipInfo u WHERE u.zip = ?1")
	public UsaZipInfo findByZip(String zip);

}
