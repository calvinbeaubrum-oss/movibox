package com.transsion.subroom.deeplink;

import android.content.Context;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.bean.MsgStatus;
import com.transsion.push.helper.RoomHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subroom.deeplink.DeepLinkHandler$updateMsgStatus$1", f = "DeepLinkHandler.kt", l = {113, 118}, m = "invokeSuspend")
public final class DeepLinkHandler$updateMsgStatus$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isPermanent;
    final /* synthetic */ String $messageId;
    Object L$0;
    int label;
    final /* synthetic */ DeepLinkHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeepLinkHandler$updateMsgStatus$1(String str, DeepLinkHandler deepLinkHandler, boolean z11, Continuation<? super DeepLinkHandler$updateMsgStatus$1> continuation) {
        super(2, continuation);
        this.$messageId = str;
        this.this$0 = deepLinkHandler;
        this.$isPermanent = z11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeepLinkHandler$updateMsgStatus$1(this.$messageId, this.this$0, this.$isPermanent, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DeepLinkHandler$updateMsgStatus$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0045  */
    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    /* JADX WARN: Code duplicated, block: B:22:0x006e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MsgBean msgBean;
        boolean z11;
        MsgStatus msgStatus;
        RoomHelper roomHelper;
        Context applicationContext;
        Object objE = a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (this.$messageId != null) {
                RoomHelper roomHelper2 = RoomHelper.f56922a;
                Context applicationContext2 = this.this$0.getApplicationContext();
                Intrinsics.f(applicationContext2, "applicationContext");
                String str = this.$messageId;
                this.label = 1;
                obj = roomHelper2.c(applicationContext2, str, this);
                if (obj == objE) {
                    return objE;
                }
                msgBean = (MsgBean) obj;
                if (msgBean != null) {
                    z11 = this.$isPermanent;
                    DeepLinkHandler deepLinkHandler = this.this$0;
                    msgStatus = MsgStatus.CLICKED;
                    msgBean.setMsgStatus(msgStatus.ordinal());
                    if (z11) {
                        msgBean.setPermanentMsgStatus(msgStatus.ordinal());
                    }
                    roomHelper = RoomHelper.f56922a;
                    applicationContext = deepLinkHandler.getApplicationContext();
                    Intrinsics.f(applicationContext, "applicationContext");
                    this.L$0 = msgBean;
                    this.label = 2;
                    if (roomHelper.i(applicationContext, msgBean, this) == objE) {
                        return objE;
                    }
                }
            }
        } else if (i11 == 1) {
            ResultKt.b(obj);
            msgBean = (MsgBean) obj;
            if (msgBean != null) {
                z11 = this.$isPermanent;
                DeepLinkHandler deepLinkHandler2 = this.this$0;
                msgStatus = MsgStatus.CLICKED;
                msgBean.setMsgStatus(msgStatus.ordinal());
                if (z11) {
                    msgBean.setPermanentMsgStatus(msgStatus.ordinal());
                }
                roomHelper = RoomHelper.f56922a;
                applicationContext = deepLinkHandler2.getApplicationContext();
                Intrinsics.f(applicationContext, "applicationContext");
                this.L$0 = msgBean;
                this.label = 2;
                if (roomHelper.i(applicationContext, msgBean, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i11 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
