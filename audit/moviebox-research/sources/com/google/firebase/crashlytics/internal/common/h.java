package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f40203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nk.f f40204b;

    public h(String str, nk.f fVar) {
        this.f40203a = str;
        this.f40204b = fVar;
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e11) {
            gk.f.f().e("Error creating marker: " + this.f40203a, e11);
            return false;
        }
    }

    public final File b() {
        return this.f40204b.e(this.f40203a);
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
