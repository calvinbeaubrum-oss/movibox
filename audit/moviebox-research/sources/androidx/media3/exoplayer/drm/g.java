package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import androidx.media3.common.DrmInitData;
import e4.x3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f10296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10298c;

        public a(byte[] bArr, String str, int i11) {
            this.f10296a = bArr;
            this.f10297b = str;
            this.f10298c = i11;
        }

        public byte[] a() {
            return this.f10296a;
        }

        public String b() {
            return this.f10297b;
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
        public final byte[] f10299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f10300b;

        public d(byte[] bArr, String str) {
            this.f10299a = bArr;
            this.f10300b = str;
        }

        public byte[] a() {
            return this.f10299a;
        }

        public String b() {
            return this.f10300b;
        }
    }

    int a();

    androidx.media3.decoder.b b(byte[] bArr) throws MediaCryptoException;

    boolean c(byte[] bArr, String str);

    void closeSession(byte[] bArr);

    a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    void e(byte[] bArr, x3 x3Var);

    void f(@Nullable b bVar);

    d getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
