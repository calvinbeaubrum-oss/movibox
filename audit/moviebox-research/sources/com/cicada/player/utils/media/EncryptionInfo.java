package com.cicada.player.utils.media;

import com.cicada.player.utils.NativeUsed;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@NativeUsed
public class EncryptionInfo {
    public String scheme;
    public int crypt_byte_block = 0;
    public int skip_byte_block = 0;
    public byte[] key_id = null;

    /* JADX INFO: renamed from: iv, reason: collision with root package name */
    public byte[] f28855iv = null;
    public List<SubsampleEncryptionInfo> subsamples = null;

    public void setIv(byte[] bArr) {
        this.f28855iv = bArr;
    }

    public void setKeyId(byte[] bArr) {
        this.key_id = bArr;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSubsamples(Object obj) {
        this.subsamples = (List) obj;
    }
}
