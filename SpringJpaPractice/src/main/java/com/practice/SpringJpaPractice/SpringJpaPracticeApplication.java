package com.practice.SpringJpaPractice;

import com.practice.SpringJpaPractice.Repository.ProductRepo;
import com.practice.SpringJpaPractice.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringJpaPracticeApplication.class, args);
		Product p1 = context.getBean(Product.class);
		Product p2 = context.getBean(Product.class);
		Product p3 = context.getBean(Product.class);

		ProductRepo repo = context.getBean(ProductRepo.class);
		System.out.println("Server is up");

		p1.setpId(101);
		p1.setpName("iPhone 16 plus");
		p1.setpStatus("Available");
		p1.setpLocation("New Jersey");

		p2.setpId(102);
		p2.setpName("IQOO");
		p2.setpStatus("Available");
		p2.setpLocation("Hyderabad");

		//repo.save(p1);
		//repo.save(p2);
		//p3.setpId(0);
		repo.deleteById(p3.getpId());
		//repo.save(p3);

		//repo.delete(0);
		System.out.println(repo.findAll());


	}

}
