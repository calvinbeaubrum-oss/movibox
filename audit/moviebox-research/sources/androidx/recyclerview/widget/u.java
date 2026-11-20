package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface u {

    /* JADX INFO: compiled from: source.java */
    public static class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<k> f12714a = new SparseArray<>();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12715b = 0;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class C0117a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public SparseIntArray f12716a = new SparseIntArray(1);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public SparseIntArray f12717b = new SparseIntArray(1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final k f12718c;

            public C0117a(k kVar) {
                this.f12718c = kVar;
            }

            @Override // androidx.recyclerview.widget.u.c
            public int a(int i11) {
                int iIndexOfKey = this.f12717b.indexOfKey(i11);
                if (iIndexOfKey >= 0) {
                    return this.f12717b.valueAt(iIndexOfKey);
                }
                throw new IllegalStateException("requested global type " + i11 + " does not belong to the adapter:" + this.f12718c.f12680c);
            }

            @Override // androidx.recyclerview.widget.u.c
            public int b(int i11) {
                int iIndexOfKey = this.f12716a.indexOfKey(i11);
                if (iIndexOfKey > -1) {
                    return this.f12716a.valueAt(iIndexOfKey);
                }
                int iC = a.this.c(this.f12718c);
                this.f12716a.put(i11, iC);
                this.f12717b.put(iC, i11);
                return iC;
            }
        }

        @Override // androidx.recyclerview.widget.u
        @NonNull
        public k a(int i11) {
            k kVar = this.f12714a.get(i11);
            if (kVar != null) {
                return kVar;
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        @Override // androidx.recyclerview.widget.u
        @NonNull
        public c b(@NonNull k kVar) {
            return new C0117a(kVar);
        }

        public int c(k kVar) {
            int i11 = this.f12715b;
            this.f12715b = i11 + 1;
            this.f12714a.put(i11, kVar);
            return i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SparseArray<List<k>> f12720a = new SparseArray<>();

        /* JADX INFO: compiled from: source.java */
        public class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final k f12721a;

            public a(k kVar) {
                this.f12721a = kVar;
            }

            @Override // androidx.recyclerview.widget.u.c
            public int a(int i11) {
                return i11;
            }

            @Override // androidx.recyclerview.widget.u.c
            public int b(int i11) {
                List<k> arrayList = b.this.f12720a.get(i11);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    b.this.f12720a.put(i11, arrayList);
                }
                if (!arrayList.contains(this.f12721a)) {
                    arrayList.add(this.f12721a);
                }
                return i11;
            }
        }

        @Override // androidx.recyclerview.widget.u
        @NonNull
        public k a(int i11) {
            List<k> list = this.f12720a.get(i11);
            if (list != null && !list.isEmpty()) {
                return list.get(0);
            }
            throw new IllegalArgumentException("Cannot find the wrapper for global view type " + i11);
        }

        @Override // androidx.recyclerview.widget.u
        @NonNull
        public c b(@NonNull k kVar) {
            return new a(kVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        int a(int i11);

        int b(int i11);
    }

    @NonNull
    k a(int i11);

    @NonNull
    c b(@NonNull k kVar);
}
