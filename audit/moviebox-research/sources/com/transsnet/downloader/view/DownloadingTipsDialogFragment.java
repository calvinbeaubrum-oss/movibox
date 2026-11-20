package com.transsnet.downloader.view;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.m;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.push.notification.permission.NoticePermissionFrom;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IFloatingApi;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.core.thread.DownloadBaseRunnable;
import com.transsnet.downloader.util.BatteryPermissionUtils;
import com.transsnet.downloader.util.DownloadUtil;
import h00.s;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
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
@SourceDebugExtension
public final class DownloadingTipsDialogFragment extends BaseDialog {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final a f61172l = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f61173c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public s f61174d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f61175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f61176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f61177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f61178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f61179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public DownloadBean f61180k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadingTipsDialogFragment a(int i11) {
            DownloadingTipsDialogFragment downloadingTipsDialogFragment = new DownloadingTipsDialogFragment();
            downloadingTipsDialogFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("arguments_file_size", Integer.valueOf(i11))));
            return downloadingTipsDialogFragment;
        }
    }

    public DownloadingTipsDialogFragment() {
        super(R$layout.downloading_tips_dialog_fragment_layout);
        this.f61175f = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$downloadManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsnet.downloader.manager.a invoke() {
                return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            }
        });
        this.f61176g = LazyKt__LazyJVMKt.b(new Function0<IAudioApi>() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$mAudioApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IAudioApi invoke() {
                return (IAudioApi) com.alibaba.android.arouter.launcher.a.d().h(IAudioApi.class);
            }
        });
        this.f61177h = LazyKt__LazyJVMKt.b(new Function0<IFloatingApi>() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$mFloatApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IFloatingApi invoke() {
                return (IFloatingApi) com.alibaba.android.arouter.launcher.a.d().h(IFloatingApi.class);
            }
        });
        this.f61178i = LazyKt__LazyJVMKt.b(new Function0<rr.a>() { // from class: com.transsnet.downloader.view.DownloadingTipsDialogFragment$audioDao$2
            @Override // kotlin.jvm.functions.Function0
            public final rr.a invoke() {
                AppDatabase.v0 v0Var = AppDatabase.f51036p;
                Application applicationA = Utils.a();
                Intrinsics.f(applicationA, "getApp()");
                return v0Var.b(applicationA).D0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IAudioApi A0() {
        Object value = this.f61176g.getValue();
        Intrinsics.f(value, "<get-mAudioApi>(...)");
        return (IAudioApi) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IFloatingApi B0() {
        Object value = this.f61177h.getValue();
        Intrinsics.f(value, "<get-mFloatApi>(...)");
        return (IFloatingApi) value;
    }

    private final int C0() {
        int i11 = getResources().getDisplayMetrics().heightPixels;
        return i11 - (i11 / 3);
    }

    public static final void D0() {
        Activity activityB = com.blankj.utilcode.util.a.b();
        if (activityB == null || activityB.isFinishing() || activityB.isDestroyed() || !(activityB instanceof FragmentActivity) || lw.c.f70578a.d((FragmentActivity) activityB, NoticePermissionFrom.DOWNLOAD_RES)) {
            return;
        }
        BatteryPermissionUtils.f61124a.f(DownloadBaseRunnable.TAG);
    }

    private final void H0() {
        DownloadBean downloadBean = this.f61180k;
        if (downloadBean == null) {
            return;
        }
        if (downloadBean == null || !downloadBean.isVideo()) {
            G0();
            return;
        }
        DownloadBean downloadBean2 = this.f61180k;
        if (downloadBean2 != null && downloadBean2.isShotTV()) {
            E0();
            return;
        }
        Activity activityB = com.blankj.utilcode.util.a.b();
        String simpleName = activityB.getClass().getSimpleName();
        Intrinsics.f(simpleName, "activity.javaClass.simpleName");
        if (StringsKt__StringsKt.Q(simpleName, "VideoDetailActivity", false, 2, null)) {
            activityB.finish();
        }
        F0();
    }

    private final void I0(boolean z11) {
        String pageFrom;
        DownloadBean downloadBean = this.f61180k;
        if (downloadBean == null || (pageFrom = downloadBean.getPageFrom()) == null) {
            return;
        }
        m mVar = m.f51277a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("dialog_name", "download_tips");
        linkedHashMap.put("action", z11 ? MediaItem.MUSIC_FLOAT_STATE_PLAY : MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        Unit unit = Unit.f68710a;
        mVar.m(pageFrom, "click", linkedHashMap);
    }

    private final void K0() {
        j.d(v.a(this), null, null, new DownloadingTipsDialogFragment$showAd$1(this, null), 3, null);
    }

    private final void L0() {
        s sVar = this.f61174d;
        if (sVar != null) {
            sVar.f66011d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadingTipsDialogFragment.M0(this.f61183a, view);
                }
            });
            sVar.f66013g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadingTipsDialogFragment.N0(this.f61184a, view);
                }
            });
            sVar.f66014h.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.view.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadingTipsDialogFragment.O0(this.f61185a, view);
                }
            });
        }
        s sVar2 = this.f61174d;
        AppCompatTextView appCompatTextView = sVar2 != null ? sVar2.f66016j : null;
        if (appCompatTextView == null) {
            return;
        }
        String str = " " + String.valueOf(this.f61179j) + " ";
        Intrinsics.f(str, "toString(...)");
        appCompatTextView.setText(str);
    }

    public static final void M0(DownloadingTipsDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void N0(DownloadingTipsDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.I0(false);
        com.alibaba.android.arouter.launcher.a.d().b("/download/panel_activity").withInt("extra_page_index", 0).navigation();
        this$0.dismissAllowingStateLoss();
    }

    public static final void O0(DownloadingTipsDialogFragment this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.I0(true);
        this$0.H0();
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final rr.a y0() {
        return (rr.a) this.f61178i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.a z0() {
        return (com.transsnet.downloader.manager.a) this.f61175f.getValue();
    }

    public final void E0() {
        DownloadBean downloadBean = this.f61180k;
        if (downloadBean != null) {
            com.alibaba.android.arouter.launcher.a.d().b("/shorts/detail").withSerializable("item_object", DownloadUtil.f61136a.p(downloadBean)).withInt("ep", downloadBean.getEp()).navigation();
        }
    }

    public final void F0() {
        String strH;
        DownloadBean downloadBean = this.f61180k;
        boolean zIsCompleted = downloadBean != null ? downloadBean.isCompleted() : false;
        com.transsnet.downloader.manager.a aVarZ0 = z0();
        DownloadBean downloadBean2 = this.f61180k;
        Intrinsics.d(downloadBean2);
        aVarZ0.j(downloadBean2);
        if (zIsCompleted) {
            strH = null;
        } else {
            com.transsnet.downloader.manager.a aVarA = com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
            DownloadBean downloadBean3 = this.f61180k;
            Intrinsics.d(downloadBean3);
            strH = aVarA.h(downloadBean3);
        }
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/video/detail");
        DownloadBean downloadBean4 = this.f61180k;
        Postcard postcardWithString = postcardB.withString("extra_local_path", downloadBean4 != null ? downloadBean4.getPath() : null);
        DownloadBean downloadBean5 = this.f61180k;
        Postcard postcardWithString2 = postcardWithString.withString("extra_url", downloadBean5 != null ? downloadBean5.getUrl() : null);
        DownloadBean downloadBean6 = this.f61180k;
        Postcard postcardWithInt = postcardWithString2.withInt("subject_type", downloadBean6 != null ? downloadBean6.getType() : 2);
        DownloadBean downloadBean7 = this.f61180k;
        Postcard postcardWithString3 = postcardWithInt.withString("id", downloadBean7 != null ? downloadBean7.getSubjectId() : null).withString("extra_proxy_url", strH);
        DownloadBean downloadBean8 = this.f61180k;
        Postcard postcardWithString4 = postcardWithString3.withString("extra_resource_id", downloadBean8 != null ? downloadBean8.getResourceId() : null);
        DownloadBean downloadBean9 = this.f61180k;
        Postcard postcardWithString5 = postcardWithString4.withString("extra_subject_id", downloadBean9 != null ? downloadBean9.getSubjectId() : null);
        DownloadBean downloadBean10 = this.f61180k;
        Postcard postcardWithString6 = postcardWithString5.withString("extra_name", downloadBean10 != null ? downloadBean10.getName() : null);
        DownloadBean downloadBean11 = this.f61180k;
        Postcard postcardWithBoolean = postcardWithString6.withString("extra_post_id", downloadBean11 != null ? downloadBean11.getPostId() : null).withBoolean("extra_completed", zIsCompleted);
        DownloadBean downloadBean12 = this.f61180k;
        Postcard postcardWithBoolean2 = postcardWithBoolean.withBoolean("extra_is_series", downloadBean12 != null ? downloadBean12.isSeries() : false);
        DownloadBean downloadBean13 = this.f61180k;
        postcardWithBoolean2.withString("extra_page_from", downloadBean13 != null ? downloadBean13.getPageFrom() : null).navigation(getContext());
    }

    public final void G0() {
        j.d(l0.a(w0.c()), null, null, new DownloadingTipsDialogFragment$opnAudio$1(this, null), 3, null);
    }

    public final void J0(DownloadBean downloadBean) {
        Intrinsics.g(downloadBean, "downloadBean");
        this.f61180k = downloadBean;
        if (downloadBean == null || !downloadBean.isShotTV()) {
            DownloadManagerApi.f60274j.a().V1(downloadBean.getSubjectId(), downloadBean.getResourceId(), downloadBean.isSeries(), downloadBean.getTotalEpisode(), true, downloadBean.isMultiresolution());
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f61179j = Integer.valueOf(arguments.getInt("arguments_file_size"));
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = bVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = C0();
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.transsion.ad.bidding.nativead.c cVar = this.f61173c;
        if (cVar != null) {
            cVar.F();
        }
        this.f61173c = null;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsnet.downloader.view.e
            @Override // java.lang.Runnable
            public final void run() {
                DownloadingTipsDialogFragment.D0();
            }
        }, 1000L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        this.f61174d = s.a(view);
        L0();
        K0();
    }
}
