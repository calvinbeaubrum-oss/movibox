package j5;

import androidx.media3.common.ParserException;
import java.io.IOException;
import u4.t;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {
    void a(int i11, int i12, t tVar) throws IOException;

    void endMasterElement(int i11) throws ParserException;

    void floatElement(int i11, double d11) throws ParserException;

    int getElementType(int i11);

    void integerElement(int i11, long j11) throws ParserException;

    boolean isLevel1Element(int i11);

    void startMasterElement(int i11, long j11, long j12) throws ParserException;

    void stringElement(int i11, String str) throws ParserException;
}
