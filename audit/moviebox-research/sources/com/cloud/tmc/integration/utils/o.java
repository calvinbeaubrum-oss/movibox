package com.cloud.tmc.integration.utils;

import android.content.Context;
import android.os.Bundle;
import com.cloud.tmc.integration.model.MiniAddHomeModel;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f31082a = new o();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, App> f31083b = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<String> f31084c = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f31085d = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, MiniAddHomeModel> f31086e = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f31087f = "1000886706715795456";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f31088g = "1000497027976413184";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f31089h = "miniapp_";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void onFail();

        void onSuccess(String str);
    }

    @JvmStatic
    @JvmOverloads
    public static final void a(Context context, Class<?> scClass, App app, String fromLocation, int i11, boolean z11, boolean z12) {
        Intrinsics.g(context, "context");
        Intrinsics.g(scClass, "scClass");
        Intrinsics.g(app, "app");
        Intrinsics.g(fromLocation, "fromLocation");
    }

    public final CopyOnWriteArrayList<String> c() {
        return f31084c;
    }

    public final ConcurrentHashMap<String, MiniAddHomeModel> d() {
        return f31086e;
    }

    public final boolean e(Context context, String str) {
        Intrinsics.g(context, "context");
        if (str == null || str.length() == 0) {
            return false;
        }
        if (!AppUtils.f31011a.s(context)) {
            return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, str, "showAddHome", false);
        }
        return ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniKeyStorageAddHome", "addHomeStatus_" + str, false);
    }

    public final ConcurrentHashMap<String, App> f() {
        return f31083b;
    }

    public final String g() {
        return f31089h;
    }

    public final void h(String str, int i11, String desc) {
        Intrinsics.g(desc, "desc");
        PerformanceAnalyseProxy performanceAnalyseProxy = (PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class);
        PointAnalyseType pointAnalyseType = PointAnalyseType.ADD_MINI_APP_TO_DESKTOP;
        Bundle bundle = new Bundle();
        bundle.putInt("add_mini_app_to_desktop_status", i11);
        bundle.putString("add_mini_app_to_desktop_desc", desc);
        Unit unit = Unit.f68710a;
        performanceAnalyseProxy.record(str, pointAnalyseType, "", bundle);
    }

    public final boolean i(Context context, String logoUrl, a aVar) {
        Intrinsics.g(context, "context");
        Intrinsics.g(logoUrl, "logoUrl");
        return false;
    }
}
