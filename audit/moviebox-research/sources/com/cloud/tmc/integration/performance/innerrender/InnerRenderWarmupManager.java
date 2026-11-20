package com.cloud.tmc.integration.performance.innerrender;

import android.content.Context;
import android.view.View;
import com.cloud.tmc.integration.structure.WarmupNode;
import com.cloud.tmc.kernel.coreimpl.DefaultEngineRouter;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import com.cloud.tmc.render.system.SystemWebView;
import fe.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import zc.i;
import zc.l;

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
public final class InnerRenderWarmupManager {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements uc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f30843a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ uc.b f30844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ nb.a f30845c;

        public a(i iVar, uc.b bVar, nb.a aVar) {
            this.f30843a = iVar;
            this.f30844b = bVar;
            this.f30845c = aVar;
        }

        @Override // uc.c
        public boolean O(uc.a event) {
            f webviewBridgeHelper;
            Intrinsics.g(event, "event");
            i iVar = this.f30843a;
            View view = iVar != null ? iVar.getView() : null;
            SystemWebView systemWebView = view instanceof SystemWebView ? (SystemWebView) view : null;
            if (systemWebView != null && (webviewBridgeHelper = systemWebView.getWebviewBridgeHelper()) != null) {
                webviewBridgeHelper.b();
            }
            uc.b bVar = this.f30844b;
            if (bVar != null) {
                bVar.c("renderOnMessageReady", this);
            }
            WarmupNode warmupNode = (WarmupNode) tc.a.a(WarmupNode.class);
            String strB = this.f30843a.b();
            Intrinsics.f(strB, "render.renderId");
            warmupNode.removeNode(strB);
            this.f30845c.a(true);
            return true;
        }
    }

    public final void a(i iVar, nb.a aVar, Node node) {
        uc.b eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(node);
        if (eventCenterInstance != null) {
            eventCenterInstance.b("renderOnMessageReady", new a(iVar, eventCenterInstance, aVar));
        }
    }

    public final void b(Context context, int i11) {
        Intrinsics.g(context, "context");
        j.d(l0.a(w0.a()), null, null, new InnerRenderWarmupManager$preWarmup$1(context, i11, null), 3, null);
    }

    public final void c(i render, lb.f fVar, nb.a warmUpCallback) {
        Intrinsics.g(render, "render");
        Intrinsics.g(warmUpCallback, "warmUpCallback");
        render.setFrameworkVersion(fVar != null ? fVar.a() : null);
        String str = "warmup_render_id__" + nb.c.f71783a.a().addAndGet(1);
        Node node = ((WarmupNode) tc.a.a(WarmupNode.class)).getNode(str);
        a(render, warmUpCallback, node);
        d(render, node, str);
    }

    public final void d(i iVar, Node node, String str) {
        iVar.h(new DefaultEngineRouter());
        iVar.q("99999");
        iVar.p(node);
        iVar.init(str);
        l lVar = new l();
        lVar.f81893a = "https://100000.miniapp.transsion.com/index.html";
        iVar.k(lVar);
    }
}
