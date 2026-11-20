package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f15136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f15139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f15140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public Bitmap f15141f;

    public l0(int i11, int i12, String str, String str2, String str3) {
        this.f15136a = i11;
        this.f15137b = i12;
        this.f15138c = str;
        this.f15139d = str2;
        this.f15140e = str3;
    }

    public l0 a(float f11) {
        l0 l0Var = new l0((int) (this.f15136a * f11), (int) (this.f15137b * f11), this.f15138c, this.f15139d, this.f15140e);
        Bitmap bitmap = this.f15141f;
        if (bitmap != null) {
            l0Var.g(Bitmap.createScaledBitmap(bitmap, l0Var.f15136a, l0Var.f15137b, true));
        }
        return l0Var;
    }

    @Nullable
    public Bitmap b() {
        return this.f15141f;
    }

    public String c() {
        return this.f15139d;
    }

    public int d() {
        return this.f15137b;
    }

    public String e() {
        return this.f15138c;
    }

    public int f() {
        return this.f15136a;
    }

    public void g(@Nullable Bitmap bitmap) {
        this.f15141f = bitmap;
    }
}
