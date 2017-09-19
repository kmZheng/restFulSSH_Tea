package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.dao.pojo.Product;
import com.company.service.iservice.IProductService;

@Controller("productAction")
@Scope("prototype")
@RequestMapping("productmvc")
public class ProductAction {
	@Autowired
	@Qualifier("productService")
	private IProductService productService;

	@RequestMapping("saveinit")
	public String saveinit() {
		return "product_save";
	}

	@RequestMapping(value = "product", method = RequestMethod.POST)
	public String save( Product product) {
		String msg = productService.save(product);
		return "success".equals(msg) ? "redirect:products" : "error";
	}

	// 实现精确查询和数据更新功能
	@RequestMapping(value = "product/{pid}", method = RequestMethod.GET)
	public String findByIdGET(@PathVariable("pid") int id, Map<String, Object> model) {
		Product product = productService.findById(id);
		if (product != null) {
			model.put("productFromServer", product);
			return "product_update";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "product", method = RequestMethod.PUT)
	public String update(@ModelAttribute Product product) {
		String msg = productService.update(product);
		return "success".equals(msg) ? "redirect:products" : "error";
	}

	@RequestMapping(value="product/{pid}",method=RequestMethod.DELETE)
	public String delete(@PathVariable("pid") int pid) {
		Product product = new Product();
		product.setPid(pid);
		String msg = productService.delete(product);
		return "success".equals(msg) ? "redirect:/productmvc/products" : "error";
	}

	@RequestMapping("products")
	public String findAll(Map<String, Object> model) {
		List<Product> products = productService.findAll();
		System.out.println(products);
		model.put("productListFromServer", products);
		return (products != null && products.size() > 0) ? "product_findAll" : "error";
	}

	@RequestMapping(value = "product/{pid}")
	public String findByIdPOST(@PathVariable("pid") int id, Map<String, Object> model) {
		Product product = productService.findById(id);
		if (product != null) {
			List<Product> products = new ArrayList<Product>();
			products.add(product);
			model.put("productListFromServer", products);
			return "product_findAll";
		} else {
			return "error";
		}
	}

	@RequestMapping(value = "products/{pname}", method = RequestMethod.POST)
	public String findByName(@PathVariable("pname") String name, Map<String, Object> model) {
		List<Product> products = productService.findByName(name);
		System.out.println(products);
		model.put("productListFromServer", products);
		return (products != null && products.size() > 0) ? "product_findAll" : "error";
	}

}
