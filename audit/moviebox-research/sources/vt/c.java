package vt;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f79110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public URL f79111c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile byte[] f79112d;

    public c(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.f79110b = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // vt.e
    public void a(MessageDigest messageDigest) {
        if (this.f79112d == null) {
            this.f79112d = this.f79110b.getBytes(e.f79115a);
        }
        messageDigest.update(this.f79112d);
    }

    public URL b() throws MalformedURLException {
        if (this.f79111c == null) {
            this.f79111c = new URL(this.f79110b);
        }
        return this.f79111c;
    }

    public String toString() {
        return this.f79110b;
    }
}
