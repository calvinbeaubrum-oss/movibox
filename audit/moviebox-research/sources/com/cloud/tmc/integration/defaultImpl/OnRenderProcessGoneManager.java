package com.cloud.tmc.integration.defaultImpl;

import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class OnRenderProcessGoneManager implements IOnRenderProcessGoneProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<IOnRenderProcessGoneProxy.a> f30707a = new CopyOnWriteArrayList<>();

    @Override // com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy
    public void received(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        Iterator<IOnRenderProcessGoneProxy.a> it = this.f30707a.iterator();
        Intrinsics.f(it, "listeners.iterator()");
        while (it.hasNext()) {
            it.next().onRenderProcessGone(webView, renderProcessGoneDetail);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy
    public void register(IOnRenderProcessGoneProxy.a aVar) {
        if (aVar == null || this.f30707a.contains(aVar)) {
            return;
        }
        this.f30707a.add(aVar);
    }

    @Override // com.cloud.tmc.kernel.proxy.renderprocess.IOnRenderProcessGoneProxy
    public void unRegister(IOnRenderProcessGoneProxy.a aVar) {
        if (aVar == null || !this.f30707a.contains(aVar)) {
            return;
        }
        this.f30707a.remove(aVar);
    }
}
