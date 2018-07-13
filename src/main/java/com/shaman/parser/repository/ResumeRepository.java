package com.shaman.parser.repository;

import com.shaman.parser.entity.ResumeItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Spring Data Repository
 */
public interface ResumeRepository  extends JpaRepository<ResumeItem,Long>{

}
