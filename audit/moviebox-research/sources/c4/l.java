package c4;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PriorityTaskManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements androidx.media3.datasource.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.media3.datasource.a f14621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityTaskManager f14622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14623c;

    public l(androidx.media3.datasource.a aVar, PriorityTaskManager priorityTaskManager, int i11) {
        this.f14621a = (androidx.media3.datasource.a) z3.a.e(aVar);
        this.f14622b = (PriorityTaskManager) z3.a.e(priorityTaskManager);
        this.f14623c = i11;
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws IOException {
        this.f14622b.c(this.f14623c);
        return this.f14621a.a(gVar);
    }

    @Override // androidx.media3.datasource.a
    public void c(o oVar) {
        z3.a.e(oVar);
        this.f14621a.c(oVar);
    }

    @Override // androidx.media3.datasource.a
    public void close() throws IOException {
        this.f14621a.close();
    }

    @Override // androidx.media3.datasource.a
    public Map<String, List<String>> getResponseHeaders() {
        return this.f14621a.getResponseHeaders();
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f14621a.getUri();
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        this.f14622b.c(this.f14623c);
        return this.f14621a.read(bArr, i11, i12);
    }
}
