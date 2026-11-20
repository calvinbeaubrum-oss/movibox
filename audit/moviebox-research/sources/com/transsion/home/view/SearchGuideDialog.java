package com.transsion.home.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.tn.lib.view.RoundedArrowImageView;
import com.transsion.baselib.report.h;
import com.transsion.baseui.dialog.BaseDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SearchGuideDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f52680g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f52681h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f52682i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public lt.f f52683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f52684d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ConstraintLayout.b f52685f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return SearchGuideDialog.f52682i;
        }

        public final SearchGuideDialog b() {
            Bundle bundle = new Bundle();
            SearchGuideDialog searchGuideDialog = new SearchGuideDialog();
            searchGuideDialog.setArguments(bundle);
            return searchGuideDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            RoundedArrowImageView roundedArrowImageView;
            ConstraintLayout constraintLayout;
            AppCompatImageView appCompatImageView;
            AppCompatImageView appCompatImageView2;
            ViewTreeObserver viewTreeObserver;
            lt.f fVar = SearchGuideDialog.this.f52683c;
            if (fVar != null && (appCompatImageView2 = fVar.f70427c) != null && (viewTreeObserver = appCompatImageView2.getViewTreeObserver()) != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
            lt.f fVar2 = SearchGuideDialog.this.f52683c;
            ViewGroup.LayoutParams layoutParams = (fVar2 == null || (appCompatImageView = fVar2.f70427c) == null) ? null : appCompatImageView.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            lt.f fVar3 = SearchGuideDialog.this.f52683c;
            ViewGroup.LayoutParams layoutParams2 = (fVar3 == null || (constraintLayout = fVar3.f70429f) == null) ? null : constraintLayout.getLayoutParams();
            Intrinsics.e(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            int marginEnd = (((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams2)).width - bVar.getMarginEnd()) - f0.a(40.0f);
            lt.f fVar4 = SearchGuideDialog.this.f52683c;
            if (fVar4 == null || (roundedArrowImageView = fVar4.f70428d) == null) {
                return;
            }
            int iA = f0.a(20.0f) + marginEnd;
            uo.b.a.g(uo.b.f78622a, "the bubbleArrowPosition is " + iA + ", the marginStart is " + marginEnd, false, 2, null);
            roundedArrowImageView.setArrowPosition((float) iA);
        }
    }

    private final void initView() {
        ConstraintLayout constraintLayout;
        AppCompatImageView appCompatImageView;
        ViewTreeObserver viewTreeObserver;
        ConstraintLayout constraintLayout2;
        Window window;
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setBackgroundDrawable(null);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes != null) {
                attributes.gravity = 17;
            }
            WindowManager.LayoutParams attributes2 = window.getAttributes();
            if (attributes2 != null) {
                attributes2.width = d0.e();
            }
            WindowManager.LayoutParams attributes3 = window.getAttributes();
            if (attributes3 != null) {
                attributes3.height = d0.c();
            }
            window.setDimAmount(0.5f);
        }
        lt.f fVar = this.f52683c;
        if (fVar != null && (constraintLayout2 = fVar.f70429f) != null) {
            ViewGroup.LayoutParams layoutParams = constraintLayout2.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ConstraintLayout.b bVar2 = this.f52685f;
            if (bVar2 != null) {
                Intrinsics.d(bVar2);
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = ((ViewGroup.MarginLayoutParams) bVar2).topMargin - com.blankj.utilcode.util.d.c();
                ConstraintLayout.b bVar3 = this.f52685f;
                Intrinsics.d(bVar3);
                ((ViewGroup.MarginLayoutParams) bVar).width = ((ViewGroup.MarginLayoutParams) bVar3).width;
                ConstraintLayout.b bVar4 = this.f52685f;
                Intrinsics.d(bVar4);
                ((ViewGroup.MarginLayoutParams) bVar).height = ((ViewGroup.MarginLayoutParams) bVar4).height;
                ConstraintLayout.b bVar5 = this.f52685f;
                Intrinsics.d(bVar5);
                bVar.setMarginStart(bVar5.getMarginStart());
                uo.b.a aVar = uo.b.f78622a;
                ConstraintLayout.b bVar6 = this.f52685f;
                Intrinsics.d(bVar6);
                uo.b.a.g(aVar, "the searchLayoutParam.marginStart is " + bVar6.getMarginStart(), false, 2, null);
            }
            constraintLayout2.setLayoutParams(bVar);
        }
        lt.f fVar2 = this.f52683c;
        if (fVar2 != null && (appCompatImageView = fVar2.f70427c) != null && (viewTreeObserver = appCompatImageView.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new b());
        }
        lt.f fVar3 = this.f52683c;
        if (fVar3 == null || (constraintLayout = fVar3.f70429f) == null) {
            return;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SearchGuideDialog.q0(this.f52704a, view);
            }
        });
    }

    public static final void q0(SearchGuideDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.g(uo.b.f78622a, "the search button is clicked", false, 2, null);
        Function0<Unit> function0 = this$0.f52684d;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismiss();
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public String h0() {
        return "POSITION_SEARCH";
    }

    @Override // com.transsion.baseui.dialog.BaseDialog
    public h newLogViewConfig() {
        return new h("OneClickToDownloadDialog", false, 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        lt.f fVarC = lt.f.c(inflater);
        this.f52683c = fVarC;
        f52682i = true;
        if (fVarC != null) {
            return fVarC.getRoot();
        }
        return null;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        initView();
        uo.b.a.g(uo.b.f78622a, g0() + " --> onCreate()", false, 2, null);
        if (bundle != null) {
            dismissAllowingStateLoss();
        }
    }

    public final void p0(Function0<Unit> function0) {
        this.f52684d = function0;
    }

    public final void r0(ConstraintLayout.b bVar) {
        this.f52685f = bVar;
    }
}
