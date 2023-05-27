def merge(l1, l2):
    global swap
    lst = []
    i = j = 0

    while i < len(l1) and j < len(l2):
        if l1[i] <= l2[j]:
            lst.append(l1[i])
            i += 1
        elif l1[i] > l2[j]:
            lst.append(l2[j])
            j += 1
            swap += len(l1) - i

    while i < len(l1):
        lst.append(l1[i])
        i += 1
    while j < len(l2):
        lst.append(l2[j])
        j += 1

    return lst

def merge_sort(lst):
    if len(lst) <= 1:
        return lst

    mid = len(lst) // 2

    left = merge_sort(lst[:mid])
    right = merge_sort(lst[mid:])

    return merge(left, right)

N = int(input())
lst = list(map(int, input().split()))
swap = 0

merge_sort(lst)
print(swap)