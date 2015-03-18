/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5.Server;

import java.util.Map;
 
/**
 *
 * @author pieter
 */

import javafxapplication5.ServerGUIController;
public class Server 
{
    private Map<String, Client> clients;
    private serverThread st;
    private ServerGUIController servercontroller;
    public Server(ServerGUIController servercontroller) 
    {
        st = new serverThread(this);
        this.servercontroller = servercontroller;
        Thread t = new Thread(st);
        t.start();
    }
    
    public void sendMessage(String Message, String naam)
    {
        System.out.println("ik stuur een bericht");
        clients = (Map<String, Client>) st.getClients();
        clients.get(naam).sendMessage(Message);
    }
    public void AddItemtoScreen(String message)
    {
        servercontroller.AddItemListview(message);
    }
}
