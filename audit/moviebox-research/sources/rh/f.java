package rh;

import com.google.android.exoplayer2.metadata.emsg.EventMessage;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventMessage[] f75424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f75425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f75426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f75427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f75428e;

    public f(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        this.f75426c = str;
        this.f75427d = str2;
        this.f75428e = j11;
        this.f75425b = jArr;
        this.f75424a = eventMessageArr;
    }

    public String a() {
        return this.f75426c + "/" + this.f75427d;
    }
}
