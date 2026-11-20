package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgi implements zzbx {
    public static final Parcelable.Creator<zzgi> CREATOR = new zzgg();
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzgi(long j11, long j12, long j13) {
        this.zza = j11;
        this.zzb = j12;
        this.zzc = j13;
    }

    public /* synthetic */ zzgi(Parcel parcel, zzgh zzghVar) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgi)) {
            return false;
        }
        zzgi zzgiVar = (zzgi) obj;
        return this.zza == zzgiVar.zza && this.zzb == zzgiVar.zzb && this.zzc == zzgiVar.zzc;
    }

    public final int hashCode() {
        long j11 = this.zzc;
        long j12 = this.zza;
        int i11 = ((int) (j12 ^ (j12 >>> 32))) + 527;
        long j13 = j11 ^ (j11 >>> 32);
        long j14 = this.zzb;
        return (((i11 * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + ((int) j13);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
