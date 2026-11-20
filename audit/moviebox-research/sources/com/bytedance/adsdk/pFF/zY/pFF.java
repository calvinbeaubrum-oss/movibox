package com.bytedance.adsdk.pFF.zY;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.ColorInt;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class pFF {
    public int ExN;

    @ColorInt
    public int Ol;

    @ColorInt
    public int Qj;
    public PointF Ql;
    public float TRI;
    public PointF Tf;
    public boolean UFX;
    public float WH;
    public sc We;
    public String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    public float f26229qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public String f26230sc;
    public float zY;

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public pFF() {
    }

    public pFF(String str, String str2, float f11, sc scVar, int i11, float f12, float f13, @ColorInt int i12, @ColorInt int i13, float f14, boolean z11, PointF pointF, PointF pointF2) {
        sc(str, str2, f11, scVar, i11, f12, f13, i12, i13, f14, z11, pointF, pointF2);
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.f26230sc.hashCode() * 31) + this.pFF.hashCode()) * 31) + this.zY)) * 31) + this.We.ordinal()) * 31) + this.ExN;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.TRI);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.Qj;
    }

    public void sc(String str, String str2, float f11, sc scVar, int i11, float f12, float f13, @ColorInt int i12, @ColorInt int i13, float f14, boolean z11, PointF pointF, PointF pointF2) {
        this.f26230sc = str;
        this.pFF = str2;
        this.zY = f11;
        this.We = scVar;
        this.ExN = i11;
        this.TRI = f12;
        this.f26229qr = f13;
        this.Qj = i12;
        this.Ol = i13;
        this.WH = f14;
        this.UFX = z11;
        this.Tf = pointF;
        this.Ql = pointF2;
    }
}
