package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class t1<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f3721i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q<T> f3722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q2<T> f3724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i1<T> f3725d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<r, T> f3726e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f3727f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final T f3728g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3729h = true;

    /* JADX WARN: Multi-variable type inference failed */
    public t1(q<T> qVar, T t11, boolean z11, q2<T> q2Var, i1<T> i1Var, Function1<? super r, ? extends T> function1, boolean z12) {
        this.f3722a = qVar;
        this.f3723b = z11;
        this.f3724c = q2Var;
        this.f3725d = i1Var;
        this.f3726e = function1;
        this.f3727f = z12;
        this.f3728g = t11;
    }

    @JvmName
    public final boolean a() {
        return this.f3729h;
    }

    public final q<T> b() {
        return this.f3722a;
    }

    public final Function1<r, T> c() {
        return this.f3726e;
    }

    public final T d() {
        if (this.f3723b) {
            return null;
        }
        i1<T> i1Var = this.f3725d;
        if (i1Var != null) {
            return i1Var.getValue();
        }
        T t11 = this.f3728g;
        if (t11 != null) {
            return t11;
        }
        k.t("Unexpected form of a provided value");
        throw new KotlinNothingValueException();
    }

    public final q2<T> e() {
        return this.f3724c;
    }

    public final i1<T> f() {
        return this.f3725d;
    }

    public final T g() {
        return this.f3728g;
    }

    public final t1<T> h() {
        this.f3729h = false;
        return this;
    }

    public final boolean i() {
        return this.f3727f;
    }

    public final boolean j() {
        return (this.f3723b || g() != null) && !this.f3727f;
    }
}
