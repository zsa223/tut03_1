package semaphore;

public class Discounter {
    static int kundenZahl = 20;
    static Discounter aldi = new Discounter();
    static int counter = 0;

    public boolean einkaufen(Kunde kunde) {
        if (counter == 0) {
            counter++;
            System.out.println("discounter.Kunde " + kunde.kundenNr + " darf einkaufen");
            try {
                Thread.sleep(1000 + (int) (Math.random() * 4000));
            } catch (InterruptedException ie) {}
            System.out.println("discounter.Kunde " + kunde.kundenNr + " geht");
            counter--;
            return true;
        }
        else
            return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < kundenZahl; i++) {
            new Kunde(i, aldi).start();
        }
    }
}
