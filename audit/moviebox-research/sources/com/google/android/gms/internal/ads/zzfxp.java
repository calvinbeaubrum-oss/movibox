package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfxp extends zzfwj {
    final CharSequence zzb;
    final zzfwp zzc;
    int zzd = 0;
    int zze = Api.BaseClientBuilder.API_PRIORITY_OTHER;

    public zzfxp(zzfxr zzfxrVar, CharSequence charSequence) {
        this.zzc = zzfxrVar.zza;
        this.zzb = charSequence;
    }

    @Override // com.google.android.gms.internal.ads.zzfwj
    public final /* bridge */ /* synthetic */ Object zza() {
        int iZzc;
        int i11 = this.zzd;
        while (true) {
            int i12 = this.zzd;
            if (i12 == -1) {
                zzb();
                return null;
            }
            int iZzd = zzd(i12);
            if (iZzd == -1) {
                iZzd = this.zzb.length();
                this.zzd = -1;
                iZzc = -1;
            } else {
                iZzc = zzc(iZzd);
                this.zzd = iZzc;
            }
            if (iZzc != i11) {
                if (i11 < iZzd) {
                    this.zzb.charAt(i11);
                }
                if (i11 < iZzd) {
                    this.zzb.charAt(iZzd - 1);
                }
                int i13 = this.zze;
                if (i13 == 1) {
                    iZzd = this.zzb.length();
                    this.zzd = -1;
                    if (iZzd > i11) {
                        this.zzb.charAt(iZzd - 1);
                    }
                } else {
                    this.zze = i13 - 1;
                }
                return this.zzb.subSequence(i11, iZzd).toString();
            }
            int i14 = iZzc + 1;
            this.zzd = i14;
            if (i14 > this.zzb.length()) {
                this.zzd = -1;
            }
        }
    }

    public abstract int zzc(int i11);

    public abstract int zzd(int i11);
}
