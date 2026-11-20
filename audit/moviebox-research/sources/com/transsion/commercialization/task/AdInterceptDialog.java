package com.transsion.commercialization.task;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.v;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercialization.R$layout;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AdInterceptDialog extends BaseDialog {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f51727j = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f51728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public os.c f51729d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super Integer, Unit> f51730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.transsion.ad.bidding.nativead.c f51731g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51732h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f51733i;

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
    public static final class b implements su.b {
        public b() {
        }

        @Override // su.b
        public void a() {
            com.transsion.commercialization.pslink.a.f51724a.a(AdInterceptDialog.this.g0() + " --> startMemberPage() --> onFailed() --> 开通会员失败");
        }

        @Override // su.b
        public void onSuccess() {
            com.transsion.commercialization.pslink.a.f51724a.a(AdInterceptDialog.this.g0() + " --> startMemberPage() --> onSuccess() --> 开通会员成功，直接下载不需要做任务了");
            AdInterceptDialog.this.f51732h = true;
            AdInterceptDialog.this.dismissAllowingStateLoss();
        }
    }

    public AdInterceptDialog() {
        super(R$layout.dialog_ad_intercept_layout);
    }

    private final void w0() {
        ConstraintLayout constraintLayout;
        AppCompatImageView appCompatImageView;
        os.c cVar = this.f51729d;
        if (cVar != null && (appCompatImageView = cVar.f73368d) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdInterceptDialog.x0(this.f51770a, view);
                }
            });
        }
        os.c cVar2 = this.f51729d;
        if (cVar2 == null || (constraintLayout = cVar2.f73367c) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.commercialization.task.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdInterceptDialog.y0(this.f51771a, view);
            }
        });
    }

    public static final void x0(AdInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void y0(AdInterceptDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        com.transsion.commercialization.pslink.f.f51726a.j();
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.c((IMemberApi) objH, this$0.getActivity(), MemberSource.SOURCE_AD_DIALOG, this$0.new b(), false, 8, null);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        String string;
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.commercialization.pslink.a.f51724a.a(g0() + " --> onCreate() --> 观看广告弹窗");
        if (bundle == null || (string = bundle.getString("memberPrice")) == null) {
            return;
        }
        this.f51733i = string;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        com.transsion.ad.bidding.nativead.c cVar = this.f51731g;
        if (cVar != null) {
            cVar.F();
        }
        if (this.f51732h) {
            Function1<? super Integer, Unit> function1 = this.f51730f;
            if (function1 != null) {
                function1.invoke(2);
                return;
            }
            return;
        }
        Function1<? super Integer, Unit> function2 = this.f51730f;
        if (function2 != null) {
            function2.invoke(1);
        }
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f51732h) {
            dismissAllowingStateLoss();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putString("memberPrice", this.f51733i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        ConstraintLayout constraintLayout;
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
        com.transsion.commercialization.pslink.f.f51726a.k();
        this.f51729d = os.c.a(view);
        if (((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).e1()) {
            os.c cVar = this.f51729d;
            constraintLayout = cVar != null ? cVar.f73367c : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
        } else {
            os.c cVar2 = this.f51729d;
            constraintLayout = cVar2 != null ? cVar2.f73367c : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
        }
        w0();
        t0();
    }

    public final void t0() {
        kotlinx.coroutines.j.d(v.a(this), null, null, new AdInterceptDialog$loadNativeAd$1(this, null), 3, null);
    }

    public final AdInterceptDialog u0(Function1<? super Integer, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f51730f = callback;
        return this;
    }

    public final AdInterceptDialog v0(String str) {
        this.f51728c = str;
        return this;
    }

    public final AdInterceptDialog z0(String str) {
        this.f51733i = str;
        return this;
    }
}
