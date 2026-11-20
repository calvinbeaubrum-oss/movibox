package com.transsion.payment.lib;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PayUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PayUtils f54030a = new PayUtils();

    public static /* synthetic */ Object b(PayUtils payUtils, long j11, int i11, Function1 function1, Continuation continuation, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            j11 = 3000;
        }
        return payUtils.a(j11, (i12 & 2) != 0 ? 2 : i11, function1, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(5:12|33|38|21|(1:23)(1:24)) */
    /* JADX WARN: Code duplicated, block: B:23:0x0066 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:32:0x00a8 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0072, code lost:
    
        r14 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        r7 = r10;
        r10 = r12;
        r11 = r7;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x0078, please report this as an issue */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a6 -> B:33:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <T> Object a(long j11, int i11, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) throws Exception {
        PayUtils$retryWithBackoff$1 payUtils$retryWithBackoff$1;
        long j12;
        int i12;
        if (continuation instanceof PayUtils$retryWithBackoff$1) {
            payUtils$retryWithBackoff$1 = (PayUtils$retryWithBackoff$1) continuation;
            int i13 = payUtils$retryWithBackoff$1.label;
            if ((i13 & Integer.MIN_VALUE) != 0) {
                payUtils$retryWithBackoff$1.label = i13 - Integer.MIN_VALUE;
            } else {
                payUtils$retryWithBackoff$1 = new PayUtils$retryWithBackoff$1(this, continuation);
            }
        } else {
            payUtils$retryWithBackoff$1 = new PayUtils$retryWithBackoff$1(this, continuation);
        }
        Object objG = payUtils$retryWithBackoff$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i14 = payUtils$retryWithBackoff$1.label;
        if (i14 == 0) {
            ResultKt.b(objG);
            CoroutineDispatcher coroutineDispatcherA = w0.a();
            PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$2 = new PayUtils$retryWithBackoff$2(function1, null);
            payUtils$retryWithBackoff$1.L$0 = function1;
            payUtils$retryWithBackoff$1.J$0 = j11;
            payUtils$retryWithBackoff$1.I$0 = i11;
            payUtils$retryWithBackoff$1.label = 1;
            objG = h.g(coroutineDispatcherA, payUtils$retryWithBackoff$2, payUtils$retryWithBackoff$1);
            if (objG == objE) {
                return objE;
            }
            long j13 = j11;
            i12 = i11;
            j12 = j13;
        } else if (i14 == 1) {
            i12 = payUtils$retryWithBackoff$1.I$0;
            j12 = payUtils$retryWithBackoff$1.J$0;
            function1 = (Function1) payUtils$retryWithBackoff$1.L$0;
            try {
                ResultKt.b(objG);
            } catch (Exception e11) {
                Exception e12 = e11;
                if (i12 <= 0) {
                    System.out.println((Object) "All retry attempts exhausted");
                    throw e12;
                }
                System.out.println((Object) ("Action failed: " + e12.getMessage() + ". Retries left: " + i12));
                payUtils$retryWithBackoff$1.L$0 = function1;
                payUtils$retryWithBackoff$1.J$0 = j12;
                payUtils$retryWithBackoff$1.I$0 = i12;
                payUtils$retryWithBackoff$1.label = 2;
                if (r0.a(j12, payUtils$retryWithBackoff$1) == objE) {
                    return objE;
                }
                i11 = i12 - 1;
                j11 = j12 * ((long) 2);
                CoroutineDispatcher coroutineDispatcherA2 = w0.a();
                PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$3 = new PayUtils$retryWithBackoff$2(function1, null);
                payUtils$retryWithBackoff$1.L$0 = function1;
                payUtils$retryWithBackoff$1.J$0 = j11;
                payUtils$retryWithBackoff$1.I$0 = i11;
                payUtils$retryWithBackoff$1.label = 1;
                objG = h.g(coroutineDispatcherA2, payUtils$retryWithBackoff$3, payUtils$retryWithBackoff$1);
                if (objG == objE) {
                    return objE;
                }
                long j14 = j11;
                i12 = i11;
                j12 = j14;
            }
        } else {
            if (i14 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i12 = payUtils$retryWithBackoff$1.I$0;
            j12 = payUtils$retryWithBackoff$1.J$0;
            function1 = (Function1) payUtils$retryWithBackoff$1.L$0;
            ResultKt.b(objG);
            i11 = i12 - 1;
            j11 = j12 * ((long) 2);
            CoroutineDispatcher coroutineDispatcherA3 = w0.a();
            PayUtils$retryWithBackoff$2 payUtils$retryWithBackoff$4 = new PayUtils$retryWithBackoff$2(function1, null);
            payUtils$retryWithBackoff$1.L$0 = function1;
            payUtils$retryWithBackoff$1.J$0 = j11;
            payUtils$retryWithBackoff$1.I$0 = i11;
            payUtils$retryWithBackoff$1.label = 1;
            objG = h.g(coroutineDispatcherA3, payUtils$retryWithBackoff$4, payUtils$retryWithBackoff$1);
            if (objG == objE) {
                return objE;
            }
            long j15 = j11;
            i12 = i11;
            j12 = j15;
        }
        System.out.println((Object) "Action succeeded");
        return objG;
    }
}
