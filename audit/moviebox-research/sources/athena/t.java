package athena;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f13747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f13749c;

    public t(long j11, long j12, String str) {
        this.f13747a = j11;
        this.f13748b = j12;
        this.f13749c = str;
    }

    public t(String str) throws Exception {
        JSONObject jSONObject = new JSONObject(str);
        this.f13747a = jSONObject.getLong("serverTime");
        this.f13748b = jSONObject.getLong("elapsedRealtime");
        this.f13749c = jSONObject.getString("bootId");
    }
}
