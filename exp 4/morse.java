import java.util.*;
import java.lang.*;

public class morse {

  public static void main(String[] args) {
	  String encryptedMessage = ":mmZ\\dxZmx]Zpgy";
    for (int key = 1; key <= 100; key++) {
          String decryptedMessage = decrypt(encryptedMessage, key);
          System.out.println("Decryption :  " + key + ": " + decryptedMessage);         
    }
  }

  public static String decrypt(String encryptedMessage, int key) {
    StringBuilder decrypted = new StringBuilder();

    for (int i = 0; i < encryptedMessage.length(); i++) 
    {
        char encryptedChar = encryptedMessage.charAt(i);
        char decryptedChar;

        if (encryptedChar - key < 32) 
        {
            decryptedChar = (char) (127 - (32 - (encryptedChar - key)));
        } 
        else 
        {
            decryptedChar = (char) (encryptedChar - key);
        }

        decrypted.append(decryptedChar);
    }

    return decrypted.toString();
 }
}















/*
  char aChar = 'a';
  //int ascii = (int) aChar;      // explicitly cast, optional, improves readability
  int ascii = aChar;              // implicit cast, auto cast char to int,
  System.out.println(ascii);      // 97
*/ 
