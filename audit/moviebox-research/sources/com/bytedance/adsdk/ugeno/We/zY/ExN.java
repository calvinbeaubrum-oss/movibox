package com.bytedance.adsdk.ugeno.We.zY;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.adsdk.ugeno.qr.Ol;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN extends sc implements Ol.sc {
    private int Ol;
    private int Tf;
    private Handler UFX;
    private int WH;

    public ExN(Context context) {
        super(context);
        this.WH = 0;
        this.UFX = new Ol(Looper.getMainLooper(), this);
        this.Tf = 0;
    }

    @Override // com.bytedance.adsdk.ugeno.qr.Ol.sc
    public void sc(Message message) {
        int i11;
        int i12;
        if (message.what != 1001) {
            return;
        }
        new StringBuilder("handleMsg: execute timer event").append(this.Tf);
        this.f26384sc.sc(this.pFF, this.TRI, this.zY.pFF());
        int i13 = this.Tf - 1;
        this.Tf = i13;
        if (i13 < 0 && (i12 = this.WH) != 0) {
            this.UFX.sendEmptyMessageDelayed(1001, i12);
        } else if (i13 <= 0 || (i11 = this.WH) == 0) {
            this.UFX.removeMessages(1001);
        } else {
            this.UFX.sendEmptyMessageDelayed(1001, i11);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.We.zY.sc
    public boolean sc(Object... objArr) {
        Map<String, String> map = this.ExN;
        if (map != null) {
            int iSc = com.bytedance.adsdk.ugeno.qr.zY.sc(map.get("loop"), 0);
            this.Ol = iSc;
            if (iSc <= 0) {
                this.Tf = -1;
            } else {
                this.Tf = iSc;
            }
            this.WH = com.bytedance.adsdk.ugeno.qr.zY.sc(this.ExN.get("duration"), 0);
        }
        this.UFX.sendEmptyMessageDelayed(1001, this.WH);
        return true;
    }
}
