
package piratas;

import java.rmi.*;
import piratas.Barco;

public interface InterfazServidor extends Remote{
    public void recibe(Agente h) throws RemoteException;

}
