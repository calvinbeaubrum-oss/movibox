package com.transsion.baselib.report;

import android.os.SystemClock;
import android.util.Log;
import androidx.lifecycle.h0;
import androidx.lifecycle.u;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class AppPeriodReport implements androidx.lifecycle.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppPeriodReport f51227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Timer f51228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static TimerTask f51229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f51230d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static long f51231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f51232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Long f51233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f51234i;

    static {
        AppPeriodReport appPeriodReport = new AppPeriodReport();
        f51227a = appPeriodReport;
        boolean zC = appPeriodReport.c("app_period_report_debug", 3);
        f51230d = zC;
        f51231f = zC ? 5000L : 300000L;
        f51232g = true;
        f51234i = zC ? 300L : 3000L;
    }

    public static /* synthetic */ void e(AppPeriodReport appPeriodReport, Long l11, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = null;
        }
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        appPeriodReport.d(l11, z11);
    }

    public final void b() {
        String value;
        Long lN;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("key_app_period_report", false);
        long jLongValue = (configBeanB == null || (value = configBeanB.getValue()) == null || (lN = kotlin.text.k.n(value)) == null) ? f51231f : lN.longValue();
        if (jLongValue == 0) {
            jLongValue = f51231f;
        }
        f51231f = jLongValue;
        if (jLongValue > 0) {
            f(true);
            h0.f8724j.a().getLifecycle().a(f51227a);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "event close period " + f51231f + " ", false, 4, null);
        h0.f8724j.a().getLifecycle().d(f51227a);
    }

    public final boolean c(String str, int i11) {
        try {
            return Log.isLoggable(str, i11);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public final void d(Long l11, boolean z11) {
        Long lValueOf;
        String value;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        long j11 = f51231f;
        if (l11 != null && l11.longValue() == j11) {
            lValueOf = Long.valueOf(f51231f);
        } else {
            Long l12 = f51233h;
            lValueOf = l12 != null ? Long.valueOf(jElapsedRealtime - l12.longValue()) : null;
        }
        f51233h = Long.valueOf(jElapsedRealtime);
        if (lValueOf == null || lValueOf.longValue() <= f51234i) {
            return;
        }
        String str = z11 ? "app_background" : "app_foreground";
        uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "report event " + str + " " + lValueOf, false, 4, null);
        HashMap map = new HashMap();
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("keyAliveOff", true);
        if (configBeanB == null || (value = configBeanB.getValue()) == null) {
            value = "0";
        }
        map.put("alive_off", value);
        m.f51277a.w("", str, lValueOf.longValue(), map);
    }

    public final void f(final boolean z11) {
        if (f51231f <= 0) {
            uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "close period " + f51231f + " ", false, 4, null);
            Timer timer = f51228b;
            if (timer != null) {
                timer.purge();
            }
            Timer timer2 = f51228b;
            if (timer2 != null) {
                timer2.cancel();
            }
            TimerTask timerTask = f51229c;
            if (timerTask != null) {
                timerTask.cancel();
            }
            h0.f8724j.a().getLifecycle().d(f51227a);
            return;
        }
        boolean z12 = f51232g;
        Unit unit = null;
        if (z11 != z12) {
            e(this, null, z12, 1, null);
        }
        f51232g = z11;
        TimerTask timerTask2 = f51229c;
        if (timerTask2 != null) {
            timerTask2.cancel();
        }
        f51229c = null;
        Timer timer3 = f51228b;
        if (timer3 != null) {
            timer3.cancel();
        }
        Timer timer4 = f51228b;
        if (timer4 != null) {
            timer4.purge();
        }
        f51228b = null;
        f51228b = new Timer();
        f51229c = new TimerTask() { // from class: com.transsion.baselib.report.AppPeriodReport$startTimer$$inlined$timerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "period event " + z11 + " period " + AppPeriodReport.f51231f + " ", false, 4, null);
                AppPeriodReport.f51227a.d(Long.valueOf(AppPeriodReport.f51231f), z11);
            }
        };
        try {
            Result.Companion companion = Result.Companion;
            Timer timer5 = f51228b;
            if (timer5 != null) {
                TimerTask timerTask3 = f51229c;
                long j11 = f51231f;
                timer5.schedule(timerTask3, j11, j11);
                unit = Unit.f68710a;
            }
            Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.lifecycle.e.a(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.lifecycle.e.b(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.lifecycle.e.c(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.lifecycle.e.d(this, uVar);
    }

    @Override // androidx.lifecycle.f
    public void onStart(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.e(this, owner);
        uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "onStart " + f51231f + " ", false, 4, null);
        if (f51233h == null) {
            f51233h = Long.valueOf(SystemClock.elapsedRealtime());
        }
        f(false);
    }

    @Override // androidx.lifecycle.f
    public void onStop(u owner) {
        Intrinsics.g(owner, "owner");
        androidx.lifecycle.e.f(this, owner);
        uo.b.a.f(uo.b.f78622a, "AppPeriodReport", "onStop " + f51231f + " ", false, 4, null);
        f(true);
    }
}
