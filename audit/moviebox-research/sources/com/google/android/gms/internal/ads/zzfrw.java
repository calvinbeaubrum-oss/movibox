package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "GassEventParcelCreator")
public final class zzfrw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfrw> CREATOR = new zzfrx();

    @SafeParcelable.VersionField(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final byte[] zzb;

    @SafeParcelable.Constructor
    public zzfrw(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.zza = i11;
        this.zzb = bArr;
    }

    public zzfrw(byte[] bArr) {
        this(1, bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        int i12 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i12);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
