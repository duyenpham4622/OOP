class ArrayQueue:
    DEFAULT_CAPACITY = 5
    def __init__(self):
        self._data = [None] * ArrayQueue.DEFAULT_CAPACITY
        self._size = 0
        self._front = 0
        
    def __len__(self):
        return self._size
    
    def is_empty(self):
        return self._size == 0
    
    def first(self):
        if self.is_empty():
            print("Hang doi rong")
        return self._data[self._front]
    
    def dequeue(self):
        if self.is_empty():
            print("Hang doi rong")
        answer = self._data[self._front]
        self._data[self._front] = None
        self._front = (self._front + 1) % len(self._data)
        self._size -= 1
        return answer
    '''
    def dequeue(self):
        if self.is_empty():
            raise Empty('Hang doi rong')
        answer = self._data[self._front]
        self._data[self._front] = None
        self._front = (self._front + 1) % len(self._data)
        self._size -= 1
        if 0 < self._size < len(self._data) // 4:
            self._resize(len(self._data) // 2)
        return answer
    '''
    def enqueue(self, e):
        if self._size == len(self._data):
            self._resize(2 * len(self._data))
        avail = (self._front + self._size) % len(self._data)
        self._data[avail] = e
        self._size += 1
        
    def _resize(self, cap):
        old = self._data
        self._data = [None] * cap
        walk = self._front
        for k in range(self._size):
            self._data[k] = old[walk]
            walk = (1 + walk) % len(old)
        self._front = 0
        
    def __str__(self):
        return '<' + ''.join(str(self._data)) + '<'
    
if __name__ == '__main__':
    Q = ArrayQueue()
    Q.enqueue(5)
    Q.enqueue(7)
    Q.enqueue(9)
    Q.enqueue(2)
    Q.enqueue(6)
    Q.enqueue(4)
    Q.enqueue(1)
    Q.enqueue(0)
    print('============Demo==========')
    print('Q: ',Q)
    print('Do dai hang doi: ', len(Q))
    print('Remove last item: ',Q.dequeue())
    print('Remove last item: ',Q.dequeue())
    print('Q: ',Q)
    print('Do dai hang doi: ', len(Q))
    
    
    