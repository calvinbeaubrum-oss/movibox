package on;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f72490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f72491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f72492e;

    public a(b.InterfaceC0782b interfaceC0782b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0782b);
        this.f72490c = new HashSet<>(hashSet);
        this.f72491d = jSONObject;
        this.f72492e = j11;
    }
}
