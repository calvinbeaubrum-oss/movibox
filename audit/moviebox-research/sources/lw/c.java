package lw;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.request.d;
import com.tn.lib.widget.R$color;
import com.transsion.push.R$mipmap;
import com.transsion.push.R$string;
import com.transsion.push.bean.PushConfigHelper;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.push.utils.NotificationMMKVUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f70578a = new c();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f70579a;

        static {
            int[] iArr = new int[NoticePermissionFrom.values().length];
            try {
                iArr[NoticePermissionFrom.APP_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoticePermissionFrom.DOWNLOAD_RES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoticePermissionFrom.PLAY_MUSIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f70579a = iArr;
        }
    }

    public static final void e(NoticePermissionFrom from, d scope, List deniedList, boolean z11, boolean z12) {
        Intrinsics.g(from, "$from");
        Intrinsics.g(scope, "scope");
        Intrinsics.g(deniedList, "deniedList");
        if (!z11) {
            uo.b.a.f(uo.b.f78622a, "NoticePer", "请求权限之后，无需弹窗", false, 4, null);
            return;
        }
        if (z12) {
            uo.b.a.f(uo.b.f78622a, "NoticePer", from + " 请求权限，需要跳到设置页，先展示提示弹窗", false, 4, null);
            scope.c(deniedList, new co.a(null, f70578a.g(from), Utils.a().getString(R$string.permission_notice_turn_on), Integer.valueOf(R$mipmap.ic_notification_permission_tips), Integer.valueOf(R$color.white_20), 1, null));
            return;
        }
        if (from == NoticePermissionFrom.APP_START) {
            uo.b.a.f(uo.b.f78622a, "NoticePer", "app 启动 直接请求权限", false, 4, null);
            scope.b(deniedList);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "NoticePer", from + " 请求权限前，提示弹窗", false, 4, null);
        scope.e(deniedList, new co.a(null, f70578a.g(from), Utils.a().getString(R$string.permission_notice_turn_on), Integer.valueOf(R$mipmap.ic_notification_permission_tips), Integer.valueOf(R$color.white_20), 1, null));
    }

    public static final void f(boolean z11, List grantedList, List deniedList) {
        Intrinsics.g(grantedList, "grantedList");
        Intrinsics.g(deniedList, "deniedList");
        uo.b.a.f(uo.b.f78622a, "NoticePer", "通知权限 请求权限结果:" + z11, false, 4, null);
    }

    public final boolean c(Fragment fragment, NoticePermissionFrom from) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(from, "from");
        FragmentActivity activity = fragment.getActivity();
        if (activity != null) {
            return f70578a.d(activity, from);
        }
        return false;
    }

    public final boolean d(FragmentActivity activity, final NoticePermissionFrom from) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(from, "from");
        if (activity.isFinishing() || activity.isDestroyed()) {
            return false;
        }
        PermissionX permissionX = PermissionX.f48641a;
        if (permissionX.a(activity)) {
            uo.b.a.s(uo.b.f78622a, "NoticePer", "checkRequestPermission , 权限已开启, from:" + from, false, 4, null);
            return false;
        }
        if (!h(from)) {
            uo.b.a.s(uo.b.f78622a, "NoticePer", "checkRequestPermission 不请求权限, from:" + from, false, 4, null);
            return false;
        }
        uo.b.a.f(uo.b.f78622a, "NoticePer", "checkRequestPermission from:" + from, false, 4, null);
        permissionX.d(activity).b("android.permission.POST_NOTIFICATIONS").a().c(new ao.b() { // from class: lw.a
            @Override // ao.b
            public final void a(d dVar, List list, boolean z11, boolean z12) {
                c.e(from, dVar, list, z11, z12);
            }
        }).b(new ao.c() { // from class: lw.b
            @Override // ao.c
            public final void a(boolean z11, List list, List list2) {
                c.f(z11, list, list2);
            }
        });
        return true;
    }

    public final String g(NoticePermissionFrom from) {
        Intrinsics.g(from, "from");
        if (a.f70579a[from.ordinal()] == 3) {
            String string = Utils.a().getString(R$string.permission_notice_tips_music);
            Intrinsics.f(string, "getApp().getString(R.str…ission_notice_tips_music)");
            return string;
        }
        String string2 = Utils.a().getString(R$string.permission_notice_tips_normal);
        Intrinsics.f(string2, "getApp().getString(R.str…ssion_notice_tips_normal)");
        return string2;
    }

    public final boolean h(NoticePermissionFrom noticePermissionFrom) {
        int i11 = a.f70579a[noticePermissionFrom.ordinal()];
        if (i11 == 1) {
            return i();
        }
        if (i11 != 2) {
            return true;
        }
        NotificationMMKVUtil notificationMMKVUtil = NotificationMMKVUtil.f57030a;
        boolean z11 = notificationMMKVUtil.a().getBoolean("key_notification_permission_download", true);
        notificationMMKVUtil.a().putBoolean("key_notification_permission_download", false);
        return z11;
    }

    public final boolean i() {
        NotificationMMKVUtil notificationMMKVUtil = NotificationMMKVUtil.f57030a;
        long j11 = notificationMMKVUtil.a().getLong("key_notification_permission_app_start_count", 0L);
        long j12 = notificationMMKVUtil.a().getLong("key_notification_permission_app_start_last_time", 0L);
        Integer remindTime = PushConfigHelper.INSTANCE.getRemindTime();
        int iD = remindTime != null ? kotlin.ranges.a.d(remindTime.intValue(), 1) : 48;
        if (j11 > 0 && System.currentTimeMillis() - j12 < 3600000 * iD) {
            uo.b.a.f(uo.b.f78622a, "NoticePer", "app启动，小于" + iD + "小时，不请求 count:" + j11, false, 4, null);
            return false;
        }
        uo.b.f78622a.c("NoticePer", "app启动 超过" + iD + "小时，再次请求  count:" + j11, true);
        notificationMMKVUtil.a().putLong("key_notification_permission_app_start_last_time", System.currentTimeMillis());
        notificationMMKVUtil.a().putLong("key_notification_permission_app_start_count", j11 + 1);
        return true;
    }
}
