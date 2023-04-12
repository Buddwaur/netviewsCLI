package netviews.netviewscli;

import models.NVWrapper;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;

@Command(name = "AddNode", description = "Takes a Node, Association, or Assignment and appends it to the policy JSON file", mixinStandardHelpOptions = true)
public class AddNode implements Runnable {

    // @Option(paramLabel = "<Type>", names = { "-t",
    // "--type" }, required = true, description = "Type of the node to be added. EX.
    // 'O', 'OA'")
    // private String type;

    // @Option(paramLabel = "<Name>", names = { "-n",
    // "--name" }, required = true, description = "Name of the node to be added.")
    // private String name;

    @Parameters(paramLabel = "<Name>", index = "0..*", description = "Name of the node to be added.")
    private String name[];

    @Parameters(paramLabel = "<Type>", index = "0", description = "Type of the node to be added. EX. 'O', 'OA'")
    private String type;

    @Override
    public void run() {
        if (type == null || name == null || name.length == 0 || type.length() == 0) {
            // Missing parameters
            throw new IllegalArgumentException("Node Type or Name is empty");
        }

        type = name[name.length - 1];

        String fullName = String.join(" ", name);

        // String fullType = String.join(" ", type);

        NVWrapper wrap = Utilities.deserialize();

        wrap.newNode(fullName, type, null);

        Utilities.serialize(wrap);
    }

}
