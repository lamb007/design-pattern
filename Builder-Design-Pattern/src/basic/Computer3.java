package basic;

/**
 * @author yzw
 * @date 2023年05月07日 20:12
 */
public class Computer3 {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数 例如：购买高配置电脑赠送低配置风扇，不赠送耳机，购买配置电脑赠送高配置风扇和耳机
    private String fan;
    private String earphone;

    // 低级
    public Computer3 buildLowComputer(Computer3 computer3) {
        computer3.setCPU("低配CPU");
        computer3.setMemory("低配memory");
        computer3.setScreen("低配screen");
        computer3.setEarphone("赠送的低配耳机");
        return computer3;
    }
    // 高配
    public Computer3 buildHighComputer(Computer3 computer3) {
        computer3.setCPU("高配CPU");
        computer3.setMemory("高配memory");
        computer3.setScreen("高配screen");
        computer3.setEarphone("赠送的高配耳机");
        computer3.setFan("赠送的高级风扇");
        return computer3;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }
}
