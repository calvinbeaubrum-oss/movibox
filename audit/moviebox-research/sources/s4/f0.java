package s4;

import androidx.annotation.Nullable;
import androidx.media3.common.q0;
import androidx.media3.exoplayer.z2;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f76008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2[] f76009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final z[] f76010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final q0 f76011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Object f76012e;

    public f0(z2[] z2VarArr, z[] zVarArr, q0 q0Var, @Nullable Object obj) {
        this.f76009b = z2VarArr;
        this.f76010c = (z[]) zVarArr.clone();
        this.f76011d = q0Var;
        this.f76012e = obj;
        this.f76008a = z2VarArr.length;
    }

    public boolean a(@Nullable f0 f0Var) {
        if (f0Var == null || f0Var.f76010c.length != this.f76010c.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.f76010c.length; i11++) {
            if (!b(f0Var, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable f0 f0Var, int i11) {
        return f0Var != null && u0.c(this.f76009b[i11], f0Var.f76009b[i11]) && u0.c(this.f76010c[i11], f0Var.f76010c[i11]);
    }

    public boolean c(int i11) {
        return this.f76009b[i11] != null;
    }
}
