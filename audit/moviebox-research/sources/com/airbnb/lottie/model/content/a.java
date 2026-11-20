package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import b7.b;
import b7.d;
import b7.f;
import c7.c;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.h;
import java.util.List;
import x6.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GradientType f15194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b7.c f15195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f15196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f15197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f15198f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f15199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f15200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f15201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f15202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f15203k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public final b f15204l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f15205m;

    public a(String str, GradientType gradientType, b7.c cVar, d dVar, f fVar, f fVar2, b bVar, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f11, List<b> list, @Nullable b bVar2, boolean z11) {
        this.f15193a = str;
        this.f15194b = gradientType;
        this.f15195c = cVar;
        this.f15196d = dVar;
        this.f15197e = fVar;
        this.f15198f = fVar2;
        this.f15199g = bVar;
        this.f15200h = lineCapType;
        this.f15201i = lineJoinType;
        this.f15202j = f11;
        this.f15203k = list;
        this.f15204l = bVar2;
        this.f15205m = z11;
    }

    @Override // c7.c
    public x6.c a(LottieDrawable lottieDrawable, h hVar, com.airbnb.lottie.model.layer.a aVar) {
        return new i(lottieDrawable, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.f15200h;
    }

    @Nullable
    public b c() {
        return this.f15204l;
    }

    public f d() {
        return this.f15198f;
    }

    public b7.c e() {
        return this.f15195c;
    }

    public GradientType f() {
        return this.f15194b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.f15201i;
    }

    public List<b> h() {
        return this.f15203k;
    }

    public float i() {
        return this.f15202j;
    }

    public String j() {
        return this.f15193a;
    }

    public d k() {
        return this.f15196d;
    }

    public f l() {
        return this.f15197e;
    }

    public b m() {
        return this.f15199g;
    }

    public boolean n() {
        return this.f15205m;
    }
}
