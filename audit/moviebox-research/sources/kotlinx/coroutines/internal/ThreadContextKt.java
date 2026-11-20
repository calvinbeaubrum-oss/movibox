package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ThreadContextKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final c0 f69447a = new c0("NO_THREAD_ELEMENTS");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, CoroutineContext.Element, Object> f69448b = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, CoroutineContext.Element element) {
            if (!(element instanceof m2)) {
                return obj;
            }
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            int iIntValue = num != null ? num.intValue() : 1;
            return iIntValue == 0 ? element : Integer.valueOf(iIntValue + 1);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Function2<m2<?>, CoroutineContext.Element, m2<?>> f69449c = new Function2<m2<?>, CoroutineContext.Element, m2<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        public final m2<?> invoke(m2<?> m2Var, CoroutineContext.Element element) {
            if (m2Var != null) {
                return m2Var;
            }
            if (element instanceof m2) {
                return (m2) element;
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Function2<l0, CoroutineContext.Element, l0> f69450d = new Function2<l0, CoroutineContext.Element, l0>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        public final l0 invoke(l0 l0Var, CoroutineContext.Element element) {
            if (element instanceof m2) {
                m2<?> m2Var = (m2) element;
                l0Var.a(m2Var, m2Var.r(l0Var.f69474a));
            }
            return l0Var;
        }
    };

    public static final void a(CoroutineContext coroutineContext, Object obj) {
        if (obj == f69447a) {
            return;
        }
        if (obj instanceof l0) {
            ((l0) obj).b(coroutineContext);
            return;
        }
        Object objFold = coroutineContext.fold(null, f69449c);
        Intrinsics.e(objFold, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        ((m2) objFold).h(coroutineContext, obj);
    }

    public static final Object b(CoroutineContext coroutineContext) {
        Object objFold = coroutineContext.fold(0, f69448b);
        Intrinsics.d(objFold);
        return objFold;
    }

    public static final Object c(CoroutineContext coroutineContext, Object obj) {
        if (obj == null) {
            obj = b(coroutineContext);
        }
        if (obj == 0) {
            return f69447a;
        }
        if (obj instanceof Integer) {
            return coroutineContext.fold(new l0(coroutineContext, ((Number) obj).intValue()), f69450d);
        }
        Intrinsics.e(obj, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        return ((m2) obj).r(coroutineContext);
    }
}
