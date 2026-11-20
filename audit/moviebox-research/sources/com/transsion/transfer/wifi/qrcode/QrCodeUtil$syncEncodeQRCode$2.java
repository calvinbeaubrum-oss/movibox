package com.transsion.transfer.wifi.qrcode;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import xn.b;

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
@DebugMetadata(c = "com.transsion.transfer.wifi.qrcode.QrCodeUtil$syncEncodeQRCode$2", f = "QrCodeUtil.kt", l = {}, m = "invokeSuspend")
public final class QrCodeUtil$syncEncodeQRCode$2 extends SuspendLambda implements Function2<k0, Continuation<? super Bitmap>, Object> {
    final /* synthetic */ int $height;
    final /* synthetic */ String $text;
    final /* synthetic */ int $width;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QrCodeUtil$syncEncodeQRCode$2(String str, int i11, int i12, Continuation<? super QrCodeUtil$syncEncodeQRCode$2> continuation) {
        super(2, continuation);
        this.$text = str;
        this.$width = i11;
        this.$height = i12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QrCodeUtil$syncEncodeQRCode$2(this.$text, this.$width, this.$height, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Bitmap> continuation) {
        return ((QrCodeUtil$syncEncodeQRCode$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        String str = this.$text;
        int i11 = this.$width;
        int i12 = this.$height;
        try {
            Result.Companion companion = Result.Companion;
            b bVar = new b();
            objM163constructorimpl = Result.m163constructorimpl(bVar.a(bVar.b(str, BarcodeFormat.QR_CODE, i11, i12)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) == null) {
            return objM163constructorimpl;
        }
        return null;
    }
}
