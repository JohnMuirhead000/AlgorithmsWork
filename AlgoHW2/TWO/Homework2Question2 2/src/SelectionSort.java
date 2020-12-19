class SelectionSort {

   public static void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++)
                if (less(a, j, min))
                    min = j;

            Comparable temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    private static boolean less(Comparable[] a, int i, int j)
    { return a[i].compareTo(a[j]) < 0; }

}
