#
# Complete the 'caesarCipher' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER k
#

def caesarCipher(s, k):
    output = ''

    k %= 26
    for letter in s:
        if not letter.isalpha():
            output += letter
            continue

        val = ord(letter)
        if letter.isupper():
            if val + k > ord('Z'):
                val -= 26
        else:
            if val + k > ord('z'):
                val -= 26

        output += chr(val + k)

    return output
