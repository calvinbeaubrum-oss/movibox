package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface DrmSession {

    /* JADX INFO: compiled from: source.java */
    public static class DrmSessionException extends IOException {
        public final int errorCode;

        public DrmSessionException(Throwable th2, int i11) {
            super(th2);
            this.errorCode = i11;
        }
    }

    UUID a();

    boolean b();

    @Nullable
    com.google.android.exoplayer2.decoder.b c();

    boolean d(String str);

    void e(@Nullable b.a aVar);

    void f(@Nullable b.a aVar);

    @Nullable
    DrmSessionException getError();

    int getState();

    @Nullable
    Map<String, String> queryKeyStatus();
}
