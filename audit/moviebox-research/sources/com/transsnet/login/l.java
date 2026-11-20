package com.transsnet.login;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.web.api.WebPageIdentity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

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
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f61543a = new l();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f61544a;

        public a(Context context) {
            this.f61544a = context;
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
            ds2.setColor(z2.a.getColor(this.f61544a, R$color.login_color_policy_link));
            ds2.setUnderlineText(true);
            ds2.clearShadowLayer();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f61545a;

        public b(Context context) {
            this.f61545a = context;
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
            ds2.setColor(z2.a.getColor(this.f61545a, R$color.login_color_policy_link));
            ds2.setUnderlineText(true);
            ds2.clearShadowLayer();
        }
    }

    public final void a(Context context, AppCompatTextView tvPrivacy) {
        Intrinsics.g(context, "context");
        Intrinsics.g(tvPrivacy, "tvPrivacy");
        String string = context.getString(R$string.login_sign_up_privacy);
        Intrinsics.f(string, "context.getString(R.string.login_sign_up_privacy)");
        String string2 = context.getString(R$string.login_privacy);
        Intrinsics.f(string2, "context.getString(R.string.login_privacy)");
        String string3 = context.getString(R$string.login_user_agreement);
        Intrinsics.f(string3, "context.getString(R.string.login_user_agreement)");
        SpannableString spannableString = new SpannableString(string);
        a aVar = new a(context);
        b bVar = new b(context);
        int iZ = StringsKt__StringsKt.Z(string, string2, 0, true);
        int iZ2 = StringsKt__StringsKt.Z(string, string3, 0, true);
        if (iZ < 0) {
            iZ = 0;
        }
        int i11 = iZ2 >= 0 ? iZ2 : 0;
        spannableString.setSpan(aVar, iZ, string2.length() + iZ, 33);
        spannableString.setSpan(bVar, i11, string3.length() + i11, 33);
        tvPrivacy.setText(spannableString);
        tvPrivacy.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
