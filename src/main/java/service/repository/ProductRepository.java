package service.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import service.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Query(
            "SELECT\n"
                    + "SUM (amount)\n"
                    + "FROM product\n"
                    + "WHERE name = :name"
    )
    int sumAmountByName(final String name);
}

