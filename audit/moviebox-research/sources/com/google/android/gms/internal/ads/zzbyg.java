package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.transsion.baselib.db.download.DownloadBean;
import com.vungle.warren.error.VungleException;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbyg implements Parcelable.Creator {
    public static final zzbyf zza(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Bundle bundleCreateBundle = null;
        com.google.android.gms.ads.internal.client.zzl zzlVar = null;
        com.google.android.gms.ads.internal.client.zzq zzqVar = null;
        String strCreateString = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        zzcei zzceiVar = null;
        Bundle bundleCreateBundle2 = null;
        ArrayList<String> arrayListCreateStringList = null;
        Bundle bundleCreateBundle3 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        ArrayList<String> arrayListCreateStringList2 = null;
        String strCreateString7 = null;
        zzbjb zzbjbVar = null;
        ArrayList<String> arrayListCreateStringList3 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        Bundle bundleCreateBundle4 = null;
        String strCreateString11 = null;
        com.google.android.gms.ads.internal.client.zzdu zzduVar = null;
        Bundle bundleCreateBundle5 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        String strCreateString14 = null;
        ArrayList<Integer> arrayListCreateIntegerList = null;
        String strCreateString15 = null;
        ArrayList<String> arrayListCreateStringList4 = null;
        ArrayList<String> arrayListCreateStringList5 = null;
        String strCreateString16 = null;
        zzbpp zzbppVar = null;
        String strCreateString17 = null;
        Bundle bundleCreateBundle6 = null;
        long j11 = 0;
        long j12 = 0;
        int i11 = 0;
        int i12 = 0;
        boolean z11 = false;
        int i13 = 0;
        int i14 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean z12 = false;
        int i15 = 0;
        int i16 = 0;
        boolean z13 = false;
        boolean z14 = false;
        int i17 = 0;
        boolean z15 = false;
        boolean z16 = false;
        int i18 = 0;
        boolean z17 = false;
        boolean z18 = false;
        boolean z19 = false;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 1:
                    i11 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 2:
                    bundleCreateBundle = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 3:
                    zzlVar = (com.google.android.gms.ads.internal.client.zzl) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzl.CREATOR);
                    break;
                case 4:
                    zzqVar = (com.google.android.gms.ads.internal.client.zzq) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzq.CREATOR);
                    break;
                case 5:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.createParcelable(parcel, header, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.createParcelable(parcel, header, PackageInfo.CREATOR);
                    break;
                case 8:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 9:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 11:
                    zzceiVar = (zzcei) SafeParcelReader.createParcelable(parcel, header, zzcei.CREATOR);
                    break;
                case 12:
                    bundleCreateBundle2 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 13:
                    i12 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 15:
                    bundleCreateBundle3 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 16:
                    z11 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 38:
                case 62:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case 18:
                    i13 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 19:
                    i14 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 20:
                    f11 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 21:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    j11 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 26:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 27:
                    arrayListCreateStringList2 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 28:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case VungleException.INCORRECT_DEFAULT_API_USAGE /* 29 */:
                    zzbjbVar = (zzbjb) SafeParcelReader.createParcelable(parcel, header, zzbjb.CREATOR);
                    break;
                case 30:
                    arrayListCreateStringList3 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case VungleException.WEB_CRASH /* 31 */:
                    j12 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 33:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 34:
                    f12 = SafeParcelReader.readFloat(parcel, header);
                    break;
                case 35:
                    i15 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 36:
                    i16 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 37:
                    z13 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 39:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 40:
                    z12 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 41:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case MotionEventCompat.AXIS_GENERIC_11 /* 42 */:
                    z14 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case MotionEventCompat.AXIS_GENERIC_12 /* 43 */:
                    i17 = SafeParcelReader.readInt(parcel, header);
                    break;
                case MotionEventCompat.AXIS_GENERIC_13 /* 44 */:
                    bundleCreateBundle4 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case MotionEventCompat.AXIS_GENERIC_14 /* 45 */:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
                case MotionEventCompat.AXIS_GENERIC_15 /* 46 */:
                    zzduVar = (com.google.android.gms.ads.internal.client.zzdu) SafeParcelReader.createParcelable(parcel, header, com.google.android.gms.ads.internal.client.zzdu.CREATOR);
                    break;
                case MotionEventCompat.AXIS_GENERIC_16 /* 47 */:
                    z15 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 48:
                    bundleCreateBundle5 = SafeParcelReader.createBundle(parcel, header);
                    break;
                case 49:
                    strCreateString12 = SafeParcelReader.createString(parcel, header);
                    break;
                case 50:
                    strCreateString13 = SafeParcelReader.createString(parcel, header);
                    break;
                case 51:
                    strCreateString14 = SafeParcelReader.createString(parcel, header);
                    break;
                case 52:
                    z16 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 53:
                    arrayListCreateIntegerList = SafeParcelReader.createIntegerList(parcel, header);
                    break;
                case 54:
                    strCreateString15 = SafeParcelReader.createString(parcel, header);
                    break;
                case 55:
                    arrayListCreateStringList4 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 56:
                    i18 = SafeParcelReader.readInt(parcel, header);
                    break;
                case DownloadBean.STATUS_COMPLETED_REMOVED /* 57 */:
                    z17 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 58:
                    z18 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 59:
                    z19 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 60:
                    arrayListCreateStringList5 = SafeParcelReader.createStringList(parcel, header);
                    break;
                case 61:
                    strCreateString16 = SafeParcelReader.createString(parcel, header);
                    break;
                case 63:
                    zzbppVar = (zzbpp) SafeParcelReader.createParcelable(parcel, header, zzbpp.CREATOR);
                    break;
                case 64:
                    strCreateString17 = SafeParcelReader.createString(parcel, header);
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    bundleCreateBundle6 = SafeParcelReader.createBundle(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzbyf(i11, bundleCreateBundle, zzlVar, zzqVar, strCreateString, applicationInfo, packageInfo, strCreateString2, strCreateString3, strCreateString4, zzceiVar, bundleCreateBundle2, i12, arrayListCreateStringList, bundleCreateBundle3, z11, i13, i14, f11, strCreateString5, j11, strCreateString6, arrayListCreateStringList2, strCreateString7, zzbjbVar, arrayListCreateStringList3, j12, strCreateString8, f12, z12, i15, i16, z13, strCreateString9, strCreateString10, z14, i17, bundleCreateBundle4, strCreateString11, zzduVar, z15, bundleCreateBundle5, strCreateString12, strCreateString13, strCreateString14, z16, arrayListCreateIntegerList, strCreateString15, arrayListCreateStringList4, i18, z17, z18, z19, arrayListCreateStringList5, strCreateString16, zzbppVar, strCreateString17, bundleCreateBundle6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i11) {
        return new zzbyf[i11];
    }
}
