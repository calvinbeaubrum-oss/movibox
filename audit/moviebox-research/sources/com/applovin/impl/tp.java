package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.HashMap;
import java.util.Map;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tp {

    /* JADX INFO: compiled from: source.java */
    public class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f23423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.adview.a f23424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f23425c;

        public a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
            this.f23423a = str;
            this.f23424b = aVar;
            this.f23425c = jVar;
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppLovinWebViewActivity) {
                ((AppLovinWebViewActivity) activity).loadUrl(this.f23423a, null);
                gc.c(this.f23424b.e(), this.f23424b.i(), this.f23424b.k());
            }
        }

        @Override // com.applovin.impl.p, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof AppLovinWebViewActivity) {
                gc.a(this.f23424b.e(), this.f23424b.i(), this.f23424b.k());
                this.f23425c.e().b(this);
            }
        }
    }

    public static Bundle a(Uri uri) {
        Bundle bundle = new Bundle();
        for (String str : uri.getQueryParameterNames()) {
            bundle.putString(str, uri.getQueryParameter(str));
        }
        return bundle;
    }

    public static void a(Uri uri, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        com.applovin.impl.adview.b bVarG = aVar.g();
        String queryParameter = uri.getQueryParameter("n");
        if (TextUtils.isEmpty(queryParameter)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("UriUtils", "Could not find url to load from query in original uri");
                return;
            }
            return;
        }
        String queryParameter2 = uri.getQueryParameter("load_type");
        if ("external".equalsIgnoreCase(queryParameter2)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("UriUtils", "Loading new page externally: " + queryParameter);
            }
            a(queryParameter, aVar, jVar);
            return;
        }
        if ("internal".equalsIgnoreCase(queryParameter2)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("UriUtils", "Loading new page in WebView: " + queryParameter);
            }
            bVarG.loadUrl(queryParameter);
            String queryParameter3 = uri.getQueryParameter("bg_color");
            if (StringUtils.isValidString(queryParameter3)) {
                bVarG.setBackgroundColor(Color.parseColor(queryParameter3));
                return;
            }
            return;
        }
        if ("in_app".equalsIgnoreCase(queryParameter2)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("UriUtils", "Loading new page in slide-up webview: " + queryParameter);
            }
            jVar.e().a(new a(queryParameter, aVar, jVar));
            Intent intent = new Intent(com.applovin.impl.sdk.j.l(), (Class<?>) AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, jVar.b0());
            intent.setFlags(ASTNode.DEOP);
            com.applovin.impl.sdk.j.l().startActivity(intent);
            return;
        }
        if (!"in_app_v2".equalsIgnoreCase(queryParameter2)) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().b("UriUtils", "Could not find load type in original uri");
                return;
            }
            return;
        }
        aVar.a(aVar.i(), aVar.k(), (Uri) null, bVarG.getAndClearLastClickEvent(), (Bundle) null);
        if (aVar.j() != null) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("UriUtils", "Loading new page in Custom Tabs: " + queryParameter);
            }
            jVar.x().a(queryParameter, aVar, jVar.n0());
            return;
        }
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().a("UriUtils", "Custom Tabs not supported, loading new page externally: " + queryParameter);
        }
        a(queryParameter, aVar, jVar);
    }

    public static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            jVar.X().e(com.applovin.impl.sdk.network.d.b().d(StringUtils.appendQueryParameter(queryParameter, "clcode", bVar.getClCode())).a(false).b(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
            return;
        }
        jVar.J();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.J().b("UriUtils", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    private static void a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.j jVar) {
        a(Uri.parse(str), aVar.g().getContext(), jVar);
        gc.b(aVar.e(), aVar.i(), aVar.k());
    }

    public static boolean a(Uri uri, Context context, com.applovin.impl.sdk.j jVar) {
        boolean z11 = false;
        if (uri == null) {
            return false;
        }
        try {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().d("UriUtils", "Opening URI: " + uri);
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(ASTNode.DEOP);
            }
            if ("market".equals(intent.getScheme()) || "play.google.com".equals(uri.getHost())) {
                intent.setPackage("com.android.vending");
            }
            jVar.f0().pauseForClick();
            context.startActivity(intent);
            z11 = true;
        } catch (Throwable th2) {
            jVar.J();
            if (com.applovin.impl.sdk.n.a()) {
                jVar.J().a("UriUtils", "Unable to open \"" + uri + "\".", th2);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", uri.toString());
            if ("play.google.com".equals(uri.getHost())) {
                CollectionUtils.putStringIfValid("details", (String) jVar.y().G().get("ps_version"), mapHashMap);
            }
            jVar.E().a("UriUtils", "openUri", th2, mapHashMap);
        }
        if (!z11) {
            jVar.f0().resumeForClick();
        }
        return z11;
    }

    public static void b(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.j jVar) {
        String strEmptyIfNull = StringUtils.emptyIfNull(uri.getQueryParameter("error"));
        String strEmptyIfNull2 = StringUtils.emptyIfNull(uri.getQueryParameter("exception"));
        String strEmptyIfNull3 = StringUtils.emptyIfNull(uri.getQueryParameter("details"));
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", strEmptyIfNull);
        CollectionUtils.putStringIfValid("top_main_method", strEmptyIfNull2, mapHashMap);
        CollectionUtils.putStringIfValid("details", strEmptyIfNull3, mapHashMap);
        if (bVar != null) {
            mapHashMap.putAll(ma.a(bVar));
        }
        jVar.E().a(la.R, (Map) mapHashMap);
    }

    public static boolean b(Uri uri) {
        return uri != null && "applovin".equalsIgnoreCase(uri.getScheme()) && "com.applovin.sdk".equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }
}
