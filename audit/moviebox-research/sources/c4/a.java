package c4;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Map;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f14584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<o> f14585b = new ArrayList<>(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public g f14587d;

    public a(boolean z11) {
        this.f14584a = z11;
    }

    @Override // androidx.media3.datasource.a
    public final void c(o oVar) {
        z3.a.e(oVar);
        if (this.f14585b.contains(oVar)) {
            return;
        }
        this.f14585b.add(oVar);
        this.f14586c++;
    }

    public final void d(int i11) {
        g gVar = (g) u0.i(this.f14587d);
        for (int i12 = 0; i12 < this.f14586c; i12++) {
            this.f14585b.get(i12).g(this, gVar, this.f14584a, i11);
        }
    }

    public final void e() {
        g gVar = (g) u0.i(this.f14587d);
        for (int i11 = 0; i11 < this.f14586c; i11++) {
            this.f14585b.get(i11).e(this, gVar, this.f14584a);
        }
        this.f14587d = null;
    }

    public final void f(g gVar) {
        for (int i11 = 0; i11 < this.f14586c; i11++) {
            this.f14585b.get(i11).h(this, gVar, this.f14584a);
        }
    }

    public final void g(g gVar) {
        this.f14587d = gVar;
        for (int i11 = 0; i11 < this.f14586c; i11++) {
            this.f14585b.get(i11).f(this, gVar, this.f14584a);
        }
    }

    @Override // androidx.media3.datasource.a
    public /* synthetic */ Map getResponseHeaders() {
        return d.a(this);
    }
}
