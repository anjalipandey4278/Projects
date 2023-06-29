package com.nagarro.AdvanceJava2;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.AdvanceJava2.model.CSVData;
import com.nagarro.AdvanceJava2.model.ProductModal;

import java.util.ArrayList;

//this is main class for the calculation
@SuppressWarnings("deprecation")
public class SearchController {
	ArrayList<ProductModal> list = new ArrayList<ProductModal>();
	ArrayList<String> arr;
	ProductView view = new ProductView();

	// method for comparing data and then give result
	public void search_Product(ArrayList<String> CSV_data, String colour, String gen, String size)
			throws FileNotFoundException, ParseException {

		SessionFactory sessionFactory = HibernetUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tnx = session.beginTransaction();

		Query q = session.createQuery("from CSVData ");
		List<CSVData> lst = q.list();
//		List<CSVData> res = new ArrayList<CSVData>();

		for (CSVData p : lst) {
			if (p.getColour().equalsIgnoreCase(colour)
					&& (p.getGender().equalsIgnoreCase(gen) || p.getGender().equalsIgnoreCase("FM"))
					&& p.getSize().equalsIgnoreCase(size) && p.getProduct_availability().equalsIgnoreCase("Y")) {

				ProductModal d = new ProductModal(p.getShirt_id(), p.getProduct_name(), p.getColour(), p.getGender(), // p.getProduct_availability(),
						p.getSize(), p.getPrice(), p.getRating(),p.getProduct_availability());

				list.add(d);
			}
		}
		tnx.commit();
	}

	public void updateView(int choice) {
		if (choice == 1) {
			Collections.sort(list, new Comparator<ProductModal>() {
				public int compare(ProductModal o1, ProductModal o2) {
					return (int) (o1.getPrice() - o2.getPrice());
				}
			});
		} else if (choice == 2) {
			Collections.sort(list, new Comparator<ProductModal>() {
				public int compare(ProductModal o1, ProductModal o2) {
					return (int) (o1.getRating() - o2.getRating());
				}
			});
		} else {
			System.out.println("You have entered wrong choice.");

			return;
		}
		view.showDetails(list);
	}

}
