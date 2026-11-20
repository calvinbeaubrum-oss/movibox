package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagv extends zzagr {
    public static final Parcelable.Creator<zzagv> CREATOR = new zzagu();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzagv(int i11, int i12, int i13, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public zzagv(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        int[] iArrCreateIntArray = parcel.createIntArray();
        int i11 = zzfy.zza;
        this.zzd = iArrCreateIntArray;
        this.zze = parcel.createIntArray();
    }

    @Override // com.google.android.gms.internal.ads.zzagr, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagv.class == obj.getClass()) {
            zzagv zzagvVar = (zzagv) obj;
            if (this.zza == zzagvVar.zza && this.zzb == zzagvVar.zzb && this.zzc == zzagvVar.zzc && Arrays.equals(this.zzd, zzagvVar.zzd) && Arrays.equals(this.zze, zzagvVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zza + 527) * 31) + this.zzb) * 31) + this.zzc) * 31) + Arrays.hashCode(this.zzd)) * 31) + Arrays.hashCode(this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }
}
