import java.util.ArrayList;
import java.util.List;

public class NhanVienService {
    // List để lưu trữ nhân viên, mô phỏng database
    private List<NhanVien> danhSachNhanVien;

    public NhanVienService() {
        this.danhSachNhanVien = new ArrayList<>();
    }

    /**
     * Thêm 1 đối tượng nhân viên vào danh sách.
     * * @param nv Đối tượng NhanVien cần thêm.
     * @return true nếu thêm thành công, false nếu thêm thất bại (ví dụ: lương không hợp lệ).
     * @throws IllegalArgumentException nếu lương không hợp lệ.
     */
    public boolean themNhanVien(NhanVien nv) {
        if (nv == null) {
            throw new IllegalArgumentException("Đối tượng nhân viên không được null.");
        }

        double luong = nv.getLuong();

        // Kiểm tra điều kiện Lương > 0 và <= 100,000,000
        if (luong <= 0 || luong > 100000000) {
            throw new IllegalArgumentException("Lương phải lớn hơn 0 và nhỏ hơn hoặc bằng 100,000,000.");
        }

        // Thêm nhân viên vào danh sách (giả lập lưu vào database)
        return danhSachNhanVien.add(nv);
    }

    // Hàm hỗ trợ cho Unit Test (kiểm tra số lượng nhân viên đã được thêm)
    public List<NhanVien> getDanhSachNhanVien() {
        return danhSachNhanVien;
    }
}