package com.transsion.usercenter.setting;

import android.os.Bundle;
import android.view.View;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.push.notification.ToolbarNotificationUtils;
import com.transsion.usercenter.R$string;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xy.p0;

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
@Route(path = "/profile/setting_notice")
@Metadata
public final class SettingNoticeActivity extends BaseActivity<p0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f59658a = true;

    /* JADX WARN: Multi-variable type inference failed */
    public static final void R(SettingNoticeActivity this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        if (this$0.f59658a) {
            ToolbarNotificationUtils.f56927a.z();
            RoomAppMMKV.f51271a.a().putBoolean("k_is_show_ongoing_tool_notice", false);
        } else {
            RoomAppMMKV.f51271a.a().putBoolean("k_is_show_ongoing_tool_notice", true);
            ToolbarNotificationUtils.f56927a.G();
        }
        this$0.f59658a = !this$0.f59658a;
        ((p0) this$0.getMViewBinding()).f80913b.setChecked(this$0.f59658a);
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public p0 getViewBinding() {
        p0 p0VarC = p0.c(getLayoutInflater());
        Intrinsics.f(p0VarC, "inflate(layoutInflater)");
        return p0VarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Q() {
        this.f59658a = RoomAppMMKV.f51271a.a().getBoolean("k_is_show_ongoing_tool_notice", true);
        ((p0) getMViewBinding()).f80913b.setChecked(this.f59658a);
        ((p0) getMViewBinding()).f80913b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingNoticeActivity.R(this.f59672a, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity
    public void initView(Bundle bundle) {
        super.initView(bundle);
        TitleLayout titleLayout = ((p0) getMViewBinding()).f80914c;
        Intrinsics.f(titleLayout, "mViewBinding.toolBar");
        so.c.e(titleLayout);
        ((p0) getMViewBinding()).f80914c.setTitleText(R$string.user_setting);
        Q();
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return false;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }
}
