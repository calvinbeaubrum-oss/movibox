package com.bytedance.adsdk.ugeno.core.pFF;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.core.qr;
import com.bytedance.adsdk.ugeno.qr.Ol;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements Ol.sc {
    private com.bytedance.adsdk.ugeno.pFF.zY ExN;
    private Handler TRI = new Ol(Looper.getMainLooper(), this);
    private WH We;
    private Tf pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26403sc;
    private Context zY;

    public sc(Context context, WH wh2, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.zY = context;
        this.We = wh2;
        this.ExN = zYVar;
    }

    public void sc() {
        WH wh2 = this.We;
        if (wh2 == null) {
            return;
        }
        try {
            int i11 = Integer.parseInt(com.bytedance.adsdk.ugeno.zY.pFF.sc(wh2.zY().optString("delay"), this.ExN.WH()));
            this.f26403sc = i11;
            this.TRI.sendEmptyMessageDelayed(1001, i11);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qr.Ol.sc
    public void sc(Message message) {
        if (message.what != 1001) {
            return;
        }
        JSONObject jSONObjectZY = this.We.zY();
        if (TextUtils.equals(jSONObjectZY.optString("type"), "onAnimation")) {
            String strOptString = jSONObjectZY.optString("nodeId");
            com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.ExN;
            com.bytedance.adsdk.ugeno.pFF.zY zYVarZY = zYVar.pFF(zYVar).zY(strOptString);
            new qr(zYVarZY.Ol(), com.bytedance.adsdk.ugeno.core.sc.sc(jSONObjectZY.optJSONObject("animatorSet"), zYVarZY)).sc();
        } else {
            Tf tf2 = this.pFF;
            if (tf2 != null) {
                WH wh2 = this.We;
                com.bytedance.adsdk.ugeno.pFF.zY zYVar2 = this.ExN;
                tf2.sc(wh2, zYVar2, zYVar2);
            }
        }
        this.TRI.removeMessages(1001);
    }

    public void sc(Tf tf2) {
        this.pFF = tf2;
    }
}
