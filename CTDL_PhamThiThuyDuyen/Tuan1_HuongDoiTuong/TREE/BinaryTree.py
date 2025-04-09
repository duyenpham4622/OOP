class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

class BinaryTree:
    def __init__(self):
        self.root = None

    # Thêm một nút vào cây nhị phân
    def insert(self, value):
        if self.root is None:
            self.root = Node(value)
        else:
            self._insert_recursive(self.root, value)

    def _insert_recursive(self, node, value):
        if value < node.value:
            if node.left is None:
                node.left = Node(value)
            else:
                self._insert_recursive(node.left, value)
        else:
            if node.right is None:
                node.right = Node(value)
            else:
                self._insert_recursive(node.right, value)

    # Tìm kiếm giá trị trong cây
    def search(self, value):
        return self._search_recursive(self.root, value)

    def _search_recursive(self, node, value):
        if node is None or node.value == value:
            return node
        if value < node.value:
            return self._search_recursive(node.left, value)
        return self._search_recursive(node.right, value)
    # Xóa một nút khỏi cây
    def delete(self, value):
        self.root = self._delete_recursive(self.root, value)

    def _delete_recursive(self, node, value):
        if node is None:
            return node

        # Tìm kiếm nút cần xóa
        if value < node.value:
            node.left = self._delete_recursive(node.left, value)
        elif value > node.value:
            node.right = self._delete_recursive(node.right, value)
        else:
            # Nút cần xóa đã được tìm thấy

            # Trường hợp 1: Nút không có con
            if node.left is None and node.right is None:
                node = None

            # Trường hợp 2: Nút có một con
            elif node.left is None:
                node = node.right
            elif node.right is None:
                node = node.left

            # Trường hợp 3: Nút có hai con
            else:
                # Tìm giá trị nhỏ nhất ở cây con phải
                min_node = self._min_value_node(node.right)
                node.value = min_node.value
                node.right = self._delete_recursive(node.right, min_node.value)

        return node

    def _min_value_node(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

    # Duyệt cây theo tiền thứ tự (Pre-order)
    def pre_order(self):
        self._pre_order_recursive(self.root)

    def _pre_order_recursive(self, node):
        if node:
            print(node.value, end=" ")
            self._pre_order_recursive(node.left)
            self._pre_order_recursive(node.right)

    # Duyệt cây theo trung thứ tự (In-order)
    def in_order(self):
        self._in_order_recursive(self.root)
    def _in_order_recursive(self, node):
        if node:
            self._in_order_recursive(node.left)
            print(node.value, end=" ")
            self._in_order_recursive(node.right)

    # Duyệt cây theo hậu thứ tự (Post-order)
    def post_order(self):
        self._post_order_recursive(self.root)

    def _post_order_recursive(self, node):
        if node:
            self._post_order_recursive(node.left)
            self._post_order_recursive(node.right)
            print(node.value, end=" ")

# Hàm chính để thử nghiệm các chức năng
if __name__ == "__main__":
    tree = BinaryTree()

    # Thêm các giá trị vào cây
    values = [20, 8, 22, 4, 12, 10, 14]
    for value in values:
        tree.insert(value)

    # Duyệt cây theo ba cách
    print("Duyệt cây theo tiền thứ tự (Pre-order):")
    tree.pre_order()
    print()

    print("Duyệt cây theo trung thứ tự (In-order):")
    tree.in_order()
    print()

    print("Duyệt cây theo hậu thứ tự (Post-order):")
    tree.post_order()
    print()

    # Tìm kiếm trong cây
    search_value = 10
    found_node = tree.search(search_value)
    if found_node:
        print(f"Tìm thấy giá trị {search_value} trong cây.")
    else:
        print(f"Không tìm thấy giá trị {search_value} trong cây.")

    # Xóa nút có giá trị 10
    print(f"\nXóa nút có giá trị 10:")
    tree.delete(10)
    tree.in_order()  # Duyệt lại cây sau khi xóa
    print()

    # Tìm kiếm lại giá trị 10
    found_node = tree.search(10)
    if found_node:
        print(f"Tìm thấy giá trị 10 trong cây.")
    else:
        print(f"Không tìm thấy giá trị 10 trong cây.")