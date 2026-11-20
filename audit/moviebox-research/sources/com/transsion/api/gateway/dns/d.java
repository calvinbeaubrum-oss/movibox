package com.transsion.api.gateway.dns;

import java.math.BigInteger;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f50734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f50736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f50737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f50738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BigInteger f50739g;

    public d(d dVar) {
        this.f50735c = 0;
        this.f50736d = 0;
        this.f50737e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f50738f = new String(cArr);
        this.f50739g = new BigInteger(this.f50738f, 16);
        this.f50734b = dVar.f50734b;
        this.f50733a = dVar.f50733a;
        this.f50735c = dVar.f50735c;
        this.f50736d = dVar.f50736d;
        this.f50737e = dVar.f50737e;
        this.f50739g = dVar.f50739g;
        this.f50738f = dVar.f50738f;
    }

    public d(String str, int i11) {
        this.f50735c = 0;
        this.f50736d = 0;
        this.f50737e = false;
        char[] cArr = new char[16];
        Arrays.fill(cArr, 'f');
        this.f50738f = new String(cArr);
        this.f50739g = new BigInteger(this.f50738f, 16);
        this.f50734b = str;
        this.f50733a = i11;
    }
}
