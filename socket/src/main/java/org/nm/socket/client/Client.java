package org.nm.socket.client;

import org.apache.commons.lang3.StringUtils;
import org.nm.socket.SocketRunTimeException;
import org.nm.util.ErrorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client
{
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    private final InetSocketAddress inetSocketAddress;

    private String name;

    private Socket socket;

    private PrintWriter out;

    private BufferedReader in;

    public Client (String name, String host, int port)
    {
        if (!StringUtils.isEmpty(host) && port > 0) {
            inetSocketAddress = new InetSocketAddress(host, port);
            this.name = name;
        }
        else {
            throw new RuntimeException("Host Name and Port cannot be blank.");
        }

    }

    public Client (String name, InetSocketAddress address)
    {
        if (address == null) {
            throw new RuntimeException("Address cannot be blank.");
        }
        inetSocketAddress = address;
        this.name = name;
    }

    public void initialize ()
    {
        try {
            socket = new Socket(inetSocketAddress.getHostName(), inetSocketAddress.getPort());
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }
        catch (IOException e) {
            logger.error("Client - {}. {} while trying to create socket - {} ", name,
                         ErrorUtil.getCompleteCausedByErrors(e), inetSocketAddress);
            throw new SocketRunTimeException(
                "Client - " + name + ".Error - " + ErrorUtil.getCompleteCausedByErrors(e)
                    + " while trying to create socket - " + inetSocketAddress, e);
        }

    }

    public void connect ()
    {
        try {
            socket.connect(inetSocketAddress);
        }
        catch (IOException e) {
            logger.error("Client - {}. {} while trying to connect to - {} ", name,
                         ErrorUtil.getCompleteCausedByErrors(e), inetSocketAddress);
            throw new SocketRunTimeException(
                "Client - " + name + ". Error - " + ErrorUtil.getCompleteCausedByErrors(e)
                    + " while trying to connect to - " + inetSocketAddress, e);
        }
    }

    public void sendMessage (String message)
    {
        try {
            out.println(message);
            String lineRead = in.readLine();
            logger.info(
                "Client - {}. Response received from server - {} after sending message - {} is - {}",
                name, inetSocketAddress, message, lineRead);
        }
        catch (IOException e) {
            logger.error(
                "Client - {}. {} while trying to send message - {} and receive response from - {} ",
                name, ErrorUtil.getCompleteCausedByErrors(e), message, inetSocketAddress);
            throw new SocketRunTimeException(
                "Client - " + name + ". Error - " + ErrorUtil.getCompleteCausedByErrors(e)
                    + " while trying to send message - " + message
                    + " and receive response from  - " + inetSocketAddress, e);
        }
    }

    public void stop ()
    {
        try {
            in.close();
            out.close();
            socket.close();
        }
        catch (IOException e) {
            logger.error("Client - {}. {} while trying to close socket to - {} ", name,
                         ErrorUtil.getCompleteCausedByErrors(e), inetSocketAddress);
            throw new SocketRunTimeException(
                "Client - " + name + ". Error - " + ErrorUtil.getCompleteCausedByErrors(e)
                    + " while trying to close socket to - " + inetSocketAddress, e);
        }
    }

}
