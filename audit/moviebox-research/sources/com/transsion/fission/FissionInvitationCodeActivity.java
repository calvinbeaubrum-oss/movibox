package com.transsion.fission;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.i;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.fissionapi.IFissionProvider;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Route(path = "/fission/invitation_code")
@Metadata
@SourceDebugExtension
public final class FissionInvitationCodeActivity extends BaseActivity<et.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f51898a = LazyKt__LazyJVMKt.b(new Function0<IFissionProvider>() { // from class: com.transsion.fission.FissionInvitationCodeActivity$mFissionProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final IFissionProvider invoke() {
            return (IFissionProvider) com.alibaba.android.arouter.launcher.a.d().h(IFissionProvider.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51899b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    @SourceDebugExtension
    public static final class a implements TextWatcher {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AppCompatButton appCompatButton = ((et.a) FissionInvitationCodeActivity.this.getMViewBinding()).f64351b;
            boolean z11 = false;
            if (editable != null && editable.length() == 8) {
                z11 = true;
            }
            appCompatButton.setSelected(z11);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f51901a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f51901a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f51901a;
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
            this.f51901a.invoke(obj);
        }
    }

    public FissionInvitationCodeActivity() {
        final Function0 function0 = null;
        this.f51899b = new ViewModelLazy(Reflection.b(FissionInvitationViewModel.class), new Function0<x0>() { // from class: com.transsion.fission.FissionInvitationCodeActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = this.getViewModelStore();
                Intrinsics.f(viewModelStore, "viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.fission.FissionInvitationCodeActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                v0.c defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                Intrinsics.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }, new Function0<r3.a>() { // from class: com.transsion.fission.FissionInvitationCodeActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final r3.a invoke() {
                r3.a aVar;
                Function0 function1 = function0;
                if (function1 != null && (aVar = (r3.a) function1.invoke()) != null) {
                    return aVar;
                }
                r3.a defaultViewModelCreationExtras = this.getDefaultViewModelCreationExtras();
                Intrinsics.f(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        });
    }

    public static final void T(FissionInvitationCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void U(FissionInvitationCodeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Editable text = ((et.a) this$0.getMViewBinding()).f64352c.getText();
        String string = text != null ? text.toString() : null;
        if (string == null || string.length() != 8) {
            return;
        }
        this$0.W(string);
    }

    private final void V() {
        Q().d().j(this, new b(new Function1<BaseDto<Object>, Unit>() { // from class: com.transsion.fission.FissionInvitationCodeActivity$initViewModel$1
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
                if (baseDto == null) {
                    return;
                }
                if (!Intrinsics.b(baseDto.getCode(), "0")) {
                    h.f50034a.k(R$string.fission_invitation_err);
                    return;
                }
                h.f50034a.k(R$string.fission_invitation_success);
                this.this$0.setResult(-1);
                this.this$0.finish();
            }
        }));
    }

    public final FissionInvitationViewModel Q() {
        return (FissionInvitationViewModel) this.f51899b.getValue();
    }

    public final IFissionProvider R() {
        return (IFissionProvider) this.f51898a.getValue();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public et.a getViewBinding() {
        et.a aVarC = et.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void W(String str) {
        if (tp.e.f77259a.a(this)) {
            Q().e(str);
        } else {
            h.f50034a.k(com.transsion.baseui.R$string.base_net_err);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        TitleLayout titleLayout = ((et.a) getMViewBinding()).f64353d;
        String string = getString(R$string.fission_invitation_code);
        Intrinsics.f(string, "getString(R.string.fission_invitation_code)");
        titleLayout.setTitleText(string);
        ((et.a) getMViewBinding()).f64353d.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.fission.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FissionInvitationCodeActivity.T(this.f51913a, view);
            }
        });
        AppCompatEditText appCompatEditText = ((et.a) getMViewBinding()).f64352c;
        IFissionProvider iFissionProviderR = R();
        appCompatEditText.setText(iFissionProviderR != null ? iFissionProviderR.I0() : null);
        AppCompatEditText appCompatEditText2 = ((et.a) getMViewBinding()).f64352c;
        Intrinsics.f(appCompatEditText2, "mViewBinding.etInvitationCode");
        gt.a.a(appCompatEditText2, i.e(4.0f));
        AppCompatEditText appCompatEditText3 = ((et.a) getMViewBinding()).f64352c;
        Intrinsics.f(appCompatEditText3, "mViewBinding.etInvitationCode");
        appCompatEditText3.addTextChangedListener(new a());
        ((et.a) getMViewBinding()).f64351b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.fission.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FissionInvitationCodeActivity.U(this.f51914a, view);
            }
        });
        V();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return RoomAppMMKV.f51271a.a().getBoolean("dark_mode_follow_sys", true) && !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
