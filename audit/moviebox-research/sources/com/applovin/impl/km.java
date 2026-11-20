package com.applovin.impl;

import android.text.TextUtils;
import android.webkit.URLUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class km extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f20262h;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to fetch app details due to: " + str2 + ", and received error code: " + i11);
            }
            km.this.f20262h.a(y0.b.APP_DETAILS_NOT_FOUND);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, String str2, int i11) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "No developer URI found - response from the Play Store is empty");
                }
                km.this.f20262h.a(y0.b.APP_DETAILS_NOT_FOUND);
                return;
            }
            Matcher matcher = Pattern.compile("(?<=\"appstore:developer_url\" content=\").*?(?=\">)").matcher(str2);
            if (!matcher.find()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "No developer URI found - unable to find the developer_url meta tag from the Play Store listing");
                }
                km.this.f20262h.a(y0.b.INVALID_DEVELOPER_URI);
                return;
            }
            String strGroup = matcher.group();
            if (URLUtil.isValidUrl(strGroup)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Found developer URI: " + strGroup);
                }
                km.this.f20262h.a(strGroup);
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Developer URI (" + strGroup + ") is not valid");
            }
            km.this.f20262h.a(y0.b.INVALID_DEVELOPER_URI);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(y0.b bVar);

        void a(String str);
    }

    public km(com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskFetchDeveloperUri", jVar);
        this.f20262h = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strValueOf = String.valueOf(this.f24689a.y().A().get("package_name"));
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Looking up developer URI for package name: " + strValueOf);
        }
        this.f24689a.j0().a(new a(com.applovin.impl.sdk.network.a.a(this.f24689a).c("GET").b("https://play.google.com/store/apps/details?id=" + strValueOf).a((Object) "").a(false).a(), this.f24689a));
    }
}
