package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
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
    public final AtomicReference<a> f2027a = new AtomicReference<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kotlinx.coroutines.sync.a f2028b = kotlinx.coroutines.sync.b.b(false, 1, null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutatePriority f2029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q1 f2030b;

        public a(MutatePriority mutatePriority, q1 q1Var) {
            this.f2029a = mutatePriority;
            this.f2030b = q1Var;
        }

        public final boolean a(a aVar) {
            return this.f2029a.compareTo(aVar.f2029a) >= 0;
        }

        public final void b() {
            this.f2030b.cancel(new MutationInterruptedException());
        }
    }

    public static /* synthetic */ Object e(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.d(mutatePriority, function1, continuation);
    }

    public final <R> Object d(MutatePriority mutatePriority, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super R> continuation) {
        return kotlinx.coroutines.l0.e(new MutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }

    public final void f(a aVar) {
        a aVar2;
        do {
            aVar2 = this.f2027a.get();
            if (aVar2 != null && !aVar.a(aVar2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!j0.a(this.f2027a, aVar2, aVar));
        if (aVar2 != null) {
            aVar2.b();
        }
    }
}
