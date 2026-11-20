package com.airbnb.lottie.model.content;

import b7.b;
import c7.c;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import x6.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class ShapeTrimPath implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f15188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f15189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f15190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f15191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15192f;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes.dex */
    public enum Type {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static Type forId(int i11) {
            if (i11 == 1) {
                return SIMULTANEOUSLY;
            }
            if (i11 == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i11);
        }
    }

    public ShapeTrimPath(String str, Type type, b bVar, b bVar2, b bVar3, boolean z11) {
        this.f15187a = str;
        this.f15188b = type;
        this.f15189c = bVar;
        this.f15190d = bVar2;
        this.f15191e = bVar3;
        this.f15192f = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new u(aVar, this);
    }

    public b b() {
        return this.f15190d;
    }

    public String c() {
        return this.f15187a;
    }

    public b d() {
        return this.f15191e;
    }

    public b e() {
        return this.f15189c;
    }

    public Type f() {
        return this.f15188b;
    }

    public boolean g() {
        return this.f15192f;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f15189c + ", end: " + this.f15190d + ", offset: " + this.f15191e + "}";
    }
}
