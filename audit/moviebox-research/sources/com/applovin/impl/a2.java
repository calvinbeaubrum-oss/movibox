package com.applovin.impl;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a2 implements i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f17417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f17418b = new ArrayList(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f17419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private l5 f17420d;

    public a2(boolean z11) {
        this.f17417a = z11;
    }

    @Override // com.applovin.impl.i5
    public final void a(xo xoVar) {
        b1.a(xoVar);
        if (this.f17418b.contains(xoVar)) {
            return;
        }
        this.f17418b.add(xoVar);
        this.f17419c++;
    }

    public final void b(l5 l5Var) {
        for (int i11 = 0; i11 < this.f17419c; i11++) {
            ((xo) this.f17418b.get(i11)).b(this, l5Var, this.f17417a);
        }
    }

    public final void c(l5 l5Var) {
        this.f17420d = l5Var;
        for (int i11 = 0; i11 < this.f17419c; i11++) {
            ((xo) this.f17418b.get(i11)).a(this, l5Var, this.f17417a);
        }
    }

    public final void d(int i11) {
        l5 l5Var = (l5) xp.a(this.f17420d);
        for (int i12 = 0; i12 < this.f17419c; i12++) {
            ((xo) this.f17418b.get(i12)).a(this, l5Var, this.f17417a, i11);
        }
    }

    @Override // com.applovin.impl.i5
    public /* synthetic */ Map e() {
        return my.a(this);
    }

    public final void g() {
        l5 l5Var = (l5) xp.a(this.f17420d);
        for (int i11 = 0; i11 < this.f17419c; i11++) {
            ((xo) this.f17418b.get(i11)).c(this, l5Var, this.f17417a);
        }
        this.f17420d = null;
    }
}
