package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseIntArray f7476a = new SparseIntArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public HashMap<Integer, HashSet<WeakReference<a>>> f7477b = new HashMap<>();

    /* JADX INFO: compiled from: source.java */
    public interface a {
    }

    public void a(int i11, a aVar) {
        HashSet<WeakReference<a>> hashSet = this.f7477b.get(Integer.valueOf(i11));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.f7477b.put(Integer.valueOf(i11), hashSet);
        }
        hashSet.add(new WeakReference<>(aVar));
    }

    public void b(int i11, a aVar) {
        HashSet<WeakReference<a>> hashSet = this.f7477b.get(Integer.valueOf(i11));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (WeakReference<a> weakReference : hashSet) {
            a aVar2 = weakReference.get();
            if (aVar2 == null || aVar2 == aVar) {
                arrayList.add(weakReference);
            }
        }
        hashSet.removeAll(arrayList);
    }
}
