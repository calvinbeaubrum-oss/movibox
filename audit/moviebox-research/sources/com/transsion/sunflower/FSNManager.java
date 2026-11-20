package com.transsion.sunflower;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.app.NotificationCompat;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.m;
import com.tencent.mmkv.MMKV;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@TargetApi(33)
public final class FSNManager {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f58381e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static volatile FSNManager f58382f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f58383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f58384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f58385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f58386d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FSNManager a() {
            return FSNManager.f58382f;
        }

        public final FSNManager b(f config) {
            Intrinsics.g(config, "config");
            FSNManager fSNManager = FSNManager.f58382f;
            if (fSNManager == null) {
                synchronized (this) {
                    fSNManager = new FSNManager(config, null);
                    FSNManager.f58382f = fSNManager;
                }
            }
            return fSNManager;
        }
    }

    public FSNManager(f fVar) {
        this.f58383a = fVar;
        this.f58384b = fVar.c();
        this.f58385c = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.sunflower.FSNManager$mmkv$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKV invoke() {
                return MMKV.z("sunflower_app");
            }
        });
        this.f58386d = LazyKt__LazyJVMKt.b(new Function0<e>() { // from class: com.transsion.sunflower.FSNManager$notificationHelper$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                return new e(this.this$0.f58384b, "dauupupup", "dauupupup_name");
            }
        });
    }

    public /* synthetic */ FSNManager(f fVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar);
    }

    public static final void p(FSNManager this$0, String eventSource) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(eventSource, "$eventSource");
        this$0.q(eventSource);
    }

    public final boolean e() {
        Object systemService = this.f58384b.getSystemService("power");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return ((PowerManager) systemService).isScreenOn();
    }

    public final boolean f(FSNConfig fSNConfig) {
        try {
            int i11 = Calendar.getInstance().get(11);
            int[] banTimeScope = fSNConfig.getBanTimeScope();
            List listY0 = kotlin.collections.d.y0(banTimeScope);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("checkBlockTimeWithConfig: hour:");
            sb2.append(i11);
            sb2.append(", banTimeScope:");
            sb2.append(listY0);
            return kotlin.collections.d.G(banTimeScope, i11);
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final void g() {
        e.f58389d.a(this.f58384b, 10001);
    }

    public final boolean h(FSNConfig fSNConfig) {
        Function0<Boolean> function0G;
        boolean enable = fSNConfig.getEnable();
        boolean z11 = !fSNConfig.getOnly4SilentUser() || ((function0G = this.f58383a.g()) != null && function0G.invoke().booleanValue());
        boolean z12 = (System.currentTimeMillis() / ((long) 1000)) - j() > fSNConfig.getEffectInterval();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("effectBlock: ");
        sb2.append(!enable);
        sb2.append(", ");
        sb2.append(!z12);
        sb2.append(", ");
        sb2.append(!z11);
        return (enable && z12 && z11) ? false : true;
    }

    public final long i() {
        long delayTime;
        if (this.f58383a.j()) {
            FSNConfig fSNConfigB = this.f58383a.b();
            delayTime = fSNConfigB != null ? fSNConfigB.getDelayTime() : 20L;
        } else {
            FSNConfig fSNConfigB2 = this.f58383a.b();
            delayTime = fSNConfigB2 != null ? fSNConfigB2.getDelayTime() : 900L;
        }
        return delayTime * ((long) 1000);
    }

    public final long j() {
        return k().getLong("dauupupup_last_effect_time", 0L);
    }

    public final MMKV k() {
        Object value = this.f58385c.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final e l() {
        return (e) this.f58386d.getValue();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final void m(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -2128145023:
                    if (!str.equals("android.intent.action.SCREEN_OFF")) {
                        return;
                    }
                    break;
                case -1886648615:
                    if (!str.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        return;
                    }
                    break;
                case -1454123155:
                    if (str.equals("android.intent.action.SCREEN_ON")) {
                        g();
                        return;
                    }
                    return;
                case 1019184907:
                    if (!str.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            o(false, str);
        }
    }

    public final void n() {
        WorkManager.g(this.f58384b.getApplicationContext()).f("FSIWorker", ExistingPeriodicWorkPolicy.UPDATE, new m.a(FSIWorker.class, this.f58383a.j() ? 1L : 60L, TimeUnit.MINUTES).i(new androidx.work.b.a().a()).b());
    }

    public final void o(boolean z11, final String eventSource) {
        Intrinsics.g(eventSource, "eventSource");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 33) {
            return;
        }
        if (i11 < 24 || i11 > 33 || z11) {
            q(eventSource);
            return;
        }
        long jI = i();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onReceive: fsi delay:");
        sb2.append(jI);
        sb2.append(" start");
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = this.f58384b.getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
            ((AlarmManager) systemService).set(0, System.currentTimeMillis() + i(), "tag", new AlarmManager.OnAlarmListener() { // from class: com.transsion.sunflower.b
                @Override // android.app.AlarmManager.OnAlarmListener
                public final void onAlarm() {
                    FSNManager.p(this.f58387a, eventSource);
                }
            }, new Handler(Looper.getMainLooper()));
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final void q(String eventSource) {
        Intrinsics.g(eventSource, "eventSource");
        FSNConfig fSNConfigB = this.f58383a.b();
        if (fSNConfigB == null) {
            Function1<String, Unit> function1E = this.f58383a.e();
            if (function1E != null) {
                function1E.invoke(" block by simba config null");
                return;
            }
            return;
        }
        Function0<Boolean> function0I = this.f58383a.i();
        if (function0I != null && !function0I.invoke().booleanValue()) {
            Function1<String, Unit> function1E2 = this.f58383a.e();
            if (function1E2 != null) {
                function1E2.invoke(" block by app foreground");
                return;
            }
            return;
        }
        if (h(fSNConfigB)) {
            Function1<String, Unit> function1E3 = this.f58383a.e();
            if (function1E3 != null) {
                function1E3.invoke(" block by remote switcher");
                return;
            }
            return;
        }
        if (f(fSNConfigB)) {
            Function1<String, Unit> function1E4 = this.f58383a.e();
            if (function1E4 != null) {
                function1E4.invoke(" block by time limit");
                return;
            }
            return;
        }
        if (e()) {
            Function1<String, Unit> function1E5 = this.f58383a.e();
            if (function1E5 != null) {
                function1E5.invoke(" block by remote screen state");
                return;
            }
            return;
        }
        Intent intentH = this.f58383a.h();
        if (intentH == null) {
            Function1<String, Unit> function1E6 = this.f58383a.e();
            if (function1E6 != null) {
                function1E6.invoke(" block by intent == null, deeplink:" + fSNConfigB.getDeepLink());
                return;
            }
            return;
        }
        PendingIntent activity = PendingIntent.getActivity(this.f58384b, 1, intentH, 201326592);
        e eVarL = l();
        s();
        Function1<String, Unit> function1F = this.f58383a.f();
        if (function1F != null) {
            function1F.invoke(eventSource);
        }
        Context context = this.f58384b;
        NotificationCompat.m mVarL = new NotificationCompat.m(context, "dauupupup").K(this.f58383a.d()).P(-1).l(true);
        Intrinsics.f(mVarL, "Builder(ctx, CHANNEL_ID)…     .setAutoCancel(true)");
        eVarL.a(context, mVarL, activity, 10001);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sendFSI-");
        sb2.append(eventSource);
        sb2.append(" done");
    }

    public final void r(FSNConfig fSNConfig) {
        this.f58383a.l(fSNConfig);
    }

    public final void s() {
        k().putLong("dauupupup_last_effect_time", System.currentTimeMillis() / ((long) 1000));
    }
}
