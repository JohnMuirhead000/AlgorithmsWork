public class Heapsort {

    public static Comparable[] sort(Comparable[] a) {
        int size  = a.length;
        for(int i = size/2 - 1;i >= 0; i--) { heapify(a, size, i); }
        for(int i = size - 1; i > 0; i-- )
        {
            exch(a, 0, i);
            heapify(a, i, 0);
        }
        return a;
    }

    public static void heapify(Comparable[] a, int n, int i) {
        int big = i;
        int left = 2*i + 1;
        int right = 2*i;
        if (left < n && less(a,big,left)){ big = left; }
        if (right < n && less(a, big, right)) { big = right; }

        if (big != i)
        {
            exch(a,i,big);
            heapify(a, n, big);
        }
    }

    private static void exch(Comparable[] a, int b, int c){

        Comparable temp = a[b];
        a[b] = a[c];
        a[c] = temp;

    }

    private static boolean less(Comparable[] a, int i, int j)
    { return a[i].compareTo(a[j]) < 0; }
}