package androidx.lifecycle;

import androidx.lifecycle.t0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class ViewModelLazy<VM extends t0> implements Lazy<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KClass<VM> f8694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<x0> f8695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<v0.c> f8696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<r3.a> f8697d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public VM f8698f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends x0> storeProducer, Function0<? extends v0.c> factoryProducer) {
        this(viewModelClass, storeProducer, factoryProducer, null, 8, null);
        Intrinsics.g(viewModelClass, "viewModelClass");
        Intrinsics.g(storeProducer, "storeProducer");
        Intrinsics.g(factoryProducer, "factoryProducer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ViewModelLazy(KClass<VM> viewModelClass, Function0<? extends x0> storeProducer, Function0<? extends v0.c> factoryProducer, Function0<? extends r3.a> extrasProducer) {
        Intrinsics.g(viewModelClass, "viewModelClass");
        Intrinsics.g(storeProducer, "storeProducer");
        Intrinsics.g(factoryProducer, "factoryProducer");
        Intrinsics.g(extrasProducer, "extrasProducer");
        this.f8694a = viewModelClass;
        this.f8695b = storeProducer;
        this.f8696c = factoryProducer;
        this.f8697d = extrasProducer;
    }

    public /* synthetic */ ViewModelLazy(KClass kClass, Function0 function0, Function0 function1, Function0 function2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, function0, function1, (i11 & 8) != 0 ? new Function0<r3.a.C0824a>() { // from class: androidx.lifecycle.ViewModelLazy.1
            @Override // kotlin.jvm.functions.Function0
            public final r3.a.C0824a invoke() {
                return r3.a.C0824a.f75108b;
            }
        } : function2);
    }

    @Override // kotlin.Lazy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public VM getValue() {
        VM vm2 = this.f8698f;
        if (vm2 != null) {
            return vm2;
        }
        VM vm3 = (VM) v0.f8780b.a(this.f8695b.invoke(), this.f8696c.invoke(), this.f8697d.invoke()).c(this.f8694a);
        this.f8698f = vm3;
        return vm3;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f8698f != null;
    }
}
