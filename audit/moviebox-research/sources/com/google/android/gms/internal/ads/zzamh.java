package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamh {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    /* JADX WARN: Code duplicated, block: B:121:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:76:0x0127  */
    public static SpannedString zza(@Nullable String str, String str2, List list) {
        byte b11;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        char c11 = 0;
        int i11 = 0;
        while (i11 < str2.length()) {
            int length = i11 + 1;
            char cCharAt = str2.charAt(i11);
            if (cCharAt == '&') {
                int iIndexOf = str2.indexOf(59, length);
                int iIndexOf2 = str2.indexOf(32, length);
                if (iIndexOf == -1) {
                    iIndexOf = iIndexOf2;
                } else if (iIndexOf2 != -1) {
                    iIndexOf = Math.min(iIndexOf, iIndexOf2);
                }
                if (iIndexOf != -1) {
                    String strSubstring = str2.substring(length, iIndexOf);
                    int iHashCode = strSubstring.hashCode();
                    if (iHashCode != 3309) {
                        if (iHashCode != 3464) {
                            if (iHashCode != 96708) {
                                if (iHashCode == 3374865 && strSubstring.equals("nbsp")) {
                                    b11 = 2;
                                } else {
                                    b11 = -1;
                                }
                            } else if (strSubstring.equals("amp")) {
                                b11 = 3;
                            } else {
                                b11 = -1;
                            }
                        } else if (strSubstring.equals("lt")) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                    } else if (strSubstring.equals("gt")) {
                        b11 = 1;
                    } else {
                        b11 = -1;
                    }
                    if (b11 == 0) {
                        spannableStringBuilder.append('<');
                    } else if (b11 == 1) {
                        spannableStringBuilder.append('>');
                    } else if (b11 == 2) {
                        spannableStringBuilder.append(' ');
                    } else if (b11 != 3) {
                        zzff.zzf("WebvttCueParser", "ignoring unsupported entity: '&" + strSubstring + ";'");
                    } else {
                        spannableStringBuilder.append('&');
                    }
                    if (iIndexOf == iIndexOf2) {
                        spannableStringBuilder.append((CharSequence) " ");
                    }
                    i11 = iIndexOf + 1;
                } else {
                    spannableStringBuilder.append(cCharAt);
                }
                c11 = 0;
            } else if (cCharAt != '<') {
                spannableStringBuilder.append(cCharAt);
            } else if (length < str2.length()) {
                char cCharAt2 = str2.charAt(length);
                int iIndexOf3 = str2.indexOf(62, length);
                length = iIndexOf3 == -1 ? str2.length() : iIndexOf3 + 1;
                int i12 = length - 2;
                boolean z11 = str2.charAt(i12) == '/';
                int i13 = i11 + (cCharAt2 == '/' ? 2 : 1);
                if (!z11) {
                    i12 = length - 1;
                }
                String strSubstring2 = str2.substring(i13, i12);
                if (!strSubstring2.trim().isEmpty()) {
                    String strTrim = strSubstring2.trim();
                    zzek.zzd(!strTrim.isEmpty());
                    int i14 = zzfy.zza;
                    String str3 = strTrim.split("[ \\.]", 2)[c11];
                    switch (str3) {
                        case "b":
                        case "c":
                        case "i":
                        case "lang":
                        case "ruby":
                        case "rt":
                        case "u":
                        case "v":
                            if (cCharAt2 == '/') {
                                while (!arrayDeque.isEmpty()) {
                                    zzame zzameVar = (zzame) arrayDeque.pop();
                                    zzg(str, zzameVar, arrayList, spannableStringBuilder, list);
                                    if (arrayDeque.isEmpty()) {
                                        arrayList.clear();
                                    } else {
                                        arrayList.add(new zzamd(zzameVar, spannableStringBuilder.length(), null));
                                    }
                                    if (zzameVar.zza.equals(str3)) {
                                        break;
                                    }
                                }
                                break;
                            } else {
                                if (!z11) {
                                    arrayDeque.push(zzame.zza(strSubstring2, spannableStringBuilder.length()));
                                }
                                break;
                            }
                            break;
                    }
                }
            }
            i11 = length;
            c11 = 0;
        }
        while (!arrayDeque.isEmpty()) {
            zzg(str, (zzame) arrayDeque.pop(), arrayList, spannableStringBuilder, list);
        }
        zzg(str, zzame.zzb(), Collections.emptyList(), spannableStringBuilder, list);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    public static zzea zzb(String str) {
        zzamg zzamgVar = new zzamg();
        zzh(str, zzamgVar);
        return zzamgVar.zza();
    }

    @Nullable
    public static zzama zzc(zzfp zzfpVar, List list) {
        Charset charset = zzfwq.zzc;
        String strZzy = zzfpVar.zzy(charset);
        if (strZzy != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzy);
            if (matcher.matches()) {
                return zze(null, matcher, zzfpVar, list);
            }
            String strZzy2 = zzfpVar.zzy(charset);
            if (strZzy2 != null) {
                Matcher matcher2 = pattern.matcher(strZzy2);
                if (matcher2.matches()) {
                    return zze(strZzy.trim(), matcher2, zzfpVar, list);
                }
            }
        }
        return null;
    }

    private static int zzd(List list, @Nullable String str, zzame zzameVar) {
        List listZzf = zzf(list, str, zzameVar);
        for (int i11 = 0; i11 < listZzf.size(); i11++) {
            zzalz zzalzVar = ((zzamf) listZzf.get(i11)).zzb;
            if (zzalzVar.zze() != -1) {
                return zzalzVar.zze();
            }
        }
        return -1;
    }

    @Nullable
    private static zzama zze(@Nullable String str, Matcher matcher, zzfp zzfpVar, List list) {
        zzamg zzamgVar = new zzamg();
        try {
            String strGroup = matcher.group(1);
            strGroup.getClass();
            zzamgVar.zza = zzamj.zzb(strGroup);
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            zzamgVar.zzb = zzamj.zzb(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zzh(strGroup3, zzamgVar);
            StringBuilder sb2 = new StringBuilder();
            String strZzy = zzfpVar.zzy(zzfwq.zzc);
            while (!TextUtils.isEmpty(strZzy)) {
                if (sb2.length() > 0) {
                    sb2.append("\n");
                }
                sb2.append(strZzy.trim());
                strZzy = zzfpVar.zzy(zzfwq.zzc);
            }
            zzamgVar.zzc = zza(str, sb2.toString(), list);
            return new zzama(zzamgVar.zza().zzp(), zzamgVar.zza, zzamgVar.zzb);
        } catch (NumberFormatException unused) {
            zzff.zzf("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    private static List zzf(List list, @Nullable String str, zzame zzameVar) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzalz zzalzVar = (zzalz) list.get(i11);
            int iZzf = zzalzVar.zzf(str, zzameVar.zza, zzameVar.zzd, zzameVar.zzc);
            if (iZzf > 0) {
                arrayList.add(new zzamf(iZzf, zzalzVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    private static void zzg(@Nullable String str, zzame zzameVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        byte b11;
        int i11 = zzameVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzameVar.zza;
        int iHashCode = str2.hashCode();
        int i12 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode != 3511770) {
                        if (iHashCode != 98) {
                            if (iHashCode != 99) {
                                if (iHashCode != 117) {
                                    if (iHashCode == 118 && str2.equals("v")) {
                                        b11 = 6;
                                    } else {
                                        b11 = -1;
                                    }
                                } else if (str2.equals("u")) {
                                    b11 = 3;
                                } else {
                                    b11 = -1;
                                }
                            } else if (str2.equals("c")) {
                                b11 = 4;
                            } else {
                                b11 = -1;
                            }
                        } else if (str2.equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                            b11 = 0;
                        } else {
                            b11 = -1;
                        }
                    } else if (str2.equals("ruby")) {
                        b11 = 2;
                    } else {
                        b11 = -1;
                    }
                } else if (str2.equals("lang")) {
                    b11 = 5;
                } else {
                    b11 = -1;
                }
            } else if (str2.equals("i")) {
                b11 = 1;
            } else {
                b11 = -1;
            }
        } else if (str2.equals("")) {
            b11 = 7;
        } else {
            b11 = -1;
        }
        switch (b11) {
            case 0:
                spannableStringBuilder.setSpan(new StyleSpan(1), i11, length, 33);
                break;
            case 1:
                spannableStringBuilder.setSpan(new StyleSpan(2), i11, length, 33);
                break;
            case 2:
                int iZzd = zzd(list2, str, zzameVar);
                ArrayList arrayList = new ArrayList(list.size());
                arrayList.addAll(list);
                Collections.sort(arrayList, zzamd.zza);
                int i13 = zzameVar.zzb;
                int i14 = 0;
                int length2 = 0;
                while (i14 < arrayList.size()) {
                    if ("rt".equals(((zzamd) arrayList.get(i14)).zzb.zza)) {
                        zzamd zzamdVar = (zzamd) arrayList.get(i14);
                        int iZzd2 = zzd(list2, str, zzamdVar.zzb);
                        if (iZzd2 == i12) {
                            iZzd2 = iZzd != i12 ? iZzd : 1;
                        }
                        int i15 = zzamdVar.zzb.zzb - length2;
                        int i16 = zzamdVar.zzc - length2;
                        CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i15, i16);
                        spannableStringBuilder.delete(i15, i16);
                        spannableStringBuilder.setSpan(new zzeh(charSequenceSubSequence.toString(), iZzd2), i13, i15, 33);
                        length2 += charSequenceSubSequence.length();
                        i13 = i15;
                    }
                    i14++;
                    i12 = -1;
                }
                break;
            case 3:
                spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                break;
            case 4:
                for (String str3 : zzameVar.zzd) {
                    Map map = zzc;
                    if (map.containsKey(str3)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i11, length, 33);
                    } else {
                        Map map2 = zzd;
                        if (map2.containsKey(str3)) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i11, length, 33);
                        }
                    }
                }
                break;
            case 5:
            case 6:
            case 7:
                break;
            default:
                return;
        }
        List listZzf = zzf(list2, str, zzameVar);
        for (int i17 = 0; i17 < listZzf.size(); i17++) {
            zzalz zzalzVar = ((zzamf) listZzf.get(i17)).zzb;
            if (zzalzVar != null) {
                if (zzalzVar.zzg() != -1) {
                    zzei.zza(spannableStringBuilder, new StyleSpan(zzalzVar.zzg()), i11, length, 33);
                }
                if (zzalzVar.zzz()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i11, length, 33);
                }
                if (zzalzVar.zzy()) {
                    zzei.zza(spannableStringBuilder, new ForegroundColorSpan(zzalzVar.zzc()), i11, length, 33);
                }
                if (zzalzVar.zzx()) {
                    zzei.zza(spannableStringBuilder, new BackgroundColorSpan(zzalzVar.zzb()), i11, length, 33);
                }
                if (zzalzVar.zzr() != null) {
                    zzei.zza(spannableStringBuilder, new TypefaceSpan(zzalzVar.zzr()), i11, length, 33);
                }
                int iZzd3 = zzalzVar.zzd();
                if (iZzd3 == 1) {
                    zzei.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalzVar.zza(), true), i11, length, 33);
                } else if (iZzd3 == 2) {
                    zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzalzVar.zza()), i11, length, 33);
                } else if (iZzd3 == 3) {
                    zzei.zza(spannableStringBuilder, new RelativeSizeSpan(zzalzVar.zza() / 100.0f), i11, length, 33);
                }
                if (zzalzVar.zzw()) {
                    spannableStringBuilder.setSpan(new zzeg(), i11, length, 33);
                }
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static void zzh(String str, zzamg zzamgVar) {
        Matcher matcher = zzb.matcher(str);
        while (matcher.find()) {
            int i11 = 1;
            String strGroup = matcher.group(1);
            strGroup.getClass();
            int i12 = 2;
            String strGroup2 = matcher.group(2);
            strGroup2.getClass();
            try {
                byte b11 = -1;
                if ("line".equals(strGroup)) {
                    int iIndexOf = strGroup2.indexOf(44);
                    if (iIndexOf != -1) {
                        String strSubstring = strGroup2.substring(iIndexOf + 1);
                        switch (strSubstring.hashCode()) {
                            case -1364013995:
                                if (strSubstring.equals(TtmlNode.CENTER)) {
                                    b11 = 1;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring.equals("middle")) {
                                    b11 = 2;
                                }
                                break;
                            case 100571:
                                if (strSubstring.equals(TtmlNode.END)) {
                                    b11 = 3;
                                }
                                break;
                            case 109757538:
                                if (strSubstring.equals("start")) {
                                    b11 = 0;
                                }
                                break;
                        }
                        if (b11 == 0) {
                            i12 = 0;
                        } else if (b11 == 1 || b11 == 2) {
                            i12 = 1;
                        } else if (b11 != 3) {
                            zzff.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring));
                            i12 = Integer.MIN_VALUE;
                        }
                        zzamgVar.zzg = i12;
                        strGroup2 = strGroup2.substring(0, iIndexOf);
                    }
                    if (strGroup2.endsWith("%")) {
                        zzamgVar.zze = zzamj.zza(strGroup2);
                        zzamgVar.zzf = 0;
                    } else {
                        zzamgVar.zze = Integer.parseInt(strGroup2);
                        zzamgVar.zzf = 1;
                    }
                } else if ("align".equals(strGroup)) {
                    switch (strGroup2.hashCode()) {
                        case -1364013995:
                            if (strGroup2.equals(TtmlNode.CENTER)) {
                                b11 = 2;
                            }
                            break;
                        case -1074341483:
                            if (strGroup2.equals("middle")) {
                                b11 = 3;
                            }
                            break;
                        case 100571:
                            if (strGroup2.equals(TtmlNode.END)) {
                                b11 = 4;
                            }
                            break;
                        case 3317767:
                            if (strGroup2.equals(TtmlNode.LEFT)) {
                                b11 = 1;
                            }
                            break;
                        case 108511772:
                            if (strGroup2.equals(TtmlNode.RIGHT)) {
                                b11 = 5;
                            }
                            break;
                        case 109757538:
                            if (strGroup2.equals("start")) {
                                b11 = 0;
                            }
                            break;
                    }
                    if (b11 != 0) {
                        if (b11 == 1) {
                            i11 = 4;
                        } else if (b11 == 2 || b11 == 3) {
                            i11 = 2;
                        } else if (b11 == 4) {
                            i11 = 3;
                        } else if (b11 != 5) {
                            zzff.zzf("WebvttCueParser", "Invalid alignment value: ".concat(strGroup2));
                            i11 = 2;
                        } else {
                            i11 = 5;
                        }
                    }
                    zzamgVar.zzd = i11;
                } else if (RequestParameters.POSITION.equals(strGroup)) {
                    int iIndexOf2 = strGroup2.indexOf(44);
                    if (iIndexOf2 != -1) {
                        String strSubstring2 = strGroup2.substring(iIndexOf2 + 1);
                        switch (strSubstring2.hashCode()) {
                            case -1842484672:
                                if (strSubstring2.equals("line-left")) {
                                    b11 = 0;
                                }
                                break;
                            case -1364013995:
                                if (strSubstring2.equals(TtmlNode.CENTER)) {
                                    b11 = 2;
                                }
                                break;
                            case -1276788989:
                                if (strSubstring2.equals("line-right")) {
                                    b11 = 4;
                                }
                                break;
                            case -1074341483:
                                if (strSubstring2.equals("middle")) {
                                    b11 = 3;
                                }
                                break;
                            case 100571:
                                if (strSubstring2.equals(TtmlNode.END)) {
                                    b11 = 5;
                                }
                                break;
                            case 109757538:
                                if (strSubstring2.equals("start")) {
                                    b11 = 1;
                                }
                                break;
                        }
                        if (b11 == 0 || b11 == 1) {
                            i11 = 0;
                        } else if (b11 != 2 && b11 != 3) {
                            if (b11 == 4 || b11 == 5) {
                                i11 = 2;
                            } else {
                                zzff.zzf("WebvttCueParser", "Invalid anchor value: ".concat(strSubstring2));
                                i11 = Integer.MIN_VALUE;
                            }
                        }
                        zzamgVar.zzi = i11;
                        strGroup2 = strGroup2.substring(0, iIndexOf2);
                    }
                    zzamgVar.zzh = zzamj.zza(strGroup2);
                } else if ("size".equals(strGroup)) {
                    zzamgVar.zzj = zzamj.zza(strGroup2);
                } else if ("vertical".equals(strGroup)) {
                    int iHashCode = strGroup2.hashCode();
                    if (iHashCode != 3462) {
                        if (iHashCode == 3642 && strGroup2.equals("rl")) {
                            b11 = 0;
                        }
                    } else if (strGroup2.equals("lr")) {
                        b11 = 1;
                    }
                    if (b11 != 0) {
                        if (b11 != 1) {
                            zzff.zzf("WebvttCueParser", "Invalid 'vertical' value: ".concat(strGroup2));
                            i11 = Integer.MIN_VALUE;
                        } else {
                            i11 = 2;
                        }
                    }
                    zzamgVar.zzk = i11;
                } else {
                    zzff.zzf("WebvttCueParser", "Unknown cue setting " + strGroup + ":" + strGroup2);
                }
            } catch (NumberFormatException unused) {
                zzff.zzf("WebvttCueParser", "Skipping bad cue setting: ".concat(String.valueOf(matcher.group())));
            }
        }
    }
}
