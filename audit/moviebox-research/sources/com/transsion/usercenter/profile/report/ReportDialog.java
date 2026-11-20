package com.transsion.usercenter.profile.report;

import android.R;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.m;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.R$string;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class ReportDialog extends BaseDialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59593i = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.usercenter.profile.report.a f59595d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f59596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f59597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.transsion.share.share.e f59598h;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ReportDialog a(String str, String id2) {
            Intrinsics.g(id2, "id");
            ReportDialog reportDialog = new ReportDialog();
            reportDialog.setArguments(androidx.core.os.c.b(TuplesKt.a("report_type", str), TuplesKt.a("id", id2)));
            return reportDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59599a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59599a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59599a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f59599a.invoke(obj);
        }
    }

    public ReportDialog() {
        super(R$layout.layout_report);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f59594c = FragmentViewModelLazyKt.a(this, Reflection.b(ReportViewModel.class), new Function0<x0>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                m mVar = objInvoke instanceof m ? (m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final ReportViewModel s0() {
        return (ReportViewModel) this.f59594c.getValue();
    }

    private final void v0() {
        s0().f().j(getViewLifecycleOwner(), new b(new Function1<BaseDto<Object>, Unit>() { // from class: com.transsion.usercenter.profile.report.ReportDialog$initLiveData$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseDto<Object> baseDto) {
                invoke2(baseDto);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseDto<Object> baseDto) {
                zp.b.f82110a.d(R$string.reported);
                this.this$0.dismissAllowingStateLoss();
                com.transsion.share.share.e eVarU0 = this.this$0.u0();
                if (eVarU0 != null) {
                    eVarU0.b(this.this$0.f59597g);
                }
            }
        }));
    }

    private final void w0(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.report_list);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
            com.transsion.usercenter.profile.report.a aVar = new com.transsion.usercenter.profile.report.a(q0());
            aVar.B0(new f9.d() { // from class: com.transsion.usercenter.profile.report.d
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    ReportDialog.x0(this.f59608a, baseQuickAdapter, view2, i11);
                }
            });
            this.f59595d = aVar;
            recyclerView.setAdapter(aVar);
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.iv_close);
        if (appCompatImageView != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.report.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReportDialog.y0(this.f59609a, view2);
                }
            });
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(R$id.btn_submit);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.profile.report.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ReportDialog.z0(this.f59610a, view2);
                }
            });
        }
    }

    public static final void x0(ReportDialog this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.r0(Integer.valueOf(i11));
    }

    public static final void y0(ReportDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void z0(ReportDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS)) {
            return;
        }
        String strT0 = this$0.t0();
        if (strT0 == null) {
            zp.b.f82110a.d(R$string.tip_blank);
        } else {
            this$0.s0().h(this$0.f59596f, this$0.f59597g, strT0);
        }
    }

    public final void A0(com.transsion.share.share.e eVar) {
        this.f59598h = eVar;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.g(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(requireContext(), R$style.BottomDialogTheme);
        bVar.o().U0(3);
        bVar.o().T0(true);
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.getAttributes().gravity = 80;
        window.getAttributes().height = -2;
        View viewFindViewById = window.findViewById(com.google.android.material.R$id.design_bottom_sheet);
        if (viewFindViewById != null) {
            viewFindViewById.setBackgroundResource(R.color.transparent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        this.f59596f = arguments != null ? arguments.getString("report_type") : null;
        Bundle arguments2 = getArguments();
        this.f59597g = arguments2 != null ? arguments2.getString("id") : null;
        w0(view);
        v0();
    }

    public final List<c> q0() {
        String[] strArr = {getString(R$string.report_0), getString(R$string.report_1), getString(R$string.report_2), getString(R$string.report_3), getString(R$string.report_4), getString(R$string.report_5), getString(R$string.report_6), getString(R$string.report_7), getString(R$string.report_8)};
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < 9; i11++) {
            String str = strArr[i11];
            Intrinsics.f(str, "reportNames[i]");
            arrayList.add(new c(str, false));
        }
        return arrayList;
    }

    public final void r0(Integer num) {
        List<c> listD;
        com.transsion.usercenter.profile.report.a aVar = this.f59595d;
        if (aVar != null && (listD = aVar.D()) != null) {
            int i11 = 0;
            for (Object obj : listD) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    g.u();
                }
                ((c) obj).c(num != null && i11 == num.intValue());
                i11 = i12;
            }
        }
        com.transsion.usercenter.profile.report.a aVar2 = this.f59595d;
        if (aVar2 != null) {
            aVar2.notifyDataSetChanged();
        }
    }

    public final String t0() {
        List<c> listD;
        com.transsion.usercenter.profile.report.a aVar = this.f59595d;
        if (aVar == null || (listD = aVar.D()) == null) {
            return null;
        }
        for (c cVar : listD) {
            if (cVar.b()) {
                return cVar.a();
            }
        }
        return null;
    }

    public final com.transsion.share.share.e u0() {
        return this.f59598h;
    }
}
