package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbjc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        com.google.android.gms.ads.internal.client.zzfk zzfkVar = null;
        int i11 = 0;
        boolean z11 = false;
        int i12 = 0;
        boolean z12 = false;
        int i13 = 0;
        boolean z13 = false;
        int i14 = 0;
        int i15 = 0;
        boolean z14 = false;
        int i16 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 3:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 4:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 5:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 6:
                    zzfkVar = (com.google.android.gms.ads.internal.client.zzfk) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzfk.CREATOR);
                    break;
                case 7:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 8:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 9:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 11:
                    i16 = SafeParcelReader.readInt(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbjb(i11, z11, i12, z12, i13, zzfkVar, z13, i14, i15, z14, i16);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbjb[i11];
    }
}
