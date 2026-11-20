package p4;

import androidx.annotation.Nullable;
import androidx.media3.common.n0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final k0 f73571d = new k0(new n0[0]);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f73572e = u0.E0(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Deprecated
    public static final androidx.media3.common.i<k0> f73573f = new androidx.media3.common.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f73574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList<n0> f73575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73576c;

    public k0(n0... n0VarArr) {
        this.f73575b = ImmutableList.copyOf(n0VarArr);
        this.f73574a = n0VarArr.length;
        f();
    }

    public static /* synthetic */ Integer e(n0 n0Var) {
        return Integer.valueOf(n0Var.f9332c);
    }

    public n0 b(int i11) {
        return this.f73575b.get(i11);
    }

    public ImmutableList<Integer> c() {
        return ImmutableList.copyOf((Collection) Lists.o(this.f73575b, new com.google.common.base.f() { // from class: p4.j0
            @Override // com.google.common.base.f
            public final Object apply(Object obj) {
                return k0.e((n0) obj);
            }
        }));
    }

    public int d(n0 n0Var) {
        int iIndexOf = this.f73575b.indexOf(n0Var);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k0.class != obj.getClass()) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return this.f73574a == k0Var.f73574a && this.f73575b.equals(k0Var.f73575b);
    }

    public final void f() {
        int i11 = 0;
        while (i11 < this.f73575b.size()) {
            int i12 = i11 + 1;
            for (int i13 = i12; i13 < this.f73575b.size(); i13++) {
                if (this.f73575b.get(i11).equals(this.f73575b.get(i13))) {
                    z3.o.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i11 = i12;
        }
    }

    public int hashCode() {
        if (this.f73576c == 0) {
            this.f73576c = this.f73575b.hashCode();
        }
        return this.f73576c;
    }
}
