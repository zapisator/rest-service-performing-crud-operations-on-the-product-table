package service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import service.domain.Product;

public interface Repository extends JpaRepository<Product, Integer> {

}
