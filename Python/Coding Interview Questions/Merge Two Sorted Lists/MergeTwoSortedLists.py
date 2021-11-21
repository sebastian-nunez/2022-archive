l1 = [4, 7, 8, 12, 34]
l2 = [2, 3, 5, 9, 18, 22, 24]


def merge(l1, l2):
    output = []
    n1 = len(l1)
    n2 = len(l2)

    i, j = 0, 0
    while i < n1 and j < n2:
        if l1[i] < l2[j]:
            output.append(l1[i])
            i += 1
        else:
            output.append(l2[j])
            j += 1

    while i < n1:
        output.append(l1[i])
        i += 1

    while j < n2:
        output.append(l2[j])
        j += 1

    return output


print(merge(l1, l2))
