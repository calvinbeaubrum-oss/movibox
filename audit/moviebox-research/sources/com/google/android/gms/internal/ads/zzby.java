package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzby implements Parcelable {
    public static final Parcelable.Creator<zzby> CREATOR = new zzbw();
    public final long zza;
    private final zzbx[] zzb;

    public zzby(long j11, zzbx... zzbxVarArr) {
        this.zza = j11;
        this.zzb = zzbxVarArr;
    }

    public zzby(Parcel parcel) {
        this.zzb = new zzbx[parcel.readInt()];
        int i11 = 0;
        while (true) {
            zzbx[] zzbxVarArr = this.zzb;
            if (i11 >= zzbxVarArr.length) {
                this.zza = parcel.readLong();
                return;
            } else {
                zzbxVarArr[i11] = (zzbx) parcel.readParcelable(zzbx.class.getClassLoader());
                i11++;
            }
        }
    }

    public zzby(List list) {
        this(C.TIME_UNSET, (zzbx[]) list.toArray(new zzbx[0]));
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzby.class == obj.getClass()) {
            zzby zzbyVar = (zzby) obj;
            if (Arrays.equals(this.zzb, zzbyVar.zzb) && this.zza == zzbyVar.zza) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = Arrays.hashCode(this.zzb) * 31;
        long j11 = this.zza;
        return iHashCode + ((int) (j11 ^ (j11 >>> 32)));
    }

    public final String toString() {
        String str;
        long j11 = this.zza;
        String string = Arrays.toString(this.zzb);
        if (j11 == C.TIME_UNSET) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j11;
        }
        return "entries=" + string + str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeInt(this.zzb.length);
        for (zzbx zzbxVar : this.zzb) {
            parcel.writeParcelable(zzbxVar, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbx zzb(int i11) {
        return this.zzb[i11];
    }

    public final zzby zzc(zzbx... zzbxVarArr) {
        int length = zzbxVarArr.length;
        if (length == 0) {
            return this;
        }
        long j11 = this.zza;
        zzbx[] zzbxVarArr2 = this.zzb;
        int i11 = zzfy.zza;
        int length2 = zzbxVarArr2.length;
        Object[] objArrCopyOf = Arrays.copyOf(zzbxVarArr2, length2 + length);
        System.arraycopy(zzbxVarArr, 0, objArrCopyOf, length2, length);
        return new zzby(j11, (zzbx[]) objArrCopyOf);
    }

    public final zzby zzd(@Nullable zzby zzbyVar) {
        return zzbyVar == null ? this : zzc(zzbyVar.zzb);
    }
}
