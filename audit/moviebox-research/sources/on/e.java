package on;

import java.util.HashSet;
import kn.g;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a {
    public e(b.InterfaceC0782b interfaceC0782b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0782b, hashSet, jSONObject, j11);
    }

    @Override // on.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f72491d.toString();
    }

    public final void e(String str) {
        com.iab.omid.library.mmadbridge.internal.c cVarE = com.iab.omid.library.mmadbridge.internal.c.e();
        if (cVarE != null) {
            for (g gVar : cVarE.c()) {
                if (this.f72490c.contains(gVar.v())) {
                    gVar.w().f(str, this.f72492e);
                }
            }
        }
    }
}
