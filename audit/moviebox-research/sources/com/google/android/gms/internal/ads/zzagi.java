package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagi extends zzagr {
    public static final Parcelable.Creator<zzagi> CREATOR = new zzagh();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzagr[] zze;

    public zzagi(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int i11 = zzfy.zza;
        this.zza = string;
        this.zzb = parcel.readByte() != 0;
        this.zzc = parcel.readByte() != 0;
        this.zzd = parcel.createStringArray();
        int i12 = parcel.readInt();
        this.zze = new zzagr[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            this.zze[i13] = (zzagr) parcel.readParcelable(zzagr.class.getClassLoader());
        }
    }

    public zzagi(String str, boolean z11, boolean z12, String[] strArr, zzagr[] zzagrVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
        this.zzd = strArr;
        this.zze = zzagrVarArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagi.class == obj.getClass()) {
            zzagi zzagiVar = (zzagi) obj;
            if (this.zzb == zzagiVar.zzb && this.zzc == zzagiVar.zzc && zzfy.zzF(this.zza, zzagiVar.zza) && Arrays.equals(this.zzd, zzagiVar.zzd) && Arrays.equals(this.zze, zzagiVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.zza;
        return (((((this.zzb ? 1 : 0) + 527) * 31) + (this.zzc ? 1 : 0)) * 31) + (str != null ? str.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeByte(this.zzb ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.zzc ? (byte) 1 : (byte) 0);
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        for (zzagr zzagrVar : this.zze) {
            parcel.writeParcelable(zzagrVar, 0);
        }
    }
}
