package com.bytedance.adsdk.pFF.zY;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class sc {
    private final PointF pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final PointF f26262sc;
    private final PointF zY;

    public sc() {
        this.f26262sc = new PointF();
        this.pFF = new PointF();
        this.zY = new PointF();
    }

    public sc(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f26262sc = pointF;
        this.pFF = pointF2;
        this.zY = pointF3;
    }

    public PointF pFF() {
        return this.pFF;
    }

    public void pFF(float f11, float f12) {
        this.pFF.set(f11, f12);
    }

    public PointF sc() {
        return this.f26262sc;
    }

    public void sc(float f11, float f12) {
        this.f26262sc.set(f11, f12);
    }

    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.zY.x), Float.valueOf(this.zY.y), Float.valueOf(this.f26262sc.x), Float.valueOf(this.f26262sc.y), Float.valueOf(this.pFF.x), Float.valueOf(this.pFF.y));
    }

    public PointF zY() {
        return this.zY;
    }

    public void zY(float f11, float f12) {
        this.zY.set(f11, f12);
    }
}
