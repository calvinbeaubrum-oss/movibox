package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import z3.c0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f11183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f11186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11187e;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(c0 c0Var);
    }

    public h(androidx.media3.datasource.a aVar, int i11, a aVar2) {
        z3.a.a(i11 > 0);
        this.f11183a = aVar;
        this.f11184b = i11;
        this.f11185c = aVar2;
        this.f11186d = new byte[1];
        this.f11187e = i11;
    }

    @Override // androidx.media3.datasource.a
    public long a(c4.g gVar) {
        throw new UnsupportedOperationException();
    }

    @Override // androidx.media3.datasource.a
    public void c(c4.o oVar) {
        z3.a.e(oVar);
        this.f11183a.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        throw new UnsupportedOperationException();
    }

    public final boolean d() throws IOException {
        if (this.f11183a.read(this.f11186d, 0, 1) == -1) {
            return false;
        }
        int i11 = (this.f11186d[0] & 255) << 4;
        if (i11 == 0) {
            return true;
        }
        byte[] bArr = new byte[i11];
        int i12 = i11;
        int i13 = 0;
        while (i12 > 0) {
            int i14 = this.f11183a.read(bArr, i13, i12);
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
            this.f11185c.a(new c0(bArr, i11));
        }
        return true;
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f11183a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f11183a.getUri();
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f11187e == 0) {
            if (!d()) {
                return -1;
            }
            this.f11187e = this.f11184b;
        }
        int i13 = this.f11183a.read(bArr, i11, Math.min(this.f11187e, i12));
        if (i13 != -1) {
            this.f11187e -= i13;
        }
        return i13;
    }
}
