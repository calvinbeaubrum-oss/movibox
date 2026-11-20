package com.applovin.impl;

import androidx.core.view.InputDeviceCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class hj implements dp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final gj f19495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bh f19496b = new bh(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19500f;

    public hj(gj gjVar) {
        this.f19495a = gjVar;
    }

    @Override // com.applovin.impl.dp
    public void a() {
        this.f19500f = true;
    }

    @Override // com.applovin.impl.dp
    public void a(bh bhVar, int i11) {
        int iD;
        boolean z11 = (i11 & 1) != 0;
        if (z11) {
            iD = bhVar.d() + bhVar.w();
        } else {
            iD = -1;
        }
        if (this.f19500f) {
            if (!z11) {
                return;
            }
            this.f19500f = false;
            bhVar.f(iD);
            this.f19498d = 0;
        }
        while (bhVar.a() > 0) {
            int i12 = this.f19498d;
            if (i12 < 3) {
                if (i12 == 0) {
                    int iW = bhVar.w();
                    bhVar.f(bhVar.d() - 1);
                    if (iW == 255) {
                        this.f19500f = true;
                        return;
                    }
                }
                int iMin = Math.min(bhVar.a(), 3 - this.f19498d);
                bhVar.a(this.f19496b.c(), this.f19498d, iMin);
                int i13 = this.f19498d + iMin;
                this.f19498d = i13;
                if (i13 == 3) {
                    this.f19496b.f(0);
                    this.f19496b.e(3);
                    this.f19496b.g(1);
                    int iW2 = this.f19496b.w();
                    int iW3 = this.f19496b.w();
                    this.f19499e = (iW2 & 128) != 0;
                    this.f19497c = (((iW2 & 15) << 8) | iW3) + 3;
                    int iB = this.f19496b.b();
                    int i14 = this.f19497c;
                    if (iB < i14) {
                        this.f19496b.a(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i14, this.f19496b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(bhVar.a(), this.f19497c - this.f19498d);
                bhVar.a(this.f19496b.c(), this.f19498d, iMin2);
                int i15 = this.f19498d + iMin2;
                this.f19498d = i15;
                int i16 = this.f19497c;
                if (i15 != i16) {
                    continue;
                } else {
                    if (!this.f19499e) {
                        this.f19496b.e(i16);
                    } else {
                        if (xp.a(this.f19496b.c(), 0, this.f19497c, -1) != 0) {
                            this.f19500f = true;
                            return;
                        }
                        this.f19496b.e(this.f19497c - 4);
                    }
                    this.f19496b.f(0);
                    this.f19495a.a(this.f19496b);
                    this.f19498d = 0;
                }
            }
        }
    }

    @Override // com.applovin.impl.dp
    public void a(ho hoVar, m8 m8Var, dp.d dVar) {
        this.f19495a.a(hoVar, m8Var, dVar);
        this.f19500f = true;
    }
}
