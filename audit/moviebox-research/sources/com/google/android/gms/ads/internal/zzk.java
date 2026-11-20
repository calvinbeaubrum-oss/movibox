package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzk implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        float f11 = 0.0f;
        int i11 = 0;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 9:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzj(z11, z12, strCreateString, z13, f11, i11, z14, z15, z16);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzj[i11];
    }
}
