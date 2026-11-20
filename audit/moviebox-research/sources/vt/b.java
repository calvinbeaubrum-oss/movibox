package vt;

import au.f;
import au.g;
import com.transsion.http.impl.s;
import wt.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public xt.a f79107a = new xt.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f79108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f79109c;

    public b(au.c cVar) {
        this.f79109c = cVar.c();
    }

    public void a(s sVar) {
        this.f79107a.a(this, sVar);
    }

    public h b() {
        if (this.f79109c.e() != null) {
            wt.c cVar = new wt.c(this.f79109c.e());
            int i11 = a.f79106b;
            long j11 = i11 <= 0 ? 104857600L : i11 * 1048576;
            int i12 = a.f79105a;
            this.f79108b = cVar.a(j11, i12 <= 0 ? 864000000L : i12 * 3600000);
        }
        return this.f79108b;
    }

    public f c() {
        return this.f79109c;
    }

    public g d() {
        return new g(this.f79109c);
    }
}
