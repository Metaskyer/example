package kr.ktservice.example.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select ptype from ProductType ptype order by ptype.id")
    @Transactional(readOnly = true)
    List<ProductType> findProductTypes();

    @Query("select ptype from Product ptype order by ptype.id")
    @Transactional(readOnly = true)
    Product findById(Long id);

}
