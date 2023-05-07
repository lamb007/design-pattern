package basic;

/**
 * @author yzw
 * @date 2023年05月07日 20:12
 */
public class Computer2 {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数 例如：购买高配置电脑赠送低配置风扇，不赠送耳机，购买配置电脑赠送高配置风扇和耳机
    private String fan;
    private String earphone;

    // 通过构造函数传入必须参数
    public Computer2(String CPU, String screen, String memory) {
        this.CPU = CPU;
        this.screen = screen;
        this.memory = memory;
    }
    // 通过set方法传入可选参数
    public void setFan(String fan) {
        this.fan = fan;
    }
    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }

}
