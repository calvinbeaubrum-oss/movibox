package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.zY.Ol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements View.OnTouchListener {
    private Ol ExN;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj TRI;
    private boolean We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26868sc;
    private long zY;

    public pFF(Ol ol2, com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2) {
        this.ExN = ol2;
        this.TRI = qj2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zY = System.currentTimeMillis();
            this.f26868sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
            this.ExN.ExN();
        } else if (action != 1) {
            if (action == 2) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (Math.abs(x11 - this.f26868sc) >= com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), 10.0f) || Math.abs(y11 - this.pFF) >= com.bytedance.sdk.component.adexpress.We.Qj.sc(com.bytedance.sdk.component.adexpress.We.sc(), 10.0f)) {
                    this.We = true;
                    this.ExN.TRI();
                }
            }
        } else {
            if (this.We) {
                return false;
            }
            if (System.currentTimeMillis() - this.zY >= 1500) {
                com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2 = this.TRI;
                if (qj2 != null) {
                    qj2.sc();
                }
            } else {
                this.ExN.TRI();
            }
        }
        return true;
    }
}
