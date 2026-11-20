package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrmSession.DrmSessionException f33173a;

    public f(DrmSession.DrmSessionException drmSessionException) {
        this.f33173a = (DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID a() {
        return com.google.android.exoplayer2.h.f33253a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean b() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public com.google.android.exoplayer2.decoder.b c() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d(String str) {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void e(@Nullable b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void f(@Nullable b.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.f33173a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }
}
