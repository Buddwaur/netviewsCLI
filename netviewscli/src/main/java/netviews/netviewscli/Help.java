package netviews.netviewscli;

import picocli.CommandLine.Command;

@Command ( name = "help", description = "Help", mixinStandardHelpOptions = true )
public class Help implements Runnable {

    @Override
    public void run () {
        final StringBuilder commands = new StringBuilder();
        commands.append( "Commands:\n" );
        commands.append( "help: \tList all commands and options available\n" );
        commands.append( "policy: \tAccess functions to create and delete policies\n" );
        System.out.println( commands.toString() );
    }

}
