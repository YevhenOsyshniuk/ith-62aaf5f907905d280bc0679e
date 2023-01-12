package ua.ithillel.homework.lesson28.data.access.mappers;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.ithillel.homework.lesson28.entity.Cart;

import java.sql.ResultSet;

public class CartMapper implements RowMapper<Cart> {
    @Override
    @SneakyThrows
    public Cart mapRow(ResultSet rs, int rowNum) {
        var cart = new Cart();
        cart.setId(rs.getLong("id"));
        cart.setName(rs.getString("name"));
        return cart;
    }
}
