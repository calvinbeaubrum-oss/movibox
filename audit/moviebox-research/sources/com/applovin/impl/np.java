package com.applovin.impl;

import android.net.Uri;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class np extends a2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f21402e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final byte[] f21403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DatagramPacket f21404g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Uri f21405h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DatagramSocket f21406i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MulticastSocket f21407j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private InetAddress f21408k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private InetSocketAddress f21409l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f21410m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f21411n;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends j5 {
        public a(Throwable th2, int i11) {
            super(th2, i11);
        }
    }

    public np() {
        this(2000);
    }

    public np(int i11) {
        this(i11, 8000);
    }

    public np(int i11, int i12) {
        super(true);
        this.f21402e = i12;
        byte[] bArr = new byte[i11];
        this.f21403f = bArr;
        this.f21404g = new DatagramPacket(bArr, 0, i11);
    }

    @Override // com.applovin.impl.g5
    public int a(byte[] bArr, int i11, int i12) throws a {
        if (i12 == 0) {
            return 0;
        }
        if (this.f21411n == 0) {
            try {
                this.f21406i.receive(this.f21404g);
                int length = this.f21404g.getLength();
                this.f21411n = length;
                d(length);
            } catch (SocketTimeoutException e11) {
                throw new a(e11, 2002);
            } catch (IOException e12) {
                throw new a(e12, 2001);
            }
        }
        int length2 = this.f21404g.getLength();
        int i13 = this.f21411n;
        int iMin = Math.min(i13, i12);
        System.arraycopy(this.f21403f, length2 - i13, bArr, i11, iMin);
        this.f21411n -= iMin;
        return iMin;
    }

    @Override // com.applovin.impl.i5
    public long a(l5 l5Var) throws a {
        Uri uri = l5Var.f20336a;
        this.f21405h = uri;
        String host = uri.getHost();
        int port = this.f21405h.getPort();
        b(l5Var);
        try {
            this.f21408k = InetAddress.getByName(host);
            this.f21409l = new InetSocketAddress(this.f21408k, port);
            if (this.f21408k.isMulticastAddress()) {
                MulticastSocket multicastSocket = new MulticastSocket(this.f21409l);
                this.f21407j = multicastSocket;
                multicastSocket.joinGroup(this.f21408k);
                this.f21406i = this.f21407j;
            } else {
                this.f21406i = new DatagramSocket(this.f21409l);
            }
            this.f21406i.setSoTimeout(this.f21402e);
            this.f21410m = true;
            c(l5Var);
            return -1L;
        } catch (IOException e11) {
            throw new a(e11, 2001);
        } catch (SecurityException e12) {
            throw new a(e12, 2006);
        }
    }

    @Override // com.applovin.impl.i5
    public Uri c() {
        return this.f21405h;
    }

    @Override // com.applovin.impl.i5
    public void close() {
        this.f21405h = null;
        MulticastSocket multicastSocket = this.f21407j;
        if (multicastSocket != null) {
            try {
                multicastSocket.leaveGroup(this.f21408k);
            } catch (IOException unused) {
            }
            this.f21407j = null;
        }
        DatagramSocket datagramSocket = this.f21406i;
        if (datagramSocket != null) {
            datagramSocket.close();
            this.f21406i = null;
        }
        this.f21408k = null;
        this.f21409l = null;
        this.f21411n = 0;
        if (this.f21410m) {
            this.f21410m = false;
            g();
        }
    }
}
