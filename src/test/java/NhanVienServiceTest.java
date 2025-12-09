import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NhanVienServiceTest {

    private NhanVienService nvService;

    @BeforeEach
    void CaiDat() {
        nvService = new NhanVienService();
    }

    // --- Test 1: Validate Lương Hợp Lệ (Biên & Tương đương) (2 Điểm) ---
    @Test
    void Test_ThemNV_LuongHopLe_BienMin() {
        // Lương = 0.01 (min hợp lệ)
        NhanVien nv = new NhanVien("NV001", "A", 25, 0.01, "Sale");
        assertTrue(nvService.ThemNhanVien(nv));
        assertEquals(1, nvService.LaySoLuongNhanVien());
    }

    @Test
    void Test_ThemNV_LuongHopLe_BienMax() {
        // Lương = 100.0 (max hợp lệ)
        NhanVien nv = new NhanVien("NV002", "B", 30, 100.0, "IT");
        assertTrue(nvService.ThemNhanVien(nv));
    }

    // --- Test 2: Validate Lương Ngoại Lệ (Biên & Tương đương) (2 Điểm) ---
    @Test
    void Test_ThemNV_LuongNgoaiLe_BienLonHonMax() {
        // Lương = 100.01 (vượt quá 100)
        NhanVien nv = new NhanVien("NV003", "C", 22, 100.01, "HR");
        // Kiểm tra ngoại lệ IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            nvService.ThemNhanVien(nv);
        });
    }

    @Test
    void Test_ThemNV_LuongNgoaiLe_BienBang0() {
        // Lương = 0 (bằng 0, không hợp lệ)
        NhanVien nv = new NhanVien("NV004", "D", 40, 0.0, "Finance");
        assertThrows(IllegalArgumentException.class, () -> {
            nvService.ThemNhanVien(nv);
        });
    }

    // --- Test 3: Validate Trường Không Để Trống (1 Điểm) ---
    @Test
    void Test_ThemNV_NgoaiLe_TenNVBiTrong() {
        // Tên nhân viên là chuỗi rỗng
        NhanVien nv = new NhanVien("NV005", "", 35, 50.0, "Marketing");
        assertThrows(IllegalArgumentException.class, () -> {
            nvService.ThemNhanVien(nv);
        });
    }
}