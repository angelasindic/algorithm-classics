# python3
import sys, threading
sys.setrecursionlimit(10**7) # max depth of recursion
threading.stack_size(2**27)  # new thread will get stack of such size
from collections import deque


class Node:
    def __init__(self, key):
        self.key = key
        self.children = []


class TreeHeight:
    def read(self):
        self.n = int(sys.stdin.readline())
        self.parent = list(map(int, sys.stdin.readline().split()))
        self.nodes = [Node(i) for i in range(self.n)]
        self.root_idx = -1

        for i in range(self.n):
            if self.parent[i] == -1:
                self.root_idx = i
            else:
                parent_idx = self.parent[i]
                self.nodes[parent_idx].children.append(self.nodes[i])

    def compute_height(self):
        root = self.nodes[self.root_idx]
        work = deque([(root, 1)])
        height = 1

        while len(work) > 0:
            (n,h) = work.popleft()
            height = h
            for c in n.children:
                work.append((c, h+1))
        return height


def main():
    tree = TreeHeight()
    tree.read()
    print(tree.compute_height())


threading.Thread(target=main).start()
