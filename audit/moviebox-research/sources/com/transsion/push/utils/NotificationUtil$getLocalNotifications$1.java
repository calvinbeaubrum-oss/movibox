package com.transsion.push.utils;

import android.content.Context;
import com.blankj.utilcode.util.n;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.push.PushConstants;
import com.transsion.push.helper.RoomHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1", f = "NotificationUtil.kt", l = {399}, m = "invokeSuspend")
public final class NotificationUtil$getLocalNotifications$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX INFO: renamed from: com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$1", f = "NotificationUtil.kt", l = {381, 383, 387, 392}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super PullMsgResp>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$context, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super PullMsgResp> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00af  */
        /* JADX WARN: Code duplicated, block: B:29:0x00c3 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:35:0x00fb A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:36:0x00fc  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlinx.coroutines.flow.b bVar;
            kotlinx.coroutines.flow.b bVar2;
            BaseDto baseDto;
            BaseDto baseDto2;
            PullMsgResp pullMsgResp;
            Context context;
            RoomHelper roomHelper;
            NotificationUtil notificationUtil;
            Object data;
            PullMsgResp pullMsgResp2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
                    kw.a aVarZ = NotificationUtil.f57032a.z();
                    String strA = cp.a.f62775a.a();
                    this.L$0 = bVar;
                    this.label = 2;
                    obj = aVarZ.b(strA, this);
                    if (obj == objE) {
                        return objE;
                    }
                    baseDto2 = (BaseDto) obj;
                    bVar2 = bVar;
                    pullMsgResp = (PullMsgResp) baseDto2.getData();
                    if (pullMsgResp != null) {
                        context = this.$context;
                        roomHelper = RoomHelper.f56922a;
                        this.L$0 = bVar2;
                        this.L$1 = baseDto2;
                        this.L$2 = context;
                        this.L$3 = pullMsgResp;
                        this.label = 3;
                        if (roomHelper.h(context, pullMsgResp, this) == objE) {
                            return objE;
                        }
                        notificationUtil = NotificationUtil.f57032a;
                        if (notificationUtil.B() == null) {
                            notificationUtil.q(context, pullMsgResp.getConfig());
                        }
                        NotificationMMKVUtil.f57030a.a().putString(PushConstants.SP_KEY_CONFIG, n.j(pullMsgResp.getConfig()));
                        data = baseDto2.getData();
                        this.L$0 = context;
                        this.L$1 = pullMsgResp;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 4;
                        if (bVar2.emit(data, this) == objE) {
                            return objE;
                        }
                        pullMsgResp2 = pullMsgResp;
                    }
                    return Unit.f68710a;
                }
                BaseDto baseDto3 = new BaseDto();
                BuiltInNotificationHelper builtInNotificationHelperS = NotificationUtil.f57032a.s();
                Context context2 = this.$context;
                this.L$0 = bVar;
                this.L$1 = baseDto3;
                this.L$2 = baseDto3;
                this.label = 1;
                Object objA = builtInNotificationHelperS.a(context2, this);
                if (objA == objE) {
                    return objE;
                }
                bVar2 = bVar;
                baseDto = baseDto3;
                obj = objA;
                baseDto2 = baseDto;
                baseDto.setData(obj);
                pullMsgResp = (PullMsgResp) baseDto2.getData();
                if (pullMsgResp != null) {
                    context = this.$context;
                    roomHelper = RoomHelper.f56922a;
                    this.L$0 = bVar2;
                    this.L$1 = baseDto2;
                    this.L$2 = context;
                    this.L$3 = pullMsgResp;
                    this.label = 3;
                    if (roomHelper.h(context, pullMsgResp, this) == objE) {
                        return objE;
                    }
                    notificationUtil = NotificationUtil.f57032a;
                    if (notificationUtil.B() == null) {
                        notificationUtil.q(context, pullMsgResp.getConfig());
                    }
                    NotificationMMKVUtil.f57030a.a().putString(PushConstants.SP_KEY_CONFIG, n.j(pullMsgResp.getConfig()));
                    data = baseDto2.getData();
                    this.L$0 = context;
                    this.L$1 = pullMsgResp;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 4;
                    if (bVar2.emit(data, this) == objE) {
                        return objE;
                    }
                    pullMsgResp2 = pullMsgResp;
                }
                return Unit.f68710a;
            }
            if (i11 == 1) {
                baseDto = (BaseDto) this.L$2;
                baseDto2 = (BaseDto) this.L$1;
                bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                baseDto.setData(obj);
                pullMsgResp = (PullMsgResp) baseDto2.getData();
                if (pullMsgResp != null) {
                    context = this.$context;
                    roomHelper = RoomHelper.f56922a;
                    this.L$0 = bVar2;
                    this.L$1 = baseDto2;
                    this.L$2 = context;
                    this.L$3 = pullMsgResp;
                    this.label = 3;
                    if (roomHelper.h(context, pullMsgResp, this) == objE) {
                        return objE;
                    }
                    notificationUtil = NotificationUtil.f57032a;
                    if (notificationUtil.B() == null) {
                        notificationUtil.q(context, pullMsgResp.getConfig());
                    }
                    NotificationMMKVUtil.f57030a.a().putString(PushConstants.SP_KEY_CONFIG, n.j(pullMsgResp.getConfig()));
                    data = baseDto2.getData();
                    this.L$0 = context;
                    this.L$1 = pullMsgResp;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 4;
                    if (bVar2.emit(data, this) == objE) {
                        return objE;
                    }
                    pullMsgResp2 = pullMsgResp;
                }
                return Unit.f68710a;
            }
            if (i11 == 2) {
                bVar = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                baseDto2 = (BaseDto) obj;
                bVar2 = bVar;
                pullMsgResp = (PullMsgResp) baseDto2.getData();
                if (pullMsgResp != null) {
                    context = this.$context;
                    roomHelper = RoomHelper.f56922a;
                    this.L$0 = bVar2;
                    this.L$1 = baseDto2;
                    this.L$2 = context;
                    this.L$3 = pullMsgResp;
                    this.label = 3;
                    if (roomHelper.h(context, pullMsgResp, this) == objE) {
                        return objE;
                    }
                    notificationUtil = NotificationUtil.f57032a;
                    if (notificationUtil.B() == null) {
                        notificationUtil.q(context, pullMsgResp.getConfig());
                    }
                    NotificationMMKVUtil.f57030a.a().putString(PushConstants.SP_KEY_CONFIG, n.j(pullMsgResp.getConfig()));
                    data = baseDto2.getData();
                    this.L$0 = context;
                    this.L$1 = pullMsgResp;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 4;
                    if (bVar2.emit(data, this) == objE) {
                        return objE;
                    }
                    pullMsgResp2 = pullMsgResp;
                }
                return Unit.f68710a;
            }
            if (i11 == 3) {
                PullMsgResp pullMsgResp3 = (PullMsgResp) this.L$3;
                Context context3 = (Context) this.L$2;
                baseDto2 = (BaseDto) this.L$1;
                bVar2 = (kotlinx.coroutines.flow.b) this.L$0;
                ResultKt.b(obj);
                pullMsgResp = pullMsgResp3;
                context = context3;
                notificationUtil = NotificationUtil.f57032a;
                if (notificationUtil.B() == null) {
                    notificationUtil.q(context, pullMsgResp.getConfig());
                }
                NotificationMMKVUtil.f57030a.a().putString(PushConstants.SP_KEY_CONFIG, n.j(pullMsgResp.getConfig()));
                data = baseDto2.getData();
                this.L$0 = context;
                this.L$1 = pullMsgResp;
                this.L$2 = null;
                this.L$3 = null;
                this.label = 4;
                if (bVar2.emit(data, this) == objE) {
                    return objE;
                }
                pullMsgResp2 = pullMsgResp;
            } else {
                if (i11 != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                pullMsgResp2 = (PullMsgResp) this.L$1;
                context = (Context) this.L$0;
                ResultKt.b(obj);
            }
            NotificationUtil.f57032a.M(context, pullMsgResp2);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLocalNotifications$1$2", f = "NotificationUtil.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super PullMsgResp>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super PullMsgResp> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass2(continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", "get local notification error", false, 4, null);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f57039a;

        public a(Context context) {
            this.f57039a = context;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(PullMsgResp pullMsgResp, Continuation<? super Unit> continuation) {
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", "get local notification =" + pullMsgResp + "}", false, 4, null);
            if (pullMsgResp != null) {
                Context context = this.f57039a;
                NotificationUtil notificationUtil = NotificationUtil.f57032a;
                if (notificationUtil.l()) {
                    NotificationUtil.V(notificationUtil, context, pullMsgResp.getItems(), null, null, 12, null);
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtil$getLocalNotifications$1(Context context, Continuation<? super NotificationUtil$getLocalNotifications$1> continuation) {
        super(2, continuation);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$getLocalNotifications$1(this.$context, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NotificationUtil$getLocalNotifications$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.q(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.$context, null)), w0.b()), new AnonymousClass2(null));
            a aVar = new a(this.$context);
            this.label = 1;
            if (aVarE.a(aVar, this) == objE) {
                return objE;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f68710a;
    }
}
