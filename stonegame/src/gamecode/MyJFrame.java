package gamecode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author: Zzz_tjhd
 * @date: 2020-09-02 22:58
 */
public class MyJFrame extends JFrame implements KeyListener {

    //定义二维数据方便管理数据
    int[][] datas = new int[4][4];
    //定义一个二维数组，元素是最终胜利的的元素
    int[][] victory = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    int x0 = 0;
    int y0 = 0;
    //统计
    int step = 0;

    public MyJFrame() {

        //初始化界面
        initFrame();
        //添加菜单
        initMenu();
        //初始化数据
        initData();
        //初始化图片
        initImage();


        //显示
        this.setVisible(true);
    }

    private void initData() {

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int index = r.nextInt(arr.length);
            int num = arr[i];
            arr[i] = arr[index];
            arr[index] = num;
        }

        //打乱二维数组
        for (int i = 0; i < arr.length; i++) {
            datas[i / 4][i % 4] = arr[i];
            if (arr[i] == 0) {
                x0 = i / 4;
                y0 = i % 4;
            }
        }
    }

    public void initFrame() {
        //大小
        this.setSize(514, 595);
        //title
        this.setTitle("石头迷阵单机版 V1.0");
        //屏幕中央
        this.setLocationRelativeTo(null);
        //关闭模式
        this.setDefaultCloseOperation(3);
        //置顶
        this.setAlwaysOnTop(true);
        //添加监听事件
        this.addKeyListener(this);
        //取消内部居中放置样式
        this.setLayout(null);
    }

    public void initMenu() {
        //设置菜单栏对象样式大小
        JMenuBar jm = new JMenuBar();
        jm.setSize(600, 30);
        //创建菜单名称
        JMenu ju = new JMenu("功能");
        JMenu ju1 = new JMenu("关于");
        //创建菜单下功能选项
        JMenuItem ji = new JMenuItem("重新游戏");
        //重新监听事件
        ji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //重新打乱顺序
                initData();
                //统计清0
                step = 0;
                //绘制整个界面
                initImage();
            }
        });
        JMenuItem ji1 = new JMenuItem("退出游戏");
        //退出监听事件
        ji1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        JMenuItem ji2 = new JMenuItem("联系我们");
        ji2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建弹框
                JDialog jd = new JDialog();
                ImageIcon ii = new ImageIcon("./stonegame//image//about.png");
                JLabel jl = new JLabel(ii);
                jl.setBounds(0, 0, 344, 344);
                jd.add(jl);
                //弹框设置大小
                jd.setSize(344, 344);
                //弹框设置到顶层
                jd.setAlwaysOnTop(true);
                //弹框居中
                jd.setLocationRelativeTo(null);
                //显示弹框
                jd.setVisible(true);
            }
        });


        //三个增加关联关系，功能关联菜单，菜单关联菜单栏，把菜单栏添加到窗体上
        ju.add(ji);
        ju.add(ji1);
        ju1.add(ji2);
        jm.add(ju);
        jm.add(ju1);
        this.setJMenuBar(jm);
    }

    public void initImage() {
/*      //添加图片
        ImageIcon ii1 = new ImageIcon("./stonegame/image/1.png");
        //创建一个jlable对象，为了设置图片的位置和宽高
        JLabel jl1 = new JLabel(ii1);
        jl1.setBounds(0 + 50, 0 + 90, 100, 100);
        //把jlable添加到主窗体
        this.add(jl1);

        //图片2
        ImageIcon ii2 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\2.png");
        JLabel jl2 = new JLabel(ii2);
        jl2.setBounds(100 + 50, 0 + 90, 100, 100);
        this.add(jl2);

        //图片3
        ImageIcon ii3 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\3.png");
        JLabel jl3 = new JLabel(ii3);
        jl3.setBounds(200 + 50, 0 + 90, 100, 100);
        this.add(jl3);

/*        for (int i = 1; i <= 4; i++) {
            ImageIcon image = new ImageIcon("./stonegame//image//" + i + ".png");
            JLabel jl = new JLabel(image);
            jl.setBounds((i - 1) * 100 + 50, 90, 100, 100);
            this.add(jl);
        }*/
        //将页面中所有的图片删除
        this.getContentPane().removeAll();

        JLabel label_step = new JLabel("步数：" + step);
        label_step.setBounds(50, 20, 100, 20);
        this.add(label_step);

        //判断游戏是否胜利
        if (victory()) {
            ImageIcon image = new ImageIcon("./stonegame//image//win.png");
            JLabel jl = new JLabel(image);
            jl.setBounds(514 / 2 - 266 / 2, 230, 266, 88);
            this.add(jl);
        }

        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                int data = datas[i][j];
                if (data != 0) {
                    ImageIcon image = new ImageIcon("./stonegame//image//" + data + ".png");
                    JLabel jl = new JLabel(image);
                    jl.setBounds(j * 100 + 50, i * 100 + 90, 100, 100);
                    this.add(jl);
                }
            }
        }

        //背景图片
        ImageIcon bg = new ImageIcon("./stonegame//image//background.png");
        JLabel jl16 = new JLabel(bg);
        jl16.setBounds(26, 30, 450, 484);
        this.add(jl16);

        //将整个界面重新绘制
        this.getContentPane().repaint();
    }

    //判断胜利
    public boolean victory() {
        //判断两个数组是否相等
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                if (datas[i][j] != victory[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //松开
    @Override
    public void keyPressed(KeyEvent e) {

    }

    //按下
    @Override
    public void keyReleased(KeyEvent e) {
        //获取按键的数字
        int keyCode = e.getKeyCode();
        move(keyCode);
        //重新绘制界面
        initImage();
    }

    private void move(int keyCode) {
        if (keyCode == 37) {
            if (y0 == 3) {
                return;
            }
            //左
            datas[x0][y0] = datas[x0][y0 + 1];
            datas[x0][y0 + 1] = 0;
            y0++;
            step++;
        } else if (keyCode == 38) {
            if (x0 == 3) {
                return;
            }
            //上
            datas[x0][y0] = datas[x0 + 1][y0];
            datas[x0 + 1][y0] = 0;
            x0++;
            step++;
        } else if (keyCode == 39) {
            if (y0 == 0) {
                return;
            }
            //右
            datas[x0][y0] = datas[x0][y0 - 1];
            datas[x0][y0 - 1] = 0;
            y0--;
            step++;
        } else if (keyCode == 40) {
            if (x0 == 0) {
                return;
            }
            //下
            datas[x0][y0] = datas[x0 - 1][y0];
            datas[x0 - 1][y0] = 0;
            x0--;
            step++;
        } else if (keyCode == 87) {
            //后门键
            datas = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        } else {
            System.out.println(keyCode);
            System.out.println("按键错了...");
        }
    }
}
