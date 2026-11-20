package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzrm extends zzdu {
    private static final int zzd = Float.floatToIntBits(Float.NaN);

    private static void zzo(int i11, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i11) * 4.656612875245797E-10d));
        if (iFloatToIntBits == zzd) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferZzj;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        int i12 = this.zzb.zzd;
        if (i12 == 21) {
            byteBufferZzj = zzj((i11 / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else if (i12 == 22) {
            byteBufferZzj = zzj(i11);
            while (iPosition < iLimit) {
                int i13 = byteBuffer.get(iPosition) & 255;
                int i14 = (byteBuffer.get(iPosition + 1) & 255) << 8;
                zzo(i13 | i14 | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        } else if (i12 == 1342177280) {
            byteBufferZzj = zzj((i11 / 3) * 4);
            while (iPosition < iLimit) {
                zzo(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 3;
            }
        } else {
            if (i12 != 1610612736) {
                throw new IllegalStateException();
            }
            byteBufferZzj = zzj(i11);
            while (iPosition < iLimit) {
                int i15 = byteBuffer.get(iPosition + 3) & 255;
                int i16 = (byteBuffer.get(iPosition + 2) & 255) << 8;
                zzo(i15 | i16 | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferZzj);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final zzdr zzi(zzdr zzdrVar) throws zzds {
        int i11 = zzdrVar.zzd;
        int i12 = zzfy.zza;
        if (i11 == 21 || i11 == 1342177280 || i11 == 22 || i11 == 1610612736) {
            return new zzdr(zzdrVar.zzb, zzdrVar.zzc, 4);
        }
        if (i11 == 4) {
            return zzdr.zza;
        }
        throw new zzds("Unhandled input format:", zzdrVar);
    }
}
