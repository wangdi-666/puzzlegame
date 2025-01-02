package com.didi.test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class Test2 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);

        jFrame.setTitle("事件演示");
        // 设置页面置顶
        jFrame.setAlwaysOnTop(true);
        // 设置界面居中
        jFrame.setLocationRelativeTo(null);
        // 设置关闭模式
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jFrame.setLayout(null);

        JButton jtb = new JButton("按钮");
        jtb.setBounds(0, 0, 100, 50);
        jtb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });
        jFrame.getContentPane().add(jtb);

        jFrame.setVisible(true);
    }
}
