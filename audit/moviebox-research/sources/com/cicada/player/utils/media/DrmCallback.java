package com.cicada.player.utils.media;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface DrmCallback {
    byte[] requestKey(String str, byte[] bArr);

    byte[] requestProvision(String str, byte[] bArr);
}
