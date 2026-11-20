package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v0;
import androidx.core.util.f;
import androidx.core.util.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f<ArrayList<T>> f7539a = new g(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0<T, ArrayList<T>> f7540b = new v0<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<T> f7541c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet<T> f7542d = new HashSet<>();

    public void a(@NonNull T t11, @NonNull T t12) {
        if (!this.f7540b.containsKey(t11) || !this.f7540b.containsKey(t12)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> arrayListF = this.f7540b.get(t11);
        if (arrayListF == null) {
            arrayListF = f();
            this.f7540b.put(t11, arrayListF);
        }
        arrayListF.add(t12);
    }

    public void b(@NonNull T t11) {
        if (this.f7540b.containsKey(t11)) {
            return;
        }
        this.f7540b.put(t11, null);
    }

    public void c() {
        int size = this.f7540b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList<T> arrayListValueAt = this.f7540b.valueAt(i11);
            if (arrayListValueAt != null) {
                k(arrayListValueAt);
            }
        }
        this.f7540b.clear();
    }

    public boolean d(@NonNull T t11) {
        return this.f7540b.containsKey(t11);
    }

    public final void e(T t11, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (arrayList.contains(t11)) {
            return;
        }
        if (hashSet.contains(t11)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(t11);
        ArrayList<T> arrayList2 = this.f7540b.get(t11);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i11 = 0; i11 < size; i11++) {
                e(arrayList2.get(i11), arrayList, hashSet);
            }
        }
        hashSet.remove(t11);
        arrayList.add(t11);
    }

    @NonNull
    public final ArrayList<T> f() {
        ArrayList<T> arrayListAcquire = this.f7539a.acquire();
        return arrayListAcquire == null ? new ArrayList<>() : arrayListAcquire;
    }

    @Nullable
    public List g(@NonNull T t11) {
        return this.f7540b.get(t11);
    }

    @Nullable
    public List<T> h(@NonNull T t11) {
        int size = this.f7540b.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList<T> arrayListValueAt = this.f7540b.valueAt(i11);
            if (arrayListValueAt != null && arrayListValueAt.contains(t11)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f7540b.keyAt(i11));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> i() {
        this.f7541c.clear();
        this.f7542d.clear();
        int size = this.f7540b.size();
        for (int i11 = 0; i11 < size; i11++) {
            e(this.f7540b.keyAt(i11), this.f7541c, this.f7542d);
        }
        return this.f7541c;
    }

    public boolean j(@NonNull T t11) {
        int size = this.f7540b.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList<T> arrayListValueAt = this.f7540b.valueAt(i11);
            if (arrayListValueAt != null && arrayListValueAt.contains(t11)) {
                return true;
            }
        }
        return false;
    }

    public final void k(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.f7539a.release(arrayList);
    }
}
