package com.transsion.push.utils;

import android.content.Context;
import com.blankj.utilcode.util.h0;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.push.helper.RoomHelper;
import com.transsion.pushapi.TriggerSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$loadSeekSubjectMsg$1", f = "NotificationUtil.kt", l = {359}, m = "invokeSuspend")
public final class NotificationUtil$loadSeekSubjectMsg$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TriggerSource $triggerSource;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtil$loadSeekSubjectMsg$1(Context context, TriggerSource triggerSource, Continuation<? super NotificationUtil$loadSeekSubjectMsg$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$triggerSource = triggerSource;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$loadSeekSubjectMsg$1(this.$context, this.$triggerSource, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NotificationUtil$loadSeekSubjectMsg$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (h0.f(NotificationMMKVUtil.f57030a.a().getLong("seeking_msg_show_time", 0L))) {
                return Unit.f68710a;
            }
            RoomHelper roomHelper = RoomHelper.f56922a;
            Context context = this.$context;
            this.label = 1;
            objF = roomHelper.f(context, this);
            if (objF == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objF = obj;
        }
        List list = (List) objF;
        if (list != null) {
            Context context2 = this.$context;
            TriggerSource triggerSource = this.$triggerSource;
            if (list.isEmpty()) {
                return Unit.f68710a;
            }
            NotificationUtil notificationUtil = NotificationUtil.f57032a;
            NotificationUtil.f57033b = notificationUtil.B();
            notificationUtil.S(context2, new PullMsgResp(list, NotificationUtil.f57033b, null, 4, null), triggerSource);
            uo.b.a aVar = uo.b.f78622a;
            MsgBean msgBean = (MsgBean) CollectionsKt___CollectionsKt.g0(list);
            uo.b.a.f(aVar, "NotificationUtil", "show seek notification msg: " + (msgBean != null ? msgBean.getReceiveTime() : null), false, 4, null);
        }
        return Unit.f68710a;
    }
}
