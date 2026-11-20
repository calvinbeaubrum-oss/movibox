package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzcei extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcei> CREATOR = new zzcej();

    @SafeParcelable.Field(id = 2)
    public String zza;

    @SafeParcelable.Field(id = 3)
    public int zzb;

    @SafeParcelable.Field(id = 4)
    public int zzc;

    @SafeParcelable.Field(id = 5)
    public boolean zzd;

    @SafeParcelable.Field(id = 6)
    public boolean zze;

    public zzcei(int i11, int i12, boolean z11, boolean z12) {
        this(240304000, i12, true, false, z12);
    }

    public zzcei(int i11, int i12, boolean z11, boolean z12, boolean z13) {
        this("afma-sdk-a-v" + i11 + InstructionFileId.DOT + i12 + InstructionFileId.DOT + (z11 ? "0" : "1"), i11, i12, z11, z13);
    }

    @SafeParcelable.Constructor
    public zzcei(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i11, @SafeParcelable.Param(id = 4) int i12, @SafeParcelable.Param(id = 5) boolean z11, @SafeParcelable.Param(id = 6) boolean z12) {
        this.zza = str;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = z11;
        this.zze = z12;
    }

    public static zzcei zza() {
        return new zzcei(12451000, 12451000, true, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzb);
        SafeParcelWriter.writeInt(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
