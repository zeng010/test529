/**
 * @author: Zzz_tjhd
 * @date: 2020-09-02 22:31
 */
public class Phone {
    String name = "小米";
    int price = 999;
    String color = "红色";

    public void call(String name) {
        System.out.println("给"+name+"打电话...");
        sendMessage();
    }

    public void sendMessage() {
        System.out.println("发短信...");
    }

    public void playGame() {
        System.out.println("玩游戏...");
    }
}
