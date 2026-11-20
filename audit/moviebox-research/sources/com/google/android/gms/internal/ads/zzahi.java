package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahi implements Parcelable {
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzahg
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            zzahi zzahiVar = (zzahi) obj;
            zzahi zzahiVar2 = (zzahi) obj2;
            return zzfzp.zzk().zzc(zzahiVar.zzb, zzahiVar2.zzb).zzc(zzahiVar.zzc, zzahiVar2.zzc).zzb(zzahiVar.zzd, zzahiVar2.zzd).zza();
        }
    };
    public static final Parcelable.Creator<zzahi> CREATOR = new zzahh();

    public zzahi(long j11, long j12, int i11) {
        zzek.zzd(j11 < j12);
        this.zzb = j11;
        this.zzc = j12;
        this.zzd = i11;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzahi.class == obj.getClass()) {
            zzahi zzahiVar = (zzahi) obj;
            if (this.zzb == zzahiVar.zzb && this.zzc == zzahiVar.zzc && this.zzd == zzahiVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return String.format(Locale.US, "Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeInt(this.zzd);
    }
}
