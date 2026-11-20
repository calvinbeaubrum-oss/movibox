package com.google.android.exoplayer2.decoder;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f33049a;

    public final void a(int i11) {
        this.f33049a = i11 | this.f33049a;
    }

    public void b() {
        this.f33049a = 0;
    }

    public final void c(int i11) {
        this.f33049a = (~i11) & this.f33049a;
    }

    public final boolean d(int i11) {
        return (this.f33049a & i11) == i11;
    }

    public final boolean e() {
        return d(ASTNode.DEOP);
    }

    public final boolean h() {
        return d(Integer.MIN_VALUE);
    }

    public final boolean i() {
        return d(4);
    }

    public final boolean j() {
        return d(ASTNode.NOJIT);
    }

    public final boolean k() {
        return d(1);
    }

    public final void l(int i11) {
        this.f33049a = i11;
    }
}
