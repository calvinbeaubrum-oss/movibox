package com.google.android.gms.internal.ads;

import android.text.Layout;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzalu {

    @Nullable
    private String zza;
    private int zzb;
    private boolean zzc;
    private int zzd;
    private boolean zze;
    private float zzk;

    @Nullable
    private String zzl;

    @Nullable
    private Layout.Alignment zzo;

    @Nullable
    private Layout.Alignment zzp;

    @Nullable
    private zzaln zzr;
    private int zzf = -1;
    private int zzg = -1;
    private int zzh = -1;
    private int zzi = -1;
    private int zzj = -1;
    private int zzm = -1;
    private int zzn = -1;
    private int zzq = -1;
    private float zzs = Float.MAX_VALUE;

    public final zzalu zzA(boolean z11) {
        this.zzq = z11 ? 1 : 0;
        return this;
    }

    public final zzalu zzB(@Nullable zzaln zzalnVar) {
        this.zzr = zzalnVar;
        return this;
    }

    public final zzalu zzC(boolean z11) {
        this.zzg = z11 ? 1 : 0;
        return this;
    }

    @Nullable
    public final String zzD() {
        return this.zza;
    }

    @Nullable
    public final String zzE() {
        return this.zzl;
    }

    public final boolean zzF() {
        return this.zzq == 1;
    }

    public final boolean zzG() {
        return this.zze;
    }

    public final boolean zzH() {
        return this.zzc;
    }

    public final boolean zzI() {
        return this.zzf == 1;
    }

    public final boolean zzJ() {
        return this.zzg == 1;
    }

    public final float zza() {
        return this.zzk;
    }

    public final float zzb() {
        return this.zzs;
    }

    public final int zzc() {
        if (this.zze) {
            return this.zzd;
        }
        throw new IllegalStateException("Background color has not been defined.");
    }

    public final int zzd() {
        if (this.zzc) {
            return this.zzb;
        }
        throw new IllegalStateException("Font color has not been defined.");
    }

    public final int zze() {
        return this.zzj;
    }

    public final int zzf() {
        return this.zzn;
    }

    public final int zzg() {
        return this.zzm;
    }

    public final int zzh() {
        int i11 = this.zzh;
        if (i11 == -1 && this.zzi == -1) {
            return -1;
        }
        return (i11 == 1 ? 1 : 0) | (this.zzi == 1 ? 2 : 0);
    }

    @Nullable
    public final Layout.Alignment zzi() {
        return this.zzp;
    }

    @Nullable
    public final Layout.Alignment zzj() {
        return this.zzo;
    }

    @Nullable
    public final zzaln zzk() {
        return this.zzr;
    }

    public final zzalu zzl(@Nullable zzalu zzaluVar) {
        int i11;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        String str;
        if (zzaluVar != null) {
            if (!this.zzc && zzaluVar.zzc) {
                zzo(zzaluVar.zzb);
            }
            if (this.zzh == -1) {
                this.zzh = zzaluVar.zzh;
            }
            if (this.zzi == -1) {
                this.zzi = zzaluVar.zzi;
            }
            if (this.zza == null && (str = zzaluVar.zza) != null) {
                this.zza = str;
            }
            if (this.zzf == -1) {
                this.zzf = zzaluVar.zzf;
            }
            if (this.zzg == -1) {
                this.zzg = zzaluVar.zzg;
            }
            if (this.zzn == -1) {
                this.zzn = zzaluVar.zzn;
            }
            if (this.zzo == null && (alignment2 = zzaluVar.zzo) != null) {
                this.zzo = alignment2;
            }
            if (this.zzp == null && (alignment = zzaluVar.zzp) != null) {
                this.zzp = alignment;
            }
            if (this.zzq == -1) {
                this.zzq = zzaluVar.zzq;
            }
            if (this.zzj == -1) {
                this.zzj = zzaluVar.zzj;
                this.zzk = zzaluVar.zzk;
            }
            if (this.zzr == null) {
                this.zzr = zzaluVar.zzr;
            }
            if (this.zzs == Float.MAX_VALUE) {
                this.zzs = zzaluVar.zzs;
            }
            if (!this.zze && zzaluVar.zze) {
                zzm(zzaluVar.zzd);
            }
            if (this.zzm == -1 && (i11 = zzaluVar.zzm) != -1) {
                this.zzm = i11;
            }
        }
        return this;
    }

    public final zzalu zzm(int i11) {
        this.zzd = i11;
        this.zze = true;
        return this;
    }

    public final zzalu zzn(boolean z11) {
        this.zzh = z11 ? 1 : 0;
        return this;
    }

    public final zzalu zzo(int i11) {
        this.zzb = i11;
        this.zzc = true;
        return this;
    }

    public final zzalu zzp(@Nullable String str) {
        this.zza = str;
        return this;
    }

    public final zzalu zzq(float f11) {
        this.zzk = f11;
        return this;
    }

    public final zzalu zzr(int i11) {
        this.zzj = i11;
        return this;
    }

    public final zzalu zzs(@Nullable String str) {
        this.zzl = str;
        return this;
    }

    public final zzalu zzt(boolean z11) {
        this.zzi = z11 ? 1 : 0;
        return this;
    }

    public final zzalu zzu(boolean z11) {
        this.zzf = z11 ? 1 : 0;
        return this;
    }

    public final zzalu zzv(@Nullable Layout.Alignment alignment) {
        this.zzp = alignment;
        return this;
    }

    public final zzalu zzw(int i11) {
        this.zzn = i11;
        return this;
    }

    public final zzalu zzx(int i11) {
        this.zzm = i11;
        return this;
    }

    public final zzalu zzy(float f11) {
        this.zzs = f11;
        return this;
    }

    public final zzalu zzz(@Nullable Layout.Alignment alignment) {
        this.zzo = alignment;
        return this;
    }
}
