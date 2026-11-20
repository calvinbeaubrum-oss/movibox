package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanm implements zzamy {
    private final zzfp zza;
    private final zzado zzb;

    @Nullable
    private final String zzc;
    private zzaea zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzanm() {
        this(null);
    }

    public zzanm(@Nullable String str) {
        this.zzf = 0;
        zzfp zzfpVar = new zzfp(4);
        this.zza = zzfpVar;
        zzfpVar.zzM()[0] = -1;
        this.zzb = new zzado();
        this.zzl = C.TIME_UNSET;
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzd);
        while (zzfpVar.zzb() > 0) {
            int i11 = this.zzf;
            if (i11 == 0) {
                byte[] bArrZzM = zzfpVar.zzM();
                int iZzd = zzfpVar.zzd();
                int iZze = zzfpVar.zze();
                while (true) {
                    if (iZzd >= iZze) {
                        zzfpVar.zzK(iZze);
                        break;
                    }
                    int i12 = iZzd + 1;
                    byte b11 = bArrZzM[iZzd];
                    boolean z11 = (b11 & 255) == 255;
                    boolean z12 = this.zzi && (b11 & 224) == 224;
                    this.zzi = z11;
                    if (z12) {
                        zzfpVar.zzK(i12);
                        this.zzi = false;
                        this.zza.zzM()[1] = bArrZzM[iZzd];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    iZzd = i12;
                }
            } else if (i11 != 1) {
                int iMin = Math.min(zzfpVar.zzb(), this.zzk - this.zzg);
                this.zzd.zzr(zzfpVar, iMin);
                int i13 = this.zzg + iMin;
                this.zzg = i13;
                if (i13 >= this.zzk) {
                    zzek.zzf(this.zzl != C.TIME_UNSET);
                    this.zzd.zzt(this.zzl, 1, this.zzk, 0, null);
                    this.zzl += this.zzj;
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int iMin2 = Math.min(zzfpVar.zzb(), 4 - this.zzg);
                zzfpVar.zzG(this.zza.zzM(), this.zzg, iMin2);
                int i14 = this.zzg + iMin2;
                this.zzg = i14;
                if (i14 >= 4) {
                    this.zza.zzK(0);
                    if (this.zzb.zza(this.zza.zzg())) {
                        zzado zzadoVar = this.zzb;
                        this.zzk = zzadoVar.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzadoVar.zzg) * 1000000) / ((long) zzadoVar.zzd);
                            zzak zzakVar = new zzak();
                            zzakVar.zzK(this.zze);
                            zzakVar.zzW(this.zzb.zzb);
                            zzakVar.zzO(4096);
                            zzakVar.zzy(this.zzb.zze);
                            zzakVar.zzX(this.zzb.zzd);
                            zzakVar.zzN(this.zzc);
                            this.zzd.zzl(zzakVar.zzac());
                            this.zzh = true;
                        }
                        this.zza.zzK(0);
                        this.zzd.zzr(this.zza, 4);
                        this.zzf = 2;
                    } else {
                        this.zzg = 0;
                        this.zzf = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zze = zzaokVar.zzb();
        this.zzd = zzacxVar.zzw(zzaokVar.zza(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzl = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = false;
        this.zzl = C.TIME_UNSET;
    }
}
