package ru.nokisev.profit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nokisev.profit.dao.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByBrand();
}
