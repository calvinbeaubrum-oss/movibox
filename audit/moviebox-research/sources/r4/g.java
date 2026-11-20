package r4;

import androidx.media3.common.y;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Objects;
import o5.l;
import o5.s;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f75120a = new a();

    /* JADX INFO: compiled from: source.java */
    public class a implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final o5.h f75121b = new o5.h();

        @Override // r4.g
        public boolean a(y yVar) {
            String str = yVar.f9501m;
            return this.f75121b.a(yVar) || Objects.equals(str, MimeTypes.APPLICATION_CEA608) || Objects.equals(str, MimeTypes.APPLICATION_MP4CEA608) || Objects.equals(str, MimeTypes.APPLICATION_CEA708);
        }

        @Override // r4.g
        public l b(y yVar) {
            String str = yVar.f9501m;
            if (str != null) {
                switch (str) {
                    case "application/x-mp4-cea-608":
                    case "application/cea-608":
                        return new p5.a(str, yVar.E, 16000L);
                    case "application/cea-708":
                        return new p5.c(yVar.E, yVar.f9503o);
                }
            }
            if (!this.f75121b.a(yVar)) {
                throw new IllegalArgumentException("Attempted to create decoder for unsupported MIME type: " + str);
            }
            s sVarC = this.f75121b.c(yVar);
            return new b(sVarC.getClass().getSimpleName() + "Decoder", sVarC);
        }
    }

    boolean a(y yVar);

    l b(y yVar);
}
