package com.transsion.lib_web.zip;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.lib_web.zip.db.WebResRemoteBean;
import hu.h;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "com.transsion.lib_web.zip.WebResManager$getWebResConfig$1", f = "WebResManager.kt", l = {50, 52}, m = "invokeSuspend")
public final class WebResManager$getWebResConfig$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    public WebResManager$getWebResConfig$1(Continuation<? super WebResManager$getWebResConfig$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebResManager$getWebResConfig$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WebResManager$getWebResConfig$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0099  */
    /* JADX WARN: Instruction removed from duplicated block: B:31:0x0099, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        String string;
        Unit unit;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    string = (String) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                unit = Unit.f68710a;
                objM163constructorimpl = Result.m163constructorimpl(unit);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    h.f66795a.b(WebResManager.f53069a.k() + " --> getWebResConfig() --> it = " + thM166exceptionOrNullimpl);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            Result.Companion companion = Result.Companion;
            WebResManager webResManager = WebResManager.f53069a;
            string = webResManager.m().getString("lastUpdateTime", "");
            h.f66795a.a(webResManager.k() + " --> loadWebRes() --> start api ..... curLastUpdateTime = " + string);
            a aVarL = webResManager.l();
            this.L$0 = string;
            this.label = 1;
            obj = a.C0574a.a(aVarL, string, null, this, 2, null);
            if (obj == objE) {
                return objE;
            }
            WebResRemoteBean webResRemoteBean = (WebResRemoteBean) ((BaseDto) obj).getData();
            unit = null;
            if (webResRemoteBean != null) {
                WebResManager webResManager2 = WebResManager.f53069a;
                this.L$0 = null;
                this.label = 2;
                if (webResManager2.o(webResRemoteBean, string, this) == objE) {
                    return objE;
                }
                unit = Unit.f68710a;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            h.f66795a.b(WebResManager.f53069a.k() + " --> getWebResConfig() --> it = " + thM166exceptionOrNullimpl);
        }
        return Unit.f68710a;
    }
}
