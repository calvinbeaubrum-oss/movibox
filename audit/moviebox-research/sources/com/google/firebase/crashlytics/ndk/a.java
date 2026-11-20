package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import androidx.annotation.NonNull;
import gk.g;
import nk.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a implements gk.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f40587e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rk.b f40588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f40589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f40590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0443a f40591d;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.ndk.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0443a {
        void a();
    }

    public a(@NonNull rk.b bVar, boolean z11) {
        this.f40588a = bVar;
        this.f40589b = z11;
    }

    public static a f(@NonNull Context context, boolean z11) {
        a aVar = new a(new rk.b(context, new JniNativeApi(context), new f(context)), z11);
        f40587e = aVar;
        return aVar;
    }

    @Override // gk.a
    @NonNull
    public g a(@NonNull String str) {
        return new rk.g(this.f40588a.a(str));
    }

    @Override // gk.a
    public boolean b() {
        String str = this.f40590c;
        return str != null && d(str);
    }

    @Override // gk.a
    public synchronized void c(@NonNull final String str, @NonNull final String str2, final long j11, @NonNull final kk.f fVar) {
        this.f40590c = str;
        InterfaceC0443a interfaceC0443a = new InterfaceC0443a() { // from class: rk.c
            @Override // com.google.firebase.crashlytics.ndk.a.InterfaceC0443a
            public final void a() {
                this.f75592a.g(str, str2, j11, fVar);
            }
        };
        this.f40591d = interfaceC0443a;
        if (this.f40589b) {
            interfaceC0443a.a();
        }
    }

    @Override // gk.a
    public boolean d(@NonNull String str) {
        return this.f40588a.c(str);
    }

    public final /* synthetic */ void g(String str, String str2, long j11, kk.f fVar) {
        gk.f.f().b("Initializing native session: " + str);
        if (this.f40588a.d(str, str2, j11, fVar)) {
            return;
        }
        gk.f.f().k("Failed to initialize Crashlytics NDK for session " + str);
    }
}
