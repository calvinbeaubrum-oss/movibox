package com.transsion.ad.monopoly;

import com.transsion.ad.monopoly.manager.AdPlansAssetsManager;
import com.transsion.ad.monopoly.manager.AdPlansRequestManager;
import com.transsion.ad.monopoly.manager.AdSceneAssetsManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.functions.Function1;

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
public final class MonopolyAdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MonopolyAdManager f50522a = new MonopolyAdManager();

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object b(MonopolyAdManager monopolyAdManager, String str, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            function1 = null;
        }
        return monopolyAdManager.a(str, function1, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0083 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(String str, Function1<? super Boolean, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        MonopolyAdManager$init$1 monopolyAdManager$init$1;
        String str2;
        Function1<? super Boolean, Unit> function2;
        AdPlansRequestManager adPlansRequestManager;
        if (continuation instanceof MonopolyAdManager$init$1) {
            monopolyAdManager$init$1 = (MonopolyAdManager$init$1) continuation;
            int i11 = monopolyAdManager$init$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                monopolyAdManager$init$1.label = i11 - Integer.MIN_VALUE;
            } else {
                monopolyAdManager$init$1 = new MonopolyAdManager$init$1(this, continuation);
            }
        } else {
            monopolyAdManager$init$1 = new MonopolyAdManager$init$1(this, continuation);
        }
        Object obj = monopolyAdManager$init$1.result;
        Object objE = a.e();
        int i12 = monopolyAdManager$init$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                function1 = (Function1) monopolyAdManager$init$1.L$1;
                str = (String) monopolyAdManager$init$1.L$0;
                ResultKt.b(obj);
            } else if (i12 == 2) {
                function2 = (Function1) monopolyAdManager$init$1.L$1;
                str2 = (String) monopolyAdManager$init$1.L$0;
                ResultKt.b(obj);
                adPlansRequestManager = AdPlansRequestManager.f50530a;
                monopolyAdManager$init$1.L$0 = null;
                monopolyAdManager$init$1.L$1 = null;
                monopolyAdManager$init$1.label = 3;
                if (adPlansRequestManager.r(str2, function2, monopolyAdManager$init$1) == objE) {
                    return objE;
                }
            } else {
                if (i12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        AdPlansAssetsManager adPlansAssetsManager = AdPlansAssetsManager.f50529a;
        monopolyAdManager$init$1.L$0 = str;
        monopolyAdManager$init$1.L$1 = function1;
        monopolyAdManager$init$1.label = 1;
        if (adPlansAssetsManager.g(monopolyAdManager$init$1) == objE) {
            return objE;
        }
        AdSceneAssetsManager adSceneAssetsManager = AdSceneAssetsManager.f50534a;
        monopolyAdManager$init$1.L$0 = str;
        monopolyAdManager$init$1.L$1 = function1;
        monopolyAdManager$init$1.label = 2;
        if (adSceneAssetsManager.c(monopolyAdManager$init$1) == objE) {
            return objE;
        }
        Function1<? super Boolean, Unit> function3 = function1;
        str2 = str;
        function2 = function3;
        adPlansRequestManager = AdPlansRequestManager.f50530a;
        monopolyAdManager$init$1.L$0 = null;
        monopolyAdManager$init$1.L$1 = null;
        monopolyAdManager$init$1.label = 3;
        if (adPlansRequestManager.r(str2, function2, monopolyAdManager$init$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }
}
