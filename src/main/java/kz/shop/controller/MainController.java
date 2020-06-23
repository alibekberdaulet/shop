package kz.shop.controller;

import kz.shop.dao.ProductDAO;
import kz.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProductDAO productDAO;

    @GetMapping("/")
    public String index(@RequestParam(required = false, defaultValue = "World") String name,
                        Map<String, Object> model) {
        model.put("name", name);
        return "index";
    }

    @GetMapping("/product/all")
    public String products(@RequestParam(required = false, defaultValue = "") String error, Map<String, Object> model) {
        model.put("error", error);
        model.put("products", productDAO.findAll());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String product(@PathVariable Long id, Map<String, Object> model) {
        Product item = productDAO.findById(id).orElse(null);
        if (item != null) {
            model.put("product", item);
            return "product";
        }
        model.put("error", "Item not found!");
        model.put("products", productDAO.findAll());
        return "products";
    }

    @PostMapping("/product/create")
    public String add(@RequestParam String name,
                      @RequestParam String code,
                      @RequestParam String createDate,
                      @RequestParam String shelfLife,
                      @RequestParam Double price,
                      Map<String, Object> model) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        String error = "";
        try {
            productDAO.save(new Product(name, code, format.parse(createDate), format.parse(shelfLife), price));
        } catch (ParseException e) {
            error = e.getMessage();
        }
        model.put("error", error);
        model.put("products", productDAO.findAll());
        return "products";
    }
}
