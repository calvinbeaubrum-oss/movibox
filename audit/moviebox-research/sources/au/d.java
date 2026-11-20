package au;

import android.content.Context;
import com.transsion.http.request.HttpMethod;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d extends c {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f13791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Context f13792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f13793o;

    public d(Context context, String str, boolean z11, Object obj, HttpMethod httpMethod, Map<String, String> map, boolean z12, int i11, int i12, boolean z13, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, boolean z14, boolean z15) {
        super(str, obj, httpMethod, map, z12, i11, i12, z13, sSLSocketFactory, hostnameVerifier, z15);
        this.f13791m = z11;
        this.f13792n = context;
        this.f13793o = z14;
        zt.a.f82154a.d("image", "origin image url:" + str);
    }

    @Override // au.c
    public f b() {
        return this.f13790l.q(this.f13791m).k(this.f13793o).c(this.f13792n).l();
    }
}
