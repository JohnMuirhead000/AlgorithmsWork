//A class which has the input of a key, so long as the key is a 'comparable' type
public class MaxPQ <Key extends Comparable<Key>> {

    //An array of keys values
    private Key[] pq;
    private int N = 0;


    //The constructor for our MaxPQ, casts the input as an array of keys
    public MaxPQ(int maxN)
    {  pq = (Key[]) new Comparable[maxN+1];  }


    //Sees if the que is empty
    public boolean isEmpty()
    {  return N == 0;  }


    public int size()
    {  return N;  }


    public void insert(Key v)
    {
        pq[N] = v;
        N++;
        swim(N);
    }

    //N++  returns then modifies
    //++N  modifies then returns


    public Key delMax()
    {
        Key max = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    //Helper function
    private void swim(int k)
    {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    //Helper function
    private void sink(int k)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    //Helper function
    private boolean less(int i, int j)
    { return pq[i].compareTo(pq[j]) < 0; }

    //Helper function
    private void exch(int i, int j)
    {  Key t = pq[i]; pq[i] = pq[j]; pq[j] = t;  }

}


