package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahe implements zzbx {
    public static final Parcelable.Creator<zzahe> CREATOR = new zzahc();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzahe(long j11, long j12, long j13, long j14, long j15) {
        this.zza = j11;
        this.zzb = j12;
        this.zzc = j13;
        this.zzd = j14;
        this.zze = j15;
    }

    public /* synthetic */ zzahe(Parcel parcel, zzahd zzahdVar) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahe.class == obj.getClass()) {
            zzahe zzaheVar = (zzahe) obj;
            if (this.zza == zzaheVar.zza && this.zzb == zzaheVar.zzb && this.zzc == zzaheVar.zzc && this.zzd == zzaheVar.zzd && this.zze == zzaheVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j11 = this.zze;
        long j12 = this.zza;
        int i11 = ((int) (j12 ^ (j12 >>> 32))) + 527;
        long j13 = j11 ^ (j11 >>> 32);
        long j14 = this.zzd;
        long j15 = j14 ^ (j14 >>> 32);
        long j16 = this.zzc;
        long j17 = j16 ^ (j16 >>> 32);
        long j18 = this.zzb;
        return (((((((i11 * 31) + ((int) (j18 ^ (j18 >>> 32)))) * 31) + ((int) j17)) * 31) + ((int) j15)) * 31) + ((int) j13);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.zza + ", photoSize=" + this.zzb + ", photoPresentationTimestampUs=" + this.zzc + ", videoStartPosition=" + this.zzd + ", videoSize=" + this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
