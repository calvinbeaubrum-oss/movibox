package com.transsion.usercenter;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.toast.core.h;
import com.transsion.baseui.activity.BaseActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import so.c;
import xy.g;

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
public final class ProfileSettingAboutUsActivity extends BaseActivity<g> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ClickableSpan {
        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            h.f50034a.a("H5 Privacy Policy");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(z2.a.getColor(Utils.a(), com.transsion.baseui.R$color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ClickableSpan {
        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            h.f50034a.a(" H5 User Agreement");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(z2.a.getColor(Utils.a(), com.transsion.baseui.R$color.base_color_395CFF));
            ds2.setUnderlineText(false);
        }
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public g getViewBinding() {
        g gVarC = g.c(getLayoutInflater());
        Intrinsics.f(gVarC, "inflate(layoutInflater)");
        return gVarC;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void O() {
        String string = ((g) getMViewBinding()).f80807d.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        int iD0 = StringsKt__StringsKt.d0(string, "Privacy Policy", 0, false, 6, null);
        spannableStringBuilder.setSpan(new a(), iD0, iD0 + 14, 0);
        int iJ0 = StringsKt__StringsKt.j0(string, "User Agreement", 0, false, 6, null);
        spannableStringBuilder.setSpan(new b(), iJ0, iJ0 + 14, 0);
        ((g) getMViewBinding()).f80807d.setMovementMethod(LinkMovementMethod.getInstance());
        ((g) getMViewBinding()).f80807d.setHighlightColor(0);
        ((g) getMViewBinding()).f80807d.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    @Override // com.transsion.baseui.activity.BaseActivity
    public boolean isTranslucent() {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.activity.BaseActivity, com.transsion.baseui.activity.BaseCommonActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ConstraintLayout root = ((g) getMViewBinding()).getRoot();
        Intrinsics.f(root, "mViewBinding.root");
        c.e(root);
        ((g) getMViewBinding()).f80806c.goneRightViewLayout();
        O();
        ((g) getMViewBinding()).f80809g.setText("V 1.0  todo 这里通过工具类获取");
        ((g) getMViewBinding()).f80808f.setText("Oneroom   todo 这里通过工具类获取");
    }
}
