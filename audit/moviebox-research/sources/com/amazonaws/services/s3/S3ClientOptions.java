package com.amazonaws.services.s3;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class S3ClientOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f15931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f15934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f15935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f15936f;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f15937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f15939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f15940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f15941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f15942f;

        private Builder() {
            this.f15937a = false;
            this.f15938b = false;
            this.f15939c = false;
            this.f15940d = false;
            this.f15941e = false;
            this.f15942f = false;
        }

        public S3ClientOptions a() {
            return new S3ClientOptions(this.f15937a, this.f15938b, this.f15939c, this.f15940d, this.f15941e, this.f15942f);
        }

        public Builder b(boolean z11) {
            this.f15940d = z11;
            return this;
        }

        public Builder c(boolean z11) {
            this.f15938b = z11;
            return this;
        }
    }

    @Deprecated
    public S3ClientOptions() {
        this.f15931a = false;
        this.f15932b = false;
        this.f15933c = false;
        this.f15934d = false;
        this.f15935e = false;
        this.f15936f = false;
    }

    @Deprecated
    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.f15931a = s3ClientOptions.f15931a;
        this.f15932b = s3ClientOptions.f15932b;
        this.f15933c = s3ClientOptions.f15933c;
        this.f15934d = s3ClientOptions.f15934d;
        this.f15935e = s3ClientOptions.f15935e;
        this.f15936f = s3ClientOptions.f15936f;
    }

    public S3ClientOptions(boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f15931a = z11;
        this.f15932b = z12;
        this.f15933c = z13;
        this.f15934d = z14;
        this.f15935e = z15;
        this.f15936f = z16;
    }

    public static Builder a() {
        return new Builder();
    }

    public boolean b() {
        return this.f15934d;
    }

    public boolean c() {
        return this.f15931a;
    }

    public boolean d() {
        return this.f15936f;
    }

    public boolean e() {
        return this.f15932b;
    }
}
