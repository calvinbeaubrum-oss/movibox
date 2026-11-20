package s3;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f75951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, AutoCloseable> f75952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<AutoCloseable> f75953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f75954d;

    public f() {
        this.f75951a = new e();
        this.f75952b = new LinkedHashMap();
        this.f75953c = new LinkedHashSet();
    }

    public f(k0 viewModelScope) {
        Intrinsics.g(viewModelScope, "viewModelScope");
        this.f75951a = new e();
        this.f75952b = new LinkedHashMap();
        this.f75953c = new LinkedHashSet();
        e("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", b.a(viewModelScope));
    }

    public f(k0 viewModelScope, AutoCloseable... closeables) {
        Intrinsics.g(viewModelScope, "viewModelScope");
        Intrinsics.g(closeables, "closeables");
        this.f75951a = new e();
        this.f75952b = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f75953c = linkedHashSet;
        e("androidx.lifecycle.viewmodel.internal.ViewModelCoroutineScope.JOB_KEY", b.a(viewModelScope));
        k.B(linkedHashSet, closeables);
    }

    public f(AutoCloseable... closeables) {
        Intrinsics.g(closeables, "closeables");
        this.f75951a = new e();
        this.f75952b = new LinkedHashMap();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f75953c = linkedHashSet;
        k.B(linkedHashSet, closeables);
    }

    public final void d(AutoCloseable closeable) {
        Intrinsics.g(closeable, "closeable");
        if (this.f75954d) {
            g(closeable);
            return;
        }
        synchronized (this.f75951a) {
            this.f75953c.add(closeable);
            Unit unit = Unit.f68710a;
        }
    }

    public final void e(String key, AutoCloseable closeable) {
        AutoCloseable autoCloseable;
        Intrinsics.g(key, "key");
        Intrinsics.g(closeable, "closeable");
        if (this.f75954d) {
            g(closeable);
            return;
        }
        synchronized (this.f75951a) {
            autoCloseable = (AutoCloseable) this.f75952b.put(key, closeable);
        }
        g(autoCloseable);
    }

    public final void f() {
        if (this.f75954d) {
            return;
        }
        this.f75954d = true;
        synchronized (this.f75951a) {
            try {
                Iterator it = this.f75952b.values().iterator();
                while (it.hasNext()) {
                    g((AutoCloseable) it.next());
                }
                Iterator it2 = this.f75953c.iterator();
                while (it2.hasNext()) {
                    g((AutoCloseable) it2.next());
                }
                this.f75953c.clear();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    public final <T extends AutoCloseable> T h(String key) {
        T t11;
        Intrinsics.g(key, "key");
        synchronized (this.f75951a) {
            t11 = (T) this.f75952b.get(key);
        }
        return t11;
    }
}
