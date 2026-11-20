package androidx.compose.ui.text.font;

import android.content.Context;
import android.graphics.Typeface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
@SourceDebugExtension
public final class b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends b3.h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.n<Typeface> f5815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i0 f5816b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(kotlinx.coroutines.n<? super Typeface> nVar, i0 i0Var) {
            this.f5815a = nVar;
            this.f5816b = i0Var;
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: h */
        public void f(int i11) {
            this.f5815a.cancel(new IllegalStateException("Unable to load font " + this.f5816b + " (reason=" + i11 + ')'));
        }

        @Override // b3.h.e
        /* JADX INFO: renamed from: i */
        public void g(Typeface typeface) {
            this.f5815a.resumeWith(Result.m163constructorimpl(typeface));
        }
    }

    public static final Typeface c(i0 i0Var, Context context) {
        Typeface typefaceG = b3.h.g(context, i0Var.a());
        Intrinsics.d(typefaceG);
        return typefaceG;
    }

    public static final Object d(i0 i0Var, Context context, Continuation<? super Typeface> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        b3.h.i(context, i0Var.a(), new a(cancellableContinuationImpl, i0Var), null);
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result;
    }
}
