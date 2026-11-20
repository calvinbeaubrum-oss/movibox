package com.google.android.play.core.appupdate;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: compiled from: source.java */
    public static abstract class a {
        @NonNull
        public abstract d a();

        @NonNull
        public abstract a b(boolean z11);
    }

    @NonNull
    public static d c(int i11) {
        return d(i11).a();
    }

    @NonNull
    public static a d(int i11) {
        y yVar = new y();
        yVar.c(i11);
        yVar.b(false);
        return yVar;
    }

    public abstract boolean a();

    public abstract int b();
}
