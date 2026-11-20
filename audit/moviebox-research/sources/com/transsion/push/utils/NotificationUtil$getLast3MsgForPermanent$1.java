package com.transsion.push.utils;

import android.content.Context;
import com.transsion.push.bean.ShowOrder;
import com.transsion.push.helper.RoomHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;

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
@DebugMetadata(c = "com.transsion.push.utils.NotificationUtil$getLast3MsgForPermanent$1", f = "NotificationUtil.kt", l = {546, 549, 551}, m = "invokeSuspend")
public final class NotificationUtil$getLast3MsgForPermanent$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $messageId;
    final /* synthetic */ boolean $needDelay;
    final /* synthetic */ ShowOrder $showOrder;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtil$getLast3MsgForPermanent$1(boolean z11, Context context, ShowOrder showOrder, String str, Continuation<? super NotificationUtil$getLast3MsgForPermanent$1> continuation) {
        super(2, continuation);
        this.$needDelay = z11;
        this.$context = context;
        this.$showOrder = showOrder;
        this.$messageId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NotificationUtil$getLast3MsgForPermanent$1(this.$needDelay, this.$context, this.$showOrder, this.$messageId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NotificationUtil$getLast3MsgForPermanent$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x004c  */
    /* JADX WARN: Code duplicated, block: B:24:0x0058 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x005d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List list;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 == 2) {
                    ResultKt.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        RoomHelper roomHelper = RoomHelper.f56922a;
                        Context context = this.$context;
                        this.label = 3;
                        obj = roomHelper.a(context, this);
                        if (obj == objE) {
                            return objE;
                        }
                    }
                    return Unit.f68710a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            list = (List) obj;
            if (list != null) {
                NotificationUtil.f57032a.U(this.$context, list, this.$showOrder, this.$messageId);
            }
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", " show notification from db", false, 4, null);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        if (this.$needDelay) {
            this.label = 1;
            if (r0.a(500L, this) == objE) {
                return objE;
            }
        }
        RoomHelper roomHelper2 = RoomHelper.f56922a;
        Context context2 = this.$context;
        this.label = 2;
        obj = roomHelper2.g(context2, this);
        if (obj == objE) {
            return objE;
        }
        if (((Boolean) obj).booleanValue()) {
            RoomHelper roomHelper3 = RoomHelper.f56922a;
            Context context3 = this.$context;
            this.label = 3;
            obj = roomHelper3.a(context3, this);
            if (obj == objE) {
                return objE;
            }
            list = (List) obj;
            if (list != null) {
                NotificationUtil.f57032a.U(this.$context, list, this.$showOrder, this.$messageId);
            }
            uo.b.a.f(uo.b.f78622a, "NotificationUtil", " show notification from db", false, 4, null);
        }
        return Unit.f68710a;
    }
}
