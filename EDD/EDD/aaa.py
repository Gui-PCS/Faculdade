def bubbleSort(lis:list):
    for i in range(1, len(lis)):
        for j in range(i, 0, -1):
            if lis[j] < lis[j-1]:
                lis[j], lis[j-1] = lis[j-1], lis[j]
            else:
                break
    return lis

def insertsort(lis): 
    for i in range(1, len(lis)):
        key = lis[i]
        j = i-1
        while j >=0 and key < lis[j]:
            lis[j+1] = lis[j]
            j -= 1
        lis[j+1] = key
    return lis

print(insertsort([7,2,1,9,21,-40,10]))