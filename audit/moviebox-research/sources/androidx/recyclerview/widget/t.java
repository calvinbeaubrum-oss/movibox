package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.v;
import androidx.collection.v0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<RecyclerView.a0, a> f12708a = new v0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v<RecyclerView.a0> f12709b = new v<>();

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static androidx.core.util.f<a> f12710d = new androidx.core.util.g(20);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public RecyclerView.j.c f12712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public RecyclerView.j.c f12713c;

        public static void a() {
            while (f12710d.acquire() != null) {
            }
        }

        public static a b() {
            a aVarAcquire = f12710d.acquire();
            return aVarAcquire == null ? new a() : aVarAcquire;
        }

        public static void c(a aVar) {
            aVar.f12711a = 0;
            aVar.f12712b = null;
            aVar.f12713c = null;
            f12710d.release(aVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(RecyclerView.a0 a0Var, @Nullable RecyclerView.j.c cVar, RecyclerView.j.c cVar2);

        void b(RecyclerView.a0 a0Var);

        void c(RecyclerView.a0 a0Var, @NonNull RecyclerView.j.c cVar, @Nullable RecyclerView.j.c cVar2);

        void d(RecyclerView.a0 a0Var, @NonNull RecyclerView.j.c cVar, @NonNull RecyclerView.j.c cVar2);
    }

    public void a(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a aVarB = this.f12708a.get(a0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f12708a.put(a0Var, aVarB);
        }
        aVarB.f12711a |= 2;
        aVarB.f12712b = cVar;
    }

    public void b(RecyclerView.a0 a0Var) {
        a aVarB = this.f12708a.get(a0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f12708a.put(a0Var, aVarB);
        }
        aVarB.f12711a |= 1;
    }

    public void c(long j11, RecyclerView.a0 a0Var) {
        this.f12709b.l(j11, a0Var);
    }

    public void d(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a aVarB = this.f12708a.get(a0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f12708a.put(a0Var, aVarB);
        }
        aVarB.f12713c = cVar;
        aVarB.f12711a |= 8;
    }

    public void e(RecyclerView.a0 a0Var, RecyclerView.j.c cVar) {
        a aVarB = this.f12708a.get(a0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.f12708a.put(a0Var, aVarB);
        }
        aVarB.f12712b = cVar;
        aVarB.f12711a |= 4;
    }

    public void f() {
        this.f12708a.clear();
        this.f12709b.b();
    }

    public RecyclerView.a0 g(long j11) {
        return this.f12709b.f(j11);
    }

    public boolean h(RecyclerView.a0 a0Var) {
        a aVar = this.f12708a.get(a0Var);
        return (aVar == null || (aVar.f12711a & 1) == 0) ? false : true;
    }

    public boolean i(RecyclerView.a0 a0Var) {
        a aVar = this.f12708a.get(a0Var);
        return (aVar == null || (aVar.f12711a & 4) == 0) ? false : true;
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.a0 a0Var) {
        p(a0Var);
    }

    public final RecyclerView.j.c l(RecyclerView.a0 a0Var, int i11) {
        a aVarValueAt;
        RecyclerView.j.c cVar;
        int iIndexOfKey = this.f12708a.indexOfKey(a0Var);
        if (iIndexOfKey >= 0 && (aVarValueAt = this.f12708a.valueAt(iIndexOfKey)) != null) {
            int i12 = aVarValueAt.f12711a;
            if ((i12 & i11) != 0) {
                int i13 = (~i11) & i12;
                aVarValueAt.f12711a = i13;
                if (i11 == 4) {
                    cVar = aVarValueAt.f12712b;
                } else {
                    if (i11 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarValueAt.f12713c;
                }
                if ((i13 & 12) == 0) {
                    this.f12708a.removeAt(iIndexOfKey);
                    a.c(aVarValueAt);
                }
                return cVar;
            }
        }
        return null;
    }

    @Nullable
    public RecyclerView.j.c m(RecyclerView.a0 a0Var) {
        return l(a0Var, 8);
    }

    @Nullable
    public RecyclerView.j.c n(RecyclerView.a0 a0Var) {
        return l(a0Var, 4);
    }

    public void o(b bVar) {
        for (int size = this.f12708a.size() - 1; size >= 0; size--) {
            RecyclerView.a0 a0VarKeyAt = this.f12708a.keyAt(size);
            a aVarRemoveAt = this.f12708a.removeAt(size);
            int i11 = aVarRemoveAt.f12711a;
            if ((i11 & 3) == 3) {
                bVar.b(a0VarKeyAt);
            } else if ((i11 & 1) != 0) {
                RecyclerView.j.c cVar = aVarRemoveAt.f12712b;
                if (cVar == null) {
                    bVar.b(a0VarKeyAt);
                } else {
                    bVar.c(a0VarKeyAt, cVar, aVarRemoveAt.f12713c);
                }
            } else if ((i11 & 14) == 14) {
                bVar.a(a0VarKeyAt, aVarRemoveAt.f12712b, aVarRemoveAt.f12713c);
            } else if ((i11 & 12) == 12) {
                bVar.d(a0VarKeyAt, aVarRemoveAt.f12712b, aVarRemoveAt.f12713c);
            } else if ((i11 & 4) != 0) {
                bVar.c(a0VarKeyAt, aVarRemoveAt.f12712b, null);
            } else if ((i11 & 8) != 0) {
                bVar.a(a0VarKeyAt, aVarRemoveAt.f12712b, aVarRemoveAt.f12713c);
            }
            a.c(aVarRemoveAt);
        }
    }

    public void p(RecyclerView.a0 a0Var) {
        a aVar = this.f12708a.get(a0Var);
        if (aVar == null) {
            return;
        }
        aVar.f12711a &= -2;
    }

    public void q(RecyclerView.a0 a0Var) {
        for (int iO = this.f12709b.o() - 1; iO >= 0; iO--) {
            if (a0Var == this.f12709b.p(iO)) {
                this.f12709b.n(iO);
                break;
            }
        }
        a aVarRemove = this.f12708a.remove(a0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
