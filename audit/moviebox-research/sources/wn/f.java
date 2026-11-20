package wn;

import android.text.TextUtils;
import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f extends a {
    public f(b.InterfaceC0893b interfaceC0893b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0893b, hashSet, jSONObject, j11);
    }

    private void e(String str) {
        com.iab.omid.library.vungle.b.a aVarA = com.iab.omid.library.vungle.b.a.a();
        if (aVarA != null) {
            for (sn.f fVar : aVarA.c()) {
                if (this.f79560c.contains(fVar.j())) {
                    fVar.k().d(str, this.f79562e);
                }
            }
        }
    }

    @Override // wn.b, android.os.AsyncTask
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
        if (un.b.l(this.f79561d, this.f79564b.b())) {
            return null;
        }
        this.f79564b.a(this.f79561d);
        return this.f79561d.toString();
    }
}
