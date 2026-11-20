package com.transsion.push.helper;

import android.content.Context;
import com.blankj.utilcode.util.h0;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.bean.MsgType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class RoomHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RoomHelper f56922a = new RoomHelper();

    public final Object a(Context context, Continuation<? super List<MsgBean>> continuation) {
        return b(context, MsgType.LOCAL_PUSH.getType(), continuation);
    }

    public final Object b(Context context, String str, Continuation<? super List<MsgBean>> continuation) {
        return AppDatabase.f51036p.b(context).G0().g(str, continuation);
    }

    public final Object c(Context context, String str, Continuation<? super MsgBean> continuation) {
        return AppDatabase.f51036p.b(context).G0().f(str, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(Context context, Continuation<? super MsgBean> continuation) throws Throwable {
        RoomHelper$getNewestMsgByReceiveTime$1 roomHelper$getNewestMsgByReceiveTime$1;
        if (continuation instanceof RoomHelper$getNewestMsgByReceiveTime$1) {
            roomHelper$getNewestMsgByReceiveTime$1 = (RoomHelper$getNewestMsgByReceiveTime$1) continuation;
            int i11 = roomHelper$getNewestMsgByReceiveTime$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                roomHelper$getNewestMsgByReceiveTime$1.label = i11 - Integer.MIN_VALUE;
            } else {
                roomHelper$getNewestMsgByReceiveTime$1 = new RoomHelper$getNewestMsgByReceiveTime$1(this, continuation);
            }
        } else {
            roomHelper$getNewestMsgByReceiveTime$1 = new RoomHelper$getNewestMsgByReceiveTime$1(this, continuation);
        }
        Object objE = roomHelper$getNewestMsgByReceiveTime$1.result;
        Object objE2 = kotlin.coroutines.intrinsics.a.e();
        int i12 = roomHelper$getNewestMsgByReceiveTime$1.label;
        if (i12 == 0) {
            ResultKt.b(objE);
            xr.a aVarG0 = AppDatabase.f51036p.b(context).G0();
            roomHelper$getNewestMsgByReceiveTime$1.label = 1;
            objE = aVarG0.e(roomHelper$getNewestMsgByReceiveTime$1);
            if (objE == objE2) {
                return objE2;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objE);
        }
        List list = (List) objE;
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        return list.get(0);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object e(Context context, Continuation<? super MsgBean> continuation) throws Throwable {
        RoomHelper$getNewestMsgByShowTime$1 roomHelper$getNewestMsgByShowTime$1;
        if (continuation instanceof RoomHelper$getNewestMsgByShowTime$1) {
            roomHelper$getNewestMsgByShowTime$1 = (RoomHelper$getNewestMsgByShowTime$1) continuation;
            int i11 = roomHelper$getNewestMsgByShowTime$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                roomHelper$getNewestMsgByShowTime$1.label = i11 - Integer.MIN_VALUE;
            } else {
                roomHelper$getNewestMsgByShowTime$1 = new RoomHelper$getNewestMsgByShowTime$1(this, continuation);
            }
        } else {
            roomHelper$getNewestMsgByShowTime$1 = new RoomHelper$getNewestMsgByShowTime$1(this, continuation);
        }
        Object objB = roomHelper$getNewestMsgByShowTime$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = roomHelper$getNewestMsgByShowTime$1.label;
        if (i12 == 0) {
            ResultKt.b(objB);
            xr.a aVarG0 = AppDatabase.f51036p.b(context).G0();
            roomHelper$getNewestMsgByShowTime$1.label = 1;
            objB = aVarG0.b(roomHelper$getNewestMsgByShowTime$1);
            if (objB == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objB);
        }
        List list = (List) objB;
        if (list == null || !(!list.isEmpty())) {
            return null;
        }
        return list.get(0);
    }

    public final Object f(Context context, Continuation<? super List<MsgBean>> continuation) {
        return b(context, MsgType.SUBJECT_SEEKING.getType(), continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object g(Context context, Continuation<? super Boolean> continuation) throws Throwable {
        RoomHelper$hasGetMsgToday$1 roomHelper$hasGetMsgToday$1;
        Long receiveTime;
        if (continuation instanceof RoomHelper$hasGetMsgToday$1) {
            roomHelper$hasGetMsgToday$1 = (RoomHelper$hasGetMsgToday$1) continuation;
            int i11 = roomHelper$hasGetMsgToday$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                roomHelper$hasGetMsgToday$1.label = i11 - Integer.MIN_VALUE;
            } else {
                roomHelper$hasGetMsgToday$1 = new RoomHelper$hasGetMsgToday$1(this, continuation);
            }
        } else {
            roomHelper$hasGetMsgToday$1 = new RoomHelper$hasGetMsgToday$1(this, continuation);
        }
        Object objD = roomHelper$hasGetMsgToday$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = roomHelper$hasGetMsgToday$1.label;
        if (i12 == 0) {
            ResultKt.b(objD);
            roomHelper$hasGetMsgToday$1.label = 1;
            objD = d(context, roomHelper$hasGetMsgToday$1);
            if (objD == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objD);
        }
        MsgBean msgBean = (MsgBean) objD;
        return (msgBean == null || (receiveTime = msgBean.getReceiveTime()) == null || !h0.f(receiveTime.longValue())) ? Boxing.a(false) : Boxing.a(true);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:38:0x00db  */
    /* JADX WARN: Code duplicated, block: B:42:0x0108 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:46:0x010f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x009b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:? A[LOOP:1: B:24:0x008d->B:53:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00bd -> B:31:0x00c0). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x0106 -> B:43:0x0109). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:42:0x0108
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object h(android.content.Context r9, com.transsion.baselib.db.notification.PullMsgResp r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.push.helper.RoomHelper.h(android.content.Context, com.transsion.baselib.db.notification.PullMsgResp, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object i(Context context, MsgBean msgBean, Continuation<? super Unit> continuation) {
        Object objC = AppDatabase.f51036p.b(context).G0().c(msgBean, continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }
}
