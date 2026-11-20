package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.UncheckedIOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class c extends i {
    public c(String str) {
        super(str);
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public String E() {
        return "#cdata";
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public void I(Appendable appendable, int i11, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(f0());
    }

    @Override // org.jsoup.nodes.i, org.jsoup.nodes.g
    public void J(Appendable appendable, int i11, Document.OutputSettings outputSettings) {
        try {
            appendable.append("]]>");
        } catch (IOException e11) {
            throw new UncheckedIOException(e11);
        }
    }
}
