package pe;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.cloud.tupdate.bean.SdkConfigInfo;
import com.cloud.tupdate.bean.UpdateEntity;
import com.cloud.tupdate.dialog.DialogPosition;
import com.cloud.tupdate.impl.UpdateParser;
import com.cloud.tupdate.net.network.HttpRequestor;
import com.cloud.tupdate.net.utils.LogUtil;
import com.cloud.tupdate.utils.d;
import com.cloud.tupdate.utils.w;
import com.transsion.gslb.GslbSdk;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import te.c;
import te.e;
import te.f;
import te.g;

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
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UpdateEntity f73744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference<Context> f73745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f73746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f73747d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, String> f73748e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f73749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f73750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g f73751h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f73752i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public DialogPosition f73753j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f73754k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f73755l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f73756m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f73757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f73758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f73759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f73760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public f f73761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f73762f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public g f73763g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f73764h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f73765i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f73766j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f73767k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public DialogPosition f73768l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f73769m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f73770n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f73771o;

        /* JADX INFO: renamed from: pe.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0803a implements qe.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f73772a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f73773b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ te.a f73774c;

            public C0803a(long j11, a aVar, te.a aVar2) {
                this.f73772a = j11;
                this.f73773b = aVar;
                this.f73774c = aVar2;
            }

            @Override // qe.b
            public void a(int i11, String str) {
                com.cloud.tupdate.utils.a.j().b("update", "sdk config --> manualCheck  code = " + i11 + "  message = " + ((Object) str));
                this.f73773b.e(this.f73774c);
            }

            @Override // qe.b
            public void b(SdkConfigInfo sdkConfigInfo) {
                if (sdkConfigInfo == null) {
                    this.f73773b.e(this.f73774c);
                    return;
                }
                com.cloud.tupdate.utils.a.j().d("update", "sdk config --> manualCheck sdkConfigInfo " + sdkConfigInfo + " ,time =  " + (System.currentTimeMillis() - this.f73772a));
                if (sdkConfigInfo.getOpenSdkCache() == null) {
                    this.f73773b.e(this.f73774c);
                    return;
                }
                if (sdkConfigInfo.getOpenSdkCache().booleanValue()) {
                    this.f73773b.e(this.f73774c);
                    return;
                }
                String closeVersions = sdkConfigInfo.getCloseVersions();
                com.cloud.tupdate.utils.a.j().d("update", "sdk config --> manualCheck closeVersion = " + ((Object) closeVersions) + " , current code = 1210");
                if (TextUtils.isEmpty(closeVersions)) {
                    return;
                }
                Intrinsics.d(closeVersions);
                if (StringsKt__StringsKt.Q(closeVersions, "1210", false, 2, null)) {
                    return;
                }
                this.f73773b.e(this.f73774c);
            }
        }

        /* JADX INFO: renamed from: pe.b$a$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0804b implements qe.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f73775a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f73776b;

            public C0804b(long j11, a aVar) {
                this.f73775a = j11;
                this.f73776b = aVar;
            }

            @Override // qe.b
            public void a(int i11, String str) {
                com.cloud.tupdate.utils.a.j().b("update", "sdk config --> update  code = " + i11 + "  message = " + ((Object) str));
                this.f73776b.h();
            }

            @Override // qe.b
            public void b(SdkConfigInfo sdkConfigInfo) {
                if (sdkConfigInfo == null) {
                    this.f73776b.h();
                    return;
                }
                com.cloud.tupdate.utils.a.j().d("update", "sdk config --> update sdkConfigInfo " + sdkConfigInfo + " ,time =  " + (System.currentTimeMillis() - this.f73775a));
                if (sdkConfigInfo.getOpenSdkCache() == null) {
                    this.f73776b.h();
                    return;
                }
                if (sdkConfigInfo.getOpenSdkCache().booleanValue()) {
                    this.f73776b.h();
                    return;
                }
                String closeVersions = sdkConfigInfo.getCloseVersions();
                com.cloud.tupdate.utils.a.j().d("update", "sdk config --> update closeVersion = " + ((Object) closeVersions) + " , current code = 1210");
                if (TextUtils.isEmpty(closeVersions)) {
                    return;
                }
                Intrinsics.d(closeVersions);
                if (StringsKt__StringsKt.Q(closeVersions, "1210", false, 2, null)) {
                    return;
                }
                this.f73776b.h();
            }
        }

        public a(Context context) {
            Intrinsics.g(context, "context");
            this.f73757a = context;
            this.f73761e = new UpdateParser();
            this.f73762f = new se.e();
            this.f73763g = new se.g();
            this.f73768l = DialogPosition.MIDDLE;
            this.f73771o = "";
        }

        public final b c() {
            w.f32268a.n(this.f73757a, "[UpdateManager.Builder] : context == null");
            b bVar = new b(null);
            bVar.f73745b = new WeakReference(this.f73757a);
            bVar.f73746c = this.f73758b;
            bVar.f73747d = this.f73759c;
            bVar.f73748e = this.f73760d;
            bVar.f73752i = this.f73767k;
            bVar.f73753j = this.f73768l;
            bVar.f73754k = this.f73769m;
            bVar.f73755l = this.f73770n;
            bVar.f73749f = this.f73762f;
            bVar.f73750g = this.f73761e;
            bVar.f73751h = this.f73763g;
            bVar.getClass();
            bVar.getClass();
            bVar.f73756m = this.f73771o;
            return bVar;
        }

        public final void d(te.a aVar) {
            try {
                qe.a.f74555a.a(this.f73757a).d(new C0803a(System.currentTimeMillis(), this, aVar));
            } catch (Exception e11) {
                com.cloud.tupdate.utils.a.j().a(Log.getStackTraceString(e11));
            }
        }

        public final void e(te.a aVar) {
            HttpRequestor httpRequestorA;
            String str;
            String str2 = this.f73758b;
            if (str2 == null || l.y(str2)) {
                String str3 = pe.a.f73738a.a() ? "https://app-manage-api-test.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get" : "https://app-manage-api.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get";
                try {
                    String domain = GslbSdk.getDomain(str3, true);
                    if (domain == null || l.y(domain)) {
                        this.f73758b = str3;
                    } else {
                        this.f73758b = domain;
                    }
                } catch (Exception e11) {
                    this.f73758b = str3;
                    LogUtil.f32213a.d(e11);
                }
            }
            String str4 = this.f73764h;
            if ((str4 == null || l.y(str4) || (str = this.f73765i) == null || l.y(str) || this.f73766j == 0) && (httpRequestorA = HttpRequestor.f32183k.a()) != null) {
                String packageName = this.f73757a.getPackageName();
                Intrinsics.f(packageName, "context.packageName");
                d dVar = d.f32241a;
                httpRequestorA.b(packageName, dVar.j(this.f73757a), dVar.i(this.f73757a));
            }
            c().A(aVar);
        }

        public final a f(String whiteListId) {
            Intrinsics.g(whiteListId, "whiteListId");
            this.f73771o = whiteListId;
            return this;
        }

        public final void g() {
            try {
                qe.a.f74555a.a(this.f73757a).d(new C0804b(System.currentTimeMillis(), this));
            } catch (Exception e11) {
                com.cloud.tupdate.utils.a.j().a(Log.getStackTraceString(e11));
            }
        }

        public final void h() {
            HttpRequestor httpRequestorA;
            String str;
            String str2 = this.f73758b;
            if (str2 == null || l.y(str2)) {
                String str3 = pe.a.f73738a.a() ? "https://app-manage-api-test.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get" : "https://app-manage-api.shalltry.com/common/app-management/v1/consumer-not-login/versioncontent/query/get";
                try {
                    String domain = GslbSdk.getDomain(str3, true);
                    if (domain == null || l.y(domain)) {
                        this.f73758b = str3;
                    } else {
                        this.f73758b = domain;
                    }
                } catch (Exception e11) {
                    this.f73758b = str3;
                    LogUtil.f32213a.d(e11);
                }
            }
            String str4 = this.f73764h;
            if ((str4 == null || l.y(str4) || (str = this.f73765i) == null || l.y(str) || this.f73766j == 0) && (httpRequestorA = HttpRequestor.f32183k.a()) != null) {
                String packageName = this.f73757a.getPackageName();
                Intrinsics.f(packageName, "context.packageName");
                d dVar = d.f32241a;
                httpRequestorA.b(packageName, dVar.j(this.f73757a), dVar.i(this.f73757a));
            }
            c().C();
        }
    }

    public b() {
        this.f73753j = DialogPosition.MIDDLE;
        this.f73756m = "";
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public void A(te.a aVar) {
        B(aVar, true);
    }

    public void B(te.a aVar, boolean z11) {
        if (TextUtils.isEmpty(this.f73746c)) {
            throw new NullPointerException("[UpdateManager] : mUpdateUrl 不能为空");
        }
        c cVar = this.f73749f;
        if (cVar == null || cVar == null) {
            return;
        }
        String str = this.f73746c;
        Intrinsics.d(str);
        cVar.b(str, this.f73747d, this.f73748e, this, aVar, z11);
    }

    public void C() {
        z();
    }

    @Override // te.e
    public UpdateEntity a(String json) {
        Intrinsics.g(json, "json");
        f fVar = this.f73750g;
        if (fVar == null) {
            return null;
        }
        UpdateEntity updateEntityA = fVar != null ? fVar.a(json) : null;
        this.f73744a = updateEntityA;
        return updateEntityA;
    }

    @Override // te.e
    public float b() {
        return this.f73754k;
    }

    @Override // te.e
    public boolean c() {
        return this.f73755l;
    }

    @Override // te.e
    public te.d d() {
        return null;
    }

    @Override // te.e
    public String e() {
        return this.f73756m;
    }

    @Override // te.e
    public DialogPosition f() {
        return this.f73753j;
    }

    @Override // te.e
    public te.b g() {
        return null;
    }

    @Override // te.e
    public Context getContext() {
        WeakReference<Context> weakReference = this.f73745b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // te.e
    public boolean h() {
        return this.f73752i;
    }

    @Override // te.e
    public void i(UpdateEntity updateEntity, e updateManager) {
        Intrinsics.g(updateEntity, "updateEntity");
        Intrinsics.g(updateManager, "updateManager");
        g gVar = this.f73751h;
        if (gVar == null) {
            return;
        }
        gVar.a(updateEntity, updateManager);
    }

    @Override // te.e
    public void j(UpdateEntity updateEntity, e updateManager, boolean z11) {
        Intrinsics.g(updateEntity, "updateEntity");
        Intrinsics.g(updateManager, "updateManager");
        g gVar = this.f73751h;
        if (gVar == null) {
            return;
        }
        gVar.b(updateEntity, updateManager, z11);
    }

    public void y() {
        if (TextUtils.isEmpty(this.f73746c)) {
            throw new NullPointerException("[UpdateManager] : mUpdateUrl 不能为空");
        }
        c cVar = this.f73749f;
        if (cVar == null || cVar == null) {
            return;
        }
        String str = this.f73746c;
        Intrinsics.d(str);
        cVar.a(str, this.f73747d, this.f73748e, this);
    }

    public final void z() {
        if (w.f32268a.a()) {
            y();
        }
    }
}
