package temproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10);

        List<Item> itemPool = new ArrayList<>();
        itemPool.add(new Item("자원 증가"));
        itemPool.add(new Item("자원 차감"));
        itemPool.add(new Item("해군 피해가기"));

        Random random = new Random();
        int randomIndex = random.nextInt(itemPool.size());
        Item randomItem = itemPool.get(randomIndex);
        
        System.out.println(randomItem.getName() + " 아이템을 획득했습니다!");
        
        if (randomItem.getName().equals("해군 피해가기")) {
            player.addNavyAvoidItem(randomItem);
        } else {
            randomItem.use(player);
        }

        player.showInventory();
    }
}