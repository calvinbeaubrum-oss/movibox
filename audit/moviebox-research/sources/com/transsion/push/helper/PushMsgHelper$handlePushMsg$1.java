package com.transsion.push.helper;

import android.content.Context;
import com.transsion.baselib.db.notification.MsgBean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
import uo.b;

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
@DebugMetadata(c = "com.transsion.push.helper.PushMsgHelper$handlePushMsg$1", f = "PushMsgHelper.kt", l = {40}, m = "invokeSuspend")
public final class PushMsgHelper$handlePushMsg$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MsgBean $msgBean;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushMsgHelper$handlePushMsg$1(Context context, MsgBean msgBean, Continuation<? super PushMsgHelper$handlePushMsg$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$msgBean = msgBean;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushMsgHelper$handlePushMsg$1(this.$context, this.$msgBean, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PushMsgHelper$handlePushMsg$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            RoomHelper roomHelper = RoomHelper.f56922a;
            Context context = this.$context;
            this.label = 1;
            obj = roomHelper.e(context, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Context context2 = this.$context;
        MsgBean msgBean = this.$msgBean;
        MsgBean msgBean2 = (MsgBean) obj;
        b.a aVar = b.f78622a;
        b.a.f(aVar, "PushMsgHelper", "showTime: " + (msgBean2 != null ? msgBean2.getShowTime() : null), false, 4, null);
        if ((msgBean2 != null ? msgBean2.getShowTime() : null) == null) {
            PushMsgHelper.f56891a.d(context2, msgBean);
        } else {
            Long showTime = msgBean2.getShowTime();
            if (showTime != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() - showTime.longValue();
                b.a.f(aVar, "PushMsgHelper", "messageId= " + msgBean.getMessageId() + " gap=" + jCurrentTimeMillis, false, 4, null);
                if ((Intrinsics.b(msgBean.getMessageId(), msgBean2.getMessageId()) || jCurrentTimeMillis <= 1800000) && !Intrinsics.b(msgBean.getMessageId(), msgBean2.getMessageId())) {
                    return Unit.f68710a;
                }
                PushMsgHelper.f56891a.d(context2, msgBean);
            }
        }
        return Unit.f68710a;
    }
}
