package vg;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.c0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f78812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f78813b;

    public f(int i11, ImmutableList<a> immutableList) {
        this.f78813b = i11;
        this.f78812a = immutableList;
    }

    @Nullable
    public static a a(int i11, int i12, c0 c0Var) {
        switch (i11) {
            case 1718776947:
                return g.d(i12, c0Var);
            case 1751742049:
                return c.b(c0Var);
            case 1752331379:
                return d.c(c0Var);
            case 1852994675:
                return h.a(c0Var);
            default:
                return null;
        }
    }

    public static f c(int i11, c0 c0Var) {
        ImmutableList.a aVar = new ImmutableList.a();
        int iF = c0Var.f();
        int iB = -2;
        while (c0Var.a() > 8) {
            int iQ = c0Var.q();
            int iE = c0Var.e() + c0Var.q();
            c0Var.O(iE);
            a aVarC = iQ == 1414744396 ? c(c0Var.q(), c0Var) : a(iQ, iB, c0Var);
            if (aVarC != null) {
                if (aVarC.getType() == 1752331379) {
                    iB = ((d) aVarC).b();
                }
                aVar.a(aVarC);
            }
            c0Var.P(iE);
            c0Var.O(iF);
        }
        return new f(i11, aVar.m());
    }

    @Nullable
    public <T extends a> T b(Class<T> cls) {
        g1<a> it = this.f78812a.iterator();
        while (it.hasNext()) {
            T t11 = (T) it.next();
            if (t11.getClass() == cls) {
                return t11;
            }
        }
        return null;
    }

    @Override // vg.a
    public int getType() {
        return this.f78813b;
    }
}
