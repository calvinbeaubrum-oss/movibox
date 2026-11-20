package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.UdpDataSource;
import com.google.android.exoplayer2.util.o0;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class k0 implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UdpDataSource f34555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public k0 f34556b;

    public k0(long j11) {
        this.f34555a = new UdpDataSource(2000, Ints.d(j11));
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) throws IOException {
        return this.f34555a.a(nVar);
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public String c() {
        int iD = d();
        com.google.android.exoplayer2.util.a.g(iD != -1);
        return o0.C("RTP/AVP;unicast;client_port=%d-%d", Integer.valueOf(iD), Integer.valueOf(iD + 1));
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f34555a.close();
        k0 k0Var = this.f34556b;
        if (k0Var != null) {
            k0Var.close();
        }
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    public int d() {
        int iD = this.f34555a.d();
        if (iD == -1) {
            return -1;
        }
        return iD;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(com.google.android.exoplayer2.upstream.k0 k0Var) {
        this.f34555a.e(k0Var);
    }

    public void f(k0 k0Var) {
        com.google.android.exoplayer2.util.a.a(this != k0Var);
        this.f34556b = k0Var;
    }

    @Override // com.google.android.exoplayer2.source.rtsp.c
    @Nullable
    public u.b g() {
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public /* synthetic */ Map getResponseHeaders() {
        return com.google.android.exoplayer2.upstream.j.a(this);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f34555a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        try {
            return this.f34555a.read(bArr, i11, i12);
        } catch (UdpDataSource.UdpDataSourceException e11) {
            if (e11.reason == 2002) {
                return -1;
            }
            throw e11;
        }
    }
}
