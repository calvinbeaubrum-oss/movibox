package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfux extends zzfvp {
    private final int zza;

    @Nullable
    private final String zzb;

    public /* synthetic */ zzfux(int i11, String str, zzfuw zzfuwVar) {
        this.zza = i11;
        this.zzb = str;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfvp) {
            zzfvp zzfvpVar = (zzfvp) obj;
            if (this.zza == zzfvpVar.zza() && ((str = this.zzb) != null ? str.equals(zzfvpVar.zzb()) : zzfvpVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        return (str == null ? 0 : str.hashCode()) ^ ((this.zza ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "OverlayDisplayState{statusCode=" + this.zza + ", sessionToken=" + this.zzb + "}";
    }

    @Override // com.google.android.gms.internal.ads.zzfvp
    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzfvp
    @Nullable
    public final String zzb() {
        return this.zzb;
    }
}
