package com.asp.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.asp.emr.model.Soap;

@Repository
public interface SoapRepository extends JpaRepository<Soap, Integer> {

	@Query(value = "select * from soap where mrNum = ?1", nativeQuery = true)
	List<Soap> findByMrNum(int mrNum);
}
