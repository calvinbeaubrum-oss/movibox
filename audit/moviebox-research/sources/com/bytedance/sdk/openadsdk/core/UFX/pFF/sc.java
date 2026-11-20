package com.bytedance.sdk.openadsdk.core.UFX.pFF;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc extends com.bytedance.adsdk.ugeno.Ol.TRI.pFF {
    public sc(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.Ol.TRI.pFF
    public void qr(String str) {
        super.qr(str);
        if (TextUtils.isEmpty(str) || TextUtils.equals("null", str)) {
            return;
        }
        try {
            String str2 = String.format(Sfl.sc(this.ExN, "tt_comment_num"), Integer.valueOf(Integer.parseInt(str)));
            ((com.bytedance.adsdk.ugeno.Ol.TRI.sc) this.Qj).setText("(" + str2 + ")");
        } catch (Exception unused) {
        }
    }
}
