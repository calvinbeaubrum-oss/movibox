package androidx.compose.runtime.snapshots;

import com.google.logging.type.LogSeverity;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class SnapshotIdSet implements Iterable<Integer>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f3596f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SnapshotIdSet f3597g = new SnapshotIdSet(0, 0, 0, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f3600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f3601d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet a() {
            return SnapshotIdSet.f3597g;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", f = "SnapshotIdSet.kt", l = {295, LogSeverity.NOTICE_VALUE, 307}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = SnapshotIdSet.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(sequenceScope, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x008f  */
        /* JADX WARN: Code duplicated, block: B:28:0x009d  */
        /* JADX WARN: Code duplicated, block: B:30:0x00b6 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:32:0x00b9  */
        /* JADX WARN: Code duplicated, block: B:35:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:37:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:39:0x00d6  */
        /* JADX WARN: Code duplicated, block: B:41:0x00f2 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:42:0x00f3  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0078 -> B:19:0x007b). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x009b -> B:31:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b4 -> B:31:0x00b7). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00f0 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00f3 -> B:43:0x00f4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:26:0x008f
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r21) {
            /*
                Method dump skipped, instruction units count: 249
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.SnapshotIdSet.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public SnapshotIdSet(long j11, long j12, int i11, int[] iArr) {
        this.f3598a = j11;
        this.f3599b = j12;
        this.f3600c = i11;
        this.f3601d = iArr;
    }

    @Override // java.lang.Iterable
    public Iterator<Integer> iterator() {
        return SequencesKt__SequenceBuilderKt.b(new AnonymousClass1(null)).iterator();
    }

    public final SnapshotIdSet j(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSetR;
        SnapshotIdSet snapshotIdSet2 = f3597g;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet2;
        }
        int i11 = snapshotIdSet.f3600c;
        int i12 = this.f3600c;
        if (i11 == i12) {
            int[] iArr = snapshotIdSet.f3601d;
            int[] iArr2 = this.f3601d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f3598a & (~snapshotIdSet.f3598a), this.f3599b & (~snapshotIdSet.f3599b), i12, iArr2);
            }
        }
        int[] iArr3 = snapshotIdSet.f3601d;
        if (iArr3 != null) {
            snapshotIdSetR = this;
            for (int i13 : iArr3) {
                snapshotIdSetR = snapshotIdSetR.r(i13);
            }
        } else {
            snapshotIdSetR = this;
        }
        if (snapshotIdSet.f3599b != 0) {
            for (int i14 = 0; i14 < 64; i14++) {
                if ((snapshotIdSet.f3599b & (1 << i14)) != 0) {
                    snapshotIdSetR = snapshotIdSetR.r(snapshotIdSet.f3600c + i14);
                }
            }
        }
        if (snapshotIdSet.f3598a != 0) {
            for (int i15 = 0; i15 < 64; i15++) {
                if ((snapshotIdSet.f3598a & (1 << i15)) != 0) {
                    snapshotIdSetR = snapshotIdSetR.r(i15 + 64 + snapshotIdSet.f3600c);
                }
            }
        }
        return snapshotIdSetR;
    }

    public final SnapshotIdSet r(int i11) {
        int[] iArr;
        int iA;
        int i12 = this.f3600c;
        int i13 = i11 - i12;
        if (i13 >= 0 && i13 < 64) {
            long j11 = 1 << i13;
            long j12 = this.f3599b;
            if ((j12 & j11) != 0) {
                return new SnapshotIdSet(this.f3598a, j12 & (~j11), i12, this.f3601d);
            }
        } else if (i13 >= 64 && i13 < 128) {
            long j13 = 1 << (i13 - 64);
            long j14 = this.f3598a;
            if ((j14 & j13) != 0) {
                return new SnapshotIdSet(j14 & (~j13), this.f3599b, i12, this.f3601d);
            }
        } else if (i13 < 0 && (iArr = this.f3601d) != null && (iA = m.a(iArr, i11)) >= 0) {
            int length = iArr.length;
            int i14 = length - 1;
            if (i14 == 0) {
                return new SnapshotIdSet(this.f3598a, this.f3599b, this.f3600c, null);
            }
            int[] iArr2 = new int[i14];
            if (iA > 0) {
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, 0, 0, iA);
            }
            if (iA < i14) {
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, iA, iA + 1, length);
            }
            return new SnapshotIdSet(this.f3598a, this.f3599b, this.f3600c, iArr2);
        }
        return this;
    }

    public final boolean s(int i11) {
        int[] iArr;
        int i12 = i11 - this.f3600c;
        if (i12 >= 0 && i12 < 64) {
            return ((1 << i12) & this.f3599b) != 0;
        }
        if (i12 >= 64 && i12 < 128) {
            return ((1 << (i12 - 64)) & this.f3598a) != 0;
        }
        if (i12 <= 0 && (iArr = this.f3601d) != null) {
            return m.a(iArr, i11) >= 0;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(kotlin.collections.h.v(this, 10));
        Iterator<Integer> it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next().intValue()));
        }
        sb2.append(androidx.compose.runtime.snapshots.a.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb2.append(']');
        return sb2.toString();
    }

    public final int u(int i11) {
        int[] iArr = this.f3601d;
        if (iArr != null) {
            return iArr[0];
        }
        long j11 = this.f3599b;
        if (j11 != 0) {
            return this.f3600c + Long.numberOfTrailingZeros(j11);
        }
        long j12 = this.f3598a;
        return j12 != 0 ? this.f3600c + 64 + Long.numberOfTrailingZeros(j12) : i11;
    }

    public final SnapshotIdSet v(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSetW;
        SnapshotIdSet snapshotIdSet2 = f3597g;
        if (snapshotIdSet == snapshotIdSet2) {
            return this;
        }
        if (this == snapshotIdSet2) {
            return snapshotIdSet;
        }
        int i11 = snapshotIdSet.f3600c;
        int i12 = this.f3600c;
        if (i11 == i12) {
            int[] iArr = snapshotIdSet.f3601d;
            int[] iArr2 = this.f3601d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f3598a | snapshotIdSet.f3598a, this.f3599b | snapshotIdSet.f3599b, i12, iArr2);
            }
        }
        int i13 = 0;
        if (this.f3601d == null) {
            int[] iArr3 = this.f3601d;
            if (iArr3 != null) {
                for (int i14 : iArr3) {
                    snapshotIdSet = snapshotIdSet.w(i14);
                }
            }
            if (this.f3599b != 0) {
                for (int i15 = 0; i15 < 64; i15++) {
                    if ((this.f3599b & (1 << i15)) != 0) {
                        snapshotIdSet = snapshotIdSet.w(this.f3600c + i15);
                    }
                }
            }
            if (this.f3598a != 0) {
                while (i13 < 64) {
                    if ((this.f3598a & (1 << i13)) != 0) {
                        snapshotIdSet = snapshotIdSet.w(i13 + 64 + this.f3600c);
                    }
                    i13++;
                }
            }
            return snapshotIdSet;
        }
        int[] iArr4 = snapshotIdSet.f3601d;
        if (iArr4 != null) {
            snapshotIdSetW = this;
            for (int i16 : iArr4) {
                snapshotIdSetW = snapshotIdSetW.w(i16);
            }
        } else {
            snapshotIdSetW = this;
        }
        if (snapshotIdSet.f3599b != 0) {
            for (int i17 = 0; i17 < 64; i17++) {
                if ((snapshotIdSet.f3599b & (1 << i17)) != 0) {
                    snapshotIdSetW = snapshotIdSetW.w(snapshotIdSet.f3600c + i17);
                }
            }
        }
        if (snapshotIdSet.f3598a != 0) {
            while (i13 < 64) {
                if ((snapshotIdSet.f3598a & (1 << i13)) != 0) {
                    snapshotIdSetW = snapshotIdSetW.w(i13 + 64 + snapshotIdSet.f3600c);
                }
                i13++;
            }
        }
        return snapshotIdSetW;
    }

    public final SnapshotIdSet w(int i11) {
        int i12;
        int[] iArrI0;
        int i13 = this.f3600c;
        int i14 = i11 - i13;
        long j11 = 0;
        if (i14 >= 0 && i14 < 64) {
            long j12 = 1 << i14;
            long j13 = this.f3599b;
            if ((j13 & j12) == 0) {
                return new SnapshotIdSet(this.f3598a, j13 | j12, i13, this.f3601d);
            }
        } else if (i14 >= 64 && i14 < 128) {
            long j14 = 1 << (i14 - 64);
            long j15 = this.f3598a;
            if ((j15 & j14) == 0) {
                return new SnapshotIdSet(j15 | j14, this.f3599b, i13, this.f3601d);
            }
        } else if (i14 < 128) {
            int[] iArr = this.f3601d;
            if (iArr == null) {
                return new SnapshotIdSet(this.f3598a, this.f3599b, i13, new int[]{i11});
            }
            int iA = m.a(iArr, i11);
            if (iA < 0) {
                int i15 = -(iA + 1);
                int length = iArr.length;
                int[] iArr2 = new int[length + 1];
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, 0, 0, i15);
                ArraysKt___ArraysJvmKt.j(iArr, iArr2, i15 + 1, i15, length);
                iArr2[i15] = i11;
                return new SnapshotIdSet(this.f3598a, this.f3599b, this.f3600c, iArr2);
            }
        } else if (!s(i11)) {
            long j16 = this.f3598a;
            long j17 = this.f3599b;
            int i16 = this.f3600c;
            int i17 = ((i11 + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j18 = j17;
            long j19 = j16;
            while (true) {
                if (i16 >= i17) {
                    i12 = i16;
                    break;
                }
                if (j18 != j11) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr3 = this.f3601d;
                        if (iArr3 != null) {
                            for (int i18 : iArr3) {
                                arrayList.add(Integer.valueOf(i18));
                            }
                        }
                    }
                    for (int i19 = 0; i19 < 64; i19++) {
                        if (((1 << i19) & j18) != 0) {
                            arrayList.add(Integer.valueOf(i19 + i16));
                        }
                    }
                    j11 = 0;
                }
                if (j19 == j11) {
                    i12 = i17;
                    j18 = j11;
                    break;
                }
                i16 += 64;
                j18 = j19;
                j19 = j11;
            }
            if (arrayList == null || (iArrI0 = CollectionsKt___CollectionsKt.I0(arrayList)) == null) {
                iArrI0 = this.f3601d;
            }
            return new SnapshotIdSet(j19, j18, i12, iArrI0).w(i11);
        }
        return this;
    }
}
