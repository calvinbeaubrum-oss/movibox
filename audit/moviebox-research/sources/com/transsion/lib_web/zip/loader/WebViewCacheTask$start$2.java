package com.transsion.lib_web.zip.loader;

import com.transsion.lib_web.zip.db.WebViewCacheConfigData;
import hu.h;
import java.io.File;
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
@DebugMetadata(c = "com.transsion.lib_web.zip.loader.WebViewCacheTask$start$2", f = "WebViewCacheTask.kt", l = {36}, m = "invokeSuspend")
public final class WebViewCacheTask$start$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ WebViewCacheTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheTask$start$2(WebViewCacheTask webViewCacheTask, Continuation<? super WebViewCacheTask$start$2> continuation) {
        super(2, continuation);
        this.this$0 = webViewCacheTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewCacheTask$start$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WebViewCacheTask$start$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        WebViewCacheTask webViewCacheTask;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                WebViewCacheTask webViewCacheTask2 = this.this$0;
                Result.Companion companion = Result.Companion;
                File fileC = com.transsion.lib_web.zip.b.f53072a.c(webViewCacheTask2.g(), webViewCacheTask2.h());
                if (fileC != null && !fileC.exists()) {
                    WebViewCacheConfigData webViewCacheConfigDataH = webViewCacheTask2.h();
                    this.L$0 = webViewCacheTask2;
                    this.label = 1;
                    Object objD = webViewCacheTask2.d(webViewCacheConfigDataH, fileC, this);
                    if (objD == objE) {
                        return objE;
                    }
                    webViewCacheTask = webViewCacheTask2;
                    obj = objD;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            webViewCacheTask = (WebViewCacheTask) this.L$0;
            ResultKt.b(obj);
            h.f66795a.a(webViewCacheTask.f() + " --> checkDownloadZip() --> download success --> file =  " + ((File) obj) + " --> dbItem = " + webViewCacheTask.h());
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        WebViewCacheTask webViewCacheTask3 = this.this$0;
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            h.f66795a.b(webViewCacheTask3.f() + " --> checkDownloadZip() --> it = " + thM166exceptionOrNullimpl + " --> dbItem = " + webViewCacheTask3.h());
        }
        return Unit.f68710a;
    }
}
