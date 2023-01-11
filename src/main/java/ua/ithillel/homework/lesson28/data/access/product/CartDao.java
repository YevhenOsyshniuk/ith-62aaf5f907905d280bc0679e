package ua.ithillel.homework.lesson28.data.access.product;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework.lesson28.data.access.service.DaoService;
import ua.ithillel.homework.lesson28.entity.Product;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class CartDao implements DaoService {
    private final JdbcTemplate jdbcTemplate;

    private final static String FIND_BY_ID = "SELECT * FROM cart WHERE id = ?";
    private final static String ADD_PRODUCT = "INSERT INTO product (name, price) values (?, ?)";
    private final static String REMOVE = "DELETE FROM cart WHERE id =?";

    public CartDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
}
