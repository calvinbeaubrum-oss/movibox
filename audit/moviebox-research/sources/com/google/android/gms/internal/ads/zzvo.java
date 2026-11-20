package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.InterruptedIOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvo implements zzzg, zzug {
    final /* synthetic */ zzvt zza;
    private final Uri zzc;
    private final zzhx zzd;
    private final zzvi zze;
    private final zzacx zzf;
    private final zzeo zzg;
    private volatile boolean zzi;
    private long zzk;

    @Nullable
    private zzaea zzm;
    private boolean zzn;
    private final zzadr zzh = new zzadr();
    private boolean zzj = true;
    private final long zzb = zzui.zza();
    private zzhb zzl = zzi(0);

    public zzvo(zzvt zzvtVar, Uri uri, zzgw zzgwVar, zzvi zzviVar, zzacx zzacxVar, zzeo zzeoVar) {
        this.zza = zzvtVar;
        this.zzc = uri;
        this.zzd = new zzhx(zzgwVar);
        this.zze = zzviVar;
        this.zzf = zzacxVar;
        this.zzg = zzeoVar;
    }

    public static /* bridge */ /* synthetic */ void zzf(zzvo zzvoVar, long j11, long j12) {
        zzvoVar.zzh.zza = j11;
        zzvoVar.zzk = j12;
        zzvoVar.zzj = true;
        zzvoVar.zzn = false;
    }

    private final zzhb zzi(long j11) {
        zzgz zzgzVar = new zzgz();
        zzgzVar.zzd(this.zzc);
        zzgzVar.zzc(j11);
        zzgzVar.zza(6);
        zzgzVar.zzb(zzvt.zzb);
        return zzgzVar.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzug
    public final void zza(zzfp zzfpVar) {
        long jMax = !this.zzn ? this.zzk : Math.max(zzvt.zzr(this.zza, true), this.zzk);
        int iZzb = zzfpVar.zzb();
        zzaea zzaeaVar = this.zzm;
        zzaeaVar.getClass();
        zzady.zzb(zzaeaVar, zzfpVar, iZzb);
        zzaeaVar.zzt(jMax, 1, iZzb, 0, null);
        this.zzn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzzg
    public final void zzg() {
        this.zzi = true;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x01dc */
    @Override // com.google.android.gms.internal.ads.zzzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzh() throws Throwable {
        boolean z11;
        int i11;
        String str;
        String str2;
        String str3;
        boolean zEquals;
        int i12;
        zzu zzuVar;
        int i13;
        int i14;
        int i15;
        int i16;
        while (!this.zzi) {
            try {
                long j11 = this.zzh.zza;
                zzhb zzhbVarZzi = zzi(j11);
                this.zzl = zzhbVarZzi;
                long jZzb = this.zzd.zzb(zzhbVarZzi);
                if (this.zzi) {
                    zzvi zzviVar = this.zze;
                    if (zzviVar.zzb() != -1) {
                        this.zzh.zza = zzviVar.zzb();
                    }
                    zzgy.zza(this.zzd);
                    return;
                }
                if (jZzb != -1) {
                    jZzb += j11;
                    zzvt.zzC(this.zza);
                }
                long j12 = jZzb;
                zzvt zzvtVar = this.zza;
                Map mapZze = this.zzd.zze();
                List list = (List) mapZze.get("icy-br");
                if (list != null) {
                    String str4 = (String) list.get(0);
                    try {
                        i16 = Integer.parseInt(str4) * 1000;
                        if (i16 > 0) {
                            i11 = i16;
                            z11 = true;
                        } else {
                            try {
                                zzff.zzf("IcyHeaders", "Invalid bitrate: " + str4);
                                z11 = false;
                                i11 = -1;
                            } catch (NumberFormatException unused) {
                                zzff.zzf("IcyHeaders", "Invalid bitrate header: ".concat(String.valueOf(str4)));
                                i11 = i16;
                                z11 = false;
                            }
                        }
                    } catch (NumberFormatException unused2) {
                        i16 = -1;
                    }
                } else {
                    z11 = false;
                    i11 = -1;
                }
                List list2 = (List) mapZze.get("icy-genre");
                if (list2 != null) {
                    str = (String) list2.get(0);
                    z11 = true;
                } else {
                    str = null;
                }
                List list3 = (List) mapZze.get("icy-name");
                if (list3 != null) {
                    str2 = (String) list3.get(0);
                    z11 = true;
                } else {
                    str2 = null;
                }
                List list4 = (List) mapZze.get("icy-url");
                if (list4 != null) {
                    str3 = (String) list4.get(0);
                    z11 = true;
                } else {
                    str3 = null;
                }
                List list5 = (List) mapZze.get("icy-pub");
                if (list5 != null) {
                    zEquals = ((String) list5.get(0)).equals("1");
                    z11 = true;
                } else {
                    zEquals = false;
                }
                List list6 = (List) mapZze.get("icy-metaint");
                if (list6 != null) {
                    String str5 = (String) list6.get(0);
                    try {
                        i15 = Integer.parseInt(str5);
                        if (i15 > 0) {
                            i12 = i15;
                            z11 = true;
                        } else {
                            try {
                                zzff.zzf("IcyHeaders", "Invalid metadata interval: " + str5);
                                i12 = -1;
                            } catch (NumberFormatException unused3) {
                                zzff.zzf("IcyHeaders", "Invalid metadata interval: ".concat(String.valueOf(str5)));
                                i12 = i15;
                            }
                        }
                    } catch (NumberFormatException unused4) {
                        i15 = -1;
                    }
                } else {
                    i12 = -1;
                }
                zzvtVar.zzs = z11 ? new zzaga(i11, str, str2, str3, zEquals, i12) : null;
                zzhx zzhxVar = this.zzd;
                zzvt zzvtVar2 = this.zza;
                if (zzvtVar2.zzs == null || zzvtVar2.zzs.zzf == -1) {
                    zzuVar = zzhxVar;
                } else {
                    zzuh zzuhVar = new zzuh(zzhxVar, zzvtVar2.zzs.zzf, this);
                    zzaea zzaeaVarZzv = this.zza.zzv();
                    this.zzm = zzaeaVarZzv;
                    zzaeaVarZzv.zzl(zzvt.zzc);
                    zzuVar = zzuhVar;
                }
                this.zze.zzd(zzuVar, this.zzc, this.zzd.zze(), j11, j12, this.zzf);
                if (this.zza.zzs != null) {
                    this.zze.zzc();
                }
                if (this.zzj) {
                    this.zze.zzf(j11, this.zzk);
                    try {
                        this.zzj = false;
                    } catch (Throwable th2) {
                        th = th2;
                        int i17 = 1;
                        int i18 = 0;
                        if (i18 != i17) {
                            zzvi zzviVar2 = this.zze;
                            if (zzviVar2.zzb() != -1) {
                                this.zzh.zza = zzviVar2.zzb();
                            }
                        }
                        zzgy.zza(this.zzd);
                        throw th;
                    }
                }
                long j13 = j11;
                int iZza = 0;
                while (true) {
                    if (iZza != 0) {
                        i13 = 1;
                        break;
                    }
                    if (this.zzi) {
                        i13 = 1;
                        iZza = 0;
                        break;
                    }
                    try {
                        this.zzg.zza();
                        iZza = this.zze.zza(this.zzh);
                        long jZzb2 = this.zze.zzb();
                        if (jZzb2 > this.zza.zzj + j13) {
                            this.zzg.zzc();
                            zzvt zzvtVar3 = this.zza;
                            zzvtVar3.zzp.post(zzvtVar3.zzo);
                            j13 = jZzb2;
                        }
                    } catch (InterruptedException unused5) {
                        throw new InterruptedIOException();
                    }
                }
                if (iZza == i13) {
                    i14 = 0;
                } else {
                    zzvi zzviVar3 = this.zze;
                    if (zzviVar3.zzb() != -1) {
                        this.zzh.zza = zzviVar3.zzb();
                    }
                    i14 = iZza;
                }
                zzgy.zza(this.zzd);
                if (i14 != 0) {
                    return;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }
}
