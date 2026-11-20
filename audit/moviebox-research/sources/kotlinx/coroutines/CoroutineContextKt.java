package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
public final class CoroutineContextKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    public static final CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, final boolean z11) {
        boolean zC = c(coroutineContext);
        boolean zC2 = c(coroutineContext2);
        if (!zC && !zC2) {
            return coroutineContext.plus(coroutineContext2);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = coroutineContext2;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
        CoroutineContext coroutineContext3 = (CoroutineContext) coroutineContext.fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$folded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            /* JADX WARN: Type inference failed for: r2v2, types: [T, kotlin.coroutines.CoroutineContext] */
            @Override // kotlin.jvm.functions.Function2
            public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                if (!(element instanceof f0)) {
                    return coroutineContext4.plus(element);
                }
                CoroutineContext.Element element2 = objectRef.element.get(element.getKey());
                if (element2 != null) {
                    Ref.ObjectRef<CoroutineContext> objectRef2 = objectRef;
                    objectRef2.element = objectRef2.element.minusKey(element.getKey());
                    return coroutineContext4.plus(((f0) element).b(element2));
                }
                f0 f0VarG = (f0) element;
                if (z11) {
                    f0VarG = f0VarG.g();
                }
                return coroutineContext4.plus(f0VarG);
            }
        });
        if (zC2) {
            objectRef.element = ((CoroutineContext) objectRef.element).fold(emptyCoroutineContext, new Function2<CoroutineContext, CoroutineContext.Element, CoroutineContext>() { // from class: kotlinx.coroutines.CoroutineContextKt$foldCopies$1
                @Override // kotlin.jvm.functions.Function2
                public final CoroutineContext invoke(CoroutineContext coroutineContext4, CoroutineContext.Element element) {
                    return element instanceof f0 ? coroutineContext4.plus(((f0) element).g()) : coroutineContext4.plus(element);
                }
            });
        }
        return coroutineContext3.plus((CoroutineContext) objectRef.element);
    }

    public static final String b(CoroutineContext coroutineContext) {
        return null;
    }

    public static final boolean c(CoroutineContext coroutineContext) {
        return ((Boolean) coroutineContext.fold(Boolean.FALSE, new Function2<Boolean, CoroutineContext.Element, Boolean>() { // from class: kotlinx.coroutines.CoroutineContextKt$hasCopyableElements$1
            public final Boolean invoke(boolean z11, CoroutineContext.Element element) {
                return Boolean.valueOf(z11 || (element instanceof f0));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, CoroutineContext.Element element) {
                return invoke(bool.booleanValue(), element);
            }
        })).booleanValue();
    }

    public static final CoroutineContext d(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        return !c(coroutineContext2) ? coroutineContext.plus(coroutineContext2) : a(coroutineContext, coroutineContext2, false);
    }

    public static final CoroutineContext e(k0 k0Var, CoroutineContext coroutineContext) {
        CoroutineContext coroutineContextA = a(k0Var.getCoroutineContext(), coroutineContext, true);
        return (coroutineContextA == w0.a() || coroutineContextA.get(ContinuationInterceptor.f68810h8) != null) ? coroutineContextA : coroutineContextA.plus(w0.a());
    }

    public static final q2<?> f(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof t0) && (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) != null) {
            if (coroutineStackFrame instanceof q2) {
                return (q2) coroutineStackFrame;
            }
        }
        return null;
    }

    public static final q2<?> g(Continuation<?> continuation, CoroutineContext coroutineContext, Object obj) {
        if (!(continuation instanceof CoroutineStackFrame) || coroutineContext.get(r2.f69518a) == null) {
            return null;
        }
        q2<?> q2VarF = f((CoroutineStackFrame) continuation);
        if (q2VarF != null) {
            q2VarF.t(coroutineContext, obj);
        }
        return q2VarF;
    }
}
