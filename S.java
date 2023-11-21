class Element {
    int klucz;

    public Element(int klucz) {
        this.klucz = klucz;
    }
}

public class S {

    public static void main(String[] args) {
        int[] tablica = {4, 2, 5, 3, 1, 4, 2, 5, 3};
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
            sortowaniePrzezZliczanie(tablica);
            pozycjaCyfry = pozycjaCyfry * 10;
        }
    }
    public static void wyswietlTablice(int[] tablica) {
        for (int i : tablica) {
            System.out.print(i + " ");
        }
        System.out.println();
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

    public static void sortowaniePrzezZliczanie(int[] tablica) {
        int n = tablica.length;
        Element[] d = new Element[n];
        Element[] b = new Element[n];
        int[] L = new int[10];

        for (int i = 0; i < L.length; i++) {
            L[i] = 0;
        }

        for (int i = 0; i < n; i++) {
            d[i] = new Element(tablica[i]);
            L[d[i].klucz]++;
        }

        for (int i = 1; i < L.length; i++) {
            L[i] += L[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            b[L[d[i].klucz] - 1] = d[i];
            L[d[i].klucz]--;
        }

        for (int i = 0; i < n; i++) {
            tablica[i] = b[i].klucz;
        }
    }
}