package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamt implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzams
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzamt(0)};
        }
    };
    private final zzamu zzb;
    private final zzfp zzc;
    private final zzfp zzd;
    private final zzfo zze;
    private zzacx zzf;
    private long zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;

    public zzamt() {
        this(0);
    }

    public zzamt(int i11) {
        this.zzb = new zzamu(true, null);
        this.zzc = new zzfp(2048);
        this.zzh = -1L;
        zzfp zzfpVar = new zzfp(10);
        this.zzd = zzfpVar;
        byte[] bArrZzM = zzfpVar.zzM();
        this.zze = new zzfo(bArrZzM, bArrZzM.length);
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzf);
        int iZza = zzacvVar.zza(this.zzc.zzM(), 0, 2048);
        if (!this.zzj) {
            this.zzf.zzO(new zzadt(C.TIME_UNSET, 0L));
            this.zzj = true;
        }
        if (iZza == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(iZza);
        if (!this.zzi) {
            this.zzb.zzd(this.zzg, 4);
            this.zzi = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzf = zzacxVar;
        this.zzb.zzb(zzacxVar, new zzaok(Integer.MIN_VALUE, 0, 1));
        zzacxVar.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzi = false;
        this.zzb.zze();
        this.zzg = j12;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        int i11 = 0;
        while (true) {
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(this.zzd.zzM(), 0, 10, false);
            this.zzd.zzK(0);
            if (this.zzd.zzo() != 4801587) {
                break;
            }
            this.zzd.zzL(3);
            int iZzl = this.zzd.zzl();
            i11 += iZzl + 10;
            zzackVar.zzl(iZzl, false);
        }
        zzacvVar.zzj();
        zzack zzackVar2 = (zzack) zzacvVar;
        zzackVar2.zzl(i11, false);
        if (this.zzh == -1) {
            this.zzh = i11;
        }
        int i12 = i11;
        int i13 = 0;
        int i14 = 0;
        do {
            zzackVar2.zzm(this.zzd.zzM(), 0, 2, false);
            this.zzd.zzK(0);
            if (zzamu.zzf(this.zzd.zzq())) {
                i13++;
                if (i13 >= 4 && i14 > 188) {
                    return true;
                }
                zzackVar2.zzm(this.zzd.zzM(), 0, 4, false);
                this.zze.zzk(14);
                int iZzd = this.zze.zzd(13);
                if (iZzd <= 6) {
                    i12++;
                    zzacvVar.zzj();
                    zzackVar2.zzl(i12, false);
                } else {
                    zzackVar2.zzl(iZzd - 6, false);
                    i14 += iZzd;
                }
            } else {
                i12++;
                zzacvVar.zzj();
                zzackVar2.zzl(i12, false);
            }
            i13 = 0;
            i14 = 0;
        } while (i12 - i11 < 8192);
        return false;
    }
}
