package com.applovin.impl;

import android.os.Parcel;
import android.os.Parcelable;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zn extends ya {
    public static final Parcelable.Creator<zn> CREATOR = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f24898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f24899c;

    /* JADX INFO: compiled from: source.java */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zn createFromParcel(Parcel parcel) {
            return new zn(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zn[] newArray(int i11) {
            return new zn[i11];
        }
    }

    public zn(Parcel parcel) {
        super((String) xp.a((Object) parcel.readString()));
        this.f24898b = parcel.readString();
        this.f24899c = (String) xp.a((Object) parcel.readString());
    }

    public zn(String str, String str2, String str3) {
        super(str);
        this.f24898b = str2;
        this.f24899c = str3;
    }

    private static List a(String str) {
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

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.applovin.impl.ya, com.applovin.impl.bf.b
    public void a(vd.b bVar) {
        String str = this.f24575a;
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b11 = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b11 = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b11 = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b11 = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b11 = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b11 = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b11 = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b11 = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b11 = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b11 = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b11 = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b11 = Ascii.VT;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b11 = Ascii.FF;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b11 = Ascii.CR;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b11 = Ascii.SO;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b11 = Ascii.SI;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b11 = Ascii.DLE;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b11 = 17;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b11 = Ascii.DC2;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b11 = 19;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b11 = Ascii.DC4;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b11 = Ascii.NAK;
                }
                break;
        }
        try {
            switch (b11) {
                case 0:
                case 10:
                    bVar.b(this.f24899c);
                    break;
                case 1:
                case 11:
                    bVar.e(this.f24899c);
                    break;
                case 2:
                case 12:
                    bVar.d(Integer.valueOf(Integer.parseInt(this.f24899c.substring(2, 4)))).c(Integer.valueOf(Integer.parseInt(this.f24899c.substring(0, 2))));
                    break;
                case 3:
                case 17:
                    bVar.c(this.f24899c);
                    break;
                case 4:
                case 18:
                    bVar.a(this.f24899c);
                    break;
                case 5:
                case 19:
                    bVar.f(this.f24899c);
                    break;
                case 6:
                case 20:
                    String[] strArrA = xp.a(this.f24899c, "/");
                    bVar.k(Integer.valueOf(Integer.parseInt(strArrA[0]))).j(strArrA.length > 1 ? Integer.valueOf(Integer.parseInt(strArrA[1])) : null);
                    break;
                case 7:
                case 16:
                    bVar.k(this.f24899c);
                    break;
                case 8:
                case 15:
                    bVar.l(this.f24899c);
                    break;
                case 9:
                case 21:
                    bVar.e(Integer.valueOf(Integer.parseInt(this.f24899c)));
                    break;
                case 13:
                    List listA = a(this.f24899c);
                    int size = listA.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.c((Integer) listA.get(2));
                            }
                        }
                        bVar.d((Integer) listA.get(1));
                    }
                    bVar.e((Integer) listA.get(0));
                    break;
                case 14:
                    List listA2 = a(this.f24899c);
                    int size2 = listA2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.f((Integer) listA2.get(2));
                            }
                        }
                        bVar.g((Integer) listA2.get(1));
                    }
                    bVar.h((Integer) listA2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zn.class != obj.getClass()) {
            return false;
        }
        zn znVar = (zn) obj;
        return xp.a((Object) this.f24575a, (Object) znVar.f24575a) && xp.a((Object) this.f24898b, (Object) znVar.f24898b) && xp.a((Object) this.f24899c, (Object) znVar.f24899c);
    }

    public int hashCode() {
        int iHashCode = (this.f24575a.hashCode() + 527) * 31;
        String str = this.f24898b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f24899c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // com.applovin.impl.ya
    public String toString() {
        return this.f24575a + ": description=" + this.f24898b + ": value=" + this.f24899c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f24575a);
        parcel.writeString(this.f24898b);
        parcel.writeString(this.f24899c);
    }
}
