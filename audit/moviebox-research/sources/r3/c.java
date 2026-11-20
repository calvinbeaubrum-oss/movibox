package r3;

import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import s3.g;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x0 f75109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0.c f75110b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f75111c;

    public c(x0 store, v0.c factory, a extras) {
        Intrinsics.g(store, "store");
        Intrinsics.g(factory, "factory");
        Intrinsics.g(extras, "extras");
        this.f75109a = store;
        this.f75110b = factory;
        this.f75111c = extras;
    }

    public static /* synthetic */ t0 b(c cVar, KClass kClass, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = g.f75955a.c(kClass);
        }
        return cVar.a(kClass, str);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final <T extends t0> T a(KClass<T> modelClass, String key) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(key, "key");
        T t11 = (T) this.f75109a.b(key);
        if (!modelClass.b(t11)) {
            b bVar = new b(this.f75111c);
            bVar.c(g.a.f75956a, key);
            T t12 = (T) d.a(this.f75110b, modelClass, bVar);
            this.f75109a.d(key, t12);
            return t12;
        }
        Object obj = this.f75110b;
        if (obj instanceof v0.e) {
            Intrinsics.d(t11);
            ((v0.e) obj).a(t11);
        }
        Intrinsics.e(t11, "null cannot be cast to non-null type T of androidx.lifecycle.viewmodel.ViewModelProviderImpl.getViewModel");
        return t11;
    }
}
