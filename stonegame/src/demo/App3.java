package demo;

import javax.swing.*;

public class App3{
    public static void main(String[] args) {
        //主界面
        JFrame jf = new JFrame();

        //设置大小
        jf.setSize(600,800);

        //显示在屏幕中央
        jf.setLocationRelativeTo(null);

        //置顶
        jf.setAlwaysOnTop(true);

        //设置title
        jf.setTitle("石头迷阵单机版 v1.0");

        //关闭主窗口退出程序
        jf.setDefaultCloseOperation(3);

        //显示主界面
        jf.setVisible(true);



    }
}