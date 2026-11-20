package c4;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f14628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f14629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14631d;

    public n(androidx.media3.datasource.a aVar, c cVar) {
        this.f14628a = (androidx.media3.datasource.a) z3.a.e(aVar);
        this.f14629b = (c) z3.a.e(cVar);
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        long jA = this.f14628a.a(gVar);
        this.f14631d = jA;
        if (jA == 0) {
            return 0L;
        }
        if (gVar.f14605h == -1 && jA != -1) {
            gVar = gVar.f(0L, jA);
        }
        this.f14630c = true;
        this.f14629b.a(gVar);
        return this.f14631d;
    }

    @Override // androidx.media3.datasource.a
    public void c(o oVar) {
        z3.a.e(oVar);
        this.f14628a.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        try {
            this.f14628a.close();
        } finally {
            if (this.f14630c) {
                this.f14630c = false;
                this.f14629b.close();
            }
        }
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f14628a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f14628a.getUri();
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f14631d == 0) {
            return -1;
        }
        int i13 = this.f14628a.read(bArr, i11, i12);
        if (i13 > 0) {
            this.f14629b.write(bArr, i11, i13);
            long j11 = this.f14631d;
            if (j11 != -1) {
                this.f14631d = j11 - ((long) i13);
            }
        }
        return i13;
    }
}
