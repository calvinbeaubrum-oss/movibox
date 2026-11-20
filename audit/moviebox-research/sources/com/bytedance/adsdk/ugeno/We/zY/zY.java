package com.bytedance.adsdk.ugeno.We.zY;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.We.qr;
import com.bytedance.adsdk.ugeno.qr.Qj;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY extends sc {
    private float Ol;
    private String Tf;
    private int UFX;
    private float WH;

    public zY(Context context) {
        super(context);
        this.UFX = 0;
        this.Tf = "up";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:32:0x007a  */
    private boolean sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        byte b11;
        qr qrVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Ol = motionEvent.getX();
            this.WH = motionEvent.getY();
        } else if (action == 1 || action == 3) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (this.UFX == 0 && (qrVar = this.f26384sc) != null) {
                qrVar.sc(zYVar, this.TRI, this.zY.pFF());
                return true;
            }
            int iPFF = Qj.pFF(this.Qj, x11 - this.Ol);
            int iPFF2 = Qj.pFF(this.Qj, y11 - this.WH);
            switch (this.Tf) {
                case "up":
                    b11 = 0;
                    break;
                case "all":
                    b11 = 4;
                    break;
                case "down":
                    b11 = 1;
                    break;
                case "left":
                    b11 = 2;
                    break;
                case "right":
                    b11 = 3;
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 == 0) {
                iPFF = -iPFF2;
            } else if (b11 == 1) {
                iPFF = iPFF2;
            } else if (b11 == 2) {
                iPFF = -iPFF;
            } else if (b11 != 3) {
                iPFF = (int) Math.abs(Math.sqrt(Math.pow(iPFF, 2.0d) + Math.pow(iPFF2, 2.0d)));
            }
            if (iPFF < this.UFX) {
                return false;
            }
            qr qrVar2 = this.f26384sc;
            if (qrVar2 != null) {
                this.Ol = 0.0f;
                this.WH = 0.0f;
                qrVar2.sc(zYVar, this.TRI, this.zY.pFF());
                return true;
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.We.zY.sc
    public boolean sc(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        Map<String, String> map = this.ExN;
        if (map != null) {
            this.Tf = TextUtils.isEmpty(map.get("direction")) ? "all" : this.ExN.get("direction");
            this.UFX = com.bytedance.adsdk.ugeno.qr.zY.sc(this.ExN.get("distance"), 0);
        }
        return sc(this.pFF, (MotionEvent) objArr[0]);
    }
}
