public class Sortowania {

    public static void main(String[] args) {
        int[] tablica = {1, 7, 2, 8, 12, 34};
        sortowaniePozycyjne(tablica);
        wyswietlTablice(tablica);
    }

    public static void sortowaniePozycyjne(int[] tablica) {
        if (tablica == null || tablica.length == 0) {
            return;
        }
        int max = znajdzMaksimum(tablica);
        int pozycjaCyfry = 1;
        while (max / pozycjaCyfry > 0) {
            sortowaniePrzezZliczanie(tablica, pozycjaCyfry);
            pozycjaCyfry = pozycjaCyfry*10;
        }
    }
    public static int znajdzMaksimum(int[] tablica) {
        int max = tablica[0];
        for (int i = 1; i < tablica.length; i++) {
            if (tablica[i] > max) {
                max = tablica[i];
            }
        }
        return max;
    }
    public static void wyswietlTablice(int[] tablica) {
        for (int i : tablica) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void sortowaniePrzezZliczanie(int[] tablica, int pozycjaCyfry) {
        int n = tablica.length;
        int[] wynik = new int[n];
        int[] zliczenia = new int[10];

        for (int i = 0; i < 10; i++) {
            zliczenia[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            zliczenia[(tablica[i] / pozycjaCyfry) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            zliczenia[i] += zliczenia[i - 1];
        }


        for (int i = n - 1; i >= 0; i--) {
            int cyfra = (tablica[i] / pozycjaCyfry) % 10;
            int indeks = zliczenia[cyfra] - 1;
            wynik[indeks] = tablica[i];
            zliczenia[cyfra]--;
        }


        for (int i = 0; i < n; i++) {
            tablica[i] = wynik[i];
        }
    }
}