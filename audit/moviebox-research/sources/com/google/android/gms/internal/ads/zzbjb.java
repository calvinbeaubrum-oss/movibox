package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
public final class zzbjb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbjb> CREATOR = new zzbjc();

    @SafeParcelable.Field(id = 1)
    public final int zza;

    @SafeParcelable.Field(id = 2)
    public final boolean zzb;

    @SafeParcelable.Field(id = 3)
    public final int zzc;

    @SafeParcelable.Field(id = 4)
    public final boolean zzd;

    @SafeParcelable.Field(id = 5)
    public final int zze;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final com.google.android.gms.ads.internal.client.zzfk zzf;

    @SafeParcelable.Field(id = 7)
    public final boolean zzg;

    @SafeParcelable.Field(id = 8)
    public final int zzh;

    @SafeParcelable.Field(id = 9)
    public final int zzi;

    @SafeParcelable.Field(id = 10)
    public final boolean zzj;

    @SafeParcelable.Field(id = 11)
    public final int zzk;

    @SafeParcelable.Constructor
    public zzbjb(@SafeParcelable.Param(id = 1) int i11, @SafeParcelable.Param(id = 2) boolean z11, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) boolean z12, @SafeParcelable.Param(id = 5) int i13, @SafeParcelable.Param(id = 6) com.google.android.gms.ads.internal.client.zzfk zzfkVar, @SafeParcelable.Param(id = 7) boolean z13, @SafeParcelable.Param(id = 8) int i14, @SafeParcelable.Param(id = 9) int i15, @SafeParcelable.Param(id = 10) boolean z14, @SafeParcelable.Param(id = 11) int i16) {
        this.zza = i11;
        this.zzb = z11;
        this.zzc = i12;
        this.zzd = z12;
        this.zze = i13;
        this.zzf = zzfkVar;
        this.zzg = z13;
        this.zzh = i14;
        this.zzj = z14;
        this.zzi = i15;
        this.zzk = i16;
    }

    @Deprecated
    public zzbjb(@NonNull NativeAdOptions nativeAdOptions) {
        this(4, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new com.google.android.gms.ads.internal.client.zzfk(nativeAdOptions.getVideoOptions()) : null, nativeAdOptions.zza(), nativeAdOptions.getMediaAspectRatio(), 0, false, 0);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x002e  */
    @NonNull
    public static com.google.android.gms.ads.nativead.NativeAdOptions zza(@Nullable zzbjb zzbjbVar) {
        com.google.android.gms.ads.nativead.NativeAdOptions.Builder builder = new com.google.android.gms.ads.nativead.NativeAdOptions.Builder();
        if (zzbjbVar == null) {
            return builder.build();
        }
        int i11 = zzbjbVar.zza;
        int i12 = 2;
        if (i11 == 2) {
            builder.setAdChoicesPlacement(zzbjbVar.zze);
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    builder.setRequestCustomMuteThisAd(zzbjbVar.zzg);
                    builder.setMediaAspectRatio(zzbjbVar.zzh);
                    builder.enableCustomClickGestureDirection(zzbjbVar.zzi, zzbjbVar.zzj);
                    int i13 = zzbjbVar.zzk;
                    if (i13 == 0) {
                        i12 = 1;
                    } else if (i13 == 2) {
                        i12 = 3;
                    } else if (i13 != 1) {
                        i12 = 1;
                    }
                    builder.zzi(i12);
                }
            }
            com.google.android.gms.ads.internal.client.zzfk zzfkVar = zzbjbVar.zzf;
            if (zzfkVar != null) {
                builder.setVideoOptions(new VideoOptions(zzfkVar));
            }
            builder.setAdChoicesPlacement(zzbjbVar.zze);
        }
        builder.setReturnUrlsForImageAssets(zzbjbVar.zzb);
        builder.setRequestMultipleImages(zzbjbVar.zzd);
        return builder.build();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        int i12 = this.zza;
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i12);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i11, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeInt(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
