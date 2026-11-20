package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static d f48542c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<String> f48543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, Object> f48544b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g f48545d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private e f48546e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f48547f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f48548g = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f48549h = "down_type";

    private d() {
        this.f48547f = false;
        try {
            this.f48545d = g.a();
            this.f48546e = e.a.f48552a;
            this.f48543a = new CopyOnWriteArrayList<>();
            this.f48544b = new ConcurrentHashMap();
            com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (gVarB != null) {
                this.f48547f = gVarB.y(1);
            }
        } catch (Throwable th2) {
            ad.a("H5DownLoadManager", th2.getMessage(), th2);
        }
    }

    public static synchronized d a() {
        try {
            if (f48542c == null) {
                f48542c = new d();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f48542c;
    }

    public final String a(String str) {
        try {
            if (Patterns.WEB_URL.matcher(str).matches() || URLUtil.isValidUrl(str)) {
                Uri uri = Uri.parse(str);
                String path = uri.getPath();
                if (TextUtils.isEmpty(path) || !TextUtils.isEmpty(uri.getQueryParameter("urlDebug"))) {
                    return str;
                }
                if (!path.toLowerCase().endsWith(".zip")) {
                    e eVar = this.f48546e;
                    return eVar != null ? eVar.a(str) : str;
                }
                g gVar = this.f48545d;
                if (gVar != null) {
                    return gVar.a(str);
                }
                return null;
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return str;
    }
}
