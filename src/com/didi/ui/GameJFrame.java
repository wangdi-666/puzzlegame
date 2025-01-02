package com.didi.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    // 跟主界面相关的代码，写在这个页面中

    int[][] data = new int[4][4];

    // 记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    // 定义一个变量，记录当前展示图片的路径
    String path = "image\\animal\\animal8\\";

    int[][] win = new int[][]{
            {1,5,9,13},
            {2,6,10,14},
            {3,7,11,15},
            {4,8,12,0}
    };

    int step = 0;

    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");

    public GameJFrame(){
        //初始化界面
        initJFrame();

        // 初始化菜单
        initMenuBar();

        // 初始化数据（打乱）
        initData();

        // 初始化图片
        initImage();

        // 让图形化界面显示出来，这一行代码写在最后
        this.setVisible(true);
    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 10, 12, 13, 14, 15};
        Random r = new Random();

        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];

        }

    }

    // 初始化图片
    private void initImage() {

        // 清空原本已经出现的所有图片
        this.getContentPane().removeAll();

        if (victory()){
            JLabel winJLabel = new JLabel(new ImageIcon("image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        JLabel stepCount = new JLabel("步数：" + step);
        stepCount.setBounds(50,50,100,20);
        this.getContentPane().add(stepCount);

        // 加载图片细节：先加载的图片会放在上面，后加载的图片在下面
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
//            ImageIcon icon = new ImageIcon("D:\\code\\puzzlegame\\image\\animal\\animal3\\1.jpg");
                JLabel jLabel = new JLabel(new ImageIcon(path+ num +".jpg"));
                // 指定图片位置
                jLabel.setBounds(105 * i + 83,j * 105 + 134,105,105);
//        this.add(jLabel);
                // 给小图片设置边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                this.getContentPane().add(jLabel);
            }
        }

        // 添加背景图片
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新一下界面
        this.getContentPane().repaint();
    }


    private void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        // 将每一个选项下面的条目加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        // 给整个页面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        // 设置页面宽高
        this.setSize(603,680);
        // 设置界面的标题
        this.setTitle("拼图单机版 v1.0");
        // 设置页面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // 取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // 按下不松时
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == 65){
            this.getContentPane().removeAll();

            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            // 添加背景图片
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    // 松开按键时
    @Override
    public void keyReleased(KeyEvent e) {
        // 游戏胜利直接结束
        if (victory()){
            return;
        }
        // 对上，下，左，右进行判断
        // 左：37 上：38 右：39 下： 40（不用记住，用到了直接打印）
        int code = e.getKeyCode();
//        System.out.println(code);
        // 调用的坐标上和左是反的，下和右是反的
        if (code == 37){
            System.out.println("向左移动");

            if (x == 3){
                return;
            }
            // x,y 表示当前空白块
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;

            step++;
            initImage();
        } else if (code == 38){
            System.out.println("向上移动");

            if (y == 3){
                //表示空白快已经在最下方了，下面没有图片能再移动了
                return;
            }
            // x,y 表示当前空白块
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;

            step++;
            initImage();

        }else if (code == 39){
            System.out.println("向右移动");
            if (x == 0){
                return;
            }
            // x,y 表示当前空白块
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;

            step++;
            initImage();
        }else if (code == 40){
            if (y == 0){
                return;
            }
            System.out.println("向下移动");
            // x,y 表示当前空白块
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;

            step++;
            initImage();
        }else if (code == 65){
            initImage();
        }else if (code == 87){
            data = new int[][]{
                    {1,5,9,13},
                    {2,6,10,14},
                    {3,7,11,15},
                    {4,8,12,0}
            };
            initImage();
        }

    }

    public boolean victory(){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取当前被点击的条目
        Object obj = e.getSource();
        if(obj == replayItem){
            System.out.println("重新游戏");

            //计步器清0
            step = 0;
            //再次打乱二维数组中的数据
            initData();
            //重新加载图片
            initImage();


        }else if (obj == reLoginItem){
            System.out.println("重新登录");
            //关闭当前的界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }else if (obj == closeItem){
            System.out.println("关闭游戏");
            // 直接关闭JVM虚拟机
            System.exit(0);
        }else if (obj == accountItem){
            System.out.println("公众号");
            // 创建一个弹框对象
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel(new ImageIcon("image\\about.png"));
            jLabel.setBounds(0,0,258,258);
            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(344,344);
            // 让弹框置顶
            jDialog.setAlwaysOnTop(true);
            // 让弹框居中
            jDialog.setLocationRelativeTo(null);
            // 弹框不关闭则无法操作下面的界面
            jDialog.setModal(true);
            // 让弹框显示出来
            jDialog.setVisible(true);
        }
    }
}
