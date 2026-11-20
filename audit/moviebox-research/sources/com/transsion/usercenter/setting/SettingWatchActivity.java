package com.transsion.usercenter.setting;

import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$drawable;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.dialog.TRDialog;
import com.tn.lib.widget.dialog.TRDialogListener;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.utils.PlayMode;
import com.transsion.baselib.utils.m;
import com.transsion.baseui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;
import xy.q0;

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
@Route(path = "/profile/watch_option")
@Metadata
public final class SettingWatchActivity extends BaseActivity<q0> implements TRDialogListener {
    private final boolean isStreamMode = m.f51320a.b();

    private final void editTipsDialog() {
        try {
            TRDialog.a aVar = new TRDialog.a();
            String string = getString(R$string.back_edit_tips);
            Intrinsics.f(string, "getString(com.tn.lib.wid….R.string.back_edit_tips)");
            TRDialog.a aVarG = aVar.g(string);
            String string2 = getString(com.transsion.usercenter.R$string.profile_back_edit_yes);
            Intrinsics.f(string2, "getString(R.string.profile_back_edit_yes)");
            TRDialog.a aVarE = aVarG.e(string2);
            String string3 = getString(com.transsion.usercenter.R$string.profile_back_edit_no);
            Intrinsics.f(string3, "getString(R.string.profile_back_edit_no)");
            aVarE.j(string3).d(z2.a.getColor(this, R$color.text_01)).i(z2.a.getColor(this, R$color.text_01)).h(R$drawable.libui_sub_btn2_normal).c(R$drawable.libui_sub_btn2_normal).f(this).a().l0(this, "edit_tips");
        } catch (Exception unused) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void restartApp() {
        m.f51320a.c(((q0) getMViewBinding()).f80927h.isSelected() ? PlayMode.STREAM : PlayMode.DOWNLOAD);
        RoomActivityLifecycleCallbacks.f51239a.d();
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.addFlags(ASTNode.DEOP);
        }
        startActivity(launchIntentForPackage);
        Process.killProcess(Process.myPid());
        System.exit(0);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void updateMode(boolean z11) {
        ((q0) getMViewBinding()).f80926g.setAlpha(z11 == this.isStreamMode ? 0.5f : 1.0f);
        ((q0) getMViewBinding()).f80926g.setEnabled(z11 != this.isStreamMode);
        ((q0) getMViewBinding()).f80927h.setSelected(z11);
        ((q0) getMViewBinding()).f80923c.setSelected(!z11);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    public q0 getViewBinding() {
        q0 q0VarC = q0.c(getLayoutInflater());
        Intrinsics.f(q0VarC, "inflate(layoutInflater)");
        return q0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        TitleLayout titleLayout = ((q0) getMViewBinding()).f80930k;
        Intrinsics.f(titleLayout, "mViewBinding.titleLayout");
        so.c.e(titleLayout);
        ((q0) getMViewBinding()).f80930k.setTitleText(com.transsion.baseui.R$string.watch_options);
        AppCompatTextView appCompatTextView = ((q0) getMViewBinding()).f80929j;
        Intrinsics.f(appCompatTextView, "mViewBinding.streamTv");
        so.c.c(appCompatTextView, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.setting.SettingWatchActivity.initView.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                SettingWatchActivity.this.updateMode(true);
            }
        }, 1, null);
        AppCompatTextView appCompatTextView2 = ((q0) getMViewBinding()).f80925f;
        Intrinsics.f(appCompatTextView2, "mViewBinding.downloadTv");
        so.c.c(appCompatTextView2, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.setting.SettingWatchActivity.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                SettingWatchActivity.this.updateMode(false);
            }
        }, 1, null);
        AppCompatTextView appCompatTextView3 = ((q0) getMViewBinding()).f80926g;
        Intrinsics.f(appCompatTextView3, "mViewBinding.restartTV");
        so.c.c(appCompatTextView3, 0L, new Function1<View, Unit>() { // from class: com.transsion.usercenter.setting.SettingWatchActivity.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                SettingWatchActivity.this.restartApp();
            }
        }, 1, null);
        updateMode(this.isStreamMode);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (((q0) getMViewBinding()).f80927h.isSelected() == this.isStreamMode) {
            super.onBackPressed();
        } else {
            editTipsDialog();
        }
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onLeftButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
        finish();
    }

    @Override // com.tn.lib.widget.dialog.TRDialogListener
    public void onRightButtonClick(TRDialog dialog) {
        Intrinsics.g(dialog, "dialog");
    }
}
