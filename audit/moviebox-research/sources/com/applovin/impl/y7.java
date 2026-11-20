package com.applovin.impl;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f24565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DataOutputStream f24566b;

    public y7() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f24565a = byteArrayOutputStream;
        this.f24566b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(w7 w7Var) {
        this.f24565a.reset();
        try {
            a(this.f24566b, w7Var.f24068a);
            String str = w7Var.f24069b;
            if (str == null) {
                str = "";
            }
            a(this.f24566b, str);
            this.f24566b.writeLong(w7Var.f24070c);
            this.f24566b.writeLong(w7Var.f24071d);
            this.f24566b.write(w7Var.f24072f);
            this.f24566b.flush();
            return this.f24565a.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
