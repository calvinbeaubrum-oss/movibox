package kotlinx.coroutines.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.y0;

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
@SourceDebugExtension
public final class u extends a2 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Throwable f69493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f69494b;

    public u(Throwable th2, String str) {
        this.f69493a = th2;
        this.f69494b = str;
    }

    @Override // kotlinx.coroutines.q0
    public y0 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.a2, kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i11) {
        t();
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.coroutines.a2
    /* JADX INFO: renamed from: o */
    public a2 q() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        t();
        throw new KotlinNothingValueException();
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0025  */
    public final Void t() {
        String str;
        if (this.f69493a == null) {
            t.d();
            throw new KotlinNothingValueException();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Module with the Main dispatcher had failed to initialize");
        String str2 = this.f69494b;
        if (str2 != null) {
            str = ". " + str2;
            if (str == null) {
                str = "";
            }
        } else {
            str = "";
        }
        sb2.append(str);
        throw new IllegalStateException(sb2.toString(), this.f69493a);
    }

    @Override // kotlinx.coroutines.a2, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Dispatchers.Main[missing");
        if (this.f69493a != null) {
            str = ", cause=" + this.f69493a;
        } else {
            str = "";
        }
        sb2.append(str);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // kotlinx.coroutines.q0
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public Void scheduleResumeAfterDelay(long j11, kotlinx.coroutines.n<? super Unit> nVar) {
        t();
        throw new KotlinNothingValueException();
    }
}
