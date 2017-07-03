import java.util.ArrayList;

public class ChainedHashTable<K, V> implements Map<K, V> {
    int size;
    int capacity;
    ArrayList<Pair<K, V>> bucket[];

    ChainedHashTable() {
        this(1000);
    }

    ChainedHashTable(int cap) {
        capacity = cap;
        bucket = (ArrayList<Pair<K, V>>[]) new ArrayList[cap];
        size = 0;
        for (int i = 0; i < cap; i++)
            bucket[i] = null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V get(K k) {
        int h = k.hashCode() % capacity;
        if (bucket[h] != null) {
            for (int i = 0; i < bucket[h].size(); i++) {
                Pair<K, V> p = (Pair<K, V>) bucket[h].get(i);
                if (p.key.equals(k))
                    return p.value;
            }
        }
        return null;
    }

    public void put(K k, V v) {
        int h = k.hashCode() % capacity;
        if (bucket[h] == null)
            bucket[h] = new ArrayList<>();
        for (int i = 0; i < bucket[h].size(); i++) {
            Pair<K, V> p = bucket[h].get(i);
            if (p.key.equals(k)) {
                p.value = v;
                return;
            }
        }
        bucket[h].add(new Pair<K, V>(k, v));
        size++;
    }

    public void remove(K k) {
        int h = k.hashCode() % capacity;
        if (bucket[h] != null) {
            for (int i = 0; i < bucket[h].size(); i++) {
                Pair<K, V> p = bucket[h].get(i);
                if (p.key.equals(k)) {
                    bucket[h].remove(i);
                    size--;
                    return;
                }
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < capacity; i++) {
            if (bucket[i] != null) {
                System.out.print("" + i + ": ");
                for (int j = 0; j < bucket[i].size(); j++) {
                    Pair<K, V> p = bucket[i].get(j);
                    System.out.print("(" + p.key + " " + p.value + ") ");
                }
                System.out.println();
            }
        }
    }
}

