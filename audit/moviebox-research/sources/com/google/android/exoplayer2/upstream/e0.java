package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class e0 implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f35385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PriorityTaskManager f35386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f35387c;

    public e0(k kVar, PriorityTaskManager priorityTaskManager, int i11) {
        this.f35385a = (k) com.google.android.exoplayer2.util.a.e(kVar);
        this.f35386b = (PriorityTaskManager) com.google.android.exoplayer2.util.a.e(priorityTaskManager);
        this.f35387c = i11;
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws IOException {
        this.f35386b.c(this.f35387c);
        return this.f35385a.a(nVar);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() throws IOException {
        this.f35385a.close();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void e(k0 k0Var) {
        com.google.android.exoplayer2.util.a.e(k0Var);
        this.f35385a.e(k0Var);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public Map<String, List<String>> getResponseHeaders() {
        return this.f35385a.getResponseHeaders();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35385a.getUri();
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws IOException {
        this.f35386b.c(this.f35387c);
        return this.f35385a.read(bArr, i11, i12);
    }
}
