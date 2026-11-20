package com.google.firebase.crashlytics.buildtools.reloc.org.apache.http;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class HttpVersion extends ProtocolVersion {
    public static final String HTTP = "HTTP";
    public static final HttpVersion HTTP_0_9 = new HttpVersion(0, 9);
    public static final HttpVersion HTTP_1_0 = new HttpVersion(1, 0);
    public static final HttpVersion HTTP_1_1 = new HttpVersion(1, 1);
    private static final long serialVersionUID = -5856653513894415344L;

    public HttpVersion(int i11, int i12) {
        super(HTTP, i11, i12);
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.ProtocolVersion
    public ProtocolVersion forVersion(int i11, int i12) {
        if (i11 == this.major && i12 == this.minor) {
            return this;
        }
        if (i11 == 1) {
            if (i12 == 0) {
                return HTTP_1_0;
            }
            if (i12 == 1) {
                return HTTP_1_1;
            }
        }
        return (i11 == 0 && i12 == 9) ? HTTP_0_9 : new HttpVersion(i11, i12);
    }
}
