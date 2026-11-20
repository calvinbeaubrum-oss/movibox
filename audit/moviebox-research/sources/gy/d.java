package gy;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.w;
import com.transsion.transfer.androidasync.u;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Headers f65633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Multimap f65634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f65635c;

    public d(Headers headers) {
        this.f65635c = -1L;
        this.f65633a = headers;
        this.f65634b = Multimap.parseSemicolonDelimited(headers.c(HttpHeaders.CONTENT_DISPOSITION));
    }

    public d(String str, long j11, List<w> list) {
        this.f65635c = j11;
        this.f65633a = new Headers();
        StringBuilder sb2 = new StringBuilder(String.format(Locale.ENGLISH, "form-data; name=\"%s\"", str));
        if (list != null) {
            for (w wVar : list) {
                sb2.append(String.format(Locale.ENGLISH, "; %s=\"%s\"", wVar.getName(), wVar.getValue()));
            }
        }
        this.f65633a.f(HttpHeaders.CONTENT_DISPOSITION, sb2.toString());
        this.f65634b = Multimap.parseSemicolonDelimited(this.f65633a.c(HttpHeaders.CONTENT_DISPOSITION));
    }

    public String a() {
        return this.f65634b.getString("name");
    }

    public Headers b() {
        return this.f65633a;
    }

    public long c() {
        return this.f65635c;
    }

    public void d(u uVar, fy.a aVar) {
    }
}
