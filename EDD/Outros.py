import asyncio

def fatorial(n):
    if n<=1:
        return n
    else:
        return fatorial(n-1)*n

fact = lambda n: fact(n-1)*n if n > 1 else n

async def fibonacci(n):
    if n<= 1:
        return n
    else:
        x = await fibonacci(n-1)+await fibonacci(n-2)
        print(len(asyncio.all_tasks(asyncio.get_running_loop())))
        return x

def produto(m,n):
    if n == 0:
        return n
    else:
        return m+produto(m,n-1 if n >= 0 else n+1)

loop = asyncio.get_event_loop()
loop.run_until_complete(fibonacci(50))