package org.avol;

/**
 * Created by lovababu on 09/06/18.
 */
public class TinyEncoding {

    private static final String ALPHABET_MAP = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789" ;
    private static final int BASE = ALPHABET_MAP.length() ;

    public static void main(String[] args) {
        System.out.println("Encode: " + encode(1831283461));
        System.out.println("Decode: " + decode(encode(1831283461)));
    }

    public static String encode ( int IndexNum ) {
        StringBuilder sb = new StringBuilder() ;

        while ( IndexNum > 0 ) {
            sb.append ( ALPHABET_MAP.charAt ( IndexNum % BASE )) ;
            IndexNum /= BASE ;
        }
        return sb.reverse().toString() ;
    }

    public static int decode ( String str ) {
        int Num = 0 ;

        for ( int i = 0, len = str.length(); i < len; i++ ) {
            Num = Num * BASE + ALPHABET_MAP.indexOf ( str.charAt(i) ) ;
        }
        return Num ;
    }
}
