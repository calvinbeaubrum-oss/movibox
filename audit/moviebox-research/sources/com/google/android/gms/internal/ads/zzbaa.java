package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbaa extends zzazr {
    private MessageDigest zzb;
    private final int zzc;
    private final int zzd;

    public zzbaa(int i11) {
        int i12 = i11 >> 3;
        this.zzc = (i11 & 7) > 0 ? i12 + 1 : i12;
        this.zzd = i11;
    }

    @Override // com.google.android.gms.internal.ads.zzazr
    public final byte[] zzb(String str) {
        synchronized (this.zza) {
            try {
                MessageDigest messageDigestZza = zza();
                this.zzb = messageDigestZza;
                if (messageDigestZza == null) {
                    return new byte[0];
                }
                messageDigestZza.reset();
                this.zzb.update(str.getBytes(Charset.forName("UTF-8")));
                byte[] bArrDigest = this.zzb.digest();
                int length = bArrDigest.length;
                int i11 = this.zzc;
                if (length > i11) {
                    length = i11;
                }
                byte[] bArr = new byte[length];
                System.arraycopy(bArrDigest, 0, bArr, 0, length);
                if ((this.zzd & 7) > 0) {
                    long j11 = 0;
                    for (int i12 = 0; i12 < length; i12++) {
                        if (i12 > 0) {
                            j11 <<= 8;
                        }
                        j11 += (long) (bArr[i12] & 255);
                    }
                    long j12 = j11 >>> (8 - (this.zzd & 7));
                    int i13 = this.zzc;
                    while (true) {
                        i13--;
                        if (i13 < 0) {
                            break;
                        }
                        bArr[i13] = (byte) (255 & j12);
                        j12 >>>= 8;
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
