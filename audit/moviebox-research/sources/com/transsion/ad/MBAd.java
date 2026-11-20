package com.transsion.ad;

import com.transsion.ad.strategy.AppManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import vq.c;

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
public final class MBAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MBAd f50258a = new MBAd();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f50259b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f50260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f50261b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f50262c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AppManager.AppEnum f50263d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f50264e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f50265f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c f50266g;

        public a(String hisavanaAppId, boolean z11, boolean z12, AppManager.AppEnum appEnum, String hotSceneId, String adConfigUrl, c reportCallback) {
            Intrinsics.g(hisavanaAppId, "hisavanaAppId");
            Intrinsics.g(appEnum, "appEnum");
            Intrinsics.g(hotSceneId, "hotSceneId");
            Intrinsics.g(adConfigUrl, "adConfigUrl");
            Intrinsics.g(reportCallback, "reportCallback");
            this.f50260a = hisavanaAppId;
            this.f50261b = z11;
            this.f50262c = z12;
            this.f50263d = appEnum;
            this.f50264e = hotSceneId;
            this.f50265f = adConfigUrl;
            this.f50266g = reportCallback;
        }

        public final String a() {
            return this.f50265f;
        }

        public final boolean b() {
            return this.f50261b;
        }

        public final AppManager.AppEnum c() {
            return this.f50263d;
        }

        public final String d() {
            return this.f50260a;
        }

        public final String e() {
            return this.f50264e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f50260a, aVar.f50260a) && this.f50261b == aVar.f50261b && this.f50262c == aVar.f50262c && this.f50263d == aVar.f50263d && Intrinsics.b(this.f50264e, aVar.f50264e) && Intrinsics.b(this.f50265f, aVar.f50265f) && Intrinsics.b(this.f50266g, aVar.f50266g);
        }

        public final c f() {
            return this.f50266g;
        }

        public final boolean g() {
            return this.f50262c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iHashCode = this.f50260a.hashCode() * 31;
            boolean z11 = this.f50261b;
            ?? r11 = z11;
            if (z11) {
                r11 = 1;
            }
            int i11 = (iHashCode + r11) * 31;
            boolean z12 = this.f50262c;
            return ((((((((i11 + (z12 ? 1 : z12)) * 31) + this.f50263d.hashCode()) * 31) + this.f50264e.hashCode()) * 31) + this.f50265f.hashCode()) * 31) + this.f50266g.hashCode();
        }

        public String toString() {
            return "AdInitParams(hisavanaAppId=" + this.f50260a + ", adTestDevice=" + this.f50261b + ", isDebug=" + this.f50262c + ", appEnum=" + this.f50263d + ", hotSceneId=" + this.f50264e + ", adConfigUrl=" + this.f50265f + ", reportCallback=" + this.f50266g + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f50268b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f50269c;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f50272f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f50267a = "";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public AppManager.AppEnum f50270d = AppManager.AppEnum.APP_MOVIE_BOX;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f50271e = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f50273g = "";

        public final a a() {
            if (this.f50267a.length() == 0) {
                throw new IllegalArgumentException("HiSavana App ID must not be empty");
            }
            if (this.f50273g.length() == 0) {
                throw new IllegalArgumentException("AdConfigUrl must not be empty");
            }
            String str = this.f50267a;
            boolean z11 = this.f50268b;
            boolean z12 = this.f50269c;
            AppManager.AppEnum appEnum = this.f50270d;
            String str2 = this.f50271e;
            String str3 = this.f50273g;
            c cVar = this.f50272f;
            if (cVar != null) {
                return new a(str, z11, z12, appEnum, str2, str3, cVar);
            }
            throw new IllegalArgumentException("ReportCallback must not be null");
        }

        public final b b(String adConfigUrl) {
            Intrinsics.g(adConfigUrl, "adConfigUrl");
            this.f50273g = adConfigUrl;
            return this;
        }

        public final b c(boolean z11) {
            this.f50268b = z11;
            return this;
        }

        public final b d(AppManager.AppEnum appEnum) {
            Intrinsics.g(appEnum, "appEnum");
            this.f50270d = appEnum;
            return this;
        }

        public final b e(String hisavanaAppId) {
            Intrinsics.g(hisavanaAppId, "hisavanaAppId");
            this.f50267a = hisavanaAppId;
            return this;
        }

        public final b f(String hotSceneId) {
            Intrinsics.g(hotSceneId, "hotSceneId");
            this.f50271e = hotSceneId;
            return this;
        }

        public final b g(boolean z11) {
            this.f50269c = z11;
            return this;
        }

        public final b h(c reportCallback) {
            Intrinsics.g(reportCallback, "reportCallback");
            this.f50272f = reportCallback;
            return this;
        }
    }

    public final a b() {
        return f50259b;
    }

    public final String c() {
        String simpleName = MBAd.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Object d(a aVar, Continuation<? super Unit> continuation) {
        f50259b = aVar;
        Object objG = h.g(w0.b(), new MBAd$initAd$2(aVar, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }

    public final Object e(String str, Continuation<? super Unit> continuation) {
        Object objG = h.g(w0.b(), new MBAd$initNonAd$2(str, null), continuation);
        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
    }
}
