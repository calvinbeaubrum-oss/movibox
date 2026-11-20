package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.SourceDebugExtension;

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
@PublishedApi
@SourceDebugExtension
public final class c {

    @JvmField
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;

    @JvmField
    public volatile String _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final long f69295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakReference<CoroutineContext> f69296b;

    @JvmField
    public volatile Thread lastObservedThread;

    public final List<StackTraceElement> a() {
        return kotlin.collections.g.l();
    }

    public final CoroutineContext b() {
        return this.f69296b.get();
    }

    public final g c() {
        return null;
    }

    public final List<StackTraceElement> d() {
        return a();
    }

    public final CoroutineStackFrame e() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final String f() {
        return this._state;
    }

    public final List<StackTraceElement> g() {
        CoroutineStackFrame coroutineStackFrameE = e();
        if (coroutineStackFrameE == null) {
            return kotlin.collections.g.l();
        }
        ArrayList arrayList = new ArrayList();
        while (coroutineStackFrameE != null) {
            StackTraceElement stackTraceElement = coroutineStackFrameE.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            coroutineStackFrameE = coroutineStackFrameE.getCallerFrame();
        }
        return arrayList;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + f() + ",context=" + b() + ')';
    }
}
