package w4;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g1;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImmutableList<a> f79284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f79285b;

    public f(int i11, ImmutableList<a> immutableList) {
        this.f79285b = i11;
        this.f79284a = immutableList;
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
        int iG = c0Var.g();
        int iB = -2;
        while (c0Var.a() > 8) {
            int iU = c0Var.u();
            int iF = c0Var.f() + c0Var.u();
            c0Var.T(iF);
            a aVarC = iU == 1414744396 ? c(c0Var.u(), c0Var) : a(iU, iB, c0Var);
            if (aVarC != null) {
                if (aVarC.getType() == 1752331379) {
                    iB = ((d) aVarC).b();
                }
                aVar.a(aVarC);
            }
            c0Var.U(iF);
            c0Var.T(iG);
        }
        return new f(i11, aVar.m());
    }

    @Nullable
    public <T extends a> T b(Class<T> cls) {
        g1<a> it = this.f79284a.iterator();
        while (it.hasNext()) {
            T t11 = (T) it.next();
            if (t11.getClass() == cls) {
                return t11;
            }
        }
        return null;
    }

    @Override // w4.a
    public int getType() {
        return this.f79285b;
    }
}
