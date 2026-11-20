package cj;

import com.google.android.play.core.install.InstallState;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b extends InstallState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f14930e;

    public b(int i11, long j11, long j12, int i12, String str) {
        this.f14926a = i11;
        this.f14927b = j11;
        this.f14928c = j12;
        this.f14929d = i12;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.f14930e = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long a() {
        return this.f14927b;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int b() {
        return this.f14929d;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int c() {
        return this.f14926a;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String d() {
        return this.f14930e;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long e() {
        return this.f14928c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.f14926a == installState.c() && this.f14927b == installState.a() && this.f14928c == installState.e() && this.f14929d == installState.b() && this.f14930e.equals(installState.d())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i11 = this.f14926a ^ 1000003;
        long j11 = this.f14927b;
        long j12 = this.f14928c;
        return (((((((i11 * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003) ^ ((int) ((j12 >>> 32) ^ j12))) * 1000003) ^ this.f14929d) * 1000003) ^ this.f14930e.hashCode();
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.f14926a + ", bytesDownloaded=" + this.f14927b + ", totalBytesToDownload=" + this.f14928c + ", installErrorCode=" + this.f14929d + ", packageName=" + this.f14930e + "}";
    }
}
