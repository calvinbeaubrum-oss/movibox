package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class i0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f35408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f35409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f35410c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f35411d = Collections.emptyMap();

    public i0(k kVar) {
        this.f35408a = (k) com.google.android.exoplayer2.util.a.e(kVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws IOException {
        this.f35410c = nVar.f35422a;
        this.f35411d = Collections.emptyMap();
        long jA = this.f35408a.a(nVar);
        this.f35410c = (Uri) com.google.android.exoplayer2.util.a.e(getUri());
        this.f35411d = getResponseHeaders();
        return jA;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        this.f35408a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f35408a.e(k0Var);
    }

    public long f() {
        return this.f35409b;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f35408a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35408a.getUri();
    }

    public Uri h() {
        return this.f35410c;
    }

    public Map<String, List<String>> i() {
        return this.f35411d;
    }

    public void j() {
        this.f35409b = 0L;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.f35408a.read(bArr, i11, i12);
        if (i13 != -1) {
            this.f35409b += (long) i13;
        }
        return i13;
    }
}
