package androidx.lifecycle;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public abstract class a extends v0.e implements v0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f6.c f8699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Lifecycle f8700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f8701c;

    public a(f6.e owner, Bundle bundle) {
        Intrinsics.g(owner, "owner");
        this.f8699a = owner.getSavedStateRegistry();
        this.f8700b = owner.getLifecycle();
        this.f8701c = bundle;
    }

    private final <T extends t0> T b(String str, Class<T> cls) {
        f6.c cVar = this.f8699a;
        Intrinsics.d(cVar);
        Lifecycle lifecycle = this.f8700b;
        Intrinsics.d(lifecycle);
        n0 n0VarB = n.b(cVar, lifecycle, str, this.f8701c);
        T t11 = (T) c(str, cls, n0VarB.b());
        t11.addCloseable("androidx.lifecycle.savedstate.vm.tag", n0VarB);
        return t11;
    }

    @Override // androidx.lifecycle.v0.e
    public void a(t0 viewModel) {
        Intrinsics.g(viewModel, "viewModel");
        f6.c cVar = this.f8699a;
        if (cVar != null) {
            Intrinsics.d(cVar);
            Lifecycle lifecycle = this.f8700b;
            Intrinsics.d(lifecycle);
            n.a(viewModel, cVar, lifecycle);
        }
    }

    public abstract <T extends t0> T c(String str, Class<T> cls, l0 l0Var);

    @Override // androidx.lifecycle.v0.c
    public <T extends t0> T create(Class<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        if (this.f8700b != null) {
            return (T) b(canonicalName, modelClass);
        }
        throw new UnsupportedOperationException("AbstractSavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
    }

    @Override // androidx.lifecycle.v0.c
    public <T extends t0> T create(Class<T> modelClass, r3.a extras) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(extras, "extras");
        String str = (String) extras.a(v0.d.f8789c);
        if (str != null) {
            return this.f8699a != null ? (T) b(str, modelClass) : (T) c(str, modelClass, o0.b(extras));
        }
        throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
    }

    @Override // androidx.lifecycle.v0.c
    public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
        return w0.c(this, kClass, aVar);
    }
}
