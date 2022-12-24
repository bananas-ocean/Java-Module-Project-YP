import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static  void inputProducts(Calculator calculator) {

        while (true) {
            String productName = "";
            System.out.println("Введите наименование товара или команду <Завершить>: ");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextLine()) {
                productName = scanner.nextLine();
                if(productName.equalsIgnoreCase("завершить")){
                    break;
                }
                while (true) {
                    Scanner input = new Scanner(System.in);
                    System.out.println("Введите цену товара: ");
                    if (input.hasNextDouble()) {
                        double price = input.nextDouble();
                        if (price > 0){
                            calculator.addProduct(new Product(productName, price));
                            break;
                        }
                    }
                    System.out.println("Вы ввели некорректную цену.");
                }
            }  else {
                System.out.println("Вы ввели некорректное наименование.");
                continue;
            }
        }
    }
    public static void printResult(Calculator calculator, int quantityOfPeople){
        if (calculator.getProducts().equals("")){return;}
        System.out.println("\n\nДобавленные товары:");
        System.out.println(calculator.getProducts());
        String sumWithCurrency = returnSumWithCurrency(calculator.getResult(quantityOfPeople));
        System.out.println("Каждый участник должен заплатить - " + sumWithCurrency);
    }

    public static String returnSumWithCurrency(double num){
        int number = (int)Math.floor(num);
        int preLastDigit = number % 100 / 10;
        if (preLastDigit == 1){
            return String.format("%.2f", num) + " рублей";
        }
        switch (number % 10){
            case 1:
                return String.format("%.2f", num) + " рубль";
            case 2:
            case 3:
            case 4:
                return String.format("%.2f", num) + " рубля";
            default:
                return String.format("%.2f", num) + " рублей";
        }
    }

    public static void main(String[] args) {

        while (true){
            System.out.println("Введите количество человек, на которых необходимо разделить счет:");
            Scanner scanner = new Scanner(System.in);
            if(scanner.hasNextInt()){
                int quantityOfPeople = scanner.nextInt();
                if(quantityOfPeople > 1){
                    Calculator сalculator = new Calculator();
                    inputProducts(сalculator);
                    printResult(сalculator, quantityOfPeople);
                    break;
                }
            }
            System.out.println("Некорректный ввод.Необходимо ввести целое число больше 1.");
        }
    }
}