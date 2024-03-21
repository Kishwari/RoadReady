package com.hexaware.roadready.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.roadready.entities.Feedback;

public interface FeedBackRepository  extends JpaRepository<Feedback, Integer>{

}
