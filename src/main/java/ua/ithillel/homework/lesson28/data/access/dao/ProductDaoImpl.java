package ua.ithillel.homework.lesson28.data.access.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework.lesson28.data.access.mappers.ProductMapper;
import ua.ithillel.homework.lesson28.entity.Product;

import javax.sql.DataSource;
import java.util.Optional;


@Repository
public class ProductDaoImpl implements ProductDao {
    private final JdbcTemplate jdbcTemplate;

    public ProductDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String FIND_ALL_QUERY = "SELECT * FROM product";
    private static final String FIND_BY_ID = "SELECT * FROM product WHERE id = ?";
    private static final String ADD_PRODUCT = "INSERT INTO product (name, price) values (?, ?)";
    private static final String REMOVE_BY_ID = "DELETE FROM product WHERE id =?";

    @Override
    public Optional<Product> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new ProductMapper(), id));
    }

    @Override
    public void add(Product product) {
        jdbcTemplate.update(ADD_PRODUCT, product.getName(), product.getPrice());
    }

    @Override
    public void removeById(long id) {
        jdbcTemplate.update(REMOVE_BY_ID, id);
    }

    @Override
    public Iterable<Product> findAll() {
        return jdbcTemplate.query(FIND_ALL_QUERY, new ProductMapper());
    }
}
