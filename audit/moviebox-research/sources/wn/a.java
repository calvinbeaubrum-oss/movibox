package wn;

import java.util.HashSet;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f79560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f79561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f79562e;

    public a(b.InterfaceC0893b interfaceC0893b, HashSet<String> hashSet, JSONObject jSONObject, long j11) {
        super(interfaceC0893b);
        this.f79560c = new HashSet<>(hashSet);
        this.f79561d = jSONObject;
        this.f79562e = j11;
    }
}
