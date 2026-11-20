package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class DocumentData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f15143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f15144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f15145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Justification f15146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f15147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f15148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f15149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f15150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f15151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f15152j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f15153k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public PointF f15154l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public PointF f15155m;

    /* JADX INFO: compiled from: source.java */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData() {
    }

    public DocumentData(String str, String str2, float f11, Justification justification, int i11, float f12, float f13, int i12, int i13, float f14, boolean z11, PointF pointF, PointF pointF2) {
        a(str, str2, f11, justification, i11, f12, f13, i12, i13, f14, z11, pointF, pointF2);
    }

    public void a(String str, String str2, float f11, Justification justification, int i11, float f12, float f13, int i12, int i13, float f14, boolean z11, PointF pointF, PointF pointF2) {
        this.f15143a = str;
        this.f15144b = str2;
        this.f15145c = f11;
        this.f15146d = justification;
        this.f15147e = i11;
        this.f15148f = f12;
        this.f15149g = f13;
        this.f15150h = i12;
        this.f15151i = i13;
        this.f15152j = f14;
        this.f15153k = z11;
        this.f15154l = pointF;
        this.f15155m = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f15143a.hashCode() * 31) + this.f15144b.hashCode()) * 31) + this.f15145c)) * 31) + this.f15146d.ordinal()) * 31) + this.f15147e;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.f15148f);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.f15150h;
    }
}
