package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import bh.l;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import i4.b0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import qg.u1;
import sg.w;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(18)
public final class h implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.c f33179d = new g.c() { // from class: sg.x
        @Override // com.google.android.exoplayer2.drm.g.c
        public final com.google.android.exoplayer2.drm.g a(UUID uuid) {
            return com.google.android.exoplayer2.drm.h.s(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f33180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f33181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f33182c;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, u1 u1Var) {
            LogSessionId logSessionIdA = u1Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            b0.a(com.google.android.exoplayer2.util.a.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    public h(UUID uuid) throws UnsupportedSchemeException {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.h.f33254b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f33180a = uuid;
        MediaDrm mediaDrm = new MediaDrm(m(uuid));
        this.f33181b = mediaDrm;
        this.f33182c = 1;
        if (com.google.android.exoplayer2.h.f33256d.equals(uuid) && t()) {
            o(mediaDrm);
        }
    }

    public static byte[] i(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        int iQ = c0Var.q();
        short s11 = c0Var.s();
        short s12 = c0Var.s();
        if (s11 != 1 || s12 != 1) {
            s.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short s13 = c0Var.s();
        Charset charset = com.google.common.base.c.f38167e;
        String strB = c0Var.B(s13, charset);
        if (strB.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strB.indexOf("</DATA>");
        if (iIndexOf == -1) {
            s.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strB.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strB.substring(iIndexOf);
        int i11 = iQ + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i11);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i11);
        byteBufferAllocate.putShort(s11);
        byteBufferAllocate.putShort(s12);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static byte[] j(UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.h.f33255c.equals(uuid) ? sg.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e A[RETURN] */
    public static byte[] k(UUID uuid, byte[] bArr) {
        byte[] bArrE;
        UUID uuid2 = com.google.android.exoplayer2.h.f33257e;
        if (uuid2.equals(uuid)) {
            byte[] bArrE2 = l.e(bArr, uuid);
            if (bArrE2 != null) {
                bArr = bArrE2;
            }
            bArr = l.a(uuid2, i(bArr));
        }
        if (o0.f35608a < 23 && com.google.android.exoplayer2.h.f33256d.equals(uuid)) {
            bArrE = l.e(bArr, uuid);
            if (bArrE != null) {
                return bArrE;
            }
        } else if (uuid2.equals(uuid) && "Amazon".equals(o0.f35610c)) {
            String str = o0.f35611d;
            if ("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) {
                bArrE = l.e(bArr, uuid);
                if (bArrE != null) {
                    return bArrE;
                }
            }
        }
        return bArr;
    }

    public static String l(UUID uuid, String str) {
        return (o0.f35608a < 26 && com.google.android.exoplayer2.h.f33255c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    public static UUID m(UUID uuid) {
        return (o0.f35608a >= 27 || !com.google.android.exoplayer2.h.f33255c.equals(uuid)) ? uuid : com.google.android.exoplayer2.h.f33254b;
    }

    public static void o(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData q(UUID uuid, List<DrmInitData.SchemeData> list) {
        if (!com.google.android.exoplayer2.h.f33256d.equals(uuid)) {
            return list.get(0);
        }
        if (o0.f35608a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i11 = 0;
            int length = 0;
            while (true) {
                if (i11 >= list.size()) {
                    byte[] bArr = new byte[length];
                    int i12 = 0;
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        byte[] bArr2 = (byte[]) com.google.android.exoplayer2.util.a.e(list.get(i13).data);
                        int length2 = bArr2.length;
                        System.arraycopy(bArr2, 0, bArr, i12, length2);
                        i12 += length2;
                    }
                    return schemeData.copyWithData(bArr);
                }
                DrmInitData.SchemeData schemeData2 = list.get(i11);
                byte[] bArr3 = (byte[]) com.google.android.exoplayer2.util.a.e(schemeData2.data);
                if (!o0.c(schemeData2.mimeType, schemeData.mimeType) || !o0.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !l.c(bArr3)) {
                    break;
                }
                length += bArr3.length;
                i11++;
            }
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            DrmInitData.SchemeData schemeData3 = list.get(i14);
            int iG = l.g((byte[]) com.google.android.exoplayer2.util.a.e(schemeData3.data));
            int i15 = o0.f35608a;
            if (i15 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i15 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    public static /* synthetic */ g s(UUID uuid) {
        try {
            return u(uuid);
        } catch (UnsupportedDrmException unused) {
            s.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + InstructionFileId.DOT);
            return new e();
        }
    }

    public static boolean t() {
        return "ASUS_Z00AD".equals(o0.f35611d);
    }

    public static h u(UUID uuid) throws UnsupportedDrmException {
        try {
            return new h(uuid);
        } catch (UnsupportedSchemeException e11) {
            throw new UnsupportedDrmException(1, e11);
        } catch (Exception e12) {
            throw new UnsupportedDrmException(2, e12);
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public int a() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.g
    public boolean c(byte[] bArr, String str) {
        if (o0.f35608a >= 31) {
            return a.a(this.f33181b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f33180a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void closeSession(byte[] bArr) {
        this.f33181b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    @SuppressLint({"WrongConstant"})
    public g.a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataQ;
        byte[] bArrK;
        String strL;
        if (list != null) {
            schemeDataQ = q(this.f33180a, list);
            bArrK = k(this.f33180a, (byte[]) com.google.android.exoplayer2.util.a.e(schemeDataQ.data));
            strL = l(this.f33180a, schemeDataQ.mimeType);
        } else {
            schemeDataQ = null;
            bArrK = null;
            strL = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f33181b.getKeyRequest(bArr, bArrK, strL, i11, map);
        byte[] bArrJ = j(this.f33180a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeDataQ != null && !TextUtils.isEmpty(schemeDataQ.licenseServerUrl)) {
            defaultUrl = schemeDataQ.licenseServerUrl;
        }
        return new g.a(bArrJ, defaultUrl, o0.f35608a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void e(@Nullable final g.b bVar) {
        this.f33181b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: sg.y
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                this.f76353a.r(bVar, mediaDrm, bArr, i11, i12, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void f(byte[] bArr, u1 u1Var) {
        if (o0.f35608a >= 31) {
            try {
                a.b(this.f33181b, bArr, u1Var);
            } catch (UnsupportedOperationException unused) {
                s.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public g.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f33181b.getProvisionRequest();
        return new g.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.g
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public w b(byte[] bArr) throws MediaCryptoException {
        return new w(m(this.f33180a), bArr, o0.f35608a < 21 && com.google.android.exoplayer2.h.f33256d.equals(this.f33180a) && "L3".equals(p("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.g
    public byte[] openSession() throws MediaDrmException {
        return this.f33181b.openSession();
    }

    public String p(String str) {
        return this.f33181b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (com.google.android.exoplayer2.h.f33255c.equals(this.f33180a)) {
            bArr2 = sg.a.b(bArr2);
        }
        return this.f33181b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.f33181b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f33181b.queryKeyStatus(bArr);
    }

    public final /* synthetic */ void r(g.b bVar, MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        bVar.a(this, bArr, i11, i12, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.g
    public synchronized void release() {
        int i11 = this.f33182c - 1;
        this.f33182c = i11;
        if (i11 == 0) {
            this.f33181b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f33181b.restoreKeys(bArr, bArr2);
    }
}
