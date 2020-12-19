public class LinearProbingHashST<Key, Value> {

    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;


    public LinearProbingHashST(int cap) {
        M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }


    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }


    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null) t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }


    public void put(Key key, Value val) {
        if (N >= M / 2) resize(2 * M);  // double M (see text)
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        keys[i] = key;
        vals[i] = val;
        N++;
    }


    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
            if (keys[i].equals(key))
                return vals[i];
        return null;
    }


    public boolean contain(Key key) {
        if (this.get(key) == null) {
            return false;
        } else {
            return true;
        }
    }


    public Key[] getKeys() {
        Key[] nonNullKeys = (Key[]) new Object[N];
        int i = 0;
        for (Key aKey : this.keys) {
            if (aKey != null) {
                nonNullKeys[i] = aKey;
                i++;
            }
        }
        return nonNullKeys;
    }

    public int getN(){return N;}

}



