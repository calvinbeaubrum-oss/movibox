package com.transsnet.downloader.viewmodel;

import androidx.core.view.MotionEventCompat;
import com.google.gson.JsonObject;
import com.tn.lib.net.bean.BaseDto;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "com.transsnet.downloader.viewmodel.DownloadViewModel$getMovieRec$1", f = "DownloadViewModel.kt", l = {MotionEventCompat.AXIS_GENERIC_14}, m = "invokeSuspend")
public final class DownloadViewModel$getMovieRec$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $page;
    final /* synthetic */ int $perPage;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DownloadViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadViewModel$getMovieRec$1(DownloadViewModel downloadViewModel, int i11, int i12, Continuation<? super DownloadViewModel$getMovieRec$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadViewModel;
        this.$page = i11;
        this.$perPage = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadViewModel$getMovieRec$1(this.this$0, this.$page, this.$perPage, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadViewModel$getMovieRec$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        DownloadViewModel downloadViewModel;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                this.this$0.f61236d = true;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("page", Boxing.d(this.$page));
                jsonObject.addProperty("perPage", Boxing.d(this.$perPage));
                ip.b.a aVar = ip.b.f67591a;
                String string = jsonObject.toString();
                Intrinsics.f(string, "jsonObject.toString()");
                RequestBody requestBodyA = aVar.a(string);
                if (requestBodyA != null) {
                    DownloadViewModel downloadViewModel2 = this.this$0;
                    i00.a aVarV = downloadViewModel2.v();
                    this.L$0 = requestBodyA;
                    this.L$1 = downloadViewModel2;
                    this.label = 1;
                    obj = aVarV.j(requestBodyA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    downloadViewModel = downloadViewModel2;
                }
                return Unit.f68710a;
            }
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            downloadViewModel = (DownloadViewModel) this.L$1;
            ResultKt.b(obj);
            downloadViewModel.s().n((BaseDto) obj);
            downloadViewModel.f61236d = false;
        } catch (Exception unused) {
            this.this$0.s().n(new BaseDto<>());
            this.this$0.f61236d = false;
        }
        return Unit.f68710a;
    }
}
