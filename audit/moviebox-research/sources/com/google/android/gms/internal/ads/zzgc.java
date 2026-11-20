package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgc implements zzbx {
    public static final Parcelable.Creator<zzgc> CREATOR = new zzga();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public /* synthetic */ zzgc(Parcel parcel, zzgb zzgbVar) {
        String string = parcel.readString();
        int i11 = zzfy.zza;
        this.zza = string;
        this.zzb = parcel.createByteArray();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzgc(String str, byte[] bArr, int i11, int i12) {
        this.zza = str;
        this.zzb = bArr;
        this.zzc = i11;
        this.zzd = i12;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzgc.class == obj.getClass()) {
            zzgc zzgcVar = (zzgc) obj;
            if (this.zza.equals(zzgcVar.zza) && Arrays.equals(this.zzb, zzgcVar.zzb) && this.zzc == zzgcVar.zzc && this.zzd == zzgcVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.zza.hashCode() + 527) * 31) + Arrays.hashCode(this.zzb)) * 31) + this.zzc) * 31) + this.zzd;
    }

    public final String toString() {
        String strZzz;
        int i11 = this.zzd;
        if (i11 != 1) {
            if (i11 == 23) {
                byte[] bArr = this.zzb;
                int i12 = zzfy.zza;
                zzek.zzd(bArr.length == 4);
                strZzz = String.valueOf(Float.intBitsToFloat((bArr[3] & 255) | ((bArr[1] & 255) << 16) | (bArr[0] << Ascii.CAN) | ((bArr[2] & 255) << 8)));
            } else if (i11 != 67) {
                byte[] bArr2 = this.zzb;
                int length = bArr2.length;
                StringBuilder sb2 = new StringBuilder(length + length);
                for (int i13 = 0; i13 < bArr2.length; i13++) {
                    sb2.append(Character.forDigit((bArr2[i13] >> 4) & 15, 16));
                    sb2.append(Character.forDigit(bArr2[i13] & Ascii.SI, 16));
                }
                strZzz = sb2.toString();
            } else {
                byte[] bArr3 = this.zzb;
                int i14 = zzfy.zza;
                zzek.zzd(bArr3.length == 4);
                strZzz = String.valueOf(bArr3[3] | (bArr3[1] << Ascii.DLE) | (bArr3[0] << Ascii.CAN) | (bArr3[2] << 8));
            }
        } else {
            strZzz = zzfy.zzz(this.zzb);
        }
        return "mdta: key=" + this.zza + ", value=" + strZzz;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final /* synthetic */ void zza(zzbt zzbtVar) {
    }
}
