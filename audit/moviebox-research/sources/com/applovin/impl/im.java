package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class im extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final b f19754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f19755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f19756j;

    /* JADX INFO: compiled from: source.java */
    public class a extends dn {
        public a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
            super(aVar, jVar);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, String str3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Unable to fetch app-ads.txt due to: " + str2 + ", and received error code: " + i11);
            }
            im.this.f19754h.a(y0.b.APPADSTXT_NOT_FOUND, im.this.f19756j);
        }

        @Override // com.applovin.impl.dn, com.applovin.impl.d4.e
        public void a(String str, String str2, int i11) {
            if (TextUtils.isEmpty(str2)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.b(this.f24690b, "No app-ads.txt found");
                }
                im.this.f19754h.a(y0.b.APPADSTXT_NOT_FOUND, im.this.f19756j);
            } else {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f24691c.a(this.f24690b, "Found app-ads.txt");
                }
                im.this.f19754h.a(str2, im.this.f19756j);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(y0.b bVar, String str);

        void a(String str, String str2);
    }

    public im(com.applovin.impl.sdk.j jVar, String str, b bVar) {
        super("TaskFetchAppAdsContent", jVar);
        this.f19755i = str;
        this.f19754h = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList = new ArrayList(Arrays.asList(Uri.parse(this.f19755i).getAuthority().split("\\.")));
        if (arrayList.size() > 0) {
            String str = (String) arrayList.get(0);
            if ("www".equals(str) || "m".equals(str)) {
                arrayList.remove(0);
            }
        }
        String strJoin = TextUtils.join(InstructionFileId.DOT, arrayList);
        Uri uriBuild = new Uri.Builder().scheme("https").authority(strJoin).appendPath("app-ads.txt").build();
        com.applovin.impl.sdk.network.a aVarA = com.applovin.impl.sdk.network.a.a(this.f24689a).c("GET").b(uriBuild.toString()).a(new Uri.Builder().scheme(HttpHost.DEFAULT_SCHEME_NAME).authority(strJoin).appendPath("app-ads.txt").build().toString()).a((Object) "").a(false).a();
        this.f19756j = uriBuild.toString();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24691c.a(this.f24690b, "Looking up app-ads.txt at " + this.f19756j);
        }
        this.f24689a.j0().a(new a(aVarA, this.f24689a));
    }
}
