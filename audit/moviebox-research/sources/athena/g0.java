package athena;

import android.os.Message;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g0 extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f13642d = {"https://time1.google.com", "https://time.cloudflare.com", "https://www.pool.ntp.org"};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13643e = 0;

    @Override // athena.y
    public void a() throws Throwable {
        Message messageObtainMessage = this.f13770b.obtainMessage(503);
        messageObtainMessage.obj = 0L;
        while (true) {
            int i11 = this.f13643e;
            if (i11 >= 3) {
                break;
            }
            y0<Long> y0VarJ = v.j(f13642d[i11]);
            if (y0VarJ.f13772a == 0) {
                messageObtainMessage.obj = y0VarJ.f13773b;
                break;
            }
            this.f13643e++;
        }
        this.f13770b.sendMessageAtFrontOfQueue(messageObtainMessage);
    }

    @Override // athena.y
    public String d() {
        return "Retrieve-Time";
    }
}
