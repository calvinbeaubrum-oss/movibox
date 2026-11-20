package pg;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.google.android.datatransport.Priority;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SparseArray<Priority> f73777a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<Priority, Integer> f73778b;

    static {
        HashMap<Priority, Integer> map = new HashMap<>();
        f73778b = map;
        map.put(Priority.DEFAULT, 0);
        f73778b.put(Priority.VERY_LOW, 1);
        f73778b.put(Priority.HIGHEST, 2);
        for (Priority priority : f73778b.keySet()) {
            f73777a.append(f73778b.get(priority).intValue(), priority);
        }
    }

    public static int a(@NonNull Priority priority) {
        Integer num = f73778b.get(priority);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority);
    }

    @NonNull
    public static Priority b(int i11) {
        Priority priority = f73777a.get(i11);
        if (priority != null) {
            return priority;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i11);
    }
}
