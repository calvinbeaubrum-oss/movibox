package com.transsion.upload.log;

import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.upload.bean.LoggerBean;
import ip.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import okhttp3.RequestBody;

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
@DebugMetadata(c = "com.transsion.upload.log.UploadLoggerManager$reportUploadLogsResult$1", f = "UploadLoggerManager.kt", l = {164}, m = "invokeSuspend")
public final class UploadLoggerManager$reportUploadLogsResult$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bucket;
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ String $sourcePath;
    final /* synthetic */ ty.a $uploadCallback;
    final /* synthetic */ String $url;
    final /* synthetic */ String $zipFileName;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UploadLoggerManager$reportUploadLogsResult$1(String str, String str2, ty.a aVar, String str3, String str4, Function1<? super String, Unit> function1, Continuation<? super UploadLoggerManager$reportUploadLogsResult$1> continuation) {
        super(2, continuation);
        this.$url = str;
        this.$bucket = str2;
        this.$uploadCallback = aVar;
        this.$sourcePath = str3;
        this.$zipFileName = str4;
        this.$callback = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UploadLoggerManager$reportUploadLogsResult$1(this.$url, this.$bucket, this.$uploadCallback, this.$sourcePath, this.$zipFileName, this.$callback, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((UploadLoggerManager$reportUploadLogsResult$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ty.a aVar;
        String str;
        Function1<String, Unit> function1;
        String str2;
        String logId;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("logsZipUrl", this.$url);
                jsonObject.addProperty("tempBucket", this.$bucket);
                b.a aVar2 = b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "json.toString()");
                RequestBody requestBodyA = aVar2.a(string);
                if (requestBodyA != null) {
                    aVar = this.$uploadCallback;
                    String str3 = this.$sourcePath;
                    str = this.$zipFileName;
                    Function1<String, Unit> function2 = this.$callback;
                    a aVarG = UploadLoggerManager.f59261a.g();
                    this.L$0 = aVar;
                    this.L$1 = str3;
                    this.L$2 = str;
                    this.L$3 = function2;
                    this.label = 1;
                    Object objB = a.C0608a.b(aVarG, null, requestBodyA, this, 1, null);
                    if (objB == objE) {
                        return objE;
                    }
                    function1 = function2;
                    str2 = str3;
                    obj = objB;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function1 = (Function1) this.L$3;
            str = (String) this.L$2;
            str2 = (String) this.L$1;
            aVar = (ty.a) this.L$0;
            ResultKt.b(obj);
            BaseDto baseDto = (BaseDto) obj;
            uo.b.a.f(uo.b.f78622a, "UploadLoggerManager", "reportUploadLogsResult code=" + baseDto.getCode(), false, 4, null);
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                LoggerBean loggerBean = (LoggerBean) baseDto.getData();
                if (loggerBean == null || (logId = loggerBean.getLogId()) == null) {
                    if (aVar != null) {
                        ty.a.C0857a.a(aVar, "", "", "", null, 8, null);
                    }
                } else if (function1 != null) {
                    function1.invoke(logId);
                }
                UploadLoggerManager.f59261a.d(str2, str);
            } else if (aVar != null) {
                ty.a.C0857a.a(aVar, "", "", "", null, 8, null);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            uo.b.a.f(uo.b.f78622a, "UploadLoggerManager", e11.toString(), false, 4, null);
            ty.a aVar3 = this.$uploadCallback;
            if (aVar3 != null) {
                e11.printStackTrace();
                ty.a.C0857a.a(aVar3, "", Unit.f68710a.toString(), "", null, 8, null);
            }
        }
        return Unit.f68710a;
    }
}
