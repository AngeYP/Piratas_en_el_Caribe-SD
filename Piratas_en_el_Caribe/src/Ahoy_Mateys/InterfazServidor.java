
package Ahoy_Mateys;

import Ahoy_Mateys.Agente;
import java.rmi.*;
import Ahoy_Mateys.Barco;

public interface InterfazServidor extends Remote{
    public void recibe(Agente h) throws RemoteException;

}
