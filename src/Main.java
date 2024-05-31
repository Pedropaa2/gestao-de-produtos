import java.util.ArrayList;

import exceptions.NegativePriceException;
import exceptions.NotFoundException;
import product.ProductController;
import product.ProductModel;

public class Main {
    
    public static void main(String[] args) {
        ProductController controller = new ProductController();

         try {
          
            ProductModel product1 = new ProductModel();
            product1.setName("Product 1");
            product1.setPriceInCents(1000); 
            product1.setStock(50);
            controller.create(product1);

           
            ProductModel product2 = new ProductModel();
            product2.setName("Product 2");
            product2.setPriceInCents(1500); 
            product2.setStock(30);
            controller.create(product2);

            ProductModel product3 = new ProductModel();
            product3.setName("Product 3");
            product3.setPriceInCents(2000); 
            product3.setStock(50);
            controller.create(product3);

            
            ArrayList<ProductModel> productList = controller.read();
            System.out.println("Produtos cadastrados:");
            for (ProductModel product : productList) {
                System.out.println("Nome: " + product.getName() + ", Código de Barras: " + product.getBarCode() +
                                   ", Preço: R$" + (product.getPriceInCents() / 100.0) + ", Estoque: " + product.getStock());
            }

          
            String barCodeToRetrieve = "BC-000002";
            Integer price = controller.retrievePrice(barCodeToRetrieve);
            System.out.println("Preço do produto com código de barras '" + barCodeToRetrieve + "': R$" + (price / 100.0));
        
    } catch (NegativePriceException e) {
        System.out.println( e.getMessage());
    } catch (NotFoundException e) {
        System.out.println( e.getMessage());
    }
}
}