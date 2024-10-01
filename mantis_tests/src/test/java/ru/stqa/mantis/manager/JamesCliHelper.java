package ru.stqa.mantis.manager;


import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;

public class JamesCliHelper extends HelperBase {

    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String password) {
//        CommandLine command = new CommandLine("cd", "/");
//        command.execute();
//        command.waitFor();
//        CommandLine command2 = new CommandLine("cd", "/Users/yaxartes_river/Documents/study/james-server-jpa-guice");
//        command2.execute();
//        command2.waitFor();
//        CommandLine command3 = new CommandLine("pwd");
//        CircularOutputStream output = new CircularOutputStream();
//        command3.copyOutputTo(output);
//        command3.execute();
//        command3.waitFor();
//        System.out.print(output);
        CommandLine cmd = new CommandLine(
                "java", "-cp", "\"james-server-jpa-app.lib/*\"",
                "org.apache.james.cli.ServerCmd",
                "AddUser", email, password);
        cmd.setWorkingDirectory(manager.property("james.workingDir"));
        CircularOutputStream out = new CircularOutputStream();
        cmd.copyOutputTo(out);
        cmd.execute();
        cmd.waitFor();
        System.out.print(out);
    }
}
