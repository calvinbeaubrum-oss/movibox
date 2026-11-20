package com.bytedance.sdk.component.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class We<P, R> extends com.bytedance.sdk.component.sc.pFF<P, R> {
    private sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f27003sc = true;
    private TRI zY;

    /* JADX INFO: compiled from: source.java */
    public interface pFF {
        We sc();
    }

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc(Object obj);

        void sc(Throwable th2);
    }

    private boolean TRI() {
        if (this.f27003sc) {
            return true;
        }
        Ol.sc(new IllegalStateException("Jsb async call already finished: " + sc() + ", hashcode: " + hashCode()));
        return false;
    }

    public void ExN() {
        We();
    }

    public void We() {
        this.f27003sc = false;
        this.zY = null;
    }

    @Override // com.bytedance.sdk.component.sc.pFF
    public /* bridge */ /* synthetic */ String sc() {
        return super.sc();
    }

    public final void sc(R r11) {
        if (TRI()) {
            this.pFF.sc(r11);
            We();
        }
    }

    public abstract void sc(P p11, TRI tri) throws Exception;

    public void sc(P p11, TRI tri, sc scVar) throws Exception {
        this.zY = tri;
        this.pFF = scVar;
        sc(p11, tri);
    }

    public final void sc(Throwable th2) {
        if (TRI()) {
            this.pFF.sc(th2);
            We();
        }
    }

    public final void zY() {
        sc((Throwable) null);
    }
}
