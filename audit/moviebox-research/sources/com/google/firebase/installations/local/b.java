package com.google.firebase.installations.local;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public static b f40708a = a().a();

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        @NonNull
        public abstract b a();

        @NonNull
        public abstract a b(@Nullable String str);

        @NonNull
        public abstract a c(long j11);

        @NonNull
        public abstract a d(@NonNull String str);

        @NonNull
        public abstract a e(@Nullable String str);

        @NonNull
        public abstract a f(@Nullable String str);

        @NonNull
        public abstract a g(@NonNull PersistedInstallation.RegistrationStatus registrationStatus);

        @NonNull
        public abstract a h(long j11);
    }

    @NonNull
    public static a a() {
        return new com.google.firebase.installations.local.a.b().h(0L).g(PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION).c(0L);
    }

    @Nullable
    public abstract String b();

    public abstract long c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract String f();

    @NonNull
    public abstract PersistedInstallation.RegistrationStatus g();

    public abstract long h();

    public boolean i() {
        return g() == PersistedInstallation.RegistrationStatus.REGISTER_ERROR;
    }

    public boolean j() {
        return g() == PersistedInstallation.RegistrationStatus.NOT_GENERATED || g() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    public boolean k() {
        return g() == PersistedInstallation.RegistrationStatus.REGISTERED;
    }

    public boolean l() {
        return g() == PersistedInstallation.RegistrationStatus.UNREGISTERED;
    }

    public boolean m() {
        return g() == PersistedInstallation.RegistrationStatus.ATTEMPT_MIGRATION;
    }

    @NonNull
    public abstract a n();

    @NonNull
    public b o(@NonNull String str, long j11, long j12) {
        return n().b(str).c(j11).h(j12).a();
    }

    @NonNull
    public b p() {
        return n().b(null).a();
    }

    @NonNull
    public b q(@NonNull String str) {
        return n().e(str).g(PersistedInstallation.RegistrationStatus.REGISTER_ERROR).a();
    }

    @NonNull
    public b r() {
        return n().g(PersistedInstallation.RegistrationStatus.NOT_GENERATED).a();
    }

    @NonNull
    public b s(@NonNull String str, @NonNull String str2, long j11, @Nullable String str3, long j12) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.REGISTERED).b(str3).f(str2).c(j12).h(j11).a();
    }

    @NonNull
    public b t(@NonNull String str) {
        return n().d(str).g(PersistedInstallation.RegistrationStatus.UNREGISTERED).a();
    }
}
