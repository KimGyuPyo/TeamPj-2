package TeamProject;

public class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void use(Player player, char currentTile) {
        switch (name) {
            case "체력 증가":
                player.increaseHealth(2);
                System.out.println("체력 증가 아이템을 사용했습니다! 체력이 3만큼 증가했습니다. 현재 체력: " + player.getHealth());
                player.removeItemFromInventory(this);
                break;

            case "체력 감소":
                player.decreaseHealth(5);
                System.out.println("체력 감소 아이템을 사용했습니다! 체력이 2만큼 감소했습니다. 현재 체력: " + player.getHealth());
                player.removeItemFromInventory(this);
                break;

            case "pp 증가":
                player.increasePp(2);
                System.out.println("pp 증가 아이템을 사용했습니다! pp가 5만큼 증가했습니다. 현재 pp: " + player.getPp());
                player.removeItemFromInventory(this);
                break;

            case "메타몽":
                System.out.println("메타몽 아이템을 사용했습니다! 로켓단으로부터 도주했습니다.");
                player.removeItemFromInventory(this);
                break;

            case "낚시대":
                if (currentTile == 's') { // 바다 타일에서만 사용 가능
                    player.increaseHealth(3);
                    System.out.println("낚시대를 사용하여 체력이 3만큼 증가했습니다! 현재 체력: " + player.getHealth());
                } else {
                    System.out.println("낚시대는 바다에서만 사용 가능합니다.");
                }
                break;

            case "학습장치":
                if (currentTile == 'g') { 
                    player.increasePp(3);
                    System.out.println("학습장치를 사용했습니다! pp가 3만큼 증가했습니다. 현재 pp: " + player.getPp());
                } else {
                    System.out.println("학습장치는 땅에서만 사용 가능합니다.");
                }
                break;




            default:
                System.out.println(name + " 아이템은 알 수 없는 아이템입니다.");
        }
    }
}