package com.cloud.tmc.render.utils;

import android.webkit.JavascriptInterface;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import uc.b;

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
public final class FullScreenJSI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f32137a;

    @JavascriptInterface
    public final void enterFullScreen(int i11, int i12, boolean z11) {
        b eventCenterInstance;
        TmcLogger.c("pom", "getRect->width:" + i11 + ", height:" + i12 + ", isVideo:" + z11);
        Node node = this.f32137a;
        if (node == null || (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(node)) == null) {
            return;
        }
        String str = "eventFullScreen_" + node.getNodeId();
        fc.a aVar = new fc.a("eventFullScreen_" + node.getNodeId());
        aVar.c(s.j(TuplesKt.a("eventFullScreenParamKeyWidth", Integer.valueOf(i11)), TuplesKt.a("eventFullScreenParamKeyHeight", Integer.valueOf(i12)), TuplesKt.a("eventFullScreenParamKeyIsVideo", Boolean.valueOf(z11))));
        Unit unit = Unit.f68710a;
        eventCenterInstance.d(str, aVar);
    }

    public final Node getPage() {
        return this.f32137a;
    }

    public final void setNode(Node node) {
        this.f32137a = node;
    }

    public final void setPage(Node node) {
        this.f32137a = node;
    }
}
