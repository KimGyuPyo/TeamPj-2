package TeamProject;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int health;
    private int pp;
    private List<Item> inventory;

    public Player(int initialHealth) {
        this.health = initialHealth;
        this.pp = 0;
        this.inventory = new ArrayList<>();
    }

    public void addItem(Item item, char currentTile) {
        inventory.add(item);
        System.out.println(item.getName() + " 아이템이 추가되었습니다!");
    }

    public void showInventory() {
        System.out.println("현재 인벤토리:");
        if (inventory.isEmpty()) {
            System.out.println("인벤토리가 비어 있습니다.");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    public void useFishingRod(char currentTile) {
        if (currentTile == 's') {
            System.out.println("낚시대를 사용하여 체력이 3만큼 증가했습니다!");
            increaseHealth(3);
        } else {
            System.out.println("낚시대는 바다에서만 사용할 수 있습니다.");
        }
    }

    public void useLearningdevice(char currentTile) {
        if (currentTile == 'g') {
            System.out.println("학습장치를 사용하여 PP가 3만큼 증가했습니다!");
            increasePp(3);
        } else {
            System.out.println("학습장치는 땅에서만 사용할 수 있습니다.");
        }
    }

    public void useHealthIncrease() {
        increaseHealth(3);
        System.out.println("체력이 3만큼 증가했습니다!");
    }

    public void useHealthDecrease() {
        decreaseHealth(2);
        System.out.println("체력이 2만큼 감소했습니다.");
    }

    public void usePpIncrease() {
        increasePp(5);
        System.out.println("PP가 5만큼 증가했습니다!");
    }

    public void useMetamong() {
        System.out.println("메타몽을 사용하여 로켓단으로부터 도망쳤습니다!");
    }

    public void increaseHealth(int amount) {
        health += amount;
    }

    public void decreaseHealth(int amount) {
        health -= amount;
        if (health < 0) health = 0;
    }

    public void increasePp(int amount) {
        pp += amount;
    }

    public int getHealth() {
        return health;
    }

    public int getPp() {
        return pp;
    }
    
}