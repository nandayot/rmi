/** HelloServer.java **/
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class Server extends UnicastRemoteObject implements InterfaceCalculator {

	public Server() throws RemoteException {
		super();

	}

	public static void main(String[] args) {

		try {
			Server obj = new Server();
			Naming.rebind("//localhost/InterfaceCalculator", obj);
		} catch (Exception ex) {
			System.out.println("Exception: " + ex.getMessage());
			System.exit(1);
		}

	}

    public double soma(double a, double b) {
        return a + b;
    }

    public double subtrai(double a, double b) {
        return a - b;
    }

    public double multiplica(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

}
