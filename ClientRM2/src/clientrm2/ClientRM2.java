/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientrm2;

import daao.IDao;
import entities.Machine;
import entities.Salle;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientRM2 {

    
    public static void main(String[] args) {
        
        try {
            IDao<Machine> dao1 = (IDao<Machine>) Naming.lookup("rmi://localhost:1099/dao1");
            IDao<Salle> dao2 = (IDao<Salle>) Naming.lookup("rmi://localhost:1099/dao2");
            Salle S1=new Salle("A");
            Salle S2=new Salle("B");
            Salle S3=new Salle("C");
            dao2.create(S1);
            dao2.create(S2);
            dao2.create(S3);
            for(Salle s:dao2.findAll()){
                System.out.println(s);
            }
            dao1.create(new Machine("L","LENOVO",5000,S1));
            dao1.create(new Machine("T","Toshiba",4000,S2));
            dao1.create(new Machine("H","HP",5500,S3));
            
            for(Machine  m  : dao1.findAll())
                System.out.println(m);
        } catch (NotBoundException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientRM2.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }

}
