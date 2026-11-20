package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final /* synthetic */ class FlowKt__DistinctKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function1<Object, Object> f69330a = new Function1<Object, Object>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultKeySelector$1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function2<Object, Object, Boolean> f69331b = new Function2<Object, Object, Boolean>() { // from class: kotlinx.coroutines.flow.FlowKt__DistinctKt$defaultAreEquivalent$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function2
        public final Boolean invoke(Object obj, Object obj2) {
            return Boolean.valueOf(Intrinsics.b(obj, obj2));
        }
    };

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> a(a<? extends T> aVar) {
        return aVar instanceof f1 ? aVar : b(aVar, f69330a, f69331b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> a<T> b(a<? extends T> aVar, Function1<? super T, ? extends Object> function1, Function2<Object, Object, Boolean> function2) {
        if (aVar instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) aVar;
            if (distinctFlowImpl.f69325b == function1 && distinctFlowImpl.f69326c == function2) {
                return aVar;
            }
        }
        return new DistinctFlowImpl(aVar, function1, function2);
    }
}
