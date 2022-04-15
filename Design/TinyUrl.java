public class Codec {
    //https://leetcode.com/problems/encode-and-decode-tinyurl/submissions/
    Map<String, String> map = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        long t = System.currentTimeMillis();
        String s = longUrl.substring(5, 8) + t;
        map.put(s.substring(0,10), longUrl);
        
        return s.substring(0,10);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
