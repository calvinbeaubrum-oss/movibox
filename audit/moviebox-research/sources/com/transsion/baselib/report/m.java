package com.transsion.baselib.report;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.thread.ThreadSingleExecutor;
import com.tn.lib.util.device.TNDeviceHelper;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f51277a = new m();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f51278b = "Report";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f51279c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n f51280d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements GslbSdk.InitListener {
        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            Intrinsics.g(map, "map");
            m.f51277a.g();
            rp.a.f75671a.a().getBoolean("", true);
        }
    }

    public static final void k(int i11, String str) {
        uo.b.a.f(uo.b.f78622a, f51278b, "loginActive:userType" + i11 + ",userid:" + str, false, 4, null);
        HashMap map = new HashMap();
        map.put("userType", String.valueOf(i11));
        if (str == null) {
            str = "0";
        }
        map.put("userId", str);
        m mVar = f51277a;
        String strL = mVar.l(map);
        Bundle bundle = new Bundle();
        bundle.putString(NotificationCompat.CATEGORY_EVENT, "login_active");
        bundle.putString("ext", strL);
        mVar.y("login_active", bundle);
    }

    public static final void o(String event, Map map) {
        Intrinsics.g(event, "$event");
        Intrinsics.g(map, "$map");
        uo.b.a.f(uo.b.f78622a, f51278b, "reportEvent() --> event = " + event + " -- map = " + map, false, 4, null);
        Bundle bundle = new Bundle();
        m mVar = f51277a;
        bundle.putString("ext", mVar.l(map));
        mVar.y(event, bundle);
    }

    public static final void q(Map map, String pageName, String event) {
        Intrinsics.g(map, "$map");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(event, "$event");
        Bundle bundle = new Bundle();
        m mVar = f51277a;
        bundle.putString("ext", mVar.l(map));
        if (!TextUtils.isEmpty(pageName)) {
            bundle.putString("page_name", pageName);
        }
        uo.b.a.f(uo.b.f78622a, f51278b + "_ad", "reportEvent() --> event = " + event + " --> bundle = " + bundle, false, 4, null);
        mVar.y(event, bundle);
    }

    public static final void v(String category, String event, String pageName, Map map) {
        Intrinsics.g(category, "$category");
        Intrinsics.g(event, "$event");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(map, "$map");
        uo.b.a.f(uo.b.f78622a, f51278b, category + " event=" + event + "  pageName=" + pageName + " map=" + map, false, 4, null);
        Bundle bundle = new Bundle();
        bundle.putString("page_name", pageName);
        m mVar = f51277a;
        bundle.putString("ext", mVar.l(map));
        mVar.y(event, bundle);
        mVar.e(pageName, event, map);
    }

    public final void e(String str, String str2, Map<String, String> map) {
        n nVar = f51280d;
        if (nVar != null) {
            nVar.b(str, str2, map);
        }
    }

    public final String f() {
        return f51279c;
    }

    public final String g() {
        return f51278b;
    }

    public final String[] h() {
        return new String[]{"dsu-a.shalltry.com"};
    }

    public final void i(Application context, boolean z11, n nVar, boolean z12) {
        Intrinsics.g(context, "context");
        boolean z13 = rp.a.f75671a.a().getBoolean("", false);
        if (z12 && !z13) {
            GslbSdk.init(context, "404", TNDeviceHelper.f49455a.g(), h(), new a());
        }
        AthenaAnalytics.O(1);
        AthenaAnalytics.F(context, "Oneroom", 2570, true, true);
        AthenaAnalytics.N(z11);
        AthenaAnalytics.t(true);
        AthenaAnalytics.M(2000);
        AthenaAnalytics.P();
        f51280d = nVar;
        uo.b.a.f(uo.b.f78622a, f51278b, "initSDK debug " + z11, false, 4, null);
    }

    public final void j(final int i11, final String str) {
        ThreadSingleExecutor.f49425b.a().b(new Runnable() { // from class: com.transsion.baselib.report.j
            @Override // java.lang.Runnable
            public final void run() {
                m.k(i11, str);
            }
        });
    }

    public final String l(Map<String, String> map) {
        Intrinsics.g(map, "map");
        String string = new JSONObject(map).toString();
        Intrinsics.f(string, "JSONObject(map).toString()");
        return string;
    }

    public final void m(String pageName, String event, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        u("reportClick", pageName, event, map);
    }

    public final void n(final String event, final Map<String, String> map) {
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        ThreadSingleExecutor.f49425b.a().b(new Runnable() { // from class: com.transsion.baselib.report.l
            @Override // java.lang.Runnable
            public final void run() {
                m.o(event, map);
            }
        });
    }

    public final void p(final String event, final Map<String, String> map, final String pageName) {
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        Intrinsics.g(pageName, "pageName");
        ThreadSingleExecutor.f49425b.a().b(new Runnable() { // from class: com.transsion.baselib.report.k
            @Override // java.lang.Runnable
            public final void run() {
                m.q(map, pageName, event);
            }
        });
    }

    public final void r(h logConfig) {
        Intrinsics.g(logConfig, "logConfig");
        HashMap<String, String> mapG = logConfig.g();
        String strA = logConfig.a();
        if (strA == null) {
            strA = f51279c;
        }
        mapG.put(WebConstants.PAGE_FROM, strA);
        logConfig.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - logConfig.h()));
        logConfig.g().put("is_load_success", String.valueOf(logConfig.i()));
        String strE = logConfig.e();
        if (strE != null) {
            logConfig.g().put("ops", strE);
        }
        u("reportPT", logConfig.f(), "pt", logConfig.g());
        if (TextUtils.equals(f51279c, logConfig.f()) || !logConfig.b()) {
            return;
        }
        f51279c = logConfig.f();
    }

    public final void s(h logConfig) {
        Intrinsics.g(logConfig, "logConfig");
        HashMap<String, String> mapG = logConfig.g();
        String strA = logConfig.a();
        if (strA == null) {
            strA = f51279c;
        }
        mapG.put(WebConstants.PAGE_FROM, strA);
        String strE = logConfig.e();
        if (strE != null) {
            logConfig.g().put("ops", strE);
        }
        u("reportPV", logConfig.f(), "pv", logConfig.g());
    }

    public final void t(String pageName, String event, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        u("reportShow", pageName, event, map);
    }

    public final void u(final String str, final String str2, final String str3, final Map<String, String> map) {
        ThreadSingleExecutor.f49425b.a().b(new Runnable() { // from class: com.transsion.baselib.report.i
            @Override // java.lang.Runnable
            public final void run() {
                m.v(str, str3, str2, map);
            }
        });
    }

    public final void w(String pageName, String event, long j11, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        map.put("duration", String.valueOf(j11));
        u("reportUseTime", pageName, event, map);
    }

    public final void x(String lastPageName) {
        Intrinsics.g(lastPageName, "lastPageName");
        f51279c = lastPageName;
    }

    public final void y(String str, Bundle bundle) {
        Bundle bundleA;
        try {
            bundle.putString(PushConstants.PROVIDER_VAID, AthenaAnalytics.w(Utils.a()));
            n nVar = f51280d;
            if (nVar != null && (bundleA = nVar.a(str, bundle)) != null) {
                bundle = bundleA;
            }
            n nVar2 = f51280d;
            Pair<Short, String> account = nVar2 != null ? nVar2.getAccount() : null;
            if (account != null) {
                AthenaAnalytics.K(account.getFirst().shortValue(), account.getSecond());
            }
            new dr.a(str).c(bundle, null).b();
        } catch (Exception e11) {
            uo.b.f78622a.h("report", "event " + str + " exception " + e11, true);
        }
    }
}
