package lp;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
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
public final class c implements Executor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f70359b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f70360c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f70361a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f70360c;
        }
    }

    public static final void c(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable runnable) {
        if (Intrinsics.b(Looper.myLooper(), Looper.getMainLooper())) {
            if (runnable != null) {
                runnable.run();
            }
        } else {
            Handler handler = this.f70361a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: lp.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.c(runnable);
                    }
                });
            }
        }
    }
}
