package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class TypefaceRequestCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.ui.text.platform.q f5812a = androidx.compose.ui.text.platform.p.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o2.b<n0, o0> f5813b = new o2.b<>(16);

    public final androidx.compose.ui.text.platform.q b() {
        return this.f5812a;
    }

    public final a3<Object> c(final n0 n0Var, Function1<? super Function1<? super o0, Unit>, ? extends o0> function1) {
        synchronized (this.f5812a) {
            o0 o0VarD = this.f5813b.d(n0Var);
            if (o0VarD != null) {
                if (o0VarD.c()) {
                    return o0VarD;
                }
                this.f5813b.f(n0Var);
            }
            try {
                o0 o0VarInvoke = function1.invoke(new Function1<o0, Unit>() { // from class: androidx.compose.ui.text.font.TypefaceRequestCache$runCached$currentTypefaceResult$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(o0 o0Var) {
                        invoke2(o0Var);
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(o0 o0Var) {
                        androidx.compose.ui.text.platform.q qVarB = this.this$0.b();
                        TypefaceRequestCache typefaceRequestCache = this.this$0;
                        n0 n0Var2 = n0Var;
                        synchronized (qVarB) {
                            try {
                                if (o0Var.c()) {
                                    typefaceRequestCache.f5813b.e(n0Var2, o0Var);
                                } else {
                                    typefaceRequestCache.f5813b.f(n0Var2);
                                }
                                Unit unit = Unit.f68710a;
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                });
                synchronized (this.f5812a) {
                    try {
                        if (this.f5813b.d(n0Var) == null && o0VarInvoke.c()) {
                            this.f5813b.e(n0Var, o0VarInvoke);
                        }
                        Unit unit = Unit.f68710a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return o0VarInvoke;
            } catch (Exception e11) {
                throw new IllegalStateException("Could not load font", e11);
            }
        }
    }
}
