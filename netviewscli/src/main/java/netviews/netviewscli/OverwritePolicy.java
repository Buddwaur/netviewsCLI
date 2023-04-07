package netviews.netviewscli;

import picocli.CommandLine.Command;
//import picocli.CommandLine.Parameters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * The SOAP client code in this command was used from a stackoverflow
 * forum response at:
 * https://stackoverflow.com/questions/15940234/how-to-do-a-soap-web-service-call-from-java-class
 */
@Command ( name = "OverwritePolicy",
		description = "Takes filepath of a new policy json file to overwrite current policy graph.",
        mixinStandardHelpOptions = true )
public class OverwritePolicy implements Runnable {
	// TODO: get rid of default value? Might not make sense in this context
    // @Parameters ( paramLabel = "<policy filepath>", defaultValue = "default",
    //        description = "file path to new policy json file." )
    //private final String[] filepath = {"default"};

    @Override
    public void run () {
    	final Runtime runTimeObj = Runtime.getRuntime();
    	try {
    		Process process = runTimeObj.exec("nc 127.0.0.1 9191 && creatPolicy");
    		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }
    	} catch (final IOException e) {
            e.printStackTrace();
    	}
    	
    	
    	//System.out.println("Overwrite command run, filepath = " + String.join(" ", filepath));
    }

}
