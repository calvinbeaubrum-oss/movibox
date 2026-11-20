package com.google.android.gms.internal.ads;

import android.os.IBinder;
import com.applovin.exoplayer2.common.base.Ascii;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfus extends zzfvm {
    private IBinder zza;
    private String zzb;
    private int zzc;
    private float zzd;
    private int zze;
    private String zzf;
    private byte zzg;

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zza(String str) {
        this.zzf = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzc(int i11) {
        this.zzg = (byte) (this.zzg | 8);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzd(int i11) {
        this.zzc = i11;
        this.zzg = (byte) (this.zzg | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zze(float f11) {
        this.zzd = f11;
        this.zzg = (byte) (this.zzg | 4);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzf(boolean z11) {
        this.zzg = (byte) (this.zzg | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzg(IBinder iBinder) {
        if (iBinder == null) {
            throw new NullPointerException("Null windowToken");
        }
        this.zza = iBinder;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvm zzh(int i11) {
        this.zze = i11;
        this.zzg = (byte) (this.zzg | Ascii.DLE);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzfvm
    public final zzfvn zzi() {
        IBinder iBinder;
        if (this.zzg == 31 && (iBinder = this.zza) != null) {
            return new zzfuu(iBinder, false, this.zzb, this.zzc, this.zzd, 0, null, this.zze, null, this.zzf, null, null);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" windowToken");
        }
        if ((this.zzg & 1) == 0) {
            sb2.append(" stableSessionToken");
        }
        if ((this.zzg & 2) == 0) {
            sb2.append(" layoutGravity");
        }
        if ((this.zzg & 4) == 0) {
            sb2.append(" layoutVerticalMargin");
        }
        if ((this.zzg & 8) == 0) {
            sb2.append(" displayMode");
        }
        if ((this.zzg & Ascii.DLE) == 0) {
            sb2.append(" windowWidthPx");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }
}
