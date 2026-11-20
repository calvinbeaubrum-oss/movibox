package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzel implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j11 = 0;
        double d11 = 0.0d;
        double d12 = 0.0d;
        String strCreateString = null;
        int i11 = 0;
        short s11 = 0;
        float f11 = 0.0f;
        int i12 = 0;
        int i13 = -1;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 2:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    s11 = SafeParcelReader.readShort(parcel, header);
                    break;
                case 4:
                    d11 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 5:
                    d12 = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 6:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 7:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzek(strCreateString, i11, s11, d11, d12, f11, j11, i12, i13);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzek[i11];
    }
}
