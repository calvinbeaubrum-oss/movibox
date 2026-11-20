package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a extends com.google.firebase.installations.local.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PersistedInstallation.RegistrationStatus f40695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f40696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f40697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f40698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f40699g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f40700h;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends com.google.firebase.installations.local.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f40701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PersistedInstallation.RegistrationStatus f40702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f40703c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f40704d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Long f40705e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Long f40706f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f40707g;

        public b() {
        }

        public b(com.google.firebase.installations.local.b bVar) {
            this.f40701a = bVar.d();
            this.f40702b = bVar.g();
            this.f40703c = bVar.b();
            this.f40704d = bVar.f();
            this.f40705e = Long.valueOf(bVar.c());
            this.f40706f = Long.valueOf(bVar.h());
            this.f40707g = bVar.e();
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b a() {
            String str = "";
            if (this.f40702b == null) {
                str = " registrationStatus";
            }
            if (this.f40705e == null) {
                str = str + " expiresInSecs";
            }
            if (this.f40706f == null) {
                str = str + " tokenCreationEpochInSecs";
            }
            if (str.isEmpty()) {
                return new a(this.f40701a, this.f40702b, this.f40703c, this.f40704d, this.f40705e.longValue(), this.f40706f.longValue(), this.f40707g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a b(@Nullable String str) {
            this.f40703c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a c(long j11) {
            this.f40705e = Long.valueOf(j11);
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a d(String str) {
            this.f40701a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a e(@Nullable String str) {
            this.f40707g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a f(@Nullable String str) {
            this.f40704d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f40702b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.b.a
        public com.google.firebase.installations.local.b.a h(long j11) {
            this.f40706f = Long.valueOf(j11);
            return this;
        }
    }

    public a(@Nullable String str, PersistedInstallation.RegistrationStatus registrationStatus, @Nullable String str2, @Nullable String str3, long j11, long j12, @Nullable String str4) {
        this.f40694b = str;
        this.f40695c = registrationStatus;
        this.f40696d = str2;
        this.f40697e = str3;
        this.f40698f = j11;
        this.f40699g = j12;
        this.f40700h = str4;
    }

    @Override // com.google.firebase.installations.local.b
    @Nullable
    public String b() {
        return this.f40696d;
    }

    @Override // com.google.firebase.installations.local.b
    public long c() {
        return this.f40698f;
    }

    @Override // com.google.firebase.installations.local.b
    @Nullable
    public String d() {
        return this.f40694b;
    }

    @Override // com.google.firebase.installations.local.b
    @Nullable
    public String e() {
        return this.f40700h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof com.google.firebase.installations.local.b)) {
            return false;
        }
        com.google.firebase.installations.local.b bVar = (com.google.firebase.installations.local.b) obj;
        String str3 = this.f40694b;
        if (str3 != null ? str3.equals(bVar.d()) : bVar.d() == null) {
            if (this.f40695c.equals(bVar.g()) && ((str = this.f40696d) != null ? str.equals(bVar.b()) : bVar.b() == null) && ((str2 = this.f40697e) != null ? str2.equals(bVar.f()) : bVar.f() == null) && this.f40698f == bVar.c() && this.f40699g == bVar.h()) {
                String str4 = this.f40700h;
                if (str4 == null) {
                    if (bVar.e() == null) {
                        return true;
                    }
                } else if (str4.equals(bVar.e())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.b
    @Nullable
    public String f() {
        return this.f40697e;
    }

    @Override // com.google.firebase.installations.local.b
    @NonNull
    public PersistedInstallation.RegistrationStatus g() {
        return this.f40695c;
    }

    @Override // com.google.firebase.installations.local.b
    public long h() {
        return this.f40699g;
    }

    public int hashCode() {
        String str = this.f40694b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f40695c.hashCode()) * 1000003;
        String str2 = this.f40696d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f40697e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j11 = this.f40698f;
        int i11 = (iHashCode3 ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f40699g;
        int i12 = (i11 ^ ((int) (j12 ^ (j12 >>> 32)))) * 1000003;
        String str4 = this.f40700h;
        return i12 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.local.b
    public com.google.firebase.installations.local.b.a n() {
        return new b(this);
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f40694b + ", registrationStatus=" + this.f40695c + ", authToken=" + this.f40696d + ", refreshToken=" + this.f40697e + ", expiresInSecs=" + this.f40698f + ", tokenCreationEpochInSecs=" + this.f40699g + ", fisError=" + this.f40700h + "}";
    }
}
