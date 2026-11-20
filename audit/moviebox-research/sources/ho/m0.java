package ho;

import android.content.Context;
import android.net.http.HttpEngine;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m0 extends j {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final HttpEngine f66735t;

    public m0(p007do.m mVar, Context context, j.a aVar) {
        super(mVar, aVar);
        this.f66735t = d0.a(context).setEnableHttp2(true).setEnableQuic(true).setEnableHttpCache(0, 0L).setDnsOptions(e0.a().setStaleDns(2).setUseHttpStackDnsResolver(1).build()).setConnectionMigrationOptions(f0.a().setAllowNonDefaultNetworkUsage(1).setDefaultNetworkMigration(1).setPathDegradationMigration(1).build()).build();
    }

    @Override // ho.j
    public final HttpURLConnection m(URL url) {
        url.toString();
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.f66735t.openConnection(url);
        httpURLConnection.setReadTimeout(this.f66688f);
        return httpURLConnection;
    }
}
