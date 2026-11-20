package pb;

import android.content.Context;
import com.cloud.tmc.integration.MiniAppConfigHelper;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.AppNode;
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
public final class a implements qb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0800a f73724b = new C0800a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public bc.a f73725a;

    /* JADX INFO: renamed from: pb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0800a {
        public C0800a() {
        }

        public /* synthetic */ C0800a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // qb.a
    public String a() {
        return "BackExitIntercept";
    }

    @Override // qb.a
    public qb.a.d b(App app, boolean z11, qb.a aVar, boolean z12) {
        return qb.a.b.a(this, app, z11, aVar, z12);
    }

    @Override // qb.a
    public qb.a.d c(qb.a.InterfaceC0816a chain) {
        long jC;
        Intrinsics.g(chain, "chain");
        TmcLogger.k("BackExitIntercept", "BackExitIntercept: " + chain.a());
        AppNode appNodeA = chain.a().a();
        long startTime = appNodeA != null ? appNodeA.getStartTime() : 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            jC = MiniAppConfigHelper.f30370a.c("miniBackInterceptorTime", 10000);
        } catch (Throwable th2) {
            TmcLogger.h("BackExitIntercept", th2);
            jC = 10000;
        }
        if (jCurrentTimeMillis - startTime > jC) {
            String strB = chain.a().b();
            if (strB == null) {
                return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
            }
            Context contextC = chain.a().c();
            if (contextC != null) {
                if (!d(contextC, strB)) {
                    TmcLogger.c("BackExitIntercept", "back intercept count overrun");
                    return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
                }
                if (!e(contextC, strB)) {
                    TmcLogger.c("BackExitIntercept", "back intercept time interval not allowed");
                    return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
                }
                bc.a aVar = this.f73725a;
                if (aVar != null) {
                    aVar.g();
                    g(contextC, strB);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("back intercept, ");
                sb2.append(this.f73725a != null);
                TmcLogger.c("BackExitIntercept", sb2.toString());
                return qb.a.b.b(this, chain.a().a(), this.f73725a != null, this, false, 8, null);
            }
        }
        TmcLogger.c("BackExitIntercept", "back intercept, " + (jC / ((long) 1000)) + "s 内不生效拦截器");
        return qb.a.b.b(this, chain.a().a(), false, this, false, 8, null);
    }

    public final boolean d(Context context, String str) {
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, "latestCheckBackInterceptorTime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, str, "latestCheckBackInterceptorNum");
        int iC = 5;
        try {
            iC = MiniAppConfigHelper.f30370a.c("miniBackInterceptorNum", 5);
        } catch (Throwable th2) {
            TmcLogger.h("BackExitIntercept", th2);
        }
        TmcLogger.c("BackExitIntercept", "checkInterceptorCount: currentTimeMillis: " + jCurrentTimeMillis + " lastCheckTime: " + j11 + " num: " + i11 + " showNum: " + iC);
        return j11 == 0 || jCurrentTimeMillis - j11 > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED || i11 < iC;
    }

    public final boolean e(Context context, String str) {
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, "latestCheckBackInterceptorTimeInterval");
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iC = 60000;
        try {
            iC = MiniAppConfigHelper.f30370a.c("miniBackInterceptorShowTime", 60000);
        } catch (Throwable th2) {
            TmcLogger.h("BackExitIntercept", th2);
        }
        TmcLogger.c("BackExitIntercept", "checkNSecondsRules: currentTimeMillis: " + jCurrentTimeMillis + " lastCheckTimeInterval: " + j11 + " showTime: " + iC);
        return jCurrentTimeMillis - j11 > ((long) iC);
    }

    public final bc.a f() {
        return this.f73725a;
    }

    public final void g(Context context, String str) {
        long j11 = ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getLong(context, str, "latestCheckBackInterceptorTime");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j11 == 0 || jCurrentTimeMillis - j11 > ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, str, "latestCheckBackInterceptorNum", 1);
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, str, "latestCheckBackInterceptorTime", jCurrentTimeMillis);
        } else {
            ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putInt(context, str, "latestCheckBackInterceptorNum", ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getInt(context, str, "latestCheckBackInterceptorNum") + 1);
        }
        ((KVStorageProxy) tc.a.a(KVStorageProxy.class)).putLong(context, str, "latestCheckBackInterceptorTimeInterval", jCurrentTimeMillis);
    }

    @Override // qb.a
    public int getPriority() {
        return 20;
    }

    public final void h(bc.a aVar) {
        this.f73725a = aVar;
    }
}
