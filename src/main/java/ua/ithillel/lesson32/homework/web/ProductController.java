package ua.ithillel.lesson32.homework.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.ithillel.lesson32.homework.entity.Product;
import ua.ithillel.lesson32.homework.repository.ProductRepository;

import java.util.Optional;

@Controller
@RequestMapping(path = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String findById(Model uiModel, @PathVariable(value = "id") long id) {
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(value -> uiModel.addAttribute("product", value));
        return "product";
    }

    @RequestMapping(path = "/allProducts", method = RequestMethod.GET)
    @ResponseBody
    public String findAll(Model uiModel) {
        uiModel.addAttribute("products", productRepository.findAll());
        return "product";
    }
}
