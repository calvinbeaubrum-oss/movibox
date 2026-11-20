package com.google.android.material.bottomappbar;

import androidx.annotation.NonNull;
import yi.g;
import yi.p;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d extends g implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f36299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f36300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f36301c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f36302d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f36303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f36304g = -1.0f;

    public d(float f11, float f12, float f13) {
        this.f36300b = f11;
        this.f36299a = f12;
        k(f13);
        this.f36303f = 0.0f;
    }

    @Override // yi.g
    public void b(float f11, float f12, float f13, @NonNull p pVar) {
        float f14;
        float f15;
        float f16 = this.f36301c;
        if (f16 == 0.0f) {
            pVar.m(f11, 0.0f);
            return;
        }
        float f17 = ((this.f36300b * 2.0f) + f16) / 2.0f;
        float f18 = f13 * this.f36299a;
        float f19 = f12 + this.f36303f;
        float f21 = (this.f36302d * f13) + ((1.0f - f13) * f17);
        if (f21 / f17 >= 1.0f) {
            pVar.m(f11, 0.0f);
            return;
        }
        float f22 = this.f36304g;
        float f23 = f22 * f13;
        boolean z11 = f22 == -1.0f || Math.abs((f22 * 2.0f) - f16) < 0.1f;
        if (z11) {
            f14 = f21;
            f15 = 0.0f;
        } else {
            f15 = 1.75f;
            f14 = 0.0f;
        }
        float f24 = f17 + f18;
        float f25 = f14 + f18;
        float fSqrt = (float) Math.sqrt((f24 * f24) - (f25 * f25));
        float f26 = f19 - fSqrt;
        float f27 = f19 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f25));
        float f28 = (90.0f - degrees) + f15;
        pVar.m(f26, 0.0f);
        float f29 = f18 * 2.0f;
        pVar.a(f26 - f18, 0.0f, f26 + f18, f29, 270.0f, degrees);
        if (z11) {
            pVar.a(f19 - f17, (-f17) - f14, f19 + f17, f17 - f14, 180.0f - f28, (f28 * 2.0f) - 180.0f);
        } else {
            float f31 = this.f36300b;
            float f32 = f23 * 2.0f;
            float f33 = f19 - f17;
            pVar.a(f33, -(f23 + f31), f33 + f31 + f32, f31 + f23, 180.0f - f28, ((f28 * 2.0f) - 180.0f) / 2.0f);
            float f34 = f19 + f17;
            float f35 = this.f36300b;
            pVar.m(f34 - ((f35 / 2.0f) + f23), f35 + f23);
            float f36 = this.f36300b;
            pVar.a(f34 - (f32 + f36), -(f23 + f36), f34, f36 + f23, 90.0f, f28 - 90.0f);
        }
        pVar.a(f27 - f18, 0.0f, f27 + f18, f29, 270.0f - degrees, degrees);
        pVar.m(f11, 0.0f);
    }

    public float c() {
        return this.f36302d;
    }

    public float d() {
        return this.f36304g;
    }

    public float f() {
        return this.f36300b;
    }

    public float g() {
        return this.f36299a;
    }

    public float h() {
        return this.f36301c;
    }

    public float j() {
        return this.f36303f;
    }

    public void k(float f11) {
        if (f11 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.f36302d = f11;
    }

    public void l(float f11) {
        this.f36304g = f11;
    }

    public void m(float f11) {
        this.f36300b = f11;
    }

    public void n(float f11) {
        this.f36299a = f11;
    }

    public void o(float f11) {
        this.f36301c = f11;
    }

    public void p(float f11) {
        this.f36303f = f11;
    }
}
