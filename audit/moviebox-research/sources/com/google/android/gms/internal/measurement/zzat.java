package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzat implements Iterable, zzap {
    private final String zza;

    public zzat(String str) {
        if (str == null) {
            throw new IllegalArgumentException("StringValue cannot be null.");
        }
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzat) {
            return this.zza.equals(((zzat) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzas(this);
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    /* JADX WARN: Code duplicated, block: B:102:0x018c  */
    /* JADX WARN: Code duplicated, block: B:104:0x0194  */
    /* JADX WARN: Code duplicated, block: B:106:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:107:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:108:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e1  */
    /* JADX WARN: Code duplicated, block: B:110:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:111:0x0209  */
    /* JADX WARN: Code duplicated, block: B:113:0x021a  */
    /* JADX WARN: Code duplicated, block: B:114:0x0234  */
    /* JADX WARN: Code duplicated, block: B:117:0x023e  */
    /* JADX WARN: Code duplicated, block: B:119:0x0257  */
    /* JADX WARN: Code duplicated, block: B:121:0x0287  */
    /* JADX WARN: Code duplicated, block: B:123:0x0299  */
    /* JADX WARN: Code duplicated, block: B:125:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:127:0x02b8  */
    /* JADX WARN: Code duplicated, block: B:128:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:130:0x02d2  */
    /* JADX WARN: Code duplicated, block: B:131:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:134:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:135:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:141:0x031f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0326  */
    /* JADX WARN: Code duplicated, block: B:146:0x032a A[LOOP:0: B:145:0x0328->B:146:0x032a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:148:0x033e  */
    /* JADX WARN: Code duplicated, block: B:150:0x0350  */
    /* JADX WARN: Code duplicated, block: B:151:0x0364  */
    /* JADX WARN: Code duplicated, block: B:154:0x036d  */
    /* JADX WARN: Code duplicated, block: B:155:0x0378  */
    /* JADX WARN: Code duplicated, block: B:158:0x0389  */
    /* JADX WARN: Code duplicated, block: B:159:0x039c  */
    /* JADX WARN: Code duplicated, block: B:162:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:163:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:165:0x03d0  */
    /* JADX WARN: Code duplicated, block: B:167:0x03e1  */
    /* JADX WARN: Code duplicated, block: B:170:0x03ff  */
    /* JADX WARN: Code duplicated, block: B:171:0x040f  */
    /* JADX WARN: Code duplicated, block: B:172:0x041c  */
    /* JADX WARN: Code duplicated, block: B:174:0x042e  */
    /* JADX WARN: Code duplicated, block: B:176:0x0444  */
    /* JADX WARN: Code duplicated, block: B:179:0x0458  */
    /* JADX WARN: Code duplicated, block: B:181:0x045c  */
    /* JADX WARN: Code duplicated, block: B:183:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:185:0x04c0  */
    /* JADX WARN: Code duplicated, block: B:186:0x04c3  */
    /* JADX WARN: Code duplicated, block: B:189:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:190:0x04fa  */
    /* JADX WARN: Code duplicated, block: B:191:0x04fe  */
    /* JADX WARN: Code duplicated, block: B:194:0x0515  */
    /* JADX WARN: Code duplicated, block: B:197:0x052a  */
    /* JADX WARN: Code duplicated, block: B:198:0x052d  */
    /* JADX WARN: Code duplicated, block: B:201:0x0546  */
    /* JADX WARN: Code duplicated, block: B:202:0x0549  */
    /* JADX WARN: Code duplicated, block: B:204:0x0560  */
    /* JADX WARN: Code duplicated, block: B:207:0x0577  */
    /* JADX WARN: Code duplicated, block: B:211:0x058e  */
    /* JADX WARN: Code duplicated, block: B:213:0x05bb  */
    /* JADX WARN: Code duplicated, block: B:215:0x05de  */
    /* JADX WARN: Code duplicated, block: B:216:0x05e2  */
    /* JADX WARN: Code duplicated, block: B:223:0x05ff  */
    /* JADX WARN: Code duplicated, block: B:224:0x0603  */
    /* JADX WARN: Code duplicated, block: B:226:0x060f  */
    /* JADX WARN: Code duplicated, block: B:229:0x061d A[LOOP:1: B:227:0x0617->B:229:0x061d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:232:0x063e  */
    /* JADX WARN: Code duplicated, block: B:234:0x064e  */
    /* JADX WARN: Code duplicated, block: B:235:0x0667  */
    /* JADX WARN: Code duplicated, block: B:247:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:248:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:249:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:250:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:251:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:252:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:253:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:255:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:256:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:257:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:258:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:259:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00c2 A[PHI: r4
  0x00c2: PHI (r4v51 java.lang.String) = 
  (r4v5 java.lang.String)
  (r4v6 java.lang.String)
  (r4v7 java.lang.String)
  (r4v9 java.lang.String)
  (r4v10 java.lang.String)
  (r4v11 java.lang.String)
  (r4v12 java.lang.String)
  (r4v13 java.lang.String)
  (r4v15 java.lang.String)
  (r4v16 java.lang.String)
  (r4v17 java.lang.String)
  (r4v18 java.lang.String)
  (r4v19 java.lang.String)
  (r4v20 java.lang.String)
  (r4v23 java.lang.String)
  (r4v52 java.lang.String)
 binds: [B:90:0x015a, B:87:0x014c, B:259:?, B:258:?, B:257:?, B:256:?, B:255:?, B:254:?, B:253:?, B:252:?, B:251:?, B:250:?, B:249:?, B:248:?, B:247:?, B:43:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:45:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:47:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:53:0x00df  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:61:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:62:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:64:0x0100  */
    /* JADX WARN: Code duplicated, block: B:65:0x0102  */
    /* JADX WARN: Code duplicated, block: B:67:0x010a  */
    /* JADX WARN: Code duplicated, block: B:68:0x010d  */
    /* JADX WARN: Code duplicated, block: B:70:0x0113  */
    /* JADX WARN: Code duplicated, block: B:71:0x0116  */
    /* JADX WARN: Code duplicated, block: B:73:0x011c  */
    /* JADX WARN: Code duplicated, block: B:74:0x011e  */
    /* JADX WARN: Code duplicated, block: B:76:0x0124  */
    /* JADX WARN: Code duplicated, block: B:77:0x0127  */
    /* JADX WARN: Code duplicated, block: B:79:0x012d  */
    /* JADX WARN: Code duplicated, block: B:80:0x012f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0135  */
    /* JADX WARN: Code duplicated, block: B:83:0x0138  */
    /* JADX WARN: Code duplicated, block: B:85:0x013e  */
    /* JADX WARN: Code duplicated, block: B:86:0x0146  */
    /* JADX WARN: Code duplicated, block: B:88:0x014e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0154  */
    /* JADX WARN: Code duplicated, block: B:91:0x015c  */
    /* JADX WARN: Code duplicated, block: B:92:0x0160  */
    /* JADX WARN: Code duplicated, block: B:94:0x016a  */
    /* JADX WARN: Code duplicated, block: B:95:0x016f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0172  */
    /* JADX WARN: Code duplicated, block: B:98:0x017e  */
    /* JADX WARN: Code duplicated, block: B:99:0x0180 A[PHI: r4 r6 r8
  0x0180: PHI (r4v50 java.lang.String) = (r4v3 java.lang.String), (r4v4 java.lang.String), (r4v51 java.lang.String) binds: [B:97:0x017c, B:95:0x016f, B:44:0x00c2] A[DONT_GENERATE, DONT_INLINE]
  0x0180: PHI (r6v37 java.lang.String) = (r6v1 java.lang.String), (r6v2 java.lang.String), (r6v38 java.lang.String) binds: [B:97:0x017c, B:95:0x016f, B:44:0x00c2] A[DONT_GENERATE, DONT_INLINE]
  0x0180: PHI (r8v25 java.lang.String) = (r8v1 java.lang.String), (r8v2 java.lang.String), (r8v26 java.lang.String) binds: [B:97:0x017c, B:95:0x016f, B:44:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzbR(String str, zzg zzgVar, List list) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        byte b11;
        String strZzi;
        int iZza;
        zzat zzatVar;
        StringBuilder sb2;
        int i11;
        zzap zzatVar2;
        zzap zzapVarZzb;
        double dDoubleValue;
        int i12;
        double dDoubleValue2;
        double dZza;
        String strZzi2;
        Matcher matcher;
        zzap zzaeVar;
        zzap zzapVarZza;
        String str7;
        String str8;
        int iIndexOf;
        Matcher matcher2;
        String str9;
        double dDoubleValue3;
        double dZza2;
        double dMin;
        double length;
        double dZza3;
        double dMin2;
        String str10;
        ArrayList arrayList;
        String strZzi3;
        long jZzd;
        String[] strArrSplit;
        int length2;
        int i13;
        int i14;
        boolean zIsEmpty;
        String str11;
        zzg zzgVar2;
        int iZza2;
        int length3;
        if (!"charAt".equals(str) && !"concat".equals(str) && !"hasOwnProperty".equals(str) && !"indexOf".equals(str) && !"lastIndexOf".equals(str) && !"match".equals(str) && !"replace".equals(str) && !AppLovinEventTypes.USER_EXECUTED_SEARCH.equals(str) && !"slice".equals(str) && !"split".equals(str) && !"substring".equals(str) && !"toLowerCase".equals(str) && !"toLocaleLowerCase".equals(str) && !"toString".equals(str)) {
            str3 = "toUpperCase";
            str2 = "toLocaleUpperCase";
            if (!str3.equals(str) && !str2.equals(str)) {
                if (!"trim".equals(str)) {
                    throw new IllegalArgumentException(String.format("%s is not a String function", str));
                }
            }
            switch (str.hashCode()) {
                case -1789698943:
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                    if (str.equals(str5)) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                    break;
                case -1776922004:
                    str4 = "charAt";
                    str6 = "toString";
                    if (str.equals(str6)) {
                        b11 = Ascii.SO;
                        str5 = r4;
                    } else {
                        str5 = r4;
                        b11 = -1;
                    }
                    break;
                case -1464939364:
                    str4 = "charAt";
                    if (str.equals("toLocaleLowerCase")) {
                        b11 = Ascii.FF;
                        str5 = r4;
                        str6 = "toString";
                    }
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                    break;
                case -1361633751:
                    str4 = "charAt";
                    if (str.equals(str4)) {
                        str5 = r4;
                        str6 = "toString";
                        b11 = 0;
                    } else {
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -1354795244:
                    if (str.equals("concat")) {
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                        b11 = 1;
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -1137582698:
                    if (str.equals("toLowerCase")) {
                        b11 = Ascii.CR;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -906336856:
                    if (str.equals(AppLovinEventTypes.USER_EXECUTED_SEARCH)) {
                        b11 = 7;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -726908483:
                    if (str.equals(str2)) {
                        b11 = Ascii.VT;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -467511597:
                    if (str.equals("lastIndexOf")) {
                        b11 = 4;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case -399551817:
                    if (str.equals(str3)) {
                        b11 = Ascii.SI;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 3568674:
                    if (str.equals("trim")) {
                        b11 = Ascii.DLE;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 103668165:
                    if (str.equals("match")) {
                        b11 = 5;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 109526418:
                    if (str.equals("slice")) {
                        b11 = 8;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 109648666:
                    if (str.equals("split")) {
                        b11 = 9;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 530542161:
                    if (str.equals("substring")) {
                        b11 = 10;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 1094496948:
                    if (str.equals("replace")) {
                        b11 = 6;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                case 1943291465:
                    if (str.equals("indexOf")) {
                        b11 = 3;
                        str4 = "charAt";
                        str5 = r4;
                        str6 = "toString";
                    } else {
                        str4 = "charAt";
                        str5 = "hasOwnProperty";
                        str6 = "toString";
                        b11 = -1;
                    }
                    break;
                default:
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                    break;
            }
            strZzi = AdError.UNDEFINED_DOMAIN;
            switch (b11) {
                case 0:
                    zzh.zzj(str4, 1, list);
                    if (list.isEmpty()) {
                        iZza = 0;
                    } else {
                        iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    String str12 = this.zza;
                    return (iZza >= 0 || iZza >= str12.length()) ? zzap.zzm : new zzat(String.valueOf(str12.charAt(iZza)));
                case 1:
                    zzatVar = this;
                    if (!list.isEmpty()) {
                        sb2 = new StringBuilder(zzatVar.zza);
                        for (i11 = 0; i11 < list.size(); i11++) {
                            sb2.append(zzgVar.zzb((zzap) list.get(i11)).zzi());
                        }
                        zzatVar2 = new zzat(sb2.toString());
                        return zzatVar2;
                    }
                    return zzatVar;
                case 2:
                    zzatVar = this;
                    zzh.zzh(str5, 1, list);
                    String str13 = zzatVar.zza;
                    zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                    if ("length".equals(zzapVarZzb.zzi())) {
                        zzatVar2 = zzap.zzk;
                    } else {
                        dDoubleValue = zzapVarZzb.zzh().doubleValue();
                        if (dDoubleValue == Math.floor(dDoubleValue) || (i12 = (int) dDoubleValue) < 0 || i12 >= str13.length()) {
                            zzatVar2 = zzap.zzl;
                        } else {
                            zzatVar2 = zzap.zzk;
                        }
                    }
                    return zzatVar2;
                case 3:
                    zzh.zzj("indexOf", 2, list);
                    String str14 = this.zza;
                    if (list.size() > 0) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    return new zzah(Double.valueOf(str14.indexOf(strZzi, (int) zzh.zza(list.size() >= 2 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : 0.0d))));
                case 4:
                    zzh.zzj("lastIndexOf", 2, list);
                    String str15 = this.zza;
                    if (list.size() > 0) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    String str16 = strZzi;
                    if (list.size() < 2) {
                        dDoubleValue2 = Double.NaN;
                    } else {
                        dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    }
                    if (Double.isNaN(dDoubleValue2)) {
                        dZza = Double.POSITIVE_INFINITY;
                    } else {
                        dZza = zzh.zza(dDoubleValue2);
                    }
                    return new zzah(Double.valueOf(str15.lastIndexOf(str16, (int) dZza)));
                case 5:
                    zzatVar = this;
                    zzh.zzj("match", 1, list);
                    String str17 = zzatVar.zza;
                    if (list.size() <= 0) {
                        strZzi2 = "";
                    } else {
                        strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    matcher = Pattern.compile(strZzi2).matcher(str17);
                    if (matcher.find()) {
                        zzaeVar = new zzae(Arrays.asList(new zzat(matcher.group())));
                        return zzaeVar;
                    }
                    zzatVar2 = zzap.zzg;
                    return zzatVar2;
                case 6:
                    zzatVar = this;
                    zzh.zzj("replace", 2, list);
                    zzapVarZza = zzap.zzf;
                    if (!list.isEmpty()) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                        }
                    }
                    str7 = strZzi;
                    str8 = zzatVar.zza;
                    iIndexOf = str8.indexOf(str7);
                    if (iIndexOf >= 0) {
                        if (zzapVarZza instanceof zzai) {
                            zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str7), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                        }
                        zzaeVar = new zzat(str8.substring(0, iIndexOf) + zzapVarZza.zzi() + str8.substring(iIndexOf + str7.length()));
                        return zzaeVar;
                    }
                    return zzatVar;
                case 7:
                    zzatVar = this;
                    zzh.zzj(AppLovinEventTypes.USER_EXECUTED_SEARCH, 1, list);
                    if (!list.isEmpty()) {
                        strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    }
                    matcher2 = Pattern.compile(strZzi).matcher(zzatVar.zza);
                    if (matcher2.find()) {
                        zzaeVar = new zzah(Double.valueOf(matcher2.start()));
                        return zzaeVar;
                    }
                    zzatVar2 = new zzah(Double.valueOf(-1.0d));
                    return zzatVar2;
                case 8:
                    zzatVar = this;
                    zzh.zzj("slice", 2, list);
                    str9 = zzatVar.zza;
                    if (list.isEmpty()) {
                        dDoubleValue3 = 0.0d;
                    } else {
                        dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                    }
                    dZza2 = zzh.zza(dDoubleValue3);
                    if (dZza2 < 0.0d) {
                        dMin = Math.max(((double) str9.length()) + dZza2, 0.0d);
                    } else {
                        dMin = Math.min(dZza2, str9.length());
                    }
                    int i15 = (int) dMin;
                    if (list.size() > 1) {
                        length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                    } else {
                        length = str9.length();
                    }
                    dZza3 = zzh.zza(length);
                    if (dZza3 < 0.0d) {
                        dMin2 = Math.max(((double) str9.length()) + dZza3, 0.0d);
                    } else {
                        dMin2 = Math.min(dZza3, str9.length());
                    }
                    zzaeVar = new zzat(str9.substring(i15, Math.max(0, ((int) dMin2) - i15) + i15));
                    return zzaeVar;
                case 9:
                    zzatVar = this;
                    zzh.zzj("split", 2, list);
                    str10 = zzatVar.zza;
                    if (str10.length() == 0) {
                        zzatVar2 = new zzae(Arrays.asList(zzatVar));
                    } else {
                        arrayList = new ArrayList();
                        if (list.isEmpty()) {
                            arrayList.add(zzatVar);
                        } else {
                            strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                            if (list.size() > 1) {
                                jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                            } else {
                                jZzd = 2147483647L;
                            }
                            if (jZzd == 0) {
                                zzatVar2 = new zzae();
                            } else {
                                strArrSplit = str10.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                                length2 = strArrSplit.length;
                                if (strZzi3.isEmpty() || length2 <= 0) {
                                    i13 = length2;
                                    i14 = 0;
                                } else {
                                    zIsEmpty = strArrSplit[0].isEmpty();
                                    i13 = length2 - 1;
                                    if (!strArrSplit[i13].isEmpty()) {
                                        i14 = zIsEmpty;
                                        i13 = length2;
                                        i14 = zIsEmpty;
                                    }
                                }
                                i14 = zIsEmpty;
                                if (length2 > jZzd) {
                                    i13--;
                                }
                                while (i14 < i13) {
                                    arrayList.add(new zzat(strArrSplit[i14]));
                                    i14++;
                                }
                            }
                        }
                        zzatVar2 = new zzae(arrayList);
                    }
                    return zzatVar2;
                case 10:
                    zzatVar = this;
                    zzh.zzj("substring", 2, list);
                    str11 = zzatVar.zza;
                    if (list.isEmpty()) {
                        zzgVar2 = zzgVar;
                        iZza2 = 0;
                    } else {
                        zzgVar2 = zzgVar;
                        iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                    }
                    if (list.size() > 1) {
                        length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                    } else {
                        length3 = str11.length();
                    }
                    int iMin = Math.min(Math.max(iZza2, 0), str11.length());
                    int iMin2 = Math.min(Math.max(length3, 0), str11.length());
                    zzaeVar = new zzat(str11.substring(Math.min(iMin, iMin2), Math.max(iMin, iMin2)));
                    return zzaeVar;
                case 11:
                    zzatVar = this;
                    zzh.zzh(str2, 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toUpperCase());
                    return zzaeVar;
                case 12:
                    zzatVar = this;
                    zzh.zzh("toLocaleLowerCase", 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toLowerCase());
                    return zzaeVar;
                case 13:
                    zzatVar = this;
                    zzh.zzh("toLowerCase", 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toLowerCase(Locale.ENGLISH));
                    return zzaeVar;
                case 14:
                    zzatVar = this;
                    zzh.zzh(str6, 0, list);
                    return zzatVar;
                case 15:
                    zzatVar = this;
                    zzh.zzh(str3, 0, list);
                    zzaeVar = new zzat(zzatVar.zza.toUpperCase(Locale.ENGLISH));
                    return zzaeVar;
                case 16:
                    zzh.zzh(str3, 0, list);
                    zzatVar = this;
                    zzaeVar = new zzat(zzatVar.zza.trim());
                    return zzaeVar;
                default:
                    throw new IllegalArgumentException("Command not supported");
            }
        }
        str2 = "toLocaleUpperCase";
        str3 = "toUpperCase";
        switch (str.hashCode()) {
            case -1789698943:
                str4 = "charAt";
                str5 = r4;
                str6 = "toString";
                if (str.equals(str5)) {
                    b11 = 2;
                } else {
                    b11 = -1;
                }
                break;
            case -1776922004:
                str4 = "charAt";
                str6 = "toString";
                if (str.equals(str6)) {
                    b11 = Ascii.SO;
                    str5 = r4;
                } else {
                    str5 = r4;
                    b11 = -1;
                }
                break;
            case -1464939364:
                str4 = "charAt";
                if (str.equals("toLocaleLowerCase")) {
                    b11 = Ascii.FF;
                    str5 = r4;
                    str6 = "toString";
                }
                str5 = "hasOwnProperty";
                str6 = "toString";
                b11 = -1;
                break;
            case -1361633751:
                str4 = "charAt";
                if (str.equals(str4)) {
                    str5 = r4;
                    str6 = "toString";
                    b11 = 0;
                } else {
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -1354795244:
                if (str.equals("concat")) {
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                    b11 = 1;
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -1137582698:
                if (str.equals("toLowerCase")) {
                    b11 = Ascii.CR;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -906336856:
                if (str.equals(AppLovinEventTypes.USER_EXECUTED_SEARCH)) {
                    b11 = 7;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -726908483:
                if (str.equals(str2)) {
                    b11 = Ascii.VT;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    b11 = 4;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case -399551817:
                if (str.equals(str3)) {
                    b11 = Ascii.SI;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 3568674:
                if (str.equals("trim")) {
                    b11 = Ascii.DLE;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 103668165:
                if (str.equals("match")) {
                    b11 = 5;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 109526418:
                if (str.equals("slice")) {
                    b11 = 8;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 109648666:
                if (str.equals("split")) {
                    b11 = 9;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 530542161:
                if (str.equals("substring")) {
                    b11 = 10;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 1094496948:
                if (str.equals("replace")) {
                    b11 = 6;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    b11 = 3;
                    str4 = "charAt";
                    str5 = r4;
                    str6 = "toString";
                } else {
                    str4 = "charAt";
                    str5 = "hasOwnProperty";
                    str6 = "toString";
                    b11 = -1;
                }
                break;
            default:
                str4 = "charAt";
                str5 = "hasOwnProperty";
                str6 = "toString";
                b11 = -1;
                break;
        }
        strZzi = AdError.UNDEFINED_DOMAIN;
        switch (b11) {
            case 0:
                zzh.zzj(str4, 1, list);
                if (list.isEmpty()) {
                    iZza = (int) zzh.zza(zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    iZza = 0;
                }
                String str18 = this.zza;
                if (iZza >= 0) {
                }
                break;
            case 1:
                zzatVar = this;
                if (!list.isEmpty()) {
                    sb2 = new StringBuilder(zzatVar.zza);
                    while (i11 < list.size()) {
                        sb2.append(zzgVar.zzb((zzap) list.get(i11)).zzi());
                    }
                    zzatVar2 = new zzat(sb2.toString());
                    return zzatVar2;
                }
                return zzatVar;
            case 2:
                zzatVar = this;
                zzh.zzh(str5, 1, list);
                String str19 = zzatVar.zza;
                zzapVarZzb = zzgVar.zzb((zzap) list.get(0));
                if ("length".equals(zzapVarZzb.zzi())) {
                    zzatVar2 = zzap.zzk;
                } else {
                    dDoubleValue = zzapVarZzb.zzh().doubleValue();
                    if (dDoubleValue == Math.floor(dDoubleValue)) {
                        zzatVar2 = zzap.zzl;
                    } else {
                        zzatVar2 = zzap.zzl;
                    }
                }
                return zzatVar2;
            case 3:
                zzh.zzj("indexOf", 2, list);
                String str110 = this.zza;
                if (list.size() > 0) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                return new zzah(Double.valueOf(str110.indexOf(strZzi, (int) zzh.zza(list.size() >= 2 ? zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue() : 0.0d))));
            case 4:
                zzh.zzj("lastIndexOf", 2, list);
                String str111 = this.zza;
                if (list.size() > 0) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                String str112 = strZzi;
                if (list.size() < 2) {
                    dDoubleValue2 = Double.NaN;
                } else {
                    dDoubleValue2 = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                }
                if (Double.isNaN(dDoubleValue2)) {
                    dZza = Double.POSITIVE_INFINITY;
                } else {
                    dZza = zzh.zza(dDoubleValue2);
                }
                return new zzah(Double.valueOf(str111.lastIndexOf(str112, (int) dZza)));
            case 5:
                zzatVar = this;
                zzh.zzj("match", 1, list);
                String str113 = zzatVar.zza;
                if (list.size() <= 0) {
                    strZzi2 = "";
                } else {
                    strZzi2 = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                matcher = Pattern.compile(strZzi2).matcher(str113);
                if (matcher.find()) {
                    zzaeVar = new zzae(Arrays.asList(new zzat(matcher.group())));
                    return zzaeVar;
                }
                zzatVar2 = zzap.zzg;
                return zzatVar2;
            case 6:
                zzatVar = this;
                zzh.zzj("replace", 2, list);
                zzapVarZza = zzap.zzf;
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                    if (list.size() > 1) {
                        zzapVarZza = zzgVar.zzb((zzap) list.get(1));
                    }
                }
                str7 = strZzi;
                str8 = zzatVar.zza;
                iIndexOf = str8.indexOf(str7);
                if (iIndexOf >= 0) {
                    if (zzapVarZza instanceof zzai) {
                        zzapVarZza = ((zzai) zzapVarZza).zza(zzgVar, Arrays.asList(new zzat(str7), new zzah(Double.valueOf(iIndexOf)), zzatVar));
                    }
                    zzaeVar = new zzat(str8.substring(0, iIndexOf) + zzapVarZza.zzi() + str8.substring(iIndexOf + str7.length()));
                    return zzaeVar;
                }
                return zzatVar;
            case 7:
                zzatVar = this;
                zzh.zzj(AppLovinEventTypes.USER_EXECUTED_SEARCH, 1, list);
                if (!list.isEmpty()) {
                    strZzi = zzgVar.zzb((zzap) list.get(0)).zzi();
                }
                matcher2 = Pattern.compile(strZzi).matcher(zzatVar.zza);
                if (matcher2.find()) {
                    zzaeVar = new zzah(Double.valueOf(matcher2.start()));
                    return zzaeVar;
                }
                zzatVar2 = new zzah(Double.valueOf(-1.0d));
                return zzatVar2;
            case 8:
                zzatVar = this;
                zzh.zzj("slice", 2, list);
                str9 = zzatVar.zza;
                if (list.isEmpty()) {
                    dDoubleValue3 = zzgVar.zzb((zzap) list.get(0)).zzh().doubleValue();
                } else {
                    dDoubleValue3 = 0.0d;
                }
                dZza2 = zzh.zza(dDoubleValue3);
                if (dZza2 < 0.0d) {
                    dMin = Math.max(((double) str9.length()) + dZza2, 0.0d);
                } else {
                    dMin = Math.min(dZza2, str9.length());
                }
                int i16 = (int) dMin;
                if (list.size() > 1) {
                    length = zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue();
                } else {
                    length = str9.length();
                }
                dZza3 = zzh.zza(length);
                if (dZza3 < 0.0d) {
                    dMin2 = Math.max(((double) str9.length()) + dZza3, 0.0d);
                } else {
                    dMin2 = Math.min(dZza3, str9.length());
                }
                zzaeVar = new zzat(str9.substring(i16, Math.max(0, ((int) dMin2) - i16) + i16));
                return zzaeVar;
            case 9:
                zzatVar = this;
                zzh.zzj("split", 2, list);
                str10 = zzatVar.zza;
                if (str10.length() == 0) {
                    zzatVar2 = new zzae(Arrays.asList(zzatVar));
                } else {
                    arrayList = new ArrayList();
                    if (list.isEmpty()) {
                        arrayList.add(zzatVar);
                    } else {
                        strZzi3 = zzgVar.zzb((zzap) list.get(0)).zzi();
                        if (list.size() > 1) {
                            jZzd = zzh.zzd(zzgVar.zzb((zzap) list.get(1)).zzh().doubleValue());
                        } else {
                            jZzd = 2147483647L;
                        }
                        if (jZzd == 0) {
                            zzatVar2 = new zzae();
                        } else {
                            strArrSplit = str10.split(Pattern.quote(strZzi3), ((int) jZzd) + 1);
                            length2 = strArrSplit.length;
                            if (strZzi3.isEmpty()) {
                                i13 = length2;
                                i14 = 0;
                            } else {
                                i13 = length2;
                                i14 = 0;
                            }
                            i14 = zIsEmpty;
                            if (length2 > jZzd) {
                                i13--;
                            }
                            while (i14 < i13) {
                                arrayList.add(new zzat(strArrSplit[i14]));
                                i14++;
                            }
                        }
                    }
                    zzatVar2 = new zzae(arrayList);
                }
                return zzatVar2;
            case 10:
                zzatVar = this;
                zzh.zzj("substring", 2, list);
                str11 = zzatVar.zza;
                if (list.isEmpty()) {
                    zzgVar2 = zzgVar;
                    iZza2 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(0)).zzh().doubleValue());
                } else {
                    zzgVar2 = zzgVar;
                    iZza2 = 0;
                }
                if (list.size() > 1) {
                    length3 = (int) zzh.zza(zzgVar2.zzb((zzap) list.get(1)).zzh().doubleValue());
                } else {
                    length3 = str11.length();
                }
                int iMin3 = Math.min(Math.max(iZza2, 0), str11.length());
                int iMin4 = Math.min(Math.max(length3, 0), str11.length());
                zzaeVar = new zzat(str11.substring(Math.min(iMin3, iMin4), Math.max(iMin3, iMin4)));
                return zzaeVar;
            case 11:
                zzatVar = this;
                zzh.zzh(str2, 0, list);
                zzaeVar = new zzat(zzatVar.zza.toUpperCase());
                return zzaeVar;
            case 12:
                zzatVar = this;
                zzh.zzh("toLocaleLowerCase", 0, list);
                zzaeVar = new zzat(zzatVar.zza.toLowerCase());
                return zzaeVar;
            case 13:
                zzatVar = this;
                zzh.zzh("toLowerCase", 0, list);
                zzaeVar = new zzat(zzatVar.zza.toLowerCase(Locale.ENGLISH));
                return zzaeVar;
            case 14:
                zzatVar = this;
                zzh.zzh(str6, 0, list);
                return zzatVar;
            case 15:
                zzatVar = this;
                zzh.zzh(str3, 0, list);
                zzaeVar = new zzat(zzatVar.zza.toUpperCase(Locale.ENGLISH));
                return zzaeVar;
            case 16:
                zzh.zzh(str3, 0, list);
                zzatVar = this;
                zzaeVar = new zzat(zzatVar.zza.trim());
                return zzaeVar;
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final zzap zzd() {
        return new zzat(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Boolean zzg() {
        return Boolean.valueOf(!this.zza.isEmpty());
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Double zzh() {
        if (this.zza.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(this.zza);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final String zzi() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzap
    public final Iterator zzl() {
        return new zzar(this);
    }
}
