package com.tn.tranpay.report;

import android.app.Application;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ga.AthenaAnalytics;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import hq.c;
import hq.e;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f50189a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f50190b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f50191c = 3560;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static e f50192d;

    public static final void i(String category, String event, String pageName, Map map) {
        Intrinsics.g(category, "$category");
        Intrinsics.g(event, "$event");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(map, "$map");
        fq.a.f65215a.b(category + " event=" + event + "  pageName=" + pageName + " map=" + map, "Report");
        Bundle bundle = new Bundle();
        bundle.putString("page_name", pageName);
        a aVar = f50189a;
        bundle.putString("ext", aVar.d(map));
        aVar.j(event, bundle);
        aVar.b(pageName, event, map);
    }

    public final void b(String str, String str2, Map<String, String> map) {
        e eVar = f50192d;
        if (eVar != null) {
            eVar.b(str, str2, map);
        }
    }

    public final void c(Application context, String channel, boolean z11, boolean z12, e eVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(channel, "channel");
        AthenaAnalytics.F(context, channel, f50191c, true, z12);
        AthenaAnalytics.N(z11);
        f50192d = eVar;
        fq.a.f65215a.f("init athena debug " + z11, "Report");
    }

    public final String d(Map<String, String> map) {
        String string = new JSONObject(map).toString();
        Intrinsics.f(string, "JSONObject(map).toString()");
        return string;
    }

    public final void e(String pageName, String event, Map<String, String> map) {
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(event, "event");
        Intrinsics.g(map, "map");
        h("reportClick", pageName, event, map);
    }

    public final void f(c logConfig) {
        Intrinsics.g(logConfig, "logConfig");
        HashMap<String, String> mapG = logConfig.g();
        String strA = logConfig.a();
        if (strA == null) {
            strA = f50190b;
        }
        mapG.put(WebConstants.PAGE_FROM, strA);
        logConfig.g().put("duration", String.valueOf(SystemClock.elapsedRealtime() - logConfig.h()));
        logConfig.g().put("is_load_success", String.valueOf(logConfig.i()));
        String strE = logConfig.e();
        if (strE != null) {
            logConfig.g().put("ops", strE);
        }
        h("reportPT", logConfig.f(), "pt", logConfig.g());
        if (TextUtils.equals(f50190b, logConfig.f()) || !logConfig.b()) {
            return;
        }
        f50190b = logConfig.f();
    }

    public final void g(c logConfig) {
        Intrinsics.g(logConfig, "logConfig");
        HashMap<String, String> mapG = logConfig.g();
        String strA = logConfig.a();
        if (strA == null) {
            strA = f50190b;
        }
        mapG.put(WebConstants.PAGE_FROM, strA);
        String strE = logConfig.e();
        if (strE != null) {
            logConfig.g().put("ops", strE);
        }
        h("reportPV", logConfig.f(), "pv", logConfig.g());
    }

    public final void h(final String str, final String str2, final String str3, final Map<String, String> map) {
        ThreadSingleExecutor.f50186b.a().b(new Runnable() { // from class: hq.d
            @Override // java.lang.Runnable
            public final void run() {
                com.tn.tranpay.report.a.i(str, str3, str2, map);
            }
        });
    }

    public final void j(String str, Bundle bundle) {
        Bundle bundleA;
        try {
            bundle.putString(PushConstants.PROVIDER_VAID, AthenaAnalytics.w(Utils.a()));
            e eVar = f50192d;
            if (eVar != null && (bundleA = eVar.a(str, bundle)) != null) {
                bundle = bundleA;
            }
            e eVar2 = f50192d;
            Pair<Short, String> account = eVar2 != null ? eVar2.getAccount() : null;
            if (account != null) {
                AthenaAnalytics.K(account.getFirst().shortValue(), account.getSecond());
            }
            new dr.a(str, f50191c).c(bundle, null).b();
        } catch (Exception e11) {
            fq.a.f65215a.d("event " + str + " exception " + e11, "Report");
        }
    }
}
