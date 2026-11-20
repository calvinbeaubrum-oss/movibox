package k20;

import com.google.gson.Gson;
import com.transsion.sdk.oneid.data.IdChangeInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<IdChangeInfo> f68221a;

    public h(ArrayList<IdChangeInfo> arrayList) {
        this.f68221a = arrayList;
    }

    public i<String> a() {
        return f.a(l.d().a(), new Gson().toJson(this.f68221a), 0);
    }
}
