package o5;

import android.util.SparseArray;
import u4.m0;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u implements u4.u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u4.u f72359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s.a f72360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseArray<w> f72361c = new SparseArray<>();

    public u(u4.u uVar, s.a aVar) {
        this.f72359a = uVar;
        this.f72360b = aVar;
    }

    public void a() {
        for (int i11 = 0; i11 < this.f72361c.size(); i11++) {
            this.f72361c.valueAt(i11).k();
        }
    }

    @Override // u4.u
    public void endTracks() {
        this.f72359a.endTracks();
    }

    @Override // u4.u
    public void f(m0 m0Var) {
        this.f72359a.f(m0Var);
    }

    @Override // u4.u
    public r0 track(int i11, int i12) {
        if (i12 != 3) {
            return this.f72359a.track(i11, i12);
        }
        w wVar = this.f72361c.get(i11);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this.f72359a.track(i11, i12), this.f72360b);
        this.f72361c.put(i11, wVar2);
        return wVar2;
    }
}
