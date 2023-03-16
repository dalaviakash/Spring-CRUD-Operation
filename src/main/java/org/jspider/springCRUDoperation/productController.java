package org.jspider.springCRUDoperation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller

public class productController {
    List<Product>productData=new ArrayList<>();
    {
     productData.add(new Product(1,"laptop",2667.88));
    }
    @GetMapping("/")
    public String getAllProducts(Model model){
        model.addAttribute("records",productData);
        return "productlist";
    }

    @GetMapping("/addproductform")  //form display
    public  String displayProduct(Model model){
        model.addAttribute("product",new Product());
        return "addproductform";
    }
    @PostMapping("/insertproduct")     //insert
    public String addProductDetails(Product p) {
        productData.add(p);
        return "redirect:/";
    }

    @GetMapping("/updateproductlist/{id}")
    public String showUpdateForm(@PathVariable(value = "id") int id ,Model model){
        Product p=productData.get(id-1);
        model.addAttribute("product",p);
        return "updateproductlist";
    }
@GetMapping("/modifyproduct")
    public String changeProduct(Product p){
        productData.set(p.getProductId()-1,p);
        return "redirect:/";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id ){
        Product p=productData.get(id-1);
        productData.remove(p);
        return "redirect:/";

    }

}
