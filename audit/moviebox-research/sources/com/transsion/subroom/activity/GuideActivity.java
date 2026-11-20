package com.transsion.subroom.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.room.R$string;
import com.transsion.subroom.R$anim;
import com.transsion.subroom.guide.GuideStepEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.r;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class GuideActivity extends BaseActivity<tx.a> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f57982c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<GuideFragment> f57983a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57984b;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class b extends FragmentStateAdapter {
        public b() {
            super(GuideActivity.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return (Fragment) GuideActivity.this.f57983a.get(i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return GuideActivity.this.f57983a.size();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public static final class c extends ViewPager2.OnPageChangeCallback {
        public c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            GuideActivity.this.f57984b = i11;
            if (i11 == 0) {
                ((tx.a) GuideActivity.this.getMViewBinding()).f78051b.setText(GuideActivity.this.getText(R$string.continue_));
                AppCompatTextView appCompatTextView = ((tx.a) GuideActivity.this.getMViewBinding()).f78052c;
                Intrinsics.f(appCompatTextView, "mViewBinding.btnSkip");
                so.c.k(appCompatTextView);
            } else {
                ((tx.a) GuideActivity.this.getMViewBinding()).f78051b.setText(GuideActivity.this.getText(com.transsion.subroom.R$string.get_started));
                AppCompatTextView appCompatTextView2 = ((tx.a) GuideActivity.this.getMViewBinding()).f78052c;
                Intrinsics.f(appCompatTextView2, "mViewBinding.btnSkip");
                so.c.g(appCompatTextView2);
            }
            ((tx.a) GuideActivity.this.getMViewBinding()).f78053d.select(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T() {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        GuideStepEnum guideStepEnum = GuideStepEnum.GUIDE_STEP_1;
        Fragment fragmentFindFragmentByTag = supportFragmentManager.findFragmentByTag(guideStepEnum.getValue());
        GuideFragment guideFragmentA = fragmentFindFragmentByTag instanceof GuideFragment ? (GuideFragment) fragmentFindFragmentByTag : GuideFragment.f57987b.a(guideStepEnum.ordinal());
        FragmentManager supportFragmentManager2 = getSupportFragmentManager();
        GuideStepEnum guideStepEnum2 = GuideStepEnum.GUIDE_STEP_2;
        Fragment fragmentFindFragmentByTag2 = supportFragmentManager2.findFragmentByTag(guideStepEnum2.getValue());
        GuideFragment guideFragmentA2 = fragmentFindFragmentByTag2 instanceof GuideFragment ? (GuideFragment) fragmentFindFragmentByTag2 : GuideFragment.f57987b.a(guideStepEnum2.ordinal());
        this.f57983a.add(guideFragmentA);
        this.f57983a.add(guideFragmentA2);
        ((tx.a) getMViewBinding()).f78054f.setAdapter(new b());
        ((tx.a) getMViewBinding()).f78054f.registerOnPageChangeCallback(new c());
    }

    public static final void U(GuideActivity this$0, tx.a this_apply, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        if (this$0.f57984b == 0) {
            this_apply.f78054f.setCurrentItem(1, false);
            com.transsion.baselib.report.m.f51277a.m("guide", "click", r.f(TuplesKt.a("module_name", "continue")));
        } else {
            this$0.finish();
            this$0.W();
            com.transsion.baselib.report.m.f51277a.m("guide", "click", r.f(TuplesKt.a("module_name", "get_started")));
        }
    }

    public static final void V(GuideActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
        this$0.W();
        com.transsion.baselib.report.m.f51277a.m("guide", "click", r.f(TuplesKt.a("module_name", "skip")));
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public tx.a getViewBinding() {
        tx.a aVarC = tx.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void W() {
        overridePendingTransition(0, R$anim.guide_out);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        this.f57984b = bundle != null ? bundle.getInt("current_index", GuideStepEnum.GUIDE_STEP_1.ordinal()) : GuideStepEnum.GUIDE_STEP_1.ordinal();
        T();
        final tx.a aVar = (tx.a) getMViewBinding();
        aVar.f78051b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.activity.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideActivity.U(this.f58027a, aVar, view);
            }
        });
        aVar.f78052c.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.activity.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuideActivity.V(this.f58029a, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("guide", false, 2, null);
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.g(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("current_index", this.f57984b);
    }
}
