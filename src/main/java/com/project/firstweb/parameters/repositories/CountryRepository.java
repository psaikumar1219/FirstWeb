package com.project.firstweb.parameters.repositories;

import com.project.firstweb.parameters.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Integer> {
}
