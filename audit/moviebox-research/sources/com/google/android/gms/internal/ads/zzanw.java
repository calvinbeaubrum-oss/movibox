package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanw implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzanu
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzanw()};
        }
    };
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;

    @Nullable
    private zzans zzj;
    private zzacx zzk;
    private boolean zzl;
    private final zzfw zzb = new zzfw(0);
    private final zzfp zzd = new zzfp(4096);
    private final SparseArray zzc = new SparseArray();
    private final zzant zze = new zzant();

    /* JADX WARN: Code duplicated, block: B:64:0x014f  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzamy zzanaVar;
        zzek.zzb(this.zzk);
        long jZzd = zzacvVar.zzd();
        if (jZzd != -1) {
            zzant zzantVar = this.zze;
            if (!zzantVar.zze()) {
                return zzantVar.zza(zzacvVar, zzadrVar);
            }
        }
        if (!this.zzl) {
            this.zzl = true;
            zzant zzantVar2 = this.zze;
            if (zzantVar2.zzb() != C.TIME_UNSET) {
                zzans zzansVar = new zzans(zzantVar2.zzd(), zzantVar2.zzb(), jZzd);
                this.zzj = zzansVar;
                this.zzk.zzO(zzansVar.zzb());
            } else {
                this.zzk.zzO(new zzadt(zzantVar2.zzb(), 0L));
            }
        }
        zzans zzansVar2 = this.zzj;
        if (zzansVar2 != null && zzansVar2.zze()) {
            return zzansVar2.zza(zzacvVar, zzadrVar);
        }
        zzacvVar.zzj();
        long jZze = jZzd != -1 ? jZzd - zzacvVar.zze() : -1L;
        if ((jZze != -1 && jZze < 4) || !zzacvVar.zzm(this.zzd.zzM(), 0, 4, true)) {
            return -1;
        }
        this.zzd.zzK(0);
        int iZzg = this.zzd.zzg();
        if (iZzg == 441) {
            return -1;
        }
        if (iZzg == 442) {
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zzd.zzM(), 0, 10, false);
            this.zzd.zzK(9);
            zzackVar.zzo((this.zzd.zzm() & 7) + 14, false);
            return 0;
        }
        if (iZzg == 443) {
            zzack zzackVar2 = (zzack) zzacvVar;
            zzackVar2.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            zzackVar2.zzo(this.zzd.zzq() + 6, false);
            return 0;
        }
        if ((iZzg >> 8) != 1) {
            ((zzack) zzacvVar).zzo(1, false);
            return 0;
        }
        int i11 = iZzg & 255;
        zzanv zzanvVar = (zzanv) this.zzc.get(i11);
        if (!this.zzf) {
            if (zzanvVar == null) {
                zzamy zzamyVar = null;
                if (i11 == 189) {
                    zzanaVar = new zzamo(null);
                    this.zzg = true;
                    this.zzi = zzacvVar.zzf();
                } else if ((iZzg & 224) == 192) {
                    zzanaVar = new zzanm(null);
                    this.zzg = true;
                    this.zzi = zzacvVar.zzf();
                } else if ((iZzg & 240) == 224) {
                    zzanaVar = new zzana(null);
                    this.zzh = true;
                    this.zzi = zzacvVar.zzf();
                } else if (zzamyVar != null) {
                    zzamyVar.zzb(this.zzk, new zzaok(Integer.MIN_VALUE, i11, 256));
                    zzanvVar = new zzanv(zzamyVar, this.zzb);
                    this.zzc.put(i11, zzanvVar);
                }
                zzamyVar = zzanaVar;
                if (zzamyVar != null) {
                    zzamyVar.zzb(this.zzk, new zzaok(Integer.MIN_VALUE, i11, 256));
                    zzanvVar = new zzanv(zzamyVar, this.zzb);
                    this.zzc.put(i11, zzanvVar);
                }
            }
            boolean z11 = this.zzg;
            long j11 = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            if (z11 && this.zzh) {
                j11 = PlaybackStateCompat.ACTION_PLAY_FROM_URI + this.zzi;
            }
            if (zzacvVar.zzf() > j11) {
                this.zzf = true;
                this.zzk.zzD();
            }
        }
        zzack zzackVar3 = (zzack) zzacvVar;
        zzackVar3.zzm(this.zzd.zzM(), 0, 2, false);
        this.zzd.zzK(0);
        int iZzq = this.zzd.zzq() + 6;
        if (zzanvVar == null) {
            zzackVar3.zzo(iZzq, false);
        } else {
            this.zzd.zzH(iZzq);
            zzackVar3.zzn(this.zzd.zzM(), 0, iZzq, false);
            this.zzd.zzK(6);
            zzanvVar.zza(this.zzd);
            zzfp zzfpVar = this.zzd;
            zzfpVar.zzJ(zzfpVar.zzc());
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzk = zzacxVar;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0021  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        zzfw zzfwVar = this.zzb;
        if (zzfwVar.zzf() != C.TIME_UNSET) {
            long jZzd = zzfwVar.zzd();
            if (jZzd != C.TIME_UNSET && jZzd != 0 && jZzd != j12) {
                zzfwVar.zzi(j12);
            }
        } else {
            zzfwVar.zzi(j12);
        }
        zzans zzansVar = this.zzj;
        if (zzansVar != null) {
            zzansVar.zzd(j12);
        }
        for (int i11 = 0; i11 < this.zzc.size(); i11++) {
            ((zzanv) this.zzc.valueAt(i11)).zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        byte[] bArr = new byte[14];
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzackVar.zzl(bArr[13] & 7, false);
        zzackVar.zzm(bArr, 0, 3, false);
        return ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255)) == 1;
    }
}
