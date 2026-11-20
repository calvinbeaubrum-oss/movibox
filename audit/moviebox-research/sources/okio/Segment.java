package okio;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
@Metadata
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;

    @JvmField
    public final byte[] data;

    @JvmField
    public int limit;

    @JvmField
    public Segment next;

    @JvmField
    public boolean owner;

    @JvmField
    public int pos;

    @JvmField
    public Segment prev;

    @JvmField
    public boolean shared;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] data, int i11, int i12, boolean z11, boolean z12) {
        Intrinsics.g(data, "data");
        this.data = data;
        this.pos = i11;
        this.limit = i12;
        this.shared = z11;
        this.owner = z12;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i11 = 0;
        if (!(segment != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        Intrinsics.d(segment);
        if (segment.owner) {
            int i12 = this.limit - this.pos;
            Segment segment2 = this.prev;
            Intrinsics.d(segment2);
            int i13 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            Intrinsics.d(segment3);
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                Intrinsics.d(segment4);
                i11 = segment4.pos;
            }
            if (i12 > i13 + i11) {
                return;
            }
            Segment segment5 = this.prev;
            Intrinsics.d(segment5);
            writeTo(segment5, i12);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        Intrinsics.d(segment2);
        segment2.next = this.next;
        Segment segment3 = this.next;
        Intrinsics.d(segment3);
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        Intrinsics.g(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.d(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i11) {
        Segment segmentTake;
        if (!(i11 > 0 && i11 <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i11 >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i12 = this.pos;
            ArraysKt___ArraysJvmKt.m(bArr, bArr2, 0, i12, i12 + i11, 2, null);
        }
        segmentTake.limit = segmentTake.pos + i11;
        this.pos += i11;
        Segment segment = this.prev;
        Intrinsics.d(segment);
        segment.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.f(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment sink, int i11) {
        Intrinsics.g(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i12 = sink.limit;
        if (i12 + i11 > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            int i13 = sink.pos;
            if ((i12 + i11) - i13 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.data;
            ArraysKt___ArraysJvmKt.m(bArr, bArr, 0, i13, i12, 2, null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = sink.data;
        int i14 = sink.limit;
        int i15 = this.pos;
        ArraysKt___ArraysJvmKt.h(bArr2, bArr3, i14, i15, i15 + i11);
        sink.limit += i11;
        this.pos += i11;
    }
}
