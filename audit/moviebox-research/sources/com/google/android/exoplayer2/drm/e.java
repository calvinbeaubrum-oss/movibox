package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import qg.u1;
import sg.v;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(18)
public final class e implements g {
    @Override // com.google.android.exoplayer2.drm.g
    public int a() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.g
    public com.google.android.exoplayer2.decoder.b b(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public boolean c(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void closeSession(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void e(@Nullable g.b bVar) {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public /* synthetic */ void f(byte[] bArr, u1 u1Var) {
        v.a(this, bArr, u1Var);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void release() {
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }
}
