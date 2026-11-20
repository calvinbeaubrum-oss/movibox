package com.transsion.baseui.util;

import android.app.Application;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.web.api.WebPageIdentity;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f51468a = Pattern.compile("(?i:http|https|rtsp|ftp)://");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<View, String, Unit> f51469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f51471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f51472d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super View, ? super String, Unit> function2, String str, boolean z11, int i11) {
            this.f51469a = function2;
            this.f51470b = str;
            this.f51471c = z11;
            this.f51472d = i11;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            Function2<View, String, Unit> function2 = this.f51469a;
            if (function2 != null) {
                String str = this.f51470b;
                if (str == null) {
                    str = "";
                }
                function2.invoke(widget, str);
            }
            if (this.f51471c) {
                String originClickUrl = this.f51470b;
                Intrinsics.f(originClickUrl, "originClickUrl");
                k.d(originClickUrl);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(this.f51472d);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<View, String, Unit> f51473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f51474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f51475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f51476d;

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function2<? super View, ? super String, Unit> function2, String str, boolean z11, int i11) {
            this.f51473a = function2;
            this.f51474b = str;
            this.f51475c = z11;
            this.f51476d = i11;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            Intrinsics.g(widget, "widget");
            Function2<View, String, Unit> function2 = this.f51473a;
            if (function2 != null) {
                String str = this.f51474b;
                if (str == null) {
                    str = "";
                }
                function2.invoke(widget, str);
            }
            if (this.f51475c) {
                String originClickUrl = this.f51474b;
                Intrinsics.f(originClickUrl, "originClickUrl");
                k.d(originClickUrl);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds2) {
            Intrinsics.g(ds2, "ds");
            super.updateDrawState(ds2);
            ds2.setColor(this.f51476d);
        }
    }

    public static final SpannableString b(TextView textView, CharSequence charSequence, boolean z11, g gVar, Function2<? super View, ? super String, Unit> function2) {
        int iD0;
        Matcher matcher;
        int i11;
        Object obj = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableString("");
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher2 = Patterns.WEB_URL.matcher(charSequence);
        int color = z2.a.getColor(Utils.a(), R$color.color_0ba7ff);
        CharSequence charSequenceH = charSequence;
        while (matcher2.find()) {
            String originUrl = matcher2.group();
            Intrinsics.f(originUrl, "url");
            if (kotlin.text.l.u(originUrl, ")", false, 2, obj)) {
                Intrinsics.f(originUrl, "url");
                originUrl = kotlin.text.l.F(originUrl, ")", "", false, 4, null);
            }
            if (charSequenceH != null) {
                Intrinsics.f(originUrl, "url");
                iD0 = StringsKt__StringsKt.d0(charSequenceH, originUrl, 0, false, 6, null);
            } else {
                iD0 = 0;
            }
            Intrinsics.f(originUrl, r12);
            String strF = kotlin.text.l.F(originUrl, "%20", " ", false, 4, null);
            Matcher matcher3 = f51468a.matcher(strF);
            if (matcher3.find()) {
                Intrinsics.f(strF, r12);
                String strGroup = matcher3.group();
                Intrinsics.f(strGroup, "protocolMatcher.group()");
                String url = kotlin.text.l.F(strF, strGroup, "", false, 4, null);
                Matcher matcher4 = Patterns.DOMAIN_NAME.matcher(url);
                if (matcher4.find()) {
                    String domain = matcher4.group();
                    Intrinsics.f(domain, "domain");
                    matcher = matcher2;
                    i11 = 2;
                    if (StringsKt__StringsKt.Q(domain, InstructionFileId.DOT, false, 2, null)) {
                        List listE0 = StringsKt__StringsKt.E0(domain, new String[]{InstructionFileId.DOT}, false, 0, 6, null);
                        if (listE0.size() > 2) {
                            Intrinsics.f(url, "url");
                            url = kotlin.text.l.F(url, listE0.get(0) + InstructionFileId.DOT, "", false, 4, null);
                        }
                    }
                } else {
                    matcher = matcher2;
                    i11 = 2;
                }
                if (url.length() > 24) {
                    Intrinsics.f(url, r12);
                    url = StringsKt__StringsKt.y0(url, 24, url.length(), "...").toString();
                }
                String str = "-" + url;
                String strValueOf = String.valueOf(charSequenceH);
                Intrinsics.f(originUrl, "originUrl");
                Intrinsics.f(str, r12);
                charSequenceH = kotlin.text.l.H(strValueOf, originUrl, str, false, 4, null);
                Drawable drawable = z2.a.getDrawable(Utils.a(), R$mipmap.base_ic_url_link);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                is.a aVar = drawable != null ? new is.a(drawable, i11) : null;
                a aVar2 = new a(function2, strF, z11, color);
                Intrinsics.f(str, r12);
                arrayList.add(new UrlContent(aVar2, aVar, originUrl, str, iD0));
                matcher2 = matcher;
            }
            obj = null;
        }
        if (arrayList.isEmpty()) {
            return new SpannableString(charSequence);
        }
        SpannableString spannableString = new SpannableString(charSequenceH);
        for (UrlContent urlContent : arrayList) {
            spannableString.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
            spannableString.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new js.a(spannableString));
        }
        if (textView != null) {
            textView.setHighlightColor(z2.a.getColor(Utils.a(), R$color.cl17));
        }
        return spannableString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.CharSequence, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [android.text.style.ImageSpan] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r7v18, types: [java.lang.CharSequence] */
    public static final SpannableStringBuilder c(TextView textView, CharSequence charSequence, boolean z11, g gVar, Function2<? super View, ? super String, Unit> function2) {
        SpannableStringBuilder spannableStringBuilder;
        int iD0;
        Matcher matcher;
        int i11;
        TextPaint textPaint;
        TextPaint textPaint2 = null;
        if (textView != null) {
            textView.setOnTouchListener(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            return new SpannableStringBuilder("");
        }
        ArrayList<UrlContent> arrayList = new ArrayList();
        Matcher matcher2 = Patterns.WEB_URL.matcher(charSequence);
        int color = z2.a.getColor(Utils.a(), R$color.color_0ba7ff);
        ?? string = charSequence;
        while (matcher2.find()) {
            String url = matcher2.group();
            Intrinsics.f(url, "url");
            if (kotlin.text.l.u(url, ")", false, 2, textPaint2)) {
                Intrinsics.f(url, "url");
                url = kotlin.text.l.F(url, ")", "", false, 4, null);
            }
            String originUrl = url;
            if (string != 0) {
                Intrinsics.f(originUrl, "url");
                iD0 = StringsKt__StringsKt.d0(string, originUrl, 0, false, 6, null);
            } else {
                iD0 = 0;
            }
            Intrinsics.f(originUrl, r12);
            String strF = kotlin.text.l.F(originUrl, "%20", " ", false, 4, null);
            Matcher matcher3 = f51468a.matcher(strF);
            if (matcher3.find()) {
                Intrinsics.f(strF, r12);
                String strGroup = matcher3.group();
                Intrinsics.f(strGroup, "protocolMatcher.group()");
                String url2 = kotlin.text.l.F(strF, strGroup, "", false, 4, null);
                Matcher matcher4 = Patterns.DOMAIN_NAME.matcher(url2);
                if (matcher4.find()) {
                    String domain = matcher4.group();
                    Intrinsics.f(domain, "domain");
                    matcher = matcher2;
                    i11 = 2;
                    textPaint = null;
                    if (StringsKt__StringsKt.Q(domain, InstructionFileId.DOT, false, 2, null)) {
                        List listE0 = StringsKt__StringsKt.E0(domain, new String[]{InstructionFileId.DOT}, false, 0, 6, null);
                        if (listE0.size() > 2) {
                            Intrinsics.f(url2, "url");
                            url2 = kotlin.text.l.F(url2, listE0.get(0) + InstructionFileId.DOT, "", false, 4, null);
                        }
                    }
                } else {
                    matcher = matcher2;
                    i11 = 2;
                    textPaint = null;
                }
                if (url2.length() > 24) {
                    Intrinsics.f(url2, r12);
                    url2 = StringsKt__StringsKt.y0(url2, 24, url2.length(), "...").toString();
                }
                String str = "-" + url2;
                String strValueOf = String.valueOf((Object) string);
                Intrinsics.f(originUrl, "originUrl");
                Intrinsics.f(str, r12);
                string = kotlin.text.l.H(strValueOf, originUrl, str, false, 4, null);
                Drawable drawable = z2.a.getDrawable(Utils.a(), R$mipmap.base_ic_url_link);
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                }
                ?? aVar = drawable != null ? new is.a(drawable, i11) : textPaint;
                b bVar = new b(function2, strF, z11, color);
                Intrinsics.f(str, r12);
                arrayList.add(new UrlContent(bVar, aVar, originUrl, str, iD0));
                textPaint2 = textPaint;
                matcher2 = matcher;
            } else {
                textPaint2 = null;
            }
        }
        TextPaint textPaint3 = textPaint2;
        StaticLayout staticLayout = new StaticLayout(charSequence, textView != null ? textView.getPaint() : textPaint3, textView != null ? textView.getWidth() : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        if (10 < staticLayout.getLineCount()) {
            int lineEnd = staticLayout.getLineEnd(9) - 13;
            if (string != 0 && string.length() > 30 && lineEnd > 0) {
                if (lineEnd < (string != 0 ? string.length() : 0)) {
                    string = string != 0 ? string.subSequence(0, lineEnd).toString() : textPaint3;
                }
            }
            spannableStringBuilder = new SpannableStringBuilder(string);
            for (UrlContent urlContent : arrayList) {
                if (urlContent.getIndexOfUrl() + urlContent.getUrl().length() < spannableStringBuilder.length()) {
                    spannableStringBuilder.setSpan(urlContent.getIconSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + 1, 33);
                    spannableStringBuilder.setSpan(urlContent.getClickableSpan(), urlContent.getIndexOfUrl(), urlContent.getIndexOfUrl() + urlContent.getUrl().length(), 33);
                }
            }
            spannableStringBuilder.append((CharSequence) "...");
            spannableStringBuilder.append((CharSequence) " More");
            int length = spannableStringBuilder.length() - 5;
            int length2 = spannableStringBuilder.length();
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            spannableStringBuilder.setSpan(new up.a(so.a.c(applicationA)), length, length2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.brand_new_50)), length, length2, 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(string);
            for (UrlContent urlContent2 : arrayList) {
                spannableStringBuilder.setSpan(urlContent2.getIconSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + 1, 33);
                spannableStringBuilder.setSpan(urlContent2.getClickableSpan(), urlContent2.getIndexOfUrl(), urlContent2.getIndexOfUrl() + urlContent2.getUrl().length(), 33);
            }
        }
        if (gVar != null) {
            gVar.a(arrayList);
        }
        if (textView != null) {
            textView.setOnTouchListener(new js.a(spannableStringBuilder));
        }
        if (textView != null) {
            textView.setHighlightColor(z2.a.getColor(Utils.a(), R$color.cl17));
        }
        return spannableStringBuilder;
    }

    public static final void d(String str) {
        com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", str).navigation();
    }

    public static final void e(TextView textView, CharSequence charSequence, Function2<? super View, ? super String, Unit> function2) {
        Intrinsics.g(textView, "<this>");
        textView.setText(b(textView, charSequence, true, null, function2));
    }

    public static final void f(TextView textView, CharSequence charSequence, boolean z11, Function2<? super View, ? super String, Unit> function2) {
        Intrinsics.g(textView, "<this>");
        textView.setText(b(textView, charSequence, z11, null, function2));
    }

    public static final void g(TextView textView, CharSequence charSequence, Function2<? super View, ? super String, Unit> function2) {
        Intrinsics.g(textView, "<this>");
        textView.setText(c(textView, charSequence, true, null, function2));
    }
}
