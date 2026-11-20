package com.google.android.datatransport.runtime.backends;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends BackendResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BackendResponse.Status f32607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32608b;

    public a(BackendResponse.Status status, long j11) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f32607a = status;
        this.f32608b = j11;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f32608b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f32607a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BackendResponse)) {
            return false;
        }
        BackendResponse backendResponse = (BackendResponse) obj;
        return this.f32607a.equals(backendResponse.c()) && this.f32608b == backendResponse.b();
    }

    public int hashCode() {
        int iHashCode = (this.f32607a.hashCode() ^ 1000003) * 1000003;
        long j11 = this.f32608b;
        return iHashCode ^ ((int) (j11 ^ (j11 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f32607a + ", nextRequestWaitMillis=" + this.f32608b + "}";
    }
}
