package TeamProject;

public class Main {
    public static void main(String[] args) {

        Player player = new Player(10);


        Item healthIncrease = new Item("체력 증가");
        Item healthDecrease = new Item("체력 감소");
        Item ppIncrease = new Item("pp 증가");
        Item metamong = new Item("메타몽");
        Item fishingRod = new Item("낚시대");
        Item learningDevice = new Item("학습장치");


        System.out.println("--- 아이템 추가 ---");
        player.addItem(healthIncrease, ' '); 
        player.addItem(healthDecrease, ' ');
        player.addItem(ppIncrease, ' ');
        player.addItem(metamong, ' ');
        player.addItem(fishingRod, 's');
        player.addItem(learningDevice, 'g');


        System.out.println("\n--- 현재 인벤토리 ---");
        player.showInventory();

        char currentTile = 's';
        System.out.println("\n현재 타일: " + currentTile);


        System.out.println("\n[낚시대 사용 시도]");
        player.useFishingRod(currentTile);


        System.out.println("\n[학습장치 사용 시도]");
        player.useLearningdevice(currentTile);


        currentTile = 'g';
        System.out.println("\n현재 타일: " + currentTile);

        System.out.println("\n[낚시대 사용 시도]");
        player.useFishingRod(currentTile);

        System.out.println("\n[학습장치 사용 시도]");
        player.useLearningdevice(currentTile);

        System.out.println("\n[체력 증가 사용 시도]");
        player.useHealthIncrease();

        System.out.println("\n[체력 감소 사용 시도]");
        player.useHealthDecrease();

        System.out.println("\n[pp 증가 사용 시도]");
        player.usePpIncrease();

        System.out.println("\n[메타몽 사용 시도]");
        player.useMetamong();

        System.out.println("\n--- 최종 인벤토리 ---");
        player.showInventory();
    }
}
