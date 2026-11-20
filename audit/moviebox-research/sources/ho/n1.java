package ho;

import android.content.Context;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n1 extends l1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public m1 f66748f;

    public n1(d dVar, Context context) {
        super(dVar, context);
    }

    @Override // ho.l1, ho.q0, java.lang.AutoCloseable
    public final void close() {
        try {
            if (this.f66748f != null) {
                this.f66749a.m().unregisterTelephonyCallback(this.f66748f);
                this.f66748f = null;
            }
        } finally {
            super.close();
        }
    }

    @Override // ho.l1, ho.q0, ho.o
    public final boolean v(a.AbstractC0700a abstractC0700a, Context context) {
        if (this.f66748f == null && io.a.c(context, "android.permission.READ_PHONE_STATE")) {
            this.f66748f = new m1(this);
            this.f66749a.m().registerTelephonyCallback(this.f66749a.d().n(), this.f66748f);
        }
        super.v(abstractC0700a, context);
        return this.f66748f != null;
    }
}
