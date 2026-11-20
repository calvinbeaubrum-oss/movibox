package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;

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
public final class DelimitedRangesSequence implements Sequence<IntRange> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CharSequence f69099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f69101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f69102d;

    /* JADX INFO: renamed from: kotlin.text.DelimitedRangesSequence$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass1 implements Iterator<IntRange>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f69103a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f69104b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f69105c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public IntRange f69106d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f69107f;

        public AnonymousClass1() {
            int iK = kotlin.ranges.a.k(DelimitedRangesSequence.this.f69100b, 0, DelimitedRangesSequence.this.f69099a.length());
            this.f69104b = iK;
            this.f69105c = iK;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        private final void a() {
            Pair pair;
            if (this.f69105c < 0) {
                this.f69103a = 0;
                this.f69106d = null;
                return;
            }
            if (DelimitedRangesSequence.this.f69101c > 0) {
                int i11 = this.f69107f + 1;
                this.f69107f = i11;
                if (i11 >= DelimitedRangesSequence.this.f69101c) {
                    this.f69106d = new IntRange(this.f69104b, StringsKt__StringsKt.X(DelimitedRangesSequence.this.f69099a));
                    this.f69105c = -1;
                } else if (this.f69105c > DelimitedRangesSequence.this.f69099a.length() && (pair = (Pair) DelimitedRangesSequence.this.f69102d.invoke(DelimitedRangesSequence.this.f69099a, Integer.valueOf(this.f69105c))) != null) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    this.f69106d = kotlin.ranges.a.r(this.f69104b, iIntValue);
                    int i12 = iIntValue + iIntValue2;
                    this.f69104b = i12;
                    this.f69105c = i12 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f69106d = new IntRange(this.f69104b, StringsKt__StringsKt.X(DelimitedRangesSequence.this.f69099a));
                    this.f69105c = -1;
                }
            } else if (this.f69105c > DelimitedRangesSequence.this.f69099a.length()) {
                this.f69106d = new IntRange(this.f69104b, StringsKt__StringsKt.X(DelimitedRangesSequence.this.f69099a));
                this.f69105c = -1;
            } else {
                int iIntValue3 = ((Number) pair.component1()).intValue();
                int iIntValue4 = ((Number) pair.component2()).intValue();
                this.f69106d = kotlin.ranges.a.r(this.f69104b, iIntValue3);
                int i13 = iIntValue3 + iIntValue4;
                this.f69104b = i13;
                this.f69105c = i13 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.f69103a = 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public IntRange next() {
            if (this.f69103a == -1) {
                a();
            }
            if (this.f69103a == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.f69106d;
            Intrinsics.e(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f69106d = null;
            this.f69103a = -1;
            return intRange;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f69103a == -1) {
                a();
            }
            return this.f69103a == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DelimitedRangesSequence(CharSequence input, int i11, int i12, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> getNextMatch) {
        Intrinsics.g(input, "input");
        Intrinsics.g(getNextMatch, "getNextMatch");
        this.f69099a = input;
        this.f69100b = i11;
        this.f69101c = i12;
        this.f69102d = getNextMatch;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new AnonymousClass1();
    }
}
