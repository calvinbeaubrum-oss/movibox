package com.transsnet.login.country;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.KeyboardUtils;
import com.transsion.baseui.activity.BaseActivity;
import com.transsnet.login.country.widget.SideBar;
import com.transsnet.loginapi.bean.Country;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n00.i;

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
@Route(path = "/loginapi/select_country")
@Metadata
@SourceDebugExtension
public final class LoginSelectCountryActivity extends BaseActivity<i> implements View.OnClickListener, SideBar.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public k00.a f61456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SelectCountryViewModel f61457b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f61458a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f61458a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f61458a;
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
            this.f61458a.invoke(obj);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void V(LoginSelectCountryActivity this$0) {
        Intrinsics.g(this$0, "this$0");
        KeyboardUtils.e(((i) this$0.getMViewBinding()).f71429d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Z(List<? extends Country> list) {
        k00.a aVar = this.f61456a;
        if (aVar == null) {
            this.f61456a = new k00.a(getApplicationContext(), this.f61457b, list);
            ((i) getMViewBinding()).f71429d.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            ((i) getMViewBinding()).f71429d.setAdapter(this.f61456a);
        } else if (aVar != null) {
            aVar.f(list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((i) getMViewBinding()).f71430f.setScrollerListener(this);
        ((i) getMViewBinding()).f71427b.setOnClickListener(this);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
    public i getViewBinding() {
        i iVarC = i.c(getLayoutInflater());
        Intrinsics.f(iVarC, "inflate(layoutInflater)");
        return iVarC;
    }

    public final void U(Bundle bundle) {
        SelectCountryViewModel selectCountryViewModel = (SelectCountryViewModel) new v0(this).a(SelectCountryViewModel.class);
        this.f61457b = selectCountryViewModel;
        if (selectCountryViewModel != null) {
            selectCountryViewModel.e().j(this, new a(new Function1<List<? extends Country>, Unit>() { // from class: com.transsnet.login.country.LoginSelectCountryActivity$initData$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends Country> list) {
                    invoke2(list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<? extends Country> list) {
                    if (list != null) {
                        this.this$0.Z(list);
                    }
                }
            }));
            selectCountryViewModel.j().j(this, new a(new Function1<List<? extends String>, Unit>() { // from class: com.transsnet.login.country.LoginSelectCountryActivity$initData$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                    invoke2((List<String>) list);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(List<String> list) {
                    if (list != null) {
                        this.this$0.a0(list);
                    }
                }
            }));
            selectCountryViewModel.i().j(this, new a(new Function1<l00.a<Country>, Unit>() { // from class: com.transsnet.login.country.LoginSelectCountryActivity$initData$1$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(l00.a<Country> aVar) {
                    invoke2(aVar);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(l00.a<Country> aVar) {
                    this.this$0.X(aVar);
                }
            }));
            selectCountryViewModel.h().j(this, new a(new Function1<Integer, Unit>() { // from class: com.transsnet.login.country.LoginSelectCountryActivity$initData$1$4
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    this.this$0.W(num);
                }
            }));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void W(Integer num) {
        if (num != null) {
            ((i) getMViewBinding()).f71429d.scrollToPosition(num.intValue());
            RecyclerView.m layoutManager = ((i) getMViewBinding()).f71429d.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(num.intValue(), 0);
            }
        }
    }

    public final void X(l00.a<Country> aVar) {
        if (aVar != null) {
            Y(aVar.a());
        }
    }

    public final void Y(Country country) {
        if (country != null) {
            Intent intent = new Intent();
            intent.putExtra("countryCode", country);
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a0(List<String> list) {
        ((i) getMViewBinding()).f71430f.setIndexs(list);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onBackPressed();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
        U(bundle);
        KeyboardUtils.d(this);
        ((i) getMViewBinding()).f71429d.postDelayed(new Runnable() { // from class: com.transsnet.login.country.a
            @Override // java.lang.Runnable
            public final void run() {
                LoginSelectCountryActivity.V(this.f61464a);
            }
        }, 200L);
    }

    @Override // com.transsnet.login.country.widget.SideBar.a
    public void t(String str) {
        SelectCountryViewModel selectCountryViewModel;
        if (str == null || (selectCountryViewModel = this.f61457b) == null) {
            return;
        }
        selectCountryViewModel.o(str);
    }
}
