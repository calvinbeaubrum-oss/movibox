package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TimeoutKt {
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Instruction removed from duplicated block: B:9:0x0018, please report this as an issue */
    public static final TimeoutCancellationException a(long j11, q0 q0Var, q1 q1Var) {
        String strK;
        s0 s0Var = q0Var instanceof s0 ? (s0) q0Var : null;
        if (s0Var != null) {
            Duration.Companion companion = Duration.f69159b;
            strK = s0Var.k(DurationKt.o(j11, DurationUnit.MILLISECONDS));
            if (strK == null) {
                strK = "Timed out waiting for " + j11 + " ms";
            }
        } else {
            strK = "Timed out waiting for " + j11 + " ms";
        }
        return new TimeoutCancellationException(strK, q1Var);
    }

    public static final <U, T extends U> Object b(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2) {
        t1.i(timeoutCoroutine, r0.b(timeoutCoroutine.uCont.getContext()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.getContext()));
        return d20.b.c(timeoutCoroutine, timeoutCoroutine, function2);
    }

    public static final <T> Object c(long j11, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j11 <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object objB = b(new TimeoutCoroutine(j11, continuation), function2);
        if (objB == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return objB;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.TimeoutCoroutine] */
    public static final <T> Object d(long j11, Function2<? super k0, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        TimeoutKt$withTimeoutOrNull$1 timeoutKt$withTimeoutOrNull$1;
        Ref.ObjectRef objectRef;
        if (continuation instanceof TimeoutKt$withTimeoutOrNull$1) {
            timeoutKt$withTimeoutOrNull$1 = (TimeoutKt$withTimeoutOrNull$1) continuation;
            int i11 = timeoutKt$withTimeoutOrNull$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                timeoutKt$withTimeoutOrNull$1.label = i11 - Integer.MIN_VALUE;
            } else {
                timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
            }
        } else {
            timeoutKt$withTimeoutOrNull$1 = new TimeoutKt$withTimeoutOrNull$1(continuation);
        }
        Object obj = timeoutKt$withTimeoutOrNull$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = timeoutKt$withTimeoutOrNull$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (j11 <= 0) {
                return null;
            }
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                timeoutKt$withTimeoutOrNull$1.L$0 = function2;
                timeoutKt$withTimeoutOrNull$1.L$1 = objectRef2;
                timeoutKt$withTimeoutOrNull$1.J$0 = j11;
                timeoutKt$withTimeoutOrNull$1.label = 1;
                ?? r11 = (T) new TimeoutCoroutine(j11, timeoutKt$withTimeoutOrNull$1);
                objectRef2.element = r11;
                Object objB = b(r11, function2);
                if (objB == kotlin.coroutines.intrinsics.a.e()) {
                    DebugProbesKt.c(timeoutKt$withTimeoutOrNull$1);
                }
                return objB == objE ? objE : objB;
            } catch (TimeoutCancellationException e11) {
                e = e11;
                objectRef = objectRef2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) timeoutKt$withTimeoutOrNull$1.L$1;
            try {
                ResultKt.b(obj);
                return obj;
            } catch (TimeoutCancellationException e12) {
                e = e12;
            }
        }
        if (e.coroutine == objectRef.element) {
            return null;
        }
        throw e;
    }
}
