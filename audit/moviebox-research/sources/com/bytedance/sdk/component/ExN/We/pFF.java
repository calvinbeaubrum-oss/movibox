package com.bytedance.sdk.component.ExN.We;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements Ol {
    private com.bytedance.sdk.component.ExN.TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private byte[] f26494sc;

    public pFF(byte[] bArr, com.bytedance.sdk.component.ExN.TRI tri) {
        this.f26494sc = bArr;
        this.pFF = tri;
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "image_type";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        Ol ufx;
        int iTf = zYVar.Tf();
        zYVar.sc(this.f26494sc.length);
        if (iTf != 2) {
            if (iTf != 3) {
                boolean zPFF = com.bytedance.sdk.component.ExN.zY.zY.sc.pFF(this.f26494sc);
                ufx = (!zPFF && com.bytedance.sdk.component.ExN.zY.zY.sc.sc(this.f26494sc)) ? new ExN(this.f26494sc, this.pFF) : new Ql(this.f26494sc, this.pFF, zPFF);
            } else {
                byte[] bArr = this.f26494sc;
                ufx = new Ql(bArr, this.pFF, com.bytedance.sdk.component.ExN.zY.zY.sc.pFF(bArr));
            }
        } else if (com.bytedance.sdk.component.ExN.zY.zY.sc.sc(this.f26494sc)) {
            ufx = new ExN(this.f26494sc, this.pFF);
        } else {
            ufx = this.pFF == null ? new UFX() : new Qj(1001, "not image format", null);
        }
        zYVar.sc(ufx);
    }
}
