package com.google.android.exoplayer2.source.hls;

import android.util.SparseArray;
import com.google.android.exoplayer2.util.k0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<k0> f34224a = new SparseArray<>();

    public k0 a(int i11) {
        k0 k0Var = this.f34224a.get(i11);
        if (k0Var != null) {
            return k0Var;
        }
        k0 k0Var2 = new k0(9223372036854775806L);
        this.f34224a.put(i11, k0Var2);
        return k0Var2;
    }

    public void b() {
        this.f34224a.clear();
    }
}
