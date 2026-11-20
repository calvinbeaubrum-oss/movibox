package com.transsion.transfer.impl.view;

import android.content.Context;
import bs.a;
import bs.c;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class TabTitleView extends SimplePagerTitleView implements a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f59115c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabTitleView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        setNormalColor(z2.a.getColor(context, R$color.text_02));
        setSelectedColor(z2.a.getColor(context, R$color.text_01));
        setTextSize(16.0f);
        setGravity(17);
        this.f59115c = new c(this);
    }

    @Override // bs.a
    public void changeLocal() {
        this.f59115c.changeLocal();
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onDeselected(int i11, int i12) {
        super.onDeselected(i11, i12);
        getPaint().setFakeBoldText(false);
    }

    @Override // net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView, h20.d
    public void onSelected(int i11, int i12) {
        super.onSelected(i11, i12);
        getPaint().setFakeBoldText(true);
    }

    public void setHintById(int i11) {
        this.f59115c.b(i11);
    }

    public void setHintWithString(CharSequence charSequence) {
        this.f59115c.c(charSequence);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        a.C0147a.a(this, function0);
    }

    public void setTextAction(Function0<? extends CharSequence> function0) {
        this.f59115c.e(function0);
    }

    public void setTextById(int i11) {
        this.f59115c.f(i11);
    }

    public void setTextWithString(CharSequence charSequence) {
        this.f59115c.g(charSequence);
    }
}
