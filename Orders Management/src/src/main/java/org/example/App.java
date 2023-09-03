package org.example;

import org.example.BLL.ProductBll;
import org.example.DAO.AbstractDAO;
import org.example.DAO.ClientDAO;
import org.example.DAO.ProductDAO;
import org.example.Model.Client;
import org.example.Model.Product;
import org.example.View.*;

import java.lang.ref.Cleaner;
import java.util.List;

public class App {
    public static void main(String[] args) {
        FirstPageView firstPageView = new FirstPageView();
        ClientsView clientsView = new ClientsView();
        ProductView productView = new ProductView();
        OrderView orderView = new OrderView();
        //ClientDAO clientDAO = new ClientDAO();
        //AbstractDAO<Client> dao = new AbstractDAO<>();
        //Client client = clientDAO.update(1);
        //System.out.println(client.getName());
        //Product client = new Product();
        //client.setId(2);
        //client.setName("John");
        //client.setPrice(20);
        //try{
        //    ProductDAO clientDAO = new ProductDAO();
        //    client = clientDAO.update(client);
        //}catch (IllegalArgumentException | IllegalAccessException e){
        //    e.printStackTrace();
       // }
        //Client client = new Client();
        //client.setId(6);
        //client.setName("dU");
        //client.setAge(35);
        //client.setAddress("ba");
        //client.setEmail("eau");
        //AbstractDAO<Client> dao = new ClientDAO();
        //List<Client> clients = dao.findAll();
        //for(Client client : clients){
        //    System.out.println(client);
        //}
        //dao.insert(client);

        Controller controller = new Controller(firstPageView,clientsView,productView,orderView);

    }
}
