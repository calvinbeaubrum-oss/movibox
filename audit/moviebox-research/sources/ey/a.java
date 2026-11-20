package ey;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f64470a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f64471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f64472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function0<Unit> f64473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function0<Unit> f64474e;

    public final boolean a() {
        return f64474e != null;
    }

    public final boolean b() {
        return f64473d != null;
    }

    public final boolean c() {
        return f64472c;
    }

    public final boolean d() {
        return f64471b;
    }

    public final void e() {
        f64472c = false;
        Function0<Unit> function0 = f64474e;
        if (function0 != null) {
            function0.invoke();
        }
        f64474e = null;
    }

    public final void f() {
        f64471b = false;
        Function0<Unit> function0 = f64473d;
        if (function0 != null) {
            function0.invoke();
        }
        f64473d = null;
    }

    public final void g(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        f64474e = callback;
    }

    public final void h(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        f64473d = callback;
    }

    public final void i() {
        f64472c = true;
    }

    public final void j() {
        f64471b = true;
    }
}
