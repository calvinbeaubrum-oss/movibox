package com.bytedance.sdk.openadsdk.core.widget;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class wjp {
    private float ExN;
    private int TRI;
    private boolean UFX;
    private float We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f28568qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f28569sc;
    private final boolean pFF = false;
    private boolean zY = false;
    private boolean Qj = true;
    private boolean Ol = false;
    private final View.OnTouchListener WH = new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.wjp.1
        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (wjp.this.f28569sc.JPJ()) {
                return !wjp.this.zY;
            }
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                wjp wjpVar = wjp.this;
                wjpVar.UFX = wjpVar.sc(motionEvent);
                wjp.this.We = x11;
                wjp.this.ExN = y11;
                wjp.this.TRI = (int) x11;
                wjp.this.f28568qr = (int) y11;
                wjp.this.Qj = true;
                if (wjp.this.f28569sc != null && wjp.this.zY) {
                    wjp.this.f28569sc.sc(view, true);
                }
            } else if (action == 1) {
                if (Math.abs(x11 - wjp.this.TRI) > 20.0f || Math.abs(y11 - wjp.this.f28568qr) > 20.0f) {
                    wjp.this.Qj = false;
                }
                wjp.this.Qj = true;
                wjp.this.Ol = false;
                wjp.this.We = 0.0f;
                wjp.this.ExN = 0.0f;
                wjp.this.TRI = 0;
                if (wjp.this.f28569sc != null) {
                    wjp.this.f28569sc.sc(view, wjp.this.Qj);
                }
                wjp.this.UFX = false;
            } else if (action == 3) {
                wjp.this.UFX = false;
            }
            return !wjp.this.zY;
        }
    };

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        boolean JPJ();

        void sc(View view, boolean z11);
    }

    public wjp(sc scVar) {
        this.f28569sc = scVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean sc(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int iZY = kX.zY(com.bytedance.sdk.openadsdk.core.Xc.sc().getApplicationContext());
        int iWe = kX.We(com.bytedance.sdk.openadsdk.core.Xc.sc().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f11 = iZY;
        if (rawX <= f11 * 0.01f || rawX >= f11 * 0.99f) {
            return true;
        }
        float f12 = iWe;
        return rawY <= 0.01f * f12 || rawY >= f12 * 0.99f;
    }

    public void sc(View view) {
        if (view != null) {
            view.setOnTouchListener(this.WH);
        }
    }

    public void sc(boolean z11) {
        this.zY = z11;
    }
}
