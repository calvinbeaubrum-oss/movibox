package com.cloud.tmc.integration.resource.processor;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import com.cloud.tmc.integration.resource.BaseResourceProcessor;
import com.cloud.tmc.integration.structure.App;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.IGetNodeSource;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy;
import com.cloud.tmc.kernel.resource.IImageResourceManager;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.kernel.utils.r;
import com.cloud.tmc.miniutils.util.e0;
import com.cloud.tmc.miniutils.util.j;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Locale;
import tc.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImageResourceProcessor implements IResourceProcessor {
    public final boolean a(String str) {
        return str.endsWith(".jpg") || str.endsWith(".png") || str.endsWith(".gif") || str.endsWith(".webp") || str.endsWith(".jpeg");
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public List<String> fuzzySearch(String str, String str2) {
        IImageResourceManager iImageResourceManager = (IImageResourceManager) a.a(IImageResourceManager.class);
        return iImageResourceManager.fuzzySearchByVUrl(iImageResourceManager.getVhost(str), str2);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, Node node) {
        File file;
        Uri url = webResourceRequest.getUrl();
        if (url == null) {
            return null;
        }
        String string = url.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            if (string.contains(".miniapp.transsion.com")) {
                App app = (App) node.bubbleFindNode(App.class);
                if (app == null) {
                    return null;
                }
                IImageResourceManager imageResourceManagerProxy = app.getImageResourceManagerProxy();
                String vhost = imageResourceManagerProxy.getVhost(str);
                if (!string.startsWith(vhost)) {
                    string = vhost + "/" + string;
                }
                file = new File(imageResourceManagerProxy.getImagePath(string));
            } else {
                String nodeSource = ((IGetNodeSource) a.a(IGetNodeSource.class)).getNodeSource(node);
                file = ("miniShellPage".equals(nodeSource) || "h5MixedPage".equals(nodeSource)) ? null : ((ImageLoaderProxy) a.a(ImageLoaderProxy.class)).loadImgFile(e0.a().getApplicationContext(), string);
            }
            if (file == null) {
                return null;
            }
            return BaseResourceProcessor.addCommonWebRespHeaders(new WebResourceResponse(r.e(string), BaseResourceProcessor.getResourceResponseEncoding(), new FileInputStream(file)));
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public WebResourceResponse get(WebResourceRequest webResourceRequest, String str, String str2, Node node) {
        return get(webResourceRequest, str, node);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i0.b(str) && !str.contains(".miniapp.transsion.com")) {
            return ((ImageLoaderProxy) a.a(ImageLoaderProxy.class)).loadImgFile(e0.a().getApplicationContext(), str);
        }
        IImageResourceManager iImageResourceManager = (IImageResourceManager) a.a(IImageResourceManager.class);
        String vhost = iImageResourceManager.getVhost(str2);
        if (!str.startsWith(vhost)) {
            str = vhost + "/" + str;
        }
        return j.r(iImageResourceManager.getImagePath(str));
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public File get(String str, String str2, String str3) {
        return get(str, str2);
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(WebResourceRequest webResourceRequest, String str) {
        Uri url = webResourceRequest.getUrl();
        if (url == null) {
            return false;
        }
        String string = url.toString();
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        String lowerCase = string.toLowerCase();
        if (lowerCase.startsWith(HttpHost.DEFAULT_SCHEME_NAME) && a(lowerCase)) {
            return true;
        }
        if (lowerCase.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            try {
                if (a(url.getPath())) {
                    return true;
                }
            } catch (Throwable th2) {
                TmcLogger.h("ImageResourceProcessor", th2);
            }
        }
        return false;
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldIntercept(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        return lowerCase.startsWith(HttpHost.DEFAULT_SCHEME_NAME) || lowerCase.endsWith(".jpg") || lowerCase.endsWith(".png") || lowerCase.endsWith(".gif") || lowerCase.endsWith(".webp") || lowerCase.endsWith(".jpeg");
    }

    @Override // com.cloud.tmc.kernel.resource.IResourceProcessor
    public boolean shouldInterceptFuzzySearch(String str) {
        return !TextUtils.isEmpty(str);
    }
}
