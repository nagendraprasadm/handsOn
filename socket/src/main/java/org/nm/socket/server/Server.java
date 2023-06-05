package org.nm.socket.server;

import org.nm.socket.SocketRunTimeException;
import org.nm.util.ErrorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private ServerSocket serverSocket;

    private int port;

    private Socket socket;

    private BufferedReader in;

    private PrintWriter out;

    public Server (int port)
    {
        this.port = port;
    }

    public void initialize ()
    {
        try {
            serverSocket = new ServerSocket(this.port);
        }
        catch (IOException e) {
            logger.error("Server - {}. {} while tying to create a server socket. ",
                         this.port, ErrorUtil.getCompleteCausedByErrors(e));
            throw new SocketRunTimeException("Server - " + this.port
                                                 + ". Error while tying to create a server socket.",
                                             e);
        }
    }

    public void listen ()
    {
        try {
            socket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            String inLine = in.readLine();
            while (inLine != null && !inLine.isEmpty()) {
                logger.info("Server - {}. Received message - {}", this.port, inLine);
                out.println("Received OK by - " + port + ". Message - " + inLine);
                inLine = in.readLine();
            }
        }
        catch (IOException e) {
            logger.error("Server - {}. {} while tying to listen on socket. ", this.port,
                         ErrorUtil.getCompleteCausedByErrors(e));
            throw new SocketRunTimeException(
                "Server - " + this.port + ". Error while tying to listen on socket.", e);
        }
        finally {
            try {
                out.close();
                in.close();
                socket.close();
            }
            catch (IOException e) {
                logger.error("Server - {}. {} while tying to close socket. ", this.port,
                             ErrorUtil.getCompleteCausedByErrors(e));
                throw new SocketRunTimeException(
                    "Server - " + this.port + ". Error while tying to close socket.", e);
            }
        }
    }
}
