package com.applovin.impl;

import android.net.Uri;
import android.util.Base64;
import com.applovin.exoplayer2.common.base.Charsets;
import java.net.URLDecoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h5 extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l5 f19371e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f19372f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f19373g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f19374h;

    public h5() {
        super(false);
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.f19374h;
        if (i13 == 0) {
            return -1;
        }
        int iMin = Math.min(i12, i13);
        System.arraycopy(xp.a((Object) this.f19372f), this.f19373g, bArr, i11, iMin);
        this.f19373g += iMin;
        this.f19374h -= iMin;
        d(iMin);
        return iMin;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws j5, dh {
        b(l5Var);
        this.f19371e = l5Var;
        Uri uri = l5Var.f20336a;
        String scheme = uri.getScheme();
        b1.a("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrA = xp.a(uri.getSchemeSpecificPart(), ",");
        if (strArrA.length != 2) {
            throw dh.b("Unexpected URI format: " + uri, null);
        }
        String str = strArrA[1];
        if (strArrA[0].contains(";base64")) {
            try {
                this.f19372f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw dh.b("Error while parsing Base64 encoded string: " + str, e11);
            }
        } else {
            this.f19372f = xp.c(URLDecoder.decode(str, Charsets.US_ASCII.name()));
        }
        long j11 = l5Var.f20342g;
        byte[] bArr = this.f19372f;
        if (j11 > bArr.length) {
            this.f19372f = null;
            throw new j5(2008);
        }
        int i11 = (int) j11;
        this.f19373g = i11;
        int length = bArr.length - i11;
        this.f19374h = length;
        long j12 = l5Var.f20343h;
        if (j12 != -1) {
            this.f19374h = (int) Math.min(length, j12);
        }
        c(l5Var);
        long j13 = l5Var.f20343h;
        return j13 != -1 ? j13 : this.f19374h;
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        l5 l5Var = this.f19371e;
        if (l5Var != null) {
            return l5Var.f20336a;
        }
        return null;
    }

    @Override // com.applovin.impl.i5
    public void close() {
        if (this.f19372f != null) {
            this.f19372f = null;
            g();
        }
        this.f19371e = null;
    }
}
