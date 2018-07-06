package table;

import android.support.annotation.NonNull;

public class Entry implements Comparable {
    public String label;
    public int value;
    public float angle;
    public int color;

    public Entry(String label, int value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public int compareTo(@NonNull Object o) {
        Entry e = (Entry) o;
        if (value > e.value)
            return -1;
        if (value < e.value)
            return 1;
        return 0;
    }
}


