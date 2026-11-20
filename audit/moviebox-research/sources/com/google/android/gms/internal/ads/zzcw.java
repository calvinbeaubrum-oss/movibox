package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcw {
    private static final String zzA;
    private static final String zzB;
    private static final String zzC;
    private static final String zzD;
    private static final String zzE;
    private static final String zzF;

    @Deprecated
    public static final zzn zzb;
    private static final zzbp zzs;
    private static final String zzt;
    private static final String zzu;
    private static final String zzv;
    private static final String zzw;
    private static final String zzx;
    private static final String zzy;
    private static final String zzz;

    @Nullable
    @Deprecated
    public Object zzd;
    public long zzf;
    public long zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;

    @Deprecated
    public boolean zzk;

    @Nullable
    public zzbf zzl;
    public boolean zzm;
    public long zzn;
    public long zzo;
    public int zzp;
    public int zzq;
    public static final Object zza = new Object();
    private static final Object zzr = new Object();
    public Object zzc = zza;
    public zzbp zze = zzs;

    static {
        zzar zzarVar = new zzar();
        zzarVar.zza("androidx.media3.common.Timeline");
        zzarVar.zzb(Uri.EMPTY);
        zzs = zzarVar.zzc();
        zzt = Integer.toString(1, 36);
        zzu = Integer.toString(2, 36);
        zzv = Integer.toString(3, 36);
        zzw = Integer.toString(4, 36);
        zzx = Integer.toString(5, 36);
        zzy = Integer.toString(6, 36);
        zzz = Integer.toString(7, 36);
        zzA = Integer.toString(8, 36);
        zzB = Integer.toString(9, 36);
        zzC = Integer.toString(10, 36);
        zzD = Integer.toString(11, 36);
        zzE = Integer.toString(12, 36);
        zzF = Integer.toString(13, 36);
        zzb = new zzn() { // from class: com.google.android.gms.internal.ads.zzcv
        };
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzcw.class.equals(obj.getClass())) {
            zzcw zzcwVar = (zzcw) obj;
            if (zzfy.zzF(this.zzc, zzcwVar.zzc) && zzfy.zzF(this.zze, zzcwVar.zze) && zzfy.zzF(null, null) && zzfy.zzF(this.zzl, zzcwVar.zzl) && this.zzf == zzcwVar.zzf && this.zzg == zzcwVar.zzg && this.zzh == zzcwVar.zzh && this.zzi == zzcwVar.zzi && this.zzj == zzcwVar.zzj && this.zzm == zzcwVar.zzm && this.zzo == zzcwVar.zzo && this.zzp == zzcwVar.zzp && this.zzq == zzcwVar.zzq) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.zzc.hashCode() + 217) * 31) + this.zze.hashCode();
        zzbf zzbfVar = this.zzl;
        int iHashCode2 = ((iHashCode * 961) + (zzbfVar == null ? 0 : zzbfVar.hashCode())) * 31;
        long j11 = this.zzf;
        int i11 = (iHashCode2 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.zzg;
        int i12 = (i11 + ((int) (j12 ^ (j12 >>> 32)))) * 31;
        long j13 = this.zzh;
        int i13 = ((((((i12 + ((int) (j13 ^ (j13 >>> 32)))) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzm ? 1 : 0);
        long j14 = this.zzo;
        return ((((((i13 * 961) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + this.zzp) * 31) + this.zzq) * 31;
    }

    public final zzcw zza(Object obj, @Nullable zzbp zzbpVar, @Nullable Object obj2, long j11, long j12, long j13, boolean z11, boolean z12, @Nullable zzbf zzbfVar, long j14, long j15, int i11, int i12, long j16) {
        this.zzc = obj;
        this.zze = zzbpVar == null ? zzs : zzbpVar;
        this.zzd = null;
        this.zzf = C.TIME_UNSET;
        this.zzg = C.TIME_UNSET;
        this.zzh = C.TIME_UNSET;
        this.zzi = z11;
        this.zzj = z12;
        this.zzk = zzbfVar != null;
        this.zzl = zzbfVar;
        this.zzn = 0L;
        this.zzo = j15;
        this.zzp = 0;
        this.zzq = 0;
        this.zzm = false;
        return this;
    }

    public final boolean zzb() {
        zzek.zzf(this.zzk == (this.zzl != null));
        return this.zzl != null;
    }
}
