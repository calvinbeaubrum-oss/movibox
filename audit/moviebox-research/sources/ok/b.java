package ok;

import com.google.firebase.crashlytics.internal.common.l;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class b implements f {
    public static d b(l lVar) {
        return new d(lVar.a() + ((long) 3600000), new d.b(8, 4), new d.a(true, false), 0, 3600, 10.0d, 1.2d, 60);
    }

    @Override // ok.f
    public d a(l lVar, JSONObject jSONObject) {
        return b(lVar);
    }
}
