package com.cloud.hisavana.net.disklrucache;

import android.net.Uri;
import android.text.TextUtils;
import com.cloud.sdk.commonutil.util.c;
import com.cloud.sdk.commonutil.util.o;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ImageCacheURL {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f28991d = StandardCharsets.UTF_8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f28992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f28993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f28994c;

    public ImageCacheURL(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f28994c = str;
            this.f28993b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        } else {
            this.f28994c = "";
            this.f28993b = "";
            c.netLog("url must be can not null or empty");
        }
    }

    public byte[] a() {
        if (this.f28992a == null) {
            this.f28992a = this.f28993b.getBytes(f28991d);
        }
        return this.f28992a;
    }

    public String b() {
        return d();
    }

    public String c() {
        return this.f28994c;
    }

    public String d() {
        return o.a(this.f28993b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ImageCacheURL) {
            return b().equals(((ImageCacheURL) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f28993b.hashCode() * 31;
    }
}
