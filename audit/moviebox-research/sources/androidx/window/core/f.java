package androidx.window.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class f<T> extends SpecificationComputer<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f13146b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f13147c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpecificationComputer.VerificationMode f13148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f13149e;

    public f(T value, String tag, SpecificationComputer.VerificationMode verificationMode, e logger) {
        Intrinsics.g(value, "value");
        Intrinsics.g(tag, "tag");
        Intrinsics.g(verificationMode, "verificationMode");
        Intrinsics.g(logger, "logger");
        this.f13146b = value;
        this.f13147c = tag;
        this.f13148d = verificationMode;
        this.f13149e = logger;
    }

    @Override // androidx.window.core.SpecificationComputer
    public T a() {
        return this.f13146b;
    }

    @Override // androidx.window.core.SpecificationComputer
    public SpecificationComputer<T> c(String message, Function1<? super T, Boolean> condition) {
        Intrinsics.g(message, "message");
        Intrinsics.g(condition, "condition");
        return condition.invoke(this.f13146b).booleanValue() ? this : new d(this.f13146b, this.f13147c, message, this.f13149e, this.f13148d);
    }
}
