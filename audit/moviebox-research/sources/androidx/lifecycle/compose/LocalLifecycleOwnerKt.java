package androidx.lifecycle.compose;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.s1;
import androidx.lifecycle.u;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@JvmName
@SourceDebugExtension
public final class LocalLifecycleOwnerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s1<u> f8715a;

    static {
        Object objM163constructorimpl;
        s1 s1Var;
        try {
            Result.Companion companion = Result.Companion;
            ClassLoader classLoader = u.class.getClassLoader();
            Intrinsics.d(classLoader);
            Method method = classLoader.loadClass("androidx.compose.ui.platform.AndroidCompositionLocals_androidKt").getMethod("getLocalLifecycleOwner", new Class[0]);
            Annotation[] annotations = method.getAnnotations();
            int length = annotations.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    Object objInvoke = method.invoke(null, new Object[0]);
                    if (objInvoke instanceof s1) {
                        s1Var = (s1) objInvoke;
                        break;
                    }
                } else if (!(annotations[i11] instanceof Deprecated)) {
                    i11++;
                }
                s1Var = null;
                break;
            }
            objM163constructorimpl = Result.m163constructorimpl(s1Var);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        s1<u> s1VarF = (s1) (Result.m169isFailureimpl(objM163constructorimpl) ? null : objM163constructorimpl);
        if (s1VarF == null) {
            s1VarF = CompositionLocalKt.f(new Function0<u>() { // from class: androidx.lifecycle.compose.LocalLifecycleOwnerKt$LocalLifecycleOwner$1$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final u invoke() {
                    throw new IllegalStateException("CompositionLocal LocalLifecycleOwner not present".toString());
                }
            });
        }
        f8715a = s1VarF;
    }

    public static final s1<u> a() {
        return f8715a;
    }
}
