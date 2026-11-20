package io;

import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f67301a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f67302b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f67303c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f67304d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f67305e;

    static {
        int iC = d.c(6L);
        f67301a = iC;
        f67302b = d.b(0, iC - 1);
        f67303c = (1 << (32 - iC)) - 1;
        f67304d = Math.max(j.b(-1L), Math.max(j.b(j.d(Long.MAX_VALUE)), j.b(j.d(Long.MIN_VALUE))));
        f67305e = Math.max(j.b(fo.c.a(-1)), Math.max(j.b(j.c(Api.BaseClientBuilder.API_PRIORITY_OTHER)), j.b(j.c(Integer.MIN_VALUE))));
    }
}
