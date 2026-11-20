package com.transsion.edcation.list;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.R$drawable;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.edcation.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
@Route(path = "/edu/courseList")
@Metadata
public final class MyCourseListActivity extends BaseActivity<yp.a> {
    public static final void S(View view) {
        com.alibaba.android.arouter.launcher.a.d().b("/edu/history").navigation();
    }

    public static final void T(MyCourseListActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.finish();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public yp.a getViewBinding() {
        yp.a aVarC = yp.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    public final void R() {
        getSupportFragmentManager().beginTransaction().replace(R$id.container, new MyCourseListFragment()).commitNow();
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "MyCourse List";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        TitleLayout titleLayout = ((yp.a) getMViewBinding()).f81575c;
        titleLayout.setRightView(R$drawable.ic_history, new View.OnClickListener() { // from class: com.transsion.edcation.list.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyCourseListActivity.S(view);
            }
        });
        titleLayout.setLeftOnclick(new View.OnClickListener() { // from class: com.transsion.edcation.list.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyCourseListActivity.T(this.f51895a, view);
            }
        });
        titleLayout.setTitleText(R$string.course_list);
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

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        com.alibaba.android.arouter.launcher.a.d().f(this);
        super.onCreate(bundle);
    }
}
