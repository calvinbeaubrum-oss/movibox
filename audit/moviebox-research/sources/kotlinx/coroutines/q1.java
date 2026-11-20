package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

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
public interface q1 extends CoroutineContext.Element {

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final b f69514j8 = b.f69515a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ void b(q1 q1Var, CancellationException cancellationException, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i11 & 1) != 0) {
                cancellationException = null;
            }
            q1Var.cancel(cancellationException);
        }

        public static <R> R c(q1 q1Var, R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(q1Var, r11, function2);
        }

        public static <E extends CoroutineContext.Element> E d(q1 q1Var, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.b(q1Var, key);
        }

        public static /* synthetic */ y0 e(q1 q1Var, boolean z11, boolean z12, Function1 function1, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
            }
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            if ((i11 & 2) != 0) {
                z12 = true;
            }
            return q1Var.invokeOnCompletion(z11, z12, function1);
        }

        public static CoroutineContext f(q1 q1Var, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(q1Var, key);
        }

        public static CoroutineContext g(q1 q1Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(q1Var, coroutineContext);
        }

        @Deprecated
        public static q1 h(q1 q1Var, q1 q1Var2) {
            return q1Var2;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements CoroutineContext.Key<q1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f69515a = new b();
    }

    t attachChild(v vVar);

    void cancel(CancellationException cancellationException);

    CancellationException getCancellationException();

    Sequence<q1> getChildren();

    q1 getParent();

    y0 invokeOnCompletion(Function1<? super Throwable, Unit> function1);

    y0 invokeOnCompletion(boolean z11, boolean z12, Function1<? super Throwable, Unit> function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation<? super Unit> continuation);

    boolean start();
}
