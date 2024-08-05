class Node:
    def __init__(self, data) -> None:
        self.data = data
        self.right = None
        self.left = None
    
def InsertElement(root, data):
    if root == None:
        return Node(data)
    else:
        if root.data == data:
            return root
        elif root.data < data:
            root.right = InsertElement(root.right, data)
        elif root.data > data:
            root.left = InsertElement(root.left, data)
    return root

def inorder(root):
    if root:
        inorder(root.left)
        print(root.data, end=", ")
        inorder(root.right)

a = Node(20)

for i in [20,5,2,8,30,25,40,35]:
    InsertElement(a, i)
    inorder(a)
    print()