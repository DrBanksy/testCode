// hill cipher encrypt
// C = E(K, P) = PKmod26
public class Q6 {
    public static String LETTERS = "abcdefghijklmnopqrstuvwxyz"; 

    public static void hillCipher(String[][] keyMatrix, String plainText[][]) {
        int keyMatrixIndex[][] = new int[2][2]; 
        int plainTextIndex[][] = new int[2][2];
        int[][] encryptedMatrixIndex = new int[2][2];

        // convert matrices to numbers corresping to alphabet index
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                keyMatrixIndex[i][j] = LETTERS.indexOf(keyMatrix[i][j].toLowerCase());
                plainTextIndex[i][j] = LETTERS.indexOf(plainText[i][j].toLowerCase());
            }
        }
        // multiply two matrices
        for(int i = 0; i < 2; ++i) {
            for(int j = 0; j < 2; ++j) {
                for(int k = 0; k < 2; ++k) {
                    encryptedMatrixIndex[i][j] += plainTextIndex[i][k]*keyMatrixIndex[k][j];
                }
                System.out.println(LETTERS.charAt(encryptedMatrixIndex[i][j]%26));
            }
        }
    }
    

    public static void main(String[] args) {
        String keyMatrix[][] = {
                                {"B", "A"},
                                {"K", "E"}
                             };
        String plainText[][] = {
                                {"C", "A"},
                                {"K","E"}
                             };

        hillCipher(keyMatrix, plainText);                    
    }
}
