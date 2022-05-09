/** HelloClient.java **/
import java.util.Scanner;
import java.rmi.Naming;

public class Client2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = 0.0, b = 0.0, result = 0.0;
        int opcao;
        try {
            InterfaceCalculator calculator = (InterfaceCalculator) Naming.lookup("//" + args[0] + "/InterfaceCalculator");
       
            while(true) {
                System.out.println("OPÇÕES CÁLCULO:");
                System.out.println("");
                System.out.println("1 - FATORIAL");
                System.out.println("2 - EXPONENCIAL");
                System.out.println("3 - AREA TRIANGULO");
                System.out.println("4 - AREA ESFERA");
                System.out.println("5 - SAIR");
                System.out.println("");
                System.out.print("Informe a opção: ");
                System.out.println("");
            
                opcao = scanner.nextInt(); 
                if(opcao == 5)
                    break;

                switch(opcao) {
                    case 1: //fatorial
                        System.out.println("Informe o número: ");
                        a = scanner.nextDouble();
                        double fat = 1;
                        while(a > 1) {
                            fat = calculator.multiplica(fat, a);
                            a = calculator.subtrai(a, 1);
                        }
                        result = fat;
                        break;
                    case 2: //exponencial
                        System.out.println("Informe o número: ");
                        a = scanner.nextDouble();
                        System.out.println("Informe o expoente: ");
                        b = scanner.nextDouble();
                        result = a;
                        while(b > 1) {
                            result = calculator.multiplica(result, a);
                            b = calculator.subtrai(b, 1);
                        }
                        break;
                    case 3: //area triangulo
                        System.out.println("Informe a base e altura: ");
                        a = scanner.nextDouble();
                        b = scanner.nextDouble();
                        result = calculator.divide(calculator.multiplica(a, b), 2);
                        break;
                    case 4: //area esfera
                        System.out.println("Informe o raio: ");
                        a = scanner.nextDouble();
                        b = 2;
                        result = a;
                        while(b > 1) {
                            result = calculator.multiplica(result, a);
                            b = calculator.subtrai(b, 1);
                        }
                        result = calculator.multiplica(12.56, result);
                        break;
                }
                System.out.println("");
                System.out.println("Resultado: " + result);
                System.out.println("---------------------------");
            }
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}