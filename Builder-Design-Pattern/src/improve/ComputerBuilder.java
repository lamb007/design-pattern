package improve;

/**
 * @author yzw
 * @date 2023年05月07日 20:57
 */
public abstract class ComputerBuilder {
    protected Computer computer = new Computer();

    // 规定建造步骤
    public abstract void buildCPU();
    public abstract void buildScreen();
    public abstract void buildMemory();
    public abstract void buildFan();
    public abstract void buildEarphone();

    // 获取建造好的产品
    public Computer buildComputer() {
        return computer;
    }
}
