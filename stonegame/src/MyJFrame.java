import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author: Zzz_tjhd
 * @date: 2020-09-02 22:58
 */
public class MyJFrame extends JFrame {

    //定义二维数据方便管理数据
    int[][] datas = new int[4][4];
    int x0 = 0;
    int y0 = 0;

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
        //取消内部居中放置样式
        this.setLayout(null);
    }

    public void initMenu() {
        //设置菜单栏对象样式大小
        JMenuBar jm = new JMenuBar();
        jm.setSize(600, 30);
        //创建菜单名称
        JMenu ju = new JMenu("功能");
        //创建菜单下功能选项
        JMenuItem ji = new JMenuItem("重新游戏");
        //重新监听事件
        ji.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("重新游戏");
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

        //三个增加关联关系，功能关联菜单，菜单关联菜单栏，把菜单栏添加到窗体上
        ju.add(ji);
        ju.add(ji1);
        jm.add(ju);
        this.setJMenuBar(jm);
    }

    public void initImage() {
/*        //添加图片
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

        //图片4
        ImageIcon ii4 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\4.png");
        JLabel jl4 = new JLabel(ii4);
        jl4.setBounds(300 + 50, 0 + 90, 100, 100);
        this.add(jl4);


        //图片5
        ImageIcon ii5 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\5.png");
        JLabel jl5 = new JLabel(ii5);
        jl5.setBounds(0 + 50, 100 + 90, 100, 100);
        this.add(jl5);

        //图片6
        ImageIcon ii6 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\6.png");
        JLabel jl6 = new JLabel(ii6);
        jl6.setBounds(100 + 50, 100 + 90, 100, 100);
        this.add(jl6);

        //图片7
        ImageIcon ii7 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\7.png");
        JLabel jl7 = new JLabel(ii7);
        jl7.setBounds(200 + 50, 100 + 90, 100, 100);
        this.add(jl7);

        //图片8
        ImageIcon ii8 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\8.png");
        JLabel jl8 = new JLabel(ii8);
        jl8.setBounds(300 + 50, 100 + 90, 100, 100);
        this.add(jl8);

        //图片9
        ImageIcon ii9 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\9.png");
        JLabel jl9 = new JLabel(ii9);
        jl9.setBounds(0 + 50, 200 + 90, 100, 100);
        this.add(jl9);

        //图片10
        ImageIcon ii10 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\10.png");
        JLabel jl10 = new JLabel(ii10);
        jl10.setBounds(100 + 50, 200 + 90, 100, 100);
        this.add(jl10);

        //图片11
        ImageIcon ii11 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\11.png");
        JLabel jl11 = new JLabel(ii11);
        jl11.setBounds(200 + 50, 200 + 90, 100, 100);
        this.add(jl11);

        //图片12
        ImageIcon ii12 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\12.png");
        JLabel jl12 = new JLabel(ii12);
        jl12.setBounds(300 + 50, 200 + 90, 100, 100);
        this.add(jl12);

        //图片13
        ImageIcon ii13 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\13.png");
        JLabel jl13 = new JLabel(ii13);
        jl13.setBounds(0 + 50, 300 + 90, 100, 100);
        this.add(jl13);

        //图片14
        ImageIcon ii14 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\14.png");
        JLabel jl14 = new JLabel(ii14);
        jl14.setBounds(100 + 50, 300 + 90, 100, 100);
        this.add(jl14);

        //图片15
        ImageIcon ii15 = new ImageIcon("E:\\muke\\test\\stonegame\\image\\15.png");
        JLabel jl15 = new JLabel(ii15);
        jl15.setBounds(200 + 50, 300 + 90, 100, 100);
        this.add(jl15);*/

/*        for (int i = 1; i <= 4; i++) {
            ImageIcon image = new ImageIcon("./stonegame//image//" + i + ".png");
            JLabel jl = new JLabel(image);
            jl.setBounds((i - 1) * 100 + 50, 90, 100, 100);
            this.add(jl);
        }*/

        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                int data = datas[i][j];
                if (data != 0) {
                    ImageIcon image = new ImageIcon("./stonegame//image//" + data + ".png");
                    JLabel jl = new JLabel(image);
                    jl.setBounds(j * 100 + 50, i * 100 + 90, 100, 100);
                    this.add(jl);
                } else {

                }
            }
        }

        //背景图片
        ImageIcon bg = new ImageIcon("./stonegame//image//background.png");
        JLabel jl16 = new JLabel(bg);
        jl16.setBounds(26, 30, 450, 484);
        this.add(jl16);
    }
}
