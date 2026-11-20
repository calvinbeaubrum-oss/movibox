package com.transsion.baseui.util;

import android.annotation.SuppressLint;
import com.blankj.utilcode.util.h0;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TimeUtilKt {
    public static final q1 a(int i11, k0 scope, Function1<? super Integer, Unit> onTick, Function0<Unit> function0) {
        Intrinsics.g(scope, "scope");
        Intrinsics.g(onTick, "onTick");
        return kotlinx.coroutines.flow.c.r(kotlinx.coroutines.flow.c.t(kotlinx.coroutines.flow.c.u(kotlinx.coroutines.flow.c.q(kotlinx.coroutines.flow.c.o(new TimeUtilKt$countdownByFlow$1(i11, null)), w0.c()), new TimeUtilKt$countdownByFlow$2(onTick, null)), new TimeUtilKt$countdownByFlow$3(function0, null)), scope);
    }

    public static final int b() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final int c(long j11) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j11);
        return (calendar.get(1) * 10000) + ((calendar.get(2) + 1) * 100) + calendar.get(5);
    }

    public static final String d(long j11) {
        String strI = h0.i(j11, h0.d("yyyy/MM/dd HH:mm:ss"));
        Intrinsics.f(strI, "millis2String(millions, …t(\"yyyy/MM/dd HH:mm:ss\"))");
        return strI;
    }

    public static final String e(int i11) {
        int i12 = i11 / 3600;
        int i13 = (i11 % 3600) / 60;
        int i14 = i11 % 60;
        StringBuilder sb2 = new StringBuilder();
        if (i12 > 0) {
            sb2.append(i13);
            sb2.append(" h ");
        }
        if (i13 > 0) {
            sb2.append(i13);
            sb2.append(" min ");
        }
        if (i14 > 0) {
            sb2.append(i14);
            sb2.append(" sec");
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    public static final String f(long j11) {
        long j12 = j11 / ((long) 1000);
        long j13 = 60;
        long j14 = j12 % j13;
        long j15 = (j12 / j13) % j13;
        long j16 = j12 / ((long) 3600);
        if (j16 > 0) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16), Long.valueOf(j15), Long.valueOf(j14)}, 3));
            Intrinsics.f(str, "format(...)");
            return str;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.f68912a;
        String str2 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j15), Long.valueOf(j14)}, 2));
        Intrinsics.f(str2, "format(...)");
        return str2;
    }

    public static final String g(long j11) {
        int i11 = Calendar.getInstance().get(1);
        String strI = h0.i(j11, h0.d("yyyy-MM-dd HH:mm:ss"));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(h0.j(strI));
        if (i11 == calendar.get(1)) {
            String strI2 = h0.i(j11, h0.d("MM-dd"));
            Intrinsics.f(strI2, "{\n        TimeUtils.mill…ateFormat(\"MM-dd\"))\n    }");
            return strI2;
        }
        String strI3 = h0.i(j11, h0.d("yyyy-MM-dd"));
        Intrinsics.f(strI3, "{\n        TimeUtils.mill…rmat(\"yyyy-MM-dd\"))\n    }");
        return strI3;
    }

    public static final String h(long j11) {
        String strI = h0.i(j11, h0.d("yyyy-MM-dd"));
        Intrinsics.f(strI, "millis2String(millions, …DateFormat(\"yyyy-MM-dd\"))");
        return strI;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static final String i(long j11) {
        if (j11 == 0) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = j11 >= 3600000 ? new SimpleDateFormat("HH:mm:ss") : new SimpleDateFormat("mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        String str = simpleDateFormat.format(Long.valueOf(j11));
        Intrinsics.f(str, "format.format(mislls)");
        return str;
    }

    public static final String j(long j11) {
        StringBuilder sb2 = new StringBuilder();
        if (j11 > 3600) {
            long j12 = 3600;
            long j13 = j11 / j12;
            j11 -= j12 * j13;
            if (j13 < 10) {
                sb2.append("0");
            }
            sb2.append(j13);
            sb2.append(":");
        }
        if (j11 > 60) {
            long j14 = 60;
            long j15 = j11 / j14;
            j11 -= j14 * j15;
            if (j15 < 10) {
                sb2.append("0");
            }
            sb2.append(j15);
            sb2.append(":");
        } else {
            sb2.append("00:");
        }
        if (j11 <= 0) {
            sb2.append("00");
        } else if (j11 > 60) {
            sb2.append("59");
        } else if (j11 < 10) {
            sb2.append("0" + j11);
        } else {
            sb2.append(j11);
        }
        String string = sb2.toString();
        Intrinsics.f(string, "sb.toString()");
        return string;
    }

    public static final int k(long j11) {
        long jCurrentTimeMillis = j11 - System.currentTimeMillis();
        if (jCurrentTimeMillis < 0) {
            return -1;
        }
        return (int) TimeUnit.MILLISECONDS.toDays(jCurrentTimeMillis);
    }
}
