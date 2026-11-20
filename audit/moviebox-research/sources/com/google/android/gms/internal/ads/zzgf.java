package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgf implements zzbx {
    public static final Parcelable.Creator<zzgf> CREATOR = new zzgd();
    public final float zza;
    public final float zzb;

    public zzgf(float f11, float f12) {
        boolean z11 = false;
        if (f11 >= -90.0f && f11 <= 90.0f && f12 >= -180.0f && f12 <= 180.0f) {
            z11 = true;
        }
        zzek.zze(z11, "Invalid latitude or longitude");
        this.zza = f11;
        this.zzb = f12;
    }

    public /* synthetic */ zzgf(Parcel parcel, zzge zzgeVar) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readFloat();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzgf.class == obj.getClass()) {
            zzgf zzgfVar = (zzgf) obj;
            if (this.zza == zzgfVar.zza && this.zzb == zzgfVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.zza).hashCode() + 527) * 31) + Float.valueOf(this.zzb).hashCode();
    }

    public final String toString() {
        return "xyz: latitude=" + this.zza + ", longitude=" + this.zzb;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.zza);
        parcel.writeFloat(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
