public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel Core i5-14500"));
    }

    @Override
    public void buildRam() {
        computer.addComponent(new Component("Kingston Fury Beast 16GB DDR5-5600"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("Crucial P3 Plus 1TB NVMe SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("Intel UHD Graphics 770"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11 Pro"));
    }

    public Computer getComputer() {
        return computer;
    }
}
