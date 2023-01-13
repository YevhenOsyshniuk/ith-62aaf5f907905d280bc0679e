package ua.ithillel.homework.lesson28.data.access.mappers;

import lombok.SneakyThrows;
import org.springframework.jdbc.core.RowMapper;
import ua.ithillel.homework.lesson28.entity.Product;

import java.sql.ResultSet;

public class ProductMapper implements RowMapper<Product> {
    @Override
    @SneakyThrows
    public Product mapRow(ResultSet rs, int rowNum) {
        var product = new Product();
        product.setId(rs.getLong("id"));
        product.setName(rs.getString("name"));
        product.setPrice(rs.getFloat("price"));
        return product;
    }
}
