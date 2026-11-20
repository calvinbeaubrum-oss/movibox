package com.transsion.ad.strategy;

import android.content.Context;
import com.blankj.utilcode.util.n;
import com.google.gson.reflect.TypeToken;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.mcc.LocalMcc;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "com.transsion.ad.strategy.NationalInformationManager$initLocalMcc$2", f = "NationalInformationManager.kt", l = {38, 48}, m = "invokeSuspend")
public final class NationalInformationManager$initLocalMcc$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NationalInformationManager$initLocalMcc$2(Context context, Continuation<? super NationalInformationManager$initLocalMcc$2> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NationalInformationManager$initLocalMcc$2(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NationalInformationManager$initLocalMcc$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00cc  */
    /* JADX WARN: Instruction removed from duplicated block: B:32:0x00cc, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        Context context;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    context = (Context) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                com.transsion.ad.a.b(com.transsion.ad.a.f50276a, NationalInformationManager.f50580a.c() + " --> initLocalMcc() --> assets数据 -- 保存数据库成功 -- success", false, 2, null);
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    com.transsion.ad.a.d(com.transsion.ad.a.f50276a, NationalInformationManager.f50580a.c() + " --> initLocalMcc() --> assets数据 -- 保存数据库失败 -- error -- it = " + thM166exceptionOrNullimpl, false, 2, null);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            context = this.$context;
            Result.Companion companion = Result.Companion;
            qq.a aVarM = MbAdDatabase.f50387p.b(context).M();
            this.L$0 = context;
            this.label = 1;
            obj = aVarM.d(this);
            if (obj == objE) {
                return objE;
            }
            if (((LocalMcc) obj) != null) {
                com.transsion.ad.a.b(com.transsion.ad.a.f50276a, NationalInformationManager.f50580a.c() + " --> initLocalMcc() --> 数据库已存在 --> success", false, 2, null);
                return Unit.f68710a;
            }
            List<LocalMcc> codeList = (List) n.e(xq.d.f80669a.b("local_mcc.json"), new TypeToken<List<? extends LocalMcc>>() { // from class: com.transsion.ad.strategy.NationalInformationManager$initLocalMcc$2$1$listType$1
            }.getType());
            qq.a aVarM2 = MbAdDatabase.f50387p.b(context).M();
            Intrinsics.f(codeList, "codeList");
            this.L$0 = null;
            this.label = 2;
            if (aVarM2.b(codeList, this) == objE) {
                return objE;
            }
            com.transsion.ad.a.b(com.transsion.ad.a.f50276a, NationalInformationManager.f50580a.c() + " --> initLocalMcc() --> assets数据 -- 保存数据库成功 -- success", false, 2, null);
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
            thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
            if (thM166exceptionOrNullimpl != null) {
                com.transsion.ad.a.d(com.transsion.ad.a.f50276a, NationalInformationManager.f50580a.c() + " --> initLocalMcc() --> assets数据 -- 保存数据库失败 -- error -- it = " + thM166exceptionOrNullimpl, false, 2, null);
            }
            return Unit.f68710a;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
    }
}
