package com.bytedance.adsdk.ugeno.core.pFF;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.core.Tf;
import com.bytedance.adsdk.ugeno.core.WH;
import com.bytedance.adsdk.ugeno.qr.Qj;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    private WH ExN;
    private boolean Qj;
    private String TRI;
    private WH We;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Context f26400qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private float f26401sc = Float.MIN_VALUE;
    private float pFF = Float.MIN_VALUE;
    private int zY = 0;

    public We(Context context, WH wh2, WH wh3, boolean z11) {
        this.f26400qr = context;
        this.We = wh2;
        this.ExN = wh3;
        this.Qj = z11;
        pFF();
    }

    public We(Context context, WH wh2, boolean z11) {
        this.f26400qr = context;
        this.We = wh2;
        this.Qj = z11;
        pFF();
    }

    private void pFF() {
        WH wh2 = this.We;
        if (wh2 == null) {
            return;
        }
        this.zY = wh2.zY().optInt("slideThreshold");
        this.TRI = this.We.zY().optString("slideDirection");
    }

    public void sc() {
        this.f26401sc = Float.MIN_VALUE;
        this.pFF = Float.MIN_VALUE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0079  */
    /* JADX WARN: Code duplicated, block: B:31:0x007b  */
    /* JADX WARN: Code duplicated, block: B:33:0x0085  */
    /* JADX WARN: Code duplicated, block: B:35:0x008f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0091  */
    /* JADX WARN: Code duplicated, block: B:39:0x009c  */
    /* JADX WARN: Code duplicated, block: B:40:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00b8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:46:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c7  */
    public boolean sc(Tf tf2, com.bytedance.adsdk.ugeno.pFF.zY zYVar, MotionEvent motionEvent) {
        float x11;
        float y11;
        int iPFF;
        int iPFF2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f26401sc = motionEvent.getX();
            this.pFF = motionEvent.getY();
        } else if (action == 1) {
            x11 = motionEvent.getX();
            y11 = motionEvent.getY();
            if (!this.Qj && Math.abs(x11 - this.f26401sc) <= 10.0f && Math.abs(y11 - this.pFF) <= 10.0f && tf2 != null) {
                sc();
                tf2.sc(this.ExN, zYVar, zYVar);
                return true;
            }
            if (this.zY != 0 && tf2 != null) {
                sc();
                tf2.sc(this.We, zYVar, zYVar);
                return true;
            }
            iPFF = Qj.pFF(this.f26400qr, x11 - this.f26401sc);
            iPFF2 = Qj.pFF(this.f26400qr, y11 - this.pFF);
            if (TextUtils.equals(this.TRI, "up")) {
                iPFF = -iPFF2;
            } else if (!TextUtils.equals(this.TRI, "down")) {
                iPFF = iPFF2;
            } else if (TextUtils.equals(this.TRI, TtmlNode.LEFT)) {
                iPFF = -iPFF;
            } else if (!TextUtils.equals(this.TRI, TtmlNode.RIGHT)) {
                iPFF = (int) Math.abs(Math.sqrt(Math.pow(iPFF, 2.0d) + Math.pow(iPFF2, 2.0d)));
            }
            if (iPFF >= this.zY) {
                sc();
                return false;
            }
            if (tf2 != null) {
                sc();
                tf2.sc(this.We, zYVar, zYVar);
                return true;
            }
            sc();
        } else if (action == 3) {
            if (this.f26401sc == Float.MIN_VALUE || this.pFF == Float.MIN_VALUE) {
                return false;
            }
            x11 = motionEvent.getX();
            y11 = motionEvent.getY();
            if (!this.Qj) {
            }
            if (this.zY != 0) {
            }
            iPFF = Qj.pFF(this.f26400qr, x11 - this.f26401sc);
            iPFF2 = Qj.pFF(this.f26400qr, y11 - this.pFF);
            if (TextUtils.equals(this.TRI, "up")) {
                iPFF = -iPFF2;
            } else if (!TextUtils.equals(this.TRI, "down")) {
                iPFF = iPFF2;
            } else if (TextUtils.equals(this.TRI, TtmlNode.LEFT)) {
                iPFF = -iPFF;
            } else if (!TextUtils.equals(this.TRI, TtmlNode.RIGHT)) {
                iPFF = (int) Math.abs(Math.sqrt(Math.pow(iPFF, 2.0d) + Math.pow(iPFF2, 2.0d)));
            }
            if (iPFF >= this.zY) {
                sc();
                return false;
            }
            if (tf2 != null) {
                sc();
                tf2.sc(this.We, zYVar, zYVar);
                return true;
            }
            sc();
        }
        return true;
    }
}
