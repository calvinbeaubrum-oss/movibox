package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import qg.u1;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface g {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f33174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f33175b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f33176c;

        public a(byte[] bArr, String str, int i11) {
            this.f33174a = bArr;
            this.f33175b = str;
            this.f33176c = i11;
        }

        public byte[] a() {
            return this.f33174a;
        }

        public String b() {
            return this.f33175b;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(g gVar, @Nullable byte[] bArr, int i11, int i12, @Nullable byte[] bArr2);
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
        g a(UUID uuid);
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f33177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f33178b;

        public d(byte[] bArr, String str) {
            this.f33177a = bArr;
            this.f33178b = str;
        }

        public byte[] a() {
            return this.f33177a;
        }

        public String b() {
            return this.f33178b;
        }
    }

    int a();

    com.google.android.exoplayer2.decoder.b b(byte[] bArr) throws MediaCryptoException;

    boolean c(byte[] bArr, String str);

    void closeSession(byte[] bArr);

    a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    void e(@Nullable b bVar);

    void f(byte[] bArr, u1 u1Var);

    d getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
