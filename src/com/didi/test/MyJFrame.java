package com.didi.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jtb1 = new JButton("按钮1");
    JButton jtb2 = new JButton("按钮2");

    public MyJFrame(){
        this.setSize(603, 680);

        this.setTitle("拼图单机版");
        // 设置页面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(null);

        jtb1.setBounds(0, 0, 100, 50);
        jtb1.addActionListener(this);

        jtb2.setBounds(100, 0, 100, 50);
        jtb2.addActionListener(this);

        // 把按钮添加到整个界面当中
        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 对当前的按钮进行判断
        // 获取当前被操作的按钮对象
        Object sourse = e.getSource();
        if(sourse == jtb1){
            jtb1.setSize(200,200);
        }else if(sourse == jtb2){
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500), r.nextInt(500));
        }
    }
}
