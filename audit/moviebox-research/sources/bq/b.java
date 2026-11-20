package bq;

import android.content.Context;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
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
public final class b implements aq.c<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final aq.c<?> f14305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f14309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f14310f;

    @JvmOverloads
    public b(aq.c<?> mStyle, int i11, int i12, int i13, float f11, float f12) {
        Intrinsics.g(mStyle, "mStyle");
        this.f14305a = mStyle;
        this.f14306b = i11;
        this.f14307c = i12;
        this.f14308d = i13;
        this.f14309e = f11;
        this.f14310f = f12;
    }

    @Override // aq.c
    public View a(Context context) {
        View viewA = this.f14305a.a(context);
        Intrinsics.d(viewA);
        return viewA;
    }

    @Override // aq.c
    public int getGravity() {
        return this.f14306b;
    }

    @Override // aq.c
    public float getHorizontalMargin() {
        return this.f14309e;
    }

    @Override // aq.c
    public float getVerticalMargin() {
        return this.f14310f;
    }

    @Override // aq.c
    public int getXOffset() {
        return this.f14307c;
    }

    @Override // aq.c
    public int getYOffset() {
        return this.f14308d;
    }
}
