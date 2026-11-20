package com.transsion.baselib.helper;

import android.content.Context;
import android.view.OrientationEventListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class d extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<Boolean, Unit> f51187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f51189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f51191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f51192f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f51193g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f51194h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(Context context, Function1<? super Boolean, Unit> callback) {
        super(context);
        Intrinsics.g(context, "context");
        Intrinsics.g(callback, "callback");
        this.f51187a = callback;
        this.f51188b = 500;
        this.f51190d = -1;
        this.f51191e = 1;
        this.f51192f = 2;
        this.f51193g = 3;
        this.f51194h = 4;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i11) {
        if (i11 == -1 || System.currentTimeMillis() - this.f51189c < this.f51188b) {
            return;
        }
        this.f51189c = System.currentTimeMillis();
        if (i11 >= 335 || i11 < 25) {
            int i12 = this.f51190d;
            int i13 = this.f51191e;
            if (i12 != i13) {
                this.f51190d = i13;
                this.f51187a.invoke(Boolean.TRUE);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("竖屏：");
            sb2.append(i11);
            return;
        }
        if (65 <= i11 && i11 < 116) {
            int i14 = this.f51190d;
            int i15 = this.f51192f;
            if (i14 != i15) {
                this.f51190d = i15;
                this.f51187a.invoke(Boolean.FALSE);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("横屏：");
            sb3.append(i11);
            return;
        }
        if (155 <= i11 && i11 < 206) {
            int i16 = this.f51190d;
            int i17 = this.f51193g;
            if (i16 != i17) {
                this.f51190d = i17;
                this.f51187a.invoke(Boolean.TRUE);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("反向-竖屏：");
            sb4.append(i11);
            return;
        }
        if (245 > i11 || i11 >= 296) {
            return;
        }
        int i18 = this.f51190d;
        int i19 = this.f51194h;
        if (i18 != i19) {
            this.f51190d = i19;
            this.f51187a.invoke(Boolean.FALSE);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("反向-横屏：");
        sb5.append(i11);
    }
}
