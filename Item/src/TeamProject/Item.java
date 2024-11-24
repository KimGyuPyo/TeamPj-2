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
            case "자원 증가":
                player.increaseResource(2);
                System.out.println("자원 증가 아이템이 사용되었습니다! 자원이 2만큼 증가했습니다. 현재 자원: " + player.getResource());
                break;

            case "자원 차감":
                player.decreaseResource(2);
                System.out.println("자원 차감 아이템이 사용되었습니다! 자원이 2만큼 감소했습니다. 현재 자원: " + player.getResource());
                break;

            case "화약 증가":
                player.increaseGunpowder(2);
                System.out.println("화약 증가 아이템이 사용되었습니다! 화약이 2만큼 증가했습니다. 현재 화약: " + player.getGunpowder());
                break;

            case "젊음의 물약":
                player.increaseTurns(3);
                System.out.println("젊음의 물약 아이템이 사용되었습니다! 턴이 3만큼 증가했습니다. 현재 턴: " + player.getTurns());
                break;

            case "해군 피해가기":
                System.out.println("해군 피해가기 아이템이 사용되었습니다! 해군에서 벗어났습니다.");
                player.removeItemFromInventory(this);
                break;

            case "낚시대":
                if (currentTile == 's') {
                    player.increaseResource(3);
                    System.out.println("낚시대를 사용했습니다! 물고기를 잡았습니다! 자원이 3만큼 증가했습니다. 현재 자원: " + player.getResource());
                    player.removeItemFromInventory(this);
                } else {
                    System.out.println("낚시대는 바다에서만 사용할 수 있습니다!");
                }
                break;

            case "창":
                if (currentTile == 'g') {
                    player.increaseResource(3);
                    System.out.println("창을 사용했습니다! 사냥에 성공했습니다! 자원이 3만큼 증가했습니다. 현재 자원: " + player.getResource());
                    player.removeItemFromInventory(this);
                } else {
                    System.out.println("창은 육지에서만 사용할 수 있습니다!");
                }
                break;

            default:
                System.out.println(name + " 아이템은 알 수 없는 아이템입니다.");
        }
    }

    public boolean isImmediatelyUsable() {
        return name.equals("자원 증가") || name.equals("자원 차감") || name.equals("화약 증가") || name.equals("젊음의 물약");
    }
}