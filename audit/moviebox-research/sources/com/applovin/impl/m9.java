package com.applovin.impl;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Charsets;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m9 implements z7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final z7.c f20633d = new z7.c() { // from class: com.applovin.impl.sz
        @Override // com.applovin.impl.z7.c
        public final z7 a(UUID uuid) {
            return m9.b(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f20634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaDrm f20635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f20636c;

    /* JADX INFO: compiled from: source.java */
    public static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    private m9(UUID uuid) {
        b1.a(uuid);
        b1.a(!t2.f23168b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f20634a = uuid;
        MediaDrm mediaDrm = new MediaDrm(a(uuid));
        this.f20635b = mediaDrm;
        this.f20636c = 1;
        if (t2.f23170d.equals(uuid) && e()) {
            a(mediaDrm);
        }
    }

    private static y6.b a(UUID uuid, List list) {
        if (!t2.f23170d.equals(uuid)) {
            return (y6.b) list.get(0);
        }
        if (xp.f24372a >= 28 && list.size() > 1) {
            y6.b bVar = (y6.b) list.get(0);
            int i11 = 0;
            int length = 0;
            while (true) {
                if (i11 >= list.size()) {
                    byte[] bArr = new byte[length];
                    int i12 = 0;
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        byte[] bArr2 = (byte[]) b1.a(((y6.b) list.get(i13)).f24563f);
                        int length2 = bArr2.length;
                        System.arraycopy(bArr2, 0, bArr, i12, length2);
                        i12 += length2;
                    }
                    return bVar.a(bArr);
                }
                y6.b bVar2 = (y6.b) list.get(i11);
                byte[] bArr3 = (byte[]) b1.a(bVar2.f24563f);
                if (!xp.a((Object) bVar2.f24562d, (Object) bVar.f24562d) || !xp.a((Object) bVar2.f24561c, (Object) bVar.f24561c) || !ji.a(bArr3)) {
                    break;
                }
                length += bArr3.length;
                i11++;
            }
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            y6.b bVar3 = (y6.b) list.get(i14);
            int iD = ji.d((byte[]) b1.a(bVar3.f24563f));
            int i15 = xp.f24372a;
            if (i15 < 23 && iD == 0) {
                return bVar3;
            }
            if (i15 >= 23 && iD == 1) {
                return bVar3;
            }
        }
        return (y6.b) list.get(0);
    }

    private static String a(UUID uuid, String str) {
        return (xp.f24372a < 26 && t2.f23169c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    private static UUID a(UUID uuid) {
        return (xp.f24372a >= 27 || !t2.f23169c.equals(uuid)) ? uuid : t2.f23168b;
    }

    private static void a(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(z7.b bVar, MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        bVar.a(this, bArr, i11, i12, bArr2);
    }

    private static byte[] a(UUID uuid, byte[] bArr) {
        return t2.f23169c.equals(uuid) ? i3.a(bArr) : bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ z7 b(UUID uuid) {
        try {
            return c(uuid);
        } catch (sp unused) {
            pc.b("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + InstructionFileId.DOT);
            return new g7();
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e A[RETURN] */
    private static byte[] b(UUID uuid, byte[] bArr) {
        byte[] bArrA;
        UUID uuid2 = t2.f23171e;
        if (uuid2.equals(uuid)) {
            byte[] bArrA2 = ji.a(bArr, uuid);
            if (bArrA2 != null) {
                bArr = bArrA2;
            }
            bArr = ji.a(uuid2, e(bArr));
        }
        if (xp.f24372a < 23 && t2.f23170d.equals(uuid)) {
            bArrA = ji.a(bArr, uuid);
            if (bArrA != null) {
                return bArrA;
            }
        } else if (uuid2.equals(uuid) && "Amazon".equals(xp.f24374c)) {
            String str = xp.f24375d;
            if ("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) {
                bArrA = ji.a(bArr, uuid);
                if (bArrA != null) {
                    return bArrA;
                }
            }
        }
        return bArr;
    }

    public static m9 c(UUID uuid) throws sp {
        try {
            return new m9(uuid);
        } catch (UnsupportedSchemeException e11) {
            throw new sp(1, e11);
        } catch (Exception e12) {
            throw new sp(2, e12);
        }
    }

    private static boolean e() {
        return "ASUS_Z00AD".equals(xp.f24375d);
    }

    private static byte[] e(byte[] bArr) {
        bh bhVar = new bh(bArr);
        int iM = bhVar.m();
        short sO = bhVar.o();
        short sO2 = bhVar.o();
        if (sO != 1 || sO2 != 1) {
            pc.c("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sO3 = bhVar.o();
        Charset charset = Charsets.UTF_16LE;
        String strA = bhVar.a(sO3, charset);
        if (strA.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strA.indexOf("</DATA>");
        if (iIndexOf == -1) {
            pc.d("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strA.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strA.substring(iIndexOf);
        int i11 = iM + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i11);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i11);
        byteBufferAllocate.putShort(sO);
        byteBufferAllocate.putShort(sO2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    @Override // com.applovin.impl.z7
    public z7.a a(byte[] bArr, List list, int i11, HashMap map) throws NotProvisionedException {
        y6.b bVarA;
        byte[] bArrB;
        String strA;
        if (list != null) {
            bVarA = a(this.f20634a, list);
            bArrB = b(this.f20634a, (byte[]) b1.a(bVarA.f24563f));
            strA = a(this.f20634a, bVarA.f24562d);
        } else {
            bVarA = null;
            bArrB = null;
            strA = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f20635b.getKeyRequest(bArr, bArrB, strA, i11, map);
        byte[] bArrA = a(this.f20634a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && bVarA != null && !TextUtils.isEmpty(bVarA.f24561c)) {
            defaultUrl = bVarA.f24561c;
        }
        return new z7.a(bArrA, defaultUrl, xp.f24372a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    public String a(String str) {
        return this.f20635b.getPropertyString(str);
    }

    @Override // com.applovin.impl.z7
    public synchronized void a() {
        int i11 = this.f20636c - 1;
        this.f20636c = i11;
        if (i11 == 0) {
            this.f20635b.release();
        }
    }

    @Override // com.applovin.impl.z7
    public void a(final z7.b bVar) {
        this.f20635b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.applovin.impl.tz
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                this.f23437a.a(bVar, mediaDrm, bArr, i11, i12, bArr2);
            }
        });
    }

    @Override // com.applovin.impl.z7
    public void a(byte[] bArr) throws DeniedByServerException {
        this.f20635b.provideProvisionResponse(bArr);
    }

    @Override // com.applovin.impl.z7
    public void a(byte[] bArr, byte[] bArr2) {
        this.f20635b.restoreKeys(bArr, bArr2);
    }

    @Override // com.applovin.impl.z7
    public boolean a(byte[] bArr, String str) {
        if (xp.f24372a >= 31) {
            return a.a(this.f20635b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f20634a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.applovin.impl.z7
    public z7.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f20635b.getProvisionRequest();
        return new z7.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.applovin.impl.z7
    public Map b(byte[] bArr) {
        return this.f20635b.queryKeyStatus(bArr);
    }

    @Override // com.applovin.impl.z7
    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (t2.f23169c.equals(this.f20634a)) {
            bArr2 = i3.b(bArr2);
        }
        return this.f20635b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.applovin.impl.z7
    public int c() {
        return 2;
    }

    @Override // com.applovin.impl.z7
    public void c(byte[] bArr) {
        this.f20635b.closeSession(bArr);
    }

    @Override // com.applovin.impl.z7
    public byte[] d() {
        return this.f20635b.openSession();
    }

    @Override // com.applovin.impl.z7
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public l9 d(byte[] bArr) {
        return new l9(a(this.f20634a), bArr, xp.f24372a < 21 && t2.f23170d.equals(this.f20634a) && "L3".equals(a("securityLevel")));
    }
}
