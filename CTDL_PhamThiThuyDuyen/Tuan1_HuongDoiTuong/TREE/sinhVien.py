class SinhVien:
    def __init__(self, ma_sv, ten_sv, lop, diem_tb):
        self.ma_sv = ma_sv
        self.ten_sv = ten_sv
        self.lop = lop
        self.diem_tb = diem_tb

    def __str__(self):
        return f"Mã SV: {self.ma_sv}, Tên: {self.ten_sv}, Lớp: {self.lop}, Điểm TB: {self.diem_tb}"

class Node:
    def __init__(self, sinh_vien):
        self.sinh_vien = sinh_vien
        self.left = None
        self.right = None

class BinaryTreeSinhVien:
    def __init__(self):
        self.root = None

    def insert(self, sinh_vien):
        if self.root is None:
            self.root = Node(sinh_vien)
        else:
            self._insert_recursive(self.root, sinh_vien)

    def _insert_recursive(self, node, sinh_vien):
        if sinh_vien.ma_sv < node.sinh_vien.ma_sv:
            if node.left is None:
                node.left = Node(sinh_vien)
            else:
                self._insert_recursive(node.left, sinh_vien)
        else:
            if node.right is None:
                node.right = Node(sinh_vien)
            else:
                self._insert_recursive(node.right, sinh_vien)

    def search(self, ma_sv):
        return self._search_recursive(self.root, ma_sv)

    def _search_recursive(self, node, ma_sv):
        if node is None or node.sinh_vien.ma_sv == ma_sv:
            return node
        if ma_sv < node.sinh_vien.ma_sv:
            return self._search_recursive(node.left, ma_sv)
        return self._search_recursive(node.right, ma_sv)

    def delete(self, ma_sv):
        self.root = self._delete_recursive(self.root, ma_sv)

    def _delete_recursive(self, node, ma_sv):
        if node is None:
            return node

        if ma_sv < node.sinh_vien.ma_sv:
            node.left = self._delete_recursive(node.left, ma_sv)
        elif ma_sv > node.sinh_vien.ma_sv:
            node.right = self._delete_recursive(node.right, ma_sv)
        else:
            if node.left is None and node.right is None:
                node = None
            elif node.left is None:
                node = node.right
            elif node.right is None:
                node = node.left
            else:
                min_node = self._min_value_node(node.right)
                node.sinh_vien = min_node.sinh_vien
                node.right = self._delete_recursive(node.right, min_node.sinh_vien.ma_sv)

        return node

    def _min_value_node(self, node):
        current = node
        while current.left is not None:
            current = current.left
        return current

    def pre_order(self):
        self._pre_order_recursive(self.root)

    def _pre_order_recursive(self, node):
        if node:
            print(node.sinh_vien)
            self._pre_order_recursive(node.left)
            self._pre_order_recursive(node.right)

    def in_order(self):
        self._in_order_recursive(self.root)

    def _in_order_recursive(self, node):
        if node:
            self._in_order_recursive(node.left)
            print(node.sinh_vien)
            self._in_order_recursive(node.right)

    def post_order(self):
        self._post_order_recursive(self.root)

    def _post_order_recursive(self, node):
        if node:
            self._post_order_recursive(node.left)
            self._post_order_recursive(node.right)
            print(node.sinh_vien)

if __name__ == "__main__":
    tree = BinaryTreeSinhVien()

    sv1 = SinhVien("SV001", "Nguyen Van A", "Lop1", 8.5)
    sv2 = SinhVien("SV003", "Tran Thi B", "Lop2", 7.8)
    sv3 = SinhVien("SV002", "Le Duc C", "Lop1", 9.0)
    sv4 = SinhVien("SV004", "Pham Thu D", "Lop3", 6.5)

    tree.insert(sv1)
    tree.insert(sv2)
    tree.insert(sv3)
    tree.insert(sv4)

    print("Duyệt cây theo tiền thứ tự (Pre-order):")
    tree.pre_order()
    print()

    print("Duyệt cây theo trung thứ tự (In-order):")
    tree.in_order()
    print()

    print("Duyệt cây theo hậu thứ tự (Post-order):")
    tree.post_order()
    print()

    search_msv = "SV002"
    found_node = tree.search(search_msv)
    if found_node:
        print(f"Tìm thấy sinh viên có mã {search_msv}: {found_node.sinh_vien}")
    else:
        print(f"Không tìm thấy sinh viên có mã {search_msv}")

    print("\nXóa sinh viên có mã SV002:")
    tree.delete("SV002")
    tree.in_order()
    print()

    found_node = tree.search("SV002")
    if found_node:
        print(f"Tìm thấy sinh viên có mã SV002: {found_node.sinh_vien}")
    else:
        print(f"Không tìm thấy sinh viên có mã SV002")