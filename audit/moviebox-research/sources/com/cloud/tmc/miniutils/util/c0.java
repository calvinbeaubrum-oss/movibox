package com.cloud.tmc.miniutils.util;

import android.os.Build;
import androidx.annotation.NonNull;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Map<String, SimpleDateFormat>> f31984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f31985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f31986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f31987d;

    /* JADX INFO: compiled from: source.java */
    public class a extends ThreadLocal<Map<String, SimpleDateFormat>> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<String, SimpleDateFormat> initialValue() {
            return new HashMap();
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f31984a = ThreadLocal.withInitial(new Supplier() { // from class: com.cloud.tmc.miniutils.util.b0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return new HashMap();
                }
            });
        } else {
            f31984a = new a();
        }
        f31985b = new String[]{"猴", "鸡", "狗", "猪", "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊"};
        f31986c = new int[]{20, 19, 21, 21, 21, 22, 23, 23, 23, 24, 23, 22};
        f31987d = new String[]{"水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座"};
    }

    public static String a(long j11, long j12, int i11) {
        return c(j11 - j12, i11);
    }

    public static long b() {
        return System.currentTimeMillis();
    }

    public static String c(long j11, int i11) {
        if (i11 <= 0) {
            return null;
        }
        int iMin = Math.min(i11, 5);
        String[] strArr = {"天", "小时", "分钟", "秒", "毫秒"};
        if (j11 == 0) {
            return 0 + strArr[iMin - 1];
        }
        StringBuilder sb2 = new StringBuilder();
        if (j11 < 0) {
            sb2.append("-");
            j11 = -j11;
        }
        int[] iArr = {86400000, 3600000, 60000, 1000, 1};
        for (int i12 = 0; i12 < iMin; i12++) {
            int i13 = iArr[i12];
            if (j11 >= i13) {
                long j12 = j11 / ((long) i13);
                j11 -= ((long) i13) * j12;
                sb2.append(j12);
                sb2.append(strArr[i12]);
            }
        }
        return sb2.toString();
    }

    public static String d(long j11, @NonNull DateFormat dateFormat) {
        return dateFormat.format(new Date(j11));
    }
}
