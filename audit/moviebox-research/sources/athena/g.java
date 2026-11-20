package athena;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.transsion.athena.data.TrackData;
import com.transsion.ga.AthenaAnalytics;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f13641a;

    public g(Handler handler) {
        this.f13641a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        String strA;
        Context contextA = ws.a.a();
        m0 m0VarA = m0.a(contextA);
        String strI = m0VarA.i("athena_id");
        try {
            strA = w.b(contextA).a();
        } catch (Exception e11) {
            a0.b("%s", e11.getMessage());
            strA = null;
        }
        if (!TextUtils.isEmpty(strA) && !TextUtils.equals(strI, strA)) {
            m0VarA.g("athena_id", strA);
            if (!TextUtils.isEmpty(strI)) {
                try {
                    if (j0.g(contextA, "android.permission.READ_PHONE_STATE") || j0.g(contextA, "android.permission.READ_PRIVILEGED_PHONE_STATE")) {
                        if (AthenaAnalytics.H() || (!j0.t(contextA))) {
                            if (TextUtils.isEmpty(com.transsion.ga.g.j())) {
                                AthenaAnalytics.z(9999).Q("data_discard", new TrackData().add("en", "device_id_transfer", 2).add("cnt", 1, 1), 9999);
                            } else {
                                AthenaAnalytics.z(9999).Q("device_id_transfer", new TrackData().add("pre_gaid", strI).add("sn", com.transsion.ga.g.j()), 9999);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }
            strI = strA;
        }
        if (!TextUtils.isEmpty(strI)) {
            j0.n(strI);
        }
        if (TextUtils.isEmpty(strI) && TextUtils.isEmpty(com.transsion.ga.g.b(0))) {
            a0.b("%s", "device gaid and iid are null");
        }
        this.f13641a.postDelayed(this, 7200000L);
    }
}
