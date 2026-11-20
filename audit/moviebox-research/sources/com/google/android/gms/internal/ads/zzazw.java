package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazw extends zzazr {
    private MessageDigest zzb;

    @Override // com.google.android.gms.internal.ads.zzazr
    public final byte[] zzb(String str) {
        byte[] bArr;
        byte[] bArrArray;
        String[] strArrSplit = str.split(" ");
        int length = strArrSplit.length;
        int i11 = 4;
        if (length == 1) {
            int iZza = zzazv.zza(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iZza);
            bArrArray = byteBufferAllocate.array();
        } else {
            if (length < 5) {
                bArr = new byte[length + length];
                for (int i12 = 0; i12 < strArrSplit.length; i12++) {
                    int iZza2 = zzazv.zza(strArrSplit[i12]);
                    int i13 = (iZza2 >> 16) ^ ((char) iZza2);
                    int i14 = i12 + i12;
                    bArr[i14] = (byte) i13;
                    bArr[i14 + 1] = (byte) (i13 >> 8);
                }
            } else {
                bArr = new byte[length];
                for (int i15 = 0; i15 < strArrSplit.length; i15++) {
                    int iZza3 = zzazv.zza(strArrSplit[i15]);
                    bArr[i15] = (byte) ((iZza3 >> 24) ^ (((iZza3 & 255) ^ ((iZza3 >> 8) & 255)) ^ ((iZza3 >> 16) & 255)));
                }
            }
            bArrArray = bArr;
        }
        this.zzb = zza();
        synchronized (this.zza) {
            try {
                MessageDigest messageDigest = this.zzb;
                if (messageDigest == null) {
                    return new byte[0];
                }
                messageDigest.reset();
                this.zzb.update(bArrArray);
                byte[] bArrDigest = this.zzb.digest();
                int length2 = bArrDigest.length;
                if (length2 <= 4) {
                    i11 = length2;
                }
                byte[] bArr2 = new byte[i11];
                System.arraycopy(bArrDigest, 0, bArr2, 0, i11);
                return bArr2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
