public class ComputerDirector {
    private ComputerBuilder builder;

    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }

    public void constructComputer() {
        builder.buildProcessor();
        builder.buildRam();
        builder.buildRam();
        builder.buildGraphicsCard();
        builder.buildHardDrive();
        builder.buildOperatingSystem();
    }
}
