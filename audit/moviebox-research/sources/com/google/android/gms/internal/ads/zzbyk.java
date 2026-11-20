package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzbyk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbyk> CREATOR = new zzbyl();

    @SafeParcelable.Field(id = 2)
    public final boolean zza;

    @Nullable
    @SafeParcelable.Field(id = 3)
    public final List zzb;

    public zzbyk() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzbyk(@SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) List list) {
        this.zza = z11;
        this.zzb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        boolean z11 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, z11);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
