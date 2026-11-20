package com.mbridge.msdk.thrid.okhttp.internal.ws;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class WebSocketReader {
    boolean closed;
    final FrameCallback frameCallback;
    long frameLength;
    final boolean isClient;
    boolean isControlFrame;
    boolean isFinalFrame;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    int opcode;
    final BufferedSource source;
    private final Buffer controlFrameBuffer = new Buffer();
    private final Buffer messageFrameBuffer = new Buffer();

    /* JADX INFO: compiled from: source.java */
    public interface FrameCallback {
        void onReadClose(int i11, String str);

        void onReadMessage(ByteString byteString) throws IOException;

        void onReadMessage(String str) throws IOException;

        void onReadPing(ByteString byteString);

        void onReadPong(ByteString byteString);
    }

    public WebSocketReader(boolean z11, BufferedSource bufferedSource, FrameCallback frameCallback) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        if (frameCallback == null) {
            throw new NullPointerException("frameCallback == null");
        }
        this.isClient = z11;
        this.source = bufferedSource;
        this.frameCallback = frameCallback;
        this.maskKey = z11 ? null : new byte[4];
        this.maskCursor = z11 ? null : new Buffer.UnsafeCursor();
    }

    private void readControlFrame() throws IOException {
        short s11;
        String utf8;
        long j11 = this.frameLength;
        if (j11 > 0) {
            this.source.readFully(this.controlFrameBuffer, j11);
            if (!this.isClient) {
                this.controlFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        switch (this.opcode) {
            case 8:
                long size = this.controlFrameBuffer.size();
                if (size == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (size != 0) {
                    s11 = this.controlFrameBuffer.readShort();
                    utf8 = this.controlFrameBuffer.readUtf8();
                    String strCloseCodeExceptionMessage = WebSocketProtocol.closeCodeExceptionMessage(s11);
                    if (strCloseCodeExceptionMessage != null) {
                        throw new ProtocolException(strCloseCodeExceptionMessage);
                    }
                } else {
                    s11 = 1005;
                    utf8 = "";
                }
                this.frameCallback.onReadClose(s11, utf8);
                this.closed = true;
                return;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.readByteString());
                return;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.readByteString());
                return;
            default:
                throw new ProtocolException("Unknown control opcode: " + Integer.toHexString(this.opcode));
        }
    }

    private void readHeader() throws IOException {
        if (this.closed) {
            throw new IOException("closed");
        }
        long jTimeoutNanos = this.source.timeout().timeoutNanos();
        this.source.timeout().clearTimeout();
        try {
            byte b11 = this.source.readByte();
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            this.opcode = b11 & Ascii.SI;
            boolean z11 = (b11 & 128) != 0;
            this.isFinalFrame = z11;
            boolean z12 = (b11 & 8) != 0;
            this.isControlFrame = z12;
            if (z12 && !z11) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z13 = (b11 & 64) != 0;
            boolean z14 = (b11 & 32) != 0;
            boolean z15 = (b11 & Ascii.DLE) != 0;
            if (z13 || z14 || z15) {
                throw new ProtocolException("Reserved flags are unsupported.");
            }
            byte b12 = this.source.readByte();
            boolean z16 = (b12 & 128) != 0;
            if (z16 == this.isClient) {
                throw new ProtocolException(this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.");
            }
            long j11 = b12 & Ascii.DEL;
            this.frameLength = j11;
            if (j11 == 126) {
                this.frameLength = ((long) this.source.readShort()) & okhttp3.internal.ws.WebSocketProtocol.PAYLOAD_SHORT_MAX;
            } else if (j11 == 127) {
                long j12 = this.source.readLong();
                this.frameLength = j12;
                if (j12 < 0) {
                    throw new ProtocolException("Frame length 0x" + Long.toHexString(this.frameLength) + " > 0x7FFFFFFFFFFFFFFF");
                }
            }
            if (this.isControlFrame && this.frameLength > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z16) {
                this.source.readFully(this.maskKey);
            }
        } catch (Throwable th2) {
            this.source.timeout().timeout(jTimeoutNanos, TimeUnit.NANOSECONDS);
            throw th2;
        }
    }

    private void readMessage() throws IOException {
        while (!this.closed) {
            long j11 = this.frameLength;
            if (j11 > 0) {
                this.source.readFully(this.messageFrameBuffer, j11);
                if (!this.isClient) {
                    this.messageFrameBuffer.readAndWriteUnsafe(this.maskCursor);
                    this.maskCursor.seek(this.messageFrameBuffer.size() - this.frameLength);
                    WebSocketProtocol.toggleMask(this.maskCursor, this.maskKey);
                    this.maskCursor.close();
                }
            }
            if (this.isFinalFrame) {
                return;
            }
            readUntilNonControlFrame();
            if (this.opcode != 0) {
                throw new ProtocolException("Expected continuation opcode. Got: " + Integer.toHexString(this.opcode));
            }
        }
        throw new IOException("closed");
    }

    private void readMessageFrame() throws IOException {
        int i11 = this.opcode;
        if (i11 != 1 && i11 != 2) {
            throw new ProtocolException("Unknown opcode: " + Integer.toHexString(i11));
        }
        readMessage();
        if (i11 == 1) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readUtf8());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.readByteString());
        }
    }

    private void readUntilNonControlFrame() throws IOException {
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                return;
            } else {
                readControlFrame();
            }
        }
    }

    public void processNextFrame() throws IOException {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
