package com.transsion.videofloat.manager;

import android.app.Application;
import android.os.Build;
import android.provider.Settings;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.permissionx.guolindev.PermissionX;
import com.permissionx.guolindev.callback.PermissionDialogClickType;
import com.tencent.mmkv.MMKV;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.videofloat.R$mipmap;
import com.transsion.videofloat.R$string;
import com.transsion.videofloat.VideoFloatManager;
import com.transsion.videofloat.VideoPipManager;
import com.transsion.videofloat.dialog.VideoFloatPermissionDialog;
import com.transsion.videofloat.view.VideoFloatView;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class VideoFloatManagerImp implements VideoFloatManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoFloatView f60032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f60033c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements yz.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yz.a f60034a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VideoFloatManagerImp f60035b;

        public a(yz.a aVar, VideoFloatManagerImp videoFloatManagerImp) {
            this.f60034a = aVar;
            this.f60035b = videoFloatManagerImp;
        }

        @Override // yz.a
        public void a(vz.a aVar) {
            String strJ;
            this.f60035b.f60033c = false;
            yz.a aVar2 = this.f60034a;
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
            this.f60035b.f60032b = null;
            if (aVar == null || (strJ = aVar.j()) == null) {
                return;
            }
            v.f60111a.e(strJ);
        }

        @Override // yz.a
        public boolean b(vz.a aVar) {
            yz.a aVar2 = this.f60034a;
            if (aVar2 != null) {
                return aVar2.b(aVar);
            }
            return false;
        }

        @Override // yz.a
        public void c(vz.a aVar) {
            if (aVar != null) {
                this.f60035b.p(aVar.q(), aVar.g());
            }
            yz.a aVar2 = this.f60034a;
            if (aVar2 != null) {
                aVar2.c(aVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void v(VideoFloatManagerImp videoFloatManagerImp, FragmentActivity fragmentActivity, boolean z11, String str, String str2, Function1 function1, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            function1 = null;
        }
        videoFloatManagerImp.u(fragmentActivity, z11, str, str2, function1);
    }

    public static final void w(boolean z11, VideoFloatManagerImp this$0, String subjectId, String pageName, com.permissionx.guolindev.request.d scope, List deniedList, boolean z12, boolean z13) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(subjectId, "$subjectId");
        Intrinsics.g(pageName, "$pageName");
        Intrinsics.g(scope, "scope");
        Intrinsics.g(deniedList, "deniedList");
        if (!z12) {
            uo.b.a.f(uo.b.f78622a, "VideoFloat", "请求权限之后，", false, 4, null);
            return;
        }
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "请求权限前，提示弹窗，isFullLand：" + z11, false, 4, null);
        if (z11) {
            scope.d(new VideoFloatPermissionDialog(false, deniedList));
        } else {
            scope.e(deniedList, new co.a(null, Utils.a().getString(R$string.video_float_tips_v2), Utils.a().getString(R$string.video_float_enable), Integer.valueOf(R$mipmap.video_float_ic_permission_img), Integer.valueOf(R$color.white_20), 1, null));
        }
        this$0.r(subjectId, pageName);
    }

    public static final void x(VideoFloatManagerImp this$0, String subjectId, String pageName, BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(subjectId, "$subjectId");
        Intrinsics.g(pageName, "$pageName");
        this$0.q(permissionDialogClickType == PermissionDialogClickType.POSITIVE, subjectId, pageName);
    }

    public static final void y(VideoFloatManagerImp this$0, Function1 function1, boolean z11, List grantedList, List deniedList) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(grantedList, "grantedList");
        Intrinsics.g(deniedList, "deniedList");
        uo.b.a.f(uo.b.f78622a, "VideoFloat", "请求权限结果:" + z11, false, 4, null);
        this$0.s(true, z11);
        if (z11) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public boolean a(String tag) {
        vz.a floatBean;
        Intrinsics.g(tag, "tag");
        VideoFloatView videoFloatView = this.f60032b;
        if (videoFloatView == null || (floatBean = videoFloatView.getFloatBean()) == null) {
            return false;
        }
        return Intrinsics.b(tag, floatBean.q() + floatBean.p() + floatBean.b());
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public void b(FragmentActivity activity, String subjectId, String pageName) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(subjectId, "subjectId");
        Intrinsics.g(pageName, "pageName");
        Function0<Boolean> function0G = TnPlayerManager.f54684a.g();
        if ((function0G == null || !function0G.invoke().booleanValue()) && !VideoPipManager.f60024a.a().b()) {
            RoomAppMMKV roomAppMMKV = RoomAppMMKV.f51271a;
            MMKV mmkvA = roomAppMMKV.a();
            VideoFloatManager.Companion companion = VideoFloatManager.f60019a;
            if (mmkvA.getBoolean(companion.a(), false) || activity.isDestroyed() || activity.isFinishing()) {
                return;
            }
            roomAppMMKV.a().putBoolean(companion.a(), true);
            n(activity, false, subjectId, pageName);
        }
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public boolean c(com.transsion.player.orplayer.f fVar) {
        uo.b.a aVar = uo.b.f78622a;
        boolean z11 = this.f60033c;
        VideoFloatView videoFloatView = this.f60032b;
        uo.b.a.f(aVar, "VideoFloat", "1-isEnterFloat：" + z11 + ", " + (videoFloatView != null ? videoFloatView.getPlayer() : null) + ", " + fVar + " ", false, 4, null);
        if (this.f60033c) {
            VideoFloatView videoFloatView2 = this.f60032b;
            if ((videoFloatView2 != null ? videoFloatView2.getPlayer() : null) != null) {
                VideoFloatView videoFloatView3 = this.f60032b;
                if (Intrinsics.b(videoFloatView3 != null ? videoFloatView3.getPlayer() : null, fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public void d() {
        s(false, o());
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public void e(FragmentActivity activity, final vz.a floatBean, final boolean z11, boolean z12, final Function1<? super Boolean, Unit> function1, final yz.a aVar) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(floatBean, "floatBean");
        Function0<Boolean> function0G = TnPlayerManager.f54684a.g();
        if (function0G == null || !function0G.invoke().booleanValue()) {
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
            uo.b.f78622a.c("VideoFloat", "单播放器 禁用pip功能", true);
            return;
        }
        floatBean.A(z11);
        if (o()) {
            if (function1 != null) {
                function1.invoke(Boolean.TRUE);
            }
            t(floatBean, z11, aVar);
        } else if (z11) {
            u(activity, z12, floatBean.g(), floatBean.q(), new Function1<Boolean, Unit>() { // from class: com.transsion.videofloat.manager.VideoFloatManagerImp$checkShowFloatView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z13) {
                    if (z13) {
                        Function1<Boolean, Unit> function2 = function1;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE);
                        }
                        this.t(floatBean, z11, aVar);
                        return;
                    }
                    Function1<Boolean, Unit> function3 = function1;
                    if (function3 != null) {
                        function3.invoke(Boolean.FALSE);
                    }
                }
            });
        } else if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public void f(boolean z11) {
        if (!z11) {
            v.f60111a.d();
        }
        this.f60033c = false;
        VideoFloatView videoFloatView = this.f60032b;
        if (videoFloatView != null) {
            videoFloatView.removeFromWindow();
        }
        this.f60032b = null;
    }

    @Override // com.transsion.videofloat.VideoFloatManager
    public boolean isPlaying() {
        VideoFloatView videoFloatView;
        if (this.f60033c && (videoFloatView = this.f60032b) != null) {
            return videoFloatView.isPlaying();
        }
        return false;
    }

    public final void n(FragmentActivity fragmentActivity, boolean z11, String str, String str2) {
        if (o()) {
            return;
        }
        v(this, fragmentActivity, z11, str, str2, null, 16, null);
    }

    public final boolean o() {
        if (Build.VERSION.SDK_INT >= 23) {
            return Settings.canDrawOverlays(Utils.a());
        }
        return true;
    }

    public final void p(String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("opt_type", "float_back_page");
        map.put("type", "float");
        com.transsion.baselib.report.m.f51277a.m(str2, "click", map);
    }

    public final void q(boolean z11, String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put("opt_type", z11 ? "allow" : "cancel");
        map.put(WebConstants.PAGE_FROM, str2);
        com.transsion.baselib.report.m.f51277a.m(VideoFloatManager.f60019a.c(), "click", map);
    }

    public final void r(String str, String str2) {
        HashMap map = new HashMap();
        map.put("subject_id", str);
        map.put(WebConstants.PAGE_FROM, str2);
        com.transsion.baselib.report.m.f51277a.t(VideoFloatManager.f60019a.c(), "dialog_show", map);
    }

    public final void s(boolean z11, boolean z12) {
        HashMap map = new HashMap();
        map.put("has_permission", String.valueOf(z12));
        map.put("action", z11 ? "click" : "auto");
        com.transsion.baselib.report.m.f51277a.t("float_opt", "app_perf", map);
    }

    public final void t(vz.a aVar, boolean z11, yz.a aVar2) {
        VideoFloatManager.a.a(this, false, 1, null);
        if (this.f60032b == null) {
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            this.f60032b = new VideoFloatView(applicationA);
        }
        VideoFloatView videoFloatView = this.f60032b;
        if (videoFloatView != null) {
            uo.b.a.f(uo.b.f78622a, "VideoFloat", "showFloat", false, 4, null);
            v.f60111a.a(aVar.j(), aVar.e());
            this.f60033c = true;
            videoFloatView.addToWindow(z11, aVar);
            videoFloatView.setVideoFloatListener(new a(aVar2, this));
        }
    }

    public final void u(FragmentActivity fragmentActivity, final boolean z11, final String str, final String str2, final Function1<? super Boolean, Unit> function1) {
        PermissionX.f48641a.d(fragmentActivity).b("android.permission.SYSTEM_ALERT_WINDOW").a().c(new ao.b() { // from class: com.transsion.videofloat.manager.e
            @Override // ao.b
            public final void a(com.permissionx.guolindev.request.d dVar, List list, boolean z12, boolean z13) {
                VideoFloatManagerImp.w(z11, this, str2, str, dVar, list, z12, z13);
            }
        }).d(new ao.a() { // from class: com.transsion.videofloat.manager.f
            @Override // ao.a
            public final void a(BaseDialog baseDialog, Boolean bool, PermissionDialogClickType permissionDialogClickType) {
                VideoFloatManagerImp.x(this.f60097a, str2, str, baseDialog, bool, permissionDialogClickType);
            }
        }).b(new ao.c() { // from class: com.transsion.videofloat.manager.g
            @Override // ao.c
            public final void a(boolean z12, List list, List list2) {
                VideoFloatManagerImp.y(this.f60100a, function1, z12, list, list2);
            }
        });
    }
}
