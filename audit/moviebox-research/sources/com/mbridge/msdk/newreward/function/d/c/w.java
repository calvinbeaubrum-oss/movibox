package com.mbridge.msdk.newreward.function.d.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class w extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.b f46382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.function.d.a.a f46383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l f46384c;

    public w(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.a.a aVar, l lVar) {
        this.f46382a = bVar;
        this.f46383b = aVar;
        this.f46384c = lVar;
    }

    @Override // com.mbridge.msdk.newreward.function.d.c.p
    public final void a(int i11, x xVar) {
        CampaignEx campaignExG = this.f46383b.g();
        if (TextUtils.isEmpty(campaignExG.getMraid())) {
            xVar.b(this.f46382a, this.f46383b, this);
            return;
        }
        String strA = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
        String md5 = SameMD5.getMD5(campaignExG.getMraid());
        if (TextUtils.isEmpty(md5)) {
            md5 = String.valueOf(System.currentTimeMillis());
        }
        FileOutputStream fileOutputStream = null;
        try {
            File file = new File(strA, md5.concat(".html"));
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(("<script>" + com.mbridge.msdk.c.b.a.a().b() + "</script>" + campaignExG.getMraid()).getBytes());
                fileOutputStream2.flush();
                campaignExG.setMraid(file.getAbsolutePath());
            } catch (Exception unused) {
                fileOutputStream = fileOutputStream2;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                campaignExG.setMraid("");
            }
        } catch (Exception unused3) {
        }
        xVar.b(this.f46382a, this.f46383b, this);
    }
}
