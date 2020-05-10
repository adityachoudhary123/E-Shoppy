package org.example.DataAccessLayer;
import org.example.Model.Cart;
import org.example.Model.Product;
import org.example.Model.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.security.core.parameters.P;

import java.io.File;
import java.util.List;

public class Repository
{
    Configuration con;
    ServiceRegistry serviceRegistry;

    public Repository()
    {
        con = new Configuration();
        File f = new File("/Users/pratikchowdhury/IdeaProjects/SpringBootSample/src/hibernate.cfg.xml");


        con.configure(f.getAbsoluteFile()).addAnnotatedClass(Users.class).addAnnotatedClass(Product.class).addAnnotatedClass(Cart.class);
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();


    }

    public boolean addUser(Users user)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.saveOrUpdate(user);
            tx.commit();
            session.clear();
            session.close();
            return true;
        }catch (Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            return false;
        }
    }

    public Users getUser(String USER_ID)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try {

            Users user = (Users) session.get(Users.class, USER_ID);
            tx.commit();
            session.clear();
            session.close();
            return user;
        }
        catch (Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            return null;
        }
    }

    public List<Product> getProduct(String PRODUCT_NAME)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try{
            String hq1 = "from Product where PRODUCT_NAME like '%" + PRODUCT_NAME + "%'";
            Query query = session.createQuery(hq1);
            List<Product> productsList = query.list();
            tx.commit();
            session.clear();
            session.close();
            return productsList;
        }
        catch (Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    public Product getProduct(int PRODUCT_ID)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try{
            String hq1 = "from Product where PRODUCT_ID = " + PRODUCT_ID;
            Product product = (Product) session.createQuery(hq1);
            tx.commit();
            session.clear();
            session.close();
            return product;
        }catch(Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    public boolean addCart(int PRODUCT_ID, String USER_ID, int QUANTITY)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Cart cart = new Cart();
        cart.setPRODUCT_ID(PRODUCT_ID);
        cart.setUSER_ID(USER_ID);
        cart.setQUANTITY(QUANTITY);

        Transaction tx = session.beginTransaction();
        try{
            session.saveOrUpdate(cart);
            tx.commit();
            session.clear();
            session.close();
            return  true;
        }
        catch(Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            e.printStackTrace();
            return false;
        }
    }
    public List<Product> getCart(String USER_ID)
    {
        SessionFactory sf = con.buildSessionFactory((serviceRegistry));
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        try{
            String hq1 = "from Product where PRODUCT_ID in (select PRODUCT_ID from Cart where USER_ID = '" + USER_ID+"')";
            Query query = session.createQuery(hq1);
            List<Product> products = query.list();
            tx.commit();
            session.clear();
            session.close();
            return products;
        }catch(Exception e)
        {
            tx.rollback();
            session.clear();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

}
