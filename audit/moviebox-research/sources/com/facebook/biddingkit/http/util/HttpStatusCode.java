package com.facebook.biddingkit.http.util;

import com.google.logging.type.LogSeverity;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum HttpStatusCode {
    SUCCESS(200),
    NO_BID(204),
    BAD_REQUEST(LogSeverity.WARNING_VALUE),
    TIMEOUT(504),
    UNKNOWN(-1);

    private int mStatusCode;

    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32455a;

        static {
            int[] iArr = new int[HttpStatusCode.values().length];
            f32455a = iArr;
            try {
                iArr[HttpStatusCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32455a[HttpStatusCode.NO_BID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32455a[HttpStatusCode.BAD_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32455a[HttpStatusCode.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HttpStatusCode(int i11) {
        this.mStatusCode = i11;
    }

    public static HttpStatusCode getValue(int i11) {
        for (HttpStatusCode httpStatusCode : values()) {
            if (httpStatusCode.mStatusCode == i11) {
                return httpStatusCode;
            }
        }
        return UNKNOWN;
    }

    public String getErrorMessage() {
        int i11 = a.f32455a[ordinal()];
        if (i11 == 1) {
            return "";
        }
        if (i11 == 2) {
            return "No bid";
        }
        if (i11 != 3) {
            return i11 != 4 ? "Unknown error" : "Server timeout";
        }
        return "Invalid request";
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
