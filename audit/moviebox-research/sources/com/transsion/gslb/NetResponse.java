package com.transsion.gslb;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class NetResponse<T> {
    public static final String EMPTY_RESPONSE = "{}";
    public int code;
    public T data;

    /* JADX INFO: compiled from: source.java */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ResponseCode {
        public static final int ERROR = -1;
        public static final int NOT_MODIFIED = 1;
        public static final int OK = 0;
        public static final int SDK_ERROR = 2;
    }

    public NetResponse(int i11, T t11) {
        this.code = i11;
        this.data = t11;
    }
}
