package com.transsion.baseui.util;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class f implements View.OnClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f51459c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f51460d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f51461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f51462b = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final void b(f this$0, View v11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(v11, "$v");
        int i11 = this$0.f51461a;
        if (i11 == 1) {
            this$0.d(v11);
        } else if (i11 >= 2) {
            this$0.c(v11);
        }
        this$0.f51462b.removeCallbacksAndMessages(null);
        this$0.f51461a = 0;
    }

    public abstract void c(View view);

    public abstract void d(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(final View v11) {
        Intrinsics.g(v11, "v");
        int i11 = this.f51461a + 1;
        this.f51461a = i11;
        if (i11 > 1) {
            return;
        }
        this.f51462b.postDelayed(new Runnable() { // from class: com.transsion.baseui.util.e
            @Override // java.lang.Runnable
            public final void run() {
                f.b(this.f51457a, v11);
            }
        }, 300L);
    }
}
