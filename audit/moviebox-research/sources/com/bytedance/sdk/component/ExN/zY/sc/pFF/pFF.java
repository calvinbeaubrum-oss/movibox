package com.bytedance.sdk.component.ExN.zY.sc.pFF;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.ExN.wjp;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements wjp {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26514sc;
    private com.bytedance.sdk.component.ExN.zY.sc.zY<String, Bitmap> zY;

    public pFF(int i11, int i12) {
        this.pFF = i11;
        this.f26514sc = i12;
        this.zY = new com.bytedance.sdk.component.ExN.zY.sc.zY<String, Bitmap>(i11) { // from class: com.bytedance.sdk.component.ExN.zY.sc.pFF.pFF.1
            @Override // com.bytedance.sdk.component.ExN.zY.sc.zY
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public int pFF(String str, Bitmap bitmap) {
                if (bitmap == null) {
                    return 0;
                }
                return pFF.sc(bitmap);
            }
        };
    }

    public static int sc(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return bitmap.getAllocationByteCount();
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public boolean pFF(String str) {
        return this.zY.sc(str) != null;
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public Bitmap sc(String str) {
        return this.zY.sc(str);
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public boolean sc(String str, Bitmap bitmap) {
        if (str == null || bitmap == null) {
            return false;
        }
        this.zY.sc(str, bitmap);
        return true;
    }
}
