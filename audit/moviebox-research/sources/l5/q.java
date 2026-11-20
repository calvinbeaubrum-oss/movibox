package l5;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import u4.r0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f69939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f69940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0.a f69941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final byte[] f69943e;

    public q(boolean z11, @Nullable String str, int i11, byte[] bArr, int i12, int i13, @Nullable byte[] bArr2) {
        z3.a.a((bArr2 == null) ^ (i11 == 0));
        this.f69939a = z11;
        this.f69940b = str;
        this.f69942d = i11;
        this.f69943e = bArr2;
        this.f69941c = new r0.a(a(str), bArr, i12, i13);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int a(@Nullable String str) {
        if (str == null) {
            return 1;
        }
        byte b11 = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    b11 = 0;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    b11 = 1;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    b11 = 2;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    b11 = 3;
                }
                break;
        }
        switch (b11) {
            case 0:
            case 1:
                return 2;
            default:
                z3.o.h("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
