package TeamProject;

import java.util.Random;

public class SecretChest {
    private String item;
    private boolean isOpened;

    private static final String[] ITEMS = {
        "자원 증가",
        "자원 차감",
        "화약 증가",
        "낚시대",
        "창",
        "해군 피해가기",
        "보물"
    };

    public SecretChest() {
        Random random = new Random();
        int randomNumber = random.nextInt(13);

        this.item = mapNumberToItem(randomNumber);
        this.isOpened = false;
    }

    private String mapNumberToItem(int number) {
        if (number >= 0 && number <= 1) return "자원 증가";
        if (number == 2) return "자원 차감";
        if (number >= 3 && number <= 4) return "화약 증가";
        if (number >= 5 && number <= 6) return "낚시대";
        if (number >= 7 && number <= 8) return "창";
        if (number >= 9 && number <= 10) return "해군 피해가기";
        if (number >= 11 && number <= 12) return "보물";
        return "알 수 없는 아이템";
    }

    public String openChest() {
        if (isOpened) {
            System.out.println("이미 열린 상자입니다!");
            return null;
        } else {
            isOpened = true;
            System.out.println("상자를 열었습니다! 나온 아이템: " + item);
            return item;
        }
    }

    public boolean isChestOpened() {
        return isOpened;
    }

    public String peekItem() {
        return item;
    }
}