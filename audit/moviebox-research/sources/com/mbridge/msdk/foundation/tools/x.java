package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import java.util.HashMap;
import java.util.Map;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45092a = "x";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map<Character, Character> f45093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Map<Character, Character> f45094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static byte[] f45095d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Ascii.VT, Ascii.FF, Ascii.CR, Ascii.SO, Ascii.SI, Ascii.DLE, 17, Ascii.DC2, 19, Ascii.DC4, Ascii.NAK, Ascii.SYN, Ascii.ETB, Ascii.CAN, Ascii.EM, -1, -1, -1, -1, -1, -1, Ascii.SUB, Ascii.ESC, Ascii.FS, Ascii.GS, Ascii.RS, Ascii.US, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static char[] f45096e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap map = new HashMap();
        f45093b = map;
        map.put('v', 'A');
        f45093b.put('S', 'B');
        f45093b.put('o', 'C');
        f45093b.put('a', 'D');
        f45093b.put('j', 'E');
        f45093b.put('c', 'F');
        f45093b.put('7', 'G');
        f45093b.put('d', 'H');
        f45093b.put('R', 'I');
        f45093b.put('z', 'J');
        f45093b.put('p', 'K');
        f45093b.put('W', 'L');
        f45093b.put('i', 'M');
        f45093b.put('f', 'N');
        f45093b.put('G', 'O');
        f45093b.put('y', 'P');
        f45093b.put('N', 'Q');
        f45093b.put('x', 'R');
        f45093b.put('Z', 'S');
        f45093b.put('n', 'T');
        f45093b.put('V', 'U');
        f45093b.put('5', 'V');
        f45093b.put('k', 'W');
        f45093b.put('+', 'X');
        f45093b.put('D', 'Y');
        f45093b.put('H', 'Z');
        f45093b.put('L', 'a');
        f45093b.put('Y', 'b');
        f45093b.put('h', 'c');
        f45093b.put('J', 'd');
        f45093b.put('4', 'e');
        f45093b.put('6', 'f');
        f45093b.put('l', 'g');
        f45093b.put('t', 'h');
        f45093b.put('0', 'i');
        f45093b.put('U', 'j');
        f45093b.put('3', 'k');
        f45093b.put('Q', 'l');
        f45093b.put('r', 'm');
        f45093b.put('g', 'n');
        f45093b.put('E', 'o');
        f45093b.put('u', 'p');
        f45093b.put('q', 'q');
        f45093b.put('8', 'r');
        f45093b.put('s', 's');
        f45093b.put('w', 't');
        f45093b.put('/', 'u');
        f45093b.put('X', 'v');
        f45093b.put('M', 'w');
        f45093b.put('e', 'x');
        f45093b.put('B', 'y');
        f45093b.put('A', 'z');
        f45093b.put('T', '0');
        f45093b.put('2', '1');
        f45093b.put('F', '2');
        f45093b.put('b', '3');
        f45093b.put('9', '4');
        f45093b.put('P', '5');
        f45093b.put('1', '6');
        f45093b.put('O', '7');
        f45093b.put('I', '8');
        f45093b.put('K', '9');
        f45093b.put('m', '+');
        f45093b.put('C', '/');
        HashMap map2 = new HashMap();
        f45094c = map2;
        map2.put('A', 'v');
        f45094c.put('B', 'S');
        f45094c.put('C', 'o');
        f45094c.put('D', 'a');
        f45094c.put('E', 'j');
        f45094c.put('F', 'c');
        f45094c.put('G', '7');
        f45094c.put('H', 'd');
        f45094c.put('I', 'R');
        f45094c.put('J', 'z');
        f45094c.put('K', 'p');
        f45094c.put('L', 'W');
        f45094c.put('M', 'i');
        f45094c.put('N', 'f');
        f45094c.put('O', 'G');
        f45094c.put('P', 'y');
        f45094c.put('Q', 'N');
        f45094c.put('R', 'x');
        f45094c.put('S', 'Z');
        f45094c.put('T', 'n');
        f45094c.put('U', 'V');
        f45094c.put('V', '5');
        f45094c.put('W', 'k');
        f45094c.put('X', '+');
        f45094c.put('Y', 'D');
        f45094c.put('Z', 'H');
        f45094c.put('a', 'L');
        f45094c.put('b', 'Y');
        f45094c.put('c', 'h');
        f45094c.put('d', 'J');
        f45094c.put('e', '4');
        f45094c.put('f', '6');
        f45094c.put('g', 'l');
        f45094c.put('h', 't');
        f45094c.put('i', '0');
        f45094c.put('j', 'U');
        f45094c.put('k', '3');
        f45094c.put('l', 'Q');
        f45094c.put('m', 'r');
        f45094c.put('n', 'g');
        f45094c.put('o', 'E');
        f45094c.put('p', 'u');
        f45094c.put('q', 'q');
        f45094c.put('r', '8');
        f45094c.put('s', 's');
        f45094c.put('t', 'w');
        f45094c.put('u', '/');
        f45094c.put('v', 'X');
        f45094c.put('w', 'M');
        f45094c.put('x', 'e');
        f45094c.put('y', 'B');
        f45094c.put('z', 'A');
        f45094c.put('0', 'T');
        f45094c.put('1', '2');
        f45094c.put('2', 'F');
        f45094c.put('3', 'b');
        f45094c.put('4', '9');
        f45094c.put('5', 'P');
        f45094c.put('6', '1');
        f45094c.put('7', 'O');
        f45094c.put('8', 'I');
        f45094c.put('9', 'K');
        f45094c.put('+', 'm');
        f45094c.put('/', 'C');
    }

    private x() {
    }

    public static String a(String str) {
        return ae.a(str);
    }

    public static String b(String str) {
        return TextUtils.isEmpty(str) ? "" : ae.b(str);
    }
}
