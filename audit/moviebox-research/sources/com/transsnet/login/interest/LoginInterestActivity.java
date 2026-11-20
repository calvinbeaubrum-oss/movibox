package com.transsnet.login.interest;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.R$array;
import com.transsnet.login.constant.LoginMmkvUtil;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LoginInterestActivity extends BaseActivity<n00.d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LoginInterestViewModel f61525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f61526b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61527a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61527a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61527a;
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
            this.f61527a.invoke(obj);
        }
    }

    public static final void R(LoginInterestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.setResult(0);
        this$0.finish();
    }

    public static final void S(LoginInterestActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LoginInterestViewModel loginInterestViewModel = this$0.f61525a;
        if (loginInterestViewModel != null) {
            d dVar = this$0.f61526b;
            loginInterestViewModel.e(dVar != null ? dVar.e() : null);
        }
    }

    private final void T() {
        LoginInterestViewModel loginInterestViewModel = (LoginInterestViewModel) new v0(this).a(LoginInterestViewModel.class);
        this.f61525a = loginInterestViewModel;
        if (loginInterestViewModel != null) {
            loginInterestViewModel.d().j(this, new a(new Function1<String, Unit>() { // from class: com.transsnet.login.interest.LoginInterestActivity$initViewModel$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str) {
                    invoke2(str);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str) {
                    this.this$0.setResult(-1);
                    this.this$0.finish();
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        LoginMmkvUtil.f61452a.a().putBoolean("login_interest_show", true);
        ((n00.d) getMViewBinding()).f71385d.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.interest.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginInterestActivity.R(this.f61529a, view);
            }
        });
        String[] stringArray = getResources().getStringArray(R$array.interest);
        Intrinsics.f(stringArray, "resources.getStringArray(R.array.interest)");
        this.f61526b = new d(kotlin.collections.d.A0(stringArray), new Function1<List<? extends Integer>, Unit>() { // from class: com.transsnet.login.interest.LoginInterestActivity.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
                invoke2((List<Integer>) list);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Integer> it) {
                Intrinsics.g(it, "it");
                ((n00.d) LoginInterestActivity.this.getMViewBinding()).f71384c.setEnabled(!it.isEmpty());
            }
        });
        ((n00.d) getMViewBinding()).f71384c.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.login.interest.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LoginInterestActivity.S(this.f61530a, view);
            }
        });
        RecyclerView recyclerView = ((n00.d) getMViewBinding()).f71383b;
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(this);
        flexboxLayoutManager.P(0);
        flexboxLayoutManager.Q(1);
        flexboxLayoutManager.R(0);
        recyclerView.setLayoutManager(flexboxLayoutManager);
        recyclerView.setAdapter(this.f61526b);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public n00.d getViewBinding() {
        n00.d dVarC = n00.d.c(getLayoutInflater());
        Intrinsics.f(dVarC, "inflate(layoutInflater)");
        return dVarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T();
        initView();
    }
}
