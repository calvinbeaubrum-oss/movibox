package sh;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements com.google.android.exoplayer2.offline.c<e> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f76359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f76360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f76361c;

    public e(String str, List<String> list, boolean z11) {
        this.f76359a = str;
        this.f76360b = Collections.unmodifiableList(list);
        this.f76361c = z11;
    }
}
