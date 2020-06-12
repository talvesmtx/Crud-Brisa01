import java.util.Scanner;

public class AulaVetores {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int[] vetor = new int[4];
		
		for(int i = 0; i < vetor.length; i++) {
			System.out.println("Digite o "+(i+1)+" valor");
			vetor[i] = entrada.nextInt();
	    }
		
		System.out.println("O valores armazenados no vetor são \n");
		for(int i = 0; i < vetor.length; i++)
		{
			System.out.println(vetor[i]);
		}
		
		System.out.println("O valor armazenado ona posição 02 do vetor é: "+vetor[2]);
	}	

}
