package com.transsion.edcation.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.lifecycle.v;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.dialog.BaseDialogFragment;
import com.transsion.baseui.util.d;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.R$id;
import com.transsion.edcation.R$layout;
import com.transsion.edcation.bean.EducationInterestResp;
import com.transsion.edcation.bean.InterestBean;
import com.transsion.edcation.bean.InterestBody;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.List;
import k10.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
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
@SourceDebugExtension
public final class InterestSelectDialog extends BaseDialogFragment<bt.a> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f51875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f51876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f51877h;

    /* JADX INFO: renamed from: com.transsion.edcation.dialog.InterestSelectDialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<LayoutInflater, ViewGroup, Boolean, bt.a> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3, bt.a.class, "inflate", "inflate(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Z)Lcom/transsion/edcation/databinding/DialogInterestSelectBinding;", 0);
        }

        public final bt.a invoke(LayoutInflater p11, ViewGroup viewGroup, boolean z11) {
            Intrinsics.g(p11, "p0");
            return bt.a.c(p11, viewGroup, z11);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ bt.a invoke(LayoutInflater layoutInflater, ViewGroup viewGroup, Boolean bool) {
            return invoke(layoutInflater, viewGroup, bool.booleanValue());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f51878a = new a<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<EducationInterestResp>> apply(Throwable it) {
            Intrinsics.g(it, "it");
            return j.i(it);
        }
    }

    public InterestSelectDialog() {
        super(AnonymousClass1.INSTANCE);
        this.f51875f = LazyKt__LazyJVMKt.b(new Function0<com.transsion.edcation.a>() { // from class: com.transsion.edcation.dialog.InterestSelectDialog$mApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.transsion.edcation.a invoke() {
                return (com.transsion.edcation.a) NetServiceGenerator.f49399d.a().i(com.transsion.edcation.a.class);
            }
        });
        this.f51876g = new ArrayList();
        this.f51877h = "InterestSelectDialog";
    }

    public static final void A0(InterestSelectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void v0(View view, InterestSelectDialog this$0, InterestBean item, View view2) {
        Intrinsics.g(view, "$view");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(item, "$item");
        view.setSelected(!view.isSelected());
        if (view.isSelected()) {
            this$0.f51876g.add(item.getId());
        } else {
            this$0.f51876g.remove(item.getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.edcation.a y0() {
        return (com.transsion.edcation.a) this.f51875f.getValue();
    }

    public static final void z0(final InterestSelectDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        d.b(0L, new Function0<Unit>() { // from class: com.transsion.edcation.dialog.InterestSelectDialog$initView$1$1

            /* JADX INFO: renamed from: com.transsion.edcation.dialog.InterestSelectDialog$initView$1$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.edcation.dialog.InterestSelectDialog$initView$1$1$1", f = "InterestSelectDialog.kt", l = {60}, m = "invokeSuspend")
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
                private /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ InterestSelectDialog this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(InterestSelectDialog interestSelectDialog, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.this$0 = interestSelectDialog;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
                    anonymousClass1.L$0 = obj;
                    return anonymousClass1;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objM163constructorimpl;
                    InterestSelectDialog interestSelectDialog;
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    try {
                        if (i11 == 0) {
                            ResultKt.b(obj);
                            InterestSelectDialog interestSelectDialog2 = this.this$0;
                            Result.Companion companion = Result.Companion;
                            com.transsion.edcation.a aVarY0 = interestSelectDialog2.y0();
                            InterestBody interestBody = new InterestBody(interestSelectDialog2.f51876g);
                            this.L$0 = interestSelectDialog2;
                            this.label = 1;
                            Object objC = com.transsion.edcation.a.C0564a.c(aVarY0, null, interestBody, this, 1, null);
                            if (objC == objE) {
                                return objE;
                            }
                            interestSelectDialog = interestSelectDialog2;
                            obj = objC;
                        } else {
                            if (i11 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            interestSelectDialog = (InterestSelectDialog) this.L$0;
                            ResultKt.b(obj);
                        }
                        BaseDto baseDto = (BaseDto) obj;
                        String unused = interestSelectDialog.f51877h;
                        List list = interestSelectDialog.f51876g;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("res: ");
                        sb2.append(baseDto);
                        sb2.append(", ids: ");
                        sb2.append(list);
                        if (Intrinsics.b(baseDto.getCode(), "0")) {
                            interestSelectDialog.i0();
                        }
                        objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                    }
                    InterestSelectDialog interestSelectDialog3 = this.this$0;
                    Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                    if (thM166exceptionOrNullimpl != null && interestSelectDialog3.isAdded() && !interestSelectDialog3.isDetached() && !interestSelectDialog3.isRemoving()) {
                        com.tn.lib.widget.toast.core.h.f50034a.l(Utils.a().getString(R$string.no_error_content));
                        String unused2 = interestSelectDialog3.f51877h;
                        String message = thM166exceptionOrNullimpl.getMessage();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("error: ");
                        sb3.append(message);
                    }
                    return Unit.f68710a;
                }
            }

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
                if (!this.this$0.f51876g.isEmpty()) {
                    kotlinx.coroutines.j.d(v.a(this.this$0), w0.b(), null, new AnonymousClass1(this.this$0, null), 2, null);
                } else {
                    if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                        return;
                    }
                    com.tn.lib.widget.toast.core.h.f50034a.l(Utils.a().getString(com.transsion.edcation.R$string.course_interest_select_tips));
                }
            }
        }, 1, null);
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public boolean h0() {
        return false;
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void initView() {
        getMViewBinding().f14395d.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterestSelectDialog.z0(this.f51880a, view);
            }
        });
        getMViewBinding().f14396f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterestSelectDialog.A0(this.f51881a, view);
            }
        });
        x0();
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void k0() {
    }

    @Override // com.transsion.baseui.dialog.BaseDialogFragment
    public void l0(Window window) {
        Intrinsics.g(window, "window");
        super.l0(window);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = -2;
        attributes.width = d0.e() - gs.a.a(40);
        window.setAttributes(attributes);
    }

    public final void u0(List<InterestBean> list) {
        Context context = getContext();
        if (context == null) {
            i0();
            return;
        }
        getMViewBinding().f14393b.removeAllViews();
        for (final InterestBean interestBean : list) {
            final View viewW0 = w0(context);
            ((TextView) viewW0.findViewById(R$id.tvContent)).setText(interestBean.getName());
            viewW0.setMinimumHeight(f0.a(40.0f));
            viewW0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.edcation.dialog.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    InterestSelectDialog.v0(viewW0, this, interestBean, view);
                }
            });
            getMViewBinding().f14393b.addView(viewW0);
        }
        CourseManager.f51853a.o(false);
        RoomAppMMKV.f51271a.a().putBoolean("edu_interest_dialog", false);
    }

    @SuppressLint({"InflateParams"})
    public final View w0(Context context) {
        Intrinsics.g(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.item_select_interest, (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(context).inflate(R.…em_select_interest, null)");
        return viewInflate;
    }

    public final void x0() {
        com.transsion.edcation.a.C0564a.a(y0(), null, 1, null).r(q10.a.b()).t(a.f51878a).e(zo.d.f82109a.c()).subscribe(new zo.a<EducationInterestResp>() { // from class: com.transsion.edcation.dialog.InterestSelectDialog$getInterestList$2
            @Override // zo.a
            public void a(String str, String str2) {
                String unused = this.f51879d.f51877h;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error: ");
                sb2.append(str);
                sb2.append(", msg:");
                sb2.append(str2);
                if (!this.f51879d.isAdded() || this.f51879d.isDetached() || this.f51879d.isRemoving()) {
                    return;
                }
                com.tn.lib.widget.toast.core.h.f50034a.l(Utils.a().getString(R$string.error_load_failed));
                this.f51879d.i0();
            }

            @Override // zo.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(EducationInterestResp educationInterestResp) {
                List<InterestBean> options;
                List<InterestBean> options2;
                super.c(educationInterestResp);
                String unused = this.f51879d.f51877h;
                Integer numValueOf = (educationInterestResp == null || (options2 = educationInterestResp.getOptions()) == null) ? null : Integer.valueOf(options2.size());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("list is empty: ");
                sb2.append(numValueOf);
                if (this.f51879d.getContext() == null || educationInterestResp == null || (options = educationInterestResp.getOptions()) == null || options.isEmpty()) {
                    return;
                }
                kotlinx.coroutines.j.d(v.a(this.f51879d), w0.c(), null, new InterestSelectDialog$getInterestList$2$onSuccess$1(this.f51879d, options, null), 2, null);
            }
        });
    }
}
