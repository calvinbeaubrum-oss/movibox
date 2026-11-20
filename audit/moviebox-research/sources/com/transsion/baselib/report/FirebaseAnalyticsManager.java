package com.transsion.baselib.report;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
import android.os.Process;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

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
public final class FirebaseAnalyticsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FirebaseAnalyticsManager f51235a = new FirebaseAnalyticsManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51236b = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.baselib.report.FirebaseAnalyticsManager$loginApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ILoginApi invoke() {
            return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f51237c = new Regex("VmSize:\\s*(\\d+)\\s*kB");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f51238d = new Regex("VmRSS:\\s*(\\d+)\\s*kB");

    public static /* synthetic */ void i(FirebaseAnalyticsManager firebaseAnalyticsManager, File file, Charset charset, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = Charsets.f69091b;
        }
        firebaseAnalyticsManager.h(file, charset, function1);
    }

    public final String g(long j11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf((j11 / 1024.0f) / 1024.0f)}, 1));
        Intrinsics.f(str, "format(...)");
        return str + "MB";
    }

    public final void h(File file, Charset charset, Function1<? super String, Unit> function1) {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            TextStreamsKt.c(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            thM166exceptionOrNullimpl.printStackTrace();
        }
    }

    public final ILoginApi j() {
        Object value = f51236b.getValue();
        Intrinsics.f(value, "<get-loginApi>(...)");
        return (ILoginApi) value;
    }

    public final Debug.MemoryInfo k(Context context) {
        if (context == null) {
            return null;
        }
        Object systemService = context.getSystemService("activity");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        ActivityManager activityManager = (ActivityManager) systemService;
        activityManager.getMemoryInfo(new ActivityManager.MemoryInfo());
        Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
        Intrinsics.f(processMemoryInfo, "activityManager.getProcessMemoryInfo(pids)");
        return processMemoryInfo[0];
    }

    public final String l(int i11) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str = String.format(Locale.ENGLISH, "%.1f", Arrays.copyOf(new Object[]{Float.valueOf(i11 / 1024.0f)}, 1));
        Intrinsics.f(str, "format(...)");
        return str + "MB";
    }

    public final int m(Regex regex, String str) {
        List<String> listA;
        String str2;
        MatchResult matchResultMatchEntire = regex.matchEntire(StringsKt__StringsKt.Z0(str).toString());
        if (matchResultMatchEntire == null || (listA = matchResultMatchEntire.a()) == null || (str2 = (String) CollectionsKt___CollectionsKt.h0(listA, 1)) == null) {
            return 0;
        }
        return Integer.parseInt(str2);
    }

    public final void n(String event, final Bundle bundle, Context context) {
        Intrinsics.g(event, "event");
        FirebaseAnalytics firebaseAnalyticsA = pj.a.a(il.a.f67224a);
        Debug.MemoryInfo memoryInfoK = k(context);
        if (memoryInfoK != null) {
            if (bundle != null) {
                bundle.putString("max_heap", f51235a.g(Runtime.getRuntime().maxMemory()));
            }
            if (bundle != null) {
                bundle.putString("total_heap", f51235a.g(Runtime.getRuntime().totalMemory()));
            }
            if (bundle != null) {
                bundle.putString("free_heap", f51235a.g(Runtime.getRuntime().freeMemory()));
            }
            if (bundle != null) {
                bundle.putString("native_pss", f51235a.l(memoryInfoK.nativePss));
            }
            if (bundle != null) {
                bundle.putString("other_pss", f51235a.l(memoryInfoK.otherPss));
            }
            i(f51235a, new File("/proc/self/status"), null, new Function1<String, Unit>() { // from class: com.transsion.baselib.report.FirebaseAnalyticsManager$reportEvent$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String line) {
                    Bundle bundle2;
                    Intrinsics.g(line, "line");
                    if (kotlin.text.l.L(line, "VmSize", false, 2, null)) {
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            FirebaseAnalyticsManager firebaseAnalyticsManager = FirebaseAnalyticsManager.f51235a;
                            bundle3.putString("vss", firebaseAnalyticsManager.l(firebaseAnalyticsManager.m(FirebaseAnalyticsManager.f51237c, line)));
                            return;
                        }
                        return;
                    }
                    if (!kotlin.text.l.L(line, "VmRSS", false, 2, null) || (bundle2 = bundle) == null) {
                        return;
                    }
                    FirebaseAnalyticsManager firebaseAnalyticsManager2 = FirebaseAnalyticsManager.f51235a;
                    bundle2.putString("rss", firebaseAnalyticsManager2.l(firebaseAnalyticsManager2.m(FirebaseAnalyticsManager.f51238d, line)));
                }
            }, 1, null);
        }
        firebaseAnalyticsA.logEvent(event, bundle);
    }

    public final void o(String screenName, Long l11, Context context) {
        Intrinsics.g(screenName, "screenName");
        FirebaseAnalytics firebaseAnalyticsA = pj.a.a(il.a.f67224a);
        final pj.b bVar = new pj.b();
        bVar.c("screen_name", screenName);
        bVar.c("screen_class", screenName);
        if (l11 != null) {
            bVar.b("engagement_time_msec", l11.longValue());
            FirebaseAnalyticsManager firebaseAnalyticsManager = f51235a;
            Debug.MemoryInfo memoryInfoK = firebaseAnalyticsManager.k(context);
            if (memoryInfoK != null) {
                bVar.c("max_heap", firebaseAnalyticsManager.g(Runtime.getRuntime().maxMemory()));
                bVar.c("total_heap", firebaseAnalyticsManager.g(Runtime.getRuntime().totalMemory()));
                bVar.c("free_heap", firebaseAnalyticsManager.g(Runtime.getRuntime().freeMemory()));
                bVar.c("native_pss", firebaseAnalyticsManager.l(memoryInfoK.nativePss));
                bVar.c("other_pss", firebaseAnalyticsManager.l(memoryInfoK.otherPss));
                i(firebaseAnalyticsManager, new File("/proc/self/status"), null, new Function1<String, Unit>() { // from class: com.transsion.baselib.report.FirebaseAnalyticsManager$reportScreenView$1$1$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(String str) {
                        invoke2(str);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String line) {
                        Intrinsics.g(line, "line");
                        if (kotlin.text.l.L(line, "VmSize", false, 2, null)) {
                            pj.b bVar2 = bVar;
                            FirebaseAnalyticsManager firebaseAnalyticsManager2 = FirebaseAnalyticsManager.f51235a;
                            bVar2.c("vss", firebaseAnalyticsManager2.l(firebaseAnalyticsManager2.m(FirebaseAnalyticsManager.f51237c, line)));
                        } else if (kotlin.text.l.L(line, "VmRSS", false, 2, null)) {
                            pj.b bVar3 = bVar;
                            FirebaseAnalyticsManager firebaseAnalyticsManager3 = FirebaseAnalyticsManager.f51235a;
                            bVar3.c("rss", firebaseAnalyticsManager3.l(firebaseAnalyticsManager3.m(FirebaseAnalyticsManager.f51238d, line)));
                        }
                    }
                }, 1, null);
            }
        }
        firebaseAnalyticsA.logEvent("screen_view", bVar.a());
    }

    public final void p(boolean z11) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(Utils.a());
        Intrinsics.f(firebaseAnalytics, "getInstance(Utils.getApp())");
        firebaseAnalytics.setAnalyticsCollectionEnabled(z11);
        qk.a.a(il.a.f67224a).setCrashlyticsCollectionEnabled(z11);
    }

    public final void q() {
        UserInfo userInfoP = j().P();
        String userId = userInfoP != null ? userInfoP.getUserId() : null;
        RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
        String string = roomAppMMKV.a().getString("firebase_id", "");
        if (TextUtils.isEmpty(string)) {
            if (TextUtils.isEmpty(userId)) {
                userId = TextUtils.isEmpty(userId) ? TNDeviceHelper.f49455a.g() : string;
            }
            roomAppMMKV.a().putString("firebase_id", userId);
            string = userId;
        }
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(Utils.a());
        Intrinsics.f(firebaseAnalytics, "getInstance(Utils.getApp())");
        firebaseAnalytics.setUserId(string);
        FirebaseCrashlytics firebaseCrashlyticsA = qk.a.a(il.a.f67224a);
        if (string != null) {
            firebaseCrashlyticsA.setUserId(string);
        }
    }
}
