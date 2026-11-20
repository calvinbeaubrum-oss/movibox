package com.transsion.push.utils;

import android.content.Context;
import com.blankj.utilcode.util.n;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.baselib.db.notification.PullMsgResp;
import com.transsion.push.helper.NotificationShowHelper;
import com.transsion.push.helper.RoomHelper;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;

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
public final class BuiltInNotificationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f57026a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Context context, Continuation<? super PullMsgResp> continuation) throws Throwable {
        BuiltInNotificationHelper$getBuiltInNotification$1 builtInNotificationHelper$getBuiltInNotification$1;
        if (continuation instanceof BuiltInNotificationHelper$getBuiltInNotification$1) {
            builtInNotificationHelper$getBuiltInNotification$1 = (BuiltInNotificationHelper$getBuiltInNotification$1) continuation;
            int i11 = builtInNotificationHelper$getBuiltInNotification$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                builtInNotificationHelper$getBuiltInNotification$1.label = i11 - Integer.MIN_VALUE;
            } else {
                builtInNotificationHelper$getBuiltInNotification$1 = new BuiltInNotificationHelper$getBuiltInNotification$1(this, continuation);
            }
        } else {
            builtInNotificationHelper$getBuiltInNotification$1 = new BuiltInNotificationHelper$getBuiltInNotification$1(this, continuation);
        }
        Object objD = builtInNotificationHelper$getBuiltInNotification$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = builtInNotificationHelper$getBuiltInNotification$1.label;
        if (i12 == 0) {
            ResultKt.b(objD);
            RoomHelper roomHelper = RoomHelper.f56922a;
            builtInNotificationHelper$getBuiltInNotification$1.L$0 = context;
            builtInNotificationHelper$getBuiltInNotification$1.label = 1;
            objD = roomHelper.d(context, builtInNotificationHelper$getBuiltInNotification$1);
            if (objD == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            context = (Context) builtInNotificationHelper$getBuiltInNotification$1.L$0;
            ResultKt.b(objD);
        }
        MsgBean msgBean = (MsgBean) objD;
        if (msgBean != null) {
            List<String> listH = NotificationShowHelper.f56890a.h(msgBean);
            if ((!listH.isEmpty()) && StringsKt__StringsKt.Q(listH.get(0), "push/1", false, 2, null)) {
                InputStream it = context.getAssets().open("push/2/notification.json");
                Intrinsics.f(it, "it");
                PullMsgResp pullMsgResp = (PullMsgResp) n.d(Okio.buffer(Okio.source(it)).readUtf8(), PullMsgResp.class);
                uo.b.a.f(uo.b.f78622a, "NotificationUtil", "load built in notification", false, 4, null);
                return pullMsgResp;
            }
        }
        InputStream it2 = context.getAssets().open("push/1/notification.json");
        Intrinsics.f(it2, "it");
        PullMsgResp pullMsgResp2 = (PullMsgResp) n.d(Okio.buffer(Okio.source(it2)).readUtf8(), PullMsgResp.class);
        uo.b.a.f(uo.b.f78622a, "NotificationUtil", "load built in notification", false, 4, null);
        return pullMsgResp2;
    }
}
