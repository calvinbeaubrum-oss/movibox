package h4;

import androidx.media3.extractor.metadata.emsg.EventMessage;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventMessage[] f66282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f66283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f66284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f66285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f66286e;

    public f(String str, String str2, long j11, long[] jArr, EventMessage[] eventMessageArr) {
        this.f66284c = str;
        this.f66285d = str2;
        this.f66286e = j11;
        this.f66283b = jArr;
        this.f66282a = eventMessageArr;
    }

    public String a() {
        return this.f66284c + "/" + this.f66285d;
    }
}
