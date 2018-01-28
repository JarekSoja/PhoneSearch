
public class Main {

    public static void main(String[] args) {

        Engine appLogic = new Engine();
        String command = "";
        appLogic.start();

        while (!command.equals("x")) {

            System.out.println("command: ");
            command = appLogic.reader();
            appLogic.command(command);
            
        }
    }
}