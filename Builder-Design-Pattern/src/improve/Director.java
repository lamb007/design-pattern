package improve;

/**
 * @author yzw
 * @date 2023年05月07日 21:19
 */
public class Director {
    // 抽象建造者
    private ComputerBuilder builder;

    // 通过构造注入一个具体建造者
    public Director(ComputerBuilder builder) {
        this.builder = builder;
    }

    public Computer construct() {
        // 多态，运行时调用具体建造者的方法
        // 可能有先后顺序
        builder.buildCPU();
        builder.buildScreen();
        builder.buildMemory();
        builder.buildFan();
        builder.buildEarphone();
        return builder.buildComputer();
    }
}
