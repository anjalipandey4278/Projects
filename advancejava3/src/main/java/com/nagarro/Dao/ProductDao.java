package com.nagarro.Dao;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.entities.Admin;
import com.nagarro.entities.ProductDetails;
import com.nagarro.helper.Factoryprovider;

public class ProductDao {

	private SessionFactory factory;
//	private Session session;
//
//	public ProductDao() {
//
//		this.session = Factoryprovider.SESSION;
//	}

	public ProductDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}

//	Session session = this.factory.openSession();

	public boolean saveProduct(ProductDetails pd, Admin admin) {
		Session session = this.factory.openSession();
		System.out.println("prosuctdao" + admin);
		try {
			List<ProductDetails> list = new ArrayList<ProductDetails>();
			list = admin.getProducts();
			list.add(pd);
//			Session session = this.factory.openSession();
			Transaction t = session.beginTransaction();
			admin.setProducts(list);
			session.saveOrUpdate(admin);
			t.commit();
			session.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;

		}

	}

	public boolean updateProduct(String title, String quantity, String size, Part part, int productID, String path) {

		try {
			Session s = Factoryprovider.getFactory().openSession();
			Transaction t = s.beginTransaction();
			ProductDetails p = (ProductDetails) s.get(ProductDetails.class, productID);
			p.setItemTitle(title);
			p.setItemQuantity(quantity);
			p.setSize(size);
			p.setImage(part.getSubmittedFileName());

			FileOutputStream fos = new FileOutputStream(path);
			InputStream is = part.getInputStream();

			// reading data

			byte[] data = new byte[is.available()];

			is.read(data);

			// writing the data

			fos.write(data);

			fos.close();
			t.commit();
			return true;

		} catch (Exception e) {
			System.out.println(e.toString());
			return false;

		}

	}

	public boolean deleteProduct(int productID) {
		try {
			Session s = Factoryprovider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			ProductDetails p = (ProductDetails) s.get(ProductDetails.class, productID);
			s.delete(p);
			tx.commit();
			return true;
		} catch (Exception e) {
			System.out.println(e.toString());
			return false;

		}
	}

}
