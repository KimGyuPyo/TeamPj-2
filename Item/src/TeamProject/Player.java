package TeamProject;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int resource;
    private int gunpowder;
    private int turns;
    private List<Item> inventory;

    private static final int MAX_INVENTORY_SIZE = 5;

    public Player(int initialResource) {
        this.resource = initialResource;
        this.gunpowder = 0;
        this.turns = 0;
        this.inventory = new ArrayList<>();
    }

    public int getResource() {
        return resource;
    }

    public int getGunpowder() {
        return gunpowder;
    }

    public int getTurns() {
        return turns;
    }

    public void increaseResource(int amount) {
        resource += amount;
    }

    public void decreaseResource(int amount) {
        resource -= amount;
        if (resource < 0) resource = 0;
    }

    public void increaseGunpowder(int amount) {
        gunpowder += amount;
    }

    public void increaseTurns(int amount) {
        turns += amount;
    }

    public void addItem(Item item, char currentTile) {
        if (item.isImmediatelyUsable()) {
            item.use(this, currentTile);
        } else {
            if (inventory.size() >= MAX_INVENTORY_SIZE) {
                System.out.println("인벤토리가 가득 찼습니다! " + item.getName() + " 아이템을 추가할 수 없습니다.");
                return;
            }
            inventory.add(item);
            System.out.println(item.getName() + " 아이템을 인벤토리에 추가했습니다!");
        }
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item);
        System.out.println(item.getName() + " 아이템이 인벤토리에서 제거되었습니다.");
    }

    public void showInventory() {
        System.out.println("현재 소지한 아이템:");
        if (inventory.isEmpty()) {
            System.out.println("없음");
        } else {
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }
}