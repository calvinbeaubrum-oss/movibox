package com.bytedance.sdk.openadsdk.utils;

import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class BT {

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void sc();

        void sc(com.bytedance.sdk.openadsdk.Xc.sc.pFF pff);
    }

    public static Drawable sc(byte[] bArr, int i11) {
        if (bArr == null || bArr.length <= 0) {
            return new ColorDrawable(0);
        }
        try {
            return new BitmapDrawable(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
        } catch (Throwable unused) {
            return new ColorDrawable(0);
        }
    }

    public static void sc(com.bytedance.sdk.openadsdk.Xc.sc scVar, int i11, int i12, sc scVar2, String str) {
        sc(scVar, i11, i12, scVar2, str, 0);
    }

    public static void sc(com.bytedance.sdk.openadsdk.Xc.sc scVar, int i11, int i12, final sc scVar2, String str, int i13) {
        com.bytedance.sdk.component.utils.Tf.sc("splashLoadAd", " getImageBytes url ".concat(String.valueOf(scVar)));
        com.bytedance.sdk.openadsdk.Xc.zY.sc().zY().sc(scVar, new com.bytedance.sdk.openadsdk.Xc.sc.sc.InterfaceC0277sc() { // from class: com.bytedance.sdk.openadsdk.utils.BT.1
            @Override // com.bytedance.sdk.openadsdk.Xc.sc.sc.InterfaceC0277sc
            public void sc(int i14, String str2, Throwable th2) {
                sc scVar3 = scVar2;
                if (scVar3 != null) {
                    scVar3.sc();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.Xc.sc.sc.InterfaceC0277sc
            public void sc(String str2, com.bytedance.sdk.openadsdk.Xc.sc.pFF pff) {
                sc scVar3;
                if (pff.We() && (scVar3 = scVar2) != null) {
                    scVar3.sc(pff);
                    return;
                }
                sc scVar4 = scVar2;
                if (scVar4 != null) {
                    scVar4.sc();
                }
            }
        }, i11, i12, ImageView.ScaleType.CENTER_INSIDE, str, i13, null);
    }
}
