package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DiffUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<c> f12436a = new Comparator<c>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f12439a - cVar2.f12439a;
        }
    };

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract boolean a(int i11, int i12);

        public abstract boolean b(int i11, int i12);

        @Nullable
        public Object c(int i11, int i12) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f12437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12438b;

        public b(int i11) {
            int[] iArr = new int[i11];
            this.f12437a = iArr;
            this.f12438b = iArr.length / 2;
        }

        public int[] a() {
            return this.f12437a;
        }

        public int b(int i11) {
            return this.f12437a[i11 + this.f12438b];
        }

        public void c(int i11, int i12) {
            this.f12437a[i11 + this.f12438b] = i12;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12440b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f12441c;

        public c(int i11, int i12, int i13) {
            this.f12439a = i11;
            this.f12440b = i12;
            this.f12441c = i13;
        }

        public int a() {
            return this.f12439a + this.f12441c;
        }

        public int b() {
            return this.f12440b + this.f12441c;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<c> f12442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f12443b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f12444c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a f12445d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f12446e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f12447f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f12448g;

        public d(a aVar, List<c> list, int[] iArr, int[] iArr2, boolean z11) {
            this.f12442a = list;
            this.f12443b = iArr;
            this.f12444c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f12445d = aVar;
            this.f12446e = aVar.e();
            this.f12447f = aVar.d();
            this.f12448g = z11;
            a();
            e();
        }

        @Nullable
        public static f g(Collection<f> collection, int i11, boolean z11) {
            f next;
            Iterator<f> it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.f12449a == i11 && next.f12451c == z11) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f next2 = it.next();
                if (z11) {
                    next2.f12450b--;
                } else {
                    next2.f12450b++;
                }
            }
            return next;
        }

        public final void a() {
            c cVar = this.f12442a.isEmpty() ? null : this.f12442a.get(0);
            if (cVar == null || cVar.f12439a != 0 || cVar.f12440b != 0) {
                this.f12442a.add(0, new c(0, 0, 0));
            }
            this.f12442a.add(new c(this.f12446e, this.f12447f, 0));
        }

        public void b(@NonNull j jVar) {
            int i11;
            androidx.recyclerview.widget.d dVar = jVar instanceof androidx.recyclerview.widget.d ? (androidx.recyclerview.widget.d) jVar : new androidx.recyclerview.widget.d(jVar);
            int i12 = this.f12446e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i13 = this.f12446e;
            int i14 = this.f12447f;
            for (int size = this.f12442a.size() - 1; size >= 0; size--) {
                c cVar = this.f12442a.get(size);
                int iA = cVar.a();
                int iB = cVar.b();
                while (true) {
                    if (i13 <= iA) {
                        break;
                    }
                    i13--;
                    int i15 = this.f12443b[i13];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        f fVarG = g(arrayDeque, i16, false);
                        if (fVarG != null) {
                            int i17 = (i12 - fVarG.f12450b) - 1;
                            dVar.onMoved(i13, i17);
                            if ((i15 & 4) != 0) {
                                dVar.onChanged(i17, 1, this.f12445d.c(i13, i16));
                            }
                        } else {
                            arrayDeque.add(new f(i13, (i12 - i13) - 1, true));
                        }
                    } else {
                        dVar.onRemoved(i13, 1);
                        i12--;
                    }
                }
                while (i14 > iB) {
                    i14--;
                    int i18 = this.f12444c[i14];
                    if ((i18 & 12) != 0) {
                        int i19 = i18 >> 4;
                        f fVarG2 = g(arrayDeque, i19, true);
                        if (fVarG2 == null) {
                            arrayDeque.add(new f(i14, i12 - i13, false));
                        } else {
                            dVar.onMoved((i12 - fVarG2.f12450b) - 1, i13);
                            if ((i18 & 4) != 0) {
                                dVar.onChanged(i13, 1, this.f12445d.c(i19, i14));
                            }
                        }
                    } else {
                        dVar.onInserted(i13, 1);
                        i12++;
                    }
                }
                int i21 = cVar.f12439a;
                int i22 = cVar.f12440b;
                for (i11 = 0; i11 < cVar.f12441c; i11++) {
                    if ((this.f12443b[i21] & 15) == 2) {
                        dVar.onChanged(i21, 1, this.f12445d.c(i21, i22));
                    }
                    i21++;
                    i22++;
                }
                i13 = cVar.f12439a;
                i14 = cVar.f12440b;
            }
            dVar.a();
        }

        public void c(@NonNull RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }

        public final void d(int i11) {
            int size = this.f12442a.size();
            int iB = 0;
            for (int i12 = 0; i12 < size; i12++) {
                c cVar = this.f12442a.get(i12);
                while (iB < cVar.f12440b) {
                    if (this.f12444c[iB] == 0 && this.f12445d.b(i11, iB)) {
                        int i13 = this.f12445d.a(i11, iB) ? 8 : 4;
                        this.f12443b[i11] = (iB << 4) | i13;
                        this.f12444c[iB] = (i11 << 4) | i13;
                        return;
                    }
                    iB++;
                }
                iB = cVar.b();
            }
        }

        public final void e() {
            for (c cVar : this.f12442a) {
                for (int i11 = 0; i11 < cVar.f12441c; i11++) {
                    int i12 = cVar.f12439a + i11;
                    int i13 = cVar.f12440b + i11;
                    int i14 = this.f12445d.a(i12, i13) ? 1 : 2;
                    this.f12443b[i12] = (i13 << 4) | i14;
                    this.f12444c[i13] = (i12 << 4) | i14;
                }
            }
            if (this.f12448g) {
                f();
            }
        }

        public final void f() {
            int iA = 0;
            for (c cVar : this.f12442a) {
                while (iA < cVar.f12439a) {
                    if (this.f12443b[iA] == 0) {
                        d(iA);
                    }
                    iA++;
                }
                iA = cVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class e<T> {
        public abstract boolean areContentsTheSame(@NonNull T t11, @NonNull T t12);

        public abstract boolean areItemsTheSame(@NonNull T t11, @NonNull T t12);

        @Nullable
        public Object getChangePayload(@NonNull T t11, @NonNull T t12) {
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12449a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12450b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12451c;

        public f(int i11, int i12, boolean z11) {
            this.f12449a = i11;
            this.f12450b = i12;
            this.f12451c = z11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12454c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12455d;

        public g() {
        }

        public g(int i11, int i12, int i13, int i14) {
            this.f12452a = i11;
            this.f12453b = i12;
            this.f12454c = i13;
            this.f12455d = i14;
        }

        public int a() {
            return this.f12455d - this.f12454c;
        }

        public int b() {
            return this.f12453b - this.f12452a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12457b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12458c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f12459d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f12460e;

        public int a() {
            return Math.min(this.f12458c - this.f12456a, this.f12459d - this.f12457b);
        }

        public boolean b() {
            return this.f12459d - this.f12457b != this.f12458c - this.f12456a;
        }

        public boolean c() {
            return this.f12459d - this.f12457b > this.f12458c - this.f12456a;
        }

        @NonNull
        public c d() {
            if (!b()) {
                int i11 = this.f12456a;
                return new c(i11, this.f12457b, this.f12458c - i11);
            }
            if (this.f12460e) {
                return new c(this.f12456a, this.f12457b, a());
            }
            return c() ? new c(this.f12456a, this.f12457b + 1, a()) : new c(this.f12456a + 1, this.f12457b, a());
        }
    }

    @Nullable
    public static h a(g gVar, a aVar, b bVar, b bVar2, int i11) {
        int iB;
        int i12;
        int i13;
        boolean z11 = (gVar.b() - gVar.a()) % 2 == 0;
        int iB2 = gVar.b() - gVar.a();
        int i14 = -i11;
        for (int i15 = i14; i15 <= i11; i15 += 2) {
            if (i15 == i14 || (i15 != i11 && bVar2.b(i15 + 1) < bVar2.b(i15 - 1))) {
                iB = bVar2.b(i15 + 1);
                i12 = iB;
            } else {
                iB = bVar2.b(i15 - 1);
                i12 = iB - 1;
            }
            int i16 = gVar.f12455d - ((gVar.f12453b - i12) - i15);
            int i17 = (i11 == 0 || i12 != iB) ? i16 : i16 + 1;
            while (i12 > gVar.f12452a && i16 > gVar.f12454c && aVar.b(i12 - 1, i16 - 1)) {
                i12--;
                i16--;
            }
            bVar2.c(i15, i12);
            if (z11 && (i13 = iB2 - i15) >= i14 && i13 <= i11 && bVar.b(i13) >= i12) {
                h hVar = new h();
                hVar.f12456a = i12;
                hVar.f12457b = i16;
                hVar.f12458c = iB;
                hVar.f12459d = i17;
                hVar.f12460e = true;
                return hVar;
            }
        }
        return null;
    }

    @NonNull
    public static d b(@NonNull a aVar) {
        return c(aVar, true);
    }

    @NonNull
    public static d c(@NonNull a aVar, boolean z11) {
        int iE = aVar.e();
        int iD = aVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(0, iE, 0, iD));
        int i11 = ((((iE + iD) + 1) / 2) * 2) + 1;
        b bVar = new b(i11);
        b bVar2 = new b(i11);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            g gVar = (g) arrayList2.remove(arrayList2.size() - 1);
            h hVarE = e(gVar, aVar, bVar, bVar2);
            if (hVarE != null) {
                if (hVarE.a() > 0) {
                    arrayList.add(hVarE.d());
                }
                g gVar2 = arrayList3.isEmpty() ? new g() : (g) arrayList3.remove(arrayList3.size() - 1);
                gVar2.f12452a = gVar.f12452a;
                gVar2.f12454c = gVar.f12454c;
                gVar2.f12453b = hVarE.f12456a;
                gVar2.f12455d = hVarE.f12457b;
                arrayList2.add(gVar2);
                gVar.f12453b = gVar.f12453b;
                gVar.f12455d = gVar.f12455d;
                gVar.f12452a = hVarE.f12458c;
                gVar.f12454c = hVarE.f12459d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f12436a);
        return new d(aVar, arrayList, bVar.a(), bVar2.a(), z11);
    }

    @Nullable
    public static h d(g gVar, a aVar, b bVar, b bVar2, int i11) {
        int iB;
        int i12;
        int i13;
        boolean z11 = Math.abs(gVar.b() - gVar.a()) % 2 == 1;
        int iB2 = gVar.b() - gVar.a();
        int i14 = -i11;
        for (int i15 = i14; i15 <= i11; i15 += 2) {
            if (i15 == i14 || (i15 != i11 && bVar.b(i15 + 1) > bVar.b(i15 - 1))) {
                iB = bVar.b(i15 + 1);
                i12 = iB;
            } else {
                iB = bVar.b(i15 - 1);
                i12 = iB + 1;
            }
            int i16 = (gVar.f12454c + (i12 - gVar.f12452a)) - i15;
            int i17 = (i11 == 0 || i12 != iB) ? i16 : i16 - 1;
            while (i12 < gVar.f12453b && i16 < gVar.f12455d && aVar.b(i12, i16)) {
                i12++;
                i16++;
            }
            bVar.c(i15, i12);
            if (z11 && (i13 = iB2 - i15) >= i14 + 1 && i13 <= i11 - 1 && bVar2.b(i13) <= i12) {
                h hVar = new h();
                hVar.f12456a = iB;
                hVar.f12457b = i17;
                hVar.f12458c = i12;
                hVar.f12459d = i16;
                hVar.f12460e = false;
                return hVar;
            }
        }
        return null;
    }

    @Nullable
    public static h e(g gVar, a aVar, b bVar, b bVar2) {
        if (gVar.b() >= 1 && gVar.a() >= 1) {
            int iB = ((gVar.b() + gVar.a()) + 1) / 2;
            bVar.c(1, gVar.f12452a);
            bVar2.c(1, gVar.f12453b);
            for (int i11 = 0; i11 < iB; i11++) {
                h hVarD = d(gVar, aVar, bVar, bVar2, i11);
                if (hVarD != null) {
                    return hVarD;
                }
                h hVarA = a(gVar, aVar, bVar, bVar2, i11);
                if (hVarA != null) {
                    return hVarA;
                }
            }
        }
        return null;
    }
}
