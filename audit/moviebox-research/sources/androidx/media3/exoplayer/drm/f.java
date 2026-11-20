package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrmSession.DrmSessionException f10295a;

    public f(DrmSession.DrmSessionException drmSessionException) {
        this.f10295a = (DrmSession.DrmSessionException) z3.a.e(drmSessionException);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        return androidx.media3.common.j.f9251a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean b() {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public androidx.media3.decoder.b c() {
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean d(String str) {
        return false;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void e(@Nullable b.a aVar) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void f(@Nullable b.a aVar) {
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException getError() {
        return this.f10295a;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }
}
