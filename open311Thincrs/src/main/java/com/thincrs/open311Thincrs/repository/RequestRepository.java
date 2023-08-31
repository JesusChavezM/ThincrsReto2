package com.thincrs.open311Thincrs.repository;

import com.thincrs.open311Thincrs.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
