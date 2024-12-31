import com.didi.ui.GameJFrame;
import com.didi.ui.LoginJFrame;
import com.didi.ui.RegisterJFrame;

public class App {
    public static void main(String[] args) {
        // 程序启动入口

        // 想开起谁的页面，就创建谁的对象就可以了
        new LoginJFrame();

        new GameJFrame();

        new RegisterJFrame();
    }
}
