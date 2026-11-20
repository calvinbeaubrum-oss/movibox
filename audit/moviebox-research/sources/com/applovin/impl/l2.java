package com.applovin.impl;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f20323a;

    public void b() {
        this.f20323a = 0;
    }

    public final void b(int i11) {
        this.f20323a = i11 | this.f20323a;
    }

    public final void c(int i11) {
        this.f20323a = (~i11) & this.f20323a;
    }

    public final boolean c() {
        return d(ASTNode.DEOP);
    }

    public final boolean d() {
        return d(Integer.MIN_VALUE);
    }

    public final boolean d(int i11) {
        return (this.f20323a & i11) == i11;
    }

    public final void e(int i11) {
        this.f20323a = i11;
    }

    public final boolean e() {
        return d(4);
    }

    public final boolean f() {
        return d(1);
    }
}
