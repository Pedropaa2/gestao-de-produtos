package product;

public class ProductModel {
    private static int nextBarCode = 1;
    private String barCode;

    public ProductModel() {
        this.barCode = generateBarCode();
    }

    private String generateBarCode() {
        String paddedCode = String.format("%06d", nextBarCode++);
        return "BC-" + paddedCode; // Exemplo de formato de código de barras
    }

    public String getBarCode(){
        return barCode;
    }

    private String name;
   
    public String getName(){
        return name;
    }

    public void setName(String newName){

        if(newName != null && !newName.isEmpty()){
            name=newName;
        }

    }
    private Integer priceInCents;
   
    public void setPriceInCents(Integer newPrice){

        if(newPrice != null){
            priceInCents=newPrice;
        }

    }
   
    public Integer getPriceInCents(){
        return priceInCents;
    }
    private Integer stock;
   
    public void setStock(Integer newStock){

        if(newStock != null){
            stock=newStock;
        }

    }
    public Integer getStock(){
        return stock;
    }

}
