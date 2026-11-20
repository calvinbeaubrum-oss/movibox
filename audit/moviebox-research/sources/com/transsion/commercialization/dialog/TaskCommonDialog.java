package com.transsion.commercialization.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tn.lib.widget.R$style;
import com.transsion.baselib.report.m;
import com.transsion.baselib.task.ArouterUtil;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.bean.HomePopupEntity;
import com.transsion.bean.HomePopupInfo;
import com.transsion.commercialization.R$layout;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class TaskCommonDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f51632g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f51633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public os.d f51634d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HomePopupEntity f51635f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements RequestListener<Drawable> {
        public b() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
            uo.b.a.f(uo.b.f78622a, "zxb_popup", TaskCommonDialog.this.g0() + " --> init() --> onResourceReady() --> 图片加载成功", false, 4, null);
            Function1 function1 = TaskCommonDialog.this.f51633c;
            if (function1 != null) {
            }
            TaskCommonDialog.this.v0();
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
            TaskCommonDialog.this.dismissAllowingStateLoss();
            return true;
        }
    }

    public TaskCommonDialog() {
        super(R$layout.dialog_common_task_layout);
    }

    private final void q0() {
        os.d dVar;
        ShapeableImageView shapeableImageView;
        HomePopupInfo popup;
        AppCompatImageView appCompatImageView;
        os.d dVar2 = this.f51634d;
        if (dVar2 != null && (appCompatImageView = dVar2.f73382d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.dialog.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TaskCommonDialog.r0(this.f51646a, view);
                }
            });
        }
        final Context context = getContext();
        if (context == null || (dVar = this.f51634d) == null || (shapeableImageView = dVar.f73381c) == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "zxb_popup", g0() + " --> init() --> mHomePopupEntity = " + this.f51635f, false, 4, null);
        RequestManager requestManagerWith = Glide.with(context);
        HomePopupEntity homePopupEntity = this.f51635f;
        requestManagerWith.load2((homePopupEntity == null || (popup = homePopupEntity.getPopup()) == null) ? null : popup.getImg()).listener(new b()).into(shapeableImageView);
        shapeableImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskCommonDialog.s0(this.f51647a, context, view);
            }
        });
    }

    public static final void r0(TaskCommonDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.t0(true);
        this$0.dismissAllowingStateLoss();
    }

    public static final void s0(TaskCommonDialog this$0, Context contextIt, View view) {
        HomePopupInfo popup;
        String innerUrl;
        HomePopupInfo popup2;
        String innerUrl2;
        HomePopupInfo popup3;
        String innerUrl3;
        HomePopupInfo popup4;
        String innerUrl4;
        HomePopupInfo popup5;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(contextIt, "$contextIt");
        com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
        HomePopupEntity homePopupEntity = this$0.f51635f;
        if (!aVar.c((homePopupEntity == null || (popup5 = homePopupEntity.getPopup()) == null) ? null : popup5.getExternalUrl())) {
            HomePopupEntity homePopupEntity2 = this$0.f51635f;
            String str = "";
            if (homePopupEntity2 == null || (popup2 = homePopupEntity2.getPopup()) == null || (innerUrl2 = popup2.getInnerUrl()) == null || l.L(innerUrl2, "oneroom://com.community.oneroom?type=", false, 2, null)) {
                ArouterUtil arouterUtil = ArouterUtil.f51292a;
                HomePopupEntity homePopupEntity3 = this$0.f51635f;
                if (homePopupEntity3 != null && (popup = homePopupEntity3.getPopup()) != null && (innerUrl = popup.getInnerUrl()) != null) {
                    str = innerUrl;
                }
                ArouterUtil.c(arouterUtil, contextIt, str, null, 4, null);
            } else {
                HomePopupEntity homePopupEntity4 = this$0.f51635f;
                String str2 = (homePopupEntity4 == null || (popup4 = homePopupEntity4.getPopup()) == null || (innerUrl4 = popup4.getInnerUrl()) == null) ? "" : innerUrl4;
                HomePopupEntity homePopupEntity5 = this$0.f51635f;
                if (homePopupEntity5 != null && (popup3 = homePopupEntity5.getPopup()) != null && (innerUrl3 = popup3.getInnerUrl()) != null) {
                    str = innerUrl3;
                }
                com.transsion.ad.strategy.a.b(aVar, str2, str, null, 4, null);
            }
        }
        u0(this$0, false, 1, null);
        this$0.dismissAllowingStateLoss();
    }

    public static /* synthetic */ void u0(TaskCommonDialog taskCommonDialog, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        taskCommonDialog.t0(z11);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        uo.b.a.f(uo.b.f78622a, "zxb_popup", g0() + " --> onCreate() --> 观看广告弹窗", false, 4, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function1<? super Boolean, Unit> function1 = this.f51633c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Window window;
        Window window2;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null && (window2 = dialog.getWindow()) != null) {
            window2.setLayout(-1, -2);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setGravity(17);
        }
        Dialog dialog3 = getDialog();
        if (dialog3 != null) {
            dialog3.setCancelable(false);
        }
        this.f51634d = os.d.a(view);
        q0();
    }

    public final void t0(boolean z11) {
        HomePopupInfo popup;
        HomePopupInfo popup2;
        HomePopupInfo popup3;
        HashMap map = new HashMap();
        HomePopupEntity homePopupEntity = this.f51635f;
        String name = null;
        map.put("dialog_id", String.valueOf((homePopupEntity == null || (popup3 = homePopupEntity.getPopup()) == null) ? null : Long.valueOf(popup3.getId())));
        HomePopupEntity homePopupEntity2 = this.f51635f;
        map.put("dialog_type", String.valueOf((homePopupEntity2 == null || (popup2 = homePopupEntity2.getPopup()) == null) ? null : Integer.valueOf(popup2.getType())));
        HomePopupEntity homePopupEntity3 = this.f51635f;
        if (homePopupEntity3 != null && (popup = homePopupEntity3.getPopup()) != null) {
            name = popup.getName();
        }
        map.put("dialog_name", String.valueOf(name));
        if (z11) {
            map.put("dialog_close", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        }
        m.f51277a.m("task_common_dialog", "click", map);
    }

    public final void v0() {
        HomePopupInfo popup;
        HomePopupInfo popup2;
        HomePopupInfo popup3;
        HashMap map = new HashMap();
        HomePopupEntity homePopupEntity = this.f51635f;
        String name = null;
        map.put("dialog_id", String.valueOf((homePopupEntity == null || (popup3 = homePopupEntity.getPopup()) == null) ? null : Long.valueOf(popup3.getId())));
        HomePopupEntity homePopupEntity2 = this.f51635f;
        map.put("dialog_type", String.valueOf((homePopupEntity2 == null || (popup2 = homePopupEntity2.getPopup()) == null) ? null : Integer.valueOf(popup2.getType())));
        HomePopupEntity homePopupEntity3 = this.f51635f;
        if (homePopupEntity3 != null && (popup = homePopupEntity3.getPopup()) != null) {
            name = popup.getName();
        }
        map.put("dialog_name", String.valueOf(name));
        m.f51277a.t("task_common_dialog", "dialog_show", map);
    }

    public final TaskCommonDialog w0(Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f51633c = callback;
        return this;
    }

    public final TaskCommonDialog x0(HomePopupEntity homePopupEntity) {
        this.f51635f = homePopupEntity;
        return this;
    }
}
