package androidx.compose.foundation;

import androidx.compose.animation.core.j0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class MutatorMutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference<a> f2252a = new AtomicReference<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f2253b = kotlinx.coroutines.sync.b.b(false, 1, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutatePriority f2254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q1 f2255b;

        public a(MutatePriority mutatePriority, q1 q1Var) {
            this.f2254a = mutatePriority;
            this.f2255b = q1Var;
        }

        public final boolean a(a aVar) {
            return this.f2254a.compareTo(aVar.f2254a) >= 0;
        }

        public final void b() {
            this.f2255b.cancel(new MutationInterruptedException());
        }
    }

    public final <T, R> Object d(T t11, MutatePriority mutatePriority, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return l0.e(new MutatorMutex$mutateWith$2(mutatePriority, this, function2, t11, null), continuation);
    }

    public final void e(a aVar) {
        a aVar2;
        do {
            aVar2 = this.f2252a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!j0.a(this.f2252a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }
}
