package com.transsion.ad.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.transsion.ad.middle.WrapperAdListener;
import com.transsion.ad.strategy.MeasureManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class AbsBuyOutNativeView extends FrameLayout implements MeasureManager.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f50657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AtomicBoolean f50658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f50659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WrapperAdListener f50660d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AbsBuyOutNativeView(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AbsBuyOutNativeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        this.f50658b = new AtomicBoolean(false);
    }

    public /* synthetic */ AbsBuyOutNativeView(Context context, AttributeSet attributeSet, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public abstract void adShowTime();

    public abstract void display();

    public final String getClassTag() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final WrapperAdListener getMCallback() {
        return this.f50660d;
    }

    public final String getSceneId() {
        String str = this.f50659c;
        return str == null ? "" : str;
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        return this;
    }

    public final WrapperAdListener getWrapperAdListener() {
        return this.f50660d;
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        if (!z11) {
            adShowTime();
            return;
        }
        if (this.f50657a == 0) {
            this.f50657a = System.currentTimeMillis();
        }
        if (this.f50658b.get()) {
            return;
        }
        this.f50658b.set(true);
        display();
    }

    public final void setCallback(WrapperAdListener wrapperAdListener) {
        this.f50660d = wrapperAdListener;
    }

    public final void setMCallback(WrapperAdListener wrapperAdListener) {
        this.f50660d = wrapperAdListener;
    }

    public final void setSceneId(String str) {
        this.f50659c = str;
    }
}
