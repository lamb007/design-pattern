package improve;

/**
 * @author yzw
 * @date 2023年05月07日 21:21
 */
public class Main {
    public static void main(String[] args) {
        // 购买低配电脑
        ComputerBuilder lowComputerBuilder = new LowComputerBuilder();
        Director director = new Director(lowComputerBuilder);
        Computer computer = director.construct();
        System.out.println("-----------------------------------------");
        // 购买高配电脑
        ComputerBuilder highComputerBuilder = new HighComputerBuilder();
        director = new Director(highComputerBuilder);
        computer = director.construct();
    }
}
