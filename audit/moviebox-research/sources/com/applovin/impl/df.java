package com.applovin.impl;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface df {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final df f18444a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements df {
        @Override // com.applovin.impl.df
        public boolean a(f9 f9Var) {
            String str = f9Var.f18900m;
            return MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
        }

        @Override // com.applovin.impl.df
        public cf b(f9 f9Var) {
            String str = f9Var.f18900m;
            if (str != null) {
                switch (str) {
                    case "application/vnd.dvb.ait":
                        return new a1();
                    case "application/x-icy":
                        return new ua();
                    case "application/id3":
                        return new xa();
                    case "application/x-emsg":
                        return new x7();
                    case "application/x-scte35":
                        return new tk();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(f9 f9Var);

    cf b(f9 f9Var);
}
