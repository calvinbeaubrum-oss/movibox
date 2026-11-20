package com.bytedance.sdk.component.adexpress.TRI;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH extends com.bytedance.adsdk.pFF.TRI {
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Map<String, Bitmap> f26696sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc implements com.bytedance.sdk.component.ExN.dE<Bitmap> {
        private final Map<String, Bitmap> We;
        private final com.bytedance.adsdk.pFF.WH pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        private final WeakReference<WH> f26699sc;
        private final String zY;

        public sc(WH wh2, com.bytedance.adsdk.pFF.WH wh3, String str, Map<String, Bitmap> map) {
            this.f26699sc = new WeakReference<>(wh2);
            this.pFF = wh3;
            this.zY = str;
            this.We = map;
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(int i11, String str, Throwable th2) {
        }

        @Override // com.bytedance.sdk.component.ExN.dE
        public void sc(com.bytedance.sdk.component.ExN.UFX<Bitmap> ufx) {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(ufx.pFF(), this.pFF.sc(), this.pFF.pFF(), false);
            this.We.put(this.zY, bitmapCreateScaledBitmap);
            WH wh2 = this.f26699sc.get();
            if (wh2 != null) {
                wh2.sc(this.pFF.Qj(), bitmapCreateScaledBitmap);
            }
        }
    }

    public WH(Context context) {
        super(context);
        this.f26696sc = new HashMap();
    }

    public void Qj() {
        if (TextUtils.isEmpty(this.pFF)) {
            return;
        }
        setProgress(0.0f);
        sc(true);
        setAnimationFromUrl(this.pFF);
        setImageAssetDelegate(new com.bytedance.adsdk.pFF.We() { // from class: com.bytedance.sdk.component.adexpress.TRI.WH.1
            @Override // com.bytedance.adsdk.pFF.We
            public Bitmap sc(final com.bytedance.adsdk.pFF.WH wh2) {
                final String strQj = wh2.Qj();
                String strWH = wh2.WH();
                String strOl = wh2.Ol();
                if (TextUtils.equals(strQj, "image_0") && TextUtils.equals(strOl, "Lark20201123-180048_2.png")) {
                    strOl = "hand.png";
                }
                Bitmap bitmap = (Bitmap) WH.this.f26696sc.get(strQj);
                if (bitmap != null) {
                    return bitmap;
                }
                if (TextUtils.isEmpty(strWH) || !TextUtils.isEmpty(strOl)) {
                    if (!TextUtils.isEmpty(strOl) && TextUtils.isEmpty(strWH)) {
                        strWH = strOl;
                    } else if (TextUtils.isEmpty(strOl) || TextUtils.isEmpty(strWH)) {
                        strWH = "";
                    } else {
                        strWH = strWH + strOl;
                    }
                }
                if (TextUtils.isEmpty(strWH)) {
                    return null;
                }
                com.bytedance.sdk.component.ExN.WH whSc = com.bytedance.sdk.component.adexpress.sc.sc.sc.sc().ExN().sc(strWH).sc(new com.bytedance.sdk.component.ExN.Qj() { // from class: com.bytedance.sdk.component.adexpress.TRI.WH.1.1
                    @Override // com.bytedance.sdk.component.ExN.Qj
                    public Bitmap sc(Bitmap bitmap2) {
                        Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, wh2.sc(), wh2.pFF(), false);
                        WH.this.f26696sc.put(strQj, bitmapCreateScaledBitmap);
                        return bitmapCreateScaledBitmap;
                    }
                });
                WH wh3 = WH.this;
                whSc.sc(new sc(wh3, wh2, strQj, wh3.f26696sc));
                return (Bitmap) WH.this.f26696sc.get(strQj);
            }
        });
        sc();
    }

    public void setAnimationsLoop(boolean z11) {
    }

    public void setData(Map<String, String> map) {
    }

    public void setImageLottieTosPath(String str) {
        this.pFF = str;
    }

    public void setLottieAdDescMaxLength(int i11) {
    }

    public void setLottieAdTitleMaxLength(int i11) {
    }

    public void setLottieAppNameMaxLength(int i11) {
    }
}
