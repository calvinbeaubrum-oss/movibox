package com.transsion.postdetail.shorttv.widget;

import android.content.Context;
import android.text.TextPaint;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShortTVTabTitleView extends SimplePagerTitleView implements bs.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f55497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bs.c f55498d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVTabTitleView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f55497c = f0.a(12.0f);
        setNormalColor(z2.a.getColor(context, R$color.text_02));
        setSelectedColor(z2.a.getColor(context, R$color.text_01));
        setTextSize(16.0f);
        setGravity(17);
        int i11 = this.f55497c;
        setPadding(i11, 0, i11, 0);
        this.f55498d = new bs.c(this);
    }

    @Override // bs.a
    public void changeLocal() {
        this.f55498d.changeLocal();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onDeselected(int i11, int i12) {
        super.onDeselected(i11, i12);
        getPaint().setFakeBoldText(true);
        TextPaint paint = getPaint();
        Context context = getContext();
        Intrinsics.f(context, "context");
        paint.setTypeface(so.a.d(context));
        int i13 = this.f55497c;
        setPadding(i13, 0, i13, 0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onSelected(int i11, int i12) {
        super.onSelected(i11, i12);
        getPaint().setFakeBoldText(true);
        TextPaint paint = getPaint();
        Context context = getContext();
        Intrinsics.f(context, "context");
        paint.setTypeface(so.a.a(context));
        int i13 = this.f55497c;
        setPadding(i13 - 1, 0, i13 - 1, 0);
    }

    public void setHintById(int i11) {
        this.f55498d.b(i11);
    }

    public void setHintWithString(CharSequence charSequence) {
        this.f55498d.c(charSequence);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        bs.a.C0147a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> function0) {
        this.f55498d.e(function0);
    }

    public void setTextById(int i11) {
        this.f55498d.f(i11);
    }

    public void setTextWithString(CharSequence charSequence) {
        this.f55498d.g(charSequence);
    }
}
