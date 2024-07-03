import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Java program to create a simple HTTP Server to demonstrate how to use
 * ServerSocket and Socket class.
 */
public class SimpleHTTPServer {

    public static void main(String args[]) throws IOException {

        //creates server socket object on port 8080 to begin listening
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Listening for connection on port 8080 ....");
        //infinite loop to keep the server up
        while (true) {
            //attempts to accept a server connection if it exists
            try (Socket socket = server.accept()) {
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
                //writes the response created above to the outputstream
                socket.getOutputStream()
                      .write(httpResponse.getBytes("UTF-8"));
            }
        }
    }

}
