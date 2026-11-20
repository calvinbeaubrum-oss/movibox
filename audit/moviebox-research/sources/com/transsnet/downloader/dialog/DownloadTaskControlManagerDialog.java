package com.transsnet.downloader.dialog;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.memberapi.MemberSource;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.config.Config;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class DownloadTaskControlManagerDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f60548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f60549d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public h00.m f60550f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f60551g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements su.a {

        /* JADX INFO: renamed from: com.transsnet.downloader.dialog.DownloadTaskControlManagerDialog$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C0617a implements su.b {
            public C0617a() {
            }

            @Override // su.b
            public void a() {
                uo.b.a.f(uo.b.f78622a, "co_mem", "DownTitleHolder --> onManagerClick() --> showCheckMemberRights() --> showMemberPage() --> onFailed() --> 开通会员失败不做任何处理", false, 4, null);
            }

            @Override // su.b
            public void onSuccess() {
                a.this.d();
            }
        }

        public a() {
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).c1(com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_MULTI_DL, memberCheckResult, new C0617a());
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() {
            Config config = new Config();
            config.g(((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).j1());
            com.transsnet.downloader.manager.b.a aVar = com.transsnet.downloader.manager.b.f61062a;
            com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).l(config);
            com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).w();
            zp.b.f82110a.d(R$string.download_task_control_manager_start_mul);
            DownloadTaskControlManagerDialog.this.dismissAllowingStateLoss();
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
            uo.b.a.f(uo.b.f78622a, "co_mem", "DownTitleHolder --> onManagerClick() --> showCheckMemberRights() --> notImplement() --> 当前类型没有实现", false, 4, null);
        }

        @Override // su.a
        public void onFail(String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            uo.b.a.f(uo.b.f78622a, "co_mem", DownloadTaskControlManagerDialog.this.g0() + " --> tvDownloadXXSizeAtOnce --> checkMemberRights() --> " + errorMsg, false, 4, null);
        }
    }

    public DownloadTaskControlManagerDialog() {
        this(false, false);
    }

    public DownloadTaskControlManagerDialog(boolean z11, boolean z12) {
        super(R$layout.dialog_download_task_control_manager_layout);
        this.f60548c = z11;
        this.f60549d = z12;
    }

    private final void initView() {
        h00.m mVar = this.f60550f;
        Group group = mVar != null ? mVar.f65939c : null;
        if (group != null) {
            group.setVisibility(this.f60549d ? 0 : 8);
        }
        h00.m mVar2 = this.f60550f;
        Group group2 = mVar2 != null ? mVar2.f65938b : null;
        if (group2 == null) {
            return;
        }
        group2.setVisibility(this.f60548c ^ true ? 0 : 8);
    }

    private final void s0() {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        h00.m mVar = this.f60550f;
        if (mVar != null && (textView4 = mVar.f65942g) != null) {
            textView4.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.z
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadTaskControlManagerDialog.t0(this.f60604a, view);
                }
            });
        }
        h00.m mVar2 = this.f60550f;
        if (mVar2 != null && (textView3 = mVar2.f65945j) != null) {
            textView3.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.a0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadTaskControlManagerDialog.u0(this.f60572a, view);
                }
            });
            textView3.setText(com.transsnet.downloader.manager.b.a.b(com.transsnet.downloader.manager.b.f61062a, null, 1, null).i() ? getString(R$string.download_pause_all) : getString(R$string.download_resume_all));
        }
        h00.m mVar3 = this.f60550f;
        if (mVar3 != null && (textView2 = mVar3.f65943h) != null) {
            String string = Utils.a().getString(R$string.download_xx_size_at_once, String.valueOf(((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).j1()));
            Intrinsics.f(string, "getApp().getString(\n    ….toString()\n            )");
            textView2.setText(string);
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.b0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadTaskControlManagerDialog.v0(this.f60574a, view);
                }
            });
        }
        h00.m mVar4 = this.f60550f;
        if (mVar4 == null || (textView = mVar4.f65941f) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.dialog.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadTaskControlManagerDialog.w0(this.f60576a, view);
            }
        });
    }

    public static final void t0(DownloadTaskControlManagerDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void u0(DownloadTaskControlManagerDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsnet.downloader.manager.b.a aVar = com.transsnet.downloader.manager.b.f61062a;
        if (com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).i()) {
            com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).n();
            ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).q0();
        } else {
            com.transsnet.downloader.manager.b.a.b(aVar, null, 1, null).w();
            ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).T();
            if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).m()) {
                zp.b.f82110a.d(R$string.download_task_control_manager_start_mul);
            } else {
                zp.b.f82110a.d(R$string.download_task_control_manager_start);
            }
        }
        this$0.dismissAllowingStateLoss();
    }

    public static final void v0(DownloadTaskControlManagerDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).y0();
        this$0.q0();
        this$0.dismissAllowingStateLoss();
    }

    public static final void w0(DownloadTaskControlManagerDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (Build.VERSION.SDK_INT >= 23) {
            FragmentActivity activity = this$0.getActivity();
            if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                BatteryPermissionUtils.f61124a.i(activity, "download_manager_dialog", this$0.f60551g);
            }
            this$0.dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            window.setBackgroundDrawable(null);
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setLayout(-1, -2);
        }
        this.f60550f = h00.m.a(view);
        initView();
        s0();
    }

    public final void q0() {
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e0(MemberSceneType.SCENE_MULTIDL, 0, new a());
    }

    public final void r0(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f60551g = callback;
    }
}
