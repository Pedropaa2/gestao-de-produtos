package product;
import exceptions.NegativePriceException;
import exceptions.NotFoundException;

import java.util.ArrayList;


public class ProductController extends ProductModel  {
  
private ArrayList<ProductModel> products;

public ProductController() {
    
    products = new ArrayList<>();
}

public String create(ProductModel payload) throws NegativePriceException {
   

    if (payload == null) {
            throw new IllegalArgumentException("Payload cannot be null");
        }
    if (payload.getPriceInCents() < 0) {
            throw new NegativePriceException("O preço do produto precisa ser um número positivo.");
        }
    products.add(payload);
    return "Produto '" + payload.getName() + "' adicionado.";

    

}

public ArrayList<ProductModel> read() {
    return products;
}

public Integer retrievePrice(String barCode) throws NotFoundException {
    for (ProductModel product : products) {
        if (product.getBarCode().equals(barCode)) {
            return product.getPriceInCents();
        }
    }
    throw new NotFoundException("Produto com o código de barras '" + barCode + "' não encontrado.");
}


 }







