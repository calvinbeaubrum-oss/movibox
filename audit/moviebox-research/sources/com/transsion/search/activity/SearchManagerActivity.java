package com.transsion.search.activity;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseNewActivity;
import com.transsion.search.R$id;
import com.transsion.search.fragment.SearchSubjectFragment;
import com.transsion.search.fragment.group.SearchUploadGroupFragment;
import com.transsion.search.fragment.group.SearchUploadWorkFragment;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/search/activity/search_manager")
@Metadata
@SourceDebugExtension
public final class SearchManagerActivity extends BaseNewActivity<bx.a> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f57432m = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Fragment f57433i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Autowired(name = "keyword")
    @JvmField
    public String f57434j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Autowired(name = "type")
    @JvmField
    public int f57435k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Autowired(name = "back_exit")
    @JvmField
    public boolean f57436l;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(String msg) {
            Intrinsics.g(msg, "msg");
            Log.w("zxb_log_search", msg);
        }
    }

    private final void p0() {
        Fragment fragmentA;
        if (this.f57433i != null) {
            return;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.f(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction fragmentTransactionBeginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.f(fragmentTransactionBeginTransaction, "beginTransaction()");
        String stringExtra = getIntent().getStringExtra("hot_search_word");
        int i11 = this.f57435k;
        if (i11 != 2) {
            fragmentA = i11 != 3 ? SearchUploadWorkFragment.f57479k.a(i11) : SearchSubjectFragment.f57447n.a(stringExtra, this.f57434j, this.f57436l);
        } else {
            fragmentA = SearchUploadGroupFragment.Companion.a(i11);
        }
        a aVar = f57432m;
        Fragment fragment = this.f57433i;
        aVar.a("fragment = " + (fragment != null ? fragment.getClass().getSimpleName() : null));
        fragmentTransactionBeginTransaction.replace(R$id.fl_content, fragmentA);
        this.f57433i = fragmentA;
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public String U() {
        return "";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void X() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Y() {
        com.alibaba.android.arouter.launcher.a.d().f(this);
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void Z() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean a0() {
        return this.f57435k != 1;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void c0() {
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void d0() {
        super.d0();
        p0();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "searchpage";
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isChangeStatusBar() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public bx.a getViewBinding() {
        bx.a aVarC = bx.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseNewActivity
    public void retryLoadData() {
        i0();
        if (!f.f49475a.e()) {
            k0();
        } else {
            g0();
            p0();
        }
    }
}
