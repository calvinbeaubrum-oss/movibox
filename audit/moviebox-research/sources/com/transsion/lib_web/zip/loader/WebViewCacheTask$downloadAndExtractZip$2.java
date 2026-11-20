package com.transsion.lib_web.zip.loader;

import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import okhttp3.Request;
import okhttp3.Response;

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
@DebugMetadata(c = "com.transsion.lib_web.zip.loader.WebViewCacheTask$downloadAndExtractZip$2", f = "WebViewCacheTask.kt", l = {}, m = "invokeSuspend")
public final class WebViewCacheTask$downloadAndExtractZip$2 extends SuspendLambda implements Function2<k0, Continuation<? super File>, Object> {
    final /* synthetic */ File $targetDirectory;
    final /* synthetic */ String $zipUrl;
    int label;
    final /* synthetic */ WebViewCacheTask this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewCacheTask$downloadAndExtractZip$2(String str, WebViewCacheTask webViewCacheTask, File file, Continuation<? super WebViewCacheTask$downloadAndExtractZip$2> continuation) {
        super(2, continuation);
        this.$zipUrl = str;
        this.this$0 = webViewCacheTask;
        this.$targetDirectory = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewCacheTask$downloadAndExtractZip$2(this.$zipUrl, this.this$0, this.$targetDirectory, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super File> continuation) {
        return ((WebViewCacheTask$downloadAndExtractZip$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Response responseExecute = OkHttpProvider.f53078a.b().newCall(new Request.Builder().url(this.$zipUrl).build()).execute();
        WebViewCacheTask webViewCacheTask = this.this$0;
        File file = this.$targetDirectory;
        try {
            if (responseExecute.isSuccessful()) {
                File fileE = webViewCacheTask.e(responseExecute, file);
                CloseableKt.a(responseExecute, null);
                return fileE;
            }
            throw new IOException("Unexpected code " + responseExecute);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(responseExecute, th2);
                throw th3;
            }
        }
    }
}
