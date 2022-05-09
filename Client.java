/** HelloClient.java **/
import java.util.Scanner;
import java.rmi.Naming;

public class Client {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double a = 0.0, b = 0.0, result = 0.0;
    int opcao;
    try {
       InterfaceCalculator calculator = (InterfaceCalculator) Naming.lookup("//" + args[0] + "/InterfaceCalculator");
       
        while(true) {
            System.out.println("Calculadora OPÇÕES:");
            System.out.println("");
            System.out.println("1 - SOMA");
            System.out.println("2 - SUBTRAÇÃO");
            System.out.println("3 - MULTIPLICAÇÃO");
            System.out.println("4 - DIVISÃO");
            System.out.println("5 - SAIR");
            System.out.println("");
            System.out.print("Informe a opção: ");
            System.out.println("");
        
            opcao = scanner.nextInt(); 
            if(opcao == 5)
                break;

            System.out.println("Informe dois números: ");
            a = scanner.nextDouble();
            b = scanner.nextDouble();

            switch(opcao) {
                case 1: //soma
                    result = calculator.soma(a, b);
                    break;
                case 2: //subtração
                    result = calculator.subtrai(a, b);
                    break;
                case 3: //multiplicação
                    result = calculator.multiplica(a, b);
                    break;
                case 4: //divisão
                    result = calculator.divide(a, b);
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