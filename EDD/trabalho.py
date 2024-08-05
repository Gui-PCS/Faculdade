#Trabalho de Estrutura de Dados
#Professores: Mario e Karmen
#Alunos: Rian Felipe Celestrino - G36GAD9
#        João Pedro Silva - N7175E5

from typing import Union

class Node:

    def __init__(self, data) -> None:
        self.data = data
        self.next = None
        self.previos = None
    
    def print(self):
        a = self.next
        res = f"{self.data} <-> "
        while a.data!=self.data:
            res += f"{a.data} <-> "
            a = a.next
        return res
    
    def __repr__(self) -> str:
        return f"{self.data}"

class CircularList:
    def __init__(self) -> None:
        self.head = None
        self.qnt = 0
    
    def __repr__(self):
        return self.head.print()

    def inserirPrmeiro(self, data:Union[float, int, str]):
        if self.head is None:
            self.head = Node(data)
            self.head.next = self.head
            self.head.previos = self.head
        else:
            nova = Node(data)
            nova.previos = self.head.previos
            self.head.previos.next = nova
            nova.next = self.head
            self.head.previos=nova
            self.head=nova
        self.qnt += 1
    
    def inserirUltima(self, data:Union[float, int, str]):
        if self.head is None:
            self.head = Node(data)
            self.head.next = self.head
            self.head.previos = self.head
        else:
            nova = Node(data)
            nova.next = self.head
            nova.previos = self.head.previos
            self.head.previos.next = nova
            self.head.previos = nova
        self.qnt += 1
    
    def inserirDeterminada(self, data:Union[float, int, str], pos:int):
        if self.head is None:
            self.head = Node(data)
            self.head.next = self.head
            self.head.previos = self.head
        else:
            nova = Node(data)
            a = self.head
            for i in range(pos):
                a = a.next
            nova.next = a
            nova.previos = a.previos
            a.previos.next = nova
            a.previos = nova
        self.qnt += 1
    
    def buscarDeterminada(self, pos:int):
        if self.head is None:
            return None
        else:
            a = self.head
            for i in range(pos):
                a = a.next
            return a.data
    
    def buscarData(self, data:Union[float, int, str]) -> Node:
        if self.head is None:
            return None
        else:
            a = self.head
            ini = a.data
            if a.data == data:
                return a
            a = a.next
            while a.data != data:
                if a.data == ini:
                    return None
                a = a.next
            return a
    
    def excluirInicio(self):
        if self.head is None:
            return None
        else:
            self.head.previos.next = self.head.next
            self.head.next.previos = self.head.previos
            self.head = self.head.next
            self.qnt -= 1
    
    def excluirFim(self):
        if self.head is None:
            return None
        else:
            self.head.previos.previos.next = self.head
            self.head.previos = self.head.previos.previos
            self.qnt -= 1
    
    def excluirDeterminada(self, pos:int):
        if self.head is None:
            return None
        else:
            a = self.head
            for i in range(pos):
                a = a.next
            if a == self.head:
                self.head = self.head.next
            a.previos.next = a.next
            a.next.previos = a.previos
            self.qnt -= 1
    
    def excuirData(self, data:Union[float, int, str]):
        if self.head is None:
            return None
        else:
            a = self.head
            ini = a.data
            if a.data == data:
                self.head.previos.next = self.head.next
                self.head.next.previos = self.head.previos
                self.head = self.head.next
                return
            a = a.next
            while a.data != data:
                if a.data == ini:
                    return None
                a = a.next
            a.previos.next = a.next
            a.next.previos = a.previos
            self.qnt -= 1

ci = CircularList()

for i in range(10):
    ci.inserirUltima(i)

print(ci)
ci.inserirUltima(10)
print(ci)
ci.inserirPrmeiro(-1)
print(ci)
ci.inserirDeterminada(11, 5)
print(ci)
print(ci.buscarDeterminada(8))
print(ci.buscarData(10).next)
ci.excluirInicio()
print(ci)
ci.excluirFim()
print(ci)
ci.excluirDeterminada(11)
print(ci)
ci.excuirData(11)
print(ci)