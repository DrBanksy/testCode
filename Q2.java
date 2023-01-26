public class Q2 {
    public static String LETTERS = "abcdefghijklmnopqrstuvwxyz";   
    public static int ALPHABETLENGTH = LETTERS.length();
    public static String caesarEncrypt(String userInput, int offset)   
    {   
        System.out.println("----- Caesars Cipher Encrypt -----");
        System.out.println("Plaintext = " + userInput );

        // plaintext
        String input = userInput.toLowerCase();
        input = userInput.replaceAll("\\s+","");

        // array to store encryoted string
        StringBuffer encryptedString = new StringBuffer();

        for(int i = 0; i < input.length(); ++i) {
            // plaintext letter
            char ch = input.charAt(i);
            
            // get position of plaintext letter in alphabetic
            int alphIndex = LETTERS.indexOf(ch);

            // add the shift to the index
            alphIndex = (alphIndex + offset) % 26;

            // append each encrypted letter
            encryptedString.append(LETTERS.charAt(alphIndex));
        }
        
        System.out.println("Shift = " + offset);
        System.out.println("Encrypted text = " + encryptedString);

        return encryptedString.toString();
    }  
    
    // decryption algorithm
    // p = D(K,C) = (C-K) % 26
    public static String caesarDecrypt(String userInput, int offset) {
        System.out.println("----- Caesars Cipher Decrypt -----");
        System.out.println("Cipher text = " + userInput);

        userInput = userInput.toLowerCase();
        userInput = userInput.replaceAll("\\s+","");
        StringBuffer decryptedString = new StringBuffer();
        
        for(int i = 0; i < userInput.length(); ++i) {
            // encrypted letter
            char ch = userInput.charAt(i);

            // position of encrypted letter in alphabet
            int chPos = LETTERS.indexOf(ch);

            // subtract shift to the index 
            chPos = (chPos - offset) % 26;
            if(chPos < 0) {
                chPos = ALPHABETLENGTH + chPos;
            }

            // append decrypted letter to string
            decryptedString.append(LETTERS.charAt(chPos));
            
        }

        System.out.println("Shift = " + offset);
        System.out.println("Decrypted text = " + decryptedString);

        return decryptedString.toString();
    }

    public static String vigenereCipherEncrypt(String userInput, String keyWord) {
        System.out.println("----- Vigenere Cipher Encrypt -----");
        System.out.println("Plaintext = " + userInput);
        System.out.println("Keyword = " + keyWord);
        
        // plaintext
        String input = userInput.toLowerCase();
        keyWord = keyWord.toLowerCase();
        StringBuffer encryptedString = new StringBuffer();
        int i = 0;
        // we need the key to be as long as the plaintext
        while(input.length() != keyWord.length()) {
            
            if(input.length() == i) {
                i = 0;
            }
            keyWord = keyWord + keyWord.charAt(i);
            ++i;
        }
        //Encrypting plaintext
        for(int j  = 0; j < input.length(); ++j ) {
            int alphaPos = (LETTERS.indexOf(input.charAt(j)) + LETTERS.indexOf(keyWord.charAt(j)))%26;
            encryptedString.append(LETTERS.charAt(alphaPos));
        }

        
        System.out.println("Encrypted text = " + encryptedString);

        return encryptedString.toString();
    }

    public static String vigenereCipherDecrypt(String userInput, String keyWord) {
        System.out.println("----- Vigenere Cipher Decrypt -----");
        
        System.out.println("Key = " + keyWord);

        // cipherText
        userInput = userInput.toLowerCase();
        userInput = userInput.replaceAll("\\s+","");

        keyWord = keyWord.toLowerCase();
        StringBuffer decryptedString = new StringBuffer();

        int j  = 0;
        // we need the key to be as long as the plaintext
        while(userInput.length() != keyWord.length()) {     
            if(userInput.length() == j) {
                j = 0;
            }
            keyWord = keyWord + keyWord.charAt(j);
            ++j;
        }
        System.out.println(keyWord);
        //decrypting ciphertext
        int i = 0;
        while(i < userInput.length()) {
            if(LETTERS.indexOf(userInput.charAt(i)) == -1) {
                decryptedString.append(userInput.charAt(i));
                i++;
                continue;
            }

            char cipherCh = userInput.charAt(i);
            char keyWordCh = keyWord.charAt(i);

            // position of encrypted letter in alphabet
            int cipherPos = LETTERS.indexOf(cipherCh);
            int keyWordPos = LETTERS.indexOf(keyWordCh);

            // subtract shift to the index 
            int decipheredLetterPos = (((cipherPos - keyWordPos) + 26) % 26) ;

            // append decrypted letter to string
            decryptedString.append(LETTERS.charAt(decipheredLetterPos));

            if(LETTERS.charAt(decipheredLetterPos) == 'p') {
                System.out.println("test" + userInput.charAt(i));
            }

            ++i;
        }

        System.out.println("Encrypted text = " + userInput);
        System.out.println("Decrypted text = " + decryptedString);

        return decryptedString.toString();
    }


    public static void main(String[] args) {
        String plaintext = "test";
        String cipherText = "vguv";
        String decryptedText; String encryptedText;
        int offset = 2;

        encryptedText = caesarEncrypt(plaintext, offset);
        

        // decryptedText = caesarDecrypt(cipherText, offset);
        

        // encryptedText = vigenereCipherEncrypt(plaintext, "TE");
        

        // decryptedText = vigenereCipherDecrypt("milx", "tete");
        


    }
}