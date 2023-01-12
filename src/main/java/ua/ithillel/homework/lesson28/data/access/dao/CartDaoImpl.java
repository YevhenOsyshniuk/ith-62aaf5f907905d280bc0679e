package ua.ithillel.homework.lesson28.data.access.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ua.ithillel.homework.lesson28.data.access.mappers.CartMapper;
import ua.ithillel.homework.lesson28.entity.Cart;
import ua.ithillel.homework.lesson28.entity.Product;

import javax.sql.DataSource;
import java.util.Optional;

@Repository
public class CartDaoImpl implements CartDao {
    private final JdbcTemplate jdbcTemplate;

    private final static String FIND_BY_ID = "SELECT * FROM cart WHERE id = ?";
    private final static String ADD_PRODUCT = "INSERT INTO cart_product values (?, ?)";
    private final static String REMOVE_BY_ID = "DELETE FROM cart WHERE id =?";

    public CartDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<Cart> findById(long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new CartMapper(), id));
    }

    @Override
    public void add(Product product) {
        jdbcTemplate.update(ADD_PRODUCT, product.getName(), product.getPrice());
    }

    @Override
    public void removeById(long id) {
        jdbcTemplate.update(REMOVE_BY_ID, id);
    }
}
