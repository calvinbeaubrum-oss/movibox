package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.o0;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class h extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public n f35392e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public byte[] f35393f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f35394g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f35395h;

    public h() {
        super(false);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws IOException {
        j(nVar);
        this.f35392e = nVar;
        Uri uri = nVar.f35422a;
        String scheme = uri.getScheme();
        com.google.android.exoplayer2.util.a.b("data".equals(scheme), "Unsupported scheme: " + scheme);
        String[] strArrT0 = o0.T0(uri.getSchemeSpecificPart(), ",");
        if (strArrT0.length != 2) {
            throw ParserException.createForMalformedDataOfUnknownType("Unexpected URI format: " + uri, null);
        }
        String str = strArrT0[1];
        if (strArrT0[0].contains(";base64")) {
            try {
                this.f35393f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e11) {
                throw ParserException.createForMalformedDataOfUnknownType("Error while parsing Base64 encoded string: " + str, e11);
            }
        } else {
            this.f35393f = o0.n0(URLDecoder.decode(str, com.google.common.base.c.f38163a.name()));
        }
        long j11 = nVar.f35428g;
        byte[] bArr = this.f35393f;
        if (j11 > bArr.length) {
            this.f35393f = null;
            throw new DataSourceException(2008);
        }
        int i11 = (int) j11;
        this.f35394g = i11;
        int length = bArr.length - i11;
        this.f35395h = length;
        long j12 = nVar.f35429h;
        if (j12 != -1) {
            this.f35395h = (int) Math.min(length, j12);
        }
        k(nVar);
        long j13 = nVar.f35429h;
        return j13 != -1 ? j13 : this.f35395h;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        if (this.f35393f != null) {
            this.f35393f = null;
            i();
        }
        this.f35392e = null;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        n nVar = this.f35392e;
        if (nVar != null) {
            return nVar.f35422a;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        if (i12 == 0) {
            return 0;
        }
        int i13 = this.f35395h;
        if (i13 == 0) {
            return -1;
        }
        int iMin = Math.min(i12, i13);
        System.arraycopy(o0.j(this.f35393f), this.f35394g, bArr, i11, iMin);
        this.f35394g += iMin;
        this.f35395h -= iMin;
        h(iMin);
        return iMin;
    }
}
