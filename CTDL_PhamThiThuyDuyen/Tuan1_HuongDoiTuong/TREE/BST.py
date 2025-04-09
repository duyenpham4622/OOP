
class Node:
    def __init__(self, key):
        self.left = None
        self.right = None
        self.value = key


class BST:
    def __init__(self):
        self.root = None

    # Hàm thêm phần tử vào cây
    def insert(self, key):
        if self.root is None:
            self.root = Node(key)
        else:
            self._insert_recursive(self.root, key)

    def _insert_recursive(self, node, key):
        if key < node.value:
            if node.left is None:
                node.left = Node(key)
            else:
                self._insert_recursive(node.left, key)
        else:
            if node.right is None:
                node.right = Node(key)
            else:
                self._insert_recursive(node.right, key)
    # Hàm tìm kiếm phần tử trong cây
    def search(self, key):
        return self._search_recursive(self.root, key)

    def _search_recursive(self, node, key):
        if node is None or node.value == key:
            return node
        if key < node.value:
            return self._search_recursive(node.left, key)
        return self._search_recursive(node.right, key)

    # Hàm duyệt cây theo thứ tự In-order (LNR)
    def inorder(self):
        return self._inorder_recursive(self.root)

    def _inorder_recursive(self, node):
        result = []
        if node:
            result += self._inorder_recursive(node.left)
            result.append(node.value)
            result += self._inorder_recursive(node.right)
        return result

    # Hàm duyệt cây theo thứ tự Pre-order (NLR)
    def preorder(self):
        return self._preorder_recursive(self.root)

    def _preorder_recursive(self, node):
        result = []
        if node:
            result.append(node.value)
            result += self._preorder_recursive(node.left)
            result += self._preorder_recursive(node.right)
        return result

    # Hàm duyệt cây theo thứ tự Post-order (LRN)
    def postorder(self):
        return self._postorder_recursive(self.root)

    def _postorder_recursive(self, node):
        result = []
        if node:
            result += self._postorder_recursive(node.left)
            result += self._postorder_recursive(node.right)
            result.append(node.value)
        return result

    # Hàm xóa phần tử khỏi cây
    def delete(self, key):
        self.root = self._delete_recursive(self.root, key)

    def _delete_recursive(self, node, key):
        if node is None:
            return node
        
        if key < node.value:
             node.left = self._delete_recursive(node.left, key)
        elif key > node.value:
            node.right = self._delete_recursive(node.right, key)
        else:
            # Node cần xóa tìm thấy
            if node.left is None:
                return node.right
            elif node.right is None:
                return node.left
            else:
                # Node có hai con
                min_larger_node = self._find_min(node.right)
                node.value = min_larger_node.value
                node.right = self._delete_recursive(node.right, min_larger_node.value)
        
        return node

    # Tìm node có giá trị nhỏ nhất trong cây con bên phải
    def _find_min(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current


# Hàm thử nghiệm
if __name__ == "__main__":
    bst = BST()

    # Thêm các phần tử vào cây
    bst.insert(50)
    bst.insert(30)
    bst.insert(20)
    bst.insert(40)
    bst.insert(70)
    bst.insert(60)
    bst.insert(80)

    print("Duyệt cây theo In-order:", bst.inorder())  # [20, 30, 40, 50, 60, 70, 80]
    print("Duyệt cây theo Pre-order:", bst.preorder())  # [50, 30, 20, 40, 70, 60, 80]
    print("Duyệt cây theo Post-order:", bst.postorder())  # [20, 40, 30, 60, 80, 70, 50]

    # Tìm kiếm một phần tử
    key = 60
    result = bst.search(key)
    if result:
        print(f"Tìm thấy {key} trong cây.")
    else:
        print(f"{key} không có trong cây.")

    # Xóa một phần tử khỏi cây
    bst.delete(20)
    print("Duyệt cây sau khi xóa 20 theo In-order:", bst.inorder())  # [30, 40, 50, 60, 70, 80]