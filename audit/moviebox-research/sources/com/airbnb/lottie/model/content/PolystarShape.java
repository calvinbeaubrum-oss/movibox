package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import b7.b;
import b7.o;
import c7.c;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import x6.n;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class PolystarShape implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f15166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o<PointF, PointF> f15167d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f15168e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f15169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f15170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f15171h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f15172i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f15173j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f15174k;

    /* JADX INFO: compiled from: source.java */
    public enum Type {
        STAR(1),
        POLYGON(2);

        private final int value;

        Type(int i11) {
            this.value = i11;
        }

        public static Type forValue(int i11) {
            for (Type type : values()) {
                if (type.value == i11) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, b bVar, o<PointF, PointF> oVar, b bVar2, b bVar3, b bVar4, b bVar5, b bVar6, boolean z11, boolean z12) {
        this.f15164a = str;
        this.f15165b = type;
        this.f15166c = bVar;
        this.f15167d = oVar;
        this.f15168e = bVar2;
        this.f15169f = bVar3;
        this.f15170g = bVar4;
        this.f15171h = bVar5;
        this.f15172i = bVar6;
        this.f15173j = z11;
        this.f15174k = z12;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new n(lottieDrawable, aVar, this);
    }

    public b b() {
        return this.f15169f;
    }

    public b c() {
        return this.f15171h;
    }

    public String d() {
        return this.f15164a;
    }

    public b e() {
        return this.f15170g;
    }

    public b f() {
        return this.f15172i;
    }

    public b g() {
        return this.f15166c;
    }

    public o<PointF, PointF> h() {
        return this.f15167d;
    }

    public b i() {
        return this.f15168e;
    }

    public Type j() {
        return this.f15165b;
    }

    public boolean k() {
        return this.f15173j;
    }

    public boolean l() {
        return this.f15174k;
    }
}
