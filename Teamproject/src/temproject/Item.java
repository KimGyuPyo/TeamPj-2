package temproject;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use(Player player) {
        switch (name) {
            case "자원 증가":
                player.increaseResource(2);
                System.out.println("자원이 2만큼 증가했습니다! 현재 자원: " + player.getResource());
                break;

            case "자원 차감":
                player.decreaseResource(2);
                System.out.println("자원이 2만큼 감소했습니다! 현재 자원: " + player.getResource());
                break;

            case "해군 피해가기":
                System.out.println("해군 피해가기 아이템이 사용되었습니다! 해군의 위협에서 안전합니다.");
                player.useNavyAvoidItem();
                break;

            default:
                System.out.println("알 수 없는 아이템입니다.");
                break;
        }
    }
}

class Player {
    private int resource;
    private List<Item> inventory;

    public Player(int initialResource) {
        this.resource = initialResource;
        this.inventory = new ArrayList<>();
    }

    public int getResource() {
        return resource;
    }

    public void increaseResource(int amount) {
        resource += amount;
    }

    public void decreaseResource(int amount) {
        resource -= amount;
        if (resource < 0) resource = 0;
    }

    public void addNavyAvoidItem(Item item) {
        inventory.add(item);
        System.out.println(item.getName() + " 아이템을 획득했습니다!");
    }

    public void useNavyAvoidItem() {
        boolean hasItem = inventory.removeIf(item -> item.getName().equals("해군 피해가기"));
        if (hasItem) {
            System.out.println("해군 피해가기 아이템을 성공적으로 사용했습니다!");
        } else {
            System.out.println("해군 피해가기 아이템이 없습니다!");
        }
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