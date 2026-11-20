package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzagz extends zzagr {
    public static final Parcelable.Creator<zzagz> CREATOR = new zzagy();

    @Nullable
    public final String zza;

    @Deprecated
    public final String zzb;
    public final zzgaa zzc;

    /* JADX WARN: Multi-variable type inference failed */
    public zzagz(String str, @Nullable String str2, List list) {
        super(str);
        zzek.zzd(!list.isEmpty());
        this.zza = str2;
        zzgaa zzgaaVarZzj = zzgaa.zzj(list);
        this.zzc = zzgaaVarZzj;
        this.zzb = (String) zzgaaVarZzj.get(0);
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagz.class == obj.getClass()) {
            zzagz zzagzVar = (zzagz) obj;
            if (zzfy.zzF(this.zzf, zzagzVar.zzf) && zzfy.zzF(this.zza, zzagzVar.zza) && this.zzc.equals(zzagzVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzc.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzagr
    public final String toString() {
        return this.zzf + ": description=" + this.zza + ": values=" + String.valueOf(this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeStringArray((String[]) this.zzc.toArray(new String[0]));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:71:0x0107  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzagr, com.google.android.gms.internal.ads.zzbx
    public final void zza(zzbt zzbtVar) {
        byte b11;
        String str = this.zzf;
        switch (str.hashCode()) {
            case 82815:
                if (!str.equals("TAL")) {
                    b11 = -1;
                } else {
                    b11 = 6;
                }
                break;
            case 82878:
                if (!str.equals("TCM")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DLE;
                }
                break;
            case 82897:
                if (!str.equals("TDA")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.FF;
                }
                break;
            case 83253:
                if (!str.equals("TP1")) {
                    b11 = -1;
                } else {
                    b11 = 2;
                }
                break;
            case 83254:
                if (!str.equals("TP2")) {
                    b11 = -1;
                } else {
                    b11 = 4;
                }
                break;
            case 83255:
                if (!str.equals("TP3")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC2;
                }
                break;
            case 83341:
                if (!str.equals("TRK")) {
                    b11 = -1;
                } else {
                    b11 = 8;
                }
                break;
            case 83378:
                if (!str.equals("TT2")) {
                    b11 = -1;
                } else {
                    b11 = 0;
                }
                break;
            case 83536:
                if (!str.equals("TXT")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.DC4;
                }
                break;
            case 83552:
                if (!str.equals("TYE")) {
                    b11 = -1;
                } else {
                    b11 = 10;
                }
                break;
            case 2567331:
                if (!str.equals("TALB")) {
                    b11 = -1;
                } else {
                    b11 = 7;
                }
                break;
            case 2569357:
                if (!str.equals("TCOM")) {
                    b11 = -1;
                } else {
                    b11 = 17;
                }
                break;
            case 2569891:
                if (!str.equals("TDAT")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.CR;
                }
                break;
            case 2570401:
                if (!str.equals("TDRC")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SO;
                }
                break;
            case 2570410:
                if (!str.equals("TDRL")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.SI;
                }
                break;
            case 2571565:
                if (!str.equals("TEXT")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.NAK;
                }
                break;
            case 2575251:
                if (!str.equals("TIT2")) {
                    b11 = -1;
                } else {
                    b11 = 1;
                }
                break;
            case 2581512:
                if (!str.equals("TPE1")) {
                    b11 = -1;
                } else {
                    b11 = 3;
                }
                break;
            case 2581513:
                if (!str.equals("TPE2")) {
                    b11 = -1;
                } else {
                    b11 = 5;
                }
                break;
            case 2581514:
                if (!str.equals("TPE3")) {
                    b11 = -1;
                } else {
                    b11 = 19;
                }
                break;
            case 2583398:
                if (!str.equals("TRCK")) {
                    b11 = -1;
                } else {
                    b11 = 9;
                }
                break;
            case 2590194:
                if (!str.equals("TYER")) {
                    b11 = -1;
                } else {
                    b11 = Ascii.VT;
                }
                break;
            default:
                b11 = -1;
                break;
        }
        switch (b11) {
            case 0:
            case 1:
                zzbtVar.zzq((CharSequence) this.zzc.get(0));
                break;
            case 2:
            case 3:
                zzbtVar.zze((CharSequence) this.zzc.get(0));
                break;
            case 4:
            case 5:
                zzbtVar.zzc((CharSequence) this.zzc.get(0));
                break;
            case 6:
            case 7:
                zzbtVar.zzd((CharSequence) this.zzc.get(0));
                break;
            case 8:
            case 9:
                String str2 = (String) this.zzc.get(0);
                int i11 = zzfy.zza;
                String[] strArrSplit = str2.split("/", -1);
                try {
                    int i12 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzbtVar.zzs(Integer.valueOf(i12));
                    zzbtVar.zzr(numValueOf);
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case 10:
            case 11:
                try {
                    zzbtVar.zzl(Integer.valueOf(Integer.parseInt((String) this.zzc.get(0))));
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case 12:
            case 13:
                try {
                    String str3 = (String) this.zzc.get(0);
                    int i13 = Integer.parseInt(str3.substring(2, 4));
                    int i14 = Integer.parseInt(str3.substring(0, 2));
                    zzbtVar.zzk(Integer.valueOf(i13));
                    zzbtVar.zzj(Integer.valueOf(i14));
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case 14:
                List listZzb = zzb((String) this.zzc.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzbtVar.zzj((Integer) listZzb.get(2));
                        }
                    }
                    zzbtVar.zzk((Integer) listZzb.get(1));
                }
                zzbtVar.zzl((Integer) listZzb.get(0));
                break;
            case 15:
                List listZzb2 = zzb((String) this.zzc.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzbtVar.zzm((Integer) listZzb2.get(2));
                        }
                    }
                    zzbtVar.zzn((Integer) listZzb2.get(1));
                }
                zzbtVar.zzo((Integer) listZzb2.get(0));
                break;
            case 16:
            case 17:
                zzbtVar.zzf((CharSequence) this.zzc.get(0));
                break;
            case 18:
            case 19:
                zzbtVar.zzg((CharSequence) this.zzc.get(0));
                break;
            case 20:
            case 21:
                zzbtVar.zzt((CharSequence) this.zzc.get(0));
                break;
        }
    }
}
