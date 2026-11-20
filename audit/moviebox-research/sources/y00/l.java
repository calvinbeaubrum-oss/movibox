package y00;

import android.text.TextUtils;
import com.vungle.warren.AdLoader;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.log.LogManager;
import com.vungle.warren.persistence.Repository;
import com.vungle.warren.tasks.UnknownTagException;
import com.vungle.warren.y;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class l implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Repository f81056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.vungle.warren.persistence.d f81057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i.a f81058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VungleApiClient f81059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final s00.a f81060e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AdLoader f81061f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f81062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LogManager f81063h;

    public l(Repository repository, com.vungle.warren.persistence.d dVar, VungleApiClient vungleApiClient, s00.a aVar, i.a aVar2, AdLoader adLoader, y yVar, LogManager logManager) {
        this.f81056a = repository;
        this.f81057b = dVar;
        this.f81058c = aVar2;
        this.f81059d = vungleApiClient;
        this.f81060e = aVar;
        this.f81061f = adLoader;
        this.f81062g = yVar;
        this.f81063h = logManager;
    }

    @Override // y00.f
    public e a(String str) throws UnknownTagException {
        if (TextUtils.isEmpty(str)) {
            throw new UnknownTagException("Job tag is null");
        }
        if (str.startsWith(i.f81049b)) {
            return new i(this.f81058c);
        }
        if (str.startsWith(d.f81037c)) {
            return new d(this.f81061f, this.f81062g);
        }
        if (str.startsWith(k.f81053c)) {
            return new k(this.f81056a, this.f81059d);
        }
        if (str.startsWith(c.f81033d)) {
            return new c(this.f81057b, this.f81056a, this.f81061f);
        }
        if (str.startsWith(a.f81026b)) {
            return new a(this.f81060e);
        }
        if (str.startsWith(j.f81051b)) {
            return new j(this.f81063h);
        }
        if (str.startsWith(b.f81028d)) {
            return new b(this.f81059d, this.f81056a, this.f81061f);
        }
        throw new UnknownTagException("Unknown Job Type " + str);
    }
}
