import java.rmi.*;

public interface InterfazServidor extends Remote{
    public void recibe(Agente h) throws RemoteException;
}
