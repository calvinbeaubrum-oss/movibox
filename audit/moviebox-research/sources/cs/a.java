package cs;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.cloud.tmc.miniapp.ByteAppManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uo.b;

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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f62808a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f62809b;

    public final void a(Application app) {
        Intrinsics.g(app, "app");
        ByteAppManager.init(app);
    }

    public final void b(Context context, String miniappDeeplink) {
        Intrinsics.g(context, "context");
        Intrinsics.g(miniappDeeplink, "miniappDeeplink");
        b.f78622a.c("launchMiniAppDeeplink", "Deeplink is mini app, " + miniappDeeplink, false);
        ByteAppManager.launchMiniAppDeeplink(context, miniappDeeplink);
    }

    public final void c(Activity activity, String appId, String sceneId) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(appId, "appId");
        Intrinsics.g(sceneId, "sceneId");
        b.a.f(b.f78622a, "MiniAppSDK", "launchMiniAppForId, appId:" + appId + ", sceneId:" + sceneId, false, 4, null);
        ByteAppManager.launchMiniAppForId(activity, appId, sceneId);
    }

    public final void d(Context context) {
        Intrinsics.g(context, "context");
        if (f62809b) {
            return;
        }
        f62809b = true;
        ByteAppManager.warmupMiniapp(context);
    }
}
