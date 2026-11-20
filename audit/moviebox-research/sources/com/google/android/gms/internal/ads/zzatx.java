package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzatx {
    static boolean zza = false;
    public static final /* synthetic */ int zzc = 0;
    private static MessageDigest zzd;
    private static final Object zze = new Object();
    private static final Object zzf = new Object();
    static final CountDownLatch zzb = new CountDownLatch(1);

    public static String zza(byte[] bArr, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] bArrZzg;
        Vector vectorZzb = zzb(bArr, 255);
        if (vectorZzb == null || vectorZzb.isEmpty()) {
            bArrZzg = zzg(zzf(4096).zzax(), str, true);
        } else {
            zzatp zzatpVarZza = zzatq.zza();
            int size = vectorZzb.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzatpVarZza.zza(zzgyl.zzv(zzg((byte[]) vectorZzb.get(i11), str, false), 0, 256));
            }
            byte[] bArrZze = zze(bArr);
            zzgyl zzgylVar = zzgyl.zzb;
            zzatpVarZza.zzb(zzgyl.zzv(bArrZze, 0, bArrZze.length));
            bArrZzg = ((zzatq) zzatpVarZza.zzal()).zzax();
        }
        return zzatt.zza(bArrZzg, true);
    }

    public static Vector zzb(byte[] bArr, int i11) {
        int length = bArr.length;
        if (length <= 0) {
            return null;
        }
        int i12 = length + 254;
        Vector vector = new Vector();
        for (int i13 = 0; i13 < i12 / 255; i13++) {
            int i14 = i13 * 255;
            try {
                int length2 = bArr.length;
                if (length2 - i14 > 255) {
                    length2 = i14 + 255;
                }
                vector.add(Arrays.copyOfRange(bArr, i14, length2));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    public static void zzd() {
        synchronized (zzf) {
            try {
                if (!zza) {
                    zza = true;
                    new Thread(new zzatw(null)).start();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static byte[] zze(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] bArrDigest;
        MessageDigest messageDigest;
        synchronized (zze) {
            try {
                zzd();
                MessageDigest messageDigest2 = null;
                try {
                    if (zzb.await(2L, TimeUnit.SECONDS) && (messageDigest = zzd) != null) {
                        messageDigest2 = messageDigest;
                    }
                } catch (InterruptedException unused) {
                }
                if (messageDigest2 == null) {
                    throw new NoSuchAlgorithmException("Cannot compute hash");
                }
                messageDigest2.reset();
                messageDigest2.update(bArr);
                bArrDigest = zzd.digest();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return bArrDigest;
    }

    public static zzatd zzf(int i11) {
        zzasg zzasgVarZza = zzatd.zza();
        zzasgVarZza.zzD(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
        return (zzatd) zzasgVarZza.zzal();
    }

    private static byte[] zzg(byte[] bArr, String str, boolean z11) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] bArrArray;
        int length = bArr.length;
        int i11 = true != z11 ? 255 : 239;
        if (length > i11) {
            bArr = zzf(4096).zzax();
        }
        int i12 = i11 + 1;
        int length2 = bArr.length;
        byte b11 = (byte) length2;
        if (length2 < i11) {
            byte[] bArr2 = new byte[i11 - length2];
            new SecureRandom().nextBytes(bArr2);
            bArrArray = ByteBuffer.allocate(i12).put(b11).put(bArr).put(bArr2).array();
        } else {
            bArrArray = ByteBuffer.allocate(i12).put(b11).put(bArr).array();
        }
        if (z11) {
            bArrArray = ByteBuffer.allocate(256).put(zze(bArrArray)).put(bArrArray).array();
        }
        byte[] bArr3 = new byte[256];
        zzaty[] zzatyVarArr = new zzaux().zzcG;
        int length3 = zzatyVarArr.length;
        for (int i13 = 0; i13 < 12; i13++) {
            zzatyVarArr[i13].zza(bArrArray, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzatr(str.getBytes("UTF-8")).zza(bArr3);
        }
        return bArr3;
    }
}
