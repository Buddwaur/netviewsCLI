package org.netviews.cli.netviews.cli2;

import java.io.IOException;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command ( name = "setup", description = "command to setup NetViews with different SDN Controllers",
        mixinStandardHelpOptions = true )
public class Setup implements Runnable {

    private final String   pathToOnosSetup = "/testls.sh";

    @Parameters ( paramLabel = "<controller>", defaultValue = "onos", description = "name of the SDN controller" )
    private final String[] controllers     = { "default" };

    @Override
    public void run () {

        String controller = controllers[0];

        if ( controller.length() == 0 ) {
            // If no parameter is passed in, then the default is set here.
            controller = "onos";
        }

        // If a default value passed
        if ( controller.equals( "onos" ) ) {

            final Runtime runTimeObj = Runtime.getRuntime();
            // Setup onos
            try {
                System.out.println( pathToOnosSetup );
                runTimeObj.exec( pathToOnosSetup );
            }
            catch ( final IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        else if ( controllers[0].length() > 1 ) {
            // For non-default values
        }
        else {
            // Print usage
            System.out.println( "Controller unavailable" );
        }

    }
}
