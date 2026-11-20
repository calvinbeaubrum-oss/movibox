package com.transsion.push.utils;

import android.content.Context;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
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
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$loadNotificationMsg$1", f = "NotificationUtil.kt", l = {326, 337}, m = "invokeSuspend")
public final class NotificationUtil$loadNotificationMsg$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ TriggerSource $triggerSource;
    Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtil$loadNotificationMsg$1(TriggerSource triggerSource, Context context, Continuation<? super NotificationUtil$loadNotificationMsg$1> continuation) {
        super(2, continuation);
        this.$triggerSource = triggerSource;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$loadNotificationMsg$1(this.$triggerSource, this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NotificationUtil$loadNotificationMsg$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:36:0x009c  */
    /* JADX WARN: Code duplicated, block: B:44:0x00be A[Catch: Exception -> 0x001b, TRY_LEAVE, TryCatch #0 {Exception -> 0x001b, blocks: (B:7:0x0014, B:34:0x0094, B:37:0x009e, B:39:0x00a6, B:41:0x00ac, B:43:0x00b4, B:44:0x00be, B:13:0x0026, B:25:0x004d, B:27:0x0051, B:29:0x005b, B:30:0x0084, B:16:0x002f, B:18:0x0035, B:20:0x003d, B:22:0x0040), top: B:49:0x000a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objA;
        Object objG;
        List list;
        MsgBean msgBean;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                    objA = obj;
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) this.L$0;
                    ResultKt.b(obj);
                    objG = obj;
                }
                if (((Boolean) objG).booleanValue()) {
                    NotificationUtil.f57032a.y(this.$context, this.$triggerSource);
                    uo.b.a.f(uo.b.f78622a, "NotificationUtil", "get notification from network", false, 4, null);
                } else if (list != null && (msgBean = (MsgBean) CollectionsKt___CollectionsKt.g0(list)) != null && msgBean.getBuiltIn() && com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    NotificationUtil.f57032a.y(this.$context, this.$triggerSource);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (this.$triggerSource == TriggerSource.NETWORK_CONNECTED && !RoomActivityLifecycleCallbacks.f51239a.i()) {
                return Unit.f68710a;
            }
            RoomHelper roomHelper = RoomHelper.f56922a;
            Context context = this.$context;
            this.label = 1;
            objA = roomHelper.a(context, this);
            if (objA == objE) {
                return objE;
            }
            List list2 = (List) objA;
            if (list2 != null) {
                Context context2 = this.$context;
                TriggerSource triggerSource = this.$triggerSource;
                if (!list2.isEmpty()) {
                    NotificationUtil notificationUtil = NotificationUtil.f57032a;
                    NotificationUtil.f57033b = notificationUtil.B();
                    notificationUtil.S(context2, new PullMsgResp(list2, NotificationUtil.f57033b, null, 4, null), triggerSource);
                    uo.b.a.f(uo.b.f78622a, "NotificationUtil", " show notification from db", false, 4, null);
                }
            }
            RoomHelper roomHelper2 = RoomHelper.f56922a;
            Context context3 = this.$context;
            this.L$0 = list2;
            this.label = 2;
            objG = roomHelper2.g(context3, this);
            if (objG == objE) {
                return objE;
            }
            list = list2;
            if (((Boolean) objG).booleanValue()) {
                NotificationUtil.f57032a.y(this.$context, this.$triggerSource);
                uo.b.a.f(uo.b.f78622a, "NotificationUtil", "get notification from network", false, 4, null);
            } else if (list != null) {
                NotificationUtil.f57032a.y(this.$context, this.$triggerSource);
            }
            return Unit.f68710a;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
