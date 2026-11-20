package com.cloud.h5update;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.cloud.h5update.bean.PreloadResource;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.download.DownloadManager;
import com.cloud.h5update.utils.j;
import com.cloud.h5update.utils.l;
import com.tmc.network.HttpRequestor;
import com.transsion.api.gateway.config.WorkMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import m9.b;

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
public final class TH5Update {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f28869d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f28871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static volatile boolean f28872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f28873h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f28875j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static b f28876k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f28878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f28879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f28868c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f28870e = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ConcurrentHashMap<String, Boolean> f28874i = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<TH5Update> f28877l = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<TH5Update>() { // from class: com.cloud.h5update.TH5Update$Companion$get$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TH5Update invoke() {
            return new TH5Update(null);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void m(a aVar, String str, String str2, int i11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                str2 = "";
            }
            if ((i12 & 4) != 0) {
                i11 = 0;
            }
            aVar.l(str, str2, i11);
        }

        public final void a() {
            List<PreloadResource> preloadResource;
            k9.b.C0737b c0737b = k9.b.f68501g;
            if (c0737b.a() == null) {
                return;
            }
            UpdateEntity updateEntityA = c0737b.a();
            if (updateEntityA != null && (preloadResource = updateEntityA.getPreloadResource()) != null) {
                Iterator<T> it = preloadResource.iterator();
                while (it.hasNext()) {
                    if (!TH5Update.f28868c.i().contains(((PreloadResource) it.next()).getStaticZipUrl())) {
                        return;
                    }
                }
            }
            j jVar = j.f28918a;
            UpdateEntity updateEntityA2 = k9.b.f68501g.a();
            Long version = updateEntityA2 != null ? updateEntityA2.getVersion() : null;
            Intrinsics.d(version);
            jVar.g("last_update_version", version.longValue());
        }

        public final void b(UpdateEntity updateEntity) {
            Intrinsics.g(updateEntity, "updateEntity");
            j jVar = j.f28918a;
            long jC = jVar.c("last_update_version", 0L);
            Long version = updateEntity.getVersion();
            if (version != null && jC == version.longValue()) {
                jVar.i("last_update_version");
            }
            List<PreloadResource> preloadResource = updateEntity.getPreloadResource();
            if (preloadResource != null) {
                for (PreloadResource preloadResource2 : preloadResource) {
                    TypeIntrinsics.d(TH5Update.f28868c.i()).remove(preloadResource2.getStaticZipUrl());
                    j.f28918a.i("last_update_url_version" + preloadResource2.getStaticZipUrl());
                }
            }
        }

        public final Context c() {
            return d().l();
        }

        public final TH5Update d() {
            return (TH5Update) TH5Update.f28877l.getValue();
        }

        public final String e() {
            return TH5Update.f28869d;
        }

        public final String f() {
            return TH5Update.f28875j;
        }

        public final boolean g() {
            return TH5Update.f28873h;
        }

        public final boolean h() {
            return TH5Update.f28872g;
        }

        public final ConcurrentHashMap<String, Boolean> i() {
            return TH5Update.f28874i;
        }

        public final b j() {
            return TH5Update.f28876k;
        }

        public final k9.b.a k(Context context) {
            Intrinsics.g(context, "context");
            return new k9.b.a(context);
        }

        public final void l(String appName, String versionName, int i11) {
            Intrinsics.g(appName, "appName");
            Intrinsics.g(versionName, "versionName");
            n(appName);
            HttpRequestor companion = HttpRequestor.Companion.getInstance();
            if (companion != null) {
                String strE = e();
                Intrinsics.d(strE);
                companion.setAppInfo(strE, versionName, i11);
            }
        }

        public final void n(String str) {
            TH5Update.f28869d = str;
        }

        public final void o(String str) {
            TH5Update.f28875j = str;
        }

        public final void p(boolean z11) {
            TH5Update.f28872g = z11;
        }

        public final void q(b bVar) {
            TH5Update.f28876k = bVar;
        }

        public final void r(b bVar) {
            q(bVar);
        }
    }

    public TH5Update() {
        this.f28879b = 1;
    }

    public /* synthetic */ TH5Update(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ TH5Update q(TH5Update tH5Update, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "Lp84tK50u1uwuN3zNQ";
        }
        return tH5Update.p(str);
    }

    public final Application l() {
        s();
        Application application = this.f28878a;
        Intrinsics.d(application);
        return application;
    }

    public final String m(Resources resources) {
        try {
            Locale locale = Build.VERSION.SDK_INT >= 24 ? resources.getConfiguration().getLocales().get(0) : resources.getConfiguration().locale;
            Intrinsics.d(locale);
            String language = locale.getLanguage();
            Intrinsics.f(language, "{\n            val locale…cale!!.language\n        }");
            return language;
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
            return "";
        }
    }

    @JvmOverloads
    public final void n(Application application, boolean z11, String str, String str2, boolean z12, String versionName, int i11) {
        Intrinsics.g(application, "application");
        Intrinsics.g(versionName, "versionName");
        this.f28878a = application;
        f28869d = str;
        f28870e = versionName;
        f28871f = i11;
        f28873h = z12;
        j jVar = j.f28918a;
        Context applicationContext = application.getApplicationContext();
        Intrinsics.f(applicationContext, "application.applicationContext");
        jVar.f(applicationContext);
        DownloadManager.k(DownloadManager.f28882g.a(), application, 0, 2, null);
        if (z11) {
            q(this, null, 1, null);
        }
        if (str2 == null) {
            str2 = l.f28923a.f();
        }
        f28875j = str2;
    }

    public final TH5Update p(String str) {
        if (this.f28878a == null) {
            return this;
        }
        try {
            HttpRequestor.Companion companion = HttpRequestor.Companion;
            HttpRequestor companion2 = companion.getInstance();
            if (companion2 != null) {
                HttpRequestor.init$default(companion2, this.f28878a, str, this.f28879b == 3 ? WorkMode.MODE_TEST : WorkMode.MODE_ONLINE, null, 8, null);
            }
            HttpRequestor companion3 = companion.getInstance();
            if (companion3 != null) {
                Application application = this.f28878a;
                Intrinsics.d(application);
                Resources resources = application.getResources();
                Intrinsics.f(resources, "mApplication!!.resources");
                companion3.setLanguage(m(resources));
            }
            if (TextUtils.isEmpty(f28869d)) {
                Application application2 = this.f28878a;
                f28869d = application2 != null ? application2.getPackageName() : null;
            }
            HttpRequestor companion4 = companion.getInstance();
            if (companion4 != null) {
                String str2 = f28869d;
                Intrinsics.d(str2);
                companion4.setAppInfo(str2, f28870e, f28871f);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("api.sunnbird.com");
            arrayList.add("api.test.sunnbird.com");
            arrayList.add("api.pre.sunnbird.com");
            ArrayList arrayList2 = new ArrayList();
            HttpRequestor companion5 = companion.getInstance();
            if (companion5 != null) {
                companion5.setGateWayActivateSignConfig(arrayList, TypeIntrinsics.c(arrayList2));
            }
            po.b.f73956a.h(this.f28879b == 3);
        } catch (Exception e11) {
            po.b.f73956a.e(e11);
        }
        return this;
    }

    public final TH5Update r(int i11) {
        this.f28879b = i11;
        k9.a.f68499a.b(i11);
        return this;
    }

    public final void s() {
        if (this.f28878a == null) {
            throw new ExceptionInInitializerError("请先在全局Application中调用 TUpdate.get().init() 初始化！");
        }
    }
}
