package com.google.android.gms.internal.ads;

import com.google.android.gms.location.DeviceOrientationRequest;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrl extends zzdu {
    private int zzd;
    private boolean zze;
    private byte[] zzf;
    private byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;
    private long zzl;

    public zzrl() {
        byte[] bArr = zzfy.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    private final int zzq(long j11) {
        return (int) ((j11 * ((long) this.zzb.zzb)) / 1000000);
    }

    private final int zzr(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > 1024) {
                int i11 = this.zzd;
                return i11 * (iPosition / i11);
            }
        }
        return byteBuffer.limit();
    }

    private final void zzs(byte[] bArr, int i11) {
        zzj(i11).put(bArr, 0, i11).flip();
        if (i11 > 0) {
            this.zzk = true;
        }
    }

    private final void zzt(ByteBuffer byteBuffer, byte[] bArr, int i11) {
        int iMin = Math.min(byteBuffer.remaining(), this.zzj);
        int i12 = this.zzj - iMin;
        System.arraycopy(bArr, i11 - i12, this.zzg, 0, i12);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.zzg, i12, iMin);
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        int iPosition;
        while (byteBuffer.hasRemaining() && !zzn()) {
            int i11 = this.zzh;
            if (i11 == 0) {
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.zzf.length));
                int iLimit2 = byteBuffer.limit();
                while (true) {
                    iLimit2 -= 2;
                    if (iLimit2 < byteBuffer.position()) {
                        iPosition = byteBuffer.position();
                        break;
                    } else if (Math.abs((int) byteBuffer.getShort(iLimit2)) > 1024) {
                        int i12 = this.zzd;
                        iPosition = ((iLimit2 / i12) * i12) + i12;
                        break;
                    }
                }
                if (iPosition == byteBuffer.position()) {
                    this.zzh = 1;
                } else {
                    byteBuffer.limit(iPosition);
                    int iRemaining = byteBuffer.remaining();
                    zzj(iRemaining).put(byteBuffer).flip();
                    if (iRemaining > 0) {
                        this.zzk = true;
                    }
                }
                byteBuffer.limit(iLimit);
            } else if (i11 != 1) {
                int iLimit3 = byteBuffer.limit();
                int iZzr = zzr(byteBuffer);
                byteBuffer.limit(iZzr);
                this.zzl += (long) (byteBuffer.remaining() / this.zzd);
                zzt(byteBuffer, this.zzg, this.zzj);
                if (iZzr < iLimit3) {
                    zzs(this.zzg, this.zzj);
                    this.zzh = 0;
                    byteBuffer.limit(iLimit3);
                }
            } else {
                int iLimit4 = byteBuffer.limit();
                int iZzr2 = zzr(byteBuffer);
                int iPosition2 = iZzr2 - byteBuffer.position();
                byte[] bArr = this.zzf;
                int length = bArr.length;
                int i13 = this.zzi;
                int i14 = length - i13;
                if (iZzr2 >= iLimit4 || iPosition2 >= i14) {
                    int iMin = Math.min(iPosition2, i14);
                    byteBuffer.limit(byteBuffer.position() + iMin);
                    byteBuffer.get(this.zzf, this.zzi, iMin);
                    int i15 = this.zzi + iMin;
                    this.zzi = i15;
                    byte[] bArr2 = this.zzf;
                    if (i15 == bArr2.length) {
                        if (this.zzk) {
                            zzs(bArr2, this.zzj);
                            long j11 = this.zzl;
                            int i16 = this.zzi;
                            int i17 = this.zzj;
                            this.zzl = j11 + ((long) ((i16 - (i17 + i17)) / this.zzd));
                            i15 = i16;
                        } else {
                            this.zzl += (long) ((i15 - this.zzj) / this.zzd);
                        }
                        zzt(byteBuffer, this.zzf, i15);
                        this.zzi = 0;
                        this.zzh = 2;
                    }
                    byteBuffer.limit(iLimit4);
                } else {
                    zzs(bArr, i13);
                    this.zzi = 0;
                    this.zzh = 0;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdu, com.google.android.gms.internal.ads.zzdt
    public final boolean zzg() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final zzdr zzi(zzdr zzdrVar) throws zzds {
        if (zzdrVar.zzd == 2) {
            return this.zze ? zzdrVar : zzdr.zza;
        }
        throw new zzds("Unhandled input format:", zzdrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzk() {
        if (this.zze) {
            this.zzd = this.zzb.zze;
            int iZzq = zzq(150000L) * this.zzd;
            if (this.zzf.length != iZzq) {
                this.zzf = new byte[iZzq];
            }
            int iZzq2 = zzq(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) * this.zzd;
            this.zzj = iZzq2;
            if (this.zzg.length != iZzq2) {
                this.zzg = new byte[iZzq2];
            }
        }
        this.zzh = 0;
        this.zzl = 0L;
        this.zzi = 0;
        this.zzk = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzl() {
        int i11 = this.zzi;
        if (i11 > 0) {
            zzs(this.zzf, i11);
            this.zzi = 0;
            this.zzh = 0;
        }
        if (this.zzk) {
            return;
        }
        this.zzl += (long) (this.zzj / this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzdu
    public final void zzm() {
        this.zze = false;
        this.zzj = 0;
        byte[] bArr = zzfy.zzf;
        this.zzf = bArr;
        this.zzg = bArr;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final void zzp(boolean z11) {
        this.zze = z11;
    }
}
