package TeamProject;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(10);


        Item resourceIncrease = new Item("자원 증가");
        Item resourceDecrease = new Item("자원 차감");
        Item gunpowderIncrease = new Item("화약 증가");
        Item youthPotion = new Item("젊음의 물약");


        Item navyAvoid = new Item("해군 피해가기");
        Item fishingRod = new Item("낚시대");
        Item spear = new Item("창");

        player.addItem(resourceIncrease, ' ');
        player.addItem(resourceDecrease, ' ');
        player.addItem(gunpowderIncrease, ' ');
        player.addItem(youthPotion, ' ');

       
        player.addItem(navyAvoid, ' ');
        player.addItem(fishingRod, 's');
        player.addItem(spear, 'g');


        player.showInventory();


        char currentTile = 's';
        System.out.println("\n현재 타일: " + currentTile);
        fishingRod.use(player, currentTile);
        spear.use(player, currentTile);

        currentTile = 'g';
        System.out.println("\n현재 타일: " + currentTile);
        fishingRod.use(player, currentTile);
        spear.use(player, currentTile);

        player.showInventory();
    }
}
