package on;

import android.text.TextUtils;
import java.util.HashSet;
import kn.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends a {
    public f(b.InterfaceC0782b interfaceC0782b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0782b, hashSet, jSONObject, j11);
    }

    private void e(String str) {
        com.iab.omid.library.mmadbridge.internal.c cVarE = com.iab.omid.library.mmadbridge.internal.c.e();
        if (cVarE != null) {
            for (g gVar : cVarE.c()) {
                if (this.f72490c.contains(gVar.v())) {
                    gVar.w().p(str, this.f72492e);
                }
            }
        }
    }

    @Override // on.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            e(str);
        }
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        if (nn.c.u(this.f72491d, this.f72494b.a())) {
            return null;
        }
        this.f72494b.a(this.f72491d);
        return this.f72491d.toString();
    }
}
