package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.i;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<List<byte[]>> f7815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f7816e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f7817f;

    public e(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull List<List<byte[]>> list) {
        this.f7812a = (String) i.g(str);
        this.f7813b = (String) i.g(str2);
        this.f7814c = (String) i.g(str3);
        this.f7815d = (List) i.g(list);
        this.f7817f = a(str, str2, str3);
    }

    public final String a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    @Nullable
    public List<List<byte[]>> b() {
        return this.f7815d;
    }

    public int c() {
        return this.f7816e;
    }

    @NonNull
    public String d() {
        return this.f7817f;
    }

    @NonNull
    public String e() {
        return this.f7812a;
    }

    @NonNull
    public String f() {
        return this.f7813b;
    }

    @NonNull
    public String g() {
        return this.f7814c;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("FontRequest {mProviderAuthority: " + this.f7812a + ", mProviderPackage: " + this.f7813b + ", mQuery: " + this.f7814c + ", mCertificates:");
        for (int i11 = 0; i11 < this.f7815d.size(); i11++) {
            sb2.append(" [");
            List<byte[]> list = this.f7815d.get(i11);
            for (int i12 = 0; i12 < list.size(); i12++) {
                sb2.append(" \"");
                sb2.append(Base64.encodeToString(list.get(i12), 0));
                sb2.append("\"");
            }
            sb2.append(" ]");
        }
        sb2.append("}");
        sb2.append("mCertificatesArray: " + this.f7816e);
        return sb2.toString();
    }
}
