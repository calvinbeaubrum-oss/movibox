package ne;

import com.cloud.tmc.kernel.bridge.IMsgDispatcher;
import com.cloud.tmc.kernel.bridge.model.ProtocolData;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.utils.p;
import com.google.gson.Gson;
import hc.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class a implements b {
    /* JADX WARN: Code duplicated, block: B:32:0x00ae A[Catch: Exception -> 0x0074, TryCatch #0 {Exception -> 0x0074, blocks: (B:3:0x0017, B:6:0x0023, B:8:0x0058, B:12:0x0065, B:15:0x006f, B:18:0x0076, B:21:0x007d, B:22:0x008a, B:32:0x00ae, B:25:0x0091, B:28:0x0098, B:29:0x00a5, B:33:0x00bb, B:36:0x00c2), top: B:41:0x0017 }] */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // ne.b
    public void a(EngineRouter engineRouter, String workerId, String renderId, String result) {
        Intrinsics.g(workerId, "workerId");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(result, "result");
        try {
            if (l.L(result, "__TmcRenderToWorkerMsg:", false, 2, null)) {
                String strF = l.F(result, "__TmcRenderToWorkerMsg:", "", false, 4, null);
                p.e("miniapp", "renderSendToNative = " + strF);
                String abilityName = ((ProtocolData) new Gson().fromJson(strF, ProtocolData.class)).getAbilityName();
                if (abilityName != null) {
                    switch (abilityName.hashCode()) {
                        case -1341969888:
                            if (abilityName.equals("DispatchEvent")) {
                                p.e("TmcRender", "DispatchEvent");
                                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, strF);
                            }
                            break;
                        case -1190321207:
                            if (abilityName.equals("DispatchNativeEvent")) {
                                p.e("TmcRender", "DispatchNativeComponent");
                                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, strF);
                            }
                            break;
                        case 66042:
                            if (abilityName.equals("Api")) {
                                p.e("TmcRender", "Api");
                                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, strF);
                            }
                            break;
                        case 229351084:
                            if (abilityName.equals("DispatchNativeComponent")) {
                                p.e("TmcRender", "DispatchNativeComponent");
                                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, strF);
                            }
                            break;
                        case 1672091434:
                            if (abilityName.equals("LifeCycle")) {
                                p.e("TmcRender", "LifeCycle");
                                ((IMsgDispatcher) tc.a.a(IMsgDispatcher.class)).handleMsgFromRender(engineRouter, workerId, renderId, strF);
                            }
                            break;
                        case 1988583688:
                            if (abilityName.equals("debugRefresh")) {
                                c.b();
                            }
                            break;
                    }
                }
            }
        } catch (Exception e11) {
            p.c("TmcRender", "DefaultBridgeDispatch e = " + e11);
        }
    }
}
