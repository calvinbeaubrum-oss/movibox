package com.google.android.exoplayer2.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.k0;
import com.google.android.exoplayer2.util.c0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e implements com.google.android.exoplayer2.upstream.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.k f33923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f33925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f33926d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f33927e;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(c0 c0Var);
    }

    public e(com.google.android.exoplayer2.upstream.k kVar, int i11, a aVar) {
        com.google.android.exoplayer2.util.a.a(i11 > 0);
        this.f33923a = kVar;
        this.f33924b = i11;
        this.f33925c = aVar;
        this.f33926d = new byte[1];
        this.f33927e = i11;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(com.google.android.exoplayer2.upstream.n nVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f33923a.e(k0Var);
    }

    public final boolean f() throws IOException {
        if (this.f33923a.read(this.f33926d, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.f33926d[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int i14 = this.f33923a.read(bArr, i13, i12);
            if (i14 == -1) {
                return false;
            }
            i13 += i14;
            i12 -= i14;
        }
        while (i11 > 0 && bArr[i11 - 1] == 0) {
            i11--;
        }
        if (i11 > 0) {
            this.f33925c.a(new c0(bArr, i11));
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f33923a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f33923a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f33927e == 0) {
            if (!f()) {
                return -1;
            }
            this.f33927e = this.f33924b;
        }
        int i13 = this.f33923a.read(bArr, i11, Math.min(this.f33927e, i12));
        if (i13 != -1) {
            this.f33927e -= i13;
        }
        return i13;
    }
}
