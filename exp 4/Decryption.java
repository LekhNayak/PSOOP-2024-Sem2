import java.util.*;
import java.lang.*;

public class Decryption {

  public static void main(String[] args) {
    // The encrypted message to be decrypted
    String encryptedMessage = ":mmZ\\dxZmx]Zpgy";

    // Loop through possible keys from 1 to 100 to decrypt the message
    for (int key = 1; key <= 100; key++) {
          String decryptedMessage = decrypt(encryptedMessage, key);
          // Print the decrypted message along with the key used for decryption
          System.out.println("Decryption :  " + key + ": " + decryptedMessage);         
    }
  }

  // Method to decrypt the message using a given key
  public static String decrypt(String encryptedMessage, int key) {
    StringBuilder decrypted = new StringBuilder();

    // Iterate through each character in the encrypted message
    for (int i = 0; i < encryptedMessage.length(); i++) 
    {
        // Get the character at index i
        char encryptedChar = encryptedMessage.charAt(i);
        char decryptedChar;

        // Decrypt the character using the key
        if (encryptedChar - key < 32) 
        {
            // If the decrypted character falls below ASCII 32, wrap around from ASCII 127
            decryptedChar = (char) (127 - (32 - (encryptedChar - key)));
        } 
        else 
        {
            // Decrypt the character normally
            decryptedChar = (char) (encryptedChar - key);
        }

        // Append the decrypted character to the StringBuilder
        decrypted.append(decryptedChar);
    }

    // Convert the StringBuilder to a String and return the decrypted message
    return decrypted.toString();
 }
}

