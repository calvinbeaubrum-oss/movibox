package com.google.android.material.datepicker;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicReference<s> f36782a = new AtomicReference<>();

    public static long a(long j11) {
        Calendar calendarS = s();
        calendarS.setTimeInMillis(j11);
        return f(calendarS).getTimeInMillis();
    }

    public static int b(@NonNull String str, @NonNull String str2, int i11, int i12) {
        while (i12 >= 0 && i12 < str.length() && str2.indexOf(str.charAt(i12)) == -1) {
            if (str.charAt(i12) == '\'') {
                do {
                    i12 += i11;
                    if (i12 < 0 || i12 >= str.length()) {
                        break;
                    }
                } while (str.charAt(i12) != '\'');
            }
            i12 += i11;
        }
        return i12;
    }

    @TargetApi(24)
    public static DateFormat c(Locale locale) {
        return d("MMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat d(String str, Locale locale) {
        DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton(str, locale);
        instanceForSkeleton.setTimeZone(r());
        instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        return instanceForSkeleton;
    }

    @NonNull
    public static String e(@NonNull String str) {
        return str.replaceAll("[^dMy/\\-.]", "").replaceAll("d{1,2}", "dd").replaceAll("M{1,2}", "MM").replaceAll("y{1,4}", "yyyy").replaceAll("\\.$", "").replaceAll("My", "M/y");
    }

    public static Calendar f(Calendar calendar) {
        Calendar calendarT = t(calendar);
        Calendar calendarS = s();
        calendarS.set(calendarT.get(1), calendarT.get(2), calendarT.get(5));
        return calendarS;
    }

    public static SimpleDateFormat g() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(e(((SimpleDateFormat) java.text.DateFormat.getDateInstance(3, Locale.getDefault())).toPattern()), Locale.getDefault());
        simpleDateFormat.setTimeZone(p());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    public static String h(Resources resources, SimpleDateFormat simpleDateFormat) {
        String pattern = simpleDateFormat.toPattern();
        String string = resources.getString(R$string.mtrl_picker_text_input_year_abbr);
        String string2 = resources.getString(R$string.mtrl_picker_text_input_month_abbr);
        String string3 = resources.getString(R$string.mtrl_picker_text_input_day_abbr);
        if (Locale.getDefault().getLanguage().equals(Locale.KOREAN.getLanguage())) {
            pattern = pattern.replaceAll("d+", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).replaceAll("M+", "M").replaceAll("y+", "y");
        }
        return pattern.replace(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D, string3).replace("M", string2).replace("y", string);
    }

    public static java.text.DateFormat i(int i11, Locale locale) {
        java.text.DateFormat dateInstance = java.text.DateFormat.getDateInstance(i11, locale);
        dateInstance.setTimeZone(p());
        return dateInstance;
    }

    public static java.text.DateFormat j(Locale locale) {
        return i(0, locale);
    }

    public static java.text.DateFormat k(Locale locale) {
        return i(2, locale);
    }

    public static java.text.DateFormat l(Locale locale) {
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat) k(locale);
        simpleDateFormat.applyPattern(x(simpleDateFormat.toPattern()));
        return simpleDateFormat;
    }

    @TargetApi(24)
    public static DateFormat m(Locale locale) {
        return d("MMMMEEEEd", locale);
    }

    public static java.text.DateFormat n(@NonNull java.text.DateFormat dateFormat) {
        java.text.DateFormat dateFormat2 = (java.text.DateFormat) dateFormat.clone();
        dateFormat2.setTimeZone(p());
        return dateFormat2;
    }

    public static s o() {
        s sVar = f36782a.get();
        return sVar == null ? s.c() : sVar;
    }

    public static TimeZone p() {
        return TimeZone.getTimeZone("UTC");
    }

    public static Calendar q() {
        Calendar calendarA = o().a();
        calendarA.set(11, 0);
        calendarA.set(12, 0);
        calendarA.set(13, 0);
        calendarA.set(14, 0);
        calendarA.setTimeZone(p());
        return calendarA;
    }

    @TargetApi(24)
    public static android.icu.util.TimeZone r() {
        return android.icu.util.TimeZone.getTimeZone("UTC");
    }

    public static Calendar s() {
        return t(null);
    }

    public static Calendar t(@Nullable Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(p());
        if (calendar == null) {
            calendar2.clear();
        } else {
            calendar2.setTimeInMillis(calendar.getTimeInMillis());
        }
        return calendar2;
    }

    @TargetApi(24)
    public static DateFormat u(Locale locale) {
        return d("yMMMd", locale);
    }

    @TargetApi(24)
    public static DateFormat v(Locale locale) {
        return d("yMMMM", locale);
    }

    @TargetApi(24)
    public static DateFormat w(Locale locale) {
        return d("yMMMMEEEEd", locale);
    }

    @NonNull
    public static String x(@NonNull String str) {
        int iB = b(str, "yY", 1, 0);
        if (iB >= str.length()) {
            return str;
        }
        String str2 = "EMd";
        int iB2 = b(str, "EMd", 1, iB);
        if (iB2 < str.length()) {
            str2 = "EMd,";
        }
        return str.replace(str.substring(b(str, str2, -1, iB) + 1, iB2), " ").trim();
    }
}
