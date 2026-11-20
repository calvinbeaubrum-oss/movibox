package androidx.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
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
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Class<?>> f8776a = kotlin.collections.g.o(Application.class, l0.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Class<?>> f8777b = kotlin.collections.f.e(l0.class);

    public static final <T> Constructor<T> c(Class<T> modelClass, List<? extends Class<?>> signature) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(signature, "signature");
        Object[] constructors = modelClass.getConstructors();
        Intrinsics.f(constructors, "modelClass.constructors");
        for (Object obj : constructors) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            Intrinsics.f(parameterTypes, "constructor.parameterTypes");
            List listA0 = kotlin.collections.d.A0(parameterTypes);
            if (Intrinsics.b(signature, listA0)) {
                Intrinsics.e(constructor, "null cannot be cast to non-null type java.lang.reflect.Constructor<T of androidx.lifecycle.SavedStateViewModelFactoryKt.findMatchingConstructor>");
                return constructor;
            }
            if (signature.size() == listA0.size() && listA0.containsAll(signature)) {
                throw new UnsupportedOperationException("Class " + modelClass.getSimpleName() + " must have parameters in the proper order: " + signature);
            }
        }
        return null;
    }

    public static final <T extends t0> T d(Class<T> modelClass, Constructor<T> constructor, Object... params) {
        Intrinsics.g(modelClass, "modelClass");
        Intrinsics.g(constructor, "constructor");
        Intrinsics.g(params, "params");
        try {
            return constructor.newInstance(Arrays.copyOf(params, params.length));
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Failed to access " + modelClass, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("A " + modelClass + " cannot be instantiated.", e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException("An exception happened in constructor of " + modelClass, e13.getCause());
        }
    }
}
