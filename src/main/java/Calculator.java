public class Calculator {

    String products = "";
    Double sum = 0.0;

    public double getResult(int quantityOfPeople) {
        return sum / quantityOfPeople;
    }

    public String getProducts() {
        return products;
    }

    public void addProduct(Product product){
        products = products + product.getName() + " : " + String.format("%.2f", product.getPrice()) + " руб." + "\n";
        sum += product.getPrice();
        System.out.println("Товар успешно добавлен!");
    }
}
