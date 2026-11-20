package c4;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f14624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f14625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f14626c = Uri.EMPTY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, List<String>> f14627d = Collections.emptyMap();

    public m(androidx.media3.datasource.a aVar) {
        this.f14624a = (androidx.media3.datasource.a) z3.a.e(aVar);
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        this.f14626c = gVar.f14598a;
        this.f14627d = Collections.emptyMap();
        long jA = this.f14624a.a(gVar);
        this.f14626c = (Uri) z3.a.e(getUri());
        this.f14627d = getResponseHeaders();
        return jA;
    }

    @Override // androidx.media3.datasource.a
    public void c(o oVar) {
        z3.a.e(oVar);
        this.f14624a.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        this.f14624a.close();
    }

    public long d() {
        return this.f14625b;
    }

    public Uri e() {
        return this.f14626c;
    }

    public Map<String, List<String>> f() {
        return this.f14627d;
    }

    public void g() {
        this.f14625b = 0L;
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f14624a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f14624a.getUri();
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int i13 = this.f14624a.read(bArr, i11, i12);
        if (i13 != -1) {
            this.f14625b += (long) i13;
        }
        return i13;
    }
}
