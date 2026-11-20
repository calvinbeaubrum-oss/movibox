package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaly {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzfp zzc = new zzfp();
    private final StringBuilder zzd = new StringBuilder();

    @Nullable
    public static String zza(zzfp zzfpVar, StringBuilder sb2) {
        zzc(zzfpVar);
        if (zzfpVar.zzb() == 0) {
            return null;
        }
        String strZzd = zzd(zzfpVar, sb2);
        if (!"".equals(strZzd)) {
            return strZzd;
        }
        char cZzm = (char) zzfpVar.zzm();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(cZzm);
        return sb3.toString();
    }

    public static void zzc(zzfp zzfpVar) {
        while (true) {
            for (boolean z11 = true; zzfpVar.zzb() > 0 && z11; z11 = false) {
                char c11 = (char) zzfpVar.zzM()[zzfpVar.zzd()];
                if (c11 == '\t' || c11 == '\n' || c11 == '\f' || c11 == '\r' || c11 == ' ') {
                    zzfpVar.zzL(1);
                } else {
                    int iZzd = zzfpVar.zzd();
                    int iZze = zzfpVar.zze();
                    byte[] bArrZzM = zzfpVar.zzM();
                    if (iZzd + 2 <= iZze) {
                        int i11 = iZzd + 1;
                        if (bArrZzM[iZzd] == 47) {
                            int i12 = iZzd + 2;
                            if (bArrZzM[i11] == 42) {
                                while (true) {
                                    int i13 = i12 + 1;
                                    if (i13 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzM[i12]) == '*' && ((char) bArrZzM[i13]) == '/') {
                                        iZze = i12 + 2;
                                        i12 = iZze;
                                    } else {
                                        i12 = i13;
                                    }
                                }
                                zzfpVar.zzL(iZze - zzfpVar.zzd());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    private static String zzd(zzfp zzfpVar, StringBuilder sb2) {
        char c11;
        sb2.setLength(0);
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        loop0: while (true) {
            boolean z11 = false;
            while (true) {
                if (iZzd < iZze && !z11) {
                    c11 = (char) zzfpVar.zzM()[iZzd];
                    if ((c11 >= 'A' && c11 <= 'Z') || ((c11 >= 'a' && c11 <= 'z') || ((c11 >= '0' && c11 <= '9') || c11 == '#' || c11 == '-' || c11 == '.' || c11 == '_'))) {
                        break;
                    }
                    z11 = true;
                } else {
                    break loop0;
                }
            }
            sb2.append(c11);
            iZzd++;
        }
        zzfpVar.zzL(iZzd - zzfpVar.zzd());
        return sb2.toString();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:102:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:103:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:105:0x0207  */
    /* JADX WARN: Code duplicated, block: B:106:0x020c  */
    /* JADX WARN: Code duplicated, block: B:108:0x0214  */
    /* JADX WARN: Code duplicated, block: B:112:0x0224  */
    /* JADX WARN: Code duplicated, block: B:115:0x022c  */
    /* JADX WARN: Code duplicated, block: B:117:0x0234  */
    /* JADX WARN: Code duplicated, block: B:119:0x023c  */
    /* JADX WARN: Code duplicated, block: B:120:0x0241  */
    /* JADX WARN: Code duplicated, block: B:122:0x0249  */
    /* JADX WARN: Code duplicated, block: B:123:0x024e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0256  */
    /* JADX WARN: Code duplicated, block: B:127:0x025e  */
    /* JADX WARN: Code duplicated, block: B:128:0x0263  */
    /* JADX WARN: Code duplicated, block: B:130:0x026b  */
    /* JADX WARN: Code duplicated, block: B:132:0x0273  */
    /* JADX WARN: Code duplicated, block: B:133:0x0278  */
    /* JADX WARN: Code duplicated, block: B:135:0x0280  */
    /* JADX WARN: Code duplicated, block: B:137:0x0290  */
    /* JADX WARN: Code duplicated, block: B:138:0x02ac  */
    /* JADX WARN: Code duplicated, block: B:140:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:142:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:148:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:150:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:151:0x02d8  */
    /* JADX WARN: Code duplicated, block: B:153:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:154:0x02e2  */
    /* JADX WARN: Code duplicated, block: B:156:0x02e5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:157:0x02e7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:158:0x02e9  */
    /* JADX WARN: Code duplicated, block: B:161:0x02f4  */
    /* JADX WARN: Code duplicated, block: B:162:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:174:0x02ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:185:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:188:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:191:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x0309 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0044  */
    /* JADX WARN: Code duplicated, block: B:94:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:95:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:97:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:98:0x01e9  */
    /* JADX WARN: Instruction removed from duplicated block: B:137:0x0290, please report this as an issue */
    public final List zzb(zzfp zzfpVar) {
        String strTrim;
        String string;
        Matcher matcher;
        String strGroup;
        int iHashCode;
        byte b11;
        boolean z11;
        int i11 = 0;
        this.zzd.setLength(0);
        int iZzd = zzfpVar.zzd();
        while (!TextUtils.isEmpty(zzfpVar.zzy(zzfwq.zzc))) {
        }
        this.zzc.zzI(zzfpVar.zzM(), zzfpVar.zzd());
        this.zzc.zzK(iZzd);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfp zzfpVar2 = this.zzc;
            StringBuilder sb2 = this.zzd;
            zzc(zzfpVar2);
            if (zzfpVar2.zzb() >= 5 && "::cue".equals(zzfpVar2.zzA(5, zzfwq.zzc))) {
                int iZzd2 = zzfpVar2.zzd();
                String strZza = zza(zzfpVar2, sb2);
                if (strZza == null) {
                    strTrim = null;
                } else if ("{".equals(strZza)) {
                    zzfpVar2.zzK(iZzd2);
                    strTrim = "";
                } else {
                    if ("(".equals(strZza)) {
                        int iZzd3 = zzfpVar2.zzd();
                        int iZze = zzfpVar2.zze();
                        boolean z12 = false;
                        while (iZzd3 < iZze && !z12) {
                            int i12 = iZzd3 + 1;
                            z12 = ((char) zzfpVar2.zzM()[iZzd3]) == ')';
                            iZzd3 = i12;
                        }
                        strTrim = zzfpVar2.zzA((iZzd3 - 1) - zzfpVar2.zzd(), zzfwq.zzc).trim();
                    } else {
                        strTrim = null;
                    }
                    if (!")".equals(zza(zzfpVar2, sb2))) {
                        strTrim = null;
                    }
                }
            } else {
                strTrim = null;
            }
            if (strTrim == null || !"{".equals(zza(this.zzc, this.zzd))) {
                break;
            }
            zzalz zzalzVar = new zzalz();
            if (!"".equals(strTrim)) {
                int iIndexOf = strTrim.indexOf(91);
                if (iIndexOf != -1) {
                    Matcher matcher2 = zza.matcher(strTrim.substring(iIndexOf));
                    if (matcher2.matches()) {
                        String strGroup2 = matcher2.group(1);
                        strGroup2.getClass();
                        zzalzVar.zzv(strGroup2);
                    }
                    strTrim = strTrim.substring(i11, iIndexOf);
                }
                int i13 = zzfy.zza;
                String[] strArrSplit = strTrim.split("\\.", -1);
                String str = strArrSplit[i11];
                int iIndexOf2 = str.indexOf(35);
                if (iIndexOf2 != -1) {
                    zzalzVar.zzu(str.substring(i11, iIndexOf2));
                    zzalzVar.zzt(str.substring(iIndexOf2 + 1));
                } else {
                    zzalzVar.zzu(str);
                }
                int length = strArrSplit.length;
                if (length > 1) {
                    zzalzVar.zzs((String[]) Arrays.copyOfRange(strArrSplit, 1, length));
                }
            }
            boolean z13 = false;
            String strZza2 = null;
            while (!z13) {
                zzfp zzfpVar3 = this.zzc;
                StringBuilder sb3 = this.zzd;
                int iZzd4 = zzfpVar3.zzd();
                strZza2 = zza(zzfpVar3, sb3);
                z13 = strZza2 == null || "}".equals(strZza2);
                if (!z13) {
                    this.zzc.zzK(iZzd4);
                    zzfp zzfpVar4 = this.zzc;
                    StringBuilder sb4 = this.zzd;
                    zzc(zzfpVar4);
                    String strZzd = zzd(zzfpVar4, sb4);
                    if (!"".equals(strZzd) && ":".equals(zza(zzfpVar4, sb4))) {
                        zzc(zzfpVar4);
                        StringBuilder sb5 = new StringBuilder();
                        boolean z14 = false;
                        while (true) {
                            if (z14) {
                                string = sb5.toString();
                                break;
                            }
                            int iZzd5 = zzfpVar4.zzd();
                            String strZza3 = zza(zzfpVar4, sb4);
                            if (strZza3 == null) {
                                string = null;
                                break;
                            }
                            if ("}".equals(strZza3) || ";".equals(strZza3)) {
                                zzfpVar4.zzK(iZzd5);
                                z14 = true;
                            } else {
                                sb5.append(strZza3);
                            }
                        }
                        if (string != null && !"".equals(string)) {
                            int iZzd6 = zzfpVar4.zzd();
                            String strZza4 = zza(zzfpVar4, sb4);
                            if (";".equals(strZza4)) {
                                if (TtmlNode.ATTR_TTS_COLOR.equals(strZzd)) {
                                    zzalzVar.zzk(zzen.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalzVar.zzh(zzen.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalzVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalzVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string)) {
                                        z11 = true;
                                    } else {
                                        z11 = true;
                                    }
                                    zzalzVar.zzj(z11);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if (TtmlNode.UNDERLINE.equals(string)) {
                                        zzalzVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalzVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if (TtmlNode.BOLD.equals(string)) {
                                        zzalzVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if (TtmlNode.ITALIC.equals(string)) {
                                        zzalzVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfwk.zza(string));
                                    if (matcher.matches()) {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592) {
                                                    b11 = -1;
                                                } else {
                                                    b11 = 0;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b11 = 1;
                                            } else {
                                                b11 = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b11 = 2;
                                        } else {
                                            b11 = -1;
                                        }
                                        if (b11 != 0) {
                                            zzalzVar.zzn(1);
                                        } else if (b11 != 1) {
                                            zzalzVar.zzn(2);
                                        } else {
                                            if (b11 == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalzVar.zzn(3);
                                        }
                                        String strGroup3 = matcher.group(1);
                                        strGroup3.getClass();
                                        zzalzVar.zzm(Float.parseFloat(strGroup3));
                                    } else {
                                        zzff.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    }
                                } else {
                                    continue;
                                }
                            } else if ("}".equals(strZza4)) {
                                zzfpVar4.zzK(iZzd6);
                                if (TtmlNode.ATTR_TTS_COLOR.equals(strZzd)) {
                                    zzalzVar.zzk(zzen.zza(string));
                                } else if ("background-color".equals(strZzd)) {
                                    zzalzVar.zzh(zzen.zza(string));
                                } else if ("ruby-position".equals(strZzd)) {
                                    if ("over".equals(string)) {
                                        zzalzVar.zzp(1);
                                    } else if ("under".equals(string)) {
                                        zzalzVar.zzp(2);
                                    }
                                } else if ("text-combine-upright".equals(strZzd)) {
                                    if ("all".equals(string) || string.startsWith("digits")) {
                                        z11 = true;
                                    } else {
                                        z11 = false;
                                    }
                                    zzalzVar.zzj(z11);
                                } else if ("text-decoration".equals(strZzd)) {
                                    if (TtmlNode.UNDERLINE.equals(string)) {
                                        zzalzVar.zzq(true);
                                    }
                                } else if ("font-family".equals(strZzd)) {
                                    zzalzVar.zzl(string);
                                } else if ("font-weight".equals(strZzd)) {
                                    if (TtmlNode.BOLD.equals(string)) {
                                        zzalzVar.zzi(true);
                                    }
                                } else if ("font-style".equals(strZzd)) {
                                    if (TtmlNode.ITALIC.equals(string)) {
                                        zzalzVar.zzo(true);
                                    }
                                } else if ("font-size".equals(strZzd)) {
                                    matcher = zzb.matcher(zzfwk.zza(string));
                                    if (matcher.matches()) {
                                        zzff.zzf("WebvttCssParser", "Invalid font-size: '" + string + "'.");
                                    } else {
                                        strGroup = matcher.group(2);
                                        strGroup.getClass();
                                        iHashCode = strGroup.hashCode();
                                        if (iHashCode != 37) {
                                            if (iHashCode != 3240) {
                                                if (iHashCode != 3592 && strGroup.equals("px")) {
                                                    b11 = 0;
                                                } else {
                                                    b11 = -1;
                                                }
                                            } else if (strGroup.equals("em")) {
                                                b11 = 1;
                                            } else {
                                                b11 = -1;
                                            }
                                        } else if (strGroup.equals("%")) {
                                            b11 = 2;
                                        } else {
                                            b11 = -1;
                                        }
                                        if (b11 != 0) {
                                            zzalzVar.zzn(1);
                                        } else if (b11 != 1) {
                                            zzalzVar.zzn(2);
                                        } else {
                                            if (b11 == 2) {
                                                throw new IllegalStateException();
                                            }
                                            zzalzVar.zzn(3);
                                        }
                                        String strGroup4 = matcher.group(1);
                                        strGroup4.getClass();
                                        zzalzVar.zzm(Float.parseFloat(strGroup4));
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
            if ("}".equals(strZza2)) {
                arrayList.add(zzalzVar);
            }
            i11 = 0;
        }
        return arrayList;
    }
}
