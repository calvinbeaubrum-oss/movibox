package com.cloud.hisavana.sdk.internal.agentpage;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.MimeTypeMap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.cloud.hisavana.net.disklrucache.ImageCacheURL;
import com.cloud.hisavana.net.disklrucache.impl.IDiskCache;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.sdk.z;
import java.io.File;
import java.io.FileInputStream;
import w9.a0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class AgentPageWebViewClient extends x9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OverrideListener f29811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f29812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f29813c = 4;

    /* JADX INFO: compiled from: source.java */
    public interface OverrideListener {
        boolean OnOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest);

        boolean OnOverrideUrlLoading(WebView webView, String str);

        void onError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError);

        void onPageFinished(WebView webView, String str);
    }

    public AgentPageWebViewClient(OverrideListener overrideListener) {
        this.f29811a = overrideListener;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        OverrideListener overrideListener = this.f29811a;
        if (overrideListener != null) {
            overrideListener.onPageFinished(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        OverrideListener overrideListener = this.f29811a;
        if (overrideListener != null) {
            overrideListener.onError(webView, webResourceRequest, webResourceError);
        }
    }

    public void setMainPageUrl(String str) {
        this.f29812b = str;
    }

    public void setSource(int i11) {
        this.f29813c = i11;
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        File file;
        try {
            z.a().d("AgentPageWebViewClient", "shouldInterceptRequest URL== " + str);
            if (str.startsWith(AgentPageJsBridge.AGENT_PAGE_START_URL)) {
                String str2 = new String(Base64.decode(str.substring(21), 0));
                if (str2.startsWith(AgentPageJsBridge.HTTPS)) {
                    IDiskCache iDiskCacheG = this.f29813c == 4 ? DiskLruCacheUtil.g(4) : DiskLruCacheUtil.g(1);
                    file = iDiskCacheG != null ? iDiskCacheG.c(new ImageCacheURL(str2)) : null;
                } else {
                    file = new File(str2);
                }
                if (file != null && file.exists() && file.length() > 0) {
                    MimeTypeMap.getSingleton();
                    return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), "UTF-8", new FileInputStream(file));
                }
                z.a().e("AgentPageWebViewClient", "not found cache for Base64URL== " + str + ", decode url = " + str2);
            } else if (str.contains(AgentPageJsBridge.AGENT_PAGE_INFO) || (!TextUtils.isEmpty(this.f29812b) && str.equals(this.f29812b))) {
                IDiskCache iDiskCacheG2 = this.f29813c == 4 ? DiskLruCacheUtil.g(4) : DiskLruCacheUtil.g(1);
                if (iDiskCacheG2 != null) {
                    File fileC = str.contains(AgentPageJsBridge.HTML_FROM_LOCAL) ? iDiskCacheG2.c(new ImageCacheURL(a0.a(str))) : iDiskCacheG2.c(new ImageCacheURL(str));
                    if (fileC != null && fileC.exists() && fileC.length() > 0) {
                        MimeTypeMap.getSingleton();
                        return new WebResourceResponse(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str)), "UTF-8", new FileInputStream(fileC));
                    }
                }
            }
            return super.shouldInterceptRequest(webView, str);
        } catch (Exception e11) {
            z.a().e(Log.getStackTraceString(e11));
            return super.shouldInterceptRequest(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        OverrideListener overrideListener = this.f29811a;
        if (overrideListener == null) {
            return false;
        }
        return overrideListener.OnOverrideUrlLoading(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        z.a().d("AgentPageWebViewClient", "shouldOverrideUrlLoading url=" + str);
        OverrideListener overrideListener = this.f29811a;
        if (overrideListener == null) {
            return false;
        }
        return overrideListener.OnOverrideUrlLoading(webView, str);
    }
}
