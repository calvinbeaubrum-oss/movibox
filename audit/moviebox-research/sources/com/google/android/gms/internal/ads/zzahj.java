package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzahj implements zzbx {
    public static final Parcelable.Creator<zzahj> CREATOR = new zzahf();
    public final List zza;

    public zzahj(List list) {
        this.zza = list;
        boolean z11 = false;
        if (!list.isEmpty()) {
            long j11 = ((zzahi) list.get(0)).zzc;
            for (int i11 = 1; i11 < list.size(); i11++) {
                if (((zzahi) list.get(i11)).zzb < j11) {
                    z11 = true;
                    break;
                }
                j11 = ((zzahi) list.get(i11)).zzc;
            }
        }
        zzek.zzd(!z11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzahj.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzahj) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return "SlowMotion: segments=".concat(this.zza.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeList(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
