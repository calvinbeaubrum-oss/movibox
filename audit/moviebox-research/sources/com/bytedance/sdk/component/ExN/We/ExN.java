package com.bytedance.sdk.component.ExN.We;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends sc {
    private com.bytedance.sdk.component.ExN.TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private byte[] f26490sc;

    public ExN(byte[] bArr, com.bytedance.sdk.component.ExN.TRI tri) {
        this.f26490sc = bArr;
        this.pFF = tri;
    }

    private void sc(int i11, String str, Throwable th2, com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        if (this.pFF == null) {
            zYVar.sc(new UFX());
        } else {
            zYVar.sc(new Qj(i11, str, th2));
        }
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public String sc() {
        return "decode";
    }

    @Override // com.bytedance.sdk.component.ExN.We.Ol
    public void sc(com.bytedance.sdk.component.ExN.zY.zY zYVar) {
        com.bytedance.sdk.component.ExN.zY.TRI triSfl = zYVar.Sfl();
        com.bytedance.sdk.component.ExN.zY.pFF.sc scVarSc = triSfl.sc(zYVar);
        try {
            zYVar.uEA();
            Bitmap bitmapSc = scVarSc.sc(this.f26490sc);
            if (bitmapSc == null) {
                sc(1002, "decode failed bitmap null", null, zYVar);
                return;
            }
            zYVar.sc(new Ql(bitmapSc, this.pFF, false));
            triSfl.sc(zYVar.YIK()).sc(zYVar.ExN(), bitmapSc);
        } catch (Throwable th2) {
            sc(1002, "decode failed:" + th2.getMessage(), th2, zYVar);
        }
    }
}
