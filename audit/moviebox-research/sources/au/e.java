package au;

import android.text.TextUtils;
import com.transsion.http.request.HttpMethod;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class e extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f13794m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public com.transsion.http.request.a f13795n;

    public e(String str, Object obj, HttpMethod httpMethod, Map<String, String> map, String str2, boolean z11, int i11, int i12, boolean z12, com.transsion.http.request.a aVar, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, boolean z13) {
        super(str, obj, httpMethod, map, z11, i11, i12, z12, sSLSocketFactory, hostnameVerifier, z13);
        this.f13794m = str2;
        this.f13795n = aVar;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("the content can not be null !");
        }
        zt.a.f82154a.d("post", "post url:" + str);
        zt.a.f82154a.d("post", "post content:" + str2);
    }

    @Override // au.c
    public f b() {
        return this.f13790l.g(this.f13794m).e(this.f13795n).l();
    }
}
