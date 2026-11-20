package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzqg extends zzdu {

    @Nullable
    private int[] zzd;

    @Nullable
    private int[] zze;

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        int[] iArr = this.zze;
        iArr.getClass();
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferZzj = zzj(((iLimit - iPosition) / this.zzb.zze) * this.zzc.zze);
        while (iPosition < iLimit) {
            for (int i11 : iArr) {
                byteBufferZzj.putShort(byteBuffer.getShort(i11 + i11 + iPosition));
            }
            iPosition += this.zzb.zze;
        }
        byteBuffer.position(iLimit);
        byteBufferZzj.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final zzdr zzi(zzdr zzdrVar) throws zzds {
        int[] iArr = this.zzd;
        if (iArr == null) {
            return zzdr.zza;
        }
        if (zzdrVar.zzd != 2) {
            throw new zzds("Unhandled input format:", zzdrVar);
        }
        boolean z11 = zzdrVar.zzc != iArr.length;
        int i11 = 0;
        while (true) {
            int length = iArr.length;
            if (i11 >= length) {
                return z11 ? new zzdr(zzdrVar.zzb, length, 2) : zzdr.zza;
            }
            int i12 = iArr[i11];
            if (i12 >= zzdrVar.zzc) {
                throw new zzds("Unhandled input format:", zzdrVar);
            }
            z11 |= i12 != i11;
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzk() {
        this.zze = this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzm() {
        this.zze = null;
        this.zzd = null;
    }

    public final void zzo(@Nullable int[] iArr) {
        this.zzd = iArr;
    }
}
