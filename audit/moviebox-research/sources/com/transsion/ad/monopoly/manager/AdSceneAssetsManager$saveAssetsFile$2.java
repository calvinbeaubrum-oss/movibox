package com.transsion.ad.monopoly.manager;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import wq.d;

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
@DebugMetadata(c = "com.transsion.ad.monopoly.manager.AdSceneAssetsManager$saveAssetsFile$2", f = "AdSceneAssetsManager.kt", l = {}, m = "invokeSuspend")
public final class AdSceneAssetsManager$saveAssetsFile$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;

    public AdSceneAssetsManager$saveAssetsFile$2(Continuation<? super AdSceneAssetsManager$saveAssetsFile$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdSceneAssetsManager$saveAssetsFile$2(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((AdSceneAssetsManager$saveAssetsFile$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            Result.Companion companion = Result.Companion;
            d dVar = d.f79584a;
            if (dVar.e()) {
                com.transsion.ad.a.b(com.transsion.ad.a.f50276a, AdSceneAssetsManager.f50534a.b() + " --> saveAssetsFile() --> 数据已经存在", false, 2, null);
                return Unit.f68710a;
            }
            String strB = xq.d.f80669a.b("assets_scene.json");
            if (TextUtils.isEmpty(strB)) {
                com.transsion.ad.a.d(com.transsion.ad.a.f50276a, AdSceneAssetsManager.f50534a.b() + " --> saveAssetsFile() --> assets数据 -- 保存数据库失败 -- fail fail fail -- readAssets = null", false, 2, null);
            } else {
                com.transsion.ad.a.b(com.transsion.ad.a.f50276a, AdSceneAssetsManager.f50534a.b() + " --> saveAssetsFile() --> readAssets = " + strB, false, 2, null);
                dVar.f(strB);
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a.d(com.transsion.ad.a.f50276a, AdSceneAssetsManager.f50534a.b() + " --> saveAssetsFile() --> 保存本地数据异常 -- error error error --> it = " + thM166exceptionOrNullimpl, false, 2, null);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
