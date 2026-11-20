package com.bytedance.sdk.component.ExN.zY.sc.pFF;

import com.bytedance.sdk.component.ExN.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements Sfl {
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26516sc;
    private com.bytedance.sdk.component.ExN.zY.sc.zY<String, byte[]> zY;

    public zY(int i11, int i12) {
        this.pFF = i11;
        this.f26516sc = i12;
        this.zY = new com.bytedance.sdk.component.ExN.zY.sc.zY<String, byte[]>(i11) { // from class: com.bytedance.sdk.component.ExN.zY.sc.pFF.zY.1
            @Override // com.bytedance.sdk.component.ExN.zY.sc.zY
            /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
            public int pFF(String str, byte[] bArr) {
                if (bArr == null) {
                    return 0;
                }
                return bArr.length;
            }
        };
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public boolean pFF(String str) {
        return this.zY.sc(str) != null;
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public boolean sc(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return false;
        }
        this.zY.sc(str, bArr);
        return true;
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public byte[] sc(String str) {
        return this.zY.sc(str);
    }
}
