package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ql {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ql f21954a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements ql {
        @Override // com.applovin.impl.ql
        public boolean a(f9 f9Var) {
            String str = f9Var.f18900m;
            return MimeTypes.TEXT_VTT.equals(str) || MimeTypes.TEXT_SSA.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || "text/x-exoplayer-cues".equals(str);
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // com.applovin.impl.ql
        public ol b(f9 f9Var) {
            String str = f9Var.f18900m;
            if (str != null) {
                byte b11 = -1;
                switch (str.hashCode()) {
                    case -1351681404:
                        if (str.equals(MimeTypes.APPLICATION_DVBSUBS)) {
                            b11 = 0;
                        }
                        break;
                    case -1248334819:
                        if (str.equals(MimeTypes.APPLICATION_PGS)) {
                            b11 = 1;
                        }
                        break;
                    case -1026075066:
                        if (str.equals(MimeTypes.APPLICATION_MP4VTT)) {
                            b11 = 2;
                        }
                        break;
                    case -1004728940:
                        if (str.equals(MimeTypes.TEXT_VTT)) {
                            b11 = 3;
                        }
                        break;
                    case 691401887:
                        if (str.equals(MimeTypes.APPLICATION_TX3G)) {
                            b11 = 4;
                        }
                        break;
                    case 822864842:
                        if (str.equals(MimeTypes.TEXT_SSA)) {
                            b11 = 5;
                        }
                        break;
                    case 930165504:
                        if (str.equals(MimeTypes.APPLICATION_MP4CEA608)) {
                            b11 = 6;
                        }
                        break;
                    case 1201784583:
                        if (str.equals("text/x-exoplayer-cues")) {
                            b11 = 7;
                        }
                        break;
                    case 1566015601:
                        if (str.equals(MimeTypes.APPLICATION_CEA608)) {
                            b11 = 8;
                        }
                        break;
                    case 1566016562:
                        if (str.equals(MimeTypes.APPLICATION_CEA708)) {
                            b11 = 9;
                        }
                        break;
                    case 1668750253:
                        if (str.equals(MimeTypes.APPLICATION_SUBRIP)) {
                            b11 = 10;
                        }
                        break;
                    case 1693976202:
                        if (str.equals(MimeTypes.APPLICATION_TTML)) {
                            b11 = Ascii.VT;
                        }
                        break;
                }
                switch (b11) {
                    case 0:
                        return new j7(f9Var.f18902o);
                    case 1:
                        return new jh();
                    case 2:
                        return new qf();
                    case 3:
                        return new yr();
                    case 4:
                        return new lp(f9Var.f18902o);
                    case 5:
                        return new xk(f9Var.f18902o);
                    case 6:
                    case 8:
                        return new y2(str, f9Var.E, 16000L);
                    case 7:
                        return new i8();
                    case 9:
                        return new z2(f9Var.E, f9Var.f18902o);
                    case 10:
                        return new jl();
                    case 11:
                        return new fp();
                }
            }
            throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
        }
    }

    boolean a(f9 f9Var);

    ol b(f9 f9Var);
}
