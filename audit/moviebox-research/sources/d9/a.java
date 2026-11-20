package d9;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseQuickAdapter<T, ?> f62948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b<T> f62949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f62950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Executor f62951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Executor f62952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Object> f62953f;

    /* JADX INFO: renamed from: d9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class ExecutorC0647a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f62954a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            Intrinsics.g(command, "command");
            this.f62954a.post(command);
        }
    }

    public a(BaseQuickAdapter<T, ?> adapter, b<T> config) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(config, "config");
        this.f62948a = adapter;
        this.f62949b = config;
        this.f62950c = new c(adapter);
        Executor executorC0647a = new ExecutorC0647a();
        this.f62952e = executorC0647a;
        Executor executorA = config.a();
        this.f62951d = executorA != null ? executorA : executorC0647a;
        this.f62953f = new CopyOnWriteArrayList();
    }
}
