package com.bytedance.adsdk.ugeno.Ol.zY;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.Ol.We.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sc extends zY {
    private int We;

    public sc(Context context) {
        super(context);
        this.We = ViewCompat.MEASURED_STATE_MASK;
    }

    private String Ol(String str) {
        String strQr = qr(str);
        return TextUtils.isEmpty(strQr) ? "" : "local://".concat(String.valueOf(strQr));
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.We.zY, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        ((zY) this).f26337sc = Ol(((zY) this).f26337sc);
        super.pFF();
        ((com.bytedance.adsdk.ugeno.Ol.We.sc) this.Qj).setColorFilter(this.We);
        ((com.bytedance.adsdk.ugeno.Ol.We.sc) this.Qj).setScaleType(ImageView.ScaleType.FIT_CENTER);
    }

    public abstract String qr(String str);

    @Override // com.bytedance.adsdk.ugeno.Ol.We.zY, com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        str.hashCode();
        if (str.equals("textColor")) {
            this.We = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
        }
    }
}
