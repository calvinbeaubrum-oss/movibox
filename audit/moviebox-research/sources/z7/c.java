package z7;

import com.applovin.exoplayer2.common.base.Ascii;
import com.avery.subtitle.exception.FatalParsingException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class c {
    public final void a(a8.d dVar) {
        a8.a aVar = new a8.a("white");
        aVar.f444d = a8.a.b("name", "white");
        dVar.f461g.put(aVar.f441a, aVar);
        a8.a aVar2 = new a8.a("whiteU", aVar);
        aVar2.f449i = true;
        dVar.f461g.put(aVar2.f441a, aVar2);
        a8.a aVar3 = new a8.a("whiteUI", aVar2);
        aVar3.f447g = true;
        dVar.f461g.put(aVar3.f441a, aVar3);
        a8.a aVar4 = new a8.a("whiteI", aVar3);
        aVar4.f449i = false;
        dVar.f461g.put(aVar4.f441a, aVar4);
        a8.a aVar5 = new a8.a("green");
        aVar5.f444d = a8.a.b("name", "green");
        dVar.f461g.put(aVar5.f441a, aVar5);
        a8.a aVar6 = new a8.a("greenU", aVar5);
        aVar6.f449i = true;
        dVar.f461g.put(aVar6.f441a, aVar6);
        a8.a aVar7 = new a8.a("greenUI", aVar6);
        aVar7.f447g = true;
        dVar.f461g.put(aVar7.f441a, aVar7);
        a8.a aVar8 = new a8.a("greenI", aVar7);
        aVar8.f449i = false;
        dVar.f461g.put(aVar8.f441a, aVar8);
        a8.a aVar9 = new a8.a("blue");
        aVar9.f444d = a8.a.b("name", "blue");
        dVar.f461g.put(aVar9.f441a, aVar9);
        a8.a aVar10 = new a8.a("blueU", aVar9);
        aVar10.f449i = true;
        dVar.f461g.put(aVar10.f441a, aVar10);
        a8.a aVar11 = new a8.a("blueUI", aVar10);
        aVar11.f447g = true;
        dVar.f461g.put(aVar11.f441a, aVar11);
        a8.a aVar12 = new a8.a("blueI", aVar11);
        aVar12.f449i = false;
        dVar.f461g.put(aVar12.f441a, aVar12);
        a8.a aVar13 = new a8.a("cyan");
        aVar13.f444d = a8.a.b("name", "cyan");
        dVar.f461g.put(aVar13.f441a, aVar13);
        a8.a aVar14 = new a8.a("cyanU", aVar13);
        aVar14.f449i = true;
        dVar.f461g.put(aVar14.f441a, aVar14);
        a8.a aVar15 = new a8.a("cyanUI", aVar14);
        aVar15.f447g = true;
        dVar.f461g.put(aVar15.f441a, aVar15);
        a8.a aVar16 = new a8.a("cyanI", aVar15);
        aVar16.f449i = false;
        dVar.f461g.put(aVar16.f441a, aVar16);
        a8.a aVar17 = new a8.a("red");
        aVar17.f444d = a8.a.b("name", "red");
        dVar.f461g.put(aVar17.f441a, aVar17);
        a8.a aVar18 = new a8.a("redU", aVar17);
        aVar18.f449i = true;
        dVar.f461g.put(aVar18.f441a, aVar18);
        a8.a aVar19 = new a8.a("redUI", aVar18);
        aVar19.f447g = true;
        dVar.f461g.put(aVar19.f441a, aVar19);
        a8.a aVar20 = new a8.a("redI", aVar19);
        aVar20.f449i = false;
        dVar.f461g.put(aVar20.f441a, aVar20);
        a8.a aVar21 = new a8.a("yellow");
        aVar21.f444d = a8.a.b("name", "yellow");
        dVar.f461g.put(aVar21.f441a, aVar21);
        a8.a aVar22 = new a8.a("yellowU", aVar21);
        aVar22.f449i = true;
        dVar.f461g.put(aVar22.f441a, aVar22);
        a8.a aVar23 = new a8.a("yellowUI", aVar22);
        aVar23.f447g = true;
        dVar.f461g.put(aVar23.f441a, aVar23);
        a8.a aVar24 = new a8.a("yellowI", aVar23);
        aVar24.f449i = false;
        dVar.f461g.put(aVar24.f441a, aVar24);
        a8.a aVar25 = new a8.a("magenta");
        aVar25.f444d = a8.a.b("name", "magenta");
        dVar.f461g.put(aVar25.f441a, aVar25);
        a8.a aVar26 = new a8.a("magentaU", aVar25);
        aVar26.f449i = true;
        dVar.f461g.put(aVar26.f441a, aVar26);
        a8.a aVar27 = new a8.a("magentaUI", aVar26);
        aVar27.f447g = true;
        dVar.f461g.put(aVar27.f441a, aVar27);
        a8.a aVar28 = new a8.a("magentaI", aVar27);
        aVar28.f449i = false;
        dVar.f461g.put(aVar28.f441a, aVar28);
        a8.a aVar29 = new a8.a("black");
        aVar29.f444d = a8.a.b("name", "black");
        dVar.f461g.put(aVar29.f441a, aVar29);
        a8.a aVar30 = new a8.a("blackU", aVar29);
        aVar30.f449i = true;
        dVar.f461g.put(aVar30.f441a, aVar30);
        a8.a aVar31 = new a8.a("blackUI", aVar30);
        aVar31.f447g = true;
        dVar.f461g.put(aVar31.f441a, aVar31);
        a8.a aVar32 = new a8.a("blackI", aVar31);
        aVar32.f449i = false;
        dVar.f461g.put(aVar32.f441a, aVar32);
    }

    public a8.d b(String str, String str2, InputStream inputStream) throws IOException, FatalParsingException {
        String str3;
        String str4;
        int i11;
        int i12;
        InputStream inputStream2 = inputStream;
        String str5 = "";
        String str6 = ":";
        a8.d dVar = new a8.d();
        dVar.f459e = str;
        byte[] bArr = new byte[1024];
        byte[] bArr2 = new byte[128];
        try {
            a(dVar);
            if (inputStream2.read(bArr) < 1024) {
                throw new FatalParsingException("The file must contain at least a GSI block");
            }
            int i13 = Integer.parseInt(new String(new byte[]{bArr[6], bArr[7]}));
            int i14 = Integer.parseInt(new String(new byte[]{bArr[12], bArr[13]}));
            byte[] bArr3 = new byte[32];
            System.arraycopy(bArr, 16, bArr3, 0, 32);
            String str7 = new String(bArr3);
            byte[] bArr4 = new byte[32];
            System.arraycopy(bArr, 48, bArr4, 0, 32);
            String str8 = new String(bArr4);
            int i15 = Integer.parseInt(new String(new byte[]{bArr[238], bArr[239], bArr[240], bArr[241], bArr[242]}));
            int i16 = Integer.parseInt(new String(new byte[]{bArr[243], bArr[244], bArr[245], bArr[246], bArr[247]}));
            dVar.f455a = (str7.trim() + " " + str8.trim()).trim();
            if (i14 > 4 || i14 < 0) {
                dVar.f464j += "Invalid Character Code table number, corrupt data? will try to parse anyways assuming it is latin.\n\n";
            } else if (i14 != 0) {
                dVar.f464j += "Only latin alphabet supported for import from STL, other languages may produce unexpected results.\n\n";
            }
            a8.b bVar = null;
            int i17 = 0;
            boolean z11 = false;
            int i18 = 0;
            while (i17 < i15) {
                if (inputStream2.read(bArr2) < 128) {
                    dVar.f464j += "Unexpected end of file, " + i17 + " blocks read, expecting " + i15 + " blocks in total.\n\n";
                    break;
                }
                if (!z11) {
                    bVar = new a8.b();
                }
                if (bArr2[1] + (bArr2[2] * Ascii.NUL) != i18) {
                    dVar.f464j += "Unexpected subtitle number at TTI block " + i17 + ". Parsing proceeds...\n\n";
                }
                z11 = bArr2[3] != -1;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str5);
                sb2.append((int) bArr2[5]);
                sb2.append(str6);
                int i19 = i15;
                sb2.append((int) bArr2[6]);
                sb2.append(str6);
                sb2.append((int) bArr2[7]);
                sb2.append(str6);
                sb2.append((int) bArr2[8]);
                String string = sb2.toString();
                String str9 = str5 + ((int) bArr2[9]) + str6 + ((int) bArr2[10]) + str6 + ((int) bArr2[11]) + str6 + ((int) bArr2[12]);
                byte b11 = bArr2[14];
                if (bArr2[15] == 0) {
                    str3 = str5;
                    str4 = str6;
                    byte[] bArr5 = new byte[112];
                    i11 = i16;
                    i12 = i17;
                    System.arraycopy(bArr2, 16, bArr5, 0, 112);
                    if (z11) {
                        c(bVar, bArr5, b11, dVar);
                    } else {
                        bVar.f451b = new a8.c("h:m:s:f/fps", string + "/" + i13);
                        bVar.f452c = new a8.c("h:m:s:f/fps", str9 + "/" + i13);
                        c(bVar, bArr5, b11, dVar);
                    }
                } else {
                    str3 = str5;
                    str4 = str6;
                    i11 = i16;
                    i12 = i17;
                }
                if (!z11) {
                    i18++;
                }
                i15 = i19;
                i17 = i12 + 1;
                str5 = str3;
                str6 = str4;
                i16 = i11;
                inputStream2 = inputStream;
            }
            int i21 = i16;
            if (i18 != i21) {
                dVar.f464j += "Number of parsed subtitles (" + i18 + ") different from expected number of subtitles (" + i21 + ").\n\n";
            }
            inputStream.close();
            dVar.a();
            dVar.f467m = true;
            return dVar;
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new FatalParsingException("Format error in the file, migth be due to corrupt data.\n" + e11.getMessage());
        }
    }

    public final void c(a8.b bVar, byte[] bArr, int i11, a8.d dVar) {
        String str;
        a8.a aVar;
        String str2 = "white";
        String str3 = "";
        int length = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (length < bArr.length) {
            byte b11 = bArr[length];
            if (b11 >= 0) {
                if (b11 < 32) {
                    int i12 = length + 1;
                    if (i12 < bArr.length && b11 == bArr[i12]) {
                        length = i12;
                    }
                    switch (bArr[length]) {
                        case 0:
                            str2 = "black";
                            break;
                        case 1:
                            str2 = "red";
                            break;
                        case 2:
                            str2 = "green";
                            break;
                        case 3:
                            str2 = "yellow";
                            break;
                        case 4:
                            str2 = "blue";
                            break;
                        case 5:
                            str2 = "magenta";
                            break;
                        case 6:
                            str2 = "cyan";
                            break;
                        case 7:
                            str2 = "white";
                            break;
                    }
                } else {
                    str3 = str3 + new String(new byte[]{b11});
                }
                length++;
            } else if (b11 <= -113) {
                int i13 = length + 1;
                if (i13 < bArr.length && b11 == bArr[i13]) {
                    length = i13;
                }
                byte b12 = bArr[length];
                if (b12 == -118) {
                    bVar.f453d += str3 + "<br />";
                } else if (b12 != -113) {
                    switch (b12) {
                        case -128:
                            z12 = true;
                            break;
                        case -127:
                            z12 = false;
                            break;
                        case -126:
                            z11 = true;
                            break;
                        case -125:
                            z11 = false;
                            break;
                    }
                } else {
                    bVar.f453d += str3;
                    if (z11) {
                        str2 = str2 + "U";
                    }
                    if (z12) {
                        str2 = str2 + "I";
                    }
                    a8.a aVar2 = dVar.f461g.get(str2);
                    if (i11 == 1) {
                        str = str2 + "L";
                        if (dVar.f461g.get(str) == null) {
                            aVar = new a8.a(str, aVar2);
                            aVar.f446f = "bottom-left";
                            dVar.f461g.put(str, aVar);
                            str2 = str;
                            aVar2 = aVar;
                        } else {
                            aVar2 = dVar.f461g.get(str);
                            str2 = str;
                        }
                    } else if (i11 == 3) {
                        str = str2 + "R";
                        if (dVar.f461g.get(str) == null) {
                            aVar = new a8.a(str, aVar2);
                            aVar.f446f = "bottom-rigth";
                            dVar.f461g.put(str, aVar);
                            str2 = str;
                            aVar2 = aVar;
                        } else {
                            aVar2 = dVar.f461g.get(str);
                            str2 = str;
                        }
                    }
                    bVar.f450a = aVar2;
                    int i14 = bVar.f451b.f454a;
                    while (dVar.f463i.containsKey(Integer.valueOf(i14))) {
                        i14++;
                    }
                    dVar.f463i.put(Integer.valueOf(i14), bVar);
                    length = bArr.length;
                }
                str3 = "";
            }
            length++;
        }
    }
}
