package com.transsion.usercenter.setting;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.widget.R$color;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.R$string;
import com.transsion.usercenter.laboratory.LabPwdDialog;
import com.transsion.usercenter.laboratory.LaboratoryActivity;
import com.transsion.web.api.WebPageIdentity;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import xy.m0;

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
@Metadata
public final class SettingAboutUsActivity extends BaseActivity<m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59631a = 6;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59632b = 500;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f59633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f59634d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", "https://h5-static.aoneroom.com/spa/html/moviebox-privacy-policy.html").navigation();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(z2.a.getColor(SettingAboutUsActivity.this, R$color.main));
            ds2.setUnderlineText(false);
            ds2.clearShadowLayer();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", "https://h5-static.aoneroom.com/spa/html/moviebox-terms-of-use.html").navigation();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(z2.a.getColor(SettingAboutUsActivity.this, R$color.main));
            ds2.setUnderlineText(false);
            ds2.clearShadowLayer();
        }
    }

    public static final void Q(final SettingAboutUsActivity this$0, boolean z11, View view) {
        Intrinsics.g(this$0, "this$0");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this$0.f59633c < this$0.f59632b) {
            this$0.f59634d++;
        } else {
            this$0.f59634d = 0;
        }
        this$0.f59633c = jCurrentTimeMillis;
        if (this$0.f59634d == this$0.f59631a) {
            if (z11) {
                this$0.startActivity(new Intent(this$0, (Class<?>) LaboratoryActivity.class));
            } else {
                new LabPwdDialog().q0(new Function0<Unit>() { // from class: com.transsion.usercenter.setting.SettingAboutUsActivity$initView$2$1
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
                        this.this$0.startActivity(new Intent(this.this$0, (Class<?>) LaboratoryActivity.class));
                    }
                }).j0(this$0, "labPwd");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        TitleLayout titleLayout = ((m0) getMViewBinding()).f80866c;
        String string = getString(R$string.user_setting_About_us);
        Intrinsics.f(string, "getString(R.string.user_setting_About_us)");
        titleLayout.setTitleText(string);
        String string2 = getString(R$string.login_sign_up_privacy);
        Intrinsics.f(string2, "getString(R.string.login_sign_up_privacy)");
        String string3 = getString(R$string.login_privacy);
        Intrinsics.f(string3, "getString(R.string.login_privacy)");
        String string4 = getString(R$string.login_user_agreement);
        Intrinsics.f(string4, "getString(R.string.login_user_agreement)");
        SpannableString spannableString = new SpannableString(string2);
        a aVar = new a();
        b bVar = new b();
        int iD0 = StringsKt__StringsKt.d0(string2, string3, 0, false, 6, null);
        int i11 = iD0 != -1 ? iD0 : 0;
        int iD1 = StringsKt__StringsKt.d0(string2, string4, 0, false, 6, null);
        if (iD1 == -1) {
            iD1 = 0;
        }
        spannableString.setSpan(aVar, i11, string3.length() + i11, 33);
        spannableString.setSpan(bVar, iD1, string4.length() + iD1, 33);
        AppCompatTextView appCompatTextView = ((m0) getMViewBinding()).f80867d;
        appCompatTextView.setText(spannableString);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((m0) getMViewBinding()).f80868f.setText(com.blankj.utilcode.util.c.f());
        final boolean z11 = System.currentTimeMillis() - RoomAppMMKV.f51271a.a().getLong("lab_enter_password_time", 0L) < TimeUnit.DAYS.toMillis(1L);
        ((m0) getMViewBinding()).f80868f.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.usercenter.setting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SettingAboutUsActivity.Q(this.f59668a, z11, view);
            }
        });
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public m0 getViewBinding() {
        m0 m0VarC = m0.c(getLayoutInflater());
        Intrinsics.f(m0VarC, "inflate(layoutInflater)");
        return m0VarC;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isStatusDark() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f59634d = 0;
    }
}
