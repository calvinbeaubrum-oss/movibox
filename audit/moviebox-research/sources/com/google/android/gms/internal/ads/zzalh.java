package com.google.android.gms.internal.ads;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalh implements zzakr {
    private static final Pattern zza = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    private final boolean zzb;

    @Nullable
    private final zzalg zzc;
    private final zzfp zzd;
    private Map zze;
    private float zzf;
    private float zzg;

    public zzalh() {
        this(null);
    }

    public zzalh(@Nullable List list) {
        this.zzf = -3.4028235E38f;
        this.zzg = -3.4028235E38f;
        this.zzd = new zzfp();
        if (list == null || list.isEmpty()) {
            this.zzb = false;
            this.zzc = null;
            return;
        }
        this.zzb = true;
        String strZzz = zzfy.zzz((byte[]) list.get(0));
        zzek.zzd(strZzz.startsWith("Format:"));
        zzalg zzalgVarZza = zzalg.zza(strZzz);
        zzalgVarZza.getClass();
        this.zzc = zzalgVarZza;
        zze(new zzfp((byte[]) list.get(1)), zzfwq.zzc);
    }

    private static float zzb(int i11) {
        if (i11 == 0) {
            return 0.05f;
        }
        if (i11 != 1) {
            return i11 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static int zzc(long j11, List list, List list2) {
        int i11;
        int size = list.size();
        while (true) {
            size--;
            if (size < 0) {
                i11 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j11) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j11) {
                i11 = size + 1;
                break;
            }
        }
        list.add(i11, Long.valueOf(j11));
        list2.add(i11, i11 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i11 - 1)));
        return i11;
    }

    private static long zzd(String str) {
        Matcher matcher = zza.matcher(str.trim());
        if (!matcher.matches()) {
            return C.TIME_UNSET;
        }
        String strGroup = matcher.group(1);
        int i11 = zzfy.zza;
        long j11 = Long.parseLong(strGroup) * 3600000000L;
        long j12 = Long.parseLong(matcher.group(2)) * 60000000;
        return j11 + j12 + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:23:0x0053  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void zze(zzfp zzfpVar, Charset charset) {
        while (true) {
            String strZzy = zzfpVar.zzy(charset);
            if (strZzy == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strZzy)) {
                while (true) {
                    String strZzy2 = zzfpVar.zzy(charset);
                    if (strZzy2 == null || (zzfpVar.zzb() != 0 && zzfpVar.zza(charset) == '[')) {
                        break;
                    }
                    String[] strArrSplit = strZzy2.split(":");
                    if (strArrSplit.length == 2) {
                        byte b11 = 0;
                        String strZza = zzfwk.zza(strArrSplit[0].trim());
                        switch (strZza.hashCode()) {
                            case 1879649548:
                                if (!strZza.equals("playresx")) {
                                    b11 = -1;
                                }
                                break;
                            case 1879649549:
                                if (!strZza.equals("playresy")) {
                                    b11 = -1;
                                } else {
                                    b11 = 1;
                                }
                                break;
                            default:
                                b11 = -1;
                                break;
                        }
                        if (b11 == 0) {
                            this.zzf = Float.parseFloat(strArrSplit[1].trim());
                        } else if (b11 == 1) {
                            try {
                                this.zzg = Float.parseFloat(strArrSplit[1].trim());
                            } catch (NumberFormatException unused) {
                            }
                        }
                    }
                }
            } else if ("[V4+ Styles]".equalsIgnoreCase(strZzy)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                zzali zzaliVarZza = null;
                while (true) {
                    String strZzy3 = zzfpVar.zzy(charset);
                    if (strZzy3 != null && (zzfpVar.zzb() == 0 || zzfpVar.zza(charset) != '[')) {
                        if (strZzy3.startsWith("Format:")) {
                            zzaliVarZza = zzali.zza(strZzy3);
                        } else if (strZzy3.startsWith("Style:")) {
                            if (zzaliVarZza == null) {
                                zzff.zzf("SsaParser", "Skipping 'Style:' line before 'Format:' line: ".concat(strZzy3));
                            } else {
                                zzalk zzalkVarZzb = zzalk.zzb(strZzy3, zzaliVarZza);
                                if (zzalkVarZzb != null) {
                                    linkedHashMap.put(zzalkVarZzb.zza, zzalkVarZzb);
                                }
                            }
                        }
                    }
                }
                this.zze = linkedHashMap;
            } else if ("[V4 Styles]".equalsIgnoreCase(strZzy)) {
                zzff.zze("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strZzy)) {
                return;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x02b0  */
    /* JADX WARN: Code duplicated, block: B:134:0x02df A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x019c  */
    /* JADX WARN: Code duplicated, block: B:69:0x01ac  */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        int i13;
        zzfp zzfpVar;
        Layout.Alignment alignment;
        int i14;
        int i15;
        int i16;
        int i17;
        Integer num;
        int i18;
        zzalh zzalhVar = this;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        zzalhVar.zzd.zzI(bArr, i11 + i12);
        zzalhVar.zzd.zzK(i11);
        Charset charsetZzB = zzalhVar.zzd.zzB();
        if (charsetZzB == null) {
            charsetZzB = zzfwq.zzc;
        }
        if (!zzalhVar.zzb) {
            zzalhVar.zze(zzalhVar.zzd, charsetZzB);
        }
        zzfp zzfpVar2 = zzalhVar.zzd;
        zzalg zzalgVarZza = zzalhVar.zzb ? zzalhVar.zzc : null;
        while (true) {
            String strZzy = zzfpVar2.zzy(charsetZzB);
            if (strZzy == null) {
                int i19 = 0;
                while (i19 < arrayList.size()) {
                    List list = (List) arrayList.get(i19);
                    if (!list.isEmpty()) {
                        if (i19 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzepVar.zza(new zzakj(list, ((Long) arrayList2.get(i19)).longValue(), ((Long) arrayList2.get(i19 + 1)).longValue() - ((Long) arrayList2.get(i19)).longValue()));
                        i13 = 1;
                    } else if (i19 != 0) {
                        i13 = 1;
                    } else {
                        i19 = 0;
                        if (i19 != arrayList.size() - 1) {
                            throw new IllegalStateException();
                        }
                        zzepVar.zza(new zzakj(list, ((Long) arrayList2.get(i19)).longValue(), ((Long) arrayList2.get(i19 + 1)).longValue() - ((Long) arrayList2.get(i19)).longValue()));
                        i13 = 1;
                    }
                    i19 += i13;
                }
                return;
            }
            if (strZzy.startsWith("Format:")) {
                zzalgVarZza = zzalg.zza(strZzy);
            } else {
                if (strZzy.startsWith("Dialogue:")) {
                    if (zzalgVarZza == null) {
                        zzff.zzf("SsaParser", "Skipping dialogue line before complete format: ".concat(strZzy));
                    } else {
                        zzek.zzd(strZzy.startsWith("Dialogue:"));
                        String[] strArrSplit = strZzy.substring(9).split(",", zzalgVarZza.zze);
                        if (strArrSplit.length != zzalgVarZza.zze) {
                            zzff.zzf("SsaParser", "Skipping dialogue line with fewer columns than format: ".concat(strZzy));
                        } else {
                            long jZzd = zzd(strArrSplit[zzalgVarZza.zza]);
                            if (jZzd == C.TIME_UNSET) {
                                zzff.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzy));
                            } else {
                                long jZzd2 = zzd(strArrSplit[zzalgVarZza.zzb]);
                                if (jZzd2 == C.TIME_UNSET) {
                                    zzff.zzf("SsaParser", "Skipping invalid timing: ".concat(strZzy));
                                } else {
                                    Map map = zzalhVar.zze;
                                    zzalk zzalkVar = (map == null || (i18 = zzalgVarZza.zzc) == -1) ? null : (zzalk) map.get(strArrSplit[i18].trim());
                                    String str = strArrSplit[zzalgVarZza.zzd];
                                    zzalj zzaljVarZza = zzalj.zza(str);
                                    String strReplace = zzalj.zzb(str).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " ");
                                    float f11 = zzalhVar.zzf;
                                    float f12 = zzalhVar.zzg;
                                    SpannableString spannableString = new SpannableString(strReplace);
                                    zzea zzeaVar = new zzea();
                                    zzeaVar.zzl(spannableString);
                                    if (zzalkVar != null) {
                                        Integer num2 = zzalkVar.zzc;
                                        zzfpVar = zzfpVar2;
                                        if (num2 != null) {
                                            spannableString.setSpan(new ForegroundColorSpan(num2.intValue()), 0, spannableString.length(), 33);
                                        }
                                        if (zzalkVar.zzj == 3 && (num = zzalkVar.zzd) != null) {
                                            spannableString.setSpan(new BackgroundColorSpan(num.intValue()), 0, spannableString.length(), 33);
                                        }
                                        float f13 = zzalkVar.zze;
                                        if (f13 != -3.4028235E38f && f12 != -3.4028235E38f) {
                                            zzeaVar.zzn(f13 / f12, 1);
                                        }
                                        if (!zzalkVar.zzf) {
                                            i16 = 0;
                                            i17 = 33;
                                            if (zzalkVar.zzg) {
                                                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
                                            }
                                            if (zzalkVar.zzh) {
                                                spannableString.setSpan(new UnderlineSpan(), i16, spannableString.length(), i17);
                                            }
                                            if (zzalkVar.zzi) {
                                                spannableString.setSpan(new StrikethroughSpan(), i16, spannableString.length(), i17);
                                            }
                                        } else if (zzalkVar.zzg) {
                                            i16 = 0;
                                            i17 = 33;
                                            spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
                                        } else {
                                            i16 = 0;
                                            i17 = 33;
                                            spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
                                        }
                                        if (zzalkVar.zzh) {
                                            spannableString.setSpan(new UnderlineSpan(), i16, spannableString.length(), i17);
                                        }
                                        if (zzalkVar.zzi) {
                                            spannableString.setSpan(new StrikethroughSpan(), i16, spannableString.length(), i17);
                                        }
                                    } else {
                                        zzfpVar = zzfpVar2;
                                        zzalgVarZza = zzalgVarZza;
                                        jZzd2 = jZzd2;
                                    }
                                    int i21 = zzaljVarZza.zza;
                                    if (i21 == -1) {
                                        i21 = zzalkVar != null ? zzalkVar.zzb : -1;
                                    }
                                    switch (i21) {
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i21);
                                        case -1:
                                            alignment = null;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            alignment = Layout.Alignment.ALIGN_NORMAL;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            alignment = Layout.Alignment.ALIGN_CENTER;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            alignment = Layout.Alignment.ALIGN_OPPOSITE;
                                            break;
                                    }
                                    zzeaVar.zzm(alignment);
                                    switch (i21) {
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i21);
                                        case -1:
                                            i14 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 4:
                                        case 7:
                                            i14 = 0;
                                            break;
                                        case 2:
                                        case 5:
                                        case 8:
                                            i14 = 1;
                                            break;
                                        case 3:
                                        case 6:
                                        case 9:
                                            i14 = 2;
                                            break;
                                    }
                                    zzeaVar.zzi(i14);
                                    switch (i21) {
                                        case 0:
                                        default:
                                            zzff.zzf("SsaParser", "Unknown alignment: " + i21);
                                        case -1:
                                            i15 = Integer.MIN_VALUE;
                                            break;
                                        case 1:
                                        case 2:
                                        case 3:
                                            i15 = 2;
                                            break;
                                        case 4:
                                        case 5:
                                        case 6:
                                            i15 = 1;
                                            break;
                                        case 7:
                                        case 8:
                                        case 9:
                                            i15 = 0;
                                            break;
                                    }
                                    zzeaVar.zzf(i15);
                                    PointF pointF = zzaljVarZza.zzb;
                                    if (pointF == null || f12 == -3.4028235E38f || f11 == -3.4028235E38f) {
                                        zzeaVar.zzh(zzb(zzeaVar.zzb()));
                                        zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                                    } else {
                                        zzeaVar.zzh(pointF.x / f11);
                                        zzeaVar.zze(zzaljVarZza.zzb.y / f12, 0);
                                    }
                                    zzec zzecVarZzp = zzeaVar.zzp();
                                    int iZzc = zzc(jZzd2, arrayList2, arrayList);
                                    for (int iZzc2 = zzc(jZzd, arrayList2, arrayList); iZzc2 < iZzc; iZzc2++) {
                                        ((List) arrayList.get(iZzc2)).add(zzecVarZzp);
                                    }
                                }
                            }
                        }
                    }
                    zzfpVar = zzfpVar2;
                    zzalgVarZza = zzalgVarZza;
                } else {
                    zzfpVar = zzfpVar2;
                    zzalgVarZza = zzalgVarZza;
                }
                zzalhVar = this;
                charsetZzB = charsetZzB;
                zzfpVar2 = zzfpVar;
                zzalgVarZza = zzalgVarZza;
            }
        }
    }
}
