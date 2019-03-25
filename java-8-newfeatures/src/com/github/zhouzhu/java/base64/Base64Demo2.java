package com.github.zhouzhu.java.base64;

import java.io.IOException;

public  class Base64Demo2 {
   private static interface Base64Codec{
       public String encode(final byte[] data);
       public byte[] decode(final String base64)throws IOException;
   }
   private static interface Base64ByteCodec{
       public byte[] encodeBytes(final byte[] data);
       public byte[] decodeBytes(final byte[] base64)throws IOException;
   }
   
}
