package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.member.R$layout;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSource;
import com.transsion.memberapi.R$string;
import kotlin.Metadata;
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
public final class MemberGuideDialog extends BaseDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f53269i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f53270j = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MemberCheckResult f53271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public su.b f53272d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f53273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public qu.c f53274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MemberSource f53275h;

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
    public static final class b extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                if (childAdapterPosition == 0) {
                    outRect.top = f0.a(24.0f);
                    outRect.bottom = f0.a(16.0f);
                } else if (childAdapterPosition != adapter.getItemCount() - 1) {
                    outRect.bottom = f0.a(16.0f);
                } else if (childAdapterPosition == adapter.getItemCount() - 1) {
                    outRect.bottom = f0.a(24.0f);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements su.b {
        public c() {
        }

        @Override // su.b
        public void a() {
            MemberGuideDialog.this.f53273f = false;
            com.transsion.member.a.f53220a.a(MemberGuideDialog.this.g0() + " --> startMemberPage --> onFailed() --> isPayMemberSuccess = false");
            if (!MemberGuideDialog.this.isAdded() || MemberGuideDialog.this.isDetached()) {
                return;
            }
            MemberGuideDialog.this.dismissAllowingStateLoss();
        }

        @Override // su.b
        public void onSuccess() {
            MemberGuideDialog.this.f53273f = true;
            com.transsion.member.a.f53220a.a(MemberGuideDialog.this.g0() + " --> startMemberPage --> onSuccess() --> isPayMemberSuccess = true");
            if (!MemberGuideDialog.this.isAdded() || MemberGuideDialog.this.isDetached()) {
                return;
            }
            MemberGuideDialog.this.dismissAllowingStateLoss();
        }
    }

    public MemberGuideDialog() {
        super(R$layout.dialog_fragment_member_guide_layout);
    }

    private final void initView() {
        TextView textView;
        TextView textView2;
        RecyclerView recyclerView;
        String str = p0(this.f53271c) + getString(R$string.member_guide_dialog_get_per);
        qu.c cVar = this.f53274g;
        TextView textView3 = cVar != null ? cVar.f74909j : null;
        if (textView3 != null) {
            textView3.setText(str);
        }
        qu.c cVar2 = this.f53274g;
        if (cVar2 != null && (recyclerView = cVar2.f74907h) != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MemberCheckResult memberCheckResult = this.f53271c;
            recyclerView.setAdapter(new f(memberCheckResult != null ? memberCheckResult.getMemberRights() : null));
            recyclerView.addItemDecoration(new b());
        }
        boolean zG = ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).g();
        qu.c cVar3 = this.f53274g;
        if (cVar3 != null && (textView2 = cVar3.f74909j) != null) {
            textView2.setVisibility(zG ? 0 : 8);
        }
        qu.c cVar4 = this.f53274g;
        if (cVar4 == null || (textView = cVar4.f74910k) == null) {
            return;
        }
        textView.setText(textView.getResources().getString(com.transsion.member.R$string.member_guide_dialog_title));
    }

    private final void r0() {
        AppCompatImageView appCompatImageView;
        View view;
        qu.c cVar = this.f53274g;
        if (cVar != null && (view = cVar.f74911l) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    MemberGuideDialog.s0(this.f53317a, view2);
                }
            });
        }
        qu.c cVar2 = this.f53274g;
        if (cVar2 == null || (appCompatImageView = cVar2.f74905f) == null) {
            return;
        }
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                MemberGuideDialog.t0(this.f53318a, view2);
            }
        });
    }

    public static final void s0(MemberGuideDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).S();
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.c((IMemberApi) objH, this$0.getActivity(), this$0.f53275h, this$0.new c(), false, 8, null);
    }

    public static final void t0(MemberGuideDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).j();
        if (!this$0.isAdded() || this$0.isDetached()) {
            return;
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        MemberSource memberSource;
        MemberCheckResult memberCheckResult;
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
        com.transsion.member.a.f53220a.a(g0() + " --> onCreate()");
        if (bundle != null && (memberCheckResult = (MemberCheckResult) bundle.getParcelable("mMemberCheckResult")) != null) {
            this.f53271c = memberCheckResult;
        }
        if (bundle == null || (memberSource = (MemberSource) bundle.getParcelable("source")) == null) {
            return;
        }
        this.f53275h = memberSource;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        if (this.f53273f) {
            su.b bVar = this.f53272d;
            if (bVar != null) {
                bVar.onSuccess();
                return;
            }
            return;
        }
        su.b bVar2 = this.f53272d;
        if (bVar2 != null) {
            bVar2.a();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putParcelable("mMemberCheckResult", this.f53271c);
        outState.putParcelable("source", this.f53275h);
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
            dialog3.setCancelable(true);
        }
        Dialog dialog4 = getDialog();
        if (dialog4 != null) {
            dialog4.setCanceledOnTouchOutside(false);
        }
        ((IInterceptReportApi) com.alibaba.android.arouter.launcher.a.d().h(IInterceptReportApi.class)).q();
        this.f53274g = qu.c.a(view);
        initView();
        r0();
    }

    public final String p0(MemberCheckResult memberCheckResult) {
        return (memberCheckResult != null ? memberCheckResult.getMemberPrice() : null) + " " + (memberCheckResult != null ? memberCheckResult.getCurrency() : null) + " ";
    }

    public final void q0(su.b callback) {
        Intrinsics.g(callback, "callback");
        this.f53272d = callback;
    }

    public final void u0(MemberCheckResult memberCheckResult) {
        this.f53271c = memberCheckResult;
    }

    public final void v0(MemberSource memberSource) {
        this.f53275h = memberSource;
    }
}
