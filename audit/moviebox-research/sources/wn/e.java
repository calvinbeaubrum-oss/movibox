package wn;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a {
    public e(b.InterfaceC0893b interfaceC0893b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0893b, hashSet, jSONObject, j11);
    }

    @Override // wn.b, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(String str) {
        e(str);
        super.onPostExecute(str);
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Object... objArr) {
        return this.f79561d.toString();
    }

    public final void e(String str) {
        com.iab.omid.library.vungle.b.a aVarA = com.iab.omid.library.vungle.b.a.a();
        if (aVarA != null) {
            for (sn.f fVar : aVarA.c()) {
                if (this.f79560c.contains(fVar.j())) {
                    fVar.k().j(str, this.f79562e);
                }
            }
        }
    }
}
