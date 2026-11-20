package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdw implements zzdt {
    private int zzb;
    private float zzc = 1.0f;
    private float zzd = 1.0f;
    private zzdr zze;
    private zzdr zzf;
    private zzdr zzg;
    private zzdr zzh;
    private boolean zzi;

    @Nullable
    private zzdv zzj;
    private ByteBuffer zzk;
    private ShortBuffer zzl;
    private ByteBuffer zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;

    public zzdw() {
        zzdr zzdrVar = zzdr.zza;
        this.zze = zzdrVar;
        this.zzf = zzdrVar;
        this.zzg = zzdrVar;
        this.zzh = zzdrVar;
        ByteBuffer byteBuffer = zzdt.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final zzdr zza(zzdr zzdrVar) throws zzds {
        if (zzdrVar.zzd != 2) {
            throw new zzds("Unhandled input format:", zzdrVar);
        }
        int i11 = this.zzb;
        if (i11 == -1) {
            i11 = zzdrVar.zzb;
        }
        this.zze = zzdrVar;
        zzdr zzdrVar2 = new zzdr(i11, zzdrVar.zzc, 2);
        this.zzf = zzdrVar2;
        this.zzi = true;
        return zzdrVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final ByteBuffer zzb() {
        int iZza;
        zzdv zzdvVar = this.zzj;
        if (zzdvVar != null && (iZza = zzdvVar.zza()) > 0) {
            if (this.zzk.capacity() < iZza) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iZza).order(ByteOrder.nativeOrder());
                this.zzk = byteBufferOrder;
                this.zzl = byteBufferOrder.asShortBuffer();
            } else {
                this.zzk.clear();
                this.zzl.clear();
            }
            zzdvVar.zzd(this.zzl);
            this.zzo += (long) iZza;
            this.zzk.limit(iZza);
            this.zzm = this.zzk;
        }
        ByteBuffer byteBuffer = this.zzm;
        this.zzm = zzdt.zza;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzc() {
        if (zzg()) {
            zzdr zzdrVar = this.zze;
            this.zzg = zzdrVar;
            zzdr zzdrVar2 = this.zzf;
            this.zzh = zzdrVar2;
            if (this.zzi) {
                this.zzj = new zzdv(zzdrVar.zzb, zzdrVar.zzc, this.zzc, this.zzd, zzdrVar2.zzb);
            } else {
                zzdv zzdvVar = this.zzj;
                if (zzdvVar != null) {
                    zzdvVar.zzc();
                }
            }
        }
        this.zzm = zzdt.zza;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzd() {
        zzdv zzdvVar = this.zzj;
        if (zzdvVar != null) {
            zzdvVar.zze();
        }
        this.zzp = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zze(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            zzdv zzdvVar = this.zzj;
            zzdvVar.getClass();
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.zzn += (long) iRemaining;
            zzdvVar.zzf(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final void zzf() {
        this.zzc = 1.0f;
        this.zzd = 1.0f;
        zzdr zzdrVar = zzdr.zza;
        this.zze = zzdrVar;
        this.zzf = zzdrVar;
        this.zzg = zzdrVar;
        this.zzh = zzdrVar;
        ByteBuffer byteBuffer = zzdt.zza;
        this.zzk = byteBuffer;
        this.zzl = byteBuffer.asShortBuffer();
        this.zzm = byteBuffer;
        this.zzb = -1;
        this.zzi = false;
        this.zzj = null;
        this.zzn = 0L;
        this.zzo = 0L;
        this.zzp = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzg() {
        if (this.zzf.zzb != -1) {
            return Math.abs(this.zzc + (-1.0f)) >= 1.0E-4f || Math.abs(this.zzd + (-1.0f)) >= 1.0E-4f || this.zzf.zzb != this.zze.zzb;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdt
    public final boolean zzh() {
        if (!this.zzp) {
            return false;
        }
        zzdv zzdvVar = this.zzj;
        return zzdvVar == null || zzdvVar.zza() == 0;
    }

    public final long zzi(long j11) {
        long j12 = this.zzo;
        if (j12 < 1024) {
            return (long) (((double) this.zzc) * j11);
        }
        long j13 = this.zzn;
        zzdv zzdvVar = this.zzj;
        zzdvVar.getClass();
        long jZzb = j13 - ((long) zzdvVar.zzb());
        int i11 = this.zzh.zzb;
        int i12 = this.zzg.zzb;
        return i11 == i12 ? zzfy.zzs(j11, jZzb, j12, RoundingMode.FLOOR) : zzfy.zzs(j11, jZzb * ((long) i11), j12 * ((long) i12), RoundingMode.FLOOR);
    }

    public final void zzj(float f11) {
        if (this.zzd != f11) {
            this.zzd = f11;
            this.zzi = true;
        }
    }

    public final void zzk(float f11) {
        if (this.zzc != f11) {
            this.zzc = f11;
            this.zzi = true;
        }
    }
}
