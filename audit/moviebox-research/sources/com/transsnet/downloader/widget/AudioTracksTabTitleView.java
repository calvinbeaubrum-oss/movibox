package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Typeface;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import com.transsnet.downloader.R$drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

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
@Metadata
public final class AudioTracksTabTitleView extends SimplePagerTitleView implements bs.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f61291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f61292d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bs.c f61293f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AudioTracksTabTitleView(Context context, String title, String subTitle) {
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(title, "title");
        Intrinsics.g(subTitle, "subTitle");
        this.f61291c = title;
        this.f61292d = subTitle;
        int iA = f0.a(8.0f);
        setSelectedColor(z2.a.getColor(context, R$color.main));
        setNormalColor(z2.a.getColor(context, R$color.text_02));
        setTextSize(16.0f);
        setGravity(17);
        setTypeface(so.a.c(context));
        setPadding(iA, 0, iA, 0);
        this.f61293f = new bs.c(this);
    }

    @Override // bs.a
    public void changeLocal() {
        this.f61293f.changeLocal();
    }

    public final up.c getContent(boolean z11) {
        if (this.f61292d.length() == 0) {
            up.c cVarB = up.c.e().e(this.f61291c).c(z11 ? getSelectedColor() : getNormalColor()).b();
            Intrinsics.f(cVarB, "builder()\n              …else normalColor).build()");
            return cVarB;
        }
        up.c.a aVarE = up.c.e().e(this.f61291c);
        Context context = getContext();
        Intrinsics.f(context, "context");
        up.c cVarB2 = aVarE.f(so.a.c(context)).c(z11 ? getSelectedColor() : getNormalColor()).e(" " + this.f61292d).d(14).f(Typeface.create(Typeface.DEFAULT, 0)).c(z11 ? getSelectedColor() : z2.a.getColor(Utils.a(), R$color.text_03)).b();
        Intrinsics.f(cVarB2, "builder()\n            .t…R.color.text_03)).build()");
        return cVarB2;
    }

    public final String getSubTitle() {
        return this.f61292d;
    }

    public final String getTitle() {
        return this.f61291c;
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onDeselected(int i11, int i12) {
        super.onDeselected(i11, i12);
        setText(getContent(false));
        setBackgroundColor(0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onSelected(int i11, int i12) {
        super.onSelected(i11, i12);
        setText(getContent(true));
        setBackgroundResource(R$drawable.bg_res_ep_tab);
    }

    public void setHintById(int i11) {
        this.f61293f.b(i11);
    }

    public void setHintWithString(CharSequence charSequence) {
        this.f61293f.c(charSequence);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        bs.a.C0147a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> function0) {
        this.f61293f.e(function0);
    }

    public void setTextById(int i11) {
        this.f61293f.f(i11);
    }

    public void setTextWithString(CharSequence charSequence) {
        this.f61293f.g(charSequence);
    }
}
