package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaqx {
    public static long zza(String str) {
        try {
            return zzd("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str).getTime();
        } catch (ParseException e11) {
            if ("0".equals(str) || "-1".equals(str)) {
                zzaqm.zzd("Unable to parse dateStr: %s, falling back to 0", str);
                return 0L;
            }
            zzaqm.zzc(e11, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    @Nullable
    public static zzapj zzb(zzapw zzapwVar) {
        boolean z11;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Map map = zzapwVar.zzc;
        if (map == null) {
            return null;
        }
        String str = (String) map.get(HttpHeaders.DATE);
        long jZza = str != null ? zza(str) : 0L;
        String str2 = (String) map.get(HttpHeaders.CACHE_CONTROL);
        int i11 = 0;
        if (str2 != null) {
            String[] strArrSplit = str2.split(",", 0);
            z11 = false;
            j11 = 0;
            j12 = 0;
            while (i11 < strArrSplit.length) {
                String strTrim = strArrSplit[i11].trim();
                if (strTrim.equals("no-cache") || strTrim.equals("no-store")) {
                    return null;
                }
                if (strTrim.startsWith("max-age=")) {
                    try {
                        j12 = Long.parseLong(strTrim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (strTrim.startsWith("stale-while-revalidate=")) {
                    j11 = Long.parseLong(strTrim.substring(23));
                } else if (strTrim.equals("must-revalidate") || strTrim.equals("proxy-revalidate")) {
                    z11 = true;
                }
                i11++;
            }
            i11 = 1;
        } else {
            z11 = false;
            j11 = 0;
            j12 = 0;
        }
        String str3 = (String) map.get(HttpHeaders.EXPIRES);
        long jZza2 = str3 != null ? zza(str3) : 0L;
        String str4 = (String) map.get(HttpHeaders.LAST_MODIFIED);
        long jZza3 = str4 != null ? zza(str4) : 0L;
        String str5 = (String) map.get("ETag");
        if (i11 != 0) {
            j14 = jCurrentTimeMillis + (j12 * 1000);
            if (z11) {
                j15 = j14;
            } else {
                Long.signum(j11);
                j15 = (j11 * 1000) + j14;
            }
            j13 = j15;
        } else {
            j13 = 0;
            if (jZza <= 0 || jZza2 < jZza) {
                j14 = 0;
            } else {
                j14 = jCurrentTimeMillis + (jZza2 - jZza);
                j13 = j14;
            }
        }
        zzapj zzapjVar = new zzapj();
        zzapjVar.zza = zzapwVar.zzb;
        zzapjVar.zzb = str5;
        zzapjVar.zzf = j14;
        zzapjVar.zze = j13;
        zzapjVar.zzc = jZza;
        zzapjVar.zzd = jZza3;
        zzapjVar.zzg = map;
        zzapjVar.zzh = zzapwVar.zzd;
        return zzapjVar;
    }

    public static String zzc(long j11) {
        return zzd("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j11));
    }

    private static SimpleDateFormat zzd(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
