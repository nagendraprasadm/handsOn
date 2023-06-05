package org.nm.socket.server;

public class ServerMain
{
    public static void main (String[] args)
    {
        Server server = new Server(Integer.parseInt(args[0]));
        server.initialize();
        server.listen();
    }
}
