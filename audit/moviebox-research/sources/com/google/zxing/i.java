package com.google.zxing;

import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface i {
    j a(b bVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    j b(b bVar) throws NotFoundException, ChecksumException, FormatException;

    void reset();
}
