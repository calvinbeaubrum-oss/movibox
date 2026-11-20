package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajn {
    public final boolean zza;

    @Nullable
    public final String zzb;
    public final zzadz zzc;
    public final int zzd;

    @Nullable
    public final byte[] zze;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public zzajn(boolean z11, @Nullable String str, int i11, byte[] bArr, int i12, int i13, @Nullable byte[] bArr2) {
        byte b11 = 0;
        int i14 = 1;
        zzek.zzd((i11 == 0) ^ (bArr2 == null));
        this.zza = z11;
        this.zzb = str;
        this.zzd = i11;
        this.zze = bArr2;
        if (str != null) {
            switch (str.hashCode()) {
                case 3046605:
                    if (!str.equals(C.CENC_TYPE_cbc1)) {
                        b11 = -1;
                    } else {
                        b11 = 2;
                    }
                    break;
                case 3046671:
                    if (!str.equals(C.CENC_TYPE_cbcs)) {
                        b11 = -1;
                    } else {
                        b11 = 3;
                    }
                    break;
                case 3049879:
                    if (!str.equals(C.CENC_TYPE_cenc)) {
                        b11 = -1;
                    }
                    break;
                case 3049895:
                    if (!str.equals(C.CENC_TYPE_cens)) {
                        b11 = -1;
                    } else {
                        b11 = 1;
                    }
                    break;
                default:
                    b11 = -1;
                    break;
            }
            if (b11 != 0 && b11 != 1) {
                if (b11 == 2 || b11 == 3) {
                    i14 = 2;
                } else {
                    zzff.zzf("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
                }
            }
        }
        this.zzc = new zzadz(i14, bArr, i12, i13);
    }
}
