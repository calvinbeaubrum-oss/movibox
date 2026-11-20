package h4;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f66242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f66244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f66245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f66246e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f66247f;

    public a(long j11, int i11, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f66242a = j11;
        this.f66243b = i11;
        this.f66244c = Collections.unmodifiableList(list);
        this.f66245d = Collections.unmodifiableList(list2);
        this.f66246e = Collections.unmodifiableList(list3);
        this.f66247f = Collections.unmodifiableList(list4);
    }
}
