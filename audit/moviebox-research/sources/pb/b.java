package pb;

import android.content.Context;
import android.os.Build;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.proxy.StartActivityProxy;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
import com.cloud.tmc.integration.utils.AppUtils;
import com.cloud.tmc.integration.utils.o;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.hisavana.common.constant.ComConstants;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class b implements qb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f73726a = new a(null);

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
        return "BackToAddHomeIntercept";
    }

    @Override // qb.a
    public qb.a.d b(App app, boolean z11, qb.a aVar, boolean z12) {
        return qb.a.b.a(this, app, z11, aVar, z12);
    }

    @Override // qb.a
    public qb.a.d c(qb.a.InterfaceC0816a chain) {
        long jC;
        AppNode appNodeA;
        Intrinsics.g(chain, "chain");
        TmcLogger.k("BackToAddHomeIntercept", "BackToAddHomeIntercept: " + chain.a());
        AppNode appNodeA2 = chain.a().a();
        long startTime = appNodeA2 != null ? appNodeA2.getStartTime() : 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jC = MiniAppConfigHelper.f30370a.c("miniAddHomeTime", 10000);
        } catch (Throwable th2) {
            TmcLogger.h("BackToAddHomeIntercept", th2);
            jC = 10000;
        }
        if (jCurrentTimeMillis - startTime > jC) {
            String strB = chain.a().b();
            if (strB != null && (appNodeA = chain.a().a()) != null) {
                Context contextC = chain.a().c();
                if (contextC != null) {
                    if (Build.VERSION.SDK_INT < 26) {
                        return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
                    }
                    AppUtils appUtils = AppUtils.f31011a;
                    if (appUtils.v(contextC, strB)) {
                        return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
                    }
                    if (!d(contextC, strB)) {
                        return new qb.a.d(false);
                    }
                    Class<?> launcherShortCutActivity = ((StartActivityProxy) tc.a.a(StartActivityProxy.class)).getLauncherShortCutActivity();
                    Intrinsics.f(launcherShortCutActivity, "get(StartActivityProxy::….launcherShortCutActivity");
                    o.a(contextC, launcherShortCutActivity, appNodeA, "2", (112 & 16) != 0 ? 0 : chain.a().d(), (112 & 32) != 0 ? false : true, (112 & 64) != 0);
                    e(contextC, strB);
                    return !appUtils.s(chain.a().c()) ? qb.a.b.b(this, chain.a().a(), false, this, false, 8, null) : qb.a.b.b(this, chain.a().a(), true, this, false, 8, null);
                }
            }
            return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
        }
        return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
    }

    public final boolean d(Context context, String str) {
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, "latestShowAddHomeTime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, str, "latestShowAddHomeNum");
        int iC = 5;
        try {
            iC = MiniAppConfigHelper.f30370a.c("miniAddHomeNum", 5);
        } catch (Throwable th2) {
            TmcLogger.h("BackToAddHomeIntercept", th2);
        }
        return j11 == 0 || jCurrentTimeMillis - j11 > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED || i11 <= iC;
    }

    public final void e(Context context, String str) {
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, "latestShowAddHomeTime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j11 == 0 || jCurrentTimeMillis - j11 > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, str, "latestShowAddHomeNum", 1);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, str, "latestShowAddHomeTime", jCurrentTimeMillis);
        } else {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, str, "latestShowAddHomeNum", ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, str, "latestShowAddHomeNum") + 1);
        }
    }

    @Override // qb.a
    public int getPriority() {
        return 30;
    }
}
