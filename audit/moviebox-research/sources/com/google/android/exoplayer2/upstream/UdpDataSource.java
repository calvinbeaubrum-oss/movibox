package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class UdpDataSource extends f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f35245e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f35246f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DatagramPacket f35247g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Uri f35248h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public DatagramSocket f35249i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public MulticastSocket f35250j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public InetAddress f35251k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f35252l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f35253m;

    /* JADX INFO: compiled from: source.java */
    public static final class UdpDataSourceException extends DataSourceException {
        public UdpDataSourceException(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public UdpDataSource() {
        this(2000);
    }

    public UdpDataSource(int i11) {
        this(i11, 8000);
    }

    public UdpDataSource(int i11, int i12) {
        super(true);
        this.f35245e = i12;
        byte[] bArr = new byte[i11];
        this.f35246f = bArr;
        this.f35247g = new DatagramPacket(bArr, 0, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public long a(n nVar) throws UdpDataSourceException {
        Uri uri = nVar.f35422a;
        this.f35248h = uri;
        String str = (String) com.google.android.exoplayer2.util.a.e(uri.getHost());
        int port = this.f35248h.getPort();
        j(nVar);
        try {
            this.f35251k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f35251k, port);
            if (this.f35251k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f35250j = multicastSocket;
                multicastSocket.joinGroup(this.f35251k);
                this.f35249i = this.f35250j;
            } else {
                this.f35249i = new DatagramSocket(inetSocketAddress);
            }
            this.f35249i.setSoTimeout(this.f35245e);
            this.f35252l = true;
            k(nVar);
            return -1L;
        } catch (IOException e11) {
            throw new UdpDataSourceException(e11, 2001);
        } catch (SecurityException e12) {
            throw new UdpDataSourceException(e12, 2006);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.k
    public void close() {
        this.f35248h = null;
        MulticastSocket multicastSocket = this.f35250j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) com.google.android.exoplayer2.util.a.e(this.f35251k));
            } catch (IOException unused) {
            }
            this.f35250j = null;
        }
        DatagramSocket datagramSocket = this.f35249i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f35249i = null;
        }
        this.f35251k = null;
        this.f35253m = 0;
        if (this.f35252l) {
            this.f35252l = false;
            i();
        }
    }

    public int d() {
        DatagramSocket datagramSocket = this.f35249i;
        if (datagramSocket == null) {
            return -1;
        }
        return datagramSocket.getLocalPort();
    }

    @Override // com.google.android.exoplayer2.upstream.k
    @Nullable
    public Uri getUri() {
        return this.f35248h;
    }

    @Override // com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) throws UdpDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.f35253m == 0) {
            try {
                ((DatagramSocket) com.google.android.exoplayer2.util.a.e(this.f35249i)).receive(this.f35247g);
                int length = this.f35247g.getLength();
                this.f35253m = length;
                h(length);
            } catch (SocketTimeoutException e11) {
                throw new UdpDataSourceException(e11, 2002);
            } catch (IOException e12) {
                throw new UdpDataSourceException(e12, 2001);
            }
        }
        int length2 = this.f35247g.getLength();
        int i13 = this.f35253m;
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f35246f, length2 - i13, bArr, i11, iMin);
        this.f35253m -= iMin;
        return iMin;
    }
}
