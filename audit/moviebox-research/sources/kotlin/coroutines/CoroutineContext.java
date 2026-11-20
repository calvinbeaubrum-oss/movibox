package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@SinceKotlin
@Metadata
public interface CoroutineContext {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DefaultImpls {
        public static CoroutineContext a(CoroutineContext coroutineContext, CoroutineContext context) {
            Intrinsics.g(context, "context");
            return context == EmptyCoroutineContext.INSTANCE ? coroutineContext : (CoroutineContext) context.fold(coroutineContext, new Function2<CoroutineContext, Element, CoroutineContext>() { // from class: kotlin.coroutines.CoroutineContext.plus.1
                @Override // kotlin.jvm.functions.Function2
                public final CoroutineContext invoke(CoroutineContext acc, Element element) {
                    CombinedContext combinedContext;
                    Intrinsics.g(acc, "acc");
                    Intrinsics.g(element, "element");
                    CoroutineContext coroutineContextMinusKey = acc.minusKey(element.getKey());
                    EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.INSTANCE;
                    if (coroutineContextMinusKey == emptyCoroutineContext) {
                        return element;
                    }
                    ContinuationInterceptor.Key key = ContinuationInterceptor.f68810h8;
                    ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContextMinusKey.get(key);
                    if (continuationInterceptor == null) {
                        combinedContext = new CombinedContext(coroutineContextMinusKey, element);
                    } else {
                        CoroutineContext coroutineContextMinusKey2 = coroutineContextMinusKey.minusKey(key);
                        if (coroutineContextMinusKey2 == emptyCoroutineContext) {
                            return new CombinedContext(element, continuationInterceptor);
                        }
                        combinedContext = new CombinedContext(new CombinedContext(coroutineContextMinusKey2, element), continuationInterceptor);
                    }
                    return combinedContext;
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public interface Element extends CoroutineContext {

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class DefaultImpls {
            public static <R> R a(Element element, R r11, Function2<? super R, ? super Element, ? extends R> operation) {
                Intrinsics.g(operation, "operation");
                return operation.invoke(r11, element);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends Element> E b(Element element, Key<E> key) {
                Intrinsics.g(key, "key");
                if (!Intrinsics.b(element.getKey(), key)) {
                    return null;
                }
                Intrinsics.e(element, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return element;
            }

            public static CoroutineContext c(Element element, Key<?> key) {
                Intrinsics.g(key, "key");
                return Intrinsics.b(element.getKey(), key) ? EmptyCoroutineContext.INSTANCE : element;
            }

            public static CoroutineContext d(Element element, CoroutineContext context) {
                Intrinsics.g(context, "context");
                return DefaultImpls.a(element, context);
            }
        }

        @Override // kotlin.coroutines.CoroutineContext
        <E extends Element> E get(Key<E> key);

        Key<?> getKey();
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public interface Key<E extends Element> {
    }

    <R> R fold(R r11, Function2<? super R, ? super Element, ? extends R> function2);

    <E extends Element> E get(Key<E> key);

    CoroutineContext minusKey(Key<?> key);

    CoroutineContext plus(CoroutineContext coroutineContext);
}
