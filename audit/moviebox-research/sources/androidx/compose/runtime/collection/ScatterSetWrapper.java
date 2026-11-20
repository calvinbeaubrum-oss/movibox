package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt__SequenceBuilderKt;

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
public final class ScatterSetWrapper<T> implements Set<T>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScatterSet<T> f3355a;

    /* JADX INFO: renamed from: androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.runtime.collection.ScatterSetWrapper$iterator$1", f = "ScatterSetWrapper.kt", l = {34}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ ScatterSetWrapper<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ScatterSetWrapper<T> scatterSetWrapper, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = scatterSetWrapper;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:13:0x005e  */
        /* JADX WARN: Code duplicated, block: B:23:0x00a6 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:24:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:26:0x00af  */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [java.lang.Object, kotlin.sequences.SequenceScope] */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3 */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r14v8 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v15 */
        /* JADX WARN: Type inference failed for: r2v3 */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x005c -> B:25:0x00ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x005e -> B:14:0x0070). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0079 -> B:22:0x00a3). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0099 -> B:21:0x009e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r23) {
            /*
                r22 = this;
                r0 = r22
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
                int r2 = r0.label
                r3 = 0
                r4 = 8
                r5 = 1
                if (r2 == 0) goto L36
                if (r2 != r5) goto L2e
                int r2 = r0.I$3
                int r6 = r0.I$2
                long r7 = r0.J$0
                int r9 = r0.I$1
                int r10 = r0.I$0
                java.lang.Object r11 = r0.L$2
                long[] r11 = (long[]) r11
                java.lang.Object r12 = r0.L$1
                java.lang.Object[] r12 = (java.lang.Object[]) r12
                java.lang.Object r13 = r0.L$0
                kotlin.sequences.SequenceScope r13 = (kotlin.sequences.SequenceScope) r13
                kotlin.ResultKt.b(r23)
                r14 = r13
                r13 = r12
                r12 = r0
                goto L9e
            L2e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L36:
                kotlin.ResultKt.b(r23)
                java.lang.Object r2 = r0.L$0
                kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
                androidx.compose.runtime.collection.ScatterSetWrapper<T> r6 = r0.this$0
                androidx.collection.ScatterSet r6 = r6.a()
                java.lang.Object[] r7 = r6.f1898b
                long[] r6 = r6.f1897a
                int r8 = r6.length
                int r8 = r8 + (-2)
                if (r8 < 0) goto Lb2
                r10 = r0
                r9 = 0
            L4e:
                r11 = r6[r9]
                long r13 = ~r11
                r15 = 7
                long r13 = r13 << r15
                long r13 = r13 & r11
                r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
                long r13 = r13 & r15
                int r17 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r17 == 0) goto Lad
                int r13 = r9 - r8
                int r13 = ~r13
                int r13 = r13 >>> 31
                int r13 = 8 - r13
                r14 = r2
                r2 = 0
                r20 = r11
                r12 = r6
                r11 = r10
                r6 = r13
                r13 = r7
                r10 = r8
                r7 = r20
            L70:
                if (r2 >= r6) goto La6
                r15 = 255(0xff, double:1.26E-321)
                long r15 = r15 & r7
                r17 = 128(0x80, double:6.3E-322)
                int r19 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                if (r19 >= 0) goto La3
                int r15 = r9 << 3
                int r15 = r15 + r2
                r15 = r13[r15]
                r11.L$0 = r14
                r11.L$1 = r13
                r11.L$2 = r12
                r11.I$0 = r10
                r11.I$1 = r9
                r11.J$0 = r7
                r11.I$2 = r6
                r11.I$3 = r2
                r11.label = r5
                java.lang.Object r15 = r14.a(r15, r11)
                if (r15 != r1) goto L99
                return r1
            L99:
                r20 = r12
                r12 = r11
                r11 = r20
            L9e:
                r20 = r12
                r12 = r11
                r11 = r20
            La3:
                long r7 = r7 >> r4
                int r2 = r2 + r5
                goto L70
            La6:
                if (r6 != r4) goto Lb2
                r8 = r10
                r10 = r11
                r6 = r12
                r7 = r13
                r2 = r14
            Lad:
                if (r9 == r8) goto Lb2
                int r9 = r9 + 1
                goto L4e
            Lb2:
                kotlin.Unit r1 = kotlin.Unit.f68710a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.collection.ScatterSetWrapper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public ScatterSetWrapper(ScatterSet<T> scatterSet) {
        this.f3355a = scatterSet;
    }

    public final ScatterSet<T> a() {
        return this.f3355a;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t11) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        return this.f3355a.a(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        Collection<? extends Object> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!this.f3355a.a(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int e() {
        return this.f3355a.c();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f3355a.d();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return SequencesKt__SequenceBuilderKt.a(new AnonymousClass1(this, null));
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.b(this, tArr);
    }
}
