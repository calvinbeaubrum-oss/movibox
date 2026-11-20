package com.bytedance.sdk.openadsdk.qr;

import android.util.Pair;
import com.bykv.vk.openvk.preload.geckox.buffer.stream.BufferOutputStream;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import com.bytedance.sdk.component.pFF.sc.BT;
import com.bytedance.sdk.component.pFF.sc.ExN;
import com.bytedance.sdk.component.pFF.sc.Ol;
import com.bytedance.sdk.component.pFF.sc.Ql;
import com.bytedance.sdk.component.pFF.sc.SR;
import com.bytedance.sdk.component.pFF.sc.TRI;
import com.bytedance.sdk.component.pFF.sc.UFX;
import com.bytedance.sdk.component.pFF.sc.zY;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc implements INetWork {
    protected UFX pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    protected UFX f28665sc;

    public sc() {
        UFX.sc scVar = new UFX.sc();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.f28665sc = scVar.sc(10L, timeUnit).pFF(10L, timeUnit).zY(10L, timeUnit).sc();
        this.pFF = new UFX.sc().sc(10L, timeUnit).pFF(30L, timeUnit).zY(30L, timeUnit).sc();
    }

    private Map<String, String> sc(TRI tri) {
        if (tri == null) {
            return null;
        }
        HashMap map = new HashMap();
        for (int i11 = 0; i11 < tri.sc(); i11++) {
            map.put(tri.sc(i11), tri.pFF(i11));
        }
        return map;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doGet(String str) throws Exception {
        BT btPFF = this.f28665sc.sc(new Ql.sc().sc().pFF(str).pFF()).pFF();
        return new Response(sc(btPFF.qr()), btPFF.zY() == 200 ? btPFF.TRI().pFF() : null, btPFF.zY(), btPFF.ExN());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, String str2) throws Exception {
        BT btPFF = this.f28665sc.sc(new Ql.sc().pFF(str).sc(SR.sc(Ol.sc("application/json; charset=utf-8"), str2)).pFF()).pFF();
        return new Response(sc(btPFF.qr()), btPFF.zY() == 200 ? btPFF.TRI().pFF() : null, btPFF.zY(), btPFF.ExN());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public Response doPost(String str, List<Pair<String, String>> list) throws Exception {
        ExN.sc scVar = new ExN.sc();
        if (list != null) {
            for (Pair<String, String> pair : list) {
                scVar.sc((String) pair.first, (String) pair.second);
            }
        }
        BT btPFF = this.f28665sc.sc(new Ql.sc().pFF(str).sc((SR) scVar.sc()).pFF()).pFF();
        return new Response(sc(btPFF.qr()), btPFF.zY() == 200 ? btPFF.TRI().pFF() : null, btPFF.zY(), btPFF.ExN());
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void downloadFile(String str, long j11, BufferOutputStream bufferOutputStream) throws Exception {
        BufferedInputStream bufferedInputStream;
        Exception e11;
        BufferedInputStream bufferedInputStream2 = null;
        int i11 = 0;
        try {
            try {
                BT btPFF = this.pFF.sc(new Ql.sc().sc().pFF(str).pFF()).pFF();
                int iZY = btPFF.zY();
                try {
                    bufferedInputStream = new BufferedInputStream(btPFF.TRI().zY());
                    try {
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int i12 = bufferedInputStream.read(bArr, 0, 2048);
                                if (i12 == -1) {
                                    CloseableUtils.close(bufferedInputStream);
                                    return;
                                }
                                bufferOutputStream.write(bArr, 0, i12);
                                th = th;
                                bufferedInputStream2 = bufferedInputStream;
                                CloseableUtils.close(bufferedInputStream2);
                                throw th;
                            }
                        } catch (Exception e12) {
                            e11 = e12;
                            i11 = iZY;
                            throw new RuntimeException("downloadFile failed, code: " + i11 + ", url:" + str + ", caused by:" + e11.getMessage(), e11);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                    }
                } catch (Exception e13) {
                    bufferedInputStream = null;
                    e11 = e13;
                }
            } catch (Exception e14) {
                bufferedInputStream = null;
                e11 = e14;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.net.INetWork
    public void syncDoGet(final String str) {
        this.f28665sc.sc(new Ql.sc().sc().pFF(str).pFF()).sc(new zY() { // from class: com.bytedance.sdk.openadsdk.qr.sc.1
            @Override // com.bytedance.sdk.component.pFF.sc.zY
            public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, BT bt2) throws IOException {
            }

            @Override // com.bytedance.sdk.component.pFF.sc.zY
            public void sc(com.bytedance.sdk.component.pFF.sc.pFF pff, IOException iOException) {
            }
        });
    }
}
