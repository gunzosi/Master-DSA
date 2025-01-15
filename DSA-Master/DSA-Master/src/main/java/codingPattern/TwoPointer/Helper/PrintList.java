package codingPattern.TwoPointer.Helper;

public class PrintList {
    // Phương thức in danh sách liên kết với mũi tên "->"
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            temp = temp.next;
            if (temp != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    // Chuyển mảng int thành chuỗi
    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder(); // Sử dụng StringBuilder để hiệu quả hơn
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]); // Thêm phần tử vào StringBuilder
            if (i < arr.length - 1) {
                sb.append(", "); // Thêm dấu phẩy nếu không phải phần tử cuối
            }
        }
        return sb.toString(); // Trả về chuỗi hoàn chỉnh
    }

    // Lặp lại chuỗi `s` `i` lần và trả về kết quả dưới dạng chuỗi
    public static String repeat(String s, int i) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append(s);
            if (j < i - 1) {
                sb.append(" "); // Thêm khoảng trắng giữa các chuỗi
            }
        }
        return sb.toString(); // Trả về chuỗi lặp
    }
}
