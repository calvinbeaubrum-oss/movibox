package com.bytedance.adsdk.pFF.zY.sc;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends SR<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> {
    public zY(List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We>> list) {
        super(sc(list));
    }

    private static com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We> sc(com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We> scVar) {
        com.bytedance.adsdk.pFF.zY.pFF.We we2 = scVar.f26180sc;
        com.bytedance.adsdk.pFF.zY.pFF.We we3 = scVar.pFF;
        if (we2 == null || we3 == null || we2.sc().length == we3.sc().length) {
            return scVar;
        }
        float[] fArrSc = sc(we2.sc(), we3.sc());
        return scVar.sc(we2.sc(fArrSc), we3.sc(fArrSc));
    }

    private static List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We>> sc(List<com.bytedance.adsdk.pFF.qr.sc<com.bytedance.adsdk.pFF.zY.pFF.We>> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            list.set(i11, sc(list.get(i11)));
        }
        return list;
    }

    public static float[] sc(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f11 = Float.NaN;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            float f12 = fArr3[i12];
            if (f12 != f11) {
                fArr3[i11] = f12;
                i11++;
                f11 = fArr3[i12];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i11);
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.SR, com.bytedance.adsdk.pFF.zY.sc.Ql
    public /* bridge */ /* synthetic */ boolean pFF() {
        return super.pFF();
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.Ql
    public com.bytedance.adsdk.pFF.sc.pFF.sc<com.bytedance.adsdk.pFF.zY.pFF.We, com.bytedance.adsdk.pFF.zY.pFF.We> sc() {
        return new com.bytedance.adsdk.pFF.sc.pFF.ExN(this.f26265sc);
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.SR
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.bytedance.adsdk.pFF.zY.sc.SR, com.bytedance.adsdk.pFF.zY.sc.Ql
    public /* bridge */ /* synthetic */ List zY() {
        return super.zY();
    }
}
