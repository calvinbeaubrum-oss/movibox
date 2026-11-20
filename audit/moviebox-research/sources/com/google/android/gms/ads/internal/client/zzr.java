package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        zzq[] zzqVarArr = null;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        boolean z12 = false;
        boolean z13 = false;
        boolean z14 = false;
        boolean z15 = false;
        boolean z16 = false;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 6:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    zzqVarArr = (zzq[]) SafeParcelReader.createTypedArray(parcel, header, zzq.CREATOR);
                    break;
                case 9:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 12:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 13:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 14:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 15:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    z19 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzq(strCreateString, i11, i12, z11, i13, i14, zzqVarArr, z12, z13, z14, z15, z16, z17, z18, z19);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzq[i11];
    }
}
