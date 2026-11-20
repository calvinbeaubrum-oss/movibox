package org.apache.commons.compress.compressors.snappy;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public enum FramedSnappyDialect {
    STANDARD(true, true),
    IWORK_ARCHIVE(false, false);

    private final boolean checksumWithCompressedChunks;
    private final boolean streamIdentifier;

    FramedSnappyDialect(boolean z11, boolean z12) {
        this.streamIdentifier = z11;
        this.checksumWithCompressedChunks = z12;
    }

    public boolean hasStreamIdentifier() {
        return this.streamIdentifier;
    }

    public boolean usesChecksumWithCompressedChunks() {
        return this.checksumWithCompressedChunks;
    }
}
