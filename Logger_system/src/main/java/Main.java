public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.setFileName("new_log.txt"); // Change file name

        logger.write("Simulation started");
        logger.write("Processing data...");

        logger.setFileName("final_log.txt");

        logger.write("Simulation finished");
        logger.close(); // Remember to close the logger
        logger.write("There is issue in this code!"); // Won't log
    }
}