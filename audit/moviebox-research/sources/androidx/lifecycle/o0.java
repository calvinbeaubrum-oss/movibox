package androidx.lifecycle;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
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
@JvmName
@SourceDebugExtension
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final r3.a.b<f6.e> f8761a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public static final r3.a.b<y0> f8762b = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public static final r3.a.b<Bundle> f8763c = new a();

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a implements r3.a.b<Bundle> {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class b implements r3.a.b<f6.e> {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class c implements r3.a.b<y0> {
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class d implements v0.c {
        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(Class cls) {
            return w0.a(this, cls);
        }

        @Override // androidx.lifecycle.v0.c
        public <T extends t0> T create(Class<T> modelClass, r3.a extras) {
            Intrinsics.g(modelClass, "modelClass");
            Intrinsics.g(extras, "extras");
            return new p0();
        }

        @Override // androidx.lifecycle.v0.c
        public /* synthetic */ t0 create(KClass kClass, r3.a aVar) {
            return w0.c(this, kClass, aVar);
        }
    }

    public static final l0 a(f6.e eVar, y0 y0Var, String str, Bundle bundle) {
        SavedStateHandlesProvider savedStateHandlesProviderD = d(eVar);
        p0 p0VarE = e(y0Var);
        l0 l0Var = p0VarE.b().get(str);
        if (l0Var != null) {
            return l0Var;
        }
        l0 l0VarA = l0.f8745f.a(savedStateHandlesProviderD.a(str), bundle);
        p0VarE.b().put(str, l0VarA);
        return l0VarA;
    }

    public static final l0 b(r3.a aVar) {
        Intrinsics.g(aVar, "<this>");
        f6.e eVar = (f6.e) aVar.a(f8761a);
        if (eVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        y0 y0Var = (y0) aVar.a(f8762b);
        if (y0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) aVar.a(f8763c);
        String str = (String) aVar.a(v0.d.f8789c);
        if (str != null) {
            return a(eVar, y0Var, str, bundle);
        }
        throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends f6.e & y0> void c(T t11) {
        Intrinsics.g(t11, "<this>");
        Lifecycle.State stateB = t11.getLifecycle().b();
        if (stateB != Lifecycle.State.INITIALIZED && stateB != Lifecycle.State.CREATED) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t11.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider") == null) {
            SavedStateHandlesProvider savedStateHandlesProvider = new SavedStateHandlesProvider(t11.getSavedStateRegistry(), t11);
            t11.getSavedStateRegistry().h("androidx.lifecycle.internal.SavedStateHandlesProvider", savedStateHandlesProvider);
            t11.getLifecycle().a(new m0(savedStateHandlesProvider));
        }
    }

    public static final SavedStateHandlesProvider d(f6.e eVar) {
        Intrinsics.g(eVar, "<this>");
        f6.c.InterfaceC0670c interfaceC0670cC = eVar.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider");
        SavedStateHandlesProvider savedStateHandlesProvider = interfaceC0670cC instanceof SavedStateHandlesProvider ? (SavedStateHandlesProvider) interfaceC0670cC : null;
        if (savedStateHandlesProvider != null) {
            return savedStateHandlesProvider;
        }
        throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
    }

    public static final p0 e(y0 y0Var) {
        Intrinsics.g(y0Var, "<this>");
        return (p0) new v0(y0Var, new d()).b("androidx.lifecycle.internal.SavedStateHandlesVM", p0.class);
    }
}
