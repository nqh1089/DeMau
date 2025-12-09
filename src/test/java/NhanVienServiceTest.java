import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NhanVienServiceTest {

    private NhanVienService nvService;

    // Chạy trước mỗi test để khởi tạo lại Service
    @BeforeEach
    void setUp() {
        nvService = new NhanVienService();
    }

    // --- 1. Các Test Case Hợp Lệ (Success Cases) ---

    // 1.1. Biên dưới hợp lệ (L = 1.0)
    @Test
    void testThemNhanVien_LuongBienDuoiHopLe() {
        NhanVien nv = new NhanVien("NV001", "A", 30, 1.0, "IT");
        assertTrue(nvService.themNhanVien(nv));
    }

    // 1.2. Biên trên hợp lệ (L = 100.000.000)
    @Test
    void testThemNhanVien_LuongBienTrenHopLe() {
        NhanVien nv = new NhanVien("NV002", "B", 35, 100000000.0, "HR");
        assertTrue(nvService.themNhanVien(nv));
    }

    // 1.3. Giá trị đại diện hợp lệ (L = 50.000.000)
    @Test
    void testThemNhanVien_LuongGiaTriDaiDienHopLe() {
        NhanVien nv = new NhanVien("NV003", "C", 25, 50000000.0, "Finance");
        assertTrue(nvService.themNhanVien(nv));
    }

    // --- 2. Các Test Case Không Hợp Lệ (Failure Cases) - Kỹ Thuật Biên ---

    // 2.1. Biên dưới không hợp lệ (L = 0) - Trên biên
    @Test
    void testThemNhanVien_LuongBienDuoiKhongHopLe_Bang0() {
        NhanVien nv = new NhanVien("NV004", "D", 40, 0.0, "IT");

        // Kiểm tra xem phương thức có ném ra Exception (IllegalArgumentException) hay không
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            nvService.themNhanVien(nv);
        }, "Lương 0.0 phải ném ra IllegalArgumentException.");

        assertEquals(0, nvService.getDanhSachNhanVien().size(), "Không được thêm nhân viên có lương 0.");
    }

    // 2.2. Biên dưới không hợp lệ (L = -1) - Ngoài biên (Số âm)
    @Test
    void testThemNhanVien_LuongBienDuoiKhongHopLe_Am() {
        NhanVien nv = new NhanVien("NV005", "E", 28, -1.0, "HR");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            nvService.themNhanVien(nv);
        }, "Lương -1.0 (số âm) phải ném ra IllegalArgumentException.");

        assertEquals(0, nvService.getDanhSachNhanVien().size(), "Không được thêm nhân viên có lương âm.");
    }

    // 2.3. Biên trên không hợp lệ (L = 100.000.001) - Ngoài biên
    @Test
    void testThemNhanVien_LuongBienTrenKhongHopLe() {
        NhanVien nv = new NhanVien("NV006", "F", 45, 100000001.0, "CEO");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            nvService.themNhanVien(nv);
        }, "Lương 100,000,001 phải ném ra IllegalArgumentException.");

        assertEquals(0, nvService.getDanhSachNhanVien().size(), "Không được thêm nhân viên có lương > 100 triệu.");
    }
}