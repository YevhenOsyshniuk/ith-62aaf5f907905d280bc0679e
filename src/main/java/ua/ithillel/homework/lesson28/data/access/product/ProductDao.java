package ua.ithillel.homework.lesson28.data.access.product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework.lesson28.data.access.service.ProductDaoService;
import ua.ithillel.homework.lesson28.entity.Product;

import javax.sql.DataSource;
import java.util.Optional;


@Repository
public class ProductDao implements ProductDaoService {
    private final JdbcTemplate jdbcTemplate;

    public ProductDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String FIND_ALL_QUERY = "SELECT * FROM product";
    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static final String ADD_PRODUCT = "INSERT INTO product (name, price) values (?, ?)";
    private static final String REMOVE = "DELETE FROM product WHERE id =?";

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new ProductMapper(), id));
    }

    @Override
    public void add(Product product) {
        jdbcTemplate.update(ADD_PRODUCT, product.getName(), product.getPrice());
    }

    @Override
    public void remove(long id) {
        jdbcTemplate.update(REMOVE, id);
    }

    @Override
    public Iterable<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new ProductMapper());
    }
}
