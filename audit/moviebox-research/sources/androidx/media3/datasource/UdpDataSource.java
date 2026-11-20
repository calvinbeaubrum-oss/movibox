package androidx.media3.datasource;

import android.net.Uri;
import androidx.annotation.Nullable;
import c4.g;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class UdpDataSource extends c4.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9575e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f9576f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final DatagramPacket f9577g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    public Uri f9578h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    public DatagramSocket f9579i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    public MulticastSocket f9580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public InetAddress f9581k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f9582l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f9583m;

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
        this.f9575e = i12;
        byte[] bArr = new byte[i11];
        this.f9576f = bArr;
        this.f9577g = new DatagramPacket(bArr, 0, i11);
    }

    @Override // androidx.media3.datasource.a
    public long a(g gVar) throws UdpDataSourceException {
        Uri uri = gVar.f14598a;
        this.f9578h = uri;
        String str = (String) z3.a.e(uri.getHost());
        int port = this.f9578h.getPort();
        f(gVar);
        try {
            this.f9581k = InetAddress.getByName(str);
            InetSocketAddress inetSocketAddress = new InetSocketAddress(this.f9581k, port);
            if (this.f9581k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(inetSocketAddress);
                this.f9580j = multicastSocket;
                multicastSocket.joinGroup(this.f9581k);
                this.f9579i = this.f9580j;
            } else {
                this.f9579i = new DatagramSocket(inetSocketAddress);
            }
            this.f9579i.setSoTimeout(this.f9575e);
            this.f9582l = true;
            g(gVar);
            return -1L;
        } catch (IOException e11) {
            throw new UdpDataSourceException(e11, 2001);
        } catch (SecurityException e12) {
            throw new UdpDataSourceException(e12, 2006);
        }
    }

    @Override // androidx.media3.datasource.a
    public void close() {
        this.f9578h = null;
        MulticastSocket multicastSocket = this.f9580j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup((InetAddress) z3.a.e(this.f9581k));
            } catch (IOException unused) {
            }
            this.f9580j = null;
        }
        DatagramSocket datagramSocket = this.f9579i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f9579i = null;
        }
        this.f9581k = null;
        this.f9583m = 0;
        if (this.f9582l) {
            this.f9582l = false;
            e();
        }
    }

    @Override // androidx.media3.datasource.a
    @Nullable
    public Uri getUri() {
        return this.f9578h;
    }

    @Override // androidx.media3.common.l
    public int read(byte[] bArr, int i11, int i12) throws UdpDataSourceException {
        if (i12 == 0) {
            return 0;
        }
        if (this.f9583m == 0) {
            try {
                ((DatagramSocket) z3.a.e(this.f9579i)).receive(this.f9577g);
                int length = this.f9577g.getLength();
                this.f9583m = length;
                d(length);
            } catch (SocketTimeoutException e11) {
                throw new UdpDataSourceException(e11, 2002);
            } catch (IOException e12) {
                throw new UdpDataSourceException(e12, 2001);
            }
        }
        int length2 = this.f9577g.getLength();
        int i13 = this.f9583m;
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f9576f, length2 - i13, bArr, i11, iMin);
        this.f9583m -= iMin;
        return iMin;
    }
}
