package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrk {
    private static final byte[] zza = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, Ascii.FS, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};
    private static final byte[] zzb = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Ascii.VT, -103, 87, 83, 1, Ascii.DLE, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};
    private ByteBuffer zzc = zzdt.zza;
    private int zze = 0;
    private int zzd = 2;

    private static final void zzc(ByteBuffer byteBuffer, long j11, int i11, int i12, boolean z11) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(true != z11 ? (byte) 0 : (byte) 2);
        byteBuffer.putLong(j11);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i11);
        byteBuffer.putInt(0);
        byteBuffer.put(zzgcw.zza(i12));
    }

    public final void zza(zzih zzihVar, List list) {
        int length;
        ByteBuffer byteBuffer = zzihVar.zzc;
        byteBuffer.getClass();
        if (byteBuffer.limit() - zzihVar.zzc.position() == 0) {
            return;
        }
        byte[] bArr = null;
        if (this.zzd == 2 && (list.size() == 1 || list.size() == 3)) {
            bArr = (byte[]) list.get(0);
        }
        ByteBuffer byteBuffer2 = zzihVar.zzc;
        int iPosition = byteBuffer2.position();
        int iLimit = byteBuffer2.limit();
        int i11 = iLimit - iPosition;
        int i12 = (i11 + 255) / 255;
        int i13 = i12 + 27 + i11;
        if (this.zzd == 2) {
            length = bArr != null ? bArr.length + 28 : 47;
            i13 += length + 44;
        } else {
            length = 0;
        }
        if (this.zzc.capacity() < i13) {
            this.zzc = ByteBuffer.allocate(i13).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.zzc.clear();
        }
        ByteBuffer byteBuffer3 = this.zzc;
        if (this.zzd == 2) {
            if (bArr != null) {
                zzc(byteBuffer3, 0L, 0, 1, true);
                int length2 = bArr.length;
                byteBuffer3.put(zzgcw.zza(length2));
                byteBuffer3.put(bArr);
                int i14 = length2 + 28;
                byteBuffer3.putInt(22, zzfy.zzd(byteBuffer3.array(), byteBuffer3.arrayOffset(), i14, 0));
                byteBuffer3.position(i14);
            } else {
                byteBuffer3.put(zza);
            }
            byteBuffer3.put(zzb);
        }
        int iZzc = this.zze + zzadq.zzc(byteBuffer2);
        this.zze = iZzc;
        zzc(byteBuffer3, iZzc, this.zzd, i12, false);
        for (int i15 = 0; i15 < i12; i15++) {
            if (i11 >= 255) {
                byteBuffer3.put((byte) -1);
                i11 -= 255;
            } else {
                byteBuffer3.put((byte) i11);
                i11 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBuffer3.put(byteBuffer2.get(iPosition));
            iPosition++;
        }
        byteBuffer2.position(byteBuffer2.limit());
        byteBuffer3.flip();
        if (this.zzd == 2) {
            byteBuffer3.putInt(length + 66, zzfy.zzd(byteBuffer3.array(), byteBuffer3.arrayOffset() + length + 44, byteBuffer3.limit() - byteBuffer3.position(), 0));
        } else {
            byteBuffer3.putInt(22, zzfy.zzd(byteBuffer3.array(), byteBuffer3.arrayOffset(), byteBuffer3.limit() - byteBuffer3.position(), 0));
        }
        this.zzd++;
        this.zzc = byteBuffer3;
        zzihVar.zzb();
        zzihVar.zzi(this.zzc.remaining());
        zzihVar.zzc.put(this.zzc);
        zzihVar.zzj();
    }

    public final void zzb() {
        this.zzc = zzdt.zza;
        this.zze = 0;
        this.zzd = 2;
    }
}
