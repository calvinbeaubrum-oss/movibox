package com.transsion.subroom.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import androidx.lifecycle.v;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tencent.mmkv.MMKV;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.utils.o;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.subroom.R$string;
import com.transsion.usercenter.laboratory.LabPwdDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
/* JADX INFO: loaded from: classes8.dex */
@Route(path = "/main/page_not_available")
@Metadata
public final class NotAvailableActivity extends BaseActivity<tx.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f58020a = 10;

    public static final void R(Ref.IntRef clickCount, final NotAvailableActivity this$0, View view) {
        Intrinsics.g(clickCount, "$clickCount");
        Intrinsics.g(this$0, "this$0");
        int i11 = clickCount.element + 1;
        clickCount.element = i11;
        if (i11 == this$0.f58020a) {
            new LabPwdDialog().q0(new Function0<Unit>() { // from class: com.transsion.subroom.activity.NotAvailableActivity$initView$1$1
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
                    this.this$0.S();
                }
            }).j0(this$0, "labPwd");
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public tx.c getViewBinding() {
        tx.c cVarC = tx.c.c(getLayoutInflater());
        Intrinsics.f(cVarC, "inflate(layoutInflater)");
        return cVarC;
    }

    public final void S() {
        SharedPreferences.Editor editorPutString;
        MMKV mmkvC = ip.a.f67589a.c();
        if (mmkvC != null && (editorPutString = mmkvC.putString("sp_code", "90101")) != null) {
            editorPutString.commit();
        }
        com.tn.lib.widget.toast.core.h.f50034a.l("Please restart the App");
        kotlinx.coroutines.j.d(v.a(this), null, null, new NotAvailableActivity$welcomeMovieBox$1(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        String string = getResources().getString(R$string.not_available);
        Intrinsics.f(string, "resources.getString(R.string.not_available)");
        String string2 = getResources().getString(R$string.in_current_region);
        Intrinsics.f(string2, "resources.getString(R.string.in_current_region)");
        SpannableString spannableString = new SpannableString(string + string2);
        final Ref.IntRef intRef = new Ref.IntRef();
        spannableString.setSpan(new ForegroundColorSpan(z2.a.getColor(this, R$color.error_red)), 0, string.length(), 34);
        ((tx.c) getMViewBinding()).f78066b.setText(spannableString);
        ((tx.c) getMViewBinding()).f78066b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.subroom.activity.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NotAvailableActivity.R(intRef, this, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isChangeStatusBar() {
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
