package com.transsion.baseui.widget;

import android.content.Context;
import android.text.TextPaint;
import com.tn.lib.widget.R$color;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import z2.a;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CustomPagerTitleView extends ColorTransitionPagerTitleView {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f51485d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CustomPagerTitleView(Context context) {
        this(context, 17, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomPagerTitleView(Context context, int i11, int i12) {
        super(context);
        Intrinsics.g(context, "context");
        this.f51485d = 16.0f;
        setNormalColor(a.getColor(context, R$color.text_02));
        setSelectedColor(a.getColor(context, R$color.text_01));
        setGravity(i11);
        getPaint().setTypeface(so.a.a(context));
        this.f51484c = i12;
        setPadding(i12, 0, i12, 0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onDeselected(int i11, int i12) {
        super.onDeselected(i11, i12);
        TextPaint paint = getPaint();
        Context context = getContext();
        Intrinsics.f(context, "context");
        paint.setTypeface(so.a.d(context));
        setTextSize(2, 14.0f);
        int i13 = this.f51484c;
        setPadding(i13, 0, i13, 0);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView, net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onSelected(int i11, int i12) {
        super.onSelected(i11, i12);
        TextPaint paint = getPaint();
        Context context = getContext();
        Intrinsics.f(context, "context");
        paint.setTypeface(so.a.a(context));
        setTextSize(2, this.f51485d);
        int i13 = this.f51484c;
        setPadding(i13 - 2, 0, i13 - 2, 0);
    }

    public final void setSelectTextSize(float f11) {
        this.f51485d = f11;
    }
}
