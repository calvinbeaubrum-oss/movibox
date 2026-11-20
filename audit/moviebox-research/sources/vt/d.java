package vt;

import android.net.Uri;
import android.text.TextUtils;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile byte[] f79113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f79114c;

    public d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("url must be can not null or empty");
        }
        this.f79114c = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
    }

    @Override // vt.e
    public void a(MessageDigest messageDigest) {
        if (this.f79113b == null) {
            this.f79113b = this.f79114c.getBytes(e.f79115a);
        }
        messageDigest.update(this.f79113b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return bu.e.a(this.f79114c).equals(bu.e.a(((d) obj).f79114c));
        }
        return false;
    }

    public int hashCode() {
        return this.f79114c.hashCode() * 31;
    }
}
