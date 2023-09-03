package org.example.View;

import org.example.BLL.BillBll;
import org.example.BLL.ClientBLL;
import org.example.BLL.OrderBll;
import org.example.BLL.ProductBll;
import org.example.Model.Bill;
import org.example.Model.Client;
import org.example.Model.Order;
import org.example.Model.Product;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for managing the application's views and handling user actions.
 */
public class Controller {
    private FirstPageView firstPageView;
    private ClientsView clientView;
    private ProductView productView;
    private OrderView orderView;
    private ClientBLL clientBll = new ClientBLL();
    private ProductBll productBll = new ProductBll();
    private OrderBll orderBll = new OrderBll();
    private BillBll billBll = new BillBll();
    private Product product = new Product();
    private Order order = new Order();

    /**
     * Constructs the Controller with the specified views.
     *
     * @param firstPageView The FirstPageView.
     * @param clientView    The ClientsView.
     * @param productView   The ProductView.
     * @param orderView     The OrderView.
     */
    public Controller(FirstPageView firstPageView, ClientsView clientView, ProductView productView, OrderView orderView) {
        this.firstPageView = firstPageView;
        this.clientView = clientView;
        this.productView = productView;
        this.orderView = orderView;

        // Set up listeners for buttons in the FirstPageView
        this.firstPageView.clientButtonListener(new ClientListener());
        this.firstPageView.productButtonListener(new ProductListener());
        this.firstPageView.orderButtonListener(new OrderListener());

        // Set up listeners for buttons in the ClientsView
        this.clientView.addAddButtonListener(new ClientAddListener());
        this.clientView.addDeleteButtonListener(new ClientDeleteListener());
        this.clientView.addEditButtonListener(new ClientUpdateListener());
        this.clientView.addViewAllButtonListener(new ClientViewAllListener());
        this.clientView.addBackButtonListener(new ClientBackListener());

        // Set up listeners for buttons in the ProductView
        this.productView.addAddButtonListener(new ProductAddListener());
        this.productView.addDeleteButtonListener(new ProductDeleteListener());
        this.productView.addEditButtonListener(new ProductUpdateListener());
        this.productView.addViewAllButtonListener(new ProductViewAllListener());
        this.productView.addBackButtonListener(new ProductBackListener());

        // Set up listeners for buttons in the OrderView
        this.orderView.addAddButtonListener(new OrderAddListener());
        this.orderView.addViewAllButtonListener(new OrderViewAllListener());
        this.orderView.addBackButtonListener(new OrderBackListener());
        this.orderView.addBillButtonListener(new OrderBillListener());
    }

    /**
     * ActionListener for the client button in the FirstPageView.
     */
    class ClientListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientView.setVisible(true);
            firstPageView.setVisible(false);
            productView.setVisible(false);
            orderView.setVisible(false);
        }
    }

    /**
     * ActionListener for the product button in the FirstPageView.
     */
    class ProductListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productView.setVisible(true);
            clientView.setVisible(false);
            firstPageView.setVisible(false);
            orderView.setVisible(false);
        }
    }

    /**
     * ActionListener for the order button in the FirstPageView.
     */
    class OrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderView.setVisible(true);
            productView.setVisible(false);
            clientView.setVisible(false);
            firstPageView.setVisible(false);
        }
    }

    /**
     * ActionListener for the back button in the ClientsView.
     */
    class ClientBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstPageView.setVisible(true);
            clientView.setVisible(false);
        }
    }

    /**
     * ActionListener for the add button in the ClientsView.
     */
    class ClientAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = new Client(clientView.getId(), clientView.getName(), clientView.getAge(), clientView.getAddress(), clientView.getEmail());
            clientBll.insertClient(client);
        }
    }

    /**
     * ActionListener for the delete button in the ClientsView.
     */
    class ClientDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            clientBll.deleteClient(clientView.getId());
        }
    }

    /**
     * ActionListener for the edit button in the ClientsView.
     */
    class ClientUpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Client client = new Client(clientView.getId(), clientView.getName(), clientView.getAge(), clientView.getAddress(), clientView.getEmail());
            try {
                clientBll.updateClient(client, clientView.getId());
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener for the view all button in the ClientsView.
     */
    class ClientViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Client> clientsList = new ArrayList<>();
            clientsList.addAll(clientBll.findAllClient());
            JTable table = clientBll.clientTable(clientsList);
            clientView.getScroll().setViewportView(table);
        }
    }

    /**
     * ActionListener for the back button in the ProductView.
     */
    class ProductBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstPageView.setVisible(true);
            productView.setVisible(false);
        }
    }

    /**
     * ActionListener for the add button in the ProductView.
     */
    class ProductAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = new Product(productView.getId(), productView.getName(), productView.getPrice(), productView.getQuantity());
            productBll.insertProduct(product);
        }
    }

    /**
     * ActionListener for the delete button in the ProductView.
     */
    class ProductDeleteListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            productBll.deleteProduct(productView.getId());
        }
    }

    /**
     * ActionListener for the edit button in the ProductView.
     */
    class ProductUpdateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Product product = new Product(productView.getId(), productView.getName(), productView.getPrice(), productView.getQuantity());
            try {
                productBll.updateProduct(product, productView.getId());
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * ActionListener for the view all button in the ProductView.
     */
    class ProductViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Product> productsList = new ArrayList<>();
            productsList.addAll(productBll.findAllProduct());
            JTable table = productBll.productTable((ArrayList<Product>) productsList);
            productView.getScroll().setViewportView(table);
        }
    }

    /**
     * ActionListener for the back button in the OrderView.
     */
    class OrderBackListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            firstPageView.setVisible(true);
            orderView.setVisible(false);
        }
    }

    /**
     * ActionListener for the add button in the OrderView.
     */
    class OrderAddListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int clientId = (int) orderView.getClientComboBox().getSelectedItem();
            int productId = (int) orderView.getProductComboBox().getSelectedItem();
            Order order = new Order(orderView.getId(), clientId, productId, orderView.getQuantity());
            Bill bill = new Bill(orderView.getId(), productBll.findProductById(productId).getPrice(),clientBll.findClientById(clientId).getName(),productBll.findProductById(productId).getName());
            try {
                    orderBll.insertOrder(order);

            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }

                billBll.insertBill(bill);

        }
    }

    /**
     * ActionListener for the view all button in the OrderView.
     */
    class OrderViewAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Order> orderList = new ArrayList<>();
            orderList.addAll(orderBll.findAllOrder());
            JTable table = orderBll.orderTable((ArrayList<Order>) orderList);
            orderView.getScroll().setViewportView(table);
        }
    }
    /**
     * ActionListener for the bill button in the OrderView.
     */
    class OrderBillListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Bill> billList = new ArrayList<>();
            billList.addAll(billBll.findBill());
            JTable table = billBll.tableBill((ArrayList<Bill>) billList);
            orderView.getScroll().setViewportView(table);
        }
    }
}
