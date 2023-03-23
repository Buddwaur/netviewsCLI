package netviews.netviewscli;

import java.util.Scanner;

import picocli.CommandLine;

public class NetviewsCLI {

    public static void main(final String[] args) {

        final Scanner scan = new Scanner(System.in);

        String input;

        final String exit = "exit";

        // final TestCommand command = new TestCommand();
        int exitCode = 0;

        do {
            System.out.print(">>> ");
            input = scan.nextLine();

            final String[] parsedInput = input.split(" ");

            final String command = parsedInput[0];

            String arguments = "";
            for (int i = 1; i < parsedInput.length; i++) {

                arguments = arguments.concat(parsedInput[i]);
                if (i != parsedInput.length - 1) {
                    arguments = arguments.concat(" ");
                }

            }

            // System.out.println( Arrays.toString( parsedInput ) );
            // System.out.println( command );
            // System.out.println( arguments );

            switch (command) {
                case "TestCommand":
                    exitCode = new CommandLine(new TestCommand()).execute(arguments);
                    break;
                case "help":
                    // exitCode = new CommandLine( new Help() ).execute();
                    break;
                case "setup":
                    exitCode = new CommandLine(new Setup()).execute(arguments);
                    break;
                case "AddPolicyElements":
                	exitCode = new CommandLine(new AddPolicyElementsCommand()).execute(arguments);
                	break;
                default:

            }

        } while (input.compareTo(exit) != 0);
        scan.close();
    }
}
