package com.transsion.push.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.PushManager;
import com.transsion.push.R$dimen;
import com.transsion.push.bean.MsgType;
import com.transsion.push.utils.NotificationUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.k;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import uo.b;

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
public final class PushMsgHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushMsgHelper f56891a = new PushMsgHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56892b = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.push.helper.PushMsgHelper$imageH$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf((int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_height));
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MsgBean f56893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f56894b;

        public a(MsgBean msgBean, Context context) {
            this.f56893a = msgBean;
            this.f56894b = context;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            b.a.f(b.f78622a, "PushMsgHelper", "onFailure", false, 4, null);
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            Long lN;
            super.onLoadFailed(drawable);
            if (Intrinsics.b(this.f56893a.getType(), MsgType.ONLINE_JSON_PUSH.getType())) {
                PushManager pushManager = PushManager.getInstance();
                String messageId = this.f56893a.getMessageId();
                pushManager.trackShow((messageId == null || (lN = k.n(messageId)) == null) ? 0L : lN.longValue(), 7);
            }
        }

        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
            Intrinsics.g(resource, "resource");
            b.a.f(b.f78622a, "PushMsgHelper", "onSuccess", false, 4, null);
            if (this.f56893a.isPermanent()) {
                NotificationShowHelper.f56890a.r(this.f56894b, this.f56893a, resource);
            } else {
                NotificationShowHelper.f56890a.q(this.f56894b, this.f56893a, resource);
            }
        }

        @Override // com.bumptech.glide.request.target.Target
        public /* bridge */ /* synthetic */ void onResourceReady(Object obj, Transition transition) {
            onResourceReady((Bitmap) obj, (Transition<? super Bitmap>) transition);
        }
    }

    public final void b(Context context, MsgBean permanentMsgBean) {
        Intrinsics.g(context, "context");
        Intrinsics.g(permanentMsgBean, "permanentMsgBean");
        d(context, permanentMsgBean);
    }

    public final void c(Context context, MsgBean msgBean) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgBean, "msgBean");
        j.d(l0.a(w0.b()), null, null, new PushMsgHelper$handlePushMsg$1(context, msgBean, null), 3, null);
    }

    public final void d(Context context, MsgBean msgBean) {
        b.a.f(b.f78622a, "PushMsgHelper", "handleRequest", false, 4, null);
        NotificationShowHelper notificationShowHelper = NotificationShowHelper.f56890a;
        List<String> listH = notificationShowHelper.h(msgBean);
        if (!listH.isEmpty()) {
            try {
                String str = listH.get(0);
                if (msgBean.getBuiltIn()) {
                    notificationShowHelper.q(context, msgBean, BitmapFactory.decodeStream(context.getAssets().open(str)));
                } else {
                    Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load(NotificationUtil.f57032a.E(str)).into(new a(msgBean, context));
                }
            } catch (Exception unused) {
                b.a.f(b.f78622a, "PushMsgHelper", "onFailure", false, 4, null);
            }
        }
    }
}
