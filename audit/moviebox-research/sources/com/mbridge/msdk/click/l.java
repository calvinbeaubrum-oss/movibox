package com.mbridge.msdk.click;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile AtomicInteger f43164a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.c.g f43165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f43167d = 9377;

    public l() {
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        this.f43165b = gVarB;
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            this.f43165b = com.mbridge.msdk.c.i.a();
        }
    }

    private com.mbridge.msdk.click.entity.a a(String str, String str2) {
        OutputStream outputStream;
        int length;
        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
        Socket socket = null;
        byte[] byteArray = null;
        try {
            try {
                Socket socket2 = new Socket(this.f43166c, this.f43167d);
                try {
                    socket2.setSoTimeout(DefaultLoadControl.DEFAULT_MIN_BUFFER_MS);
                    outputStream = socket2.getOutputStream();
                    try {
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        byteBufferWrap.order(byteOrder);
                        byteBufferWrap.put((byte) 2);
                        byteBufferWrap.put((byte) 3);
                        byteBufferWrap.putShort((short) f43164a.getAndIncrement());
                        if (TextUtils.isEmpty(str2)) {
                            byteBufferWrap.putInt(0);
                            outputStream.write(byteBufferWrap.array());
                            length = 0;
                        } else {
                            if (!TextUtils.isEmpty(str2)) {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(str2.getBytes());
                                gZIPOutputStream.close();
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            length = byteArray.length;
                            byteBufferWrap.putInt(length);
                            outputStream.write(byteBufferWrap.array());
                            outputStream.write(byteArray);
                        }
                        outputStream.flush();
                        ad.a("SocketSpider", "Socket Request : header : " + Arrays.toString(byteBufferWrap.array()) + " length : " + length);
                        InputStream inputStream = socket2.getInputStream();
                        byte[] bArr = new byte[8];
                        inputStream.read(bArr, 0, 8);
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                        byteBufferWrap2.order(byteOrder);
                        int i11 = byteBufferWrap2.getInt(4);
                        byte b11 = bArr[1];
                        boolean z11 = b11 == 3;
                        boolean z12 = b11 == 2;
                        ad.b("SocketSpider", "Socket Response : header : " + Arrays.toString(bArr) + " length : " + i11 + " isGzip : " + z11);
                        byte[] bArr2 = new byte[i11];
                        new DataInputStream(socket2.getInputStream()).readFully(bArr2);
                        if (!z11 && i11 > 2 && ((bArr2[0] << 8) | (bArr2[1] & 255)) == 8075) {
                            z11 = true;
                        }
                        if (z12 && i11 == 0) {
                            aVar.f43126f = 200;
                            aVar.f43127g = str;
                            aVar.f43125e = 0;
                            try {
                                socket2.close();
                                outputStream.close();
                            } catch (Exception e11) {
                                ad.b("SocketSpider", e11.getMessage());
                            }
                            return aVar;
                        }
                        if (i11 < 1) {
                            aVar.f43126f = 200;
                            aVar.f43127g = str;
                            aVar.f43125e = 0;
                            try {
                                socket2.close();
                                outputStream.close();
                            } catch (Exception e12) {
                                ad.b("SocketSpider", e12.getMessage());
                            }
                            return aVar;
                        }
                        try {
                            String strA = z11 ? a(bArr2) : new String(bArr2);
                            if (!TextUtils.isEmpty(strA)) {
                                aVar.f43126f = 200;
                                aVar.f43127g = str;
                                aVar.f43125e = 0;
                                try {
                                    JSONObject jSONObjectOptJSONObject = new JSONObject(strA).optJSONObject("data");
                                    if (jSONObjectOptJSONObject != null) {
                                        String strOptString = jSONObjectOptJSONObject.optString(RequestParameters.SUBRESOURCE_LOCATION);
                                        if (!TextUtils.isEmpty(strOptString)) {
                                            aVar.f43126f = 302;
                                            aVar.f43121a = strOptString;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    ad.b("SocketSpider", th2.getMessage());
                                }
                                try {
                                    socket2.close();
                                    outputStream.close();
                                } catch (Exception e13) {
                                    ad.b("SocketSpider", e13.getMessage());
                                }
                                return aVar;
                            }
                        } catch (Throwable th3) {
                            ad.b("SocketSpider", th3.getMessage());
                            aVar.f43128h = th3.getMessage();
                        }
                        inputStream.close();
                        socket2.close();
                        outputStream.close();
                        return aVar;
                    } catch (Throwable th4) {
                        th = th4;
                        socket = socket2;
                        try {
                            ad.a("SocketSpider", "Socket exception: " + th.getMessage());
                            aVar.f43128h = th.getMessage();
                            if (socket != null) {
                                socket.close();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                            }
                            return aVar;
                        } catch (Throwable th5) {
                            if (socket == null) {
                                throw th5;
                            }
                            try {
                                socket.close();
                                if (outputStream == null) {
                                    throw th5;
                                }
                                outputStream.close();
                                throw th5;
                            } catch (Exception e14) {
                                ad.b("SocketSpider", e14.getMessage());
                                throw th5;
                            }
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    outputStream = null;
                }
            } catch (Throwable th7) {
                th = th7;
                outputStream = null;
            }
        } catch (Exception e15) {
            ad.b("SocketSpider", e15.getMessage());
        }
    }

    private String a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[1024];
        while (true) {
            int i11 = gZIPInputStream.read(bArr2, 0, 1024);
            if (i11 <= 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toString();
            }
            byteArrayOutputStream.write(bArr2, 0, i11);
        }
    }

    private JSONObject b(String str, CampaignEx campaignEx, boolean z11, boolean z12) {
        JSONObject jSONObject = new JSONObject();
        try {
            Uri uri = Uri.parse(str);
            if (uri != null) {
                String host = uri.getHost();
                String path = uri.getPath();
                String encodedQuery = uri.getEncodedQuery();
                this.f43166c = host;
                jSONObject.put("uri", AgentPageJsBridge.HTTPS + host + path);
                jSONObject.put("data", encodedQuery);
            }
        } catch (Throwable th2) {
            ad.b("SocketSpider", th2.getMessage());
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!z11 && !z12) {
                jSONObject2.put("User-Agent", z.g());
            }
            if (campaignEx != null) {
                if (z11 && campaignEx.getcUA() == 1) {
                    jSONObject2.put("User-Agent", z.g());
                }
                if (z12 && campaignEx.getImpUA() == 1) {
                    jSONObject2.put("User-Agent", z.g());
                }
            } else {
                jSONObject2.put("User-Agent", z.g());
            }
            jSONObject2.put("Accept-Encoding", "gzip");
            if (this.f43165b.aI() && !TextUtils.isEmpty(str)) {
                jSONObject2.put(RequestParameters.SUBRESOURCE_REFERER, str);
            }
            jSONObject.put("header", jSONObject2);
        } catch (Throwable th3) {
            ad.b("SocketSpider", th3.getMessage());
        }
        return jSONObject;
    }

    public final com.mbridge.msdk.click.entity.a a(String str, CampaignEx campaignEx, boolean z11, boolean z12) {
        com.mbridge.msdk.click.entity.a aVar = new com.mbridge.msdk.click.entity.a();
        aVar.f43127g = str;
        if (TextUtils.isEmpty(str)) {
            aVar.f43128h = "request url can not null.";
            return aVar;
        }
        String strReplace = str.replace(" ", "%20");
        JSONObject jSONObjectB = b(strReplace, campaignEx, z11, z12);
        if (jSONObjectB.length() == 0) {
            aVar.f43128h = "request content generation failed.";
            return aVar;
        }
        if (TextUtils.isEmpty(jSONObjectB.optString("uri"))) {
            aVar.f43128h = "request url parse error.";
            return aVar;
        }
        if (campaignEx != null) {
            int trackingTcpPort = campaignEx.getTrackingTcpPort();
            if (trackingTcpPort == 0) {
                trackingTcpPort = 9377;
            }
            this.f43167d = trackingTcpPort;
        }
        if (!TextUtils.isEmpty(this.f43166c)) {
            return a(strReplace, jSONObjectB.toString());
        }
        aVar.f43128h = "request url parse error.";
        return aVar;
    }
}
