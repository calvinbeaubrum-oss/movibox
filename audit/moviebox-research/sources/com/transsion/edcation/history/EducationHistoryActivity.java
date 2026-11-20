package com.transsion.edcation.history;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.d;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$id;
import com.transsion.baselib.utils.o;
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
@Route(path = "/edu/history")
@Metadata
public final class EducationHistoryActivity extends BaseActivity<yp.a> {
    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public yp.a getViewBinding() {
        yp.a aVarC = yp.a.c(getLayoutInflater());
        Intrinsics.f(aVarC, "inflate(layoutInflater)");
        return aVarC;
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public String getPageName() {
        return "Education History";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        TitleLayout titleLayout = ((yp.a) getMViewBinding()).f81575c;
        String string = getString(R$string.course_history_title);
        Intrinsics.f(string, "getString(R.string.course_history_title)");
        titleLayout.setTitleText(string);
        titleLayout.setPadding(0, d.c(), 0, 0);
        getSupportFragmentManager().beginTransaction().replace(R$id.container, new EducationHistoryFragment()).commitNow();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return !o.f51321a.a();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
