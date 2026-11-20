package com.bytedance.adsdk.ugeno.core.pFF;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    private boolean ExN;
    private Context We;
    private float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26402sc;
    private WH zY;

    public pFF(Context context, WH wh2) {
        this.We = context;
        this.zY = wh2;
    }

    public boolean sc(Tf tf2, com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26402sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x11 = motionEvent.getX();
                float y11 = motionEvent.getY();
                if (Math.abs(x11 - this.f26402sc) >= 15.0f || Math.abs(y11 - this.pFF) >= 15.0f) {
                    this.ExN = true;
                }
            } else if (action == 3) {
                this.ExN = false;
            }
        } else {
            if (this.ExN) {
                this.ExN = false;
                return false;
            }
            float x12 = motionEvent.getX();
            float y12 = motionEvent.getY();
            if (Math.abs(x12 - this.f26402sc) >= 15.0f || Math.abs(y12 - this.pFF) >= 15.0f) {
                this.ExN = false;
            } else if (tf2 != null) {
                tf2.sc(this.zY, zYVar, zYVar);
                return true;
            }
        }
        return true;
    }
}
