package com.transsion.moviedetail.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.moviedetail.fragment.SubjectListFragment;
import com.transsion.moviedetailapi.AbsSubjectListViewModel;
import com.transsion.usercenter.R$id;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class SubjectListActivity extends BaseNewActivity<yp.a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f53436m = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bundle f53437i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Class<AbsSubjectListViewModel> f53438j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f53439k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Fragment f53440l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Bundle params, Class<? extends AbsSubjectListViewModel> type, String str) {
            Intrinsics.g(context, "context");
            Intrinsics.g(params, "params");
            Intrinsics.g(type, "type");
            Intent intent = new Intent(context, (Class<?>) SubjectListActivity.class);
            intent.putExtra("subject_params_key", params);
            intent.putExtra("view_model_type", type);
            intent.putExtra("subject_params_title", str);
            context.startActivity(intent);
        }
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        if (this.f53438j == null) {
            Intent intent = getIntent();
            Serializable serializableExtra = intent.getSerializableExtra("view_model_type");
            this.f53438j = serializableExtra instanceof Class ? (Class) serializableExtra : null;
            this.f53437i = intent.getBundleExtra("subject_params_key");
            this.f53439k = intent.getStringExtra("subject_params_title");
        }
        ConstraintLayout constraintLayoutB = ((yp.a) getMViewBinding()).getRoot();
        Intrinsics.f(constraintLayoutB, "mViewBinding.root");
        so.c.e(constraintLayoutB);
        TitleLayout titleLayout = ((yp.a) getMViewBinding()).f81575c;
        String str = this.f53439k;
        if (str == null) {
            str = "";
        }
        titleLayout.setTitleText(str);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean b0() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
        o0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "post_list";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    public final void o0() {
        SubjectListFragment subjectListFragmentA;
        Class<AbsSubjectListViewModel> cls = this.f53438j;
        if (cls == null) {
            finish();
            return;
        }
        Fragment fragmentFindFragmentByTag = getSupportFragmentManager().findFragmentByTag("subject_fragment_tag");
        if (fragmentFindFragmentByTag instanceof SubjectListFragment) {
            subjectListFragmentA = (SubjectListFragment) fragmentFindFragmentByTag;
        } else {
            SubjectListFragment.a aVar = SubjectListFragment.C;
            Bundle bundle = this.f53437i;
            if (bundle == null) {
                bundle = new Bundle();
            }
            subjectListFragmentA = aVar.a(bundle, cls);
        }
        this.f53440l = subjectListFragmentA;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        Fragment fragment = this.f53440l;
        if (fragment != null) {
            fragmentTransactionBeginTransaction.replace(R$id.container, fragment, "subject_fragment_tag");
        }
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        o0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public yp.a getViewBinding() {
        yp.a aVarC = yp.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            k0();
        } else {
            g0();
            c0();
        }
    }
}
