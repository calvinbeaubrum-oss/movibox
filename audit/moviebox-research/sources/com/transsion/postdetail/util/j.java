package com.transsion.postdetail.util;

import android.app.Activity;
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
public final class j extends OrientationEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f56218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, Unit> f56219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56220c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public j(Activity activity, Function1<? super Integer, Unit> callback) {
        super(activity);
        Intrinsics.g(activity, "activity");
        Intrinsics.g(callback, "callback");
        this.f56218a = activity;
        this.f56219b = callback;
    }

    public final int a() {
        return this.f56220c;
    }

    public final int b(Activity activity) {
        Intrinsics.g(activity, "activity");
        return activity.getWindowManager().getDefaultDisplay().getRotation();
    }

    public final void c(int i11) {
        if (this.f56220c == i11) {
            return;
        }
        this.f56220c = i11;
        this.f56219b.invoke(Integer.valueOf(i11));
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i11) {
        if (71 <= i11 && i11 < 110) {
            if (this.f56220c != 3 && b(this.f56218a) == 3) {
                c(3);
                return;
            }
            return;
        }
        if (251 > i11 || i11 >= 290 || this.f56220c == 1 || b(this.f56218a) != 1) {
            return;
        }
        c(1);
    }
}
