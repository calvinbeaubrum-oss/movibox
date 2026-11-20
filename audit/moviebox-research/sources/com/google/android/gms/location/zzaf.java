package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        WorkSource workSource = new WorkSource();
        com.google.android.gms.internal.location.zze zzeVar = null;
        long j11 = -1;
        long j12 = Long.MAX_VALUE;
        long j13 = Long.MAX_VALUE;
        long j14 = 0;
        long j15 = 600000;
        long j16 = 3600000;
        int i11 = 102;
        int i12 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        float f11 = 0.0f;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        boolean z12 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    j16 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 3:
                    j15 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 4:
                case 14:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 5:
                    j12 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 6:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 8:
                    j14 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 9:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    j13 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 11:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 13:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 15:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 16:
                    workSource = (WorkSource) SafeParcelReader.createParcelable(parcel, header, WorkSource.CREATOR);
                    break;
                case 17:
                    zzeVar = (com.google.android.gms.internal.location.zze) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.internal.location.zze.CREATOR);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new LocationRequest(i11, j16, j15, j14, j12, j13, i12, f11, z11, j11, i13, i14, z12, workSource, zzeVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new LocationRequest[i11];
    }
}
