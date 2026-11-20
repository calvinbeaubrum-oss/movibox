package kotlinx.coroutines.flow.internal;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class ChannelFlow<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public final CoroutineContext f69391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @JvmField
    public final int f69392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @JvmField
    public final BufferOverflow f69393c;

    public ChannelFlow(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        this.f69391a = coroutineContext;
        this.f69392b = i11;
        this.f69393c = bufferOverflow;
    }

    public static /* synthetic */ <T> Object h(ChannelFlow<T> channelFlow, kotlinx.coroutines.flow.b<? super T> bVar, Continuation<? super Unit> continuation) {
        Object objE = l0.e(new ChannelFlow$collect$2(bVar, channelFlow, null), continuation);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    @Override // kotlinx.coroutines.flow.a
    public Object a(kotlinx.coroutines.flow.b<? super T> bVar, Continuation<? super Unit> continuation) {
        return h(this, bVar, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    @Override // kotlinx.coroutines.flow.internal.j
    public kotlinx.coroutines.flow.a<T> d(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow) {
        CoroutineContext coroutineContextPlus = coroutineContext.plus(this.f69391a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i12 = this.f69392b;
            if (i12 != -3) {
                if (i11 == -3) {
                    i11 = i12;
                } else if (i12 != -2) {
                    if (i11 == -2) {
                        i11 = i12;
                    } else {
                        i11 += i12;
                        if (i11 < 0) {
                            i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                        }
                    }
                }
            }
            bufferOverflow = this.f69393c;
        }
        return (Intrinsics.b(coroutineContextPlus, this.f69391a) && i11 == this.f69392b && bufferOverflow == this.f69393c) ? this : j(coroutineContextPlus, i11, bufferOverflow);
    }

    public String g() {
        return null;
    }

    public abstract Object i(kotlinx.coroutines.channels.m<? super T> mVar, Continuation<? super Unit> continuation);

    public abstract ChannelFlow<T> j(CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow);

    public kotlinx.coroutines.flow.a<T> k() {
        return null;
    }

    public final Function2<kotlinx.coroutines.channels.m<? super T>, Continuation<? super Unit>, Object> l() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int m() {
        int i11 = this.f69392b;
        if (i11 == -3) {
            return -2;
        }
        return i11;
    }

    public kotlinx.coroutines.channels.o<T> n(k0 k0Var) {
        return kotlinx.coroutines.channels.k.b(k0Var, this.f69391a, m(), this.f69393c, CoroutineStart.ATOMIC, null, l(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strG = g();
        if (strG != null) {
            arrayList.add(strG);
        }
        if (this.f69391a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f69391a);
        }
        if (this.f69392b != -3) {
            arrayList.add("capacity=" + this.f69392b);
        }
        if (this.f69393c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f69393c);
        }
        return m0.a(this) + '[' + CollectionsKt___CollectionsKt.o0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
