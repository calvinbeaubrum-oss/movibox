package com.google.firebase.installations.remote;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class b extends TokenResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f40720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TokenResult.ResponseCode f40721c;

    /* JADX INFO: renamed from: com.google.firebase.installations.remote.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0448b extends TokenResult.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Long f40723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public TokenResult.ResponseCode f40724c;

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult a() {
            String str = "";
            if (this.f40723b == null) {
                str = " tokenExpirationTimestamp";
            }
            if (str.isEmpty()) {
                return new b(this.f40722a, this.f40723b.longValue(), this.f40724c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a b(TokenResult.ResponseCode responseCode) {
            this.f40724c = responseCode;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a c(String str) {
            this.f40722a = str;
            return this;
        }

        @Override // com.google.firebase.installations.remote.TokenResult.a
        public TokenResult.a d(long j11) {
            this.f40723b = Long.valueOf(j11);
            return this;
        }
    }

    public b(@Nullable String str, long j11, @Nullable TokenResult.ResponseCode responseCode) {
        this.f40719a = str;
        this.f40720b = j11;
        this.f40721c = responseCode;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public TokenResult.ResponseCode b() {
        return this.f40721c;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @Nullable
    public String c() {
        return this.f40719a;
    }

    @Override // com.google.firebase.installations.remote.TokenResult
    @NonNull
    public long d() {
        return this.f40720b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TokenResult)) {
            return false;
        }
        TokenResult tokenResult = (TokenResult) obj;
        String str = this.f40719a;
        if (str != null ? str.equals(tokenResult.c()) : tokenResult.c() == null) {
            if (this.f40720b == tokenResult.d()) {
                TokenResult.ResponseCode responseCode = this.f40721c;
                if (responseCode == null) {
                    if (tokenResult.b() == null) {
                        return true;
                    }
                } else if (responseCode.equals(tokenResult.b())) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f40719a;
        int iHashCode = str == null ? 0 : str.hashCode();
        long j11 = this.f40720b;
        int i11 = (((iHashCode ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        TokenResult.ResponseCode responseCode = this.f40721c;
        return i11 ^ (responseCode != null ? responseCode.hashCode() : 0);
    }

    public String toString() {
        return "TokenResult{token=" + this.f40719a + ", tokenExpirationTimestamp=" + this.f40720b + ", responseCode=" + this.f40721c + "}";
    }
}
