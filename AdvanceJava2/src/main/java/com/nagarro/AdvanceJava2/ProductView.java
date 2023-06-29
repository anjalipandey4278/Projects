package com.nagarro.AdvanceJava2;

import java.util.ArrayList;

import com.nagarro.AdvanceJava2.model.ProductModal;

//class for printing data for output
public class ProductView {
	public void showDetails(ArrayList<ProductModal> productList) {
		
		for (ProductModal details : productList) {
			System.out.println();
			System.out.print( "product name -"+details.getProduct_name());
			System.out.print("product colour -"+ details.getColour());
			System.out.print("product Gender -"+ details.getGender());
			System.out.print("product Price -"+ details.getPrice());
			System.out.print("product Size -"+details.getSize());
			System.out.print("product Rating -"+details.getRating());
		}

		if (productList.isEmpty())
			System.out.print("Products are not available right now");

	}
}
