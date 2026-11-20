package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF extends com.bytedance.adsdk.ugeno.Ol.TRI.pFF {
    private String We;
    private String jcs;

    public pFF(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        if (TextUtils.isEmpty(this.jcs) || TextUtils.equals(this.jcs, "null")) {
            this.jcs = "";
        }
        if (TextUtils.isEmpty(this.We) || TextUtils.equals(this.We, "null")) {
            this.We = "";
        }
        String str = this.We + this.jcs;
        ((com.bytedance.adsdk.ugeno.Ol.TRI.pFF) this).f26328sc = str;
        ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setText(str);
        ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF
    public void qr(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "null")) {
            str = "";
        }
        if (TextUtils.isEmpty(this.jcs) || TextUtils.equals(this.jcs, "null")) {
            this.jcs = "";
        }
        if (TextUtils.isEmpty(this.We) || TextUtils.equals(this.We, "null")) {
            this.We = "";
        }
        String str2 = this.We + str + this.jcs;
        ((com.bytedance.adsdk.ugeno.Ol.TRI.pFF) this).f26328sc = str2;
        ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setText(str2);
        try {
            float f11 = this.kX ? this.Gb : this.HJN;
            float f12 = this.BR ? this.cD : this.HJN;
            float fMeasureText = ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).getPaint().measureText(((com.bytedance.adsdk.ugeno.Ol.TRI.pFF) this).f26328sc);
            if (fMeasureText >= 0.0f) {
                ExN((int) (f11 + fMeasureText + f12));
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF, com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        str.hashCode();
        if (str.equals("before")) {
            this.We = str2;
        } else if (str.equals("after")) {
            this.jcs = str2;
        }
    }
}
