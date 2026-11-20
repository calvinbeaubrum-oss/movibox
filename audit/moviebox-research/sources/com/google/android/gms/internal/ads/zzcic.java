package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcic extends zzchw implements zzhy {
    private String zzd;
    private final zzcgk zze;
    private boolean zzf;
    private final zzcib zzg;
    private final zzchh zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private final Object zzk;
    private final String zzl;
    private final int zzm;
    private boolean zzn;

    public zzcic(zzcgl zzcglVar, zzcgk zzcgkVar) {
        super(zzcglVar);
        this.zze = zzcgkVar;
        this.zzg = new zzcib();
        this.zzh = new zzchh();
        this.zzk = new Object();
        this.zzl = (String) zzfwz.zzd(zzcglVar != null ? zzcglVar.zzr() : null).zzb("");
        this.zzm = zzcglVar != null ? zzcglVar.zzf() : 0;
    }

    public static final String zzm(String str) {
        return "cache:".concat(String.valueOf(zzcdv.zze(str)));
    }

    private final void zzv() {
        int iZza = (int) this.zzg.zza();
        int iZza2 = (int) this.zzh.zza(this.zzi);
        int iPosition = this.zzi.position();
        int iRound = Math.round(iZza2 * (iPosition / iZza));
        int iZzs = zzcgc.zzs();
        int iZzu = zzcgc.zzu();
        String str = this.zzd;
        zzn(str, zzm(str), iPosition, iZza, iRound, iZza2, iRound > 0, iZzs, iZzu);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zza(zzgw zzgwVar, zzhb zzhbVar, boolean z11, int i11) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzb(zzgw zzgwVar, zzhb zzhbVar, boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzgw zzgwVar, zzhb zzhbVar, boolean z11) {
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzd(zzgw zzgwVar, zzhb zzhbVar, boolean z11) {
        if (zzgwVar instanceof zzhj) {
            this.zzg.zzb((zzhj) zzgwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzchw
    public final void zzf() {
        this.zzf = true;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final ByteBuffer zzk() {
        synchronized (this.zzk) {
            try {
                ByteBuffer byteBuffer = this.zzi;
                if (byteBuffer != null && !this.zzj) {
                    byteBuffer.flip();
                    this.zzj = true;
                }
                this.zzf = true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return this.zzi;
    }

    public final boolean zzl() {
        return this.zzn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:? -> B:23:0x00cf). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzchw
    public final boolean zzt(String str) throws Throwable {
        String str2;
        this.zzd = str;
        String str3 = "error";
        String strZzm = zzm(str);
        int i11 = 0;
        try {
            zzhe zzheVar = new zzhe();
            zzheVar.zzf(this.zzb);
            zzheVar.zzc(this.zze.zzd);
            zzheVar.zzd(this.zze.zzf);
            zzheVar.zzb(true);
            zzheVar.zze(this);
            zzgw zzgwVarZza = zzheVar.zza();
            if (this.zze.zzj) {
                zzgwVarZza = new zzchf(this.zza, zzgwVarZza, this.zzl, this.zzm, null, null);
            }
            zzgwVarZza.zzb(new zzhb(Uri.parse(str)));
            zzcgl zzcglVar = (zzcgl) this.zzc.get();
            if (zzcglVar != null) {
                zzcglVar.zzt(strZzm, this);
            }
            Clock clockZzB = com.google.android.gms.ads.internal.zzt.zzB();
            long jCurrentTimeMillis = clockZzB.currentTimeMillis();
            long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzy)).longValue();
            long jLongValue2 = ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzx)).longValue();
            this.zzi = ByteBuffer.allocate(this.zze.zzc);
            int i12 = 8192;
            byte[] bArr = new byte[8192];
            long j11 = jCurrentTimeMillis;
            while (true) {
                int iZza = zzgwVarZza.zza(bArr, i11, Math.min(this.zzi.remaining(), i12));
                if (iZza == -1) {
                    this.zzn = true;
                    zzj(str, strZzm, (int) this.zzh.zza(this.zzi));
                    break;
                }
                synchronized (this.zzk) {
                    try {
                        if (!this.zzf) {
                            try {
                                this.zzi.put(bArr, 0, iZza);
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        try {
                            if (this.zzi.remaining() <= 0) {
                                zzv();
                                break;
                            }
                            str2 = 1;
                            try {
                                if (this.zzf) {
                                    throw new IOException("Precache abort at " + this.zzi.limit() + " bytes");
                                }
                                long jCurrentTimeMillis2 = clockZzB.currentTimeMillis();
                                if (jCurrentTimeMillis2 - j11 >= jLongValue) {
                                    zzv();
                                    j11 = jCurrentTimeMillis2;
                                }
                                if (jCurrentTimeMillis2 - jCurrentTimeMillis > 1000 * jLongValue2) {
                                    throw new IOException("Timeout exceeded. Limit: " + jLongValue2 + " sec");
                                }
                                str3 = str3;
                                i11 = 0;
                                i12 = 8192;
                            } catch (Exception e11) {
                                e = e11;
                                String str4 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                                zzcec.zzj("Failed to preload url " + str + " Exception: " + str4);
                                zzg(str, strZzm, str2, str4);
                                return false;
                            }
                        } catch (Exception e12) {
                            e = e12;
                            str2 = str3;
                            String str5 = e.getClass().getCanonicalName() + ":" + e.getMessage();
                            zzcec.zzj("Failed to preload url " + str + " Exception: " + str5);
                            zzg(str, strZzm, str2, str5);
                            return false;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
            }
            return true;
        } catch (Exception e13) {
            e = e13;
            str3 = str3;
        }
    }
}
