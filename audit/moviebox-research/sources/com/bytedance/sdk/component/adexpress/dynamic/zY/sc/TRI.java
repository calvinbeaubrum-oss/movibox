package com.bytedance.sdk.component.adexpress.dynamic.zY.sc;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI implements View.OnTouchListener {
    private static int zY = 10;
    private com.bytedance.sdk.component.adexpress.dynamic.zY.Qj ExN;
    private boolean We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26865sc;

    public TRI(com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2) {
        this.ExN = qj2;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26865sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (Math.abs(x11 - this.f26865sc) >= zY || Math.abs(y11 - this.pFF) >= zY) {
                    this.We = true;
                }
            } else if (action == 3) {
                this.We = false;
            }
        } else {
            if (this.We) {
                this.We = false;
                return false;
            }
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            if (Math.abs(x12 - this.f26865sc) >= zY || Math.abs(y12 - this.pFF) >= zY) {
                this.We = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.zY.Qj qj2 = this.ExN;
                if (qj2 != null) {
                    qj2.sc();
                }
            }
        }
        return true;
    }
}
