package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaga implements zzbx {
    public static final Parcelable.Creator<zzaga> CREATOR = new zzafz();
    public final int zza;

    @Nullable
    public final String zzb;

    @Nullable
    public final String zzc;

    @Nullable
    public final String zzd;
    public final boolean zze;
    public final int zzf;

    public zzaga(int i11, @Nullable String str, @Nullable String str2, @Nullable String str3, boolean z11, int i12) {
        boolean z12 = true;
        if (i12 != -1 && i12 <= 0) {
            z12 = false;
        }
        zzek.zzd(z12);
        this.zza = i11;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z11;
        this.zzf = i12;
    }

    public zzaga(Parcel parcel) {
        this.zza = parcel.readInt();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.readString();
        int i11 = zzfy.zza;
        this.zze = parcel.readInt() != 0;
        this.zzf = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaga.class == obj.getClass()) {
            zzaga zzagaVar = (zzaga) obj;
            if (this.zza == zzagaVar.zza && zzfy.zzF(this.zzb, zzagaVar.zzb) && zzfy.zzF(this.zzc, zzagaVar.zzc) && zzfy.zzF(this.zzd, zzagaVar.zzd) && this.zze == zzagaVar.zze && this.zzf == zzagaVar.zzf) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zzb;
        int iHashCode = str != null ? str.hashCode() : 0;
        int i11 = this.zza;
        String str2 = this.zzc;
        int iHashCode2 = str2 != null ? str2.hashCode() : 0;
        int i12 = ((i11 + 527) * 31) + iHashCode;
        String str3 = this.zzd;
        return (((((((i12 * 31) + iHashCode2) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + (this.zze ? 1 : 0)) * 31) + this.zzf;
    }

    public final String toString() {
        return "IcyHeaders: name=\"" + this.zzc + "\", genre=\"" + this.zzb + "\", bitrate=" + this.zza + ", metadataInterval=" + this.zzf;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeString(this.zzd);
        int i12 = zzfy.zza;
        parcel.writeInt(this.zze ? 1 : 0);
        parcel.writeInt(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        String str = this.zzc;
        if (str != null) {
            zzbtVar.zzp(str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            zzbtVar.zzi(str2);
        }
    }
}
