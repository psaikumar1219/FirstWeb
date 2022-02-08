package com.project.firstweb.parameters.repositories;

import com.project.firstweb.parameters.models.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State,Integer> {
}
