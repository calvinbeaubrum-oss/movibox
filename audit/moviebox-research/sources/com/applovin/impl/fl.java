package com.applovin.impl;

import android.net.Uri;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class fl implements i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i5 f19008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f19009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Uri f19010c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f19011d = Collections.emptyMap();

    public fl(i5 i5Var) {
        this.f19008a = (i5) b1.a(i5Var);
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) {
        int iA = this.f19008a.a(bArr, i11, i12);
        if (iA != -1) {
            this.f19009b += (long) iA;
        }
        return iA;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) {
        this.f19010c = l5Var.f20336a;
        this.f19011d = Collections.emptyMap();
        long jA = this.f19008a.a(l5Var);
        this.f19010c = (Uri) b1.a(c());
        this.f19011d = e();
        return jA;
    }

    @Override // com.applovin.impl.i5
    public void a(xo xoVar) {
        b1.a(xoVar);
        this.f19008a.a(xoVar);
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f19008a.c();
    }

    @Override // com.applovin.impl.i5
    public void close() {
        this.f19008a.close();
    }

    @Override // com.applovin.impl.i5
    public Map e() {
        return this.f19008a.e();
    }

    public long g() {
        return this.f19009b;
    }

    public Uri h() {
        return this.f19010c;
    }

    public Map i() {
        return this.f19011d;
    }
}
