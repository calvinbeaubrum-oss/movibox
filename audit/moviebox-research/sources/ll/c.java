package ll;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cg.h;
import cl.g;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.metrics.i;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vl.k;
import yl.m;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ql.a f70308i = ql.a.e();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f70309a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nl.a f70310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.firebase.perf.util.d f70311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public Boolean f70312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final jj.e f70313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bl.b<m> f70314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g f70315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bl.b<h> f70316h;

    public c(jj.e eVar, bl.b<m> bVar, g gVar, bl.b<h> bVar2, RemoteConfigManager remoteConfigManager, nl.a aVar, SessionManager sessionManager) {
        this.f70312d = null;
        this.f70313e = eVar;
        this.f70314f = bVar;
        this.f70315g = gVar;
        this.f70316h = bVar2;
        if (eVar == null) {
            this.f70312d = Boolean.FALSE;
            this.f70310b = aVar;
            this.f70311c = new com.google.firebase.perf.util.d(new Bundle());
            return;
        }
        k.k().r(eVar, gVar, bVar2);
        Context contextJ = eVar.j();
        com.google.firebase.perf.util.d dVarA = a(contextJ);
        this.f70311c = dVarA;
        remoteConfigManager.setFirebaseRemoteConfigProvider(bVar);
        this.f70310b = aVar;
        aVar.Q(dVarA);
        aVar.O(contextJ);
        sessionManager.setApplicationContext(contextJ);
        this.f70312d = aVar.j();
        ql.a aVar2 = f70308i;
        if (aVar2.h() && d()) {
            aVar2.f(String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", ql.b.b(eVar.m().e(), contextJ.getPackageName())));
        }
    }

    public static com.google.firebase.perf.util.d a(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No perf enable meta data found ");
            sb2.append(e11.getMessage());
            bundle = null;
        }
        return bundle != null ? new com.google.firebase.perf.util.d(bundle) : new com.google.firebase.perf.util.d();
    }

    @NonNull
    public static c c() {
        return (c) jj.e.k().i(c.class);
    }

    @NonNull
    public Map<String, String> b() {
        return new HashMap(this.f70309a);
    }

    public boolean d() {
        Boolean bool = this.f70312d;
        return bool != null ? bool.booleanValue() : jj.e.k().s();
    }

    @NonNull
    public i e(@NonNull String str, @NonNull String str2) {
        return new i(str, str2, k.k(), new Timer());
    }
}
