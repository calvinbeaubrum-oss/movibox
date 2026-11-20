package athena;

import android.os.Message;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class f0 extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final br.e f13639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ar.c f13640f;

    public f0(String str, br.e eVar, ar.c cVar) {
        this.f13638d = str;
        this.f13639e = eVar;
        this.f13640f = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        ar.c cVar = this.f13640f;
        if (cVar != null) {
            cVar.a(0, false);
        }
    }

    @Override // athena.y
    public void a() {
        y0<String> y0VarB = v.b(this.f13638d, "", this.f13639e.B(), 0);
        if (y0VarB.f13772a == -1 && br.d.k(this.f13639e.i()) && br.g.G() && !this.f13770b.hasMessages(298)) {
            Message messageObtainMessage = this.f13770b.obtainMessage(298);
            messageObtainMessage.arg1 = 1;
            this.f13770b.sendMessageDelayed(messageObtainMessage, 300000L);
            return;
        }
        int i11 = y0VarB.f13772a;
        if (i11 == 0) {
            String str = y0VarB.f13773b;
            a0.f("<-- globalConfig:%s", str);
            ar.b.a().h(str);
            this.f13639e.k(System.currentTimeMillis() + this.f13639e.o());
            this.f13770b.postAtFrontOfQueue(new Runnable() { // from class: athena.m
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13720a.e();
                }
            });
        } else if (i11 != 1) {
            br.e eVar = this.f13639e;
            eVar.p(eVar.s() + 1);
        } else {
            a0.f("<-- globalConfig:%s", "NOT_MODIFIED");
            this.f13639e.k(System.currentTimeMillis() + this.f13639e.o());
        }
        ar.b.a().w();
    }

    @Override // athena.y
    public String d() {
        return "Retrieve-Global-Config";
    }
}
