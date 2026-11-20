package com.google.android.datatransport.runtime;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.datatransport.Priority;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        public abstract o a();

        public abstract a b(String str);

        public abstract a c(@Nullable byte[] bArr);

        public abstract a d(Priority priority);
    }

    public static a a() {
        return new d.b().d(Priority.DEFAULT);
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    public abstract Priority d();

    public boolean e() {
        return c() != null;
    }

    public o f(Priority priority) {
        return a().b(b()).d(priority).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
