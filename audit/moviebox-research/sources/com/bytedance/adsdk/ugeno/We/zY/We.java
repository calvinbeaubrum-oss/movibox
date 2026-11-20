package com.bytedance.adsdk.ugeno.We.zY;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.We.qr;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We extends sc {
    private float Ol;
    private boolean UFX;
    private float WH;

    public We(Context context) {
        super(context);
    }

    public boolean sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Ol = motionEvent.getRawX();
            this.WH = motionEvent.getRawY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                if (Math.abs(rawX - this.Ol) >= 15.0f || Math.abs(rawY - this.WH) >= 15.0f) {
                    this.UFX = true;
                }
            } else if (action == 3) {
                this.UFX = false;
            }
        } else {
            if (this.UFX) {
                this.UFX = false;
                this.Ol = 0.0f;
                this.WH = 0.0f;
                return false;
            }
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.Ol) >= 15.0f || Math.abs(rawY2 - this.WH) >= 15.0f) {
                this.UFX = false;
            } else {
                qr qrVar = this.f26384sc;
                if (qrVar != null) {
                    qrVar.sc(zYVar, this.TRI, this.zY.pFF());
                    this.Ol = 0.0f;
                    this.WH = 0.0f;
                    return true;
                }
            }
        }
        return true;
    }

    @Override // com.bytedance.adsdk.ugeno.We.zY.sc
    public boolean sc(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        return sc(this.pFF, (MotionEvent) objArr[0]);
    }
}
