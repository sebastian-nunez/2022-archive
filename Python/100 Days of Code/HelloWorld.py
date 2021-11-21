# import java.util.Scanner;

# public class CodeBreaker {

# 	public static void main(String[] args) {

# 		String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
# 		String decoded = "";

# 		System.out.println("Enter Coded Message:");
# 		System.out.println("(input a non-number to finish)");

# 		Scanner scan = new Scanner(System.in);
# 		while (scan.hasNextInt()) {

# 			int number = scan.nextInt();
# 			char numChar;

# 			if (number > 0 && number <= 26) {
# 				numChar = (char)(number + 96);
# 				decoded += Character.toString(numChar);
# 			}

# 			if (number >= -26 && number < 0) {
# 				numChar = (char)(Math.abs(number) + 64);
# 				decoded += Character.toString(numChar);
# 			}

# 		}

# 		System.out.println("Decoded Message:");
# 		System.out.println(decoded);

# 	}

# }

decoded = ''

print('Enter coded message (Input a non-number to finish)')

while True:
    try:
        num = int(input())

    except:
        break

    print(ord('A'))
    if num > 0 and num <= 26:
        decoded += chr(num + 96)

    if num >= -26 and num < 0:
        decoded += chr(abs(num) + 64)


print(f'Decoded Message: {decoded}')
