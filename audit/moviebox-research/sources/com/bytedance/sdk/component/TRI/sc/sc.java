package com.bytedance.sdk.component.TRI.sc;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc {
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc ExN;
    private ExN Ol;
    private boolean Qj;
    private long Ql;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc TRI;
    private int Tf;
    private int UFX;
    private boolean WH;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc We;
    private com.bytedance.sdk.component.TRI.sc.pFF.zY pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc f26628qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private com.bytedance.sdk.component.TRI.sc.sc.ExN f26629sc;
    private com.bytedance.sdk.component.TRI.sc.We.pFF.sc zY;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.TRI.sc.sc$sc, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0249sc {
        private com.bytedance.sdk.component.TRI.sc.We.pFF.sc ExN;
        private boolean Ol;
        private com.bytedance.sdk.component.TRI.sc.sc.ExN Qj;
        private boolean TRI;
        private long Tf;
        private com.bytedance.sdk.component.TRI.sc.We.pFF.sc We;
        private com.bytedance.sdk.component.TRI.sc.We.pFF.sc pFF;

        /* JADX INFO: renamed from: qr, reason: collision with root package name */
        private ExN f26630qr;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private com.bytedance.sdk.component.TRI.sc.pFF.zY f26631sc;
        private com.bytedance.sdk.component.TRI.sc.We.pFF.sc zY;
        private int WH = 5000;
        private int UFX = 10;

        public C0249sc pFF(int i11) {
            this.UFX = i11;
            return this;
        }

        public C0249sc pFF(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
            this.zY = scVar;
            return this;
        }

        public C0249sc sc(int i11) {
            this.WH = i11;
            return this;
        }

        public C0249sc sc(long j11) {
            this.Tf = j11;
            return this;
        }

        public C0249sc sc(ExN exN) {
            this.f26630qr = exN;
            return this;
        }

        public C0249sc sc(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
            this.pFF = scVar;
            return this;
        }

        public C0249sc sc(com.bytedance.sdk.component.TRI.sc.pFF.zY zYVar) {
            this.f26631sc = zYVar;
            return this;
        }

        public C0249sc sc(com.bytedance.sdk.component.TRI.sc.sc.ExN exN) {
            this.Qj = exN;
            return this;
        }

        public C0249sc sc(boolean z11) {
            this.TRI = z11;
            return this;
        }

        public sc sc() {
            sc scVar = new sc();
            scVar.pFF = this.f26631sc;
            scVar.zY = this.pFF;
            scVar.We = this.zY;
            scVar.ExN = this.We;
            scVar.TRI = this.ExN;
            scVar.Qj = this.TRI;
            scVar.Ol = this.f26630qr;
            scVar.f26629sc = this.Qj;
            scVar.WH = this.Ol;
            scVar.Tf = this.UFX;
            scVar.UFX = this.WH;
            scVar.Ql = this.Tf;
            return scVar;
        }

        public C0249sc zY(com.bytedance.sdk.component.TRI.sc.We.pFF.sc scVar) {
            this.We = scVar;
            return this;
        }
    }

    private sc() {
        this.UFX = 200;
        this.Tf = 10;
    }

    public long ExN() {
        return this.Ql;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc Ol() {
        return this.ExN;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc Qj() {
        return this.We;
    }

    public int Ql() {
        return this.Tf;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc TRI() {
        return this.f26628qr;
    }

    public int Tf() {
        return this.UFX;
    }

    public boolean UFX() {
        return this.Qj;
    }

    public com.bytedance.sdk.component.TRI.sc.pFF.zY WH() {
        return this.pFF;
    }

    public ExN We() {
        return this.Ol;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc pFF() {
        return this.TRI;
    }

    public com.bytedance.sdk.component.TRI.sc.We.pFF.sc qr() {
        return this.zY;
    }

    public com.bytedance.sdk.component.TRI.sc.sc.ExN sc() {
        return this.f26629sc;
    }

    public boolean zY() {
        return this.WH;
    }
}
