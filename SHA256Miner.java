import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Miner {
    public static void main(String[] args) {
        try {
            String nome = "Kevin"; // Seu nome aqui
            long numero = 0;
            while (true) {
                // Criando a string para hash
                String textoParaHash = nome + numero;

                // Calculando o hash SHA-256
                String hash = calcularSHA256(textoParaHash);

                // Convertendo o hash hexadecimal para binário
                String hashBinario = hexParaBinario(hash);

                // Verificando se o hash começa com pelo menos 30 zeros
                if (hashBinario.startsWith("000000000000000000000000000000")) {
                    System.out.println("Número encontrado: " + numero);
                    System.out.println("SHA256 em hexa: " + hash);
                    System.out.println("SHA256 em binário: " + hashBinario);
                    break;
                }

                numero++;
            }
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Erro ao calcular o hash SHA-256: " + e.getMessage());
        }
    }

    private static String calcularSHA256(String texto) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(texto.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1)
                hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private static String hexParaBinario(String hexString) {
        StringBuilder binario = new StringBuilder();
        hexString = hexString.toUpperCase();
        for (int i = 0; i < hexString.length(); i++) {
            char hexChar = hexString.charAt(i);
            switch (hexChar) {
                case '0':
                    binario.append("0000");
                    break;
                case '1':
                    binario.append("0001");
                    break;
                case '2':
                    binario.append("0010");
                    break;
                case '3':
                    binario.append("0011");
                    break;
                case '4':
                    binario.append("0100");
                    break;
                case '5':
                    binario.append("0101");
                    break;
                case '6':
                    binario.append("0110");
                    break;
                case '7':
                    binario.append("0111");
                    break;
                case '8':
                    binario.append("1000");
                    break;
                case '9':
                    binario.append("1001");
                    break;
                case 'A':
                    binario.append("1010");
                    break;
                case 'B':
                    binario.append("1011");
                    break;
                case 'C':
                    binario.append("1100");
                    break;
                case 'D':
                    binario.append("1101");
                    break;
                case 'E':
                    binario.append("1110");
                    break;
                case 'F':
                    binario.append("1111");
                    break;
            }
        }
        return binario.toString();
    }
}
