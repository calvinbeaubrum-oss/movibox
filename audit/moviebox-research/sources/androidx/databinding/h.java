package androidx.databinding;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends c<j.a, j, b> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final androidx.core.util.h<b> f8178g = new androidx.core.util.h<>(10);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c.a<j.a, j, b> f8179h = new a();

    /* JADX INFO: compiled from: source.java */
    public class a extends c.a<j.a, j, b> {
        @Override // androidx.databinding.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j.a aVar, j jVar, int i11, b bVar) {
            if (i11 == 1) {
                aVar.b(jVar, bVar.f8180a, bVar.f8181b);
                return;
            }
            if (i11 == 2) {
                aVar.c(jVar, bVar.f8180a, bVar.f8181b);
                return;
            }
            if (i11 == 3) {
                aVar.d(jVar, bVar.f8180a, bVar.f8182c, bVar.f8181b);
            } else if (i11 != 4) {
                aVar.a(jVar);
            } else {
                aVar.e(jVar, bVar.f8180a, bVar.f8181b);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8182c;
    }

    public h() {
        super(f8179h);
    }

    public static b n(int i11, int i12, int i13) {
        b bVarAcquire = f8178g.acquire();
        if (bVarAcquire == null) {
            bVarAcquire = new b();
        }
        bVarAcquire.f8180a = i11;
        bVarAcquire.f8182c = i12;
        bVarAcquire.f8181b = i13;
        return bVarAcquire;
    }

    @Override // androidx.databinding.c
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public synchronized void d(@NonNull j jVar, int i11, b bVar) {
        super.d(jVar, i11, bVar);
        if (bVar != null) {
            f8178g.release(bVar);
        }
    }

    public void p(@NonNull j jVar, int i11, int i12) {
        d(jVar, 1, n(i11, 0, i12));
    }

    public void q(@NonNull j jVar, int i11, int i12) {
        d(jVar, 2, n(i11, 0, i12));
    }

    public void r(@NonNull j jVar, int i11, int i12) {
        d(jVar, 4, n(i11, 0, i12));
    }
}
