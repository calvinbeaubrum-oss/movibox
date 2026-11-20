package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzrn extends zzdu {
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private byte[] zzh = zzfy.zzf;
    private int zzi;
    private long zzj;

    @Override // com.google.android.gms.internal.ads.zzdu, com.google.android.gms.internal.ads.zzdt
    public final ByteBuffer zzb() {
        int i11;
        if (super.zzh() && (i11 = this.zzi) > 0) {
            zzj(i11).put(this.zzh, 0, this.zzi).flip();
            this.zzi = 0;
        }
        return super.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i11 = iLimit - iPosition;
        if (i11 == 0) {
            return;
        }
        int iMin = Math.min(i11, this.zzg);
        this.zzj += (long) (iMin / this.zzb.zze);
        this.zzg -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.zzg <= 0) {
            int i12 = i11 - iMin;
            int length = (this.zzi + i12) - this.zzh.length;
            ByteBuffer byteBufferZzj = zzj(length);
            int iMax = Math.max(0, Math.min(length, this.zzi));
            byteBufferZzj.put(this.zzh, 0, iMax);
            int iMax2 = Math.max(0, Math.min(length - iMax, i12));
            byteBuffer.limit(byteBuffer.position() + iMax2);
            byteBufferZzj.put(byteBuffer);
            byteBuffer.limit(iLimit);
            int i13 = i12 - iMax2;
            int i14 = this.zzi - iMax;
            this.zzi = i14;
            byte[] bArr = this.zzh;
            System.arraycopy(bArr, iMax, bArr, 0, i14);
            byteBuffer.get(this.zzh, this.zzi, i13);
            this.zzi += i13;
            byteBufferZzj.flip();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdu, com.google.android.gms.internal.ads.zzdt
    public final boolean zzh() {
        return super.zzh() && this.zzi == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final zzdr zzi(zzdr zzdrVar) throws zzds {
        if (zzdrVar.zzd != 2) {
            throw new zzds("Unhandled input format:", zzdrVar);
        }
        this.zzf = true;
        return (this.zzd == 0 && this.zze == 0) ? zzdr.zza : zzdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzk() {
        if (this.zzf) {
            this.zzf = false;
            int i11 = this.zze;
            int i12 = this.zzb.zze;
            this.zzh = new byte[i11 * i12];
            this.zzg = this.zzd * i12;
        }
        this.zzi = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzl() {
        if (this.zzf) {
            int i11 = this.zzi;
            if (i11 > 0) {
                this.zzj += (long) (i11 / this.zzb.zze);
            }
            this.zzi = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzm() {
        this.zzh = zzfy.zzf;
    }

    public final long zzo() {
        return this.zzj;
    }

    public final void zzp() {
        this.zzj = 0L;
    }

    public final void zzq(int i11, int i12) {
        this.zzd = i11;
        this.zze = i12;
    }
}
