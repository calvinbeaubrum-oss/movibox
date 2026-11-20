package com.applovin.impl;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f17778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f17779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f17780c;

    public ar(View view, com.applovin.impl.sdk.j jVar) {
        this.f17778a = jVar;
        this.f17779b = jVar.J();
        this.f17780c = view;
    }

    public long a(ne neVar) {
        long j11;
        if (com.applovin.impl.sdk.n.a()) {
            this.f17779b.a("ViewabilityTracker", "Checking visibility...");
        }
        Point pointB = z3.b(this.f17780c.getContext());
        if (this.f17780c.isShown()) {
            j11 = 0;
        } else {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View is hidden");
            }
            j11 = 2;
        }
        if (this.f17780c.getAlpha() < neVar.i0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View is transparent");
            }
            j11 |= 4;
        }
        Animation animation = this.f17780c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View is animating");
            }
            j11 |= 8;
        }
        if (this.f17780c.getParent() == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "No parent view found");
            }
            j11 |= 16;
        }
        int iPxToDp = AppLovinSdkUtils.pxToDp(this.f17780c.getContext(), this.f17780c.getWidth());
        if (iPxToDp < Math.min(neVar.o0(), pointB.x)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View has width (" + iPxToDp + ") below threshold");
            }
            j11 |= 32;
        }
        int iPxToDp2 = AppLovinSdkUtils.pxToDp(this.f17780c.getContext(), this.f17780c.getHeight());
        if (iPxToDp2 < neVar.k0()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View has height (" + iPxToDp2 + ") below threshold");
            }
            j11 |= 64;
        }
        Rect rect = new Rect(0, 0, pointB.x, pointB.y);
        int[] iArr = {-1, -1};
        this.f17780c.getLocationOnScreen(iArr);
        int i11 = iArr[0];
        Rect rect2 = new Rect(i11, iArr[1], this.f17780c.getWidth() + i11, iArr[1] + this.f17780c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            }
            j11 |= 128;
        }
        Activity activityB = this.f17778a.e().b();
        if (activityB != null && !zq.a(this.f17780c, activityB)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f17779b.b("ViewabilityTracker", "View is not in top activity's view hierarchy");
            }
            j11 |= 256;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f17779b.a("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j11));
        }
        return j11;
    }
}
