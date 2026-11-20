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
import com.cloud.tmc.render.bean.JSConfig;
import com.cloud.tmc.render.proxy.InjectJSProxy;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class InjectJavaScriptResourceProcessor implements IResourceProcessor {
    public static final String ASSET_INJECT_JS_FOLDER_NAME = "injectjavascript";
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f30913a = "InjectJavaScriptResourceProcessor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f30914b = "";

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String str, String str2) {
        return new ArrayList();
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node) {
        Uri url;
        String str2;
        d pageContext;
        Activity activity;
        if (webResourceRequest != null) {
            try {
                url = webResourceRequest.getUrl();
            } catch (Throwable unused) {
            }
        } else {
            url = null;
        }
        if (url == null) {
            return null;
        }
        String string = url.toString();
        Intrinsics.f(string, "uri.toString()");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        TmcLogger.k(this.f30913a, "InjectJavaScriptResourceProcessor requestUrl:" + string);
        String strI = r.i(string);
        if (strI != null) {
            int i11 = 0;
            List listE0 = StringsKt__StringsKt.E0(strI, new String[]{"/"}, false, 0, 6, null);
            if (listE0 != null && (true ^ listE0.isEmpty())) {
                String str3 = (String) CollectionsKt___CollectionsKt.q0(listE0);
                PageNode pageNode = node instanceof PageNode ? (PageNode) node : null;
                AssetManager assets = (pageNode == null || (pageContext = pageNode.getPageContext()) == null || (activity = pageContext.getActivity()) == null) ? null : activity.getAssets();
                if (assets != null) {
                    String[] list = assets.list(ASSET_INJECT_JS_FOLDER_NAME);
                    if (list != null && list.length != 0) {
                        int length = list.length;
                        while (true) {
                            if (i11 >= length) {
                                str2 = null;
                                break;
                            }
                            str2 = list[i11];
                            if (Intrinsics.b(str2, str3)) {
                                break;
                            }
                            i11++;
                        }
                        if (str2 == null) {
                            return null;
                        }
                        TmcLogger.k(this.f30913a, "InjectJavaScriptResourceProcessor filePath:injectjavascript/" + str2);
                        InputStream inputStreamOpen = assets.open("injectjavascript/" + str2);
                        Intrinsics.f(inputStreamOpen, "assetManager.open(\"$ASSE…S_FOLDER_NAME/$fileName\")");
                        return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(r.e(string), BaseResourceProcessor.getResourceResponseEncoding(), inputStreamOpen));
                    }
                    TmcLogger.k(this.f30913a, "InjectJavaScriptResourceProcessor Folder must have js file");
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

    public final String getAppId() {
        return this.f30914b;
    }

    public final void setAppId(String str) {
        this.f30914b = str;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0020 A[Catch: all -> 0x009d, TryCatch #0 {all -> 0x009d, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0010, B:11:0x0024, B:14:0x0030, B:16:0x0038, B:20:0x0044, B:21:0x004e, B:23:0x0054, B:25:0x0064, B:27:0x0076, B:29:0x008c, B:31:0x0092, B:10:0x0020), top: B:35:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x0030 A[Catch: all -> 0x009d, TRY_ENTER, TryCatch #0 {all -> 0x009d, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0010, B:11:0x0024, B:14:0x0030, B:16:0x0038, B:20:0x0044, B:21:0x004e, B:23:0x0054, B:25:0x0064, B:27:0x0076, B:29:0x008c, B:31:0x0092, B:10:0x0020), top: B:35:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0037  */
    /* JADX WARN: Code duplicated, block: B:18:0x0042  */
    /* JADX WARN: Code duplicated, block: B:19:0x0043  */
    /* JADX WARN: Code duplicated, block: B:23:0x0054 A[Catch: all -> 0x009d, TryCatch #0 {all -> 0x009d, blocks: (B:4:0x0004, B:6:0x000a, B:8:0x0010, B:11:0x0024, B:14:0x0030, B:16:0x0038, B:20:0x0044, B:21:0x004e, B:23:0x0054, B:25:0x0064, B:27:0x0076, B:29:0x008c, B:31:0x0092, B:10:0x0020), top: B:35:0x0004 }] */
    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(WebResourceRequest webResourceRequest, String str) {
        String path;
        List listE0;
        String str2;
        String str3;
        Iterator<T> it;
        if (webResourceRequest != null) {
            try {
                Uri url = webResourceRequest.getUrl();
                if (url == null || (path = url.getPath()) == null || (listE0 = StringsKt__StringsKt.E0(path, new String[]{"/"}, false, 0, 6, null)) == null) {
                    listE0 = g.l();
                }
                str2 = "";
                if (!listE0.isEmpty()) {
                    str3 = (String) CollectionsKt___CollectionsKt.q0(listE0);
                } else {
                    str3 = "";
                }
                InjectJSProxy injectJSProxy = (InjectJSProxy) tc.a.a(InjectJSProxy.class);
                if (str == null) {
                    str2 = str;
                }
                it = injectJSProxy.getTartgetInjectJSData(str2).iterator();
                while (it.hasNext()) {
                    if (!Intrinsics.b(((JSConfig) it.next()).getJsName(), str3) && ShellResourceProcessor.Companion.a().matchEntire((CharSequence) CollectionsKt___CollectionsKt.q0(listE0)) == null) {
                        String str4 = this.f30913a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("InjectJavaScriptResourceProcessor shouldIntercept -> appId:");
                        sb2.append(str);
                        sb2.append(", requestUrl:");
                        sb2.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
                        TmcLogger.c(str4, sb2.toString());
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        } else {
            listE0 = g.l();
            str2 = "";
            if (!listE0.isEmpty()) {
                str3 = (String) CollectionsKt___CollectionsKt.q0(listE0);
            } else {
                str3 = "";
            }
            InjectJSProxy injectJSProxy2 = (InjectJSProxy) tc.a.a(InjectJSProxy.class);
            if (str == null) {
                str2 = str;
            }
            it = injectJSProxy2.getTartgetInjectJSData(str2).iterator();
            while (it.hasNext()) {
                if (!Intrinsics.b(((JSConfig) it.next()).getJsName(), str3)) {
                }
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String str, String str2) {
        List listL;
        try {
            String strI = r.i(str);
            if (strI == null || (listL = StringsKt__StringsKt.E0(strI, new String[]{"/"}, false, 0, 6, null)) == null) {
                listL = g.l();
            }
            String str3 = "";
            String str4 = listL.isEmpty() ^ true ? (String) CollectionsKt___CollectionsKt.q0(listL) : "";
            InjectJSProxy injectJSProxy = (InjectJSProxy) tc.a.a(InjectJSProxy.class);
            if (str2 != null) {
                str3 = str2;
            }
            Iterator<T> it = injectJSProxy.getTartgetInjectJSData(str3).iterator();
            while (it.hasNext()) {
                if (Intrinsics.b(((JSConfig) it.next()).getJsName(), str4) && ShellResourceProcessor.Companion.a().matchEntire((CharSequence) CollectionsKt___CollectionsKt.q0(listL)) == null) {
                    TmcLogger.c(this.f30913a, "InjectJavaScriptResourceProcessor shouldIntercept -> appId:" + str2 + ", requestUrl:" + str);
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String str) {
        return false;
    }
}
