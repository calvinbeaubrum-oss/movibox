package com.applovin.impl.sdk.nativeAd;

import android.net.Uri;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u2;
import com.applovin.impl.yl;
import java.io.File;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends yl {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u2 f22690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AppLovinNativeAdImpl f22691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final InterfaceC0201a f22692j;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.nativeAd.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0201a {
        void a(AppLovinNativeAdImpl appLovinNativeAdImpl);
    }

    public a(AppLovinNativeAdImpl appLovinNativeAdImpl, j jVar, InterfaceC0201a interfaceC0201a) {
        super("TaskCacheNativeAd", jVar);
        this.f22690h = new u2();
        this.f22691i = appLovinNativeAdImpl;
        this.f22692j = interfaceC0201a;
    }

    private Uri a(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Attempting to cache resource: " + uri);
        }
        String strA = this.f24689a.B().a(a(), uri.toString(), this.f22691i.getCachePrefix(), Collections.emptyList(), false, false, this.f22690h);
        if (StringUtils.isValidString(strA)) {
            File fileA = this.f24689a.B().a(strA, a());
            if (fileA != null) {
                Uri uriFromFile = Uri.fromFile(fileA);
                if (uriFromFile != null) {
                    return uriFromFile;
                }
                if (n.a()) {
                    this.f24691c.b(this.f24690b, "Unable to extract Uri from image file");
                }
            } else if (n.a()) {
                this.f24691c.b(this.f24690b, "Unable to retrieve File from cached image filename = " + strA);
            }
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Begin caching ad #" + this.f22691i.getAdIdNumber() + "...");
        }
        Uri uriA = a(this.f22691i.getIconUri());
        if (uriA != null) {
            this.f22691i.setIconUri(uriA);
        }
        Uri uriA2 = a(this.f22691i.getMainImageUri());
        if (uriA2 != null) {
            this.f22691i.setMainImageUri(uriA2);
        }
        Uri uriA3 = a(this.f22691i.getPrivacyIconUri());
        if (uriA3 != null) {
            this.f22691i.setPrivacyIconUri(uriA3);
        }
        if (n.a()) {
            this.f24691c.a(this.f24690b, "Finished caching ad #" + this.f22691i.getAdIdNumber());
        }
        this.f22692j.a(this.f22691i);
    }
}
