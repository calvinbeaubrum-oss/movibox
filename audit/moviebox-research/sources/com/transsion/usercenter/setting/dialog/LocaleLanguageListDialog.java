package com.transsion.usercenter.setting.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.locale.LocaleChangedHelper;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.setting.viewmodel.LocaleLanguageViewModel;
import f9.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import xy.w;

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
public final class LocaleLanguageListDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f59682g = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f59683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public jz.b f59684d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LocaleLanguageViewModel f59685f;

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
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59686a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59686a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59686a;
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
            this.f59686a.invoke(obj);
        }
    }

    public LocaleLanguageListDialog() {
        super(R$layout.dialog_locale_language);
    }

    public static final void q0(jz.b this_apply, LocaleLanguageListDialog this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "<anonymous parameter 1>");
        Object item = adapter.getItem(i11);
        if (item instanceof kz.a) {
            LocaleChangedHelper.f51197a.a(this_apply.getContext(), ((kz.a) item).b());
        }
        this$0.dismissAllowingStateLoss();
    }

    private final void r0() {
        Context context = getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        if (appCompatActivity != null) {
            LocaleLanguageViewModel localeLanguageViewModel = (LocaleLanguageViewModel) new v0(appCompatActivity).a(LocaleLanguageViewModel.class);
            localeLanguageViewModel.d().j(appCompatActivity, new b(new Function1<List<kz.a>, Unit>() { // from class: com.transsion.usercenter.setting.dialog.LocaleLanguageListDialog$initData$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<kz.a> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<kz.a> list) {
                    jz.b bVar = this.this$0.f59684d;
                    if (bVar != null) {
                        bVar.w0(list);
                    }
                }
            }));
            localeLanguageViewModel.c();
            this.f59685f = localeLanguageViewModel;
        }
    }

    private final void s0(View view) {
        AppCompatTextView appCompatTextView;
        w wVarA = w.a(view);
        this.f59683c = wVarA;
        if (wVarA == null || (appCompatTextView = wVarA.f80981c) == null) {
            return;
        }
        appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                LocaleLanguageListDialog.t0(this.f59687a, view2);
            }
        });
    }

    public static final void t0(LocaleLanguageListDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext, getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
            window.setGravity(80);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "this.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.blankj.utilcode.util.d0.e();
            window.setAttributes(attributes);
            window.setBackgroundDrawable(null);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        s0(view);
        p0();
        r0();
    }

    public final void p0() {
        RecyclerView recyclerView;
        final jz.b bVar = new jz.b(new ArrayList());
        bVar.B0(new d() { // from class: com.transsion.usercenter.setting.dialog.c
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocaleLanguageListDialog.q0(bVar, this, baseQuickAdapter, view, i11);
            }
        });
        this.f59684d = bVar;
        w wVar = this.f59683c;
        if (wVar == null || (recyclerView = wVar.f80980b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f59684d);
    }
}
