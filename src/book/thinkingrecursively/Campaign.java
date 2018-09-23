package book.thinkingrecursively;

public class Campaign {
    public static void main(String[] args) {
        int dollar = 1000;
        int people = 10;
        runCampaign(dollar, people);
    }

    private static void runCampaign(int dollar, int people) {
        if (dollar == 1) {
            System.out.println("Raised $1");
        } else {
            int raiseDollar = dollar / people;
            for (int i = 0; i < people; i++) {
                runCampaign(raiseDollar, people);
            }
        }
    }
}
