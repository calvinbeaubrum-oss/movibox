package com.transsion.room.view;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import bs.a;
import bs.c;
import com.blankj.utilcode.util.f0;
import com.tn.lib.widget.R$color;
import h20.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class RoomListMainTabTitleView extends AppCompatTextView implements d, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f57303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f57304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f57305c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomListMainTabTitleView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f57304b = z2.a.getColor(context, R$color.text_02);
        this.f57303a = z2.a.getColor(context, R$color.text_01);
        setTextSize(14.0f);
        setGravity(17);
        setMinWidth(f0.a(120.0f));
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        this.f57305c = new c(this);
    }

    @Override // bs.a
    public void changeLocal() {
        this.f57305c.changeLocal();
    }

    public final int getNormalColor() {
        return this.f57304b;
    }

    public final int getSelectedColor() {
        return this.f57303a;
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
        setTextColor(this.f57304b);
        Context context = getContext();
        Intrinsics.f(context, "context");
        setTypeface(so.a.d(context));
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
        setTextColor(this.f57303a);
        Context context = getContext();
        Intrinsics.f(context, "context");
        setTypeface(so.a.c(context));
    }

    public void setHintById(int i11) {
        this.f57305c.b(i11);
    }

    public void setHintWithString(CharSequence charSequence) {
        this.f57305c.c(charSequence);
    }

    public void setLocalChangeListener(Function0<Unit> function0) {
        a.C0147a.a(this, function0);
    }

    public final void setNormalColor(int i11) {
        this.f57304b = i11;
    }

    public final void setSelectedColor(int i11) {
        this.f57303a = i11;
    }

    public void setTextAction(Function0<? extends CharSequence> function0) {
        this.f57305c.e(function0);
    }

    public void setTextById(int i11) {
        this.f57305c.f(i11);
    }

    public void setTextWithString(CharSequence charSequence) {
        this.f57305c.g(charSequence);
    }
}
