package pb;

import android.os.Bundle;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ua.e;

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
public final class c implements qb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f73727b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f73728a = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // qb.a
    public String a() {
        return "BackToPageIntercept";
    }

    @Override // qb.a
    public qb.a.d b(App app, boolean z11, qb.a aVar, boolean z12) {
        return qb.a.b.a(this, app, z11, aVar, z12);
    }

    @Override // qb.a
    public qb.a.d c(qb.a.InterfaceC0816a chain) {
        Intrinsics.g(chain, "chain");
        TmcLogger.k("BackToPageIntercept", "BackToPageIntercept: " + chain.a());
        if (chain.a().d() == 2) {
            return chain.b(chain.a());
        }
        AppNode appNodeA = chain.a().a();
        if (appNodeA != null) {
            if (this.f73728a.length() == 0) {
                return qb.a.b.b(this, appNodeA, false, this, false, 8, null);
            }
            if (appNodeA.getStartParams().getBoolean("enableQuickMode") && !appNodeA.isAsyncLaunchStatus()) {
                appNodeA.setBackToPagePath(this.f73728a);
                e asyncStartLoadingCallback = appNodeA.getAsyncStartLoadingCallback();
                if (asyncStartLoadingCallback != null) {
                    asyncStartLoadingCallback.a();
                }
                return qb.a.b.b(this, chain.a().a(), true, this, false, 8, null);
            }
            appNodeA.putRouteType(this.f73728a, Page.SOURCE_RELAUNCH);
            String str = this.f73728a;
            Bundle startParams = appNodeA.getStartParams();
            Bundle sceneParams = appNodeA.getSceneParams();
            sceneParams.putString("navigationType", "backToPageIntercept");
            Unit unit = Unit.f68710a;
            appNodeA.relaunchToUrl(str, startParams, sceneParams);
        }
        return qb.a.b.b(this, chain.a().a(), true, this, false, 8, null);
    }

    public final void d(String str) {
        Intrinsics.g(str, "<set-?>");
        this.f73728a = str;
    }

    @Override // qb.a
    public int getPriority() {
        return 10;
    }
}
