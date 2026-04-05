public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void buildProcessor() {
        computer.addComponent(new Component("Intel Core i9-14900KS"));
    }

    @Override
    public void buildRam() {
        computer.addComponent(new Component("Corsair Dominator Titanium 64GB DDR5-7200"));
    }

    @Override
    public void buildHardDrive() {
        computer.addComponent(new Component("Samsung 990 Pro 4TB NVMe SSD"));
    }

    @Override
    public void buildGraphicsCard() {
        computer.addComponent(new Component("NVIDIA GeForce RTX 4090 Founders Edition"));
        computer.addComponent(new Component("ASUS ROG Matrix GeForce RTX 4090 Platinum"));
    }

    @Override
    public void buildOperatingSystem() {
        computer.addComponent(new Component("Windows 11 Pro"));
    }

    public Computer getComputer() {
        return computer;
    }
}
