package com.transsion.home.activity;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.report.h;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.home.R$id;
import com.transsion.home.R$mipmap;
import com.transsion.home.R$string;
import com.transsion.home.activity.FilterActivity;
import com.transsion.home.fragment.tab.FilterFragment;
import es.b;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import yp.a;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Route(path = "/home/filter")
@Metadata
public final class FilterActivity extends BaseActivity<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "tabId")
    @JvmField
    public int f51981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "tabCode")
    @JvmField
    public String f51982b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "filterType")
    @JvmField
    public String f51983c;

    private final void R() {
        getSupportFragmentManager().beginTransaction().replace(R$id.container, FilterFragment.A.a(this.f51981a, this.f51982b, this.f51983c)).commitNow();
    }

    public static final void S(FilterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        b bVar = (b) es.a.f64348a.a(b.class);
        if (bVar != null) {
            bVar.c("", this$0);
        }
    }

    public static final void T(FilterActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.V();
        this$0.finish();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public a getViewBinding() {
        a aVarC = a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void U() {
        HashMap map = new HashMap();
        map.put("event_type", "back_browse");
        map.put("tabId", String.valueOf(this.f51981a));
        com.transsion.baselib.helper.a.f51183a.d(getPageName(), map);
    }

    public final void V() {
        HashMap map = new HashMap();
        map.put("event_type", "back_click");
        map.put("tabId", String.valueOf(this.f51981a));
        com.transsion.baselib.helper.a.f51183a.e(getPageName(), map);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "home_filter_page";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        TitleLayout titleLayout = ((a) getMViewBinding()).f81575c;
        titleLayout.setRightView(R$mipmap.ic_search_movie, new View.OnClickListener() { // from class: ht.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterActivity.S(this.f66784a, view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: ht.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FilterActivity.T(this.f66785a, view);
            }
        });
        U();
        String string = getString(R$string.filter);
        Intrinsics.f(string, "getString(R.string.filter)");
        titleLayout.setTitleText(string);
        titleLayout.setPadding(0, d.c(), 0, 0);
        R();
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
    public h newLogViewConfig() {
        h hVar = new h(getPageName(), false, 2, null);
        hVar.k(true);
        return hVar;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public void retryLoadData() {
    }
}
