package androidx.media3.exoplayer.drm;

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
import androidx.media3.common.DrmInitData;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import e4.x3;
import i4.b0;
import i4.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l5.l;
import z3.c0;
import z3.o;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public final class h implements g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.c f10301d = new g.c() { // from class: i4.y
        @Override // androidx.media3.exoplayer.drm.g.c
        public final androidx.media3.exoplayer.drm.g a(UUID uuid) {
            return androidx.media3.exoplayer.drm.h.t(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UUID f10302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaDrm f10303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10304c;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.WEB_CRASH)
    public static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, x3 x3Var) {
            LogSessionId logSessionIdA = x3Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            b0.a(z3.a.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    public h(UUID uuid) throws UnsupportedSchemeException {
        z3.a.e(uuid);
        z3.a.b(!androidx.media3.common.j.f9252b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f10302a = uuid;
        MediaDrm mediaDrm = new MediaDrm(n(uuid));
        this.f10303b = mediaDrm;
        this.f10304c = 1;
        if (androidx.media3.common.j.f9254d.equals(uuid) && u()) {
            p(mediaDrm);
        }
    }

    public static byte[] i(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        int iU = c0Var.u();
        short sW = c0Var.w();
        short sW2 = c0Var.w();
        if (sW != 1 || sW2 != 1) {
            o.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sW3 = c0Var.w();
        Charset charset = com.google.common.base.c.f38167e;
        String strF = c0Var.F(sW3, charset);
        if (strF.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strF.indexOf("</DATA>");
        if (iIndexOf == -1) {
            o.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strF.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strF.substring(iIndexOf);
        int i11 = iU + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i11);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i11);
        byteBufferAllocate.putShort(sW);
        byteBufferAllocate.putShort(sW2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static String j(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        return (u0.f81838a < 33 || !"https://default.url".equals(str)) ? str : "";
    }

    public static byte[] k(UUID uuid, byte[] bArr) {
        return androidx.media3.common.j.f9253c.equals(uuid) ? i4.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005e A[RETURN] */
    public static byte[] l(UUID uuid, byte[] bArr) {
        byte[] bArrE;
        UUID uuid2 = androidx.media3.common.j.f9255e;
        if (uuid2.equals(uuid)) {
            byte[] bArrE2 = l.e(bArr, uuid);
            if (bArrE2 != null) {
                bArr = bArrE2;
            }
            bArr = l.a(uuid2, i(bArr));
        }
        if (u0.f81838a < 23 && androidx.media3.common.j.f9254d.equals(uuid)) {
            bArrE = l.e(bArr, uuid);
            if (bArrE != null) {
                return bArrE;
            }
        } else if (uuid2.equals(uuid) && "Amazon".equals(u0.f81840c)) {
            String str = u0.f81841d;
            if ("AFTB".equals(str) || "AFTS".equals(str) || "AFTM".equals(str) || "AFTT".equals(str)) {
                bArrE = l.e(bArr, uuid);
                if (bArrE != null) {
                    return bArrE;
                }
            }
        }
        return bArr;
    }

    public static String m(UUID uuid, String str) {
        return (u0.f81838a < 26 && androidx.media3.common.j.f9253c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    public static UUID n(UUID uuid) {
        return (u0.f81838a >= 27 || !androidx.media3.common.j.f9253c.equals(uuid)) ? uuid : androidx.media3.common.j.f9252b;
    }

    public static void p(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData r(UUID uuid, List<DrmInitData.SchemeData> list) {
        if (!androidx.media3.common.j.f9254d.equals(uuid)) {
            return list.get(0);
        }
        if (u0.f81838a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int i11 = 0;
            int length = 0;
            while (true) {
                if (i11 >= list.size()) {
                    byte[] bArr = new byte[length];
                    int i12 = 0;
                    for (int i13 = 0; i13 < list.size(); i13++) {
                        byte[] bArr2 = (byte[]) z3.a.e(list.get(i13).data);
                        int length2 = bArr2.length;
                        System.arraycopy(bArr2, 0, bArr, i12, length2);
                        i12 += length2;
                    }
                    return schemeData.copyWithData(bArr);
                }
                DrmInitData.SchemeData schemeData2 = list.get(i11);
                byte[] bArr3 = (byte[]) z3.a.e(schemeData2.data);
                if (!u0.c(schemeData2.mimeType, schemeData.mimeType) || !u0.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) || !l.c(bArr3)) {
                    break;
                }
                length += bArr3.length;
                i11++;
            }
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            DrmInitData.SchemeData schemeData3 = list.get(i14);
            int iG = l.g((byte[]) z3.a.e(schemeData3.data));
            int i15 = u0.f81838a;
            if (i15 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i15 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    public static /* synthetic */ g t(UUID uuid) {
        try {
            return v(uuid);
        } catch (UnsupportedDrmException unused) {
            o.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + InstructionFileId.DOT);
            return new e();
        }
    }

    public static boolean u() {
        return "ASUS_Z00AD".equals(u0.f81841d);
    }

    public static h v(UUID uuid) throws UnsupportedDrmException {
        try {
            return new h(uuid);
        } catch (UnsupportedSchemeException e11) {
            throw new UnsupportedDrmException(1, e11);
        } catch (Exception e12) {
            throw new UnsupportedDrmException(2, e12);
        }
    }

    @Override // androidx.media3.exoplayer.drm.g
    public int a() {
        return 2;
    }

    @Override // androidx.media3.exoplayer.drm.g
    public boolean c(byte[] bArr, String str) {
        if (u0.f81838a >= 31) {
            return a.a(this.f10303b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f10302a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void closeSession(byte[] bArr) {
        this.f10303b.closeSession(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.g
    @SuppressLint({"WrongConstant"})
    public g.a d(byte[] bArr, @Nullable List<DrmInitData.SchemeData> list, int i11, @Nullable HashMap<String, String> map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataR;
        byte[] bArrL;
        String strM;
        if (list != null) {
            schemeDataR = r(this.f10302a, list);
            bArrL = l(this.f10302a, (byte[]) z3.a.e(schemeDataR.data));
            strM = m(this.f10302a, schemeDataR.mimeType);
        } else {
            schemeDataR = null;
            bArrL = null;
            strM = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f10303b.getKeyRequest(bArr, bArrL, strM, i11, map);
        byte[] bArrK = k(this.f10302a, keyRequest.getData());
        String strJ = j(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strJ) && schemeDataR != null && !TextUtils.isEmpty(schemeDataR.licenseServerUrl)) {
            strJ = schemeDataR.licenseServerUrl;
        }
        return new g.a(bArrK, strJ, u0.f81838a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void e(byte[] bArr, x3 x3Var) {
        if (u0.f81838a >= 31) {
            try {
                a.b(this.f10303b, bArr, x3Var);
            } catch (UnsupportedOperationException unused) {
                o.h("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void f(@Nullable final g.b bVar) {
        this.f10303b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: i4.z
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                this.f67143a.s(bVar, mediaDrm, bArr, i11, i12, bArr2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.g
    public g.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f10303b.getProvisionRequest();
        return new g.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // androidx.media3.exoplayer.drm.g
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public w b(byte[] bArr) throws MediaCryptoException {
        return new w(n(this.f10302a), bArr, u0.f81838a < 21 && androidx.media3.common.j.f9254d.equals(this.f10302a) && "L3".equals(q("securityLevel")));
    }

    @Override // androidx.media3.exoplayer.drm.g
    public byte[] openSession() throws MediaDrmException {
        return this.f10303b.openSession();
    }

    @Override // androidx.media3.exoplayer.drm.g
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (androidx.media3.common.j.f9253c.equals(this.f10302a)) {
            bArr2 = i4.a.b(bArr2);
        }
        return this.f10303b.provideKeyResponse(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.f10303b.provideProvisionResponse(bArr);
    }

    public String q(String str) {
        return this.f10303b.getPropertyString(str);
    }

    @Override // androidx.media3.exoplayer.drm.g
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.f10303b.queryKeyStatus(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.g
    public synchronized void release() {
        int i11 = this.f10304c - 1;
        this.f10304c = i11;
        if (i11 == 0) {
            this.f10303b.release();
        }
    }

    @Override // androidx.media3.exoplayer.drm.g
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f10303b.restoreKeys(bArr, bArr2);
    }

    public final /* synthetic */ void s(g.b bVar, MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        bVar.a(this, bArr, i11, i12, bArr2);
    }
}
