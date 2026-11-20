package com.cloud.tmc.integration.defaultImpl;

import com.cloud.tmc.integration.model.WebViewStore;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.render.IWebViewDownloadProxy;
import com.google.gson.JsonObject;
import java.util.HashMap;
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
public final class DefaultWebViewDownloadImpl implements IWebViewDownloadProxy {
    public static final a Companion = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.render.IWebViewDownloadProxy
    public void dispatchDownloadEvent(Node node, String str, String str2, String str3, String str4, long j11) {
        HashMap<String, bc.a> onDownloads;
        bc.a aVar;
        Intrinsics.g(node, "node");
        try {
            TmcLogger.c("DefaultWebViewDownloadI", "dispatchDownloadEvent: 准备发送url: " + str);
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            App app = pageNode != null ? pageNode.getApp() : null;
            WebViewStore webViewStore = app != null ? (WebViewStore) app.getData(WebViewStore.class) : null;
            if (webViewStore != null && (onDownloads = webViewStore.getOnDownloads()) != null && (aVar = onDownloads.get(app.getAppId())) != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("url", str);
                jsonObject.addProperty("userAgent", str2);
                jsonObject.addProperty("contentDisposition", str3);
                jsonObject.addProperty("mimetype", str4);
                jsonObject.addProperty("contentLength", Long.valueOf(j11));
                aVar.d(jsonObject);
            }
            TmcLogger.c("DefaultWebViewDownloadI", "dispatchDownloadEvent: 分发 url 完成。 url: " + str);
        } catch (Throwable th2) {
            TmcLogger.g("DefaultWebViewDownloadI", "Failed to dispatch download event", th2);
        }
    }

    @Override // com.cloud.tmc.kernel.proxy.render.IWebViewDownloadProxy
    public void dispatchDownloadFailEvent(Node node, JsonObject data) {
        HashMap<String, bc.a> onDownloads;
        bc.a aVar;
        Intrinsics.g(node, "node");
        Intrinsics.g(data, "data");
        try {
            PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
            App app = pageNode != null ? pageNode.getApp() : null;
            WebViewStore webViewStore = app != null ? (WebViewStore) app.getData(WebViewStore.class) : null;
            if (webViewStore != null && (onDownloads = webViewStore.getOnDownloads()) != null && (aVar = onDownloads.get(app.getAppId())) != null) {
                aVar.e(data);
            }
            TmcLogger.c("DefaultWebViewDownloadI", "dispatchDownloadEvent: 分发 fail 完成。");
        } catch (Throwable th2) {
            TmcLogger.g("DefaultWebViewDownloadI", "Failed to dispatch download event", th2);
        }
    }
}
