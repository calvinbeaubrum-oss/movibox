package com.transsion.member.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.member.MemberPromoCodeViewModel;
import com.transsion.member.R$layout;
import com.transsion.member.R$string;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class MemberPromoCodeDialog extends BaseDialog {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f53284g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53285h = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function0<Unit> f53286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qu.h f53287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f53288f;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MemberPromoCodeDialog a(Function0<Unit> callBack) {
            Intrinsics.g(callBack, "callBack");
            MemberPromoCodeDialog memberPromoCodeDialog = new MemberPromoCodeDialog();
            memberPromoCodeDialog.w0(callBack);
            return memberPromoCodeDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s11) {
            AppCompatEditText appCompatEditText;
            AppCompatEditText appCompatEditText2;
            Intrinsics.g(s11, "s");
            String string = s11.toString();
            if (Intrinsics.b(s11.toString(), string)) {
                return;
            }
            qu.h hVar = MemberPromoCodeDialog.this.f53287d;
            if (hVar != null && (appCompatEditText2 = hVar.f74948g) != null) {
                appCompatEditText2.setText(string);
            }
            qu.h hVar2 = MemberPromoCodeDialog.this.f53287d;
            if (hVar2 == null || (appCompatEditText = hVar2.f74948g) == null) {
                return;
            }
            appCompatEditText.setSelection(string.length());
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s11, int i11, int i12, int i13) {
            Intrinsics.g(s11, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s11, int i11, int i12, int i13) {
            ImageView imageView;
            AppCompatEditText appCompatEditText;
            Editable text;
            ImageView imageView2;
            Intrinsics.g(s11, "s");
            MemberPromoCodeDialog.this.x0("");
            qu.h hVar = MemberPromoCodeDialog.this.f53287d;
            if (hVar == null || (appCompatEditText = hVar.f74948g) == null || (text = appCompatEditText.getText()) == null || text.length() == 0) {
                qu.h hVar2 = MemberPromoCodeDialog.this.f53287d;
                if (hVar2 == null || (imageView = hVar2.f74945c) == null) {
                    return;
                }
                so.c.g(imageView);
                return;
            }
            qu.h hVar3 = MemberPromoCodeDialog.this.f53287d;
            if (hVar3 == null || (imageView2 = hVar3.f74945c) == null) {
                return;
            }
            so.c.k(imageView2);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f53290a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f53290a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f53290a;
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
            this.f53290a.invoke(obj);
        }
    }

    public MemberPromoCodeDialog() {
        super(R$layout.dialog_member_promo_code_layout);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return this;
            }
        };
        this.f53288f = FragmentViewModelLazyKt.a(this, Reflection.b(MemberPromoCodeViewModel.class), new Function0<x0>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final void initView() {
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        AppCompatEditText appCompatEditText;
        qu.h hVar = this.f53287d;
        if (hVar != null && (appCompatEditText = hVar.f74948g) != null) {
            appCompatEditText.addTextChangedListener(new b());
        }
        qu.h hVar2 = this.f53287d;
        if (hVar2 != null && (imageView2 = hVar2.f74944b) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.h
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.s0(this.f53320a, view);
                }
            });
        }
        qu.h hVar3 = this.f53287d;
        if (hVar3 != null && (imageView = hVar3.f74945c) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.i
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.t0(this.f53321a, view);
                }
            });
        }
        qu.h hVar4 = this.f53287d;
        if (hVar4 != null && (textView = hVar4.f74946d) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MemberPromoCodeDialog.u0(this.f53322a, view);
                }
            });
        }
        r0().d().j(getViewLifecycleOwner(), new c(new Function1<com.transsion.member.i, Unit>() { // from class: com.transsion.member.dialog.MemberPromoCodeDialog.initView.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(com.transsion.member.i iVar) {
                invoke2(iVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(com.transsion.member.i iVar) {
                if (!iVar.c()) {
                    if (Intrinsics.b(iVar.a(), "400")) {
                        MemberPromoCodeDialog memberPromoCodeDialog = MemberPromoCodeDialog.this;
                        String string = memberPromoCodeDialog.getString(R$string.member_promo_code_error_tips);
                        Intrinsics.f(string, "getString(R.string.member_promo_code_error_tips)");
                        memberPromoCodeDialog.x0(string);
                    } else {
                        com.tn.lib.widget.toast.core.h.f50034a.k(com.tn.lib.widget.R$string.error_load_failed);
                    }
                    qu.h hVar5 = MemberPromoCodeDialog.this.f53287d;
                    TextView textView2 = hVar5 != null ? hVar5.f74946d : null;
                    if (textView2 == null) {
                        return;
                    }
                    textView2.setEnabled(true);
                    return;
                }
                if (iVar.b() == null) {
                    MemberPromoCodeDialog memberPromoCodeDialog2 = MemberPromoCodeDialog.this;
                    String string2 = memberPromoCodeDialog2.getString(R$string.member_promo_code_error_tips);
                    Intrinsics.f(string2, "getString(R.string.member_promo_code_error_tips)");
                    memberPromoCodeDialog2.x0(string2);
                    return;
                }
                Context context = MemberPromoCodeDialog.this.getContext();
                if (context != null) {
                    if (iVar.b().getVipDurationDays() > 0) {
                        zp.b.a aVar = zp.b.f82110a;
                        int i11 = R$layout.claim_succeed_layout;
                        String string3 = context.getString(R$string.member_claimed_succeed_days, Integer.valueOf(iVar.b().getVipDurationDays()));
                        Intrinsics.f(string3, "getString(\n             …                        )");
                        aVar.g(i11, string3, (8 & 4) != 0 ? 0 : 17, (8 & 8) != 0 ? 0 : 0, (8 & 16) != 0 ? 0 : 0);
                    } else {
                        com.tn.lib.widget.toast.core.h.f50034a.k(R$string.member_enjoy_your_benefits_now);
                    }
                }
                MemberPromoCodeDialog.this.dismissAllowingStateLoss();
            }
        }));
    }

    public static final void s0(MemberPromoCodeDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public static final void t0(MemberPromoCodeDialog this$0, View view) {
        AppCompatEditText appCompatEditText;
        Intrinsics.g(this$0, "this$0");
        qu.h hVar = this$0.f53287d;
        if (hVar == null || (appCompatEditText = hVar.f74948g) == null) {
            return;
        }
        appCompatEditText.setText("");
    }

    public static final void u0(MemberPromoCodeDialog this$0, View view) {
        String string;
        AppCompatEditText appCompatEditText;
        Editable text;
        String string2;
        Intrinsics.g(this$0, "this$0");
        qu.h hVar = this$0.f53287d;
        if (hVar == null || (appCompatEditText = hVar.f74948g) == null || (text = appCompatEditText.getText()) == null || (string2 = text.toString()) == null || (string = StringsKt__StringsKt.Z0(string2).toString()) == null) {
            string = "";
        }
        if (string.length() == 0) {
            String string3 = this$0.getString(R$string.member_promo_code_empty_tips);
            Intrinsics.f(string3, "getString(R.string.member_promo_code_empty_tips)");
            this$0.x0(string3);
        } else {
            qu.h hVar2 = this$0.f53287d;
            TextView textView = hVar2 != null ? hVar2.f74946d : null;
            if (textView != null) {
                textView.setEnabled(false);
            }
            this$0.r0().f(string);
        }
    }

    public static final void v0(AppCompatEditText this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        this_apply.requestFocus();
        KeyboardUtils.i(this_apply);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomInputDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(requireContext(), getTheme());
        Window window = bVar.getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        bVar.o().U0(3);
        bVar.o().T0(true);
        return bVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics.g(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.f53286c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        final AppCompatEditText appCompatEditText;
        super.onStart();
        qu.h hVar = this.f53287d;
        if (hVar == null || (appCompatEditText = hVar.f74948g) == null) {
            return;
        }
        appCompatEditText.postDelayed(new Runnable() { // from class: com.transsion.member.dialog.g
            @Override // java.lang.Runnable
            public final void run() {
                MemberPromoCodeDialog.v0(appCompatEditText);
            }
        }, 200L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(true);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(false);
        }
        ((ITaskCenterApi) com.alibaba.android.arouter.launcher.a.d().h(ITaskCenterApi.class)).v1();
        this.f53287d = qu.h.a(view);
        initView();
    }

    public final MemberPromoCodeViewModel r0() {
        return (MemberPromoCodeViewModel) this.f53288f.getValue();
    }

    public final void w0(Function0<Unit> callBack) {
        Intrinsics.g(callBack, "callBack");
        this.f53286c = callBack;
    }

    public final void x0(String msg) {
        TextView textView;
        TextView textView2;
        Intrinsics.g(msg, "msg");
        if (msg.length() <= 0) {
            qu.h hVar = this.f53287d;
            if (hVar == null || (textView = hVar.f74947f) == null) {
                return;
            }
            so.c.h(textView);
            return;
        }
        qu.h hVar2 = this.f53287d;
        TextView textView3 = hVar2 != null ? hVar2.f74947f : null;
        if (textView3 != null) {
            textView3.setText(msg);
        }
        qu.h hVar3 = this.f53287d;
        if (hVar3 == null || (textView2 = hVar3.f74947f) == null) {
            return;
        }
        so.c.k(textView2);
    }
}
