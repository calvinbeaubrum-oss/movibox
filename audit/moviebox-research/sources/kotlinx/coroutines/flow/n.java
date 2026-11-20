package kotlinx.coroutines.flow;

import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final /* synthetic */ class n {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a<T> implements kotlinx.coroutines.flow.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f69422a;

        public a(Object obj) {
            this.f69422a = obj;
        }

        @Override // kotlinx.coroutines.flow.a
        public Object a(b<? super T> bVar, Continuation<? super Unit> continuation) {
            Object objEmit = bVar.emit((Object) this.f69422a, continuation);
            return objEmit == kotlin.coroutines.intrinsics.a.e() ? objEmit : Unit.f68710a;
        }
    }

    public static final <T> kotlinx.coroutines.flow.a<T> a(@BuilderInference Function2<? super b<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        return new y0(function2);
    }

    public static final <T> kotlinx.coroutines.flow.a<T> b(T t11) {
        return new a(t11);
    }
}
