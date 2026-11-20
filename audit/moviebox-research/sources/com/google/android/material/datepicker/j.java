package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import com.google.android.material.R$string;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {
    public static androidx.core.util.e<String, String> a(@Nullable Long l11, @Nullable Long l12) {
        return b(l11, l12, null);
    }

    public static androidx.core.util.e<String, String> b(@Nullable Long l11, @Nullable Long l12, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l11 == null && l12 == null) {
            return androidx.core.util.e.a(null, null);
        }
        if (l11 == null) {
            return androidx.core.util.e.a(null, d(l12.longValue(), simpleDateFormat));
        }
        if (l12 == null) {
            return androidx.core.util.e.a(d(l11.longValue(), simpleDateFormat), null);
        }
        Calendar calendarQ = y.q();
        Calendar calendarS = y.s();
        calendarS.setTimeInMillis(l11.longValue());
        Calendar calendarS2 = y.s();
        calendarS2.setTimeInMillis(l12.longValue());
        if (simpleDateFormat != null) {
            return androidx.core.util.e.a(simpleDateFormat.format(new Date(l11.longValue())), simpleDateFormat.format(new Date(l12.longValue())));
        }
        if (calendarS.get(1) == calendarS2.get(1)) {
            return calendarS.get(1) == calendarQ.get(1) ? androidx.core.util.e.a(g(l11.longValue(), Locale.getDefault()), g(l12.longValue(), Locale.getDefault())) : androidx.core.util.e.a(g(l11.longValue(), Locale.getDefault()), n(l12.longValue(), Locale.getDefault()));
        }
        return androidx.core.util.e.a(n(l11.longValue(), Locale.getDefault()), n(l12.longValue(), Locale.getDefault()));
    }

    public static String c(long j11) {
        return d(j11, null);
    }

    public static String d(long j11, @Nullable SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            return simpleDateFormat.format(new Date(j11));
        }
        return q(j11) ? f(j11) : m(j11);
    }

    public static String e(Context context, long j11, boolean z11, boolean z12, boolean z13) {
        String strJ = j(j11);
        if (z11) {
            strJ = String.format(context.getString(R$string.mtrl_picker_today_description), strJ);
        }
        if (z12) {
            return String.format(context.getString(R$string.mtrl_picker_start_date_description), strJ);
        }
        return z13 ? String.format(context.getString(R$string.mtrl_picker_end_date_description), strJ) : strJ;
    }

    public static String f(long j11) {
        return g(j11, Locale.getDefault());
    }

    public static String g(long j11, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.c(locale).format(new Date(j11)) : y.l(locale).format(new Date(j11));
    }

    public static String h(long j11) {
        return i(j11, Locale.getDefault());
    }

    public static String i(long j11, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.m(locale).format(new Date(j11)) : y.j(locale).format(new Date(j11));
    }

    public static String j(long j11) {
        return q(j11) ? h(j11) : o(j11);
    }

    public static String k(Context context, int i11) {
        return y.q().get(1) == i11 ? String.format(context.getString(R$string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i11)) : String.format(context.getString(R$string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i11));
    }

    public static String l(long j11) {
        return Build.VERSION.SDK_INT >= 24 ? y.v(Locale.getDefault()).format(new Date(j11)) : DateUtils.formatDateTime(null, j11, 8228);
    }

    public static String m(long j11) {
        return n(j11, Locale.getDefault());
    }

    public static String n(long j11, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.u(locale).format(new Date(j11)) : y.k(locale).format(new Date(j11));
    }

    public static String o(long j11) {
        return p(j11, Locale.getDefault());
    }

    public static String p(long j11, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? y.w(locale).format(new Date(j11)) : y.j(locale).format(new Date(j11));
    }

    public static boolean q(long j11) {
        Calendar calendarQ = y.q();
        Calendar calendarS = y.s();
        calendarS.setTimeInMillis(j11);
        return calendarQ.get(1) == calendarS.get(1);
    }
}
