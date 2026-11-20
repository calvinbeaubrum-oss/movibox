package com.tn.lib.widget.toast.core;

import android.app.Application;
import android.content.res.Resources;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f50034a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Application f50035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static aq.b f50036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static aq.c<?> f50037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f50038e;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void c(h hVar, Application application, aq.c cVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cVar = f50037d;
        }
        hVar.b(application, cVar);
    }

    public final void a(CharSequence charSequence) {
        if (d()) {
            l(charSequence);
        }
    }

    @JvmOverloads
    public final void b(Application application, aq.c<?> cVar) {
        f50035b = application;
        if (f50036c == null) {
            h(new g());
        }
        if (cVar == null) {
            cVar = new bq.a();
        }
        f50034a.i(cVar);
    }

    public final boolean d() {
        if (f50038e == null) {
            Application application = f50035b;
            Intrinsics.d(application);
            f50038e = Boolean.valueOf((application.getApplicationInfo().flags & 2) != 0);
        }
        Boolean bool = f50038e;
        Intrinsics.d(bool);
        return bool.booleanValue();
    }

    public final void e(int i11) {
        f(i11, 0, 0);
    }

    public final void f(int i11, int i12, int i13) {
        g(i11, i12, i13, 0.0f, 0.0f);
    }

    public final void g(int i11, int i12, int i13, float f11, float f12) {
        aq.b bVar = f50036c;
        Intrinsics.d(bVar);
        aq.c<?> cVar = f50037d;
        Intrinsics.d(cVar);
        bVar.c(new bq.b(cVar, i11, i12, i13, f11, f12));
    }

    public final void h(aq.b bVar) {
        f50036c = bVar;
        Intrinsics.d(bVar);
        bVar.b(f50035b);
    }

    public final void i(aq.c<?> cVar) {
        f50037d = cVar;
        aq.b bVar = f50036c;
        Intrinsics.d(bVar);
        bVar.c(cVar);
    }

    public final void j(int i11) {
        if (i11 <= 0) {
            return;
        }
        i(new bq.c(i11, f50037d));
    }

    public final void k(int i11) {
        try {
            Application application = f50035b;
            Intrinsics.d(application);
            l(application.getResources().getText(i11));
        } catch (Resources.NotFoundException unused) {
            l(String.valueOf(i11));
        }
    }

    public final void l(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return;
        }
        aq.b bVar = f50036c;
        Intrinsics.d(bVar);
        bVar.a(charSequence);
    }
}
