package com.bytedance.adsdk.ugeno.core.pFF;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.qr.Ol;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN implements Ol.sc {
    private WH ExN;
    private com.bytedance.adsdk.ugeno.pFF.zY TRI;
    private Context We;
    private int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Handler f26398qr = new Ol(Looper.getMainLooper(), this);

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private boolean f26399sc;
    private Tf zY;

    public ExN(Context context, WH wh2, com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.We = context;
        this.ExN = wh2;
        this.TRI = zYVar;
    }

    public void sc() {
        WH wh2 = this.ExN;
        if (wh2 == null) {
            return;
        }
        JSONObject jSONObjectZY = wh2.zY();
        try {
            this.pFF = Integer.parseInt(com.bytedance.adsdk.ugeno.zY.pFF.sc(jSONObjectZY.optString("interval", "8000"), this.TRI.WH()));
            this.f26399sc = jSONObjectZY.optBoolean("repeat");
            this.f26398qr.sendEmptyMessageDelayed(1001, this.pFF);
        } catch (NumberFormatException unused) {
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qr.Ol.sc
    public void sc(Message message) {
        if (message.what != 1001) {
            return;
        }
        Tf tf2 = this.zY;
        if (tf2 != null) {
            WH wh2 = this.ExN;
            com.bytedance.adsdk.ugeno.pFF.zY zYVar = this.TRI;
            tf2.sc(wh2, zYVar, zYVar);
        }
        if (this.f26399sc) {
            this.f26398qr.sendEmptyMessageDelayed(1001, this.pFF);
        } else {
            this.f26398qr.removeMessages(1001);
        }
    }

    public void sc(Tf tf2) {
        this.zY = tf2;
    }
}
