package com.mbridge.msdk.playercommon.exoplayer2.source;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.FormatHolder;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.CryptoInfo;
import com.mbridge.msdk.playercommon.exoplayer2.decoder.DecoderInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocation;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.Allocator;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class SampleQueue implements TrackOutput {
    public static final int ADVANCE_FAILED = -1;
    private static final int INITIAL_SCRATCH_SIZE = 32;
    private final int allocationLength;
    private final Allocator allocator;
    private Format downstreamFormat;
    private final SampleMetadataQueue.SampleExtrasHolder extrasHolder;
    private AllocationNode firstAllocationNode;
    private Format lastUnadjustedFormat;
    private final SampleMetadataQueue metadataQueue;
    private boolean pendingFormatAdjustment;
    private boolean pendingSplice;
    private AllocationNode readAllocationNode;
    private long sampleOffsetUs;
    private final ParsableByteArray scratch;
    private long totalBytesWritten;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private AllocationNode writeAllocationNode;

    /* JADX INFO: compiled from: source.java */
    public static final class AllocationNode {
        public Allocation allocation;
        public final long endPosition;
        public AllocationNode next;
        public final long startPosition;
        public boolean wasInitialized;

        public AllocationNode(long j11, int i11) {
            this.startPosition = j11;
            this.endPosition = j11 + ((long) i11);
        }

        public final AllocationNode clear() {
            this.allocation = null;
            AllocationNode allocationNode = this.next;
            this.next = null;
            return allocationNode;
        }

        public final void initialize(Allocation allocation, AllocationNode allocationNode) {
            this.allocation = allocation;
            this.next = allocationNode;
            this.wasInitialized = true;
        }

        public final int translateOffset(long j11) {
            return ((int) (j11 - this.startPosition)) + this.allocation.offset;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public SampleQueue(Allocator allocator) {
        this.allocator = allocator;
        int individualAllocationLength = allocator.getIndividualAllocationLength();
        this.allocationLength = individualAllocationLength;
        this.metadataQueue = new SampleMetadataQueue();
        this.extrasHolder = new SampleMetadataQueue.SampleExtrasHolder();
        this.scratch = new ParsableByteArray(32);
        AllocationNode allocationNode = new AllocationNode(0L, individualAllocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
    }

    private void advanceReadTo(long j11) {
        while (true) {
            AllocationNode allocationNode = this.readAllocationNode;
            if (j11 < allocationNode.endPosition) {
                return;
            } else {
                this.readAllocationNode = allocationNode.next;
            }
        }
    }

    private void clearAllocationNodes(AllocationNode allocationNode) {
        if (allocationNode.wasInitialized) {
            AllocationNode allocationNode2 = this.writeAllocationNode;
            boolean z11 = allocationNode2.wasInitialized;
            int i11 = (z11 ? 1 : 0) + (((int) (allocationNode2.startPosition - allocationNode.startPosition)) / this.allocationLength);
            Allocation[] allocationArr = new Allocation[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                allocationArr[i12] = allocationNode.allocation;
                allocationNode = allocationNode.clear();
            }
            this.allocator.release(allocationArr);
        }
    }

    private void discardDownstreamTo(long j11) {
        AllocationNode allocationNode;
        if (j11 == -1) {
            return;
        }
        while (true) {
            allocationNode = this.firstAllocationNode;
            if (j11 < allocationNode.endPosition) {
                break;
            }
            this.allocator.release(allocationNode.allocation);
            this.firstAllocationNode = this.firstAllocationNode.clear();
        }
        if (this.readAllocationNode.startPosition < allocationNode.startPosition) {
            this.readAllocationNode = allocationNode;
        }
    }

    private static Format getAdjustedSampleFormat(Format format, long j11) {
        if (format == null) {
            return null;
        }
        if (j11 == 0) {
            return format;
        }
        long j12 = format.subsampleOffsetUs;
        return j12 != Long.MAX_VALUE ? format.copyWithSubsampleOffsetUs(j12 + j11) : format;
    }

    private void postAppend(int i11) {
        long j11 = this.totalBytesWritten + ((long) i11);
        this.totalBytesWritten = j11;
        AllocationNode allocationNode = this.writeAllocationNode;
        if (j11 == allocationNode.endPosition) {
            this.writeAllocationNode = allocationNode.next;
        }
    }

    private int preAppend(int i11) {
        AllocationNode allocationNode = this.writeAllocationNode;
        if (!allocationNode.wasInitialized) {
            allocationNode.initialize(this.allocator.allocate(), new AllocationNode(this.writeAllocationNode.endPosition, this.allocationLength));
        }
        return Math.min(i11, (int) (this.writeAllocationNode.endPosition - this.totalBytesWritten));
    }

    private void readData(long j11, ByteBuffer byteBuffer, int i11) {
        advanceReadTo(j11);
        while (i11 > 0) {
            int iMin = Math.min(i11, (int) (this.readAllocationNode.endPosition - j11));
            AllocationNode allocationNode = this.readAllocationNode;
            byteBuffer.put(allocationNode.allocation.data, allocationNode.translateOffset(j11), iMin);
            i11 -= iMin;
            j11 += (long) iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j11 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readData(long j11, byte[] bArr, int i11) {
        advanceReadTo(j11);
        int i12 = i11;
        while (i12 > 0) {
            int iMin = Math.min(i12, (int) (this.readAllocationNode.endPosition - j11));
            AllocationNode allocationNode = this.readAllocationNode;
            System.arraycopy(allocationNode.allocation.data, allocationNode.translateOffset(j11), bArr, i11 - i12, iMin);
            i12 -= iMin;
            j11 += (long) iMin;
            AllocationNode allocationNode2 = this.readAllocationNode;
            if (j11 == allocationNode2.endPosition) {
                this.readAllocationNode = allocationNode2.next;
            }
        }
    }

    private void readEncryptionData(DecoderInputBuffer decoderInputBuffer, SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder) {
        int unsignedShort;
        long j11 = sampleExtrasHolder.offset;
        this.scratch.reset(1);
        readData(j11, this.scratch.data, 1);
        long j12 = j11 + 1;
        byte b11 = this.scratch.data[0];
        boolean z11 = (b11 & 128) != 0;
        int i11 = b11 & Ascii.DEL;
        CryptoInfo cryptoInfo = decoderInputBuffer.cryptoInfo;
        if (cryptoInfo.f46513iv == null) {
            cryptoInfo.f46513iv = new byte[16];
        }
        readData(j12, cryptoInfo.f46513iv, i11);
        long j13 = j12 + ((long) i11);
        if (z11) {
            this.scratch.reset(2);
            readData(j13, this.scratch.data, 2);
            j13 += 2;
            unsignedShort = this.scratch.readUnsignedShort();
        } else {
            unsignedShort = 1;
        }
        CryptoInfo cryptoInfo2 = decoderInputBuffer.cryptoInfo;
        int[] iArr = cryptoInfo2.numBytesOfClearData;
        if (iArr == null || iArr.length < unsignedShort) {
            iArr = new int[unsignedShort];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cryptoInfo2.numBytesOfEncryptedData;
        if (iArr3 == null || iArr3.length < unsignedShort) {
            iArr3 = new int[unsignedShort];
        }
        int[] iArr4 = iArr3;
        if (z11) {
            int i12 = unsignedShort * 6;
            this.scratch.reset(i12);
            readData(j13, this.scratch.data, i12);
            j13 += (long) i12;
            this.scratch.setPosition(0);
            for (int i13 = 0; i13 < unsignedShort; i13++) {
                iArr2[i13] = this.scratch.readUnsignedShort();
                iArr4[i13] = this.scratch.readUnsignedIntToInt();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = sampleExtrasHolder.size - ((int) (j13 - sampleExtrasHolder.offset));
        }
        TrackOutput.CryptoData cryptoData = sampleExtrasHolder.cryptoData;
        CryptoInfo cryptoInfo3 = decoderInputBuffer.cryptoInfo;
        cryptoInfo3.set(unsignedShort, iArr2, iArr4, cryptoData.encryptionKey, cryptoInfo3.f46513iv, cryptoData.cryptoMode, cryptoData.encryptedBlocks, cryptoData.clearBlocks);
        long j14 = sampleExtrasHolder.offset;
        int i14 = (int) (j13 - j14);
        sampleExtrasHolder.offset = j14 + ((long) i14);
        sampleExtrasHolder.size -= i14;
    }

    public final int advanceTo(long j11, boolean z11, boolean z12) {
        return this.metadataQueue.advanceTo(j11, z11, z12);
    }

    public final int advanceToEnd() {
        return this.metadataQueue.advanceToEnd();
    }

    public final void discardTo(long j11, boolean z11, boolean z12) {
        discardDownstreamTo(this.metadataQueue.discardTo(j11, z11, z12));
    }

    public final void discardToEnd() {
        discardDownstreamTo(this.metadataQueue.discardToEnd());
    }

    public final void discardToRead() {
        discardDownstreamTo(this.metadataQueue.discardToRead());
    }

    public final void discardUpstreamSamples(int i11) {
        long jDiscardUpstreamSamples = this.metadataQueue.discardUpstreamSamples(i11);
        this.totalBytesWritten = jDiscardUpstreamSamples;
        if (jDiscardUpstreamSamples != 0) {
            AllocationNode allocationNode = this.firstAllocationNode;
            if (jDiscardUpstreamSamples != allocationNode.startPosition) {
                while (this.totalBytesWritten > allocationNode.endPosition) {
                    allocationNode = allocationNode.next;
                }
                AllocationNode allocationNode2 = allocationNode.next;
                clearAllocationNodes(allocationNode2);
                AllocationNode allocationNode3 = new AllocationNode(allocationNode.endPosition, this.allocationLength);
                allocationNode.next = allocationNode3;
                if (this.totalBytesWritten == allocationNode.endPosition) {
                    allocationNode = allocationNode3;
                }
                this.writeAllocationNode = allocationNode;
                if (this.readAllocationNode == allocationNode2) {
                    this.readAllocationNode = allocationNode3;
                    return;
                }
                return;
            }
        }
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode4 = new AllocationNode(this.totalBytesWritten, this.allocationLength);
        this.firstAllocationNode = allocationNode4;
        this.readAllocationNode = allocationNode4;
        this.writeAllocationNode = allocationNode4;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void format(Format format) {
        Format adjustedSampleFormat = getAdjustedSampleFormat(format, this.sampleOffsetUs);
        boolean z11 = this.metadataQueue.format(adjustedSampleFormat);
        this.lastUnadjustedFormat = format;
        this.pendingFormatAdjustment = false;
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener == null || !z11) {
            return;
        }
        upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedSampleFormat);
    }

    public final int getFirstIndex() {
        return this.metadataQueue.getFirstIndex();
    }

    public final long getFirstTimestampUs() {
        return this.metadataQueue.getFirstTimestampUs();
    }

    public final long getLargestQueuedTimestampUs() {
        return this.metadataQueue.getLargestQueuedTimestampUs();
    }

    public final int getReadIndex() {
        return this.metadataQueue.getReadIndex();
    }

    public final Format getUpstreamFormat() {
        return this.metadataQueue.getUpstreamFormat();
    }

    public final int getWriteIndex() {
        return this.metadataQueue.getWriteIndex();
    }

    public final boolean hasNextSample() {
        return this.metadataQueue.hasNextSample();
    }

    public final int peekSourceId() {
        return this.metadataQueue.peekSourceId();
    }

    public final int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean z11, boolean z12, long j11) {
        int i11 = this.metadataQueue.read(formatHolder, decoderInputBuffer, z11, z12, this.downstreamFormat, this.extrasHolder);
        if (i11 == -5) {
            this.downstreamFormat = formatHolder.format;
            return -5;
        }
        if (i11 != -4) {
            if (i11 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!decoderInputBuffer.isEndOfStream()) {
            if (decoderInputBuffer.timeUs < j11) {
                decoderInputBuffer.addFlag(Integer.MIN_VALUE);
            }
            if (decoderInputBuffer.isEncrypted()) {
                readEncryptionData(decoderInputBuffer, this.extrasHolder);
            }
            decoderInputBuffer.ensureSpaceForWrite(this.extrasHolder.size);
            SampleMetadataQueue.SampleExtrasHolder sampleExtrasHolder = this.extrasHolder;
            readData(sampleExtrasHolder.offset, decoderInputBuffer.data, sampleExtrasHolder.size);
        }
        return -4;
    }

    public final void reset() {
        reset(false);
    }

    public final void reset(boolean z11) {
        this.metadataQueue.reset(z11);
        clearAllocationNodes(this.firstAllocationNode);
        AllocationNode allocationNode = new AllocationNode(0L, this.allocationLength);
        this.firstAllocationNode = allocationNode;
        this.readAllocationNode = allocationNode;
        this.writeAllocationNode = allocationNode;
        this.totalBytesWritten = 0L;
        this.allocator.trim();
    }

    public final void rewind() {
        this.metadataQueue.rewind();
        this.readAllocationNode = this.firstAllocationNode;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final int sampleData(ExtractorInput extractorInput, int i11, boolean z11) throws InterruptedException, IOException {
        int iPreAppend = preAppend(i11);
        AllocationNode allocationNode = this.writeAllocationNode;
        int i12 = extractorInput.read(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
        if (i12 != -1) {
            postAppend(i12);
            return i12;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void sampleData(ParsableByteArray parsableByteArray, int i11) {
        while (i11 > 0) {
            int iPreAppend = preAppend(i11);
            AllocationNode allocationNode = this.writeAllocationNode;
            parsableByteArray.readBytes(allocationNode.allocation.data, allocationNode.translateOffset(this.totalBytesWritten), iPreAppend);
            i11 -= iPreAppend;
            postAppend(iPreAppend);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.TrackOutput
    public final void sampleMetadata(long j11, int i11, int i12, int i13, TrackOutput.CryptoData cryptoData) {
        if (this.pendingFormatAdjustment) {
            format(this.lastUnadjustedFormat);
        }
        if (this.pendingSplice) {
            if ((i11 & 1) == 0 || !this.metadataQueue.attemptSplice(j11)) {
                return;
            } else {
                this.pendingSplice = false;
            }
        }
        this.metadataQueue.commitSample(j11 + this.sampleOffsetUs, i11, (this.totalBytesWritten - ((long) i12)) - ((long) i13), i12, cryptoData);
    }

    public final boolean setReadPosition(int i11) {
        return this.metadataQueue.setReadPosition(i11);
    }

    public final void setSampleOffsetUs(long j11) {
        if (this.sampleOffsetUs != j11) {
            this.sampleOffsetUs = j11;
            this.pendingFormatAdjustment = true;
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void sourceId(int i11) {
        this.metadataQueue.sourceId(i11);
    }

    public final void splice() {
        this.pendingSplice = true;
    }
}
