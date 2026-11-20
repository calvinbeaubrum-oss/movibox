package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
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
public final class q0 extends v0.e implements v0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Application f8771a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0.c f8772b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f8773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Lifecycle f8774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f6.c f8775e;

    public q0() {
        this.f8772b = new v0.a();
    }

    @SuppressLint({"LambdaLast"})
    public q0(Application application, f6.e owner, Bundle bundle) {
        Intrinsics.g(owner, "owner");
        this.f8775e = owner.getSavedStateRegistry();
        this.f8774d = owner.getLifecycle();
        this.f8773c = bundle;
        this.f8771a = application;
        this.f8772b = application != null ? v0.a.f8783e.a(application) : new v0.a();
    }

    @Override // androidx.lifecycle.v0.e
    public void a(t0 viewModel) {
        Intrinsics.g(viewModel, "viewModel");
        if (this.f8774d != null) {
            f6.c cVar = this.f8775e;
            Intrinsics.d(cVar);
            Lifecycle lifecycle = this.f8774d;
            Intrinsics.d(lifecycle);
            n.a(viewModel, cVar, lifecycle);
        }
    }

    public final <T extends t0> T b(String key, Class<T> modelClass) {
        T t11;
        Application application;
        Intrinsics.g(key, "key");
        Intrinsics.g(modelClass, "modelClass");
        Lifecycle lifecycle = this.f8774d;
        if (lifecycle == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || this.f8771a == null) ? r0.c(modelClass, r0.f8777b) : r0.c(modelClass, r0.f8776a);
        if (constructorC == null) {
            return this.f8771a != null ? (T) this.f8772b.create(modelClass) : (T) v0.d.f8787a.a().create(modelClass);
        }
        f6.c cVar = this.f8775e;
        Intrinsics.d(cVar);
        n0 n0VarB = n.b(cVar, lifecycle, key, this.f8773c);
        if (!zIsAssignableFrom || (application = this.f8771a) == null) {
            t11 = (T) r0.d(modelClass, constructorC, n0VarB.b());
        } else {
            Intrinsics.d(application);
            t11 = (T) r0.d(modelClass, constructorC, application, n0VarB.b());
        }
        t11.addCloseable("androidx.lifecycle.savedstate.vm.tag", n0VarB);
        return t11;
    }

    @Override // androidx.lifecycle.v0.c
    public <T extends t0> T create(Class<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return (T) b(canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.v0.c
    public <T extends t0> T create(Class<T> modelClass, r3.a extras) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(extras, "extras");
        String str = (String) extras.a(v0.d.f8789c);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (extras.a(o0.f8761a) == null || extras.a(o0.f8762b) == null) {
            if (this.f8774d != null) {
                return (T) b(str, modelClass);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) extras.a(v0.a.f8785g);
        boolean zIsAssignableFrom = b.class.isAssignableFrom(modelClass);
        Constructor constructorC = (!zIsAssignableFrom || application == null) ? r0.c(modelClass, r0.f8777b) : r0.c(modelClass, r0.f8776a);
        if (constructorC == null) {
            return (T) this.f8772b.create(modelClass, extras);
        }
        return (!zIsAssignableFrom || application == null) ? (T) r0.d(modelClass, constructorC, o0.b(extras)) : (T) r0.d(modelClass, constructorC, application, o0.b(extras));
    }

    @Override // androidx.lifecycle.v0.c
    public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
        return w0.c(this, kClass, aVar);
    }
}
