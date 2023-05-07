package improve;

/**
 * @author yzw
 * @date 2023年05月07日 21:01
 */
public class LowComputerBuilder extends ComputerBuilder{
    @Override
    public void buildCPU() {
        System.out.println("配备低配CPU");
    }

    @Override
    public void buildScreen() {
        System.out.println("配备低配屏幕");
    }

    @Override
    public void buildMemory() {
        System.out.println("配备低配内存");
    }

    @Override
    public void buildFan() {
        System.out.println("不赠送耳机");
    }

    @Override
    public void buildEarphone() {
        System.out.println("赠送低配耳机");
    }
}
