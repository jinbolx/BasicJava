package leetcode;

public class EncodeAndDecode {

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] longArray=longUrl.toCharArray();
        for (int i = 0; i <longArray.length; i++) {
            longArray[i]= (char) (longArray[i]+1);
        }
        return new String(longArray,0,longArray.length);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        char[] shortArray=shortUrl.toCharArray();
        for (int i = 0; i < shortArray.length; i++) {
            shortArray[i]= (char) (shortArray[i]-1);
        }
        return new String(shortArray,0,shortArray.length);
    }

    public static void main(String[] args) {
        EncodeAndDecode encodeAndDecode = new EncodeAndDecode();
        String longUrl="=1123_";
        System.out.println(encodeAndDecode.decode(encodeAndDecode.encode(longUrl)));
    }
}
