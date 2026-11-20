package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzgmk {
    private final zzgmi zza;
    private final zzgmi zzb;

    public zzgmk(byte[] bArr) throws GeneralSecurityException {
        if (!zzgmv.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.zza = zza(bArr, 1);
        this.zzb = zza(bArr, 0);
    }

    public abstract zzgmi zza(byte[] bArr, int i11) throws InvalidKeyException;

    public final byte[] zzb(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            this.zzb.zzc(bArr, 0).get(bArr4);
            int length = bArr2.length;
            int i11 = length & 15;
            int i12 = i11 == 0 ? length : (length + 16) - i11;
            int iRemaining = byteBuffer.remaining();
            int i13 = iRemaining % 16;
            int i14 = (i13 == 0 ? iRemaining : (iRemaining + 16) - i13) + i12;
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i14 + 16).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(bArr2);
            byteBufferOrder.position(i12);
            byteBufferOrder.put(byteBuffer);
            byteBufferOrder.position(i14);
            byteBufferOrder.putLong(length);
            byteBufferOrder.putLong(iRemaining);
            if (!MessageDigest.isEqual(zzgmn.zza(bArr4, byteBufferOrder.array()), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            return this.zza.zzd(bArr, byteBuffer);
        } catch (GeneralSecurityException e11) {
            throw new AEADBadTagException(e11.toString());
        }
    }
}
