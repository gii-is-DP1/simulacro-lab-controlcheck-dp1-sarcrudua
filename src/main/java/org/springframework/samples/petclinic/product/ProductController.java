package org.springframework.samples.petclinic.product;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    private static final String VIEWS_PRODUCT_CREATE_UPDATE_FORM = "products/createOrUpdateProductForm";
    private static final String VIEWS_WELCOME = "welcome";


    @ModelAttribute("product_types")
	public List<ProductType> populateProductTypes() {
		return this.productService.getAllProductTypes();
	}

    @GetMapping(path = "create")
    public String initCreationForm(ModelMap modelMap) {
        String view = VIEWS_PRODUCT_CREATE_UPDATE_FORM;
        modelMap.addAttribute("product", new Product());
        return view;
    }


    @PostMapping(path = "create")
    public String processCreationForm(@Valid Product product, BindingResult result, ModelMap modelMap) {
        if (result.hasErrors()){
            modelMap.addAttribute("product", product);
            return VIEWS_PRODUCT_CREATE_UPDATE_FORM;

        }else {
            productService.save(product);
            modelMap.addAttribute("message","Product succesfully created!");
            return VIEWS_WELCOME;
        }
    }

    

}
