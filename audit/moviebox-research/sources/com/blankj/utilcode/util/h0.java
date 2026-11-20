package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import com.hisavana.common.constant.ComConstants;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Map<String, SimpleDateFormat>> f25328a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f25329b = {"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f25330c = {20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f25331d = {"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};

    /* JADX INFO: compiled from: source.java */
    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    }

    public static long a(Date date) {
        return date.getTime();
    }

    public static String b(Date date, @NonNull String str) {
        return d(str).format(date);
    }

    public static SimpleDateFormat c() {
        return d("yyyy-MM-dd HH:mm:ss");
    }

    @SuppressLint({"SimpleDateFormat"})
    public static SimpleDateFormat d(String str) {
        Map<String, SimpleDateFormat> map = f25328a.get();
        SimpleDateFormat simpleDateFormat = map.get(str);
        if (simpleDateFormat != null) {
            return simpleDateFormat;
        }
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(str);
        map.put(str, simpleDateFormat2);
        return simpleDateFormat2;
    }

    public static long e() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(13, 0);
        calendar.set(12, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static boolean f(long j11) {
        long jE = e();
        return j11 >= jE && j11 < jE + ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED;
    }

    public static Date g(long j11) {
        return new Date(j11);
    }

    public static String h(long j11) {
        return i(j11, c());
    }

    public static String i(long j11, @NonNull DateFormat dateFormat) {
        return dateFormat.format(new Date(j11));
    }

    public static Date j(String str) {
        return l(str, c());
    }

    public static Date k(String str, @NonNull String str2) {
        return l(str, d(str2));
    }

    public static Date l(String str, @NonNull DateFormat dateFormat) {
        try {
            return dateFormat.parse(str);
        } catch (ParseException e11) {
            e11.printStackTrace();
            return null;
        }
    }
}
