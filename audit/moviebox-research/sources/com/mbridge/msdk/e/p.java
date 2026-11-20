package com.mbridge.msdk.e;

import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
final class p implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f43923a;

    public p(g gVar) {
        this.f43923a = gVar;
    }

    @Override // com.mbridge.msdk.e.l
    public final void a(e eVar) {
        if (y.a(this.f43923a)) {
            return;
        }
        this.f43923a.a(eVar);
    }

    @Override // com.mbridge.msdk.e.l
    public final long[] a() {
        return y.a(this.f43923a) ? new long[]{0, 0} : this.f43923a.a();
    }

    @Override // com.mbridge.msdk.e.l
    public final void b(e eVar) {
        if (y.a(this.f43923a)) {
            return;
        }
        try {
            h hVarI = eVar.i();
            if (y.b(hVarI)) {
                eVar.a(hVarI.a(eVar));
            }
            this.f43923a.b(eVar);
        } catch (Exception e11) {
            if (a.f43738a) {
                Log.e("TrackManager", "process event error", e11);
            }
        }
    }
}
