package com.cloud.tmc.integration.resource.processor;

import android.app.Activity;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.structure.node.PageNode;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.r;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import tb.d;

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
public final class ShellResourceProcessor implements IResourceProcessor {
    public static final String ASSET_SHELL_JS_BRIDGE_FILE_NAME = "byteh5bridge.aio.min.js";
    public static final String ASSET_SHELL_JS_BRIDGE_FOLDER_NAME = "ShellJSBridge";
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f30915b = new Regex("byteh5bridge.*.aio.min.js");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f30916a = "miniShell";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Regex a() {
            return ShellResourceProcessor.f30915b;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String str, String str2) {
        return new ArrayList();
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node) throws IOException {
        Uri url;
        String path;
        d pageContext;
        Activity activity;
        Uri url2 = webResourceRequest != null ? webResourceRequest.getUrl() : null;
        if (url2 == null) {
            return null;
        }
        String string = url2.toString();
        Intrinsics.f(string, "uri.toString()");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        TmcLogger.k(this.f30916a, "ShellJSBridge requestUrl:" + string);
        PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
        AssetManager assets = (pageNode == null || (pageContext = pageNode.getPageContext()) == null || (activity = pageContext.getActivity()) == null) ? null : activity.getAssets();
        if (assets != null) {
            String[] list = assets.list(ASSET_SHELL_JS_BRIDGE_FOLDER_NAME);
            if (list == null || list.length == 0) {
                TmcLogger.k(this.f30916a, "ShellJSBridge Folder must have byteh5bridge.aio.min.js");
            } else {
                if (list.length > 1) {
                    TmcLogger.k(this.f30916a, "ShellJSBridge Folder only keep one byteh5bridge.aio.min.js");
                    return null;
                }
                String string2 = list[0].toString();
                if (f30915b.matchEntire(string2) == null) {
                    TmcLogger.k(this.f30916a, "ShellJSBridge Folder have file must match to byteh5bridge.aio.min.js");
                    return null;
                }
                if (webResourceRequest != null && (url = webResourceRequest.getUrl()) != null && (path = url.getPath()) != null) {
                    List listE0 = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null);
                    if ((!listE0.isEmpty()) && (Intrinsics.b(CollectionsKt___CollectionsKt.q0(listE0), ASSET_SHELL_JS_BRIDGE_FILE_NAME) || Intrinsics.b(CollectionsKt___CollectionsKt.q0(listE0), string2))) {
                        TmcLogger.k(this.f30916a, "ShellJSBridge get file From Assets:ShellJSBridge/" + string2);
                        InputStream inputStreamOpen = assets.open("ShellJSBridge/" + string2);
                        Intrinsics.f(inputStreamOpen, "assetManager.open(\"$ASSE…E_FOLDER_NAME/$fileName\")");
                        return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(r.e(string), BaseResourceProcessor.getResourceResponseEncoding(), inputStreamOpen));
                    }
                }
            }
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, String str2, Node node) {
        return get(webResourceRequest, str, node);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2) {
        return null;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2, String str3) {
        return get(str, str2);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(WebResourceRequest webResourceRequest, String str) {
        String path;
        if (webResourceRequest != null) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url != null && (path = url.getPath()) != null) {
                    List listE0 = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null);
                    if ((!listE0.isEmpty()) && f30915b.matchEntire((CharSequence) CollectionsKt___CollectionsKt.q0(listE0)) != null) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String str, String str2) {
        if (str != null) {
            try {
                String strI = r.i(str);
                if (strI != null) {
                    Intrinsics.f(strI, "getPath(it)");
                    List listE0 = StringsKt__StringsKt.E0(strI, new String[]{"/"}, false, 0, 6, null);
                    if ((!listE0.isEmpty()) && f30915b.matchEntire((CharSequence) CollectionsKt___CollectionsKt.q0(listE0)) != null) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String str) {
        return false;
    }
}
