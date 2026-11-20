package org.apache.commons.compress.archivers.dump;

import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class UnsupportedCompressionAlgorithmException extends DumpArchiveException {
    private static final long serialVersionUID = 1;

    public UnsupportedCompressionAlgorithmException() {
        super("this file uses an unsupported compression algorithm.");
    }

    public UnsupportedCompressionAlgorithmException(String str) {
        super("this file uses an unsupported compression algorithm: " + str + InstructionFileId.DOT);
    }
}
