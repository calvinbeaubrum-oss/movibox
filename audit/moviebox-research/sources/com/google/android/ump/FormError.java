package com.google.android.ump;

import androidx.annotation.RecentlyNonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class FormError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f38128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f38129b;

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ErrorCode {
        public static final int INTERNAL_ERROR = 1;
        public static final int INTERNET_ERROR = 2;
        public static final int INVALID_OPERATION = 3;
        public static final int TIME_OUT = 4;
    }

    public FormError(int i11, @RecentlyNonNull String str) {
        this.f38128a = i11;
        this.f38129b = str;
    }

    public int getErrorCode() {
        return this.f38128a;
    }

    @RecentlyNonNull
    public String getMessage() {
        return this.f38129b;
    }
}
