package com.didi.ui;

import javax.swing.*;
import java.util.Random;

public class GameJFrame extends JFrame {
    // 跟主界面相关的代码，写在这个页面中

    int[][] data = new int[4][4];

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
            data[i / 4][i % 4] = tempArr[i];
        }

    }

    // 初始化图片
    private void initImage() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int num = data[i][j];
//            ImageIcon icon = new ImageIcon("D:\\code\\puzzlegame\\image\\animal\\animal3\\1.jpg");
                JLabel jLabel = new JLabel(new ImageIcon("D:\\code\\puzzlegame\\image\\animal\\animal3\\"+ num +".jpg"));
                // 指定图片位置
                jLabel.setBounds(105 * i,j * 105,105,105);
//        this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }
    }


    private void initMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();

        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我们");

        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem closeItem = new JMenuItem("关闭游戏");

        JMenuItem accountItem = new JMenuItem("公众号");

        // 将每一个选项下面的条目加到选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

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
    }
}
