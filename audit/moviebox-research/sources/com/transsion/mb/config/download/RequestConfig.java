package com.transsion.mb.config.download;

import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import com.google.gson.JsonArray;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.util.networkinfo.f;
import com.transsion.mb.config.manager.ConfigMMKV;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.ServiceLoader;
import k10.d;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mu.a;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RequestConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f53101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static mu.b f53102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f53103e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f53106h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RequestConfig f53099a = new RequestConfig();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f53100b = "RequestConfig";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f53104f = LazyKt__LazyJVMKt.b(new Function0<mu.a>() { // from class: com.transsion.mb.config.download.RequestConfig$configApi$2
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f53105g = "";

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a<T1, T2> implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T1, T2> f53107a = new a<>();

        public final boolean a(int i11, Throwable th2) {
            Intrinsics.g(th2, "<anonymous parameter 1>");
            uo.b.a.f(uo.b.f78622a, RequestConfig.f53100b, "retry ing.. t1:" + i11, false, 4, null);
            return Intrinsics.b(RequestConfig.f53099a.i(), Boolean.TRUE) && i11 <= 1;
        }

        @Override // k10.d
        public /* bridge */ /* synthetic */ boolean test(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (Throwable) obj2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b extends zo.a<AppStartConfig> {
        @Override // zo.a
        public void a(String str, String str2) {
            uo.b.a.f(uo.b.f78622a, RequestConfig.f53100b, "onFailure code: " + str + "  message: " + str2, false, 4, null);
            RequestConfig.f53103e = false;
            mu.b bVar = RequestConfig.f53102d;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // zo.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(AppStartConfig appStartConfig) {
            Unit unit;
            super.c(appStartConfig);
            RequestConfig.f53101c = true;
            RequestConfig.f53103e = false;
            if (appStartConfig == null) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, RequestConfig.f53100b, "onSuccess:" + appStartConfig, false, 4, null);
            try {
                Result.Companion companion = Result.Companion;
                JsonArray items = appStartConfig.getItems();
                if (items != null) {
                    ConfigManager.f53111c.a().g(items);
                }
                String version = appStartConfig.getVersion();
                if (version != null) {
                    ConfigMMKV.f53109a.a().putString("configVersion", version);
                }
                mu.b bVar = RequestConfig.f53102d;
                if (bVar != null) {
                    bVar.b();
                    unit = Unit.f68710a;
                } else {
                    unit = null;
                }
                Result.m163constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m163constructorimpl(ResultKt.a(th2));
            }
        }
    }

    public final void f() {
        if (f53101c) {
            return;
        }
        l();
    }

    public final String g() {
        if (f53105g.length() > 0) {
            return f53105g;
        }
        if (Build.VERSION.SDK_INT <= 23) {
            f53105g = "all";
            return "all";
        }
        try {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(nu.a.class);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator it = serviceLoaderLoad.iterator();
            while (it.hasNext()) {
                linkedHashSet.addAll(((nu.a) it.next()).a());
            }
            f53105g = CollectionsKt___CollectionsKt.o0(linkedHashSet, ",", null, null, 0, null, null, 62, null);
        } catch (Exception e11) {
            uo.b.a aVar = uo.b.f78622a;
            String message = e11.getMessage();
            if (message == null) {
                message = "";
            }
            uo.b.a.j(aVar, "CombinedRequestParam", message, false, 4, null);
            e11.printStackTrace();
            f53105g = "all";
        }
        return f53105g;
    }

    public final mu.a h() {
        return (mu.a) f53104f.getValue();
    }

    public final Boolean i() {
        if (f53106h == null) {
            f53106h = Boolean.valueOf(f.f49475a.e());
        }
        return f53106h;
    }

    public final void j(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.g(network, "network");
        Intrinsics.g(networkCapabilities, "networkCapabilities");
        f53106h = Boolean.TRUE;
        f();
    }

    public final void k() {
        f53106h = Boolean.FALSE;
    }

    public final void l() {
        if (f53103e) {
            uo.b.a.f(uo.b.f78622a, f53100b, "requestConfig ing...", false, 4, null);
            return;
        }
        f53103e = true;
        f53101c = false;
        String string = ConfigMMKV.f53109a.a().getString("configVersion", "");
        h().a(cp.a.f62775a.a(), g(), string != null ? string : "").e(zo.d.f82109a.e()).u(a.f53107a).subscribe(new b());
    }

    public final void m(mu.b configLoadListener) {
        Intrinsics.g(configLoadListener, "configLoadListener");
        f53102d = configLoadListener;
    }
}
