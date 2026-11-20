package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class j0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f35412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f35413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f35414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f35415d;

    public j0(k kVar, i iVar) {
        this.f35412a = (k) com.google.android.exoplayer2.util.a.e(kVar);
        this.f35413b = (i) com.google.android.exoplayer2.util.a.e(iVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws IOException {
        long jA = this.f35412a.a(nVar);
        this.f35415d = jA;
        if (jA == 0) {
            return 0L;
        }
        if (nVar.f35429h == -1 && jA != -1) {
            nVar = nVar.f(0L, jA);
        }
        this.f35414c = true;
        this.f35413b.a(nVar);
        return this.f35415d;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        try {
            this.f35412a.close();
        } finally {
            if (this.f35414c) {
                this.f35414c = false;
                this.f35413b.close();
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f35412a.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f35412a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35412a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f35415d == 0) {
            return -1;
        }
        int i13 = this.f35412a.read(bArr, i11, i12);
        if (i13 > 0) {
            this.f35413b.write(bArr, i11, i13);
            long j11 = this.f35415d;
            if (j11 != -1) {
                this.f35415d = j11 - ((long) i13);
            }
        }
        return i13;
    }
}
