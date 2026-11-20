package fi;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.o3;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.z2;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z2[] f64963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s[] f64964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o3 f64965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final Object f64966e;

    public c0(z2[] z2VarArr, s[] sVarArr, o3 o3Var, @Nullable Object obj) {
        this.f64963b = z2VarArr;
        this.f64964c = (s[]) sVarArr.clone();
        this.f64965d = o3Var;
        this.f64966e = obj;
        this.f64962a = z2VarArr.length;
    }

    public boolean a(@Nullable c0 c0Var) {
        if (c0Var == null || c0Var.f64964c.length != this.f64964c.length) {
            return false;
        }
        for (int i11 = 0; i11 < this.f64964c.length; i11++) {
            if (!b(c0Var, i11)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable c0 c0Var, int i11) {
        return c0Var != null && o0.c(this.f64963b[i11], c0Var.f64963b[i11]) && o0.c(this.f64964c[i11], c0Var.f64964c[i11]);
    }

    public boolean c(int i11) {
        return this.f64963b[i11] != null;
    }
}
