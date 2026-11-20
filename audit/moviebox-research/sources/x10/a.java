package x10;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f79833a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C0895a f79834b = new C0895a(null, null, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static C0895a f79835c;

    /* JADX INFO: renamed from: x10.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0895a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @JvmField
        public final Method f79836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JvmField
        public final Method f79837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JvmField
        public final Method f79838c;

        public C0895a(Method method, Method method2, Method method3) {
            this.f79836a = method;
            this.f79837b = method2;
            this.f79838c = method3;
        }
    }

    public final C0895a a(BaseContinuationImpl baseContinuationImpl) {
        try {
            C0895a c0895a = new C0895a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f79835c = c0895a;
            return c0895a;
        } catch (Exception unused) {
            C0895a c0895a2 = f79834b;
            f79835c = c0895a2;
            return c0895a2;
        }
    }

    public final String b(BaseContinuationImpl continuation) {
        Intrinsics.g(continuation, "continuation");
        C0895a c0895aA = f79835c;
        if (c0895aA == null) {
            c0895aA = a(continuation);
        }
        if (c0895aA == f79834b) {
            return null;
        }
        Method method = c0895aA.f79836a;
        Object objInvoke = method != null ? method.invoke(continuation.getClass(), new Object[0]) : null;
        if (objInvoke == null) {
            return null;
        }
        Method method2 = c0895aA.f79837b;
        Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, new Object[0]) : null;
        if (objInvoke2 == null) {
            return null;
        }
        Method method3 = c0895aA.f79838c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
