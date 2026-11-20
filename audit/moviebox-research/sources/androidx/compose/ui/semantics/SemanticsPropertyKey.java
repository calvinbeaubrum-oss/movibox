package androidx.compose.ui.semantics;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SemanticsPropertyKey<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<T, T, T> f5625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5626c;

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String str, Function2<? super T, ? super T, ? extends T> function2) {
        this.f5624a = str;
        this.f5625b = function2;
    }

    public /* synthetic */ SemanticsPropertyKey(String str, Function2 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? new Function2<T, T, T>() { // from class: androidx.compose.ui.semantics.SemanticsPropertyKey.1
            @Override // kotlin.jvm.functions.Function2
            public final T invoke(T t11, T t12) {
                return t11 == null ? t12 : t11;
            }
        } : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SemanticsPropertyKey(String str, boolean z11) {
        this(str, null, 2, 0 == true ? 1 : 0);
        this.f5626c = z11;
    }

    public SemanticsPropertyKey(String str, boolean z11, Function2<? super T, ? super T, ? extends T> function2) {
        this(str, function2);
        this.f5626c = z11;
    }

    public final String a() {
        return this.f5624a;
    }

    public final boolean b() {
        return this.f5626c;
    }

    public final T c(T t11, T t12) {
        return this.f5625b.invoke(t11, t12);
    }

    public final void d(q qVar, KProperty<?> kProperty, T t11) {
        qVar.a(this, t11);
    }

    public String toString() {
        return "AccessibilityKey: " + this.f5624a;
    }
}
