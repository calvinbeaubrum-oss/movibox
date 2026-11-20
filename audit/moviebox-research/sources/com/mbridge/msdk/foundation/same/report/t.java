package com.mbridge.msdk.foundation.same.report;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class t extends com.mbridge.msdk.e.a.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f44922a = new AtomicInteger(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f44923b;

    public t(byte b11) {
        this.f44923b = b11;
    }

    private static void a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    private static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Exception unused) {
            }
        }
    }

    private void a(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            try {
                byteBuffer.clear();
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.mbridge.msdk.e.a.a.a
    public final com.mbridge.msdk.e.a.a.f a(com.mbridge.msdk.e.a.p<?> pVar, Map<String, String> map) throws IOException {
        ByteBuffer byteBuffer;
        OutputStream outputStream;
        ByteBuffer byteBufferWrap;
        com.mbridge.msdk.e.a.a.f fVar;
        byte[] byteArray;
        if (com.mbridge.msdk.e.a.f43738a) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SocketStack executeRequest ");
            sb2.append(pVar.i());
            sb2.append(":");
            sb2.append(pVar.f());
        }
        Socket socket = null;
        try {
            Socket socket2 = new Socket(pVar.i(), pVar.f());
            try {
                socket2.setSoTimeout(pVar.s());
                outputStream = socket2.getOutputStream();
                try {
                    if (outputStream == null) {
                        throw new IOException("create outputStream exception");
                    }
                    byteBufferWrap = ByteBuffer.wrap(new byte[8]);
                    try {
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        byteBufferWrap.order(byteOrder);
                        byteBufferWrap.put(this.f44923b);
                        byte[] bArrO = pVar.o();
                        if (bArrO == null || bArrO.length == 0) {
                            byteBufferWrap.put((byte) 1);
                        } else {
                            byteBufferWrap.put((byte) 3);
                        }
                        byteBufferWrap.putShort((short) f44922a.getAndIncrement());
                        if (bArrO == null || bArrO.length == 0) {
                            byteBufferWrap.putInt(0);
                            outputStream.write(byteBufferWrap.array());
                        } else {
                            if (bArrO.length == 0) {
                                byteArray = null;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                                gZIPOutputStream.write(bArrO);
                                gZIPOutputStream.close();
                                byteArray = byteArrayOutputStream.toByteArray();
                            }
                            byteBufferWrap.putInt(byteArray == null ? 0 : byteArray.length);
                            outputStream.write(byteBufferWrap.array());
                            outputStream.write(byteArray);
                        }
                        outputStream.flush();
                        byte[] bArr = new byte[8];
                        socket2.getInputStream().read(bArr, 0, 8);
                        ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr);
                        try {
                            byteBufferWrap2.order(byteOrder);
                            int i11 = byteBufferWrap2.getInt(4);
                            boolean z11 = bArr[1] == 2;
                            byte[] bArr2 = new byte[i11];
                            new DataInputStream(socket2.getInputStream()).readFully(bArr2);
                            if (z11 && i11 == 0) {
                                fVar = new com.mbridge.msdk.e.a.a.f(204, new ArrayList(), i11, null);
                            } else {
                                if (i11 < 1 || bArr2[0] != 1) {
                                    com.mbridge.msdk.e.a.a.f fVar2 = new com.mbridge.msdk.e.a.a.f(500, new ArrayList(), 0, null);
                                    a(outputStream);
                                    a(socket2);
                                    a(byteBufferWrap);
                                    a(byteBufferWrap2);
                                    return fVar2;
                                }
                                fVar = new com.mbridge.msdk.e.a.a.f(200, new ArrayList(), i11, null);
                            }
                            a(outputStream);
                            a(socket2);
                            a(byteBufferWrap);
                            a(byteBufferWrap2);
                            return fVar;
                        } catch (Throwable th2) {
                            byteBuffer = byteBufferWrap2;
                            th = th2;
                            socket = socket2;
                            try {
                                throw new IOException(th);
                            } catch (Throwable th3) {
                                a(outputStream);
                                a(socket);
                                a(byteBufferWrap);
                                a(byteBuffer);
                                throw th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        byteBuffer = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    byteBufferWrap = null;
                    socket = socket2;
                    byteBuffer = byteBufferWrap;
                    throw new IOException(th);
                }
            } catch (Throwable th6) {
                th = th6;
                outputStream = null;
                byteBufferWrap = null;
            }
        } catch (Throwable th7) {
            th = th7;
            byteBuffer = null;
            outputStream = null;
            byteBufferWrap = null;
        }
    }
}
