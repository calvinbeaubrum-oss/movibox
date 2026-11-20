package com.cloud.tupdate;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.cloud.tupdate.net.network.HttpRequestor;
import com.cloud.tupdate.net.utils.LogUtil;
import com.cloud.tupdate.utils.d;
import com.transsion.gslb.GslbSdk;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TUpdate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f32174c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy<TUpdate> f32175d = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<TUpdate>() { // from class: com.cloud.tupdate.TUpdate$Companion$get$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TUpdate invoke() {
            return new TUpdate(null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f32176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f32177b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Context a() {
            return b().b();
        }

        public final TUpdate b() {
            return (TUpdate) TUpdate.f32175d.getValue();
        }

        public final pe.b.a c(Context context) {
            Intrinsics.g(context, "context");
            return new pe.b.a(context);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class b implements GslbSdk.InitListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f32178a;

        public b(String str) {
            this.f32178a = str;
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitFail() {
            LogUtil.f32213a.c("gslb is fail");
        }

        @Override // com.transsion.gslb.GslbSdk.InitListener
        public void onInitSuccess(Map<String, String> map) {
            String domain = GslbSdk.getDomain(this.f32178a, true);
            Bundle bundle = new Bundle();
            bundle.putString("gslb_init_url", domain);
            com.cloud.tupdate.utils.b.f32235a.i("gslb_init", bundle);
        }
    }

    public TUpdate() {
    }

    public /* synthetic */ TUpdate(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Application b() {
        g();
        Application application = this.f32176a;
        Intrinsics.d(application);
        return application;
    }

    @JvmOverloads
    public final void c(Application application, boolean z11) {
        Intrinsics.g(application, "application");
        this.f32176a = application;
        e();
        com.cloud.tupdate.utils.b bVar = com.cloud.tupdate.utils.b.f32235a;
        bVar.c(this.f32176a, this.f32177b);
        d(application);
        com.cloud.tupdate.utils.a.j().d("update", "update SDK Version is 1.2.1");
        Bundle bundle = new Bundle();
        bundle.putInt("upgrade_sdk_init_status", 1);
        bVar.i("upgrade_sdk_init", bundle);
    }

    public final void d(Context context) {
        try {
            String str = this.f32177b ? "https://app-manage-api-test.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get" : "https://app-manage-api.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get";
            GslbSdk.init(context, new String[]{str}, new b(str));
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
    }

    public final TUpdate e() {
        if (this.f32176a == null) {
            return this;
        }
        try {
            HttpRequestor.Companion companion = HttpRequestor.f32183k;
            HttpRequestor httpRequestorA = companion.a();
            if (httpRequestorA != null) {
                httpRequestorA.c(this.f32177b);
            }
            HttpRequestor httpRequestorA2 = companion.a();
            if (httpRequestorA2 != null) {
                httpRequestorA2.d(d.f32241a.h());
            }
            LogUtil.f32213a.f(this.f32177b);
        } catch (Exception e11) {
            LogUtil.f32213a.d(e11);
        }
        return this;
    }

    public final TUpdate f(boolean z11) {
        this.f32177b = z11;
        if (z11) {
            com.cloud.tupdate.utils.a.j().h(z11);
        } else {
            com.cloud.tupdate.utils.a.j().h(Log.isLoggable("UPDATE", 3));
        }
        pe.a.f73738a.b(z11);
        return this;
    }

    public final void g() {
        if (this.f32176a == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 TUpdate.get().init() 初始化！");
        }
    }
}
