package repository;

import model.ResumeItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Spring Data Repository
 */
public interface ResumeRepository  extends JpaRepository<ResumeItem,Long>{

}
