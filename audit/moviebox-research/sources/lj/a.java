package lj;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, kj.b> f70301a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f70302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bl.b<nj.a> f70303c;

    public a(Context context, bl.b<nj.a> bVar) {
        this.f70302b = context;
        this.f70303c = bVar;
    }

    public kj.b a(String str) {
        return new kj.b(this.f70302b, this.f70303c, str);
    }

    public synchronized kj.b b(String str) {
        try {
            if (!this.f70301a.containsKey(str)) {
                this.f70301a.put(str, a(str));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f70301a.get(str);
    }
}
