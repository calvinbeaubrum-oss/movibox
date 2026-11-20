package com.google.android.gms.internal.ads;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzall implements zzakr {
    private static final Pattern zza = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");
    private static final Pattern zzb = Pattern.compile("\\{\\\\.*?\\}");
    private final StringBuilder zzc = new StringBuilder();
    private final ArrayList zzd = new ArrayList();
    private final zzfp zze = new zzfp();

    public static float zzb(int i11) {
        if (i11 == 0) {
            return 0.08f;
        }
        if (i11 == 1) {
            return 0.5f;
        }
        if (i11 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long zzc(Matcher matcher, int i11) {
        String strGroup = matcher.group(i11 + 1);
        long j11 = strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L;
        String strGroup2 = matcher.group(i11 + 2);
        strGroup2.getClass();
        long j12 = j11 + (Long.parseLong(strGroup2) * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS);
        String strGroup3 = matcher.group(i11 + 3);
        strGroup3.getClass();
        long j13 = j12 + (Long.parseLong(strGroup3) * 1000);
        String strGroup4 = matcher.group(i11 + 4);
        if (strGroup4 != null) {
            j13 += Long.parseLong(strGroup4);
        }
        return j13 * 1000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:59:0x013d  */
    /* JADX WARN: Code duplicated, block: B:94:0x0197  */
    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        String str;
        byte b11;
        byte b12;
        zzec zzecVarZzp;
        zzall zzallVar = this;
        zzallVar.zze.zzI(bArr, i11 + i12);
        zzallVar.zze.zzK(i11);
        Charset charsetZzB = zzallVar.zze.zzB();
        if (charsetZzB == null) {
            charsetZzB = zzfwq.zzc;
        }
        while (true) {
            String strZzy = zzallVar.zze.zzy(charsetZzB);
            if (strZzy == null) {
                return;
            }
            if (strZzy.length() != 0) {
                try {
                    Integer.parseInt(strZzy);
                    String strZzy2 = zzallVar.zze.zzy(charsetZzB);
                    if (strZzy2 == null) {
                        zzff.zzf("SubripParser", "Unexpected end");
                        return;
                    }
                    Matcher matcher = zza.matcher(strZzy2);
                    if (matcher.matches()) {
                        long jZzc = zzc(matcher, 1);
                        long jZzc2 = zzc(matcher, 6);
                        zzallVar.zzc.setLength(0);
                        zzallVar.zzd.clear();
                        for (String strZzy3 = zzallVar.zze.zzy(charsetZzB); !TextUtils.isEmpty(strZzy3); strZzy3 = zzallVar.zze.zzy(charsetZzB)) {
                            if (zzallVar.zzc.length() > 0) {
                                zzallVar.zzc.append("<br>");
                            }
                            StringBuilder sb2 = zzallVar.zzc;
                            ArrayList arrayList = zzallVar.zzd;
                            String strTrim = strZzy3.trim();
                            StringBuilder sb3 = new StringBuilder(strTrim);
                            Matcher matcher2 = zzb.matcher(strTrim);
                            int i13 = 0;
                            while (matcher2.find()) {
                                String strGroup = matcher2.group();
                                arrayList.add(strGroup);
                                int iStart = matcher2.start() - i13;
                                int length = strGroup.length();
                                sb3.replace(iStart, iStart + length, "");
                                i13 += length;
                            }
                            sb2.append(sb3.toString());
                        }
                        Spanned spannedFromHtml = Html.fromHtml(zzallVar.zzc.toString());
                        int i14 = 0;
                        while (true) {
                            if (i14 < zzallVar.zzd.size()) {
                                str = (String) zzallVar.zzd.get(i14);
                                if (!str.matches("\\{\\\\an[1-9]\\}")) {
                                    i14++;
                                }
                            } else {
                                str = null;
                            }
                        }
                        zzea zzeaVar = new zzea();
                        zzeaVar.zzl(spannedFromHtml);
                        if (str == null) {
                            zzecVarZzp = zzeaVar.zzp();
                        } else {
                            switch (str) {
                                case "{\an1}":
                                    b11 = 0;
                                    break;
                                case "{\an3}":
                                    b11 = 3;
                                    break;
                                case "{\an4}":
                                    b11 = 1;
                                    break;
                                case "{\an6}":
                                    b11 = 4;
                                    break;
                                case "{\an7}":
                                    b11 = 2;
                                    break;
                                case "{\an9}":
                                    b11 = 5;
                                    break;
                                default:
                                    b11 = -1;
                                    break;
                            }
                            if (b11 == 0 || b11 == 1 || b11 == 2) {
                                zzeaVar.zzi(0);
                            } else if (b11 == 3 || b11 == 4 || b11 == 5) {
                                zzeaVar.zzi(2);
                            } else {
                                zzeaVar.zzi(1);
                            }
                            switch (str) {
                                case "{\an1}":
                                    b12 = 0;
                                    break;
                                case "{\an2}":
                                    b12 = 1;
                                    break;
                                case "{\an3}":
                                    b12 = 2;
                                    break;
                                case "{\an7}":
                                    b12 = 3;
                                    break;
                                case "{\an8}":
                                    b12 = 4;
                                    break;
                                case "{\an9}":
                                    b12 = 5;
                                    break;
                                default:
                                    b12 = -1;
                                    break;
                            }
                            if (b12 == 0 || b12 == 1 || b12 == 2) {
                                zzeaVar.zzf(2);
                            } else if (b12 == 3 || b12 == 4 || b12 == 5) {
                                zzeaVar.zzf(0);
                            } else {
                                zzeaVar.zzf(1);
                            }
                            zzeaVar.zzh(zzb(zzeaVar.zzb()));
                            zzeaVar.zze(zzb(zzeaVar.zza()), 0);
                            zzecVarZzp = zzeaVar.zzp();
                        }
                        zzepVar.zza(new zzakj(zzgaa.zzm(zzecVarZzp), jZzc, jZzc2 - jZzc));
                    } else {
                        zzff.zzf("SubripParser", "Skipping invalid timing: ".concat(strZzy2));
                    }
                } catch (NumberFormatException unused) {
                    zzff.zzf("SubripParser", "Skipping invalid index: ".concat(strZzy));
                }
            }
            zzallVar = this;
        }
    }
}
