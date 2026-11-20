package com.transsion.push.helper;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.notification.MsgBean;
import com.transsion.push.R$dimen;
import com.transsion.push.R$id;
import com.transsion.push.R$layout;
import com.transsion.push.bean.MsgStyle;
import com.transsion.push.bean.MsgType;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.notification.d;
import com.transsion.push.notification.g;
import com.transsion.push.utils.NotificationUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import org.mvel2.ast.ASTNode;
import uo.b;
import w9.q;

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
@SourceDebugExtension
public final class PushShowPermanentHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static long f56907d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q1 f56912i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PushShowPermanentHelper f56904a = new PushShowPermanentHelper();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f56905b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f56906c = 600000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f56908e = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.push.helper.PushShowPermanentHelper$imageW$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf((int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_width));
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy f56909f = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.push.helper.PushShowPermanentHelper$imageH$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf((int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_height));
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer[] f56910g = {Integer.valueOf(R$id.imageIv1), Integer.valueOf(R$id.imageIv2), Integer.valueOf(R$id.imageIv3), Integer.valueOf(R$id.imageIv4), Integer.valueOf(R$id.imageIv5), Integer.valueOf(R$id.imageIv6), Integer.valueOf(R$id.imageIv7), Integer.valueOf(R$id.imageIv8), Integer.valueOf(R$id.imageIv9), Integer.valueOf(R$id.imageIv10)};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer[] f56911h = {Integer.valueOf(R$id.title1), Integer.valueOf(R$id.title2), Integer.valueOf(R$id.title3), Integer.valueOf(R$id.title4)};

    public static /* synthetic */ PendingIntent i(PushShowPermanentHelper pushShowPermanentHelper, Context context, String str, int i11, int i12, PermanentItemBean permanentItemBean, String str2, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            str2 = null;
        }
        return pushShowPermanentHelper.h(context, str, i11, i12, permanentItemBean, str2);
    }

    public final NotificationCompat.m a(Context context, int i11, List<PermanentItemBean> list, List<Bitmap> list2, d dVar) {
        Object objM163constructorimpl;
        Unit unit;
        RemoteViews remoteViewsI;
        g.a aVar = new g.a(context, i11, R$layout.push_notification_permanent_small_a, R$layout.push_notification_permanent_big_a);
        try {
            Result.Companion companion = Result.Companion;
            PermanentItemBean permanentItemBean = (PermanentItemBean) CollectionsKt___CollectionsKt.e0(list);
            String strS = PushPermanentManager.f56895a.s();
            if (strS.length() == 0) {
                String title = permanentItemBean.getTitle();
                if (title == null) {
                    title = "";
                }
                strS = title;
            }
            aVar.G(dVar.c());
            int i12 = 0;
            aVar.V(R$id.notification_title_tv, StringsKt__StringsKt.c1(strS, '\n'));
            aVar.T(R$id.notification_title_tv, StringsKt__StringsKt.c1(strS, '\n'));
            aVar.O(System.currentTimeMillis());
            PushShowPermanentHelper pushShowPermanentHelper = f56904a;
            aVar.A(pushShowPermanentHelper.h(context, dVar.d(), i11, 1, null, pushShowPermanentHelper.f()));
            aVar.K(true);
            aVar.z(NotificationUtil.f57032a.D());
            RemoteViews remoteViewsJ = aVar.j();
            if (remoteViewsJ != null) {
                for (Object obj : list2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    Bitmap bitmap = (Bitmap) obj;
                    if (i12 < 10) {
                        String strF = i12 == 9 ? f56904a.f() : null;
                        PushShowPermanentHelper pushShowPermanentHelper2 = f56904a;
                        PendingIntent pendingIntentH = pushShowPermanentHelper2.h(context, dVar.d(), i11, 1, list.get(i12), strF);
                        Bitmap bitmapL = pushShowPermanentHelper2.l(context, bitmap);
                        if (bitmapL == null) {
                            bitmapL = bitmap;
                        }
                        Integer[] numArr = f56910g;
                        aVar.S(numArr[i12].intValue(), bitmapL);
                        aVar.U(numArr[i12].intValue(), pendingIntentH);
                        if (i12 < 3) {
                            remoteViewsJ.setImageViewBitmap(numArr[i12].intValue(), bitmapL);
                            aVar.Y(numArr[i12].intValue(), pendingIntentH);
                        }
                    }
                    i12 = i13;
                }
                if (list2.size() < 10 && (remoteViewsI = aVar.i()) != null) {
                    remoteViewsI.setViewVisibility(R$id.content_layout_2, 8);
                }
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
            objM163constructorimpl = Result.m163constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            String message = thM166exceptionOrNullimpl.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("buildTypeABuilder-error:");
            sb2.append(message);
        }
        if (NotificationUtil.f57032a.H()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    public final NotificationCompat.m b(Context context, int i11, List<PermanentItemBean> list, List<Bitmap> list2, d dVar) {
        Object objM163constructorimpl;
        g.a aVar = new g.a(context, i11, R$layout.push_notification_permanent_small_b, R$layout.push_notification_permanent_big_b);
        try {
            Result.Companion companion = Result.Companion;
            PermanentItemBean permanentItemBean = (PermanentItemBean) CollectionsKt___CollectionsKt.e0(list);
            String strS = PushPermanentManager.f56895a.s();
            if (strS.length() == 0) {
                String title = permanentItemBean.getTitle();
                if (title == null) {
                    title = "";
                }
                strS = title;
            }
            aVar.G(dVar.c());
            aVar.V(R$id.notification_title_tv, StringsKt__StringsKt.c1(strS, '\n'));
            aVar.T(R$id.notification_title_tv, StringsKt__StringsKt.c1(strS, '\n'));
            RemoteViews remoteViewsJ = aVar.j();
            if (remoteViewsJ != null) {
                int i12 = 0;
                for (Object obj : list2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        kotlin.collections.g.u();
                    }
                    Bitmap bitmap = (Bitmap) obj;
                    PushShowPermanentHelper pushShowPermanentHelper = f56904a;
                    int i14 = i12;
                    PendingIntent pendingIntentI = i(pushShowPermanentHelper, context, dVar.d(), i11, 2, list.get(i12), null, 32, null);
                    Bitmap bitmapL = pushShowPermanentHelper.l(context, bitmap);
                    if (bitmapL == null) {
                        bitmapL = bitmap;
                    }
                    int byteCount = bitmap.getByteCount();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("bitmap i:");
                    sb2.append(i14);
                    sb2.append(", bitmap:");
                    sb2.append(byteCount);
                    Integer[] numArr = f56910g;
                    aVar.S(numArr[i14].intValue(), bitmapL);
                    if (i14 < 4) {
                        aVar.T(f56911h[i14].intValue(), list.get(i14).getTitle());
                        if (i14 == 0) {
                            aVar.A(pendingIntentI);
                        }
                    }
                    remoteViewsJ.setImageViewBitmap(numArr[i14].intValue(), bitmapL);
                    aVar.U(numArr[i14].intValue(), pendingIntentI);
                    i12 = i13;
                }
            }
            aVar.O(System.currentTimeMillis());
            aVar.K(true);
            aVar.z(NotificationUtil.f57032a.D());
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            String message = thM166exceptionOrNullimpl.getMessage();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("error:");
            sb3.append(message);
        }
        if (NotificationUtil.f57032a.H()) {
            return aVar.P().a(context);
        }
        aVar.R(System.currentTimeMillis());
        aVar.N(true);
        return aVar.P().a(context);
    }

    public final void c() {
        NotificationShowHelper notificationShowHelper = NotificationShowHelper.f56890a;
        notificationShowHelper.e(notificationShowHelper.n());
    }

    public final int d() {
        return ((Number) f56909f.getValue()).intValue();
    }

    public final int e() {
        return ((Number) f56908e.getValue()).intValue();
    }

    public final String f() {
        return "oneroom://com.community.oneroom?type=/main/tab&channel=permanent_push&msgId=111&msg_type=11";
    }

    public final String g(List<PermanentItemBean> msgList) {
        Intrinsics.g(msgList, "msgList");
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        for (Object obj : msgList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.g.u();
            }
            PermanentItemBean permanentItemBean = (PermanentItemBean) obj;
            if (i11 <= 9 && permanentItemBean != null) {
                sb2.append(permanentItemBean.getSubjectId());
            }
            i11 = i12;
        }
        String strC = q.c(sb2.toString());
        Intrinsics.f(strC, "toMd5(id.toString())");
        return strC;
    }

    public final PendingIntent h(Context context, String str, int i11, int i12, PermanentItemBean permanentItemBean, String str2) {
        String strValueOf;
        Intrinsics.g(context, "context");
        NotificationUtil notificationUtil = NotificationUtil.f57032a;
        String type = MsgType.PERMANENT.getType();
        String strValueOf2 = String.valueOf(i12);
        if (permanentItemBean == null || (strValueOf = permanentItemBean.getSubjectId()) == null) {
            strValueOf = String.valueOf(i11);
        }
        Intent intentX = notificationUtil.x(context, str, i11, MsgStyle.SOURCE_PUSH, type, strValueOf2, strValueOf);
        if (intentX == null) {
            return null;
        }
        if (str2 == null) {
            str2 = permanentItemBean != null ? permanentItemBean.getDeeplink() : null;
        }
        intentX.setData(Uri.parse(str2));
        return PendingIntent.getActivity(context, i11, intentX, Build.VERSION.SDK_INT >= 23 ? 201326592 : ASTNode.NOJIT);
    }

    public final void j(Context context, List<PermanentItemBean> msgList, List<Bitmap> bitmapList, int i11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgList, "msgList");
        Intrinsics.g(bitmapList, "bitmapList");
        b.a.f(b.f78622a, "PUSH_SHOW", "showPermanent msgList:" + msgList.size() + ",abType:" + i11 + " ", false, 4, null);
        if (msgList.isEmpty() || bitmapList.isEmpty()) {
            return;
        }
        List<PermanentItemBean> listM0 = CollectionsKt___CollectionsKt.M0(msgList);
        d dVarC = d.f56962d.c(MsgType.PERMANENT.getType());
        NotificationShowHelper notificationShowHelper = NotificationShowHelper.f56890a;
        int iN = notificationShowHelper.n();
        NotificationCompat.m mVarA = i11 == 1 ? a(context, iN, listM0, bitmapList, dVarC) : b(context, iN, listM0, bitmapList, dVarC);
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(notificationShowHelper.o(context, mVarA, iN, dVarC, true));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        String strG = g(listM0);
        if (Intrinsics.b(strG, f56905b)) {
            return;
        }
        f56905b = strG;
        a aVar = a.f56923a;
        MsgBean msgBean = new MsgBean(0, null, null, null, null, MsgStyle.SOURCE_PUSH, String.valueOf(i11), null, MsgType.PERMANENT.getType(), null, 0, null, false, false, false, 0, 65183, null);
        msgBean.setPermanent(true);
        aVar.d(msgBean);
    }

    public final void k(Context context, List<PermanentItemBean> msgList) {
        Intrinsics.g(context, "context");
        Intrinsics.g(msgList, "msgList");
        if (!Intrinsics.b(g(CollectionsKt___CollectionsKt.M0(msgList)), f56905b) || System.currentTimeMillis() - f56907d >= f56906c) {
            f56907d = System.currentTimeMillis();
            q1 q1Var = f56912i;
            if (q1Var != null) {
                q1.a.b(q1Var, null, 1, null);
            }
            f56912i = j.d(l0.a(w0.b()), null, null, new PushShowPermanentHelper$showPermanentPush$1(msgList, context, null), 3, null);
        }
    }

    public final Bitmap l(Context context, Bitmap bitmap) {
        return com.transsion.push.utils.a.f57057a.e(context, bitmap, e(), d(), false, gs.a.a(4));
    }
}
