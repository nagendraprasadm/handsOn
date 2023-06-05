package org.nm.socket.client;

public class ClientMain
{
    public static void main (String[] args)
    {
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        String name = args[2];
        Client client = new Client( name,host, port);
        client.initialize();
        //client.connect();
        client.sendMessage("Test BLA");
        client.stop();
    }
}
