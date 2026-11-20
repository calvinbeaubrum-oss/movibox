package k9;

import android.content.Context;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.UpdateEntity;
import com.cloud.h5update.impl.UpdateChecker;
import com.cloud.h5update.impl.UpdateParser;
import com.cloud.h5update.utils.l;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m9.c;
import m9.d;

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
public final class b implements c {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0737b f68501g = new C0737b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static UpdateEntity f68502h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f68503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f68504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map<String, String> f68505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<String, String> f68506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public m9.a f68507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f68508f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f68509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f68510b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Map<String, String> f68511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, String> f68512d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f68513e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public m9.a f68514f;

        public a(Context context) {
            Intrinsics.g(context, "context");
            this.f68509a = context;
            this.f68513e = new UpdateParser();
            this.f68514f = new UpdateChecker();
        }

        public final b a() {
            l.f28923a.q(this.f68509a, "[UpdateManager.Builder] : context == null");
            b bVar = new b(null);
            bVar.f68503a = new WeakReference(this.f68509a);
            bVar.f68504b = this.f68510b;
            bVar.f68505c = this.f68511c;
            bVar.f68506d = this.f68512d;
            bVar.f68507e = this.f68514f;
            bVar.f68508f = this.f68513e;
            return bVar;
        }

        public final void b() {
            String str;
            String str2 = this.f68510b;
            if (str2 == null || kotlin.text.l.y(str2)) {
                k9.a aVar = k9.a.f68499a;
                if (aVar.a() == 3) {
                    str = "https://api-test.byte-app.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN";
                } else {
                    str = aVar.a() == 2 ? "https://app-manage-api-static-pre.shalltry.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN" : "https://app-manage-api-static.shalltry.com/common/app-management/consumer-not-login/preloadconfig/query/getResourceByCDN";
                }
                this.f68510b = str;
            }
            a().k();
        }

        public final a c(m9.a updateChecker) {
            Intrinsics.g(updateChecker, "updateChecker");
            this.f68514f = updateChecker;
            return this;
        }
    }

    /* JADX INFO: renamed from: k9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0737b {
        public C0737b() {
        }

        public /* synthetic */ C0737b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UpdateEntity a() {
            return b.f68502h;
        }
    }

    public b() {
    }

    public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // m9.c
    public UpdateEntity a(String json) {
        Intrinsics.g(json, "json");
        d dVar = this.f68508f;
        if (dVar == null) {
            return null;
        }
        Intrinsics.d(dVar);
        f68502h = dVar.a(json);
        TH5Update.a aVar = TH5Update.f28868c;
        if (aVar.j() != null) {
            m9.b bVarJ = aVar.j();
            Intrinsics.d(bVarJ);
            if (!bVarJ.i(f68502h)) {
                return null;
            }
        }
        return f68502h;
    }

    public void i() {
        if (TextUtils.isEmpty(this.f68504b)) {
            throw new NullPointerException("[UpdateManager] : mUpdateUrl 不能为空");
        }
        m9.a aVar = this.f68507e;
        if (aVar == null) {
            return;
        }
        Intrinsics.d(aVar);
        String str = this.f68504b;
        Intrinsics.d(str);
        aVar.a(str, this.f68505c, this.f68506d, this);
    }

    public final void j() {
        m9.a aVar;
        if (l.f28923a.b()) {
            i();
            return;
        }
        String str = this.f68504b;
        if (str == null || (aVar = this.f68507e) == null) {
            return;
        }
        aVar.b(str, this);
    }

    public void k() {
        j();
    }
}
