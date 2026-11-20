package c4;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f14619a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f14620b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    @Nullable
    public static String a(long j11, long j12) {
        if (j11 == 0 && j12 == -1) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bytes=");
        sb2.append(j11);
        sb2.append("-");
        if (j12 != -1) {
            sb2.append((j11 + j12) - 1);
        }
        return sb2.toString();
    }

    public static long b(@Nullable String str, @Nullable String str2) {
        long j11;
        if (TextUtils.isEmpty(str)) {
            j11 = -1;
        } else {
            try {
                j11 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                z3.o.c("HttpUtil", "Unexpected Content-Length [" + str + "]");
                j11 = -1;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j11;
        }
        Matcher matcher = f14619a.matcher(str2);
        if (!matcher.matches()) {
            return j11;
        }
        try {
            long j12 = (Long.parseLong((String) z3.a.e(matcher.group(2))) - Long.parseLong((String) z3.a.e(matcher.group(1)))) + 1;
            if (j11 < 0) {
                return j12;
            }
            if (j11 == j12) {
                return j11;
            }
            z3.o.h("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j11, j12);
        } catch (NumberFormatException unused2) {
            z3.o.c("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j11;
        }
    }

    public static long c(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f14620b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) z3.a.e(matcher.group(1)));
        }
        return -1L;
    }
}
