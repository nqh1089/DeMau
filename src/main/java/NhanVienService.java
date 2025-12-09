import java.util.ArrayList;
import java.util.List;

public class NhanVienService {

    private final List<NhanVien> danhSachNhanVien = new ArrayList<>();

    public boolean ThemNhanVien(NhanVien nv) {
        // --- 1. Validate Trường Trống (1 Điểm) ---
        if (nv.getMaNV() == null || nv.getMaNV().trim().isEmpty() ||
                nv.getTenNV() == null || nv.getTenNV().trim().isEmpty() ||
                nv.getLuong() < 0) { // Giả định: luong < 0 cũng là trống/không hợp lệ
            throw new IllegalArgumentException("Tat ca cac truong du lieu khong duoc de trong/am.");
        }

        // --- 2. Validate Lương (0 < luong <= 100) (2 Điểm) ---
        double luong = nv.getLuong();
        if (luong <= 0) {
            throw new IllegalArgumentException("Luong phai lon hon 0.");
        }
        if (luong > 100.0) { // Giả định đơn vị là triệu
            throw new IllegalArgumentException("Luong khong duoc vuot qua 100 trieu.");
        }

        // Thêm nhân viên vào danh sách (giả lập thành công)
        danhSachNhanVien.add(nv);
        return true;
    }

    // Hàm hỗ trợ cho Test
    public int LaySoLuongNhanVien() {
        return danhSachNhanVien.size();
    }
}