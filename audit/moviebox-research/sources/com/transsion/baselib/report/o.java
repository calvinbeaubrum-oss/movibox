package com.transsion.baselib.report;

import android.app.Activity;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.push.bean.MsgStyle;
import com.transsion.startup.pref.consume.AppStartDotState;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f51281a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f51282b = "cold";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f51283c = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f51284d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f51285e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Uri f51286f;

    public final Uri a() {
        return f51286f;
    }

    public final String b(Uri uri) {
        if (uri == null) {
            return "launch";
        }
        return Intrinsics.b(com.transsion.baselib.helper.b.f51184a.a(uri).getUtmSource(), MsgStyle.SOURCE_PUSH) ? MsgStyle.SOURCE_PUSH : WebConstants.FIELD_DEEPLINK;
    }

    public final String c() {
        return TextUtils.isEmpty(f51284d) ? "launch" : f51284d;
    }

    public final void d(boolean z11, Activity activity) {
        Intrinsics.g(activity, "activity");
        if (z11) {
            f51282b = "warm";
            e(SystemClock.elapsedRealtime() - f51283c);
        } else {
            f51283c = SystemClock.elapsedRealtime();
            f(f51282b);
        }
    }

    public final void e(long j11) {
        HashMap map = new HashMap();
        map.put("source", f51284d);
        map.put("channel", f51285e);
        map.put("duration", String.valueOf(j11));
        m.f51277a.n("app_stop", map);
    }

    public final void f(String str) {
        f51284d = b(f51286f);
        String utmSource = com.transsion.baselib.helper.b.f51184a.a(f51286f).getUtmSource();
        if (utmSource == null) {
            utmSource = "";
        }
        f51285e = utmSource;
        f51286f = null;
        HashMap map = new HashMap();
        map.put("type", str);
        map.put("source", f51284d);
        map.put("channel", f51285e);
        m mVar = m.f51277a;
        mVar.n(AppStartDotState.APP_START, map);
        if (Intrinsics.b(f51284d, "launch")) {
            mVar.n("app_launch_channel", map);
            h(f51285e);
        }
    }

    public final void g(String shortUrl, String wholeUrl) {
        String queryParameter;
        String queryParameter2;
        Intrinsics.g(shortUrl, "shortUrl");
        Intrinsics.g(wholeUrl, "wholeUrl");
        String str = "";
        Uri uri = !Intrinsics.b(wholeUrl, "") ? Uri.parse(wholeUrl) : Uri.parse(shortUrl);
        f51284d = b(uri);
        String utmSource = com.transsion.baselib.helper.b.f51184a.a(uri).getUtmSource();
        if (utmSource == null) {
            utmSource = "";
        }
        f51285e = utmSource;
        HashMap map = new HashMap();
        map.put("source", f51284d);
        map.put("channel", f51285e);
        if (uri == null || (queryParameter = uri.getQueryParameter("msgId")) == null) {
            queryParameter = "";
        }
        map.put("msgId", queryParameter);
        if (uri != null && (queryParameter2 = uri.getQueryParameter("msg_type")) != null) {
            str = queryParameter2;
        }
        map.put("msg_type", str);
        map.put("url", wholeUrl);
        map.put("surl", shortUrl);
        m.f51277a.n("app_launch_channel", map);
        h(f51285e);
    }

    public final void h(String str) {
        try {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            roomAppMMKV.a().putString("k_last_open_channel", str);
            roomAppMMKV.a().putString("k_last_open_time", String.valueOf(System.currentTimeMillis()));
            roomAppMMKV.a().putString("k_last_open_version", com.transsion.core.utils.a.c());
        } catch (Exception unused) {
        }
    }

    public final void i(Uri uri) {
        f51286f = uri;
    }
}
