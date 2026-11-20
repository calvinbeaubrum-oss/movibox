package androidx.media3.exoplayer.hls;

import android.util.SparseArray;
import z3.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<i0> f10620a = new SparseArray<>();

    public i0 a(int i11) {
        i0 i0Var = this.f10620a.get(i11);
        if (i0Var != null) {
            return i0Var;
        }
        i0 i0Var2 = new i0(9223372036854775806L);
        this.f10620a.put(i11, i0Var2);
        return i0Var2;
    }

    public void b() {
        this.f10620a.clear();
    }
}
