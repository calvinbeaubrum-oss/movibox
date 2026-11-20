package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import com.applovin.impl.sj;
import com.applovin.impl.z3;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class AppLovinTouchToClickListener implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f17509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f17510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f17511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ClickRecognitionState f17512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f17513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private PointF f17514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f17515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f17516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final OnClickListener f17517i;

    /* JADX INFO: compiled from: source.java */
    public enum ClickRecognitionState {
        DISABLED,
        ACTION_DOWN,
        ACTION_POINTER_UP,
        ACTION_UP
    }

    /* JADX INFO: compiled from: source.java */
    public interface OnClickListener {
        void onClick(View view, MotionEvent motionEvent);
    }

    public AppLovinTouchToClickListener(com.applovin.impl.sdk.j jVar, sj sjVar, Context context, OnClickListener onClickListener) {
        this.f17509a = ((Long) jVar.a(sj.D0)).longValue();
        this.f17510b = ((Integer) jVar.a(sj.E0)).intValue();
        this.f17511c = AppLovinSdkUtils.dpToPx(context, ((Integer) jVar.a(sj.J0)).intValue());
        this.f17512d = ClickRecognitionState.values()[((Integer) jVar.a(sjVar)).intValue()];
        this.f17516h = context;
        this.f17517i = onClickListener;
    }

    private float a(float f11) {
        return f11 / this.f17516h.getResources().getDisplayMetrics().density;
    }

    private float a(PointF pointF, PointF pointF2) {
        float f11 = pointF.x - pointF2.x;
        float f12 = pointF.y - pointF2.y;
        return a((float) Math.sqrt((f11 * f11) + (f12 * f12)));
    }

    private void a(View view, MotionEvent motionEvent) {
        this.f17517i.onClick(view, motionEvent);
        this.f17515g = true;
    }

    private boolean a(MotionEvent motionEvent) {
        if (this.f17511c <= 0) {
            return true;
        }
        Point pointB = z3.b(this.f17516h);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int i11 = this.f17511c;
        float f11 = i11;
        return rawX >= f11 && rawY >= f11 && rawX <= ((float) (pointB.x - i11)) && rawY <= ((float) (pointB.y - i11));
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i11;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 6 && !this.f17515g && this.f17512d == ClickRecognitionState.ACTION_POINTER_UP) {
                    a(view, motionEvent);
                }
            } else if (!this.f17515g && this.f17512d == ClickRecognitionState.ACTION_UP) {
                a(view, motionEvent);
            } else if (this.f17512d == ClickRecognitionState.DISABLED) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f17513e;
                float fA = a(this.f17514f, new PointF(motionEvent.getX(), motionEvent.getY()));
                if (!this.f17515g) {
                    long j11 = this.f17509a;
                    if ((j11 < 0 || jElapsedRealtime < j11) && ((i11 = this.f17510b) < 0 || fA < i11)) {
                        a(view, motionEvent);
                    }
                }
            }
        } else if (this.f17512d != ClickRecognitionState.ACTION_DOWN) {
            this.f17513e = SystemClock.elapsedRealtime();
            this.f17514f = new PointF(motionEvent.getX(), motionEvent.getY());
            this.f17515g = false;
        } else if (a(motionEvent)) {
            a(view, motionEvent);
        }
        return true;
    }
}
