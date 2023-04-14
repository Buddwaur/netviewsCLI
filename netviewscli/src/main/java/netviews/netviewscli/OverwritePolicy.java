package netviews.netviewscli;

import picocli.CommandLine.Command;
//import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * The SOAP client code in this command was used from a stackoverflow
 * forum response at:
 * https://stackoverflow.com/questions/15940234/how-to-do-a-soap-web-service-call-from-java-class
 */
@Command(name = "OverwritePolicy", description = "Takes filepath of a new policy json file to overwrite current policy graph.", mixinStandardHelpOptions = true)
public class OverwritePolicy implements Runnable {

    private Socket sock;

    @Override
    public void run() {
        // Connect to Server with Socket
        try {
            sock = new Socket("127.0.0.1", 9191);
            PrintStream output = new PrintStream(sock.getOutputStream());
            output.println("Change!");
            output.close();
            sock.close();
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
