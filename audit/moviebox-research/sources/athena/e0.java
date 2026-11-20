package athena;

import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class e0 extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final br.b f13632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f13633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f13634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f13635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f13636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ar.c f13637j;

    public e0(int i11, br.b bVar, String str, long j11, int i12, long j12, ar.c cVar) {
        this.f13631d = i11;
        this.f13632e = bVar;
        this.f13633f = str;
        this.f13634g = j11;
        this.f13635h = i12;
        this.f13636i = j12;
        this.f13637j = cVar;
    }

    @Override // athena.y
    public void a() {
        String string;
        try {
            JSONObject jSONObjectF = br.d.f();
            jSONObjectF.put("sname", String.valueOf(this.f13631d));
            jSONObjectF.put("sdkver", br.g.a(this.f13631d));
            string = jSONObjectF.toString();
        } catch (Exception e11) {
            a0.c(e11.getMessage());
            string = "";
        }
        y0<String> y0VarB = v.b(this.f13633f, string, this.f13634g, this.f13631d);
        int i11 = y0VarB.f13772a;
        boolean z11 = false;
        if (i11 == 0) {
            String str = y0VarB.f13773b;
            a0.f("<-- appIdConfig:%s", str);
            ar.b.a().g(this.f13632e, str);
            this.f13632e.i(this.f13635h);
            if (this.f13632e.k() > 0) {
                this.f13636i = ((long) this.f13632e.k()) * 3600000;
            }
            this.f13632e.j(System.currentTimeMillis() + this.f13636i);
            z11 = true;
        } else if (i11 != 1) {
            br.b bVar = this.f13632e;
            bVar.s(bVar.t() + 1);
        } else {
            a0.f("<-- appIdConfig:%s", "NOT_MODIFIED");
            this.f13632e.i(this.f13635h);
            this.f13632e.j(System.currentTimeMillis() + this.f13636i);
        }
        ar.c cVar = this.f13637j;
        if (cVar != null) {
            cVar.a(this.f13632e.a(), z11);
        }
    }

    @Override // athena.y
    public String d() {
        return "Retrieve-" + this.f13631d + "-Config";
    }
}
