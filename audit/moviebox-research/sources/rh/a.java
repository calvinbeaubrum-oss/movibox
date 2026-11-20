package rh;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f75384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f75385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<j> f75386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f75387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<e> f75388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<e> f75389f;

    public a(int i11, int i12, List<j> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f75384a = i11;
        this.f75385b = i12;
        this.f75386c = Collections.unmodifiableList(list);
        this.f75387d = Collections.unmodifiableList(list2);
        this.f75388e = Collections.unmodifiableList(list3);
        this.f75389f = Collections.unmodifiableList(list4);
    }
}
