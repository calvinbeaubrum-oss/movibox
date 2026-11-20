package bb;

import android.os.Bundle;
import com.cloud.tmc.integration.chain.page.PageChainContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class b implements ab.a {
    public void a(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("keepSituation");
        appChainContext.r().set(0);
        appChainContext.p().set(0);
        appChainContext.Y(false);
        appChainContext.X(false);
        appChainContext.W(false);
        appChainContext.V(false);
        appChainContext.T(11);
        appChainContext.t().clear();
        appChainContext.u().clear();
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iL = appChainContext.l();
        if (1 <= iL) {
            int i11 = 1;
            while (true) {
                appChainContext.t().put(String.valueOf(i11), 0L);
                appChainContext.u().put(String.valueOf(i11), kotlin.collections.g.h(Long.valueOf(jCurrentTimeMillis), Long.valueOf(jCurrentTimeMillis)));
                if (i11 == iL) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        appChainContext.a0(0);
        appChainContext.x().clear();
        appChainContext.R("");
    }

    public void b(String str) {
        ab.a.C0021a.a(this, str);
    }

    public void c(wa.a appChainContext, Bundle dataBundle) {
        Intrinsics.g(appChainContext, "appChainContext");
        Intrinsics.g(dataBundle, "dataBundle");
        b("reset");
        if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S)) {
            String string = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
            Intrinsics.f(string, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
            appChainContext.Z(string);
            String string2 = dataBundle.getString("hot_open_type", "-2");
            Intrinsics.f(string2, "dataBundle.getString(Tmc…ants.HOT_OPEN_TYPE, \"-2\")");
            appChainContext.S(string2);
            for (PageChainContext pageChainContext : appChainContext.q()) {
                String string3 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.S, "0");
                Intrinsics.f(string3, "dataBundle.getString(ChainPoint.CHAIN_SCENE, \"0\")");
                pageChainContext.P(string3);
            }
        }
        if (dataBundle.containsKey(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T)) {
            String string4 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
            Intrinsics.f(string4, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
            appChainContext.U(string4);
            for (PageChainContext pageChainContext2 : appChainContext.q()) {
                String string5 = dataBundle.getString(com.cloud.tmc.kernel.proxy.performanceanalyse.a.T, "-1");
                Intrinsics.f(string5, "dataBundle.getString(Cha…CHAIN_OPEN_CHANNEL, \"-1\")");
                pageChainContext2.J(string5);
            }
        }
    }
}
