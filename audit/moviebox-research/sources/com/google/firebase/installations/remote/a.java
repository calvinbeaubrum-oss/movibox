package com.google.firebase.installations.remote;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends InstallationResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f40711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TokenResult f40712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InstallationResponse.ResponseCode f40713e;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends InstallationResponse.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f40715b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40716c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TokenResult f40717d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public InstallationResponse.ResponseCode f40718e;

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse a() {
            return new a(this.f40714a, this.f40715b, this.f40716c, this.f40717d, this.f40718e);
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a b(TokenResult tokenResult) {
            this.f40717d = tokenResult;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a c(String str) {
            this.f40715b = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a d(String str) {
            this.f40716c = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a e(InstallationResponse.ResponseCode responseCode) {
            this.f40718e = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.InstallationResponse.a
        public InstallationResponse.a f(String str) {
            this.f40714a = str;
            return this;
        }
    }

    public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable TokenResult tokenResult, @Nullable InstallationResponse.ResponseCode responseCode) {
        this.f40709a = str;
        this.f40710b = str2;
        this.f40711c = str3;
        this.f40712d = tokenResult;
        this.f40713e = responseCode;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public TokenResult b() {
        return this.f40712d;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String c() {
        return this.f40710b;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String d() {
        return this.f40711c;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public InstallationResponse.ResponseCode e() {
        return this.f40713e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationResponse)) {
            return false;
        }
        InstallationResponse installationResponse = (InstallationResponse) obj;
        String str = this.f40709a;
        if (str != null ? str.equals(installationResponse.f()) : installationResponse.f() == null) {
            String str2 = this.f40710b;
            if (str2 != null ? str2.equals(installationResponse.c()) : installationResponse.c() == null) {
                String str3 = this.f40711c;
                if (str3 != null ? str3.equals(installationResponse.d()) : installationResponse.d() == null) {
                    TokenResult tokenResult = this.f40712d;
                    if (tokenResult != null ? tokenResult.equals(installationResponse.b()) : installationResponse.b() == null) {
                        InstallationResponse.ResponseCode responseCode = this.f40713e;
                        if (responseCode == null) {
                            if (installationResponse.e() == null) {
                                return true;
                            }
                        } else if (responseCode.equals(installationResponse.e())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.remote.InstallationResponse
    @Nullable
    public String f() {
        return this.f40709a;
    }

    public int hashCode() {
        String str = this.f40709a;
        int iHashCode = ((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003;
        String str2 = this.f40710b;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f40711c;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        TokenResult tokenResult = this.f40712d;
        int iHashCode4 = (iHashCode3 ^ (tokenResult == null ? 0 : tokenResult.hashCode())) * 1000003;
        InstallationResponse.ResponseCode responseCode = this.f40713e;
        return iHashCode4 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "InstallationResponse{uri=" + this.f40709a + ", fid=" + this.f40710b + ", refreshToken=" + this.f40711c + ", authToken=" + this.f40712d + ", responseCode=" + this.f40713e + "}";
    }
}
