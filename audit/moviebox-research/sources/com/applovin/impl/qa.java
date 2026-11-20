package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface qa extends i5 {

    /* JADX INFO: compiled from: source.java */
    public static final class a extends c {
        public a(IOException iOException, l5 l5Var) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, l5Var, 2007, 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b extends i5.a {
        @Override // com.applovin.impl.i5.a
        qa a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c extends j5 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final l5 f21919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21920c;

        public c(l5 l5Var, int i11, int i12) {
            super(a(i11, i12));
            this.f21919b = l5Var;
            this.f21920c = i12;
        }

        public c(IOException iOException, l5 l5Var, int i11, int i12) {
            super(iOException, a(i11, i12));
            this.f21919b = l5Var;
            this.f21920c = i12;
        }

        public c(String str, l5 l5Var, int i11, int i12) {
            super(str, a(i11, i12));
            this.f21919b = l5Var;
            this.f21920c = i12;
        }

        public c(String str, IOException iOException, l5 l5Var, int i11, int i12) {
            super(str, iOException, a(i11, i12));
            this.f21919b = l5Var;
            this.f21920c = i12;
        }

        private static int a(int i11, int i12) {
            if (i11 == 2000 && i12 == 1) {
                return 2001;
            }
            return i11;
        }

        public static c a(IOException iOException, l5 l5Var, int i11) {
            int i12;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i12 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i12 = 1004;
            } else {
                i12 = (message == null || !Ascii.toLowerCase(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            }
            return i12 == 2007 ? new a(iOException, l5Var) : new c(iOException, l5Var, i12, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f21921d;

        public d(String str, l5 l5Var) {
            super("Invalid content type: " + str, l5Var, 2003, 1);
            this.f21921d = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21922d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f21923f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Map f21924g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final byte[] f21925h;

        public e(int i11, String str, IOException iOException, Map map, l5 l5Var, byte[] bArr) {
            super("Response code: " + i11, iOException, l5Var, 2004, 1);
            this.f21922d = i11;
            this.f21923f = str;
            this.f21924g = map;
            this.f21925h = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f21926a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map f21927b;

        public synchronized Map a() {
            try {
                if (this.f21927b == null) {
                    this.f21927b = Collections.unmodifiableMap(new HashMap(this.f21926a));
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return this.f21927b;
        }
    }
}
