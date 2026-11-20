package androidx.media3.exoplayer.upstream;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: source.java */
    public interface a {
        androidx.media3.exoplayer.upstream.a a();

        @Nullable
        a next();
    }

    void a(a aVar);

    androidx.media3.exoplayer.upstream.a allocate();

    void b(androidx.media3.exoplayer.upstream.a aVar);

    int getIndividualAllocationLength();

    void trim();
}
