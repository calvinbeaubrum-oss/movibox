package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class f implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f35388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<k0> f35389b = new ArrayList<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f35390c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public n f35391d;

    public f(boolean z11) {
        this.f35388a = z11;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public final void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        if (this.f35389b.contains(k0Var)) {
            return;
        }
        this.f35389b.add(k0Var);
        this.f35390c++;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public /* synthetic */ Map getResponseHeaders() {
        return j.a(this);
    }

    public final void h(int i11) {
        n nVar = (n) o0.j(this.f35391d);
        for (int i12 = 0; i12 < this.f35390c; i12++) {
            this.f35389b.get(i12).e(this, nVar, this.f35388a, i11);
        }
    }

    public final void i() {
        n nVar = (n) o0.j(this.f35391d);
        for (int i11 = 0; i11 < this.f35390c; i11++) {
            this.f35389b.get(i11).c(this, nVar, this.f35388a);
        }
        this.f35391d = null;
    }

    public final void j(n nVar) {
        for (int i11 = 0; i11 < this.f35390c; i11++) {
            this.f35389b.get(i11).h(this, nVar, this.f35388a);
        }
    }

    public final void k(n nVar) {
        this.f35391d = nVar;
        for (int i11 = 0; i11 < this.f35390c; i11++) {
            this.f35389b.get(i11).g(this, nVar, this.f35388a);
        }
    }
}
