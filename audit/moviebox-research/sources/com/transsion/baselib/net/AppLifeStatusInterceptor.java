package com.transsion.baselib.net;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

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
public final class AppLifeStatusInterceptor implements Interceptor {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f51216d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f51217a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51218b = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.baselib.net.AppLifeStatusInterceptor$handler$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f51219c;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b implements RoomActivityLifecycleCallbacks.a {
        public b() {
        }

        @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
        public void onBackgroundStatusChange(boolean z11) {
            if (z11) {
                return;
            }
            RoomAppMMKV.f51271a.a().putLong("record_latest_foreground_time", System.currentTimeMillis());
            c.f51224a.b().set(true);
            AppLifeStatusInterceptor.this.f();
        }
    }

    public AppLifeStatusInterceptor() {
        HashSet<String> hashSet = new HashSet<>();
        this.f51219c = hashSet;
        hashSet.add("/wefeed-mobile-bff/message/push/local/list");
        hashSet.add("/wefeed-mobile-bff/subject-api/get-ext-captions");
        hashSet.add("/wefeed-mobile-bff/app/config");
        c();
    }

    public static final void e() {
        com.alibaba.android.arouter.launcher.a.d().b("/main/page_not_available").navigation();
    }

    public final void c() {
        RoomActivityLifecycleCallbacks.f51239a.b(new b());
    }

    public final Handler d() {
        return (Handler) this.f51218b.getValue();
    }

    public final void f() {
        if (this.f51217a.get()) {
            this.f51217a.set(false);
            j.d(l0.a(w0.b()), null, null, new AppLifeStatusInterceptor$requestForBackToForeground$1(null), 3, null);
        }
    }

    public final boolean g(Interceptor.Chain chain) {
        RoomActivityLifecycleCallbacks roomActivityLifecycleCallbacks = RoomActivityLifecycleCallbacks.f51239a;
        if (!roomActivityLifecycleCallbacks.i() || ((!roomActivityLifecycleCallbacks.l() && c.f51224a.b().get()) || roomActivityLifecycleCallbacks.j())) {
            return false;
        }
        String path = Uri.parse(chain.request().url().toString()).getPath();
        if (!roomActivityLifecycleCallbacks.l() && CollectionsKt___CollectionsKt.X(this.f51219c, path)) {
            return false;
        }
        this.f51217a.set(true);
        return true;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.g(chain, "chain");
        Request request = chain.request();
        if (!g(chain)) {
            Response responseProceed = chain.proceed(request);
            if (responseProceed.code() == 403 && !RoomActivityLifecycleCallbacks.f51239a.i()) {
                d().post(new Runnable() { // from class: com.transsion.baselib.net.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        AppLifeStatusInterceptor.e();
                    }
                });
            }
            return responseProceed;
        }
        uo.b.f78622a.n("HttpTag", new String[]{"AppLifeStatusInterceptor response " + ((Object) null) + " : " + request.url() + " is Background request cancel "}, true);
        throw new IOException("is Background request cancel");
    }
}
