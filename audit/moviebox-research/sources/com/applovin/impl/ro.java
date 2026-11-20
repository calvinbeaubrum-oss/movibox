package com.applovin.impl;

import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final lo f22162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22163b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long[] f22164c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f22165d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f22166e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long[] f22167f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f22168g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f22169h;

    public ro(lo loVar, long[] jArr, int[] iArr, int i11, long[] jArr2, int[] iArr2, long j11) {
        b1.a(iArr.length == jArr2.length);
        b1.a(jArr.length == jArr2.length);
        b1.a(iArr2.length == jArr2.length);
        this.f22162a = loVar;
        this.f22164c = jArr;
        this.f22165d = iArr;
        this.f22166e = i11;
        this.f22167f = jArr2;
        this.f22168g = iArr2;
        this.f22169h = j11;
        this.f22163b = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | ASTNode.DISCARD;
        }
    }

    public int a(long j11) {
        for (int iB = xp.b(this.f22167f, j11, true, false); iB >= 0; iB--) {
            if ((this.f22168g[iB] & 1) != 0) {
                return iB;
            }
        }
        return -1;
    }

    public int b(long j11) {
        for (int iA = xp.a(this.f22167f, j11, true, false); iA < this.f22167f.length; iA++) {
            if ((this.f22168g[iA] & 1) != 0) {
                return iA;
            }
        }
        return -1;
    }
}
