package com.bytedance.sdk.openadsdk.core.Qj;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.kX;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class uEA extends GestureDetector {
    private final com.bytedance.sdk.openadsdk.core.pFF.TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc f28097sc;

    /* JADX INFO: compiled from: source.java */
    public static class sc extends GestureDetector.SimpleOnGestureListener {

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        boolean f28098sc = false;

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            this.f28098sc = true;
            return super.onSingleTapUp(motionEvent);
        }

        public boolean pFF() {
            return this.f28098sc;
        }

        public void sc() {
            this.f28098sc = false;
        }
    }

    public uEA(Context context) {
        this(context, new sc());
    }

    public uEA(Context context, sc scVar) {
        super(context, scVar);
        this.f28097sc = scVar;
        this.pFF = new com.bytedance.sdk.openadsdk.core.pFF.TRI();
        setIsLongpressEnabled(false);
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.pFF.sc(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public boolean pFF() {
        return this.f28097sc.pFF();
    }

    public com.bytedance.sdk.openadsdk.core.model.WH sc(Context context, View view, View view2) {
        if (this.pFF == null) {
            return new com.bytedance.sdk.openadsdk.core.model.WH.sc().sc();
        }
        return new com.bytedance.sdk.openadsdk.core.model.WH.sc().TRI(this.pFF.f28459sc).ExN(this.pFF.pFF).We(this.pFF.zY).zY(this.pFF.We).pFF(this.pFF.ExN).sc(this.pFF.TRI).pFF(kX.sc(view)).sc(kX.sc(view2)).zY(kX.zY(view)).We(kX.zY(view2)).We(this.pFF.f28458qr).ExN(this.pFF.Qj).TRI(this.pFF.Ol).sc(this.pFF.Tf).pFF(com.bytedance.sdk.openadsdk.core.Ol.pFF().sc() ? 1 : 2).sc("vessel").sc(kX.ExN(context)).zY(kX.qr(context)).pFF(kX.TRI(context)).sc();
    }

    public void sc() {
        this.f28097sc.sc();
    }
}
