package com.transsion.member.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import com.bumptech.glide.Glide;
import com.tn.lib.widget.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.member.R$layout;
import com.transsion.member.R$mipmap;
import com.transsion.member.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberTaskItem;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.r0;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ClaimMemberDialog extends BaseDialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MemberTaskItem f53264c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f53265d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f53266f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q1 f53267g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q1 f53268h;

    /* JADX INFO: renamed from: com.transsion.member.dialog.ClaimMemberDialog$onStart$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.member.dialog.ClaimMemberDialog$onStart$1", f = "ClaimMemberDialog.kt", l = {107}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClaimMemberDialog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                if (ClaimMemberDialog.this.q0() != null) {
                    long j11 = ClaimMemberDialog.this.f53266f;
                    this.label = 1;
                    if (r0.a(j11, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            ClaimMemberDialog.this.p0();
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.member.dialog.ClaimMemberDialog$onStart$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.member.dialog.ClaimMemberDialog$onStart$2", f = "ClaimMemberDialog.kt", l = {114}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ f1<Boolean> $dataFlow;
        int label;
        final /* synthetic */ ClaimMemberDialog this$0;

        /* JADX INFO: renamed from: com.transsion.member.dialog.ClaimMemberDialog$onStart$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.member.dialog.ClaimMemberDialog$onStart$2$1", f = "ClaimMemberDialog.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
            final /* synthetic */ f1<Boolean> $dataFlow;
            /* synthetic */ boolean Z$0;
            int label;
            final /* synthetic */ ClaimMemberDialog this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ClaimMemberDialog claimMemberDialog, f1<Boolean> f1Var, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = claimMemberDialog;
                this.$dataFlow = f1Var;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$dataFlow, continuation);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Boolean bool, Continuation<? super Unit> continuation) {
                return invoke(bool.booleanValue(), continuation);
            }

            public final Object invoke(boolean z11, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(Boolean.valueOf(z11), continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (!this.Z$0) {
                    this.this$0.p0();
                }
                com.transsion.member.a.f53220a.a("ClaimMemberDialog hasMemberShip:" + this.$dataFlow.getValue());
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(f1<Boolean> f1Var, ClaimMemberDialog claimMemberDialog, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$dataFlow = f1Var;
            this.this$0 = claimMemberDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$dataFlow, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                f1<Boolean> f1Var = this.$dataFlow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, f1Var, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.h(f1Var, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    public ClaimMemberDialog() {
        super(R$layout.dialog_member_claim_layout);
        this.f53265d = com.transsion.core.utils.e.a(50.0f);
        this.f53266f = 3500L;
    }

    private final void r0(View view) {
        qu.g gVarA = qu.g.a(view);
        Intrinsics.f(gVarA, "bind(view)");
        gVarA.f74939d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClaimMemberDialog.s0(this.f53314a, view2);
            }
        });
        gVarA.f74937b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.member.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ClaimMemberDialog.t0(this.f53315a, view2);
            }
        });
        MemberTaskItem memberTaskItem = this.f53264c;
        if (memberTaskItem != null) {
            TextView textView = gVarA.f74942h;
            String title = memberTaskItem.getTitle();
            if (title == null) {
                title = "";
            }
            textView.setText(title);
            TextView textView2 = gVarA.f74941g;
            String subTitle = memberTaskItem.getSubTitle();
            textView2.setText(subTitle != null ? subTitle : "");
            TextView textView3 = gVarA.f74937b;
            String buttonName = memberTaskItem.getButtonName();
            if (buttonName == null) {
                buttonName = getString(R$string.member_claim_now);
            }
            textView3.setText(buttonName);
            Glide.with(requireContext()).load2(memberTaskItem.getIcon()).placeholder(R$mipmap.ic_premium_mask).error(R$mipmap.ic_premium_mask).into(gVarA.f74940f);
        }
    }

    public static final void s0(ClaimMemberDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.p0();
    }

    public static final void t0(final ClaimMemberDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Object objH = com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class);
        Intrinsics.f(objH, "getInstance().navigation(IMemberApi::class.java)");
        IMemberApi.a.b((IMemberApi) objH, null, new Function0<Unit>() { // from class: com.transsion.member.dialog.ClaimMemberDialog$initView$2$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                this.this$0.p0();
            }
        }, 1, null);
    }

    private final void u0() {
        Window window;
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null) {
            dialog2.setCanceledOnTouchOutside(true);
        }
        window.setDimAmount(0.0f);
        window.setLayout(-1, -2);
        window.setGravity(48);
        WindowManager.LayoutParams attributes = window.getAttributes();
        Intrinsics.f(attributes, "it.attributes");
        attributes.flags |= 32;
        window.setAttributes(attributes);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.center_DialogStyle);
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        q1 q1Var = this.f53267g;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f53267g = null;
        q1 q1Var2 = this.f53268h;
        if (q1Var2 != null) {
            q1.a.b(q1Var2, null, 1, null);
        }
        this.f53268h = null;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        try {
            super.onStart();
        } catch (Exception unused) {
            dismiss();
        }
        this.f53267g = kotlinx.coroutines.j.d(v.a(this), w0.c(), null, new AnonymousClass1(null), 2, null);
        this.f53268h = kotlinx.coroutines.j.d(v.a(this), w0.c(), null, new AnonymousClass2(((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).d(), this, null), 2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        u0();
        r0(view);
    }

    public final void p0() {
        com.transsion.member.a.f53220a.a("ClaimMemberDialog lifecycle:" + getLifecycle().b());
        q1 q1Var = this.f53267g;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        q1 q1Var2 = this.f53268h;
        if (q1Var2 != null) {
            q1.a.b(q1Var2, null, 1, null);
        }
        if (getLifecycle().b().isAtLeast(Lifecycle.State.RESUMED)) {
            try {
                dismiss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final MemberTaskItem q0() {
        return this.f53264c;
    }

    public final void v0(MemberTaskItem memberTaskItem) {
        this.f53264c = memberTaskItem;
    }

    public final void w0(int i11) {
        this.f53265d = i11;
    }
}
