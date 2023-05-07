package improve;


public class Computer {
    // 必须参数
    private String CPU;
    private String screen;
    private String memory;

    // 可选参数
    private String fan;
    private String earphone;

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getFan() {
        return fan;
    }

    public void setFan(String fan) {
        this.fan = fan;
    }

    public String getEarphone() {
        return earphone;
    }

    public void setEarphone(String earphone) {
        this.earphone = earphone;
    }
}
