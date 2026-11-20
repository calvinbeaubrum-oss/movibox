package com.transsion.usercenter.message.detail;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.URLSpan;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.a;
import com.tn.lib.view.TitleLayout;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.usercenter.message.b;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import tp.d;
import xy.k0;

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
@Route(path = "/profile/message_detail")
@Metadata
@SourceDebugExtension
public final class MessageDetailActivity extends BaseActivity<k0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Autowired(name = "msg_content")
    @JvmField
    public String f59481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Autowired(name = "msg_create_time")
    @JvmField
    public String f59482b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Autowired(name = "msg_nickname")
    @JvmField
    public String f59483c;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void initView() {
        TitleLayout titleLayout = ((k0) getMViewBinding()).f80843c;
        String str = this.f59483c;
        if (str == null) {
            str = "";
        }
        titleLayout.setTitleText(str);
        AppCompatTextView appCompatTextView = ((k0) getMViewBinding()).f80845f;
        b.a aVar = b.f59473a;
        String str2 = this.f59482b;
        if (str2 == null) {
            str2 = "0";
        }
        appCompatTextView.setText(aVar.a(this, str2));
        AppCompatTextView appCompatTextView2 = ((k0) getMViewBinding()).f80844d;
        String str3 = this.f59481a;
        if (str3 == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str3, 0) : Html.fromHtml(str3));
        Object[] spans = spannableString.getSpans(0, spannableString.length(), URLSpan.class);
        Intrinsics.f(spans, "spanString.getSpans(0, s…gth, URLSpan::class.java)");
        for (Object obj : spans) {
            URLSpan uRLSpan = (URLSpan) obj;
            int spanStart = spannableString.getSpanStart(uRLSpan);
            int spanEnd = spannableString.getSpanEnd(uRLSpan);
            spannableString.removeSpan(uRLSpan);
            if (spanStart != -1 && spanEnd != -1) {
                String url = uRLSpan.getURL();
                Intrinsics.f(url, "it.url");
                spannableString.setSpan(new CustomURLSpan(url), spanStart, spanEnd, 33);
            }
        }
        appCompatTextView2.setText(spannableString);
        appCompatTextView2.setMovementMethod(new d(null));
    }

    @Override // com.transsion.baseui.activity.BaseCommonActivity
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public k0 getViewBinding() {
        k0 k0VarC = k0.c(getLayoutInflater());
        Intrinsics.f(k0VarC, "inflate(layoutInflater)");
        return k0VarC;
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
        a.d().f(this);
        super.onCreate(bundle);
        initView();
    }
}
