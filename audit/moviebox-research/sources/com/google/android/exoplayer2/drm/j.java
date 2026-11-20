package com.google.android.exoplayer2.drm;

import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface j {
    byte[] a(UUID uuid, g.d dVar) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, g.a aVar) throws MediaDrmCallbackException;
}
