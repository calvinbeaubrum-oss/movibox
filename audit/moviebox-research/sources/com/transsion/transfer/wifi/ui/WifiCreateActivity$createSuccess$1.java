package com.transsion.transfer.wifi.ui;

import android.graphics.Bitmap;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.gslb.Worker;
import com.transsion.transfer.R$id;
import com.transsion.transfer.wifi.qrcode.QrCodeUtil;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.transfer.wifi.ui.WifiCreateActivity$createSuccess$1", f = "WifiCreateActivity.kt", l = {262, 270}, m = "invokeSuspend")
public final class WifiCreateActivity$createSuccess$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ qy.a $wifiInfoModel;
    long J$0;
    int label;
    final /* synthetic */ WifiCreateActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WifiCreateActivity$createSuccess$1(qy.a aVar, WifiCreateActivity wifiCreateActivity, long j11, Continuation<? super WifiCreateActivity$createSuccess$1> continuation) {
        super(2, continuation);
        this.$wifiInfoModel = aVar;
        this.this$0 = wifiCreateActivity;
        this.$duration = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WifiCreateActivity$createSuccess$1(this.$wifiInfoModel, this.this$0, this.$duration, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((WifiCreateActivity$createSuccess$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x007e  */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x007e, please report this as an issue */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        long jCurrentTimeMillis;
        Object objG;
        Unit unit;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                long j11 = this.J$0;
                ResultKt.b(obj);
                jCurrentTimeMillis = j11;
                objG = obj;
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            unit = Unit.f68710a;
            if (unit == null) {
                WifiCreateActivity wifiCreateActivity = this.this$0;
                long j12 = this.$duration;
                com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, wifiCreateActivity.getClassTag() + " --> createSuccess() --> syncEncodeQRCode() --> 创建二维码失败了", false, 2, null);
                wifiCreateActivity.z0(Worker.WHAT_SYNC_DATA, j12);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        jCurrentTimeMillis = System.currentTimeMillis();
        QrCodeUtil qrCodeUtil = QrCodeUtil.f59192a;
        String strB = qrCodeUtil.b(this.$wifiInfoModel);
        this.J$0 = jCurrentTimeMillis;
        this.label = 1;
        objG = QrCodeUtil.g(qrCodeUtil, strB, 0, 0, this, 6, null);
        if (objG == objE) {
            return objE;
        }
        Bitmap bitmap = (Bitmap) objG;
        if (bitmap != null) {
            WifiCreateActivity wifiCreateActivity2 = this.this$0;
            long j13 = this.$duration;
            ((AppCompatImageView) wifiCreateActivity2.findViewById(R$id.ivTransWifiQrCode)).setImageBitmap(bitmap);
            wifiCreateActivity2.f59221m = false;
            py.c.f74067a.j(j13, System.currentTimeMillis() - jCurrentTimeMillis);
            a2 a2VarC = w0.c();
            WifiCreateActivity$createSuccess$1$1$1 wifiCreateActivity$createSuccess$1$1$1 = new WifiCreateActivity$createSuccess$1$1$1(wifiCreateActivity2, null);
            this.label = 2;
            if (kotlinx.coroutines.h.g(a2VarC, wifiCreateActivity$createSuccess$1$1$1, this) == objE) {
                return objE;
            }
            unit = Unit.f68710a;
        } else {
            unit = null;
        }
        if (unit == null) {
            WifiCreateActivity wifiCreateActivity3 = this.this$0;
            long j14 = this.$duration;
            com.transsion.transfer.wifi.util.g.d(com.transsion.transfer.wifi.util.g.f59252a, wifiCreateActivity3.getClassTag() + " --> createSuccess() --> syncEncodeQRCode() --> 创建二维码失败了", false, 2, null);
            wifiCreateActivity3.z0(Worker.WHAT_SYNC_DATA, j14);
        }
        return Unit.f68710a;
    }
}
