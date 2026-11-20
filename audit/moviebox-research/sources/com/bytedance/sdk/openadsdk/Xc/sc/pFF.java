package com.bytedance.sdk.openadsdk.Xc.sc;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.component.utils.We;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    private List<Object> ExN;
    private Map<String, String> TRI;
    private Bitmap We;
    private byte[] pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    int f27478sc;
    private Bitmap zY;

    public pFF(Bitmap bitmap, Bitmap bitmap2, int i11) {
        this.pFF = null;
        this.ExN = null;
        this.TRI = null;
        this.We = bitmap2;
        this.zY = bitmap;
        this.f27478sc = i11;
    }

    public pFF(byte[] bArr, int i11) {
        this.zY = null;
        this.We = null;
        this.ExN = null;
        this.TRI = null;
        this.pFF = bArr;
        this.f27478sc = i11;
    }

    public boolean We() {
        if (this.zY != null) {
            return true;
        }
        byte[] bArr = this.pFF;
        return bArr != null && bArr.length > 0;
    }

    public Bitmap pFF() {
        return this.We;
    }

    public Bitmap sc() {
        return this.zY;
    }

    public byte[] zY() {
        try {
            if (this.pFF == null) {
                this.pFF = We.sc(this.zY);
            }
        } catch (OutOfMemoryError e11) {
            Tf.sc("GifRequestResult", e11.getMessage());
        }
        return this.pFF;
    }
}
