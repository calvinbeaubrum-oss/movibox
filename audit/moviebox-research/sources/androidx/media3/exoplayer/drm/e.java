package androidx.media3.exoplayer.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DrmInitData;
import e4.x3;
import i4.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public final class e implements g {
    @Override // androidx.media3.exoplayer.drm.g
    public int a() {
        return 1;
    }

    @Override // androidx.media3.exoplayer.drm.g
    public androidx.media3.decoder.b b(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public boolean c(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void closeSession(byte[] bArr) {
    }

    @Override // androidx.media3.exoplayer.drm.g
    public g.a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public /* synthetic */ void e(byte[] bArr, x3 x3Var) {
        v.a(this, bArr, x3Var);
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void f(@Nullable g.b bVar) {
    }

    @Override // androidx.media3.exoplayer.drm.g
    public g.d getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // androidx.media3.exoplayer.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void release() {
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }
}
