public interface ComputerBuilder {
    void buildProcessor();

    void buildRam();

    void buildHardDrive();

    void buildGraphicsCard();

    void buildOperatingSystem();

    Computer getComputer();
}
