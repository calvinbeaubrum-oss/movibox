package lp;

import android.text.TextUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
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
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f70351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f70352b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public kp.b f70354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Executor f70355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExecutorService f70356f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f70353c = "";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f70357g = 5;

    public a(int i11, int i12, ExecutorService executorService) {
        this.f70351a = Math.max(1, i11);
        this.f70352b = i12;
        this.f70356f = executorService;
    }

    public final com.tn.lib.thread.e a() {
        String str;
        int iMax = Math.max(10, this.f70357g);
        this.f70357g = iMax;
        this.f70357g = Math.min(1, iMax);
        this.f70351a = Math.max(1, this.f70351a);
        this.f70355e = c.f70359b.a();
        if (TextUtils.isEmpty(this.f70353c)) {
            int i11 = this.f70352b;
            if (i11 == 1) {
                str = "FIXED";
            } else if (i11 == 2) {
                str = "CACHEABLE";
            } else if (i11 != 3) {
                str = i11 != 4 ? "ThreadEngine" : "SINGLE";
            } else {
                str = "SCHEDULED";
            }
            this.f70353c = str;
        }
        return new com.tn.lib.thread.e(this.f70352b, this.f70351a, this.f70357g, this.f70353c, this.f70354d, this.f70355e, this.f70356f);
    }

    public final a b(String name) {
        Intrinsics.g(name, "name");
        this.f70353c = name;
        return this;
    }

    public final a c(int i11) {
        this.f70357g = i11;
        return this;
    }
}
