package com.cloud.tmc.render.utils;

import android.webkit.JavascriptInterface;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.eventcenter.IEventCenterFactory;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.s;
import kotlin.jvm.internal.Intrinsics;
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
public final class ADJSI {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Node f32136a;

    @JavascriptInterface
    public final void adEvent(String adTag, boolean z11, String callbackId) {
        b eventCenterInstance;
        Intrinsics.g(adTag, "adTag");
        Intrinsics.g(callbackId, "callbackId");
        TmcLogger.c("pom", "adEvent->adTag:" + adTag + ", adm:" + z11 + ", callbackId:" + callbackId);
        Node node = this.f32136a;
        if (node == null || (eventCenterInstance = ((IEventCenterFactory) tc.a.a(IEventCenterFactory.class)).getEventCenterInstance(node)) == null) {
            return;
        }
        String str = "eventAD_" + node.getNodeId();
        fc.a aVar = new fc.a("eventAD_" + node.getNodeId());
        aVar.c(s.j(TuplesKt.a("eventADParmaKeyADTag", adTag), TuplesKt.a("eventADParmaKeyADM", Boolean.valueOf(z11)), TuplesKt.a("eventADParmaKeyCallbackId", callbackId)));
        Unit unit = Unit.f68710a;
        eventCenterInstance.d(str, aVar);
    }

    public final Node getPage() {
        return this.f32136a;
    }

    public final void setNode(Node node) {
        this.f32136a = node;
    }

    public final void setPage(Node node) {
        this.f32136a = node;
    }
}
